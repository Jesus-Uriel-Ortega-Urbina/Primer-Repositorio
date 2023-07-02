
package pkg10.ioexeption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IoExeption {
    
    public static void main(String[] args) {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("archivo.txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                
            }
        } catch (IOException e) {
            
            System.out.println("Ocurrió una excepción " + e.getMessage());
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
            
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
