package datos;

import entidades.CuentaBancaria;
import java.util.Comparator;

/**
 *
 * @author Jairo F
 */
public class OrdenPorSaldo implements Comparator<CuentaBancaria>{

    @Override
    public int compare(CuentaBancaria o1, CuentaBancaria o2) {
        if(o1.getSaldo()>o2.getSaldo())
            return 1;
        else if(o1.getSaldo()==o2.getSaldo())
            return 0;
        else return -1;
    }
    
}
