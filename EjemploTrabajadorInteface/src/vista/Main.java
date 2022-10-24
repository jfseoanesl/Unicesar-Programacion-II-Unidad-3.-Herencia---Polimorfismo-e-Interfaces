package vista;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ILibro libroTrabajadores = new LibroArrayList();
        
        Empleado e = new Empleado(Cargo.COORDINADOR);
        libroTrabajadores.adicionar(e);
                
        Docente d = new Docente(18);
        libroTrabajadores.adicionar(d);
       
        ITrabajador i = new Empleado(Cargo.SECRETARIA);
        libroTrabajadores.adicionar(i);
        
        System.out.println("Trabajadores registrados: ");
        System.out.println("--------------------------------------------");
        for(ITrabajador r: libroTrabajadores.leer()){
            infoTrabajador(r);
        }
        
        System.out.println("");
        
        System.out.println("Trabajadores que ganan mas de $9000:");
        System.out.println("------------------------------------------------");
        ArrayList<ITrabajador> busqueda = libroTrabajadores.buscar(9000);
        for(ITrabajador r: busqueda){
            infoTrabajador(r);
        }
    }
    
    public static void infoTrabajador(ITrabajador t){
        System.out.println("Tipo: " + t.getTipo());
        System.out.println("Sueldo: " + t.getSueldo());
        System.out.println("Bonificacion: " + t.getBonificacion());
        System.out.println("------------------------");
    }
    
    public static void imprimirListaTrabajador(ArrayList<ITrabajador> lista){
        for(ITrabajador t: lista){
            infoTrabajador(t);
        }
    }
}
