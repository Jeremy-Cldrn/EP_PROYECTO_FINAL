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
	private JLabel lblNewLabel;
	private JLabel lblDansey;
	private JLabel lblCercadoDeLima;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
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
		
		lblNewLabel = new JLabel("Av. Guillermo");
		lblNewLabel.setBounds(70, 252, 170, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel);
		
		lblDansey = new JLabel("Dansey 925,");
		lblDansey.setBounds(70, 282, 170, 24);
		lblDansey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblDansey);
		
		lblCercadoDeLima = new JLabel("Cercado de Lima");
		lblCercadoDeLima.setBounds(70, 316, 170, 24);
		lblCercadoDeLima.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCercadoDeLima);
		
		lblNewLabel_1 = new JLabel("01-4037365");
		lblNewLabel_1.setBounds(278, 252, 170, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("(+51) 908 935 051");
		lblNewLabel_2.setBounds(278, 282, 170, 24);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("informes@rankortools.pe");
		lblNewLabel_3.setBounds(278, 317, 193, 24);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_3);
		
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
	

