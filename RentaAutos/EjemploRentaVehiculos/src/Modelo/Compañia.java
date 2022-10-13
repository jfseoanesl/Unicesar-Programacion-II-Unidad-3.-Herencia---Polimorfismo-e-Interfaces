/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class Compañia {
    private String nombre;
    private ArrayList<Vehiculo> bdVehiculo;
    private int vReg; // vehiculos registrados

    public Compañia() {
        this("RENTA DE VEHICULOS SIERRA NEVADA");
    }

    public Compañia(String nombre) {
        this.nombre=nombre;
        this.bdVehiculo = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getBdVehiculo() {
        return bdVehiculo;
    }

    public void setBdVehiculo(ArrayList<Vehiculo> bdVehiculo) {
        this.bdVehiculo = bdVehiculo;
    }

    public int getvReg() {
        return vReg;
    }

    public void setvReg(int vReg) {
        this.vReg = vReg;
    }
    
    public void addVehiculo(Vehiculo v){
  
        this.bdVehiculo.add(v);
    }
    public Vehiculo buscarVehiculo(String placa){
        Vehiculo buscado=null;
        for(Vehiculo v: this.bdVehiculo){
            if(placa.equalsIgnoreCase(v.getPlaca())){
                buscado = v;
                break;
            }
        }
        return buscado;
    }
    
    public boolean verificaAlquiler(Vehiculo v){
       return v.isEstado();
    }
    
    public void rentarVehiculo(Vehiculo v){
                   
        v.rentarVehiculo();
            
    }
        
    
    public double devolverVehiculo(Vehiculo v){
       
            v.setEstado(false);
            return v.calcularImporte();
       
    }
    
    @Override
    public String toString(){
        return "Nombre Empresa: " + this.nombre + "\n" +
               "Total registrados: " + this.vReg;
    }
    
    public ArrayList<Vehiculo> vehiculosDisponibles(){
        ArrayList<Vehiculo> disponible = new ArrayList();
        int n=0;
        for(Vehiculo v: this.bdVehiculo){
            if(!v.isEstado()){
                disponible.add(v);
            }
        }
        return disponible;
    }
    
    public ArrayList<Vehiculo> vehiculosRentados(){
        ArrayList<Vehiculo> rentados = new ArrayList();
        int n=0;
        for(Vehiculo v: this.bdVehiculo){
            if(v.isEstado()){
                rentados.add(v);
            }
        }
        return rentados;
    }
    
    
    
}
