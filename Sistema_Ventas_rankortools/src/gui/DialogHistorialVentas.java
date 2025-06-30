package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogHistorialVentas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblVentaDeproductos;
	private JScrollPane scr;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogHistorialVentas dialog = new DialogHistorialVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogHistorialVentas() {
		setTitle("Historial de Ventas");
		setBounds(100, 100, 568, 695);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblVentaDeproductos = new JLabel("HISTORIAL DE VENTAS");
		lblVentaDeproductos.setOpaque(true);
		lblVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDeproductos.setForeground(Color.WHITE);
		lblVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVentaDeproductos.setBackground(Color.BLACK);
		lblVentaDeproductos.setBounds(0, 0, 554, 34);
		contentPanel.add(lblVentaDeproductos);
		
		scr = new JScrollPane();
		scr.setBounds(14, 45, 524, 596);
		contentPanel.add(scr);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scr.setViewportView(txtS);
	}
}