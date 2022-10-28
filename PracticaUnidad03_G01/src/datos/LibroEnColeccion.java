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
    
    

    @Override
    public void registrarCuenta(CuentaBancaria c) {
        this.libro.add(c);
    }

    @Override
    public CuentaBancaria consultarCuentaByNumero(int n) {
            CuentaBancaria busqueda=null;
            for(CuentaBancaria b: this.libro){
                if(b.getNumeroCuenta()==n){
                    busqueda = b;
                    break;
                }
            }
            return busqueda;
    }

    @Override
    public ArrayList<CuentaBancaria> ordenarCuentasBySaldo() {
        ArrayList<CuentaBancaria> listaOrdenada = new ArrayList(this.libro);
        Collections.sort(listaOrdenada, new OrdenPorSaldo());
        return  listaOrdenada;
    }

    @Override
    public ArrayList<CuentaBancaria> consultarCuentasByMonto(double monto) {
        ArrayList<CuentaBancaria> consulta = new ArrayList();
        for(CuentaBancaria b: this.libro){
            if(b.getSaldo()>=monto){
                consulta.add(b);
            }
        }
        return consulta;
    }

    @Override
    public CuentaBancaria cancelarCuenta(int n) {
        Iterator<CuentaBancaria> i = this.libro.iterator();
        CuentaBancaria eliminada = null;
        while(i.hasNext()){
            CuentaBancaria b = i.next();
            if(b.getNumeroCuenta()==n){
                eliminada = b;
                i.remove();
                break;
            }
        }
        return eliminada;
        
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
}
