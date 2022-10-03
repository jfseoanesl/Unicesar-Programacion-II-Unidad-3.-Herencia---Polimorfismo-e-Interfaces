package modelo;

/**
 *
 * @author Jairo F
 */
public class Medico extends Persona {
    
    private String especialidad;
    private String hospital;

    public Medico() {
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Medico{" +super.toString() + ", especialidad=" + especialidad + ", hospital=" + hospital + '}';
    }
    
    
}
