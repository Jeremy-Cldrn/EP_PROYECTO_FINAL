package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DialogIntegrantes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblFondo;
	private JLabel lblIntegrantes;
	private JLabel lblIntegrante1;
	private JLabel lblIntegrante2;
	private JLabel lblIntegrante3;
	private JLabel lblIntegrante4;
	private JLabel lblIntegrante5;
	private JLabel lblGrupoC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogIntegrantes dialog = new DialogIntegrantes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogIntegrantes() {
		setTitle("Acerca de Integrantes");
		setBounds(100, 100, 595, 474);
		getContentPane().setLayout(null);
		
		// Cargar imagen para lblFondo
		ImageIcon iconFondo = new ImageIcon("imagenes/FondoIntegrantes.jpg");
		
		lblIntegrante1 = new JLabel("Sophia Caroline Hernández Palomino ");
		lblIntegrante1.setForeground(Color.WHITE);
		lblIntegrante1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrante1.setBounds(156, 120, 267, 34);
		getContentPane().add(lblIntegrante1);
		
		lblIntegrantes = new JLabel("INTEGRANTES");
		lblIntegrantes.setForeground(Color.WHITE);
		lblIntegrantes.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblIntegrantes.setBounds(182, 25, 215, 24);
		getContentPane().add(lblIntegrantes);
		
		lblIntegrante2 = new JLabel(" Jeremy Calderon Calderon Chavez ");
		lblIntegrante2.setForeground(Color.WHITE);
		lblIntegrante2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrante2.setBounds(156, 179, 267, 34);
		getContentPane().add(lblIntegrante2);
		
		lblIntegrante3 = new JLabel("Alexis Castro Olivares");
		lblIntegrante3.setForeground(Color.WHITE);
		lblIntegrante3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrante3.setBounds(205, 236, 168, 34);
		getContentPane().add(lblIntegrante3);
		
		lblIntegrante5 = new JLabel("Edith Jennyfer Chavez Tello ");
		lblIntegrante5.setForeground(Color.WHITE);
		lblIntegrante5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrante5.setBounds(189, 293, 208, 34);
		getContentPane().add(lblIntegrante5);
		
		lblIntegrante4 = new JLabel("Martin Wilfredo Condori Mamani ");
		lblIntegrante4.setForeground(Color.WHITE);
		lblIntegrante4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIntegrante4.setBounds(171, 353, 241, 34);
		getContentPane().add(lblIntegrante4);
		
		lblGrupoC = new JLabel("Grupo C");
		lblGrupoC.setForeground(Color.WHITE);
		lblGrupoC.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblGrupoC.setBounds(226, 76, 126, 33);
		getContentPane().add(lblGrupoC);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 579, 435);
		getContentPane().add(lblFondo);
		// Escalar imagen al tamaño del JLabel lblFondo
		Image imgFondo = iconFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH);
		// Asignar imagen al JLabel lblFondo
		lblFondo.setIcon(new ImageIcon(imgFondo));

	}
}
