
package pkg8.classnot;


public class ClassNot {
    
    public static void main(String[] args) {
        
        try {
            
            Class.forName("com.example.NonExistentClass");
            
        } catch (ClassNotFoundException e) {
            
            System.out.println("Ocurrió una excepción: " + e.getMessage());
            
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
        }
    }
}
