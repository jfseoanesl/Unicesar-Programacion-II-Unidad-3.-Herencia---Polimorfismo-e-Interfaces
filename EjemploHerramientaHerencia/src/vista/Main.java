package vista;

import modelo.Herramienta;
import modelo.Serrucho;

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
        
        Herramienta h = new Herramienta();
        h.setMarca("Contructor");
        h.setPrecio(100);
        System.out.println("H: " + h);
        
        Herramienta h2 = new Herramienta("La roca", 2000);
        System.out.println("H2: " + h2);
        
        Serrucho s = new Serrucho("Acero", 1, 120, "Braulio", 400);
        System.out.println("S: " + s);
        
    }
    
}
