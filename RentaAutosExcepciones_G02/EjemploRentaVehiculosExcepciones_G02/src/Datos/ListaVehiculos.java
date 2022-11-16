package Datos;

import Entidad.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class ListaVehiculos implements IServicios {
    private ArrayList<Vehiculo> lista;

    public ListaVehiculos() {
        this.lista = new ArrayList();
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) {
        Vehiculo buscado=null;
        for(Vehiculo v: this.lista){
            if(placa.equalsIgnoreCase(v.getPlaca())){
                buscado = v;
                break;
            }
        }
        return buscado;
    }

    @Override
    public void addVehiculo(Vehiculo v) {
        this.lista.add(v);
    }

    @Override
    public ArrayList<Vehiculo> getAllVehiculo() {
        return this.lista;
    }

    @Override
    public ArrayList<Vehiculo> vehiculosDisponibles() {
        ArrayList<Vehiculo> disponible = new ArrayList();
        int n=0;
        for(Vehiculo v: this.lista){
            if(!v.isEstado()){
                disponible.add(v);
            }
        }
        return disponible;
    }

    @Override
    public ArrayList<Vehiculo> vehiculosRentados() {
        ArrayList<Vehiculo> rentados = new ArrayList();
        int n=0;
        for(Vehiculo v: this.lista){
            if(v.isEstado()){
                rentados.add(v);
            }
        }
        return rentados;
    }
}
