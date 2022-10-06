package modelo;

import java.util.Date;

/**
 *
 * @author Jairo F
 */
public class Cuenta extends ProductoBancario {
    private String numCuenta;
    private double saldo;
    private String titula;

    public Cuenta() {
        //super();
    }

    public Cuenta(int idProducto, Date fechaApertura, String numCuenta, double saldo, String titula) {
        super(idProducto, fechaApertura);
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.titula = titula;
    }

    /**
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
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

    /**
     * @return the titula
     */
    public String getTitula() {
        return titula;
    }

    /**
     * @param titula the titula to set
     */
    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String toString() {
        return "Cuenta{" +super.toString() + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", titula=" + titula + '}';
    }
    
    
    
}
