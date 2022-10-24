package modelo;

/**
 *
 * @author Jairo F
 */
public interface ITrabajador {
    double sCoordinador = 5000;
    double sAsistente = 4000;
    double sSecretaria = 3000;
    double pHoraDocente = 120;
    double bEmpleado = 1;
    double bDocente = 0.7;
    
    double getSueldo();
    double getBonificacion();
    String getTipo();
}
