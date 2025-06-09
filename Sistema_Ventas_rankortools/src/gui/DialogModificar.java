package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;

public class DialogModificar extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogModificar dialog = new DialogModificar();
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
	public DialogModificar() {
		setBackground(new Color(255, 235, 205));
		setTitle("Modificar Stock");
		setBounds(100, 100, 454, 326);

	}

}
