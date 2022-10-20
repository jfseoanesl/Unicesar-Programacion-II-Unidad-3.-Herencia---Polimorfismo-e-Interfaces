
package vista;

import java.util.ArrayList;
import java.util.Date;

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
        // TODO code application logic here
        Vehiculo a = new Autobus("ABC", 1000, 0, 50);
        Vehiculo t = new Tractor("HIJ", 2000, new Date(122, 9, 1), new Date());
        Vehiculo m = new Motocicleta("FGH-1", 1000, 90);
        Vehiculo a2 = new Autobus("ABC-2", 1000, 0, 100);
        
        ArrayList<Vehiculo> lista = new ArrayList();
        lista.add(a);
        lista.add(t);
        lista.add(m);
        lista.add(a2);
        
        for(Vehiculo v: lista){
            System.out.println("Tipo vehiculo: " + v.getTipo());
            System.out.println("Importe por renta: " + v.devolucionVehiculo());
            System.out.println("---------");
        }
    }
    
}
