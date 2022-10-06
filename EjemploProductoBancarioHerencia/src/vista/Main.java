package vista;

import java.util.Date;
import modelo.Cuenta;
import modelo.ProductoBancario;

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
        
        ProductoBancario productoA = new ProductoBancario();
        System.out.println("A: " + productoA);
        
        ProductoBancario productoB= new ProductoBancario(123, new Date());
        System.out.println("B: " + productoB);
        
        Cuenta cuenta = new Cuenta();
        System.out.println("cuenta: " + cuenta);
        
        Cuenta cuenta2 = new Cuenta(456, new Date(),"ABC345", 1000, "Jairo Seoanes");
        System.out.println("Cuenta2: " + cuenta2);
    }
    
}
