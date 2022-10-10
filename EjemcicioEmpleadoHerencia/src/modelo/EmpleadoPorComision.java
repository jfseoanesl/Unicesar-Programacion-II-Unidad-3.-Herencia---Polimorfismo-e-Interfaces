package modelo;

/**
 *
 * @author Jairo F
 */
public class EmpleadoPorComision extends EmpleadoBasico {
    
    private double ventasDelMes;
    private double pComision;

    public EmpleadoPorComision() {
        super();
        this.ventasDelMes=1000000;
        this.pComision=0.05;
    }

    public EmpleadoPorComision(double ventasDelMes, double pComision, double horasTrabajadasMes, double pagoPorHora) {
        super(horasTrabajadasMes, pagoPorHora);
        this.ventasDelMes = ventasDelMes;
        this.pComision = pComision;
    }

    /**
     * @return the ventasDelMes
     */
    public double getVentasDelMes() {
        return ventasDelMes;
    }

    /**
     * @param ventasDelMes the ventasDelMes to set
     */
    public void setVentasDelMes(double ventasDelMes) {
        this.ventasDelMes = ventasDelMes;
    }

    /**
     * @return the pComision
     */
    public double getpComision() {
        return pComision;
    }

    /**
     * @param pComision the pComision to set
     */
    public void setpComision(double pComision) {
        this.pComision = pComision;
    }
    
    public double calcularComision(){
        double comision = this.ventasDelMes * this.pComision;
        return comision;
    }
    
    @Override
    public double calcularSalarioMensual(){
        
        double salario=super.calcularSalarioMensual() + this.calcularComision();
        return salario;
    }
    
}
