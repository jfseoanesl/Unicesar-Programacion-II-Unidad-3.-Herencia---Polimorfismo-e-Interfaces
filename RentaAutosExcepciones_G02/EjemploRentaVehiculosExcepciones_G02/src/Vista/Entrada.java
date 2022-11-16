/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class Entrada {

    private static Scanner entrada = new Scanner(System.in);

    public static int leerInt(String dato) {

        int valor=0;
        boolean tieneExcepcion;
        do {
            System.out.print(dato);
            try {
                valor = entrada.nextInt();
                tieneExcepcion = false;
                
            } catch (java.util.InputMismatchException ioe) {
                System.out.println("Excepcion: Se requiere un valor numerico (int)");
                entrada.nextLine();
                tieneExcepcion = true;
               
            }
        } while (tieneExcepcion);
        
        return valor;
    }

    public static double leerDouble(String dato) {
        System.out.print(dato);
        return entrada.nextDouble();
    }

    public static String leerLinea(String dato) {
        System.out.print(dato);
        entrada = new Scanner(System.in);
        return entrada.nextLine();
    }

    public static String leerString(String dato) {
        System.out.print(dato);
        return entrada.next();
    }

    public static Date leerFecha(String titulo) {
        System.out.println(titulo);
        Calendar cal = Calendar.getInstance();
        int dia = Entrada.leerInt("  Dia[dd]: ");
        cal.set(Calendar.DAY_OF_MONTH, dia);
        int mes = Entrada.leerInt("  Mes[mm]: ");
        cal.set(Calendar.MONTH, mes - 1);
        int año = Entrada.leerInt("  Año[aaaa]: ");
        cal.set(Calendar.YEAR, año);
        return cal.getTime();
    }

}
