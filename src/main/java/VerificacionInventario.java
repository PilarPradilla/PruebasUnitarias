import java.util.ArrayList;
import java.util.List;

class Producto {
    String nombre;
    int stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }
}

class Tienda {
    List<Producto> productos = new ArrayList<>();
    List<Producto> carrito = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public boolean hayProductos() {
        return !productos.isEmpty();
    }

    public void agregarAlCarrito(String nombre) {
        if (!hayProductos()) {
            System.out.println("No hay productos disponibles.");
            return;
        }
        for (Producto p : productos) {
            if (p.nombre.equals(nombre) && p.stock > 0) {
                carrito.add(p);
                p.stock--;
                System.out.println("Producto agregado al carrito: " + p.nombre);
                return;
            }
        }
        System.out.println("Producto no disponible o sin stock.");
    }
}

public class VerificacionInventario {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.agregarProducto(new Producto("Libro", 2));
        tienda.agregarProducto(new Producto("Lapiz", 0));

        tienda.agregarAlCarrito("Lapiz"); // Producto no disponible o sin stock
        tienda.agregarAlCarrito("Libro"); // Producto agregado al carrito: Libro

        tienda.productos.clear(); // Simular tienda vacía
        tienda.agregarAlCarrito("Libro"); // No hay productos disponibles.
    }
}
