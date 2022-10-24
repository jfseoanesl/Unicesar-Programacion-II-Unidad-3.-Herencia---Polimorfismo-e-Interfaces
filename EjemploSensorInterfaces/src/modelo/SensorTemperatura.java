package modelo;

import java.util.Random;

/**
 *
 * @author Jairo F
 */
public class SensorTemperatura implements ISensor {

    @Override
    public void activarSensor() {
         System.out.println("Se activa el sensor de tmp");
    }

    @Override
    public double leerMedicion() {
        Random r = new Random();
        return r.nextDouble();
    }

    @Override
    public void desactivarSensor() {
        System.out.println("Se desactiva el sensor de tmp");
    }
    
}
