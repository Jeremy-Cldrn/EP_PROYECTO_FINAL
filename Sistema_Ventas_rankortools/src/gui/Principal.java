package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenu mnAcercaDe;
	private JMenu mnArchivo;
	private JMenuItem mntmTienda;
	private JMenuItem mntmIntegrantes;
	private JMenuItem mntmVentasDia;
	private JMenuItem mntmSalir;
	private JMenuItem mntmIngresarSolicitud;
	private JLabel lblFondo;
	private JMenuItem mntmProductos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmReporteStock;
	private JMenuItem mntmHistorialVentas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Rankor Perú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 435);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimientos");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnMantenimiento);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMantenimiento.add(mntmProductos);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mntmClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMantenimiento.add(mntmClientes);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnVentas);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnReportes);
		
		mntmReporteStock = new JMenuItem("Reporte Stock");
		mntmReporteStock.addActionListener(this);
		mntmReporteStock.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnReportes.add(mntmReporteStock);
		
		mnAcercaDe = new JMenu("Acerca de");
		mnAcercaDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAcercaDe);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnArchivo);
		
		mntmIngresarSolicitud = new JMenuItem("Ingresar solicitud");
		mntmIngresarSolicitud.addActionListener(this);
		mntmIngresarSolicitud.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmIngresarSolicitud);
		
		mntmHistorialVentas = new JMenuItem("Historial Ventas");
		mntmHistorialVentas.addActionListener(this);
		mntmHistorialVentas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmHistorialVentas);
		
		
		mntmTienda = new JMenuItem("Tienda");
		mntmTienda.addActionListener(this);
		mntmTienda.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmTienda);
		
		mntmIntegrantes = new JMenuItem("Integrantes");
		mntmIntegrantes.addActionListener(this);
		mntmIntegrantes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmIntegrantes);
		
		mntmVentasDia = new JMenuItem("Ventas del dia");
		mntmVentasDia.addActionListener(this);
		mntmVentasDia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmVentasDia);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnArchivo.add(mntmSalir);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon("imagenes/principal.png");
		Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 853, 365);
		contentPane.add(lblFondo);

		/*lblFondo = new JLabel("");
		lblFondo.setBackground(Color.GRAY);
		lblFondo.setIcon(new ImageIcon("imagenes/principal.png"));
		lblFondo.setBounds(-8, -12, 763, 309);
		contentPane.add(lblFondo);*/
		
		setLocationRelativeTo(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReporteStock) {
			doMntmReporteStockActionPerformed(e);
		}
		if (e.getSource() == mntmHistorialVentas) {
			doMntmHistorialVentasActionPerformed(e);
		}
		if (e.getSource() == mntmClientes) {
			doMntmClientesActionPerformed(e);
		}
		if (e.getSource() == mntmProductos) {
			doMntmProductosActionPerformed(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmIngresarSolicitud) {
			actionPerformedMntmIngresarSolicitud(e);
		}
		if (e.getSource() == mntmTienda) {
		actionPerformedMntmTienda(e);
		}
		if (e.getSource() == mntmIntegrantes) {
			actionPerformedMntmIntegrantes(e);
		}
		if (e.getSource() == mntmVentasDia) {
			actionPerformedMntmVentasDia(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int respuesta;		
	    respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir del programa?" , "IMPORTANTE", 
		JOptionPane.YES_NO_OPTION, 2);
	    if(respuesta == 0)
		System.exit(0);
	}
	
	protected void actionPerformedMntmIngresarSolicitud(ActionEvent e) {
		DialogIngresarSolicitud dSolicitud = new DialogIngresarSolicitud();
		dSolicitud.setLocationRelativeTo(dSolicitud);
		dSolicitud.setVisible(true);
	}
	
	protected void actionPerformedMntmTienda(ActionEvent e) {
		DialogTienda dTienda = new DialogTienda();
		dTienda.setLocationRelativeTo(dTienda);
		dTienda.setVisible(true);
	}
	
	protected void actionPerformedMntmIntegrantes(ActionEvent e) {
		DialogIntegrantes dIntegrantes = new DialogIntegrantes();
		dIntegrantes.setLocationRelativeTo(dIntegrantes);
		dIntegrantes.setVisible(true);
	}
	
	protected void actionPerformedMntmVentasDia(ActionEvent e) {
		DialogVentasDia dVentaDia = new DialogVentasDia();
		dVentaDia.setLocationRelativeTo(dVentaDia);
		dVentaDia.setVisible(true);
	}
	protected void doMntmProductosActionPerformed(ActionEvent e) {
		DialogProductos dProductos =new DialogProductos();
		dProductos.setLocationRelativeTo(dProductos);
		dProductos.setVisible(true);
	}
		
	protected void doMntmClientesActionPerformed(ActionEvent e) {
		DialogClientes dClientes = new DialogClientes();
		dClientes.setLocationRelativeTo(dClientes);
		dClientes.setVisible(true);
	}
	protected void doMntmHistorialVentasActionPerformed(ActionEvent e) {
		DialogHistorialVentas dHistorialVentas = new DialogHistorialVentas();
		dHistorialVentas.setLocationRelativeTo(dHistorialVentas);
		dHistorialVentas.setVisible(true);
	}
	protected void doMntmReporteStockActionPerformed(ActionEvent e) {
		DialogReporteStock dialogReporteStock = new DialogReporteStock();
		dialogReporteStock.setLocationRelativeTo(dialogReporteStock);
		dialogReporteStock.setVisible(true);
	}
}
