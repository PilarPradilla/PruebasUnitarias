import java.util.HashMap;
import java.util.Map;

class RegistroVentas {
    private Map<String, Double> ventas = new HashMap<>();

    // Registra una venta con su monto total
    public void registrarVenta(String producto, double monto) {
        if (monto > 0) {
            ventas.put(producto, ventas.getOrDefault(producto, 0.0) + monto);
        } else {
            System.out.println("No se puede registrar una venta con monto 0 o negativo.");
        }
    }

    // Calcula la ganancia total del día
    public double calcularGanancias() {
        double total = 0;
        for (double valor : ventas.values()) {
            total += valor;
        }
        return total;
    }

    // Limpia el registro (para simular un nuevo día)
    public void reiniciar() {
        ventas.clear();
    }
}

public class GananciasDiarias {
    public static void main(String[] args) {
        RegistroVentas registro = new RegistroVentas();
        registro.registrarVenta("Pollo Asado", 60000);
        registro.registrarVenta("Arepa", 10000);
        registro.registrarVenta("Gaseosa", 5000);

        System.out.println("Ganancias del día: $" + registro.calcularGanancias());
    }
}
