package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class Ajouter_Patient extends JFrame implements ActionListener{


	private JPanel Ajouter;
	private JLabel Code,Nom,Prenom,Sexe,AnneeN,Adresse,Tel,Email,DateIns,l1,l2,l3;
	private JTextField  code,nom,prenom,anneeN,adresse,tel,email,dateIns;
	private JComboBox sexe;
	private JButton ajout,annuler;
	private Connection con;
	private String url;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_Patient frame = new Ajouter_Patient();
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
	public Ajouter_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 461);
		

				Ajouter= new JPanel();
				Ajouter.setLayout(new GridLayout(12,2));
				Ajouter.setBounds(20, 100, 400, 300);
				setContentPane(Ajouter);
				l2=new JLabel("Ajouter un nouveau patient");
				l2.setForeground(new Color(0, 0, 128));
				l2.setFont(new Font("Tahoma", Font.BOLD, 17));
				l3=new JLabel("");
				
				Code= new JLabel("Code: ");
				code= new JTextField(10);
				Nom = new JLabel("Nom: ");
				nom = new JTextField(10);
				Prenom = new JLabel("Prénom : ");
				prenom = new JTextField(10);
				Sexe=new JLabel("Sexe: ");
				sexe=new JComboBox();
				sexe.addItem("F");
				sexe.addItem("M");
				AnneeN = new JLabel("Date de naissance (AAAA-MM-JJ): ");
				anneeN = new JTextField(10);
				Adresse = new JLabel("Adresse: ");
				adresse = new JTextField(30);
				Tel = new JLabel("Tel: ");
				tel = new JTextField(10);
				Email = new JLabel("Email: ");
				email = new JTextField(10);
				DateIns = new JLabel("Date d'inscription (AAAA-MM-JJ): ");
				dateIns = new JTextField(10);
				ajout= new JButton("Ajouter");
				annuler = new JButton("Annuler");
				l1=new JLabel("");
				Ajouter.add(l2);Ajouter.add(l3);
				Ajouter.add(Code);Ajouter.add(code);
				Ajouter.add(Nom);Ajouter.add(nom);
				Ajouter.add(Prenom);Ajouter.add(prenom);
				Ajouter.add(Sexe);Ajouter.add(sexe);
				Ajouter.add(AnneeN);Ajouter.add(anneeN);
				Ajouter.add(Adresse);Ajouter.add(adresse);
				Ajouter.add(Tel);Ajouter.add(tel);
				Ajouter.add(Email);Ajouter.add(email);
				Ajouter.add(DateIns);Ajouter.add(dateIns);
				Ajouter.add(ajout);Ajouter.add(annuler);
				Ajouter.add(l1);
				ajout.addActionListener(this);
				annuler.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								setVisible(false);
							}
					
						});
				
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object source=e.getSource();
		if(source==ajout)
		{
			
			if(code.getText().toString().contentEquals("")||nom.getText().toString().contentEquals("")||
					prenom.getText().toString().contentEquals("")||sexe.getSelectedItem().toString().contentEquals("")||
					anneeN.getText().toString().contentEquals("")||adresse.getText().toString().contentEquals("")||
					tel.getText().toString().contentEquals("")||email.getText().toString().contentEquals("")||
					dateIns.getText().toString().contentEquals(""))
			{
				JOptionPane.showMessageDialog(null,"Aucun champ ne doit etre vide ","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			else if(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$",email.getText().toString().toLowerCase().toLowerCase())==false)
			{
           			JOptionPane.showMessageDialog(null,"Adresse mail non valide , Veuillez respecter la syntaxe d'email ","Problème de saisie",JOptionPane.ERROR_MESSAGE);	
			}else if(code_existe(code.getText().toString())==1)
			{
				JOptionPane.showMessageDialog(null,"Ce code existe déjà veuillez saisir de nouveau du patient","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				V_Liste_Patients vue=new V_Liste_Patients(new Model2());
			AjoutPatient(code.getText().toString(),nom.getText().toString(),prenom.getText().toString(),sexe.getSelectedItem().toString(),
					anneeN.getText().toString(),adresse.getText().toString(),tel.getText().toString(),email.getText().toString(),
					dateIns.getText().toString());
			l1.setText("Patient ajouté");
			vue.actualiserTable(new Model2());
			}
		}
		
		
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
	public void AjoutPatient(String c,String n,String p,String s,String date_n,String a,String t,String em,String date_ins)
	{
		connectionBD();
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate("INSERT INTO patient (code,nom,prenom,sexe,date_naissance,adresse,tel,email,date_inscription) VALUES('"+c+"','"+n+"','"+p+"','"+s+"','"+date_n+"','"+a+"','"+t+"','"+em+"','"+date_ins+"');");
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		connectionBDClose();
	}
	public int code_existe(String code)
	{
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM patient;");
	
			while(rs.next())
			{
				if(rs.getString(1).equals(code)) {
					return 1;
				}	
				
			}
			
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	}


