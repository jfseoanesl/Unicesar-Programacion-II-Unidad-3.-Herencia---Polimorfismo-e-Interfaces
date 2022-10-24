package modelo;

import java.util.Random;

/**
 *
 * @author Jairo F
 */
public class SensorRuido implements ISensor{

    @Override
    public void activarSensor() {
        System.out.println("Se activa sensor de ruido");
    }

    @Override
    public double leerMedicion() {
        Random r = new Random();
        double lectura= r.nextDouble();
        return Math.round(lectura * 1000.0) / 1000.0;
    }

    @Override
    public void desactivarSensor() {
        System.out.println("Se desactiva sensor de ruido");
    }
    
}
