package gui;
	
import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosClientes;
import clases.Clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogClientes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni, txtNombres, txtApellido, txtDireccion, txtTelefono;
	private JLabel lblMantenimientoClientes, lblDni, lblNombres, lblApellidos, lblDireeccin, lblTelefono;
	private JTable tblClientes;
	private JScrollPane scrollPane;
	private DefaultTableModel modeloClientes;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogClientes dialog = new DialogClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogClientes() {
		setTitle("Clientes");
		setBounds(100, 100, 637, 450);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblMantenimientoClientes = new JLabel("MANTENIMIENTO CLIENTES");
		lblMantenimientoClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoClientes.setBounds(0, 0, 623, 35);
		lblMantenimientoClientes.setForeground(Color.WHITE);
		lblMantenimientoClientes.setBackground(Color.BLACK);
		lblMantenimientoClientes.setOpaque(true);
		contentPane.add(lblMantenimientoClientes);

		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(37, 65, 100, 19);
		contentPane.add(lblDni);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombres.setBounds(37, 94, 100, 19);
		contentPane.add(lblNombres);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(37, 123, 100, 19);
		contentPane.add(lblApellidos);

		lblDireeccin = new JLabel("Dirección:");
		lblDireeccin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireeccin.setBounds(37, 152, 100, 19);
		contentPane.add(lblDireeccin);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(37, 181, 100, 19);
		contentPane.add(lblTelefono);

		txtDni = new JTextField();
		txtDni.setBounds(127, 67, 96, 19);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setBounds(127, 96, 245, 19);
		contentPane.add(txtNombres);

		txtApellido = new JTextField();
		txtApellido.setBounds(127, 125, 245, 19);
		contentPane.add(txtApellido);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(127, 154, 281, 19);
		contentPane.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(127, 183, 147, 19);
		contentPane.add(txtTelefono);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 222, 544, 164);
		contentPane.add(scrollPane);

		tblClientes = new JTable();
		scrollPane.setViewportView(tblClientes);
		
		modeloClientes = new DefaultTableModel();
		modeloClientes.addColumn("DNI");
		modeloClientes.addColumn("NOMBRES");
		modeloClientes.addColumn("APELLIDOS");
		modeloClientes.addColumn("DIRECCIÓN");
		modeloClientes.addColumn("TELÉFONO");
		tblClientes.setModel(modeloClientes);
		
		tblClientes.getSelectionModel().addListSelectionListener(e -> {
			if(!e.getValueIsAdjusting() && tblClientes.getSelectedRow() != -1) {
				int fila = tblClientes.getSelectedRow();
				if (fila == -1) {
					mensaje("Seleccione una fila para editar.");
					return;
				}
				txtDni.setText(tblClientes.getValueAt(fila, 0).toString());
				txtNombres.setText(tblClientes.getValueAt(fila, 1).toString());
				txtApellido.setText(tblClientes.getValueAt(fila, 2).toString());
				txtDireccion.setText(tblClientes.getValueAt(fila, 3).toString());
				txtTelefono.setText(tblClientes.getValueAt(fila, 4).toString());
			}
		});
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(463, 95, 118, 21);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(463, 124, 118, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(463, 152, 118, 21);
		contentPane.add(btnEliminar);
		
		listar();
	}
	
	//Declaracion Global
	ArreglosClientes ac = new ArreglosClientes();
	
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
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		adicionarClientes();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarClientes();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarClientes();
	}
	
	//Metodos tipo void (sin parametros)
	void listar() {
		modeloClientes.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Object [] fila = {
					ac.obtener(i).getDni(),
					ac.obtener(i).getNombres(),
					ac.obtener(i).getApellidos(),
					ac.obtener(i).getDireccion(),
					ac.obtener(i).getTelefono()};
			modeloClientes.addRow(fila);
		}	
	}
	
	void limpiar() {
		txtDni.setText("");
		txtNombres.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDni.requestFocus();
	}
	
	//Métodos tipo void (con parametros)
	void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
	}
	
	//Metodos que retornan valor (sin parametros)
	int leerDni() {
		return Integer.parseInt(txtDni.getText().trim());
	}
	
	String leerNombres() {
		return txtNombres.getText().toString();
	}
	
	String leerApellidos() {
		return txtApellido.getText().toString();
	}
	
	String leerDireccion() {
		return txtDireccion.getText().toString();
	}
	
	int leerTelefono() {
		return Integer.parseInt(txtTelefono.getText().trim());
	}
	
	//FUNCIONES CRUD
	private void adicionarClientes() {
		try {
			Clientes nuevo = new Clientes(leerDni(), leerNombres(), leerApellidos(), leerDireccion(), leerTelefono());
			ac.adicionar(nuevo);
			ac.actualizarArchivo();
			listar();
			limpiar();
			mensaje("Cliente registrado.");
		} catch (Exception e) {
			mensaje("Error al registrar cliente. Verifique los datos.");
		}
	}

	private void modificarClientes() {
		try {
			int dni = leerDni();
			Clientes c = ac.buscarClientes(dni);
			if (c == null) {
				mensaje("El DNI ingresado no existe.");
				return;
			}
			c.setNombres(leerNombres());
			c.setApellidos(leerApellidos());
			c.setDireccion(leerDireccion());
			c.setTelefono(leerTelefono());
			ac.actualizarArchivo();
			listar();
			limpiar();
			mensaje("Cliente modificado correctamente.");
		} catch (Exception e) {
			mensaje("Error al modificar cliente. Verifique los datos.");
		}
	}

	private void eliminarClientes() {
		int fila = tblClientes.getSelectedRow();
		if (fila == -1) {
			mensaje("Seleccione una fila a eliminar.");
			return;
		}
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			ac.eliminar(ac.obtener(fila));
			ac.actualizarArchivo();
			listar();
			limpiar();
		}
	}
}
