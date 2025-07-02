package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosProductos;
import clases.Productos;

public class DialogProductos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoProd, lblCategoria, lblProducto, lblCdigo, lblPrecio;
	private JTextField txtCodigo, txtPrecio;
	private JScrollPane scr;
	private JTable tblProductos;
	private JButton btnAdicionar, btnModificar, btnEliminar;
	private DefaultTableModel modeloProducto;
	private JComboBox<String> cboCategoria, cboProductos;
	private Map<String, String[]> productosPorCategoria;
	private ArreglosProductos ap = new ArreglosProductos();
	
    public static void main(String[] args) {
        try {
            DialogProductos dialog = new DialogProductos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public DialogProductos() {
		setTitle("Productos");
		setBounds(0, -28, 735, 557);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoProd = new JLabel("MANTENIMIENTO PRODUCTOS", SwingConstants.CENTER);
		lblMantenimientoProd.setBounds(0, 0, 702, 34);
		lblMantenimientoProd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoProd.setForeground(Color.WHITE);
		lblMantenimientoProd.setBackground(Color.BLACK);
		lblMantenimientoProd.setOpaque(true);
		contentPane.add(lblMantenimientoProd);

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(58, 61, 93, 17);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCategoria);

		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(58, 95, 93, 17);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblProducto);

		lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(406, 61, 93, 17);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(480, 62, 176, 19);
		contentPane.add(txtCodigo);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(406, 95, 93, 17);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(480, 93, 176, 19);
		contentPane.add(txtPrecio);

		scr = new JScrollPane();
		scr.setBounds(27, 145, 675, 289);
		contentPane.add(scr);

		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scr.setViewportView(tblProductos);

		modeloProducto = new DefaultTableModel(new Object[]{"Código", "Categoria", "Producto", "Precio"}, 0);
		tblProductos.setModel(modeloProducto);

		tblProductos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting() && tblProductos.getSelectedRow() != -1) {
				int fila = tblProductos.getSelectedRow();
				txtCodigo.setText(tblProductos.getValueAt(fila, 0).toString());
				cboCategoria.setSelectedItem(tblProductos.getValueAt(fila, 1).toString());
				cboProductos.setSelectedItem(tblProductos.getValueAt(fila, 2).toString());
				txtPrecio.setText(tblProductos.getValueAt(fila, 3).toString());
			}
		});

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(110, 465, 114, 21);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnAdicionar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(302, 465, 114, 21);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(491, 465, 114, 21);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnEliminar);

		cboCategoria = new JComboBox<>();
		cboCategoria.setBounds(156, 61, 195, 21);
		cboCategoria.addActionListener(this);
		contentPane.add(cboCategoria);

		cboProductos = new JComboBox<>();
		cboProductos.setBounds(156, 93, 195, 21);
		contentPane.add(cboProductos);

		inicializarDatos();
		listar();
	}

	private void inicializarDatos() {
		productosPorCategoria = new HashMap<>();
		productosPorCategoria.put("Herramientas Electricas", new String[]{"Cortadoras", "Esmeril", "Hidrovaladoras", "Martillos", "Pistolas de calor", "Sierras", "Sopladoras", "Taladros", "Tronzadoras"});
		productosPorCategoria.put("Herramientas Inalámbricas", new String[]{"Atornilladores", "Llaves", "Taladro atornillador"});
		productosPorCategoria.put("Accesorios", new String[]{"Brocas", "Cinceles", "Discos"});

		for (String categoria : productosPorCategoria.keySet()) {
			cboCategoria.addItem(categoria);
		}
		actualizarProductos("Herramientas Inalámbricas");
	}

	private void actualizarProductos(String categoria) {
		cboProductos.removeAllItems();
		String[] productos = productosPorCategoria.get(categoria);
		if (productos != null) {
			for (String producto : productos) {
				cboProductos.addItem(producto);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == cboCategoria) {
			actionPerformedCmbCategoria(e);
		}
	}

	protected void actionPerformedCmbCategoria(ActionEvent e) {
		String categoriaSeleccionada = (String) cboCategoria.getSelectedItem();
		actualizarProductos(categoriaSeleccionada);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		adicionarProductos();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarProductos();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarProductos();
	}

	void listar() {
		modeloProducto.setRowCount(0);
		for (int i = 0; i < ap.tamanio(); i++) {
			Productos p = ap.obtener(i);
			modeloProducto.addRow(
				new Object[]{p.getCodigo(), 
							 p.getCategoria(), 
							 p.getProducto(), 
							 p.getPrecio()});
		}
	}

	void limpiar() {
		cboCategoria.setSelectedIndex(0);
		cboProductos.setSelectedIndex(0);
		txtCodigo.setText("");
		txtPrecio.setText("");
		txtCodigo.requestFocus();
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	String leerCategoria() {
		return cboCategoria.getSelectedItem().toString();
	}

	String leerProducto() {
		return cboProductos.getSelectedItem().toString();
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	
	private void adicionarProductos() {
		String codigoStr = txtCodigo.getText().trim();
		String precioStr = txtPrecio.getText().trim();

		if (codigoStr.isEmpty()) {
			mensaje("No se ingresó el código del producto.");
			txtCodigo.requestFocus();
			return;
		}
		if (precioStr.isEmpty()) {
			mensaje("No se ingresó el precio del producto.");
			txtPrecio.requestFocus();
			return;
		}

		try {
			int codigo = Integer.parseInt(codigoStr);
			double precio = Double.parseDouble(precioStr);
			String categoria = leerCategoria();
			String producto = leerProducto();

			// Verifica si el código ya existe
			if (ap.buscarProductos(codigo) != null) {
				mensaje("El código ya existe. Ingrese un código diferente.");
				txtCodigo.requestFocus();
				return;
			}

			// Verifica si ya existe un producto con la misma categoría y nombre
			for (int i = 0; i < ap.tamanio(); i++) {
				Productos p = ap.obtener(i);
				if (p.getCategoria().equalsIgnoreCase(categoria) &&
					p.getProducto().equalsIgnoreCase(producto)) {
					mensaje("Ya existe un producto con esa categoría y nombre.");
					return;
				}
			}

			// Si todo está bien, se agrega el producto
			Productos nuevo = new Productos(codigo, categoria, producto, precio);
			ap.adicionar(nuevo);
			listar();
			limpiar();
			mensaje("Producto agregado correctamente.");
		} catch (NumberFormatException ex) {
			mensaje("Código o precio inválido. Asegúrese de ingresar valores numéricos.");
		}
	}

	
	private void modificarProductos() {
		int fila = tblProductos.getSelectedRow();
		if (fila == -1) {
			mensaje("Seleccione una fila para modificar");
			return;
		}
		try {
			int codigo = leerCodigo();
			Productos x = ap.buscarProductos(codigo);
			if (x != null) {
				x.setCategoria(leerCategoria());
				x.setProducto(leerProducto());
				x.setPrecio(leerPrecio());
				ap.actualizarArchivo();
				listar();
				limpiar();
				mensaje("Producto modificado correctamente");
			} else {
				mensaje("El código ingresado no existe");
				txtCodigo.requestFocus();
			}
		} catch (Exception ex) {
			mensaje("Datos inválidos");
		}
	}
	
	private void eliminarProductos() {
		int fila = tblProductos.getSelectedRow();
		if (fila == -1) {
			mensaje("Seleccione fila a eliminar");
			return;
		}
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION,2);
		if (respuesta == JOptionPane.YES_OPTION) {
			ap.eliminar(ap.obtener(fila));
			listar();
			limpiar();
		}
	}
}
