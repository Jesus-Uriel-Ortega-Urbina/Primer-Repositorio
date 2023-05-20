//modificar el ultimo static
package pkg2.trifiv_v1;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;


public class TRIFIV_v1 {

    public static void main(String[] args) throws IOException {
       
    
        BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));  
        //bufferedReder nos manda cuales imprtaciones son requeridas  owo
        int num; 
        float mult3;
        float mult5;
        

        System.out .println("Dame el numero: ");
        num = Integer.parseInt(bufEntrada.readLine());
        
        
        mult3 = num%3;
        mult5 = num%5;
        
    
  
        
        if(mult3 ==0 && mult5 ==0)
        {
            System.out.println("TRIFIV");
        }
        else if (mult3==0)
        {
            System.out.println("TRI");
        }
        else if (mult5==0)
        {
            System.out.println("FIV");
        }
   
    }
}