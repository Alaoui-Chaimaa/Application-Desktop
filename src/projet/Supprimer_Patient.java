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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Supprimer_Patient extends JFrame implements ActionListener {
private JPanel Supprimer;
	private JLabel Code_p,l1,l2,l3;
	private JTextField code_p;
private JButton sup,AnnulerS;
private Connection con;
private String url;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supprimer_Patient frame = new Supprimer_Patient();
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
	public Supprimer_Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		Supprimer= new JPanel();
		Supprimer.setLayout(new GridLayout(5,2));
		setContentPane(Supprimer);
		l1=new JLabel("Supprimer un patient");
		l1.setForeground(new Color(0, 0, 128));
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l2=new JLabel("");
		l3=new JLabel("");
		
		Code_p=new JLabel("Code Patient: ");
		code_p=new JTextField(25);
		sup= new JButton("supprimer");
		AnnulerS = new JButton("Annuler");
		Supprimer.add(l1);Supprimer.add(l2);
		Supprimer.add(Code_p);Supprimer.add(code_p);
		Supprimer.add(sup);Supprimer.add(AnnulerS);
		Supprimer.add(l3);
		sup.addActionListener(this);
		AnnulerS.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
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
	public void SupprimerPatient(String c)
	{
		connectionBD();
		try {
			Statement sts = con.createStatement();
			sts.executeUpdate("DELETE FROM patient WHERE code = '"+c+"';");
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
		if(source==sup)
		{
			if(code_existe(code_p.getText().toString())==0)
			{
				JOptionPane.showMessageDialog(null,"Ce code patient n'existe pas","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			else 
					{
				SupprimerPatient(code_p.getText().toString());
				l3.setText("Patient Supprimé");
				V_Liste_Patients vue=new V_Liste_Patients(new Model2());
				vue.actualiserTable(new Model2());
					}
		}
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
