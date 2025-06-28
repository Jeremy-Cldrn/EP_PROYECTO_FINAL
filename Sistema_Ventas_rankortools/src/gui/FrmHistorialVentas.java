package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrmHistorialVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblVentaDeproductos;
	private JScrollPane scr;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHistorialVentas frame = new FrmHistorialVentas();
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
	public FrmHistorialVentas() {
		setTitle("Historial de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVentaDeproductos = new JLabel("HISTORIAL DE VENTAS");
		lblVentaDeproductos.setBounds(-1, -1, 554, 34);
		lblVentaDeproductos.setOpaque(true);
		lblVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDeproductos.setForeground(Color.WHITE);
		lblVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVentaDeproductos.setBackground(Color.BLACK);
		contentPane.add(lblVentaDeproductos);
		
		scr = new JScrollPane();
		scr.setBounds(15, 42, 524, 596);
		contentPane.add(scr);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scr.setViewportView(txtS);
	}

}
