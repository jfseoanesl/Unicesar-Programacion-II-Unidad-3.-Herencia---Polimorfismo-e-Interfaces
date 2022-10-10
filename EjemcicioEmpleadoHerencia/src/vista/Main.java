package vista;

import modelo.EmpleadoBasico;
import modelo.EmpleadoPorComision;

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
        
        EmpleadoBasico eb = new EmpleadoBasico();
        System.out.println("Salario eb: " + eb.calcularSalarioMensual());
        System.out.println("---------------------------------");
        
        EmpleadoPorComision ec = new EmpleadoPorComision();
        System.out.println("Salario ec: " + ec.calcularSalarioMensual());
    }
    
}
