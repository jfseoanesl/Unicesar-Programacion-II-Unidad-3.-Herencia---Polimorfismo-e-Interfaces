package entidades;

import java.time.*;

/**
 *
 * @author Jairo F
 */
public class Ahorro extends CuentaBancaria {
    private double pInteresMensual;
    private LocalDate fechaVencimiento;

    public Ahorro() {
    }

    public Ahorro( int numeroCuenta, String nombreCliente, double saldo, double pInteresMensual, LocalDate fechaVencimiento) {
        super(numeroCuenta, nombreCliente, saldo);
        this.pInteresMensual = pInteresMensual;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the pInteresMensual
     */
    public double getpInteresMensual() {
        return pInteresMensual;
    }

    /**
     * @param pInteresMensual the pInteresMensual to set
     */
    public void setpInteresMensual(double pInteresMensual) {
        this.pInteresMensual = pInteresMensual;
    }

    /**
     * @return the fechaVencimiento
     */
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    @Override
    public String consultarDatos(){
        String datos = super.consultarDatos() + String.format("\t%10s\t%10.2f\t%10s", 
                                                this.fechaVencimiento,
                                                this.pInteresMensual,
                                                "X");
        return datos;
    }
    
    @Override
    public boolean validarRetiro(double monto){
        if(this.saldo>=monto){
            LocalDate hoy = LocalDate.now();
            return hoy.compareTo(this.fechaVencimiento)==0;
        }
        else{
            return false;
        }
        
        
    }
    
    public void depositarInteres(){
        double intereses = this.pInteresMensual * this.saldo;
        this.depositar(intereses);
    }
    
}
