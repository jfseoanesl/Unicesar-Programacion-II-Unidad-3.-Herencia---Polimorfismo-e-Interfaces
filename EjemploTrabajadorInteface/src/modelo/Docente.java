package modelo;

/**
 *
 * @author Jairo F
 */
public class Docente implements ITrabajador {
    private int horasT;

    public Docente(int horasT) {
        this.horasT = horasT;
    }

    /**
     * @return the horasT
     */
    public int getHorasT() {
        return horasT;
    }

    /**
     * @param horasT the horasT to set
     */
    public void setHorasT(int horasT) {
        this.horasT = horasT;
    }

    @Override
    public double getSueldo() {
        return this.horasT * ITrabajador.pHoraDocente;
    }

    @Override
    public double getBonificacion() {
        return this.getSueldo() * ITrabajador.bDocente;
    }
    
    @Override
    public String getTipo(){
        return "Docente";
    }
    
}
