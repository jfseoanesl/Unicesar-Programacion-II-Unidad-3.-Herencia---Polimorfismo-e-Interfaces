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
import Excepciones.ValidationException;
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

       
    public void addVehiculo(Vehiculo v) throws ValidationException{
       if(v==null)
           throw new ValidationException("El vehiculo no puede ser null, no es posible almacenarlo");
       if(v instanceof Autobus){
           if(((Autobus) v).getnKmRenta()<0)
               throw new ValidationException("El Kms del autobus deben ser mayor a cero ");
           
           if(((Autobus) v).getpKm()<0)
               throw new ValidationException("La tarifa del autobus deben ser mayor a cero ");
       }
       else if(v instanceof Tractor){
           
           if(((Tractor) v).getpDia()<0)
               throw new ValidationException("La tarifa del tractor deben ser mayor a cero ");
       
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
