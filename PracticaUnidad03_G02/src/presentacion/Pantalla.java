
package presentacion;

import entidades.CuentaBancaria;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class Pantalla {
    public static int imprimirMenu(String titulo, String opciones[]){
        Pantalla.tituloVista(titulo);
        for(int i=0; i<opciones.length; i++){
            System.out.printf("| %-35s |%n", opciones[i]);
        }
        System.out.println("---------------------------------------");
        int opc = Teclado.leerInt("Seleccione una opcion:");
        return opc;
    }
    
   public static void imprimirCuentas(ArrayList<CuentaBancaria> cuentas){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s%n",
                          "No cuenta", 
                          "Nombre cliente", 
                          "Saldo","Fecha Venc", 
                          "% Interes",
                          "% Comision");
        System.out.println("--------------------------------------------------------------------------------------------");
        for(CuentaBancaria c: cuentas){
            System.out.println("| "+c.consultarDatos()+" |");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
                
    }
    
    public static void imprimirCuentas(CuentaBancaria cuentas){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s%n",
                          "No cuenta", 
                          "Nombre cliente", 
                          "Saldo","Fecha Venc", 
                          "% Interes",
                          "% Comision");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("| "+cuentas.consultarDatos()+" |");
        System.out.println("--------------------------------------------------------------------------------------------");
                
    }
    
    public static void tituloVista(String titulo){
        System.out.println("\n---------------------------------------");
        System.out.printf("| %-35s |%n", titulo.toUpperCase());
        System.out.println("---------------------------------------");
    }
    
    public static void msgExito(){
        System.out.println("!! Operacion realizada con exito ¡¡");
    }
    
    public static void msgNoEncontrada(){
        System.out.println("!! La cuenta no se encuentra registrada ¡¡");
    }
    
    public static int msgConfirmacion(){
        int opc;
        do{
            opc = Teclado.leerInt("¿Desea confirmar ? [1->si] [2->no]","");
        }while(opc!=1 && opc!=2);
        return opc;
    }
    
    public static void printTexto(String dato){
        System.out.printf("%s %-15s:",">>",dato);
    }
    
    public static void printTexto(String dato, String marcador){
        System.out.printf("%s %-15s:",marcador,dato);
    }
}
