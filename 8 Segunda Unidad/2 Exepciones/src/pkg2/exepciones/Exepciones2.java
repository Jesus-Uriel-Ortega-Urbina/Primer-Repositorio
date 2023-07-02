
package pkg2.exepciones;

import javax.swing.JOptionPane;


public class Exepciones2 {


    public static void main(String[] args) {
        
        int x, y;
        
        try {
        
        x= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa numero 1:", "Solicita Datos", 3));
        y= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa numero 2:", "Solicita Datos", 3));
        
        JOptionPane.showMessageDialog(null, "La Divicion de "+ x + "/" + y + " es" + (x/y), "Mostrar resultado", 1);

        
    } catch (NumberFormatException n) {
        
            System.out.println(n.getMessage() + " No le sabes, eso no es un numero");
            
        } catch (ArithmeticException a) {
        
            System.out.println(a.getMessage() + " No se puede dividir entre 0");
        
        }
    } 
}

