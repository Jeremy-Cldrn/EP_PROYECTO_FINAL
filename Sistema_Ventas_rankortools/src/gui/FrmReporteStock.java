package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmReporteStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel blVentaDeproductos;
	private JScrollPane scr;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteStock frame = new FrmReporteStock();
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
	public FrmReporteStock() {
		setTitle("Reporte de Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		blVentaDeproductos = new JLabel("HISTORIAL DE VENTAS");
		blVentaDeproductos.setBounds(-1, -1, 554, 34);
		blVentaDeproductos.setOpaque(true);
		blVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
		blVentaDeproductos.setForeground(Color.WHITE);
		blVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		blVentaDeproductos.setBackground(Color.BLACK);
		contentPane.add(blVentaDeproductos);
		
		scr = new JScrollPane();
		scr.setBounds(15, 42, 524, 596);
		contentPane.add(scr);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scr.setViewportView(txtS);
	}

}
