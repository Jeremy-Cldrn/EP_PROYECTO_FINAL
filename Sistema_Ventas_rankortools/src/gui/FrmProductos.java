package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosProductos;
import clases.Productos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProductos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoProd;
	private JLabel lblCategoria;
	private JLabel lblProducto;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JScrollPane scrollPane;
	private JTable tblProductos;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel modeloProducto;
	private JComboBox<String> cmbCategoria;
	private JComboBox<String> cmbProductos;
	private Map<String, String[]> productosPorCategoria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductos frame = new FrmProductos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProductos() {
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoProd = 	new JLabel("MANTENIMIENTO PRODUCTOS");
		lblMantenimientoProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoProd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoProd.setBounds(0, 0, 613, 34);
		lblMantenimientoProd.setForeground(new Color(255, 255, 255));
		lblMantenimientoProd.setBackground(new Color(0, 0, 0));
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
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(425, 62, 176, 19);
		contentPane.add(txtCodigo);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(351, 95, 93, 17);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(425, 93, 176, 19);
		contentPane.add(txtPrecio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 145, 574, 208);
		contentPane.add(scrollPane);
		
		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		modeloProducto = new DefaultTableModel();
		modeloProducto.addColumn("Código");
		modeloProducto.addColumn("Categoria"); 
		modeloProducto.addColumn("Producto");
		modeloProducto.addColumn("Precio");
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
		cmbCategoria.addActionListener(this);
		cmbCategoria.setBounds(141, 61, 176, 21);
		contentPane.add(cmbCategoria);
		
		cmbProductos = new JComboBox<>();
		cmbProductos.setBounds(141, 92, 176, 21);
		contentPane.add(cmbProductos);
		
		inicializarDatos();
		listar();
	}
	
	//Declaración global
	ArreglosProductos ap = new ArreglosProductos();
	
	 private void inicializarDatos() {
	// Definimos las categorías y sus productos
		 productosPorCategoria = new HashMap<>();
		 productosPorCategoria.put("Herramientas Electricas", new String[] {"Cortadoras", "Esmeril", "Hidrovaladoras", "Martillos", "Pistolas de calor", "Sierras", "Sopladoras", "Taladros", "Tronzadoras"});
		 productosPorCategoria.put("Herramientas Inalámbricas", new String[] {"Atornilladores", "Llaves", "Taladro atornillador"});
		 productosPorCategoria.put("Accesorios", new String[] {"Brocas", "Cinceles", "Discos"});
		 
		 for(String categoria : productosPorCategoria.keySet()) {
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
		Productos nuevo = new Productos(leerCodigo(), leerCategoria(), leerProducto(), leerPrecio());
		ap.adicionar(nuevo);
		listar();
		limpiar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int fila = tblProductos.getSelectedRow();
		
        if (fila == -1) {
            mensaje("Seleccione una fila para modificar");
            return;
        }

        try {
            int codigo = leerCodigo();
            Productos x = ap.buscarProductos(codigo);
            if (x != null) {
                String categoria = leerCategoria();
                String producto = leerProducto();
                try {
                    double precio = leerPrecio();
                    x.setCategoria(categoria);
                    x.setProducto(producto);
                    x.setPrecio(precio);
                    ap.actualizarArchivo();
                    listar();
                    limpiar();
                    mensaje("Producto modificado correctamente");
                } catch (Exception ex) {
                    mensaje("Ingrese un precio válido");
                    txtPrecio.requestFocus();
                }
            } else {
                mensaje("El código ingresado no existe");
                txtCodigo.requestFocus();
            }
        } catch (Exception ex) {
            mensaje("Código inválido");
            txtCodigo.requestFocus();
        }
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int fila=tblProductos.getSelectedRow();
		
		if(fila==-1) {
			mensaje("Seleccione fila a eliminar");
			return;
		}
		
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
		if (respuesta==JOptionPane.YES_OPTION){
			Productos p = ap.obtener(fila);
			ap.eliminar(p);
			listar();
			limpiar();
		}
	}
	
//  M�todos tipo void (con parametros)
	 void listar() {
		 modeloProducto.setRowCount(0);
		 for (int i = 0; i < ap.tamanio(); i++) {
			Object[] fila = {
					ap.obtener(i).getCodigo(),
					ap.obtener(i).getCategoria(),
					ap.obtener(i).getProducto(),
					ap.obtener(i).getPrecio(),
			};
			modeloProducto.addRow(fila);
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
	 
	 void error(String s, JTextField txt) {	
		 mensaje(s);
		 txt.setText("");
		 txt.requestFocus();
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
}
