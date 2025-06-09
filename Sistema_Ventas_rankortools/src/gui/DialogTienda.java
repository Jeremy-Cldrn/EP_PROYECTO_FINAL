package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DialogTienda extends JDialog {

	private static final long serialVersionUID = 1L;

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
		setBounds(100, 100, 454, 326);

	}

}
