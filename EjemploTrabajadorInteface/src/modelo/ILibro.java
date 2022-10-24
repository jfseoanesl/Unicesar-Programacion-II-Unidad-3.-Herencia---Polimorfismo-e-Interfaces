package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public interface ILibro {
    int MAX_TRABAJADORES = 10;
    void adicionar(ITrabajador t);
    ArrayList<ITrabajador> buscar(double monto);
    ArrayList<ITrabajador> leer();
}
