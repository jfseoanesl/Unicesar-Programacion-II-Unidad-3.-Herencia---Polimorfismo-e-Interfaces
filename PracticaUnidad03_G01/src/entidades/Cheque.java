package entidades;

/**
 *
 * @author Jairo F
 */
public class Cheque extends CuentaBancaria{
    private double pComisionUso;

    public Cheque() {
    }

    public Cheque(int nimeroCuenta, String nombreCliente, double saldo, double pComisionUso) {
        super(nimeroCuenta, nombreCliente, saldo);
        this.pComisionUso = pComisionUso;
    }

    /**
     * @return the pComisionUso
     */
    public double getpComisionUso() {
        return pComisionUso;
    }

    /**
     * @param pComisionUso the pComisionUso to set
     */
    public void setpComisionUso(double pComisionUso) {
        this.pComisionUso = pComisionUso;
    }
    
    @Override
    public String consultarDatos(){
            String datos = super.consultarDatos() + 
                       String.format("\t%10s\t%10s\t%10.2f","X","X", 
                           this.pComisionUso);
        
        return datos;
    }
    
    @Override
    public void retirar(double monto){
        double comision = this.calcularComision(monto);
        double total = comision + monto;
        if(this.validarRetiro(total)){
           this.setSaldo(this.getSaldo()-total);
        }
        
    }
    
    public double calcularComision(double monto){
        return monto * this.pComisionUso;
    }
    
    @Override
    public boolean validarRetiro(double monto){
        return this.getSaldo()>=monto;
    }
}
