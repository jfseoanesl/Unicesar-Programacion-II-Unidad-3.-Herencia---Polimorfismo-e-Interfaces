package entidades;

/**
 *
 * @author Jairo F
 */
public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected String nombreCliente;
    protected double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int numeroCuenta, String nombreCliente, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
    }

    /**
     * @return the numeroCuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
        String datos = String.format("%15d\t%15s\t%10.2f", 
                                     this.numeroCuenta,
                                     this.nombreCliente,
                                     this.saldo);
        return datos;
    }
    
    public void depositar(double monto){
        this.saldo = this.saldo + monto;
    }
    
    public void retirar(double monto){
        if(this.validarRetiro(monto)){
            this.saldo = this.saldo - monto;
        }
    }
    
    public abstract boolean validarRetiro(double monto);
}
