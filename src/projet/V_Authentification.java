package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class V_Authentification extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model1 m=new Model1();
					V_Authentification frame = new V_Authentification(m);
					
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
	public V_Authentification(Model1 m) {
	
		C_Authentification c=new C_Authentification(this,m);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 346);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acc\u00E8s Utilisateur");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(180, 11, 186, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Utilisateur:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(72, 68, 118, 23);
		contentPane.add(lblNewLabel_1);
		
	    comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("CheckBox.background"));
		comboBox.setBounds(180, 68, 222, 26);
		m.Utilisateurs(comboBox);

		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(72, 121, 118, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie:");
		lblCatgorie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCatgorie.setBounds(72, 171, 118, 23);
		contentPane.add(lblCatgorie);
		
	    comboBox_1 = new JComboBox();
		comboBox_1.setBounds(180, 168, 222, 32);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("Medecin");
		comboBox_1.addItem("Secretaire");
		
	    btnNewButton = new JButton("Se connecter");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setBounds(212, 244, 144, 32);
		btnNewButton.addActionListener(c);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 118, 222, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\poste\\Documents\\PH3.jpg"));
		lblNewLabel_3.setBounds(0, 0, 561, 307);
		contentPane.add(lblNewLabel_3);
	}
	public String getMotdePasse()
	{
		return passwordField.getText();
	}
	public String getUtilisateur()
	{
		return comboBox.getSelectedItem().toString();
	}
	public String getCategorie()
	{
		return comboBox_1.getSelectedItem().toString();
	}
	public JButton getBtnConnection()
	{
		return btnNewButton;
	}
}
