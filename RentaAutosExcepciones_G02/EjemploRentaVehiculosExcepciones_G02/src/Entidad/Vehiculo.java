/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author jairo
 */
public abstract class Vehiculo {
    private String placa;
    private boolean estado; // alquilado(true) - Disponible (false)

    public Vehiculo() {
    }

    public Vehiculo(String placa) {
        this.placa = placa;
        this.estado=false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public abstract double calcularImporte();
    
    public void rentarVehiculo(){
        this.setEstado(true);
    }
    
        
    public abstract String infoRenta();
    
    public abstract String infoDevolucion();
    
}
