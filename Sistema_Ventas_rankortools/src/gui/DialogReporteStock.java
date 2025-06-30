package gui;

import java.awt.BorderLayout;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogReporteStock extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogReporteStock dialog = new DialogReporteStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogReporteStock() {
		setTitle("Reporte de Stock");
		setBounds(100, 100, 563, 744);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblVentaDeproductos = new JLabel("STOCK");
			lblVentaDeproductos.setOpaque(true);
			lblVentaDeproductos.setHorizontalAlignment(SwingConstants.CENTER);
			lblVentaDeproductos.setForeground(Color.WHITE);
			lblVentaDeproductos.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblVentaDeproductos.setBackground(Color.BLACK);
			lblVentaDeproductos.setBounds(0, 0, 554, 34);
			contentPanel.add(lblVentaDeproductos);
		}
		{
			JScrollPane scr = new JScrollPane();
			scr.setBounds(11, 94, 524, 596);
			contentPanel.add(scr);
			
			txtS = new JTextArea();
			txtS.setEditable(false);
			scr.setViewportView(txtS);
		}
		
		btnNewButton = new JButton("IMPRIMIR");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(198, 47, 151, 34);
		contentPanel.add(btnNewButton);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
