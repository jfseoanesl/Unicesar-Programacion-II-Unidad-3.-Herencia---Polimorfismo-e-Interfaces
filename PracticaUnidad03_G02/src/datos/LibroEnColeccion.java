package datos;

import entidades.CuentaBancaria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Jairo F
 */
public class LibroEnColeccion implements ILibroCuenta {
    private ArrayList<CuentaBancaria> libro;

    public LibroEnColeccion() {
        this.libro = new ArrayList();
    }

    /**
     * @return the libro
     */
    public ArrayList<CuentaBancaria> getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(ArrayList<CuentaBancaria> libro) {
        this.libro = libro;
    }

    @Override
    public void registraCuenta(CuentaBancaria c) {
        this.libro.add(c);
    }

    @Override
    public CuentaBancaria consultarCuentaByNumero(int n) {
       CuentaBancaria buscada= null;
       for(CuentaBancaria c: this.libro){
           if(c.getNumeroCuenta()==n){
               buscada=c;
               break;
           }
       }
       return buscada;
    }

    @Override
    public ArrayList<CuentaBancaria> ordenarCuentasBySaldo() {
        ArrayList<CuentaBancaria> ordenada = new ArrayList(this.libro);
        Collections.sort(ordenada, new OrdenPorSaldo());
        return ordenada;
    }

    @Override
    public ArrayList<CuentaBancaria> consultarCuentasByMonto(double monto) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList();
        for(CuentaBancaria c: this.libro){
            if(c.getSaldo()>=monto){
                cuentas.add(c);
            }
        }
        return cuentas;
    }

    @Override
    public CuentaBancaria cancelarCuenta(int n) {
       CuentaBancaria cancelada= null;
       Iterator<CuentaBancaria> i = this.libro.iterator();
       while(i.hasNext()){
           CuentaBancaria leida = i.next();
           if(leida.getNumeroCuenta()==n){
               cancelada = leida;
               i.remove();
               break;
           }
       }
       return cancelada;
    }
    
    
}
