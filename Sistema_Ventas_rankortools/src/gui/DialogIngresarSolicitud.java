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
import clases.Clientes;
import clases.Productos;
import clases.Venta;
import arreglos.ArregloVentas;


import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogIngresarSolicitud extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final DialogBuscarClientes DialogBuscarClientes = null;
	private JLabel lblVentaDeproductos;
	private JLabel lblCategoria;
	private JLabel lblProducto;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboProductos;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblS;
	private JButton btnComprar;
	private JScrollPane scr;
	
	private JTextArea txtS;private ArreglosProductos ap = new ArreglosProductos();
	private Map<String, String[]> productosPorCategoria;
	private ArregloVentas ventas = new ArregloVentas();
	private JLabel lblDni;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDireeccin;
	private JLabel lblTelefono;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnBuscar;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JButton btnLimpiar;


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
					dialog.setLocationRelativeTo(null);
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
		setBounds(100, 100, 598, 636);
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
		lblCategoria.setBounds(40, 228, 93, 17);
		getContentPane().add(lblCategoria);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProducto.setBounds(40, 255, 93, 17);
		getContentPane().add(lblProducto);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setBounds(130, 227, 214, 21);
		getContentPane().add(cboCategoria);
		
		cboProductos = new JComboBox<String>();
		cboProductos.setBounds(130, 255, 176, 21);
		getContentPane().add(cboProductos);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(40, 283, 93, 17);
		getContentPane().add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setBounds(40, 310, 72, 19);
		getContentPane().add(lblCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setText((String) null);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(130, 282, 101, 19);
		getContentPane().add(txtPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setText((String) null);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(130, 312, 101, 19);
		getContentPane().add(txtCantidad);
		
		lblS = new JLabel("S/.");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(107, 283, 22, 17);
		getContentPane().add(lblS);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnComprar.setBounds(423, 231, 105, 41);
		getContentPane().add(btnComprar);
		
		scr = new JScrollPane();
		scr.setBounds(21, 356, 544, 226);
		getContentPane().add(scr);
		
		txtS = new JTextArea();
		scr.setViewportView(txtS);
		txtS.setEditable(false);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(40, 56, 100, 19);
		getContentPane().add(lblDni);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombres.setBounds(40, 85, 100, 19);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(40, 114, 100, 19);
		getContentPane().add(lblApellidos);
		
		lblDireeccin = new JLabel("Dirección:");
		lblDireeccin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireeccin.setBounds(40, 143, 100, 19);
		getContentPane().add(lblDireeccin);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(40, 172, 100, 19);
		getContentPane().add(lblTelefono);
		
		txtDni = new JTextField();
		txtDni.setText((String) null);
		txtDni.setColumns(10);
		txtDni.setBounds(130, 58, 96, 19);
		getContentPane().add(txtDni);
		
		txtNombres = new JTextField();
		txtNombres.setText((String) null);
		txtNombres.setBounds(130, 87, 245, 19);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setText((String) null);
		txtApellidos.setBounds(130, 116, 245, 19);
		getContentPane().add(txtApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setText((String) null);
		txtDireccion.setBounds(130, 145, 281, 19);
		getContentPane().add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setText((String) null);
		txtTelefono.setBounds(130, 174, 147, 19);
		getContentPane().add(txtTelefono);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(427, 92, 101, 46);
		getContentPane().add(btnBuscar);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(21, 341, 544, 13);
		getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(21, 218, 544, 13);
		getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.GRAY);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(563, 219, 9, 120);
		getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.GRAY);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(21, 219, 9, 120);
		getContentPane().add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.GRAY);
		separator_4.setBounds(21, 47, 544, 13);
		getContentPane().add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.GRAY);
		separator_5.setBounds(21, 205, 544, 13);
		getContentPane().add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(21, 45, 10, 163);
		getContentPane().add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(563, 45, 10, 163);
		getContentPane().add(separator_7);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBounds(423, 283, 105, 41);
		getContentPane().add(btnLimpiar);

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
					txtPrecio.setText(String.valueOf(p.getPrecio()));
					break;
				}
			}
		} catch (Exception e) {
			txtPrecio.setText("");
		}
	}

	private void procesarCompra() {
	    try {
	        String categoria = cboCategoria.getSelectedItem().toString();
	        String producto = cboProductos.getSelectedItem().toString();
	        int cantidad = Integer.parseInt(txtCantidad.getText());
	        double precio = Double.parseDouble(txtPrecio.getText());
	        
	        Clientes cliente = new Clientes(
	                Integer.parseInt(txtDni.getText()),
	                txtNombres.getText(),
	                txtApellidos.getText(),
	                txtDireccion.getText(),
	                Integer.parseInt(txtTelefono.getText())
	            );

	        Venta venta = new Venta(categoria, producto, precio, cantidad, cliente);
	        txtS.setText(venta.formatoBoleta());
	        ventas.registrarVenta(venta);

	    } catch (Exception e) {
	        txtS.setText("Error al procesar la compra. Verifique los datos.");
	    }
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		DialogBuscarClientes dialogBuscarClientes = new DialogBuscarClientes(this);
		dialogBuscarClientes.setLocationRelativeTo(dialogBuscarClientes);
		dialogBuscarClientes.setModal(true);
		dialogBuscarClientes.setVisible(true);
	}

	public void cargarClienteDesdeBusqueda(Clientes c) {
	    txtDni.setText(String.valueOf(c.getDni()));
	    txtNombres.setText(c.getNombres());
	    txtApellidos.setText(c.getApellidos());
	    txtDireccion.setText(c.getDireccion());
	    txtTelefono.setText(String.valueOf(c.getTelefono()));
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtS.setText("");
	}
}
