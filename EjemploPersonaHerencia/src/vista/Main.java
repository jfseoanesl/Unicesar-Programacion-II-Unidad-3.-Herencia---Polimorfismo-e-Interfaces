package vista;

import modelo.Medico;
import modelo.Persona;

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
        
        Persona p = new Persona();
        p.setNombre("Jairo");
        p.setApellido("Seoanes");
        p.setEdad(25);
        
        System.out.println(p.toString());
        
        Medico m = new Medico();
        m.setNombre("Jairo");
        m.setApellido("Seoanes");
        m.setEdad(25);
        m.setEspecialidad("Pediatra");
        m.setHospital("Rosario Pumarejo");
        System.out.println(m);
    }
    
}
