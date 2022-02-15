package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import java.sql.ResultSetMetaData;

public class Model1 {
	private Connection con;
	private String url;
	public void connectionBD(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
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
	public void Utilisateurs(JComboBox c)
	{
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from utilisateur";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next())
			{
				String nom=rs.getString("nom_utilisateur").toString();
				c.addItem(nom);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public int tester_compte(String nom,String motdepasse,String categorie)
	{
		connectionBD();
		try
		{
			Statement s = con.createStatement();
			String sql="select * from utilisateur";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString(1).contentEquals(nom))
				{
					if(rs.getString(3).contentEquals(categorie))
					{
						if(rs.getString(2).contentEquals(motdepasse))
						{
							return 1;
						}
						else
						{
							return 0;
						}
					}
				}
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return -1;
		
	}
}
