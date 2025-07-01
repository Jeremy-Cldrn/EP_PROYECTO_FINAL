package arreglos;

import clases.Venta;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ArregloVentas {
    private static final String ARCHIVO = "data/ventas.txt";

    public void registrarVenta(Venta venta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            pw.println(venta.toArchivo());
        } catch (IOException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }
    }
}

