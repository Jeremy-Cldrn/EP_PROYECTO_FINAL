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
import java.awt.Color;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnProductos;
	private JMenu mnVentas;
	private JMenu mnAcercaDe;
	private JMenu mnAyuda;
	private JMenuItem mntmTienda;
	private JMenuItem mntmIntegrantes;
	private JMenuItem mntmVentasDia;
	private JMenuItem mntmSalir;
	private JMenuItem mntnConsultar;
	private JMenuItem mntnModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmIngresarSolicitud;
	private JMenuItem mntmReporteVentas;
	private JLabel lblFondo;

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
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAyuda);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAyuda.add(mntmSalir);
		
		mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnProductos);
		
		mntnConsultar = new JMenuItem("Consultar Stock");
		mntnConsultar.addActionListener(this);
		mntnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntnConsultar);
		
		mntnModificar = new JMenuItem("Modificar Stock");
		mntnModificar.addActionListener(this);
		mntnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntnModificar);
		
		mntmListar = new JMenuItem("Listar Stock");
		mntmListar.addActionListener(this);
		mntmListar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnVentas);
		
		mntmIngresarSolicitud = new JMenuItem("Ingresar solicitud");
		mntmIngresarSolicitud.addActionListener(this);
		mntmIngresarSolicitud.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmIngresarSolicitud);
		
		mntmReporteVentas = new JMenuItem("Reporte de ventas");
		mntmReporteVentas.addActionListener(this);
		mntmReporteVentas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmReporteVentas);
		
		mnAcercaDe = new JMenu("Acerca de");
		mnAcercaDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAcercaDe);
		
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
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntnModificar) {
			actionPerformedMntnModificar(e);
		}
		if (e.getSource() == mntnConsultar) {
			actionPerformedMntnConsultar(e);
		}
		if (e.getSource() == mntmIngresarSolicitud) {
			actionPerformedMntmIngresarSolicitud(e);
		}
		if (e.getSource() == mntmReporteVentas) {
			actionPerformedMntmReporteVentas(e);
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
	protected void actionPerformedMntnConsultar(ActionEvent e) {
		DialogConsultar dC = new DialogConsultar();
		dC.setLocationRelativeTo(dC);
		dC.setVisible(true);
	}
	protected void actionPerformedMntnModificar(ActionEvent e) {
		DialogModificar dM = new DialogModificar();
		dM.setLocationRelativeTo(dM);
		dM.setVisible(true);
	}
	protected void actionPerformedMntmListar(ActionEvent e) {
		DialogListar dL = new DialogListar();
		dL.setLocationRelativeTo(dL);
		dL.setVisible(true);
	}
	protected void actionPerformedMntmIngresarSolicitud(ActionEvent e) {
		DialogIngresarSolicitud dIngresarSol = new DialogIngresarSolicitud();
		dIngresarSol.setLocationRelativeTo(dIngresarSol);
		dIngresarSol.setVisible(true);
	}
	protected void actionPerformedMntmReporteVentas(ActionEvent e) {
		DialogReporteVentas dReporteV = new DialogReporteVentas();
		dReporteV.setLocationRelativeTo(dReporteV);
		dReporteV.setVisible(true);
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
}
