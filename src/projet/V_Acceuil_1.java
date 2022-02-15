package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class V_Acceuil_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_Acceuil_1 frame = new V_Acceuil_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public V_Acceuil_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Acceuil a=new Acceuil();
		setContentPane(a);
		pack();
		setVisible(true);
	    setTitle("Acceuil");
		setBounds(0, 100, 1350,700);
	}

}
