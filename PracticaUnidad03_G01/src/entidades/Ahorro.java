package entidades;

import java.time.*;

/**
 *
 * @author Jairo F
 */
public class Ahorro extends CuentaBancaria{
    private LocalDate fechaVencimiento;
    private double pInteresMensual;

    public Ahorro() {
    }

    public Ahorro(int nimeroCuenta, String nombreCliente, double saldo,LocalDate fechaVencimiento, double pInteresMensual) {
        super(nimeroCuenta, nombreCliente, saldo);
        this.fechaVencimiento = fechaVencimiento;
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

    @Override
    public boolean validarRetiro(double monto) {
        if(this.getSaldo()>=monto){
            LocalDate hoy = LocalDate.now();
            if(hoy.compareTo(this.fechaVencimiento)==0){
                return true;
            }//fechas iguales
            else
                return false;
        
        }// si hay ssaldo para retiro
        else
            return false;
    }
    
    @Override
    public String consultarDatos(){
        
        String datos = super.consultarDatos() + 
                       String.format("\t%10s\t%10.2f\t%10s", 
                           this.fechaVencimiento, this.pInteresMensual, "X");
        
        return datos;
    }
    
    public void depositarInteres(){
        double interes = this.getSaldo() * this.pInteresMensual;
        this.depositar(interes);
    }
    
    
}
