package modelo;

import datos.*;
import entidades.CuentaBancaria;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class Banco {
    private ILibroCuenta libroElectronico;

    public Banco() {
        this.libroElectronico = new LibroEnColeccion();
    }
    
    
    public void registraCuenta(CuentaBancaria c){
        this.libroElectronico.registraCuenta(c);
    }
    public CuentaBancaria consultarCuentaByNumero(int n){
         return this.libroElectronico.consultarCuentaByNumero(n);
    }
    public ArrayList<CuentaBancaria> ordenarCuentasBySaldo(){
        return this.libroElectronico.ordenarCuentasBySaldo();
    }
    public ArrayList<CuentaBancaria> consultarCuentasByMonto(double monto){
        return this.libroElectronico.consultarCuentasByMonto(monto);
    }
    public CuentaBancaria cancelarCuenta(int n){
        return this.libroElectronico.cancelarCuenta(n);
    }
    
}
