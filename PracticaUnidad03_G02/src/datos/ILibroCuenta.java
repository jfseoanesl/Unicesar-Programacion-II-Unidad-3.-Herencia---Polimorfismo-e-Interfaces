package datos;

import entidades.*;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface ILibroCuenta {
    void registraCuenta(CuentaBancaria c);
    CuentaBancaria consultarCuentaByNumero(int n);
    ArrayList<CuentaBancaria> ordenarCuentasBySaldo();
    ArrayList<CuentaBancaria> consultarCuentasByMonto(double monto);
    CuentaBancaria cancelarCuenta(int n);
}
