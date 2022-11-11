/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidad.Autobus;
import Modelo.Compañia;
import Entidad.Tractor;
import Entidad.Vehiculo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class VistaConsola {

    private Compañia company;

    public VistaConsola() {
        this.company = new Compañia();
    }

    public void vistaMenuPpal() {
        int opc;
        do {
            System.out.println("\n [ " + this.company.getNombre() + " ]");
            System.out.println("----------- MENU PRINCIPAL -----------");
            System.out.println("1. Adicionar nuevo vehiculo");
            System.out.println("2. Rentar Vehiculo");
            System.out.println("3. Devolver Vehiculo");
            System.out.println("0. Salir");
            System.out.println("-------------------------------------");
            opc = Entrada.leerInt("Seleccione: ");

            switch (opc) {
                case 0:
                    System.out.println("Aplicativo cerrado con exito");
                    break;
                case 1:
                    this.vistaAdicionarVehiculo();
                    break;
                case 2:
                    this.vistaRentarVehiculo();
                    break;
                case 3:
                    this.vistaDevolverVehiculo();
                    break;
                default:
                    System.out.println("!! Opcion no disponible, seleccione nuevamente ¡¡");
            }

        } while (opc != 0);
    }

    public int vistaVehiculosDisponibles() {
        System.out.println("");
        ArrayList<Vehiculo> disponible = this.company.vehiculosDisponibles();
        int i = disponible.size();
        System.out.printf("Vehiculos disponibles para rentar:[ %d ]%n", i);
        System.out.println("-------------------------------------------------------------");
        if (disponible.size() > 0) {
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "Placa", "Tipo", "No Km", "Tarifa");
        }

        for (Vehiculo v : disponible) {
            System.out.print(v.infoRenta());
        }

        System.out.println("-------------------------------------------------------------");
        return i;
    }

    public int vistaVehiculosRentados() {
        System.out.println("");
        ArrayList<Vehiculo> rentados = this.company.vehiculosRentados();
        int i = rentados.size();
        System.out.printf("Vehiculos pendiente por devolucion: [ %d ]%n", i);
        System.out.println("---------------------------------------------------------------------");

        if (rentados.size() > 0) {
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\n", "Placa", "Tipo", "Km-Renta", "Fecha-Renta", "Tarifa");
        }

        for (Vehiculo v : rentados) {
            System.out.print(v.infoDevolucion());
        }

        System.out.println("---------------------------------------------------------------------");
        return i;
    }

    public Vehiculo vistaBuscarVehiculoRenta() {
        String placa = Entrada.leerString("Seleccione placa: ");
        Vehiculo v = this.company.buscarVehiculo(placa);
        return v;
    }

    public void vistaRentarVehiculo() {
        System.out.println(" \n--- 3. RENTAR VEHICULO ---");
        int continuar;
        do {
            int tDisponible = this.vistaVehiculosDisponibles();
            if (tDisponible > 0) {
                Vehiculo v = this.vistaBuscarVehiculoRenta();
                if (v != null) {
                    if (!this.company.verificaAlquiler(v)) {
                        this.company.rentarVehiculo(v);
                        System.out.println("\n!!EL vehiculo rentado con exito ¡¡\n");
                    } else {
                        System.out.println("\n!!EL vehiculo no se encuentra disponible para alquiler ¡¡\n");
                    }
                } else {
                    System.out.println("\n!!EL vehiculo no se encuentra registrado ¡¡\n");
                }
                continuar = Entrada.leerInt("¿0->para rentar otro ?  ");
            } else {
                continuar = 1;
            }
        } while (continuar == 0);

    }

    public void vistaDevolverVehiculo() {
        System.out.println(" --- 4. DEVOLUCION VEHICULO ---");

        int continuar;
        do {
            int tRentados = this.vistaVehiculosRentados();
            if (tRentados > 0) {
                Vehiculo v = this.vistaBuscarVehiculoRenta();
                if (v != null) {
                    if (this.company.verificaAlquiler(v)) {

                        double km = 0;
                        Date fecha = null;
                        System.out.println("\nDatos de devolucion: ");
                        System.out.println("-----------------------------");
                        if (v instanceof Autobus) {
                            km = Entrada.leerDouble("Kilometraje actual: ");
                            ((Autobus) v).setnKmDevuelve(km);
                        } else {
                            fecha = Entrada.leerFecha("Fecha de devolucion: ");
                            ((Tractor) v).setfDevolucion(fecha);
                        }
                        double importe = this.company.devolverVehiculo(v);
                        System.out.println("Importe a pagar: " + importe + "\n");

                    } else {
                        System.out.println("\n!! El vehiculo no se encuentra rentado \n");
                    }
                } else {
                    System.out.println("\n!! El vehiculo no se encuentra registrado en la compañia \n");
                }
            }

            continuar = Entrada.leerInt("¿0->para devolver otro ?  ");

        } while (continuar == 0);

    }

    public Vehiculo vistaCrearVehiculo() {
        System.out.println("---------------------------------");
        Vehiculo v;
        String placa = Entrada.leerString("No Placa: ");
        int tipo;
        do {
            tipo = Entrada.leerInt("Tipo de vehiculo[0->Autobus , 1->Tractor]:");
        } while (tipo != 0 && tipo != 1);
        if (tipo == 0) {
            double kmActual = Entrada.leerDouble("Kilometraje: ");
            double tarifaKm = Entrada.leerDouble("Tarifa x Km: ");
            v = new Autobus(tarifaKm, placa, kmActual);
        } else {
            double tarifaDia = Entrada.leerDouble("Tarifa x Dia: ");
            v = new Tractor(tarifaDia, placa);
        }
        System.out.println("");
        return v;
    }

    public void vistaAdicionarVehiculo() {
        System.out.println(" \n--- 2. REGISTRO DE VEHICULOS ---");
        int continuar;

        do {
            boolean tieneExcepcion;
            do {

                try {
                    Vehiculo v = this.vistaCrearVehiculo();
                    this.company.addVehiculo(v);
                    tieneExcepcion = false;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Ingrese los datos nuevamente: ");
                    tieneExcepcion = true;
                }
            } while (tieneExcepcion);

            System.out.println("Registro exitoso...\n");
            continuar = Entrada.leerInt("¿Desea registrar otro ? [0->si][Otro->no] ");

        } while (continuar == 0);

    }

}
