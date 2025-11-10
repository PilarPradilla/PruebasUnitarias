import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GananciasDiariasTest {

    @Test
    public void testCalculoGananciasCorrecto() {
        RegistroVentas registro = new RegistroVentas();
        registro.registrarVenta("Pollo Asado", 60000);
        registro.registrarVenta("Arepa", 10000);
        registro.registrarVenta("Gaseosa", 5000);

        double total = registro.calcularGanancias();
        assertEquals(75000, total, "La ganancia total debe ser 75,000");
    }

    @Test
    public void testNoPermitirVentaNegativa() {
        RegistroVentas registro = new RegistroVentas();
        registro.registrarVenta("Pollo Asado", -20000);
        assertEquals(0, registro.calcularGanancias(), "No debe registrar ventas negativas");
    }

    @Test
    public void testReiniciarVentas() {
        RegistroVentas registro = new RegistroVentas();
        registro.registrarVenta("Arepa", 5000);
        registro.reiniciar();
        assertEquals(0, registro.calcularGanancias(), "Las ganancias deben reiniciarse");
    }
}
