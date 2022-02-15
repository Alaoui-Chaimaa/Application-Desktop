package projet;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JRadioButton;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Statistiques extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton rdbtnNewRadioButton,rdbtnParAnne,rdbtnParMois,rdbtnParMaladie;
	private JLabel lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5;
	private JDateChooser dateChooser;
	private JButton btnNewButton;
	private Connection con;
	private String url;
	private java.util.Date date_choisie;
	private Date d_choisie;


	/**
	 * Create the panel.
	 */
	public Statistiques() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		add(panel);
		panel.setLayout(null);
		ButtonGroup btn=new ButtonGroup();
		JLabel lblNewLabel = new JLabel("Statistiques");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(505, 0, 177, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 428, 434);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Recherche par Semaine /Mois/Maladie/Ann\u00E9e:");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 412, 21);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Saisir le premier jour de la semaine:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 164, 232, 21);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(226, 164, 180, 28);
		panel_1.add(dateChooser);
		dateChooser.setVisible(false);
		
		lblNewLabel_3 = new JLabel("Saisir le mois(MM):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 218, 215, 28);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(226, 221, 86, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		lblNewLabel_4 = new JLabel("Saisir l'ann\u00E9e(AAAA):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 270, 215, 28);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 271, 86, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
	 lblNewLabel_5 = new JLabel("Saisir la maladie:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 324, 134, 28);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(226, 325, 180, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		btnNewButton = new JButton("Rechercher");
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(105, 387, 232, 36);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
	rdbtnNewRadioButton = new JRadioButton("Par semaine");
		rdbtnNewRadioButton.setBounds(6, 39, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(this);
		
		 rdbtnParAnne = new JRadioButton("Par ann\u00E9e");
		rdbtnParAnne.setBounds(10, 76, 109, 23);
		panel_1.add(rdbtnParAnne);
		rdbtnParAnne.addActionListener(this);
		 rdbtnParMois = new JRadioButton("Par mois");
		rdbtnParMois.setBounds(164, 39, 109, 23);
		panel_1.add(rdbtnParMois);
		rdbtnParMois.addActionListener(this);
		
		 rdbtnParMaladie = new JRadioButton("Par maladie");
		rdbtnParMaladie.setBounds(164, 76, 109, 23);
		panel_1.add(rdbtnParMaladie);
		btn.add(rdbtnNewRadioButton);
		btn.add(rdbtnParAnne);
		btn.add(rdbtnParMois);
		btn.add(rdbtnParMaladie);
		rdbtnParMaladie.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(438, 51, 411, 429);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre de patients:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 11, 269, 32);
		panel_2.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 54, 158, 42);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNombreDeRendezvous = new JLabel("Nombre de rendez_vous:");
		lblNombreDeRendezvous.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNombreDeRendezvous.setBounds(10, 123, 269, 32);
		panel_2.add(lblNombreDeRendezvous);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(182, 173, 158, 42);
		panel_2.add(textField_4);
		
		JLabel lblNombreDeVisites = new JLabel("Nombre de visites:");
		lblNombreDeVisites.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNombreDeVisites.setBounds(10, 237, 269, 32);
		panel_2.add(lblNombreDeVisites);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(182, 280, 158, 42);
		panel_2.add(textField_5);
	
 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		
		if(rdbtnNewRadioButton.isSelected())
		{
			lblNewLabel_2.setVisible(true);
			dateChooser.setVisible(true);
			lblNewLabel_4.setVisible(false);
			textField_1.setVisible(false);
			lblNewLabel_5.setVisible(false);
			textField_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			textField.setVisible(false);
		
		}
		if(rdbtnParAnne.isSelected())
		{
			lblNewLabel_4.setVisible(true);
			textField_1.setVisible(true);
			lblNewLabel_2.setVisible(false);
			dateChooser.setVisible(false);
			lblNewLabel_5.setVisible(false);
			textField_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			textField.setVisible(false);
		}
		if(rdbtnParMois.isSelected())
		{
			lblNewLabel_3.setVisible(true);
			textField.setVisible(true);
			lblNewLabel_4.setVisible(true);
			textField_1.setVisible(true);
			lblNewLabel_2.setVisible(false);
			dateChooser.setVisible(false);
			lblNewLabel_5.setVisible(false);
			textField_2.setVisible(false);
		}
		if(rdbtnParMaladie.isSelected())
		{
			lblNewLabel_5.setVisible(true);
			textField_2.setVisible(true);
			lblNewLabel_3.setVisible(false);
			textField.setVisible(false);
			lblNewLabel_4.setVisible(false);
			textField_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
			dateChooser.setVisible(false);
		}
		if(rdbtnParMaladie.isSelected()&&source==btnNewButton)
		{
		int n=nombre_visite(textField_2.getText().toString());
		textField_3.setText(""+n);
		textField_5.setText(""+n);
		}
		if(rdbtnParAnne.isSelected()&&source==btnNewButton)
		{
		int n=nombre_rdv_annee(Integer.parseInt(textField_1.getText().toString()));
		textField_4.setText(""+n);
		int m=nombre_patient_annee(Integer.parseInt(textField_1.getText().toString()));
		textField_3.setText(""+m);
		int k=nombre_visite_annee(Integer.parseInt(textField_1.getText().toString()));
		textField_5.setText(""+k);
	
		}
		if(rdbtnParMois.isSelected()&&source==btnNewButton)
		{
		int n=nombre_rdv_annee_m(Integer.parseInt(textField_1.getText().toString()),Integer.parseInt(textField.getText().toString()));
		textField_4.setText(""+n);
		int m=nombre_patient_annee_m(Integer.parseInt(textField_1.getText().toString()),Integer.parseInt(textField.getText().toString()));
		textField_3.setText(""+m);
		int k=nombre_visite_annee_m(Integer.parseInt(textField_1.getText().toString()),Integer.parseInt(textField.getText().toString()));
		textField_5.setText(""+k);
	
		}
		if(rdbtnNewRadioButton.isSelected()&&source==btnNewButton)
		{
			date_choisie=dateChooser.getDate();
			d_choisie=convert(date_choisie);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date_choisie);
			calendar.add(Calendar.DATE, 7);
			java.util.Date d_plus=calendar.getTime();
			Date date_plus=convert(d_plus);
		int n=nombre_rdv_semaine(d_choisie,date_plus);
		textField_4.setText(""+n);
		int k=nombre_visite_semaine(d_choisie,date_plus);
		textField_5.setText(""+k);
		int m=nombre_patient_semaine(d_choisie,date_plus);
		textField_3.setText(""+m);
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
	public int nombre_visite(String mal)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from visite";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString(2).contentEquals(mal))
				{
					n++;
				}
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_rdv_annee(int a)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date) from rendez_vous where year(date)="+a+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_patient_annee(int a)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date_inscription) from patient where year(date_inscription)="+a+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_visite_annee(int a)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date_cons) from visite where year(date_cons)="+a+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_rdv_annee_m(int m,int a)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date),month(date) from rendez_vous where year(date)="+a+" and month(date)="+m+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_patient_annee_m(int a,int m)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date_inscription),month(date_inscription) from patient where year(date_inscription)="+a+" and month(date_inscription)="+m+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_visite_annee_m(int a,int m)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select year(date_cons),month(date_cons) from visite where year(date_cons)="+a+" and month(date_cons)="+m+"";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_rdv_semaine(Date d1,Date d2)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from rendez_vous where date between '"+d1+"' and '"+d2+"' ";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_visite_semaine(Date d1,Date d2)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from visite where date_cons between '"+d1+"' and '"+d2+"' ";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	public int nombre_patient_semaine(Date d1,Date d2)
	{
		int n=0;
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from patient where date_inscription between '"+d1+"' and '"+d2+"' ";
			ResultSet rs=s.executeQuery(sql);
			rs.last();
			n=rs.getRow();
			rs.beforeFirst();
						
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
		
	}
	private static java.sql.Date convert(java.util.Date uDate)
	{
		java.sql.Date sDate= new java.sql.Date(uDate.getTime());
		return sDate;
	}



}
