package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DialogHistorialVentas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblVentaDeproductos;
	private JScrollPane scr;
	private JTextArea txtS;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogHistorialVentas dialog = new DialogHistorialVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogHistorialVentas() {
		setTitle("Historial de Ventas");
		setBounds(100, 100, 568, 754);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblVentaDeproductos = new JLabel("HISTORIAL DE VENTAS");
		lblVentaDeproductos.setBounds(0, 0, 554, 42);
		lblVentaDeproductos.setOpaque(true);
		lblVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDeproductos.setForeground(Color.WHITE);
		lblVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVentaDeproductos.setBackground(Color.BLACK);
		contentPanel.add(lblVentaDeproductos);

		scr = new JScrollPane();
		scr.setBounds(14, 57, 524, 596);
		contentPanel.add(scr);
		
		txtS = new JTextArea();
		scr.setViewportView(txtS);

		// Llamada correcta al método
		mostrarHistorial1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	// Método para leer y mostrar el historial
	private void mostrarHistorial1() {
		try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
			StringBuilder contenido = new StringBuilder();
			String linea;
			int numVenta = 1;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				if (datos.length == 5) {
					contenido.append("VENTA N° ").append(numVenta++).append("\n");
					contenido.append("Categoría\t: ").append(datos[0]).append("\n");
					contenido.append("Producto\t: ").append(datos[1]).append("\n");
					contenido.append("Precio\t\t: S/ ").append(datos[2]).append("\n");
					contenido.append("Cantidad\t: ").append(datos[3]).append("\n");
					contenido.append("Total\t\t: S/ ").append(datos[4]).append("\n");
					contenido.append("----------------------------------------\n");
				}
			}
		} catch (IOException e) {
			txtS.setText("No se pudo leer el archivo de ventas.");
		}
	}
}