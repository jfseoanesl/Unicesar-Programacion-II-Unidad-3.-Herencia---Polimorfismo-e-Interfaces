/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.IServicios;
import Datos.ListaVehiculos;
import Entidad.Autobus;
import Entidad.Tractor;
import Entidad.Vehiculo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class Compañia {
    private String nombre;
    private IServicios bdVehiculo;

    public Compañia() {
        this("RENTA DE VEHICULOS SIERRA NEVADA");
    }

    public Compañia(String nombre) {
        this.nombre=nombre;
        this.bdVehiculo = new ListaVehiculos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

       
    public void addVehiculo(Vehiculo v) throws Exception{
        if(v instanceof Autobus){
            Autobus autobus = (Autobus)v;
            
            if(autobus.getpKm()<0)
                throw new Exception("La tarifa de renta del autobus debe ser mayor que 0");
            
            if(autobus.getnKmRenta()<0)
                throw new Exception("El Kilometraja del autobus debe ser un numero positivo");
        }
        else{
            Tractor tractor = (Tractor)v;
            
            if(tractor.getpDia()<0)
                throw new Exception("La tarifa de renta del tractor debe ser un numero positivo");
        }
        
        this.getBdVehiculo().addVehiculo(v);
    }
    
    public Vehiculo buscarVehiculo(String placa){
        
        return this.bdVehiculo.buscarVehiculo(placa);
        
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
               "Total registrados: " + this.getBdVehiculo().getAllVehiculo().size();
    }
    
    public ArrayList<Vehiculo> vehiculosDisponibles(){
        
        return this.bdVehiculo.vehiculosDisponibles();
                
    }
    
    public ArrayList<Vehiculo> vehiculosRentados(){
        
        return this.bdVehiculo.vehiculosRentados();
        
    }

    /**
     * @return the bdVehiculo
     */
    public IServicios getBdVehiculo() {
        return bdVehiculo;
    }

    /**
     * @param bdVehiculo the bdVehiculo to set
     */
    public void setBdVehiculo(IServicios bdVehiculo) {
        this.bdVehiculo = bdVehiculo;
    }
    
    
    
}
