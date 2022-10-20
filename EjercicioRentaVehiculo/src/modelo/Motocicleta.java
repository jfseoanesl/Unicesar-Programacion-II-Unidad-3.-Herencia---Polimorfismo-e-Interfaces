
package modelo;

/**
 *
 * @author Jairo F
 */
public class Motocicleta  extends Vehiculo{
    private double tiempoMinRenta;

    public Motocicleta() {
    }

    public Motocicleta( String placa, double tarifa, double tiempoMinRenta) {
        super(placa, tarifa);
        this.tiempoMinRenta = tiempoMinRenta;
    }

    /**
     * @return the tiempoMinRenta
     */
    public double getTiempoMinRenta() {
        return tiempoMinRenta;
    }

    /**
     * @param tiempoMinRenta the tiempoMinRenta to set
     */
    public void setTiempoMinRenta(double tiempoMinRenta) {
        this.tiempoMinRenta = tiempoMinRenta;
    }
    
    @Override
    public double devolucionVehiculo(){
        this.setAlquilado(false);
        return this.tiempoMinRenta * this.getTarifa();
        
    }
    @Override
    public String getTipo() {
        return "Motocicleta";
    }
}
