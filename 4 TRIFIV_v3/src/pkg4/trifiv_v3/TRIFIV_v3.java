
package pkg4.trifiv_v3;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

public class TRIFIV_v3 {

    public static void main(String[] args) throws IOException {
       
        //Declaracion de variables 
        BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));  
        //bufferedReder nos manda cuales imprtaciones son requeridas 
        int numero; 
        float mult3;
        float mult5;
        //Entrada de datos
        System.out .println("Dame el numero: ");
        numero = Integer.parseInt(bufEntrada.readLine());
        //Procesar datos
     
        System.out.println(retornaMultiplo(numero));
        
    }
    
    public static String retornaMultiplo (int num)
            
    { 
        if(num %3==0 && num%5 ==0)
        {
            return "TRIFIV";
        }
        if (num%3==0)
        {
            return "TRI";
        }
        if (num%5==0)
        {
            return "FIV";
                
        }
        return  "no es multiplo";
    }
}
