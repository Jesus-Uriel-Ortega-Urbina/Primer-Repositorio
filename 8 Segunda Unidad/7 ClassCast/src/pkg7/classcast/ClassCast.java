

package pkg7.classcast;


public class ClassCast {
    
    public static void main(String[] args) {
        
        try {
            
            Object obj = "Hola mundo";
            
            Integer num = (Integer) obj;
            // Genera la excepción ClassCastException
            
            System.out.println("Numero obtenido: " + num);
            
        } catch (ClassCastException e) {
            
            System.out.println("Ocurrió una excepción: " + e.getMessage());
            
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
        }
    }
}
