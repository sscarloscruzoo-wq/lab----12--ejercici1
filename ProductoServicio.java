package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.SequencedCollection;

public class ProductoServicio implements IProductoServicio {

    private final ArrayList<Producto> productos =
            new ArrayList<>();

    private final Path archivo =
            Paths.get("datos", "productos.txt");

    // Cargar productos al iniciar el servicio
    public ProductoServicio() {
        cargarProductos();
    }

    // CREATE
    @Override
    public boolean registrar(Producto producto) {

        if (buscar(producto.codigo) != null) {
            return false;
        }

        productos.add(producto);
        guardarProductos();

        return true;
    }

    // READ
    @Override
    public Producto buscar(String codigo) {

        for (Producto p : productos) {
            if (p.codigo.equalsIgnoreCase(codigo)) {
                return p;
            }
        }

        return null;
    }

    // UPDATE
    @Override
    public boolean actualizar(Producto nuevo) {

        Producto actual = buscar(nuevo.codigo);

        if (actual == null) {
            return false;
        }

        actual.nombre = nuevo.nombre;
        actual.precio = nuevo.precio;
        actual.stock = nuevo.stock;

        guardarProductos();

        return true;
    }

    // DELETE
    @Override
    public boolean eliminar(String codigo) {

        boolean eliminado = productos.removeIf(
                p -> p.codigo.equalsIgnoreCase(codigo)
        );

        if (eliminado) {
            guardarProductos();
        }

        return eliminado;
    }

    // LIST
    @Override
    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    // Guardar todos los productos en TXT
    private void guardarProductos() {

        try {
            Files.createDirectories(archivo.getParent());

            List<String> lineas = new ArrayList<>();

            for (Producto p : productos) {

                String linea = p.codigo + ";"
                        + p.nombre + ";"
                        + p.precio + ";"
                        + p.stock;

                lineas.add(linea);
            }

            Files.write(
                    archivo,
                    lineas,
                    StandardCharsets.UTF_8
            );
            
            System.out.println("TXT GUARDADO EN:");
            System.out.println(archivo.toAbsolutePath());
            System.out.println("PRODUCTOS: " + productos.size());

        } catch (IOException ex) {
            throw new IllegalStateException(
                    "No se pudo guardar productos.txt", ex
            );
        }
    }

    // Recuperar productos al iniciar
    private void cargarProductos() {

        if (!Files.exists(archivo)) {
            return;
        }

        try {

            List<String> lineas = Files.readAllLines(
                    archivo,
                    StandardCharsets.UTF_8
            );

            for (String linea : lineas) {

                String[] datos = linea.split(";", -1);

                if (datos.length != 4) {
                    continue;
                }

                try {
                    Producto p = new Producto(
                            datos[0],
                            datos[1],
                            Double.parseDouble(datos[2]),
                            Integer.parseInt(datos[3])
                    );

                    if (buscar(p.codigo) == null) {
                        productos.add(p);
                    }

                } catch (NumberFormatException ex) {
                    System.err.println(
                            "Registro inválido: " + linea
                    );
                }
            }

        } catch (IOException ex) {
            throw new IllegalStateException(
                    "No se pudo leer productos.txt", ex
            );
        }
    }
    
    // SEMANA 12 - HERRAMIENTAS DE COLECCIÓN

    @Override
    public List<Producto> recorrerConIterator() {
        List<Producto> resultado = new ArrayList<>();
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            resultado.add(it.next());
        }
        return resultado;
    }

    @Override
    public List<Producto> buscarPorNombre(String texto) {
        String filtro = texto == null ? ""
                : texto.trim().toLowerCase(Locale.ROOT);
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.nombre.toLowerCase(Locale.ROOT).contains(filtro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    @Override
    public List<Producto> ordenarPorPrecio(boolean ascendente) {
        List<Producto> resultado = listar();
        Comparator<Producto> comparador =
                Comparator.comparingDouble(p -> p.precio);
        if (!ascendente) {
            comparador = comparador.reversed();
        }
        resultado.sort(comparador);
        return resultado;
    }

    @Override
    public List<Producto> ordenarPorNombre() {
        List<Producto> resultado = listar();
        resultado.sort(Comparator.comparing(
                p -> p.nombre,
                String.CASE_INSENSITIVE_ORDER));
        return resultado;
    }

    @Override
    public Producto obtenerPrimero() {
        SequencedCollection<Producto> secuencia = productos;
        return secuencia.isEmpty() ? null : secuencia.getFirst();
    }

    @Override
    public Producto obtenerUltimo() {
        SequencedCollection<Producto> secuencia = productos;
        return secuencia.isEmpty() ? null : secuencia.getLast();
    }

    @Override
    public List<Producto> obtenerInvertidos() {
        SequencedCollection<Producto> secuencia = productos;
        return new ArrayList<>(secuencia.reversed());
    }
}