package modelo;

/**
 *
 * @author Jairo F
 */
public class EmpleadoBasico {
    private double horasTrabajadasMes;
    private double pagoPorHora;

    public EmpleadoBasico(double horasTrabajadasMes, double pagoPorHora) {
        this.horasTrabajadasMes = horasTrabajadasMes;
        this.pagoPorHora = pagoPorHora;
    }

    public EmpleadoBasico() {
        this.horasTrabajadasMes=160;
        this.pagoPorHora=12500;
    }

    /**
     * @return the horasTrabajadasMes
     */
    public double getHorasTrabajadasMes() {
        return horasTrabajadasMes;
    }

    /**
     * @param horasTrabajadasMes the horasTrabajadasMes to set
     */
    public void setHorasTrabajadasMes(double horasTrabajadasMes) {
        this.horasTrabajadasMes = horasTrabajadasMes;
    }

    /**
     * @return the pagoPorHora
     */
    public double getPagoPorHora() {
        return pagoPorHora;
    }

    /**
     * @param pagoPorHora the pagoPorHora to set
     */
    public void setPagoPorHora(double pagoPorHora) {
        this.pagoPorHora = pagoPorHora;
    }
    
    public double calcularSalarioMensual(){
        double salario = this.horasTrabajadasMes * this.pagoPorHora;
        return salario;
    }
}
