package pkg9.proyecto_final;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Servidor extends javax.swing.JFrame implements Runnable {
//La clase Servidor hereda de javax.swing.JFrame para representar una ventana de la interfaz gráfica
//y también implementa la interfaz Runnable para permitir la ejecución en un hilo separado.

    private Connection conn;
    private StringBuilder mensajes;
//Aquí se declaran dos variables de instancia: conn para almacenar la conexión a la base de datos 
//y mensajes para almacenar los mensajes recibidos.

    public Servidor() {
        initComponents();
        Thread hilo = new Thread(this);
        //aqui creamos nuestro hilo y lo inicializamos para empezar varios procesos
        hilo.start();
        conn = null;
        mensajes = new StringBuilder();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:33065/socket", "root", "");
            cargarMensajes(); // Cargar mensajes guardados al iniciar el servidor
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e);
        }
    }

    //El constructor de la clase Servidor inicializa la interfaz gráfica (initComponents()),
    //crea un nuevo hilo (hilo) y lo inicia para ejecutar el método run(). Luego inicializa la variable 
    //conn como null y crea un nuevo objeto StringBuilder para mensajes.
    private void cargarMensajes() {
        try {
            String sql = "SELECT mensaje FROM mensajes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String mensaje = rs.getString("mensaje");
                campo.append("\n" + mensaje);
                mensajes.append("\n" + mensaje);

            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los mensajes: " + e);
        }
    }

    //Este método se utiliza para cargar los mensajes almacenados en la base de datos al iniciar el servidor.
    //Realiza una consulta SQL para seleccionar todos los mensajes de la tabla mensajes, y luego recorre 
    //el conjunto de resultados (ResultSet) para agregar cada mensaje al área de texto (campo)
    //y al objeto StringBuilder mensajes.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        campo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campo.setColumns(20);
        campo.setRows(5);
        jScrollPane1.setViewportView(campo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea campo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(9999);

            while (true) {
                Socket misocket = servidor.accept();
                DataInputStream recibir_datos = new DataInputStream(misocket.getInputStream());
                String mensaje = recibir_datos.readUTF();

                //Este método se ejecuta en un hilo separado y contiene el código principal del servidor de chat.
                //Primero crea un ServerSocket en el puerto 9999 para escuchar conexiones entrantes.
                //Luego, en un bucle infinito, espera a que se establezca una conexión (accept()) 
                //y crea un DataInputStream para recibir datos desde el socket. El mensaje recibido se
                //almacena en la variable mensaje.
                campo.append("\n" + mensaje);
                mensajes.append("\n" + mensaje);

                // Verificar si el mensaje ya existe en la base de datos
                String sql = "SELECT mensaje FROM mensajes WHERE mensaje=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, mensaje);
                ResultSet rs = stmt.executeQuery();

                //Después de recibir un mensaje, se agrega al área de texto (campo) y al objeto StringBuilder mensajes.
                //Luego se realiza una consulta SQL para verificar si el mensaje ya existe en la base de datos.
                //Si el mensaje no existe, se inserta en la base de datos.
                if (!rs.next()) {
                    // El mensaje no existe, insertarlo en la base de datos
                    sql = "INSERT INTO mensajes (mensaje) VALUES (?)";
                    PreparedStatement insertStmt = conn.prepareStatement(sql);
                    insertStmt.setString(1, mensaje);
                    insertStmt.executeUpdate();
                    insertStmt.close();
                }

                rs.close();
                stmt.close();
                misocket.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    // Método para obtener los mensajes guardados
    public String getMensajes() {
        return mensajes.toString();

    }
    //Este método devuelve los mensajes almacenados en el objeto StringBuilder mensajes como una cadena de texto.

}
