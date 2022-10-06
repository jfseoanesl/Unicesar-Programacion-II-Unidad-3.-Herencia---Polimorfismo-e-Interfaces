package modelo;

import java.util.Date;

/**
 *
 * @author Jairo F
 */
public class ProductoBancario {
    private int idProducto;
    private Date fechaApertura;

    public ProductoBancario() {
    }

    public ProductoBancario(int idProducto, Date fechaApertura) {
        this.idProducto = idProducto;
        this.fechaApertura = fechaApertura;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the fechaApertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * @param fechaApertura the fechaApertura to set
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "ProductoBancario{" + "idProducto=" + idProducto + ", fechaApertura=" + fechaApertura + '}';
    }
    
    
}
