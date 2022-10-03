package modelo;

/**
 *
 * @author Jairo F
 */
public class Herramienta {
    protected String marca;
    protected double precio;

    public Herramienta() {
        
    }

    public Herramienta(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "marca=" + marca + ", precio=" + precio + '}';
    }
    
    
    
}
