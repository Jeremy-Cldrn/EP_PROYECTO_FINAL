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
	private JScrollPane scrollPane;
	private JTable tblProductos;
	private JButton btnAdicionar, btnModificar, btnEliminar;
	private DefaultTableModel modeloProducto;
	private JComboBox<String> cmbCategoria, cmbProductos;
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
		setBounds(100, 100, 637, 450);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoProd = new JLabel("MANTENIMIENTO PRODUCTOS", SwingConstants.CENTER);
		lblMantenimientoProd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoProd.setBounds(0, 0, 623, 34);
		lblMantenimientoProd.setForeground(Color.WHITE);
		lblMantenimientoProd.setBackground(Color.BLACK);
		lblMantenimientoProd.setOpaque(true);
		contentPane.add(lblMantenimientoProd);

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(27, 61, 93, 17);
		contentPane.add(lblCategoria);

		lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProducto.setBounds(27, 92, 93, 17);
		contentPane.add(lblProducto);

		lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(351, 61, 93, 17);
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(425, 62, 176, 19);
		contentPane.add(txtCodigo);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(351, 95, 93, 17);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(425, 93, 176, 19);
		contentPane.add(txtPrecio);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 145, 574, 208);
		contentPane.add(scrollPane);

		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);

		modeloProducto = new DefaultTableModel(new Object[]{"Código", "Categoria", "Producto", "Precio"}, 0);
		tblProductos.setModel(modeloProducto);

		tblProductos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting() && tblProductos.getSelectedRow() != -1) {
				int fila = tblProductos.getSelectedRow();
				txtCodigo.setText(tblProductos.getValueAt(fila, 0).toString());
				cmbCategoria.setSelectedItem(tblProductos.getValueAt(fila, 1).toString());
				cmbProductos.setSelectedItem(tblProductos.getValueAt(fila, 2).toString());
				txtPrecio.setText(tblProductos.getValueAt(fila, 3).toString());
			}
		});

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setBounds(70, 376, 114, 21);
		contentPane.add(btnAdicionar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(254, 376, 114, 21);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(438, 376, 114, 21);
		contentPane.add(btnEliminar);

		cmbCategoria = new JComboBox<>();
		cmbCategoria.setBounds(141, 61, 176, 21);
		cmbCategoria.addActionListener(this);
		contentPane.add(cmbCategoria);

		cmbProductos = new JComboBox<>();
		cmbProductos.setBounds(141, 92, 176, 21);
		contentPane.add(cmbProductos);

		inicializarDatos();
		listar();
	}

	private void inicializarDatos() {
		productosPorCategoria = new HashMap<>();
		productosPorCategoria.put("Herramientas Electricas", new String[]{"Cortadoras", "Esmeril", "Hidrovaladoras", "Martillos", "Pistolas de calor", "Sierras", "Sopladoras", "Taladros", "Tronzadoras"});
		productosPorCategoria.put("Herramientas Inalámbricas", new String[]{"Atornilladores", "Llaves", "Taladro atornillador"});
		productosPorCategoria.put("Accesorios", new String[]{"Brocas", "Cinceles", "Discos"});

		for (String categoria : productosPorCategoria.keySet()) {
			cmbCategoria.addItem(categoria);
		}
		actualizarProductos("Herramientas Inalámbricas");
	}

	private void actualizarProductos(String categoria) {
		cmbProductos.removeAllItems();
		String[] productos = productosPorCategoria.get(categoria);
		if (productos != null) {
			for (String producto : productos) {
				cmbProductos.addItem(producto);
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
		if (e.getSource() == cmbCategoria) {
			actionPerformedCmbCategoria(e);
		}
	}

	protected void actionPerformedCmbCategoria(ActionEvent e) {
		String categoriaSeleccionada = (String) cmbCategoria.getSelectedItem();
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
			modeloProducto.addRow(new Object[]{p.getCodigo(), p.getCategoria(), p.getProducto(), p.getPrecio()});
		}
	}

	void limpiar() {
		cmbCategoria.setSelectedIndex(0);
		cmbProductos.setSelectedIndex(0);
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
		return cmbCategoria.getSelectedItem().toString();
	}

	String leerProducto() {
		return cmbProductos.getSelectedItem().toString();
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	//FUNCIONES CRUD
	private void adicionarProductos() {
		Productos nuevo = new Productos(leerCodigo(), leerCategoria(), leerProducto(), leerPrecio());
		ap.adicionar(nuevo);
		listar();
		limpiar();
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
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			ap.eliminar(ap.obtener(fila));
			listar();
			limpiar();
		}
	}
}
