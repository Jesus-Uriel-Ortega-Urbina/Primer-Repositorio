
package pkg1.excepciones;

import javax.swing.JOptionPane;


public class Excepciones1 {


    public static void main(String[] args) {
        
        int x, y;
        
        try {
        
        x= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa numero 1:", "Solicita Datos", 3));

        
    } catch (NumberFormatException n) {
            System.out.println(n.getMessage() + " No le sabes, eso no es un numero");
        }
        
    }
    
}
