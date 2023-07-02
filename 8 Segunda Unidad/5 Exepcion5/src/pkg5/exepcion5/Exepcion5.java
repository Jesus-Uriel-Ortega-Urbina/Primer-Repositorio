
package pkg5.exepcion5;


public class Exepcion5 {

 
    public static int miMetodo(int a, int b)throws ArithmeticException{
        
        if (b==0) {
            throw new ArithmeticException();
        }
        
        int c = a /b;
        return c;

    }
    
    public static  void main(String[] args) {
        try {
            int division = miMetodo(10, 0);
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println("Exepcion aritmetica arrojada " );
            e.printStackTrace();
        }
    }
    
}

//enviar ejemplos de java corrigiendo los errores de la imagen