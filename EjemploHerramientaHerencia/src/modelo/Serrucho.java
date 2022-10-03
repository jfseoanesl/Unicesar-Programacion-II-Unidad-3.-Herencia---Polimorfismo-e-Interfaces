package modelo;

/**
 *
 * @author Jairo F
 */
public class Serrucho extends Herramienta {
    
    private String material;
    private double peso;
    private double dimension;

    public Serrucho() {
        super();
    }

    public Serrucho(String material, double peso, double dimension, String marca, double precio) {
        super(marca, precio);
        this.material = material;
        this.peso = peso;
        this.dimension = dimension;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the dimension
     */
    public double getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Serrucho{" + super.toString()+ ", material=" + material + ", peso=" + peso + ", dimension=" + dimension + '}';
    }
    
    
    
}
