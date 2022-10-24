package modelo;

/**
 *
 * @author Jairo F
 */
public class Empleado implements ITrabajador{
    private Cargo cargo;

    public Empleado(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public double getSueldo() {
        double sueldo=0;
        switch(this.cargo){
            case COORDINADOR: sueldo = ITrabajador.sCoordinador;
                                break;
            case ASISTENTE:   sueldo = ITrabajador.sAsistente;
                                break;
            case SECRETARIA:  sueldo = ITrabajador.sSecretaria;
           
        }
        return sueldo;
    }

    @Override
    public double getBonificacion() {
        return this.getSueldo() * ITrabajador.bEmpleado;
    }
    
    @Override
    public String getTipo(){
        return "Empleado";
    }
    
}
