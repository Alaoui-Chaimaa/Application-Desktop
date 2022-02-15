package projet;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Agenda extends JPanel {
	private Connection con;
	private String url;
	private Object rdvs[][];
	private String nomC[] = {"Id_Rdv","Nom_Patient","Tel_Patient","Email_Patient","Date","Heure","But_Consultation"};
	private JRadioButton rdbtnParJour,rdbtnParSemaine;

	private JPanel panel_2 ;
	private Date date,date_1;
  
	/**
	 * Create the panel.
	 */
	public Agenda() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		add(panel);
		panel.setLayout(null);
		ButtonGroup B=new ButtonGroup();
		
		JLabel lblNewLabel = new JLabel("Consulter l'agenda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(490, 0, 271, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 695, 80);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Consulter votre agenda par:");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setBounds(0, 0, 247, 25);
		panel_1.add(lblNewLabel_1);
		
	 rdbtnParJour = new JRadioButton("Par jour");
		rdbtnParJour.setBounds(10, 27, 109, 23);
		panel_1.add(rdbtnParJour);
		
	
		 rdbtnParSemaine = new JRadioButton("Par semaine");
		rdbtnParSemaine.setBounds(10, 53, 109, 23);
		panel_1.add(rdbtnParSemaine);
		B.add(rdbtnParJour);
		B.add(rdbtnParSemaine);
		
		 panel_2 = new JPanel();
		panel_2.setBounds(0, 134, 1256, 413);
		add(panel_2);
		panel_2.setLayout(null);
	java.util.Date date_s=new java.util.Date();
	java.util.Date date_s1=new java.util.Date();
	date=convert(date_s);
	DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar=Calendar.getInstance();
	calendar.add(Calendar.DATE, 7);
	date_s1=calendar.getTime();
	date_1=convert(date_s1);
	
		rdbtnParJour.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						afficherRdv(date);
						JTable table=new JTable(getRdvs(),getNomsC());
						
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(33, 0, 1170, 402);
						panel_2.add(scrollPane);

						panel_2.setVisible(true);
					}
			
				});
		rdbtnParSemaine.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				afficherRdvSemaine(date,date_1);
				JTable table=new JTable(getRdvs(),getNomsC());
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(33, 0, 1170, 402);
				panel_2.add(scrollPane);

				panel_2.setVisible(true);
				
			}
	
		});
		
		panel_2.setVisible(false);

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
	public Object[][] getRdvs(){
		return rdvs;
	}
	public String[] getNomsC(){
		return nomC;
	}
	public void afficherRdvs(String query){
		connectionBD();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsMeta= rs.getMetaData();
			rs.last();
		rdvs= new Object[rs.getRow()][rsMeta.getColumnCount()];
			  rs.beforeFirst();
			int cpt=0;
			while(rs.next()) {
				rdvs[cpt][0] = rs.getString(1);rdvs[cpt][1] = rs.getString(2);
				rdvs[cpt][2] = rs.getString(3);rdvs[cpt][3] = rs.getString(4);
				rdvs[cpt][4] = rs.getString(5);rdvs[cpt][5] = rs.getString(6);
				rdvs[cpt][6] = rs.getString(7);
				
				
			    cpt++;
			}
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		connectionBDClose();
	}
	public void afficherRdv(Date d)
	{
		afficherRdvs("select * from rendez_vous where date='"+d+"';");
	}
	public void afficherRdvSemaine(Date date_1,Date date_2)
	{
		afficherRdvs("select * from rendez_vous where date between '"+date_1+"' and '"+date_2+"';");
	}
	private static java.sql.Date convert(java.util.Date uDate)
	{
		java.sql.Date sDate= new java.sql.Date(uDate.getTime());
		return sDate;
	}
	
}
