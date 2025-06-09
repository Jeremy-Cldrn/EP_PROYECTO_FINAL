package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DialogIntegrantes extends JDialog {

	private static final long serialVersionUID = 1L;

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
		setBounds(100, 100, 454, 326);

	}

}
