
package ejercicio1;

import java.util.List;

public interface IProductoServicio {

    boolean registrar(Producto producto);

    Producto buscar(String codigo);

    boolean actualizar(Producto producto);

    boolean eliminar(String codigo);

    List<Producto> listar();
    
        // SEMANA 12 - COLECCIONES
    List<Producto> recorrerConIterator();
    List<Producto> buscarPorNombre(String texto);
    List<Producto> ordenarPorPrecio(boolean ascendente);
    List<Producto> ordenarPorNombre();
    Producto obtenerPrimero();
    Producto obtenerUltimo();
    List<Producto> obtenerInvertidos();
}
