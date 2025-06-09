package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnProductos;
	private JMenu mnVentas;
	private JMenu mnAcercaDe;
	private JMenu mnAyuda;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntnConsultar;
	private JMenuItem mntnModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;

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
		setBounds(100, 100, 670, 417);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		setJMenuBar(menuBar);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAyuda);
		
		mntmNewMenuItem_3 = new JMenuItem("Salir");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAyuda.add(mntmNewMenuItem_3);
		
		mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnProductos);
		
		mntnConsultar = new JMenuItem("Consultar Stock");
		mntnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntnConsultar);
		
		mntnModificar = new JMenuItem("Modificar Stock");
		mntnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntnModificar);
		
		mntmListar = new JMenuItem("Listar Stock");
		mntmListar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProductos.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnVentas);
		
		mntmNewMenuItem_4 = new JMenuItem("Ingresar solicitud");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Reporte de ventas");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnVentas.add(mntmNewMenuItem_5);
		
		mnAcercaDe = new JMenu("Acerca de");
		mnAcercaDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAcercaDe);
		
		mntmNewMenuItem = new JMenuItem("Tienda");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Integrantes");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Ventas del dia");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnAcercaDe.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
