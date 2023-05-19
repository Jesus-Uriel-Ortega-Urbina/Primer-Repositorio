
package pkg5.trifiv_v4;

import funciones.funcionMultiplo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TRIFIV_v4 { 

    public static void main(String[] args) throws IOException {
       
        //Declaracion de variables 
        BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
        int numero; 
        
        funcionMultiplo funcion = new funcionMultiplo();
        
        System.out .println("Dame el numero: ");
        numero = Integer.parseInt(bufEntrada.readLine());
        
        System.out.println(funcion.retornaMultiplo(numero));
        
        
    }
    
}

