package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosClientes;
import clases.Clientes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogBuscarClientes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable tblBuscarClts;
	private DefaultTableModel modeloBuscarCliente;
	private JButton btnEnviar;
	private DialogIngresarSolicitud dlgIngresarSolicitud;

	public DialogBuscarClientes(DialogIngresarSolicitud dialogIngresarSolicitud) {
		this.dlgIngresarSolicitud = dialogIngresarSolicitud;
		initComponents();
	}

	private void initComponents() {
		setTitle("Buscar Clientes");
		setBounds(100, 100, 610, 380);
		getContentPane().setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar por Apellidos:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBuscar.setBounds(29, 31, 162, 19);
		getContentPane().add(lblBuscar);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(201, 33, 259, 19);
		getContentPane().add(txtBusqueda);
		txtBusqueda.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar.setBounds(470, 30, 100, 21);
		getContentPane().add(btnEnviar);


		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 95, 540, 220);
		getContentPane().add(scrollPane);

		tblBuscarClts = new JTable();
		scrollPane.setViewportView(tblBuscarClts);

		modeloBuscarCliente = new DefaultTableModel();
		modeloBuscarCliente.addColumn("DNI");
		modeloBuscarCliente.addColumn("NOMBRES");
		modeloBuscarCliente.addColumn("APELLIDOS");
		modeloBuscarCliente.addColumn("DIRECCIÓN");
		modeloBuscarCliente.addColumn("TELÉFONO");
		tblBuscarClts.setModel(modeloBuscarCliente);

		listarClientes("");

		// Filtro en tiempo real
		txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				listarClientes(txtBusqueda.getText());
			}
			public void removeUpdate(DocumentEvent e) {
				listarClientes(txtBusqueda.getText());
			}
			public void changedUpdate(DocumentEvent e) {
				listarClientes(txtBusqueda.getText());
			}
		});
	}
	
	ArreglosClientes ac = new ArreglosClientes();
	
	private void listarClientes(String filtro) {
		modeloBuscarCliente.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Clientes c = ac.obtener(i);
			if(filtro.isEmpty() || c.getApellidos().toLowerCase().contains(filtro.toLowerCase())) {
				modeloBuscarCliente.addRow(new Object[] {
						c.getDni(),
						c.getNombres(),
						c.getApellidos(),
						c.getDireccion(),
						c.getTelefono()
				});
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
	}

	protected void actionPerformedBtnEnviar(ActionEvent e) {
		int fila = tblBuscarClts.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}

		int dni = Integer.parseInt(tblBuscarClts.getValueAt(fila, 0).toString());
		String nombres = tblBuscarClts.getValueAt(fila, 1).toString();
		String apellido = tblBuscarClts.getValueAt(fila, 2).toString();
		String direccion = tblBuscarClts.getValueAt(fila, 3).toString();
		int telefono = Integer.parseInt(tblBuscarClts.getValueAt(fila, 4).toString());

		Clientes clientes = new Clientes(dni, nombres, apellido, direccion, telefono);
		dlgIngresarSolicitud.cargarClienteDesdeBusqueda(clientes);
		dispose();
	}
}
