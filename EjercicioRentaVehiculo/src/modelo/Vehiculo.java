package modelo;

/**
 *
 * @author Jairo F
 */
public abstract class Vehiculo {
    private String placa;
    private double tarifa;
    private boolean alquilado;

    public Vehiculo() {
    }

    public Vehiculo(String placa, double tarifa) {
        this.placa = placa;
        this.tarifa = tarifa;
        this.alquilado=true;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the tarifa
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the alquilado
     */
    public boolean isAlquilado() {
        return alquilado;
    }

    /**
     * @param alquilado the alquilado to set
     */
    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }
    
    public abstract double devolucionVehiculo();
    public abstract String getTipo();
    
}
