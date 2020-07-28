/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarioadecimal;

import binarioadecimal.cup.AnalizadorSintactico;
import java.io.StringReader;
import java.util.Scanner;
import binarioadecimal.jflex.AnalizadorLexico;

/**
 *
 * @author sergio
 */
public class BinarioADecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese un Numero Binario");
            boolean opcionValida=true;
            
                String numero = scanner.nextLine();
                AnalizadorLexico al = new AnalizadorLexico(new StringReader(numero));
                        AnalizadorSintactico as = new AnalizadorSintactico(al);
                try {
                    as.parse();
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(BinarioADecimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                do {
                    opcionValida=true;
                System.out.println("Deseas Ingresar Otro? Y/N");
                String opcion = scanner.nextLine();
                if (opcion.equalsIgnoreCase("y")) {
                    salir=false;
                } else if (opcion.equalsIgnoreCase("n")) {
                    salir=true;
                } else {
                    System.out.println("Opcion Invalida");
                    opcionValida=false;
                }
            } while (!opcionValida);

        } while (!salir);
    }
    
}
