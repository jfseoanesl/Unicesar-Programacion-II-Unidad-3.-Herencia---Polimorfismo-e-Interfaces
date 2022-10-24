package modelo;

/**
 *
 * @author Jairo F
 */
public interface ISensor {
    public abstract void activarSensor();
    double leerMedicion();
    void desactivarSensor();
}
