package modelo;

/**
 *
 * @author Jairo F
 */
public class Autobus extends Vehiculo {
    private double kmRenta;
    private double kmDevolucion;

    public Autobus() {
    }

    public Autobus(String placa, double tarifa, double kmRenta, double kmDevolucion) {
        super(placa, tarifa);
        this.kmRenta = kmRenta;
        this.kmDevolucion = kmDevolucion;
    }

    /**
     * @return the kmRenta
     */
    public double getKmRenta() {
        return kmRenta;
    }

    /**
     * @param kmRenta the kmRenta to set
     */
    public void setKmRenta(double kmRenta) {
        this.kmRenta = kmRenta;
    }

    /**
     * @return the kmDevolucion
     */
    public double getKmDevolucion() {
        return kmDevolucion;
    }

    /**
     * @param kmDevolucion the kmDevolucion to set
     */
    public void setKmDevolucion(double kmDevolucion) {
        this.kmDevolucion = kmDevolucion;
    }
    
    @Override
    public double devolucionVehiculo(){
        double importe = (this.kmDevolucion-this.kmRenta) * this.getTarifa();
        this.setAlquilado(false);
        return importe;
    }

    @Override
    public String getTipo() {
        return "Autobus";
    }
    
}
