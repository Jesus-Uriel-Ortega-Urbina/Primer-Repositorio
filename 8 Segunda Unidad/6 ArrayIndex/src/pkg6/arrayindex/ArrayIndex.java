
package pkg6.arrayindex;


public class ArrayIndex {
    
    public static void main(String[] args) {
        try {
            
            int[] array = {1, 2, 3};
            int element = array[3]; 
            // Genera la excepción ArrayIndexOutOfBoundsException
            
            System.out.println("Elemento obtenido: " + element);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Ocurrio una excepcion: " + e.getMessage());
            
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
            
        }
    }
}

