package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Modifier_Patient extends JFrame implements ActionListener {

	
	private JPanel Modifier;
	private JLabel Code,Nom,Prenom,Sexe,AnneeN,Adresse,Tel,Email,DateIns,l1,l2,l3;
	private JTextField  code_m,nom_m,prenom_m,anneeN_m,adresse_m,tel_m,email_m,dateIns_m;
	private JComboBox sexe_m;
	private JButton modify,annuler_m;
	private Connection con;
	private String url;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier_Patient frame = new Modifier_Patient();
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
	public Modifier_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 461);
		Modifier= new JPanel();
		Modifier.setLayout(new GridLayout(12,2));
		Modifier.setBounds(20, 100, 400, 300);
setContentPane(Modifier);
l2=new JLabel("Modifier Infos Patient");
l2.setForeground(new Color(0, 0, 128));
l2.setFont(new Font("Tahoma", Font.BOLD, 17));
l3=new JLabel("");
		Code= new JLabel("Code Patient: ");
		code_m= new JTextField(10);
		Nom = new JLabel("Nom: ");
		nom_m = new JTextField(10);
		Prenom = new JLabel("Prénom : ");
		prenom_m = new JTextField(10);
		Sexe=new JLabel("Sexe: ");
		sexe_m=new JComboBox();
		sexe_m.addItem("F");
		sexe_m.addItem("M");
		AnneeN = new JLabel("Date de naissance (AAAA-MM-JJ): ");
		anneeN_m = new JTextField(10);
		Adresse = new JLabel("Adresse: ");
		adresse_m = new JTextField(30);
		Tel = new JLabel("Tel: ");
		tel_m = new JTextField(10);
		Email = new JLabel("Email: ");
		email_m = new JTextField(10);
		DateIns = new JLabel("Date d'inscription (AAAA-MM-JJ): ");
		dateIns_m = new JTextField(10);
		modify= new JButton("Modifier");
		annuler_m = new JButton("Annuler");
		Modifier.add(l2);Modifier.add(l3);
		Modifier.add(Code);Modifier.add(code_m);
		Modifier.add(Nom);Modifier.add(nom_m);
		Modifier.add(Prenom);Modifier.add(prenom_m);
		Modifier.add(Sexe);Modifier.add(sexe_m);
		Modifier.add(AnneeN);Modifier.add(anneeN_m);
		Modifier.add(Adresse);Modifier.add(adresse_m);
		Modifier.add(Tel);Modifier.add(tel_m);
		Modifier.add(Email);Modifier.add(email_m);
		Modifier.add(DateIns);Modifier.add(dateIns_m);
		Modifier.add(modify);Modifier.add(annuler_m);
		modify.addActionListener(this);
		annuler_m.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
	
		});
		l1=new JLabel("");
		Modifier.add(l1);
		
		
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
	public void ModifierPatient(String c,String n,String p,String s,String date_n,String a,String t,String em,String date_ins)
	{
		connectionBD();
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate("UPDATE patient SET nom='"+n+"',prenom='"+p+"',sexe='"+s+"',date_naissance='"+date_n+"',adresse='"+a+"',tel='"+t+"',email='"+em+"',date_inscription='"+date_ins+"'"
					+ "WHERE code='"+c+"';");
			
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		connectionBDClose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source==modify)
		{
			
			if(code_m.getText().toString().contentEquals("")||nom_m.getText().toString().contentEquals("")||
					prenom_m.getText().toString().contentEquals("")||sexe_m.getSelectedItem().toString().contentEquals("")||
					anneeN_m.getText().toString().contentEquals("")||adresse_m.getText().toString().contentEquals("")||
					tel_m.getText().toString().contentEquals("")||email_m.getText().toString().contentEquals("")||
					dateIns_m.getText().toString().contentEquals(""))
			{
				JOptionPane.showMessageDialog(null,"Aucun champ ne doit etre vide ","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			else if(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$",email_m.getText().toString().toLowerCase().toLowerCase())==false)
			{
           			JOptionPane.showMessageDialog(null,"Adresse mail non valide , Veuillez respecter la syntaxe d'email ","Problème de saisie",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				V_Liste_Patients vue=new V_Liste_Patients(new Model2());
			ModifierPatient(code_m.getText().toString(),nom_m.getText().toString(),prenom_m.getText().toString(),sexe_m.getSelectedItem().toString(),
					anneeN_m.getText().toString(),adresse_m.getText().toString(),tel_m.getText().toString(),email_m.getText().toString(),
					dateIns_m.getText().toString());
			l1.setText("Informations modifiées");
			vue.actualiserTable(new Model2());
			}
		}
	}

}
