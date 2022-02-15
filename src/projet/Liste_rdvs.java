package projet;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Liste_rdvs extends JPanel {
	private Connection con;
	private String url;
	private Object rdvs[][];
	private String nomC[] = {"Id_Rdv","Nom_Patient","Tel_Patient","Email_Patient","Date","Heure","But_Consultation"};

	/**
	 * Create the panel.
	 */
	public Liste_rdvs() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des rendez_vous");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(486, 0, 342, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 46, 1213, 490);
		add(panel_2);
		panel_2.setLayout(null);
		afficherRdvs();
		JTable table=new JTable(getRdvs(),getNomsC());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1203, 490);
		panel_2.add(scrollPane);

		panel_2.setVisible(true);
    

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
	public void afficherRdvs()
	{
		afficherRdvs("select * from rendez_vous;");
	}
	public void AjouterRdv(String n_p,String t_p,String e_p,String date,String heure,String but_c)
	{
		connectionBD();
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate("INSERT INTO rendez_vous (nom_p,tel_p,email_p,date,heure,but_cons) VALUES('"+n_p+"','"+t_p+"','"+e_p+"','"+date+"','"+heure+"','"+but_c+"');");
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		connectionBDClose();
	}
	public int verifier_si_creneau_reserve(String date,String heure)
	{
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from rendez_vous";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString(5).contentEquals(date))
				{
					if(rs.getString(6).contentEquals(heure))
					{
						return 1;
					}
				}
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
		
	}
}