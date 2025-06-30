package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DialogClientes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtDni, txtNombres, txtApellido, txtDireccion, txtTelefono;
	private JLabel lblMantenimientoClientes, lblDni, lblNombres, lblApellidos, lblDireeccin, lblTelefono;
	private JButton btnAdicionar, btnModificar, btnEliminar;
	private JTable tblClientes;
	private JScrollPane scr;
	private DefaultTableModel modeloClientes;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DialogClientes dialog = new DialogClientes();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public DialogClientes() {
		setTitle("Clientes");
		setBounds(100, 100, 637, 471);
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

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(470, 94, 111, 21);
		contentPane.add(btnAdicionar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(470, 123, 111, 21);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(470, 152, 111, 21);
		contentPane.add(btnEliminar);

		scr = new JScrollPane();
		scr.setBounds(37, 222, 544, 199);
		contentPane.add(scr);

		tblClientes = new JTable();
		tblClientes.setFillsViewportHeight(true);
		modeloClientes = new DefaultTableModel();
		modeloClientes.addColumn("DNI");
		modeloClientes.addColumn("NOMBRES");
		modeloClientes.addColumn("APELLIDOS");
		modeloClientes.addColumn("DIRECCIÓN");
		modeloClientes.addColumn("TELÉFONO");
		tblClientes.setModel(modeloClientes);

		scr.setViewportView(tblClientes);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
