package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class DialogTienda extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JLabel lblDatosContacto;
	private JLabel lblDirecicion1;
	private JLabel lblDirecicion2;
	private JLabel lblDirecicion3;
	private JLabel lblTelefono;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JLabel lblMapa;
	private JLabel lblUbicacion;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogTienda dialog = new DialogTienda();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogTienda() {
		setTitle("Acerca de TIENDA");
		setBounds(100, 100, 524, 786);
		getContentPane().setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(0, 1, 508, 179);
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setOpaque(true);
		getContentPane().add(lblLogo);

		// Cargar imagen
		ImageIcon icon = new ImageIcon("imagenes/logo.png");
		// Escalar imagen al tamaño del JLabel
		Image img = icon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		// Asignar imagen al JLabel
		lblLogo.setIcon(new ImageIcon(img));
		
		lblDatosContacto = new JLabel("Datos de Contacto");
		lblDatosContacto.setBounds(139, 203, 229, 24);
		lblDatosContacto.setFont(new Font("Tahoma", Font.BOLD, 24));
		getContentPane().add(lblDatosContacto);
		
		lblDirecicion1 = new JLabel("Av. Guillermo");
		lblDirecicion1.setBounds(70, 252, 170, 24);
		lblDirecicion1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblDirecicion1);
		
		lblDirecicion2 = new JLabel("Dansey 925,");
		lblDirecicion2.setBounds(70, 282, 170, 24);
		lblDirecicion2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblDirecicion2);
		
		lblDirecicion3 = new JLabel("Cercado de Lima");
		lblDirecicion3.setBounds(70, 316, 170, 24);
		lblDirecicion3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblDirecicion3);
		
		lblTelefono = new JLabel("01-4037365");
		lblTelefono.setBounds(278, 252, 170, 24);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblTelefono);
		
		lblCelular = new JLabel("(+51) 908 935 051");
		lblCelular.setBounds(278, 282, 170, 24);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("informes@rankortools.pe");
		lblCorreo.setBounds(278, 317, 193, 24);
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(lblCorreo);
		
		lblMapa = new JLabel("");
		lblMapa.setOpaque(true);
		lblMapa.setBackground(Color.WHITE);
		lblMapa.setBounds(0, 404, 508, 345);
		getContentPane().add(lblMapa);
		
		lblUbicacion = new JLabel("Ubicación");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUbicacion.setBounds(193, 356, 122, 24);
		getContentPane().add(lblUbicacion);
		
		// Cargar imagen para lblMapa
		ImageIcon iconMapa = new ImageIcon("imagenes/ubicacion.png");
		// Escalar imagen al tamaño del JLabel lblMapa
		Image imgMapa = iconMapa.getImage().getScaledInstance(lblMapa.getWidth(), lblMapa.getHeight(), Image.SCALE_SMOOTH);
		// Asignar imagen al JLabel lblMapa
		lblMapa.setIcon(new ImageIcon(imgMapa));
		
		
		
	}
}
	

