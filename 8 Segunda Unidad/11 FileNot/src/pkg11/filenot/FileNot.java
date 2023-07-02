
package pkg11.filenot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNot {
    
    public static void main(String[] args) {
        
        try {
            
            File file = new File("archivo.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio una excepcion: " + e.getMessage());
            
            // Opcionalmente, puedes imprimir la traza de la excepción:
            // e.printStackTrace();
        }
    }
}
