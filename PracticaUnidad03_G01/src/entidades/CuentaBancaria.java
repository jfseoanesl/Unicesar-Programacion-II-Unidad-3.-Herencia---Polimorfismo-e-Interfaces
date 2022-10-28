package entidades;

/**
 *
 * @author Jairo F
 */
public abstract class CuentaBancaria {
    private int numeroCuenta;
    private String nombreCliente;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int nimeroCuenta, String nombreCliente, double saldo) {
        this.numeroCuenta = nimeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
    }

    /**
     * @return the nimeroCuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param nimeroCuenta the nimeroCuenta to set
     */
    public void setNumeroCuenta(int nimeroCuenta) {
        this.numeroCuenta = nimeroCuenta;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String consultarDatos(){
        
        String datos = String.format("%10d\t%10s\t%10.2f", 
                this.numeroCuenta,
                this.nombreCliente,
                this.saldo);
        
        return datos;
    }
    
    public void depositar(double monto){
        this.saldo= this.saldo + monto;
    }
    
    public void retirar(double monto){
       
        if(this.validarRetiro(monto)){
            
           this.saldo = this.saldo - monto; 
           
        }   
    }
    
    public abstract boolean validarRetiro(double monto);
}
