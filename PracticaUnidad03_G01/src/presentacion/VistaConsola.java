package presentacion;

import entidades.*;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Banco;

/**
 *
 * @author Jairo F
 */
public class VistaConsola {

    private Banco banco;
    private String menuGeneral[] = {"1. Registro de cuenta",
        "2. Consulta de cuenta",
        "3. Ordenamiento de cuenta x saldo",
        "4. Consulta de cuentas x Monto",
        "5. Cancelacion de cuenta",
        "0. Salir"};
    private String menuAhorro[] = {"1. Depositar",
        "2. Retirar",
        "3. Aplicar interes mensual",
        "0. Salir"};
    private String menuCheques[] = {"1. Depositar",
        "2. Retirar",
        "0. Salir"};
    private int opcMenuGeneral, opcMenuAhorro, opcMenuCheque;

    public VistaConsola() {
        this.banco = new Banco();
    }

    private void vistaRegistrarCuenta() {
        CuentaBancaria cuenta;
        Pantalla.tituloVista(this.menuGeneral[this.opcMenuGeneral - 1]);
        int numero = Teclado.leerInt("No cuenta");
        String cliente = Teclado.leerString("Nombre cliente");
        double saldo = Teclado.leerDouble("Saldo inicial");
        int tipo;
        do {
            tipo = Teclado.leerInt("Tipo[1-Ahorro][2-Cheque]");
        } while (tipo != 1 && tipo != 2);
        if (tipo == 1) { // ahorro
            LocalDate fechaVencimiento = Teclado.leerFecha("Fecha vencimiento");
            double interesMensual = Teclado.leerDouble("% Interes mensual");
            cuenta = new Ahorro(numero, cliente, saldo, fechaVencimiento, interesMensual);
        } else {//cheque
            double comisionUso = Teclado.leerDouble("% Comision por uso");
            cuenta = new Cheque(numero, cliente, saldo, comisionUso);
        }

        if (Pantalla.msgConfirmacion() == 1) {
            this.banco.registrarCuenta(cuenta);
            Pantalla.msgExito();
        }

    }

    private void vistaConsultarCuentabyNumero() {
        CuentaBancaria cuenta;
        Pantalla.tituloVista(this.menuGeneral[this.opcMenuGeneral - 1]);
        int numero = Teclado.leerInt("No cuenta");
        cuenta = this.banco.consultarCuentaByNumero(numero);
        if (cuenta != null) {
            Pantalla.imprimirCuentas(cuenta);
            this.vistaOperacionesCuenta(cuenta);
        } else {
            Pantalla.msgNoEncontrada();
        }
    }

    private void vistaOrdenarCuenta() {
        ArrayList<CuentaBancaria> cuentas;
        Pantalla.tituloVista(this.menuGeneral[this.opcMenuGeneral - 1]);
        cuentas = this.banco.ordenarCuentasBySaldo();
        Pantalla.imprimirCuentas(cuentas);
    }

    private void vistaConsultarCuentaByMonto() {
        ArrayList<CuentaBancaria> cuentas;
        Pantalla.tituloVista(this.menuGeneral[this.opcMenuGeneral - 1]);
        double monto = Teclado.leerDouble("Monto: ");
        cuentas = this.banco.consultarCuentasByMonto(monto);
        Pantalla.imprimirCuentas(cuentas);

    }

    private void vistaCancelarCuenta() {
        CuentaBancaria cuenta;
        Pantalla.tituloVista(this.menuGeneral[this.opcMenuGeneral - 1]);
        int numero = Teclado.leerInt("No cuenta");
        cuenta = this.banco.cancelarCuenta(numero);
        if (cuenta != null) {
            Pantalla.msgExito();
            Pantalla.imprimirCuentas(cuenta);
            Pantalla.printTexto("Cuenta eliminada\n", "*");
        } else {
            Pantalla.msgNoEncontrada();
        }
    }

    private void vistaSalir() {
        Pantalla.tituloVista("** Fin de la ejecucion del programa **");
    }

    public void menuGeneral() {
        do {
            this.opcMenuGeneral = Pantalla.imprimirMenu("MENU GENERAL", this.menuGeneral);
            switch (this.opcMenuGeneral) {
                case 1:
                    this.vistaRegistrarCuenta();
                    break;
                case 2:
                    this.vistaConsultarCuentabyNumero();
                    break;
                case 3:
                    this.vistaOrdenarCuenta();
                    break;
                case 4:
                    this.vistaConsultarCuentaByMonto();
                    break;
                case 5:
                    this.vistaCancelarCuenta();
                    break;
                case 0:
                    this.vistaSalir();
            }
        } while (this.opcMenuGeneral != 0);
    }

    private void vistaOperacionesCuenta(CuentaBancaria cuenta) {
        if (cuenta instanceof Ahorro) {
            this.menuAhorro((Ahorro) cuenta);
        } else {
            this.menuCheques((Cheque) cuenta);
        }

    }

    private void vistaRetirar(CuentaBancaria cuenta) {
        Pantalla.tituloVista("Retiros de cuenta[ cuenta no: " + cuenta.getNumeroCuenta() + " ]");
        double monto = Teclado.leerDouble("Monto");
        cuenta.retirar(monto);
        Pantalla.msgExito();

    }

    private void vistaDepositar(CuentaBancaria cuenta) {
        Pantalla.tituloVista("Depositos en cuenta[ cuenta no: " + cuenta.getNumeroCuenta() + " ]");
        double monto = Teclado.leerDouble("Monto");
        cuenta.depositar(monto);
        Pantalla.msgExito();

    }

    private void vistaDepositarInteres(Ahorro cuenta) {
        Pantalla.tituloVista("Aplicacion de interes mensual [ cuenta no: " + cuenta.getNumeroCuenta() + " ]");
        Pantalla.printTexto("Saldo inicial");
        System.out.println(cuenta.getSaldo());

        Pantalla.printTexto("% Interes aplicados");
        System.out.println(cuenta.getpInteresMensual());

        cuenta.depositarInteres();

        Pantalla.printTexto("Nuevo saldo ");
        System.out.println(cuenta.getSaldo());

        Pantalla.msgExito();

    }

    private void menuAhorro(Ahorro cuenta) {
        do {
            this.opcMenuAhorro = Pantalla.imprimirMenu("MENU AHORROS[ cuenta no: " + cuenta.getNumeroCuenta() + " ]", this.menuAhorro);
            switch (this.opcMenuAhorro) {
                case 1:
                    this.vistaDepositar(cuenta);
                    break;
                case 2:
                    this.vistaRetirar(cuenta);
                    break;
                case 3:
                    this.vistaDepositarInteres(cuenta);
                    break;

                case 0:
            }
        } while (this.opcMenuAhorro != 0);
    }

    private void menuCheques(Cheque cuenta) {
        do {
            this.opcMenuCheque = Pantalla.imprimirMenu("MENU CHEQUES[ cuenta no: " + cuenta.getNumeroCuenta() + " ]", this.menuCheques);
            switch (this.opcMenuCheque) {
                case 1:
                    this.vistaDepositar(cuenta);
                    break;
                case 2:
                    this.vistaRetirar(cuenta);
                    break;
                case 0:
            }
        } while (this.opcMenuCheque != 0);
    }

}
