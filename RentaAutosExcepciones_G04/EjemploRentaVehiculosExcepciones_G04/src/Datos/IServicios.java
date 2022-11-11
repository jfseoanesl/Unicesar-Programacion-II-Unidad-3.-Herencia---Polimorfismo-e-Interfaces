/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import Entidad.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface IServicios {
    Vehiculo buscarVehiculo(String placa);
    void addVehiculo(Vehiculo v);
    ArrayList<Vehiculo> getAllVehiculo();
    ArrayList<Vehiculo> vehiculosDisponibles();
    ArrayList<Vehiculo> vehiculosRentados();
}
