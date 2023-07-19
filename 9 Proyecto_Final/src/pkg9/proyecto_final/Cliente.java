package pkg9.proyecto_final;



//socket es un puente para enviar y recibir informacion

import java.io.DataOutputStream;
import java.net.Socket;


//el cliente pide la peticion y el servidor es quien la recibe
public class Cliente extends javax.swing.JFrame {

    public Cliente() {
        initComponents();
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_mensaje = new javax.swing.JTextField();
        btn_boton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Chat");

        txt_mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mensajeActionPerformed(evt);
            }
        });

        btn_boton.setText("Enviar");
        btn_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_botonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(txt_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btn_boton)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mensajeActionPerformed
        
   

        
    }//GEN-LAST:event_txt_mensajeActionPerformed

    private void btn_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_botonActionPerformed
       
        //Boton enviar 
        
          try {
            
            Socket socket = new Socket("localhost", 9999);
            //el host apunta a un computador conectado a una red en este caso, solo trasfiero datos de mi PC
            //los datos los vamos a enviar y el servidor lo resivira con un FileInpatString 
           //mi puerto sera el 999 para iniciar el inicio de datos
           
           DataOutputStream enviar_datos = new DataOutputStream(socket.getOutputStream());
           //con esta clase enviamos los datos y obtengo lo que tiene el socket
           
           
           enviar_datos.writeUTF(txt_mensaje.getText());
           //UTF es para escribir caracteres
           
           socket.close();
           
           //Lo que hicimos fue crear un puente al que enviamos algo a mi pc y le pasamos el puerto para empezar
           //Tambien establecimos lo que enviaremos y se cierra

            
            txt_mensaje.setText(""); // Limpiar el campo de texto después de enviar los datos
        } catch (Exception e) {
            System.out.println(e);
        }

  

        

    }//GEN-LAST:event_btn_botonActionPerformed

 
    
    public static void main(String args[]) {
     
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_boton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_mensaje;
    // End of variables declaration//GEN-END:variables
}
