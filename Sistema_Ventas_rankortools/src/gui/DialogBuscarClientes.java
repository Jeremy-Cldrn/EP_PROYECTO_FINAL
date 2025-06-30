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
	private DialogClientes dlgClientes;
	private JButton btnEnviar;
	private JRadioButton rdbDni, rdbApellido;
	private ButtonGroup grupoBusqueda;

	private ArreglosClientes ac = new ArreglosClientes();

	public DialogBuscarClientes(DialogClientes dlg) {
		this.dlgClientes = dlg;
		initComponents();
	}

	private void initComponents() {
		setTitle("Buscar Clientes");
		setBounds(100, 100, 610, 380);
		getContentPane().setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBuscar.setBounds(29, 31, 77, 19);
		getContentPane().add(lblBuscar);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(100, 32, 245, 19);
		getContentPane().add(txtBusqueda);
		txtBusqueda.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar.setBounds(470, 30, 100, 21);
		getContentPane().add(btnEnviar);

		rdbDni = new JRadioButton("DNI");
		rdbDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbDni.setBounds(100, 60, 60, 21);
		getContentPane().add(rdbDni);

		rdbApellido = new JRadioButton("Apellido");
		rdbApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbApellido.setBounds(160, 60, 100, 21);
		getContentPane().add(rdbApellido);

		grupoBusqueda = new ButtonGroup();
		grupoBusqueda.add(rdbDni);
		grupoBusqueda.add(rdbApellido);
		rdbApellido.setSelected(true); // por defecto

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

	private void listarClientes(String filtro) {
		modeloBuscarCliente.setRowCount(0); // Limpiar tabla

		for (int i = 0; i < ac.tamanio(); i++) {
			Clientes c = ac.obtener(i);
			boolean coincide = false;

			if (filtro.isEmpty()) {
				coincide = true;
			} else if (rdbDni.isSelected()) {
				coincide = String.valueOf(c.getDni()).contains(filtro);
			} else if (rdbApellido.isSelected()) {
				coincide = c.getApellidos().toLowerCase().contains(filtro.toLowerCase());
			}

			if (coincide) {
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
		dlgClientes.cargarClienteDesdeBusqueda(clientes);
		dispose();
	}
}
