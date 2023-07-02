
package pkg9.nullpointer;


public class NullPointer {
    
    public static void main(String[] args) {
        
        try {
            
            String str = null;
            
            int length = str.length();
            // Genera la excepción NullPointerException
            
            System.out.println("Longitud de la cadena: " + length);
            
        } catch (NullPointerException e) {
            
            
            System.out.println("Ocurrió una excepción: " + e.getMessage());
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
        }
    }
}

