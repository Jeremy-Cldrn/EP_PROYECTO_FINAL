package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

import arreglos.ArreglosProductos;
import clases.Productos;
import clases.Venta;
import arreglos.ArregloVentas;


import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogIngresarSolicitud extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblVentaDeproductos;
	private JLabel lblCategoria;
	private JLabel lblProducto;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboProductos;
	private JLabel lblPrecio;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblS;
	private JButton btnComprar;
	private JScrollPane scr;
	
	private JTextArea txtS;private ArreglosProductos ap = new ArreglosProductos();
	private Map<String, String[]> productosPorCategoria;
	private ArregloVentas ventas = new ArregloVentas();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogIngresarSolicitud dialog = new DialogIngresarSolicitud();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogIngresarSolicitud() {
		setTitle("Ingresar solicitud");
		setBounds(100, 100, 607, 484);
		getContentPane().setLayout(null);
		
		lblVentaDeproductos = new JLabel("VENTA DEPRODUCTOS");
		lblVentaDeproductos.setOpaque(true);
		lblVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDeproductos.setForeground(Color.WHITE);
		lblVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVentaDeproductos.setBackground(Color.BLACK);
		lblVentaDeproductos.setBounds(1, 1, 597, 34);
		getContentPane().add(lblVentaDeproductos);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(45, 65, 93, 17);
		getContentPane().add(lblCategoria);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProducto.setBounds(45, 101, 93, 17);
		getContentPane().add(lblProducto);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setBounds(135, 64, 214, 21);
		getContentPane().add(cboCategoria);
		
		cboProductos = new JComboBox<String>();
		cboProductos.setBounds(135, 100, 176, 21);
		getContentPane().add(cboProductos);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(45, 138, 93, 17);
		getContentPane().add(lblPrecio);
		
		lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 171, 72, 19);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText((String) null);
		textField.setColumns(10);
		textField.setBounds(135, 137, 101, 19);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBounds(135, 173, 101, 19);
		getContentPane().add(textField_1);
		
		lblS = new JLabel("S/.");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(112, 138, 22, 17);
		getContentPane().add(lblS);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnComprar.setBounds(428, 68, 105, 92);
		getContentPane().add(btnComprar);
		
		scr = new JScrollPane();
		scr.setBounds(18, 212, 561, 218);
		getContentPane().add(scr);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scr.setViewportView(txtS);

		cboCategoria.addActionListener(e -> actualizarProductos());
		btnComprar.addActionListener(e -> procesarCompra());
		cboProductos.addActionListener(e -> actualizarPrecio());

		inicializarDatos();
		

	}

	private void inicializarDatos() {
		productosPorCategoria = new HashMap<>();
		productosPorCategoria.put("Herramientas Electricas", new String[]{"Cortadoras", "Esmeril", "Hidrolavadoras", "Martillos", "Pistolas de calor", "Sierras", "Sopladoras", "Taladros", "Tronzadoras"});
		productosPorCategoria.put("Herramientas Inalámbricas", new String[]{"Atornilladores", "Llaves", "Taladro atornillador"});
		productosPorCategoria.put("Accesorios", new String[]{"Brocas", "Cinceles", "Discos"});

		for (String categoria : productosPorCategoria.keySet()) {
			cboCategoria.addItem(categoria);
		}
		cboCategoria.setSelectedIndex(0); // para disparar el primer update
	}


	private void actualizarProductos() {
		String categoria = cboCategoria.getSelectedItem().toString();
		cboProductos.removeAllItems();
		String[] productos = productosPorCategoria.get(categoria);
		if (productos != null) {
			for (String producto : productos) {
				cboProductos.addItem(producto);
			}
		}
		actualizarPrecio();
	}

	private void actualizarPrecio() {
		try {
			String categoria = cboCategoria.getSelectedItem().toString();
			String producto = cboProductos.getSelectedItem().toString();
			for (int i = 0; i < ap.tamanio(); i++) {
				Productos p = ap.obtener(i);
				if (p.getCategoria().equals(categoria) && p.getProducto().equals(producto)) {
					textField.setText(String.valueOf(p.getPrecio()));
					break;
				}
			}
		} catch (Exception e) {
			textField.setText("");
		}
	}

	private void procesarCompra() {
	    try {
	        String categoria = cboCategoria.getSelectedItem().toString();
	        String producto = cboProductos.getSelectedItem().toString();
	        int cantidad = Integer.parseInt(textField_1.getText());
	        double precio = Double.parseDouble(textField.getText());

	        Venta venta = new Venta(categoria, producto, precio, cantidad);
	        txtS.setText(venta.formatoBoleta());
	        ventas.registrarVenta(venta);

	    } catch (Exception e) {
	        txtS.setText("Error al procesar la compra. Verifique los datos.");
	    }
	}


}
