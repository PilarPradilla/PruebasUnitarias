import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    @Test
    public void testAgregarProductoYCarrito() {
        Tienda tienda = new Tienda();
        Producto libro = new Producto("Libro", 2);
        tienda.agregarProducto(libro);

        assertTrue(tienda.hayProductos());

        tienda.agregarAlCarrito("Libro");
        assertEquals(1, libro.stock);
    }

    @Test
    public void testProductoSinStock() {
        Tienda tienda = new Tienda();
        tienda.agregarProducto(new Producto("Lapiz", 0));

        tienda.agregarAlCarrito("Lapiz");
        assertEquals(0, tienda.carrito.size());
    }
}
