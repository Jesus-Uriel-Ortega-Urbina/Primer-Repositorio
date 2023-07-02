
package pkg3.exepciones3;

import javax.swing.JOptionPane;


public class Exepciones3 {


    public static void main(String[] args) {
        
   try {
       float equis = 5/0;
       System.out.println("Equis = " + equis);
       
   } catch (ArithmeticException e) {
        System.out.println("Error al dividir entre 0");
        
   } finally { //siempre se va a ejecutar haya error o no
       
       System.out.println("A pesar de todo se ejecuta Finaly");
      }
        
    }
        
  
 }