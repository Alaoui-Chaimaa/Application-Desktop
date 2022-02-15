package projet;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class Visite extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private Connection con;
	private String url;
	private String n,m,mo,d_c,ob,t,c1,c2,c3,gs;
	private int mt,tmp,fc;
	private float p,ta,gly,cho,ten;
	private JLabel lblNewLabel_4;
	

	/**
	 * Create the panel.
	 */
	public Visite() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nouvelle Visite");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(538, 0, 330, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9tails de Visite:");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 66, 158, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 101, 79, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 126, 206, 28);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblMaladie = new JLabel("Maladie:");
		lblMaladie.setForeground(Color.BLACK);
		lblMaladie.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaladie.setBackground(SystemColor.menu);
		lblMaladie.setBounds(256, 98, 92, 21);
		add(lblMaladie);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(256, 126, 206, 28);
		add(textField_1);
		
		JLabel lblMotif = new JLabel("Motif:");
		lblMotif.setForeground(Color.BLACK);
		lblMotif.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMotif.setBackground(SystemColor.menu);
		lblMotif.setBounds(487, 98, 92, 21);
		add(lblMotif);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(487, 126, 206, 28);
		add(textField_2);
		
		
		JLabel lblObservations = new JLabel("Observations:");
		lblObservations.setForeground(Color.BLACK);
		lblObservations.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObservations.setBackground(SystemColor.menu);
		lblObservations.setBounds(10, 231, 158, 21);
		add(lblObservations);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 263, 300, 206);
		add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Traitement Prescrit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(373, 231, 206, 21);
		add(lblNewLabel_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(373, 263, 300, 206);
		add(textArea_1);
		
		JLabel lblDateDeConsultation = new JLabel("Date de consultation:");
		lblDateDeConsultation.setForeground(Color.BLACK);
		lblDateDeConsultation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateDeConsultation.setBackground(SystemColor.menu);
		lblDateDeConsultation.setBounds(10, 165, 183, 21);
		add(lblDateDeConsultation);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 192, 206, 28);
		add(textField_3);
		
		
		JLabel lblMontantPayer = new JLabel("Montant \u00E0 payer:");
		lblMontantPayer.setForeground(Color.BLACK);
		lblMontantPayer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMontantPayer.setBackground(SystemColor.menu);
		lblMontantPayer.setBounds(256, 171, 183, 21);
		add(lblMontantPayer);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(256, 196, 206, 28);
		add(textField_4);
		
		
		JLabel lblConstantes = new JLabel("Constantes:");
		lblConstantes.setForeground(new Color(32, 178, 170));
		lblConstantes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConstantes.setBounds(718, 63, 158, 21);
		add(lblConstantes);
		
		JLabel lblPoidskg = new JLabel("Poids (Kg):");
		lblPoidskg.setForeground(Color.BLACK);
		lblPoidskg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPoidskg.setBackground(SystemColor.menu);
		lblPoidskg.setBounds(718, 98, 92, 21);
		add(lblPoidskg);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(718, 128, 92, 24);
		add(textField_5);
		textField_5.setColumns(10);
		
		
		JLabel lblTaillecm = new JLabel("Taille (cm):");
		lblTaillecm.setForeground(Color.BLACK);
		lblTaillecm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTaillecm.setBackground(SystemColor.menu);
		lblTaillecm.setBounds(861, 98, 92, 21);
		add(lblTaillecm);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(861, 130, 92, 24);
		add(textField_6);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe sanguin:");
		lblGroupeSanguin.setForeground(Color.BLACK);
		lblGroupeSanguin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGroupeSanguin.setBackground(SystemColor.menu);
		lblGroupeSanguin.setBounds(718, 171, 121, 21);
		add(lblGroupeSanguin);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(718, 200, 121, 24);
		add(textField_7);
		
		
		JLabel lblTensionmmhg = new JLabel("Tension (mmHg):");
		lblTensionmmhg.setForeground(Color.BLACK);
		lblTensionmmhg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTensionmmhg.setBackground(SystemColor.menu);
		lblTensionmmhg.setBounds(861, 171, 146, 21);
		add(lblTensionmmhg);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(861, 196, 121, 24);
		add(textField_8);
		
		JLabel lblTempc = new JLabel("Temp(\u00B0C):");
		lblTempc.setForeground(Color.BLACK);
		lblTempc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTempc.setBackground(SystemColor.menu);
		lblTempc.setBounds(718, 247, 121, 21);
		add(lblTempc);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(718, 279, 121, 24);
		add(textField_9);
		
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(861, 279, 121, 24);
		add(textField_10);
		
		JLabel lblGlycmiegl = new JLabel("Glyc\u00E9mie (g/l):");
		lblGlycmiegl.setForeground(Color.BLACK);
		lblGlycmiegl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGlycmiegl.setBackground(SystemColor.menu);
		lblGlycmiegl.setBounds(861, 247, 146, 21);
		add(lblGlycmiegl);
		
		JLabel lblCholstmmoll = new JLabel("Chol\u00E9st (mmol/l):");
		lblCholstmmoll.setForeground(Color.BLACK);
		lblCholstmmoll.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCholstmmoll.setBackground(SystemColor.menu);
		lblCholstmmoll.setBounds(718, 325, 146, 21);
		add(lblCholstmmoll);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(718, 357, 121, 24);
		add(textField_11);
		
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(861, 359, 121, 24);
		add(textField_12);
		
		
		JLabel lblFrquenceCardiaquebpm = new JLabel("FC (bpm):");
		lblFrquenceCardiaquebpm.setForeground(Color.BLACK);
		lblFrquenceCardiaquebpm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFrquenceCardiaquebpm.setBackground(SystemColor.menu);
		lblFrquenceCardiaquebpm.setBounds(861, 325, 173, 21);
		add(lblFrquenceCardiaquebpm);
		
		JButton btnNewButton = new JButton("Valider la visite");
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(718, 404, 306, 41);
		add(btnNewButton);
		
		 lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(718, 466, 306, 34);
		add(lblNewLabel_4);
		btnNewButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						n=textField.getText().toString();
						m=textField_1.getText().toString();
						mo=textField_2.getText().toString();
						ob=textArea.getText().toString();
						t=textArea_1.getText().toString();
						d_c=textField_3.getText().toString();
						c1=textField_4.getText().toString();
						mt=Integer.parseInt(c1);
						p=Float.parseFloat(textField_5.getText().toString());
						ta=Float.parseFloat(textField_6.getText().toString());
						ten=Float.parseFloat(textField_8.getText().toString());
						c2=textField_9.getText().toString();
						tmp=Integer.parseInt(c2);
						gly=Float.parseFloat(textField_10.getText().toString());
						cho=Float.parseFloat(textField_11.getText().toString());
						c3=textField_12.getText().toString();
						fc=Integer.parseInt(c3);
						gs=textField_7.getText().toString();
						
						
						AjoutVisite(n,m,mo,d_c,mt,ob,t,p,ta,ten,tmp,gly,cho,fc,gs);
						lblNewLabel_4.setText("Visite ajoutée");
						
					}
			
				});

	}
	public void connectionBD(){
		try{
			url = new String("jdbc:mysql://localhost/projet_cabinet?autoReconnect=true&useSSL=false");

			con = DriverManager.getConnection(url,"root","");
			System.out.println("CONNEXION ETABLIE");

		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
	public void connectionBDClose(){
		try {
			con.close();
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}
	public void AjoutVisite(String n,String m,String mo,String d_c,int mt,String ob,String t,float p,float ta,float ten,int tmp,float gly,float cho,int fc,String gs)
	{
		connectionBD();
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate("INSERT INTO visite (nom_patient,maladie,motif,date_cons,montant,observations,traitement,poids,taille,tension,temp,glycemie,cholest,fc,groupe_s) VALUES('"+n+"','"+m+"','"+mo+"','"+d_c+"',"+mt+",'"+ob+"','"+t+"',"+p+","+ta+","+ten+","+tmp+","+gly+","+cho+","+fc+",'"+gs+"');");
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		connectionBDClose();
	}
}
