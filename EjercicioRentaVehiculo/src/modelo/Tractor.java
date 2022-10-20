package modelo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jairo F
 */
public class Tractor extends Vehiculo {
    private Date fechaRenta;
    private Date fechaDevolucion;

    public Tractor() {
    }

    public Tractor(String placa, double tarifa,Date fechaRenta, Date fechaDevolucion) {
        super(placa, tarifa);
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the fechaRenta
     */
    public Date getFechaRenta() {
        return fechaRenta;
    }

    /**
     * @param fechaRenta the fechaRenta to set
     */
    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    /**
     * @return the fechaDevolucion
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    @Override
    public double devolucionVehiculo(){
        long diff = this.fechaDevolucion.getTime() - this.fechaRenta.getTime();
        
        TimeUnit unit = TimeUnit.DAYS;
        long dias = unit.convert(diff, TimeUnit.MILLISECONDS);

        //long dias = diff / (1000 * 60 * 60 * 24);
        
        double importe = dias * this.getTarifa();
        this.setAlquilado(false);
        return importe;
    }
    
    @Override
    public String getTipo() {
        return "Tractor";
    }
}
