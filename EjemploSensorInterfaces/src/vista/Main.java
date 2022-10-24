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
        // TODO code application logic here
        ISensor st = new SensorTemperatura();
        double lectura=st.leerMedicion();
        
        ISensor sr = new SensorRuido();
     
        
        ArrayList<ISensor> lista = new ArrayList();
        lista.add(sr);
        lista.add(st);
        
        for(ISensor s: lista){
            ejecutarSensor(s);
            System.out.println("-------------");
        }
        
    }
    
    public static void ejecutarSensor(ISensor sensor){
        sensor.activarSensor();
        System.out.println("Lectura sensor: " + sensor.leerMedicion());
        sensor.desactivarSensor();
    }
    
}
