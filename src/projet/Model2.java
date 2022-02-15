package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Model2 {
	private Connection con;
	private String url;
	private Object patients[][];
	private String nomC[] = {"code","nom","prenom","sexe","date_naissance","adresse","tel","email","date_inscription"};
	public Model2(){
		this.afficherPatients();
	}
	
	public Object[][] getPatients(){
		return patients;
	}
	public String[] getNomsColonnes(){
		return nomC;
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
	public void afficherPatients(String query){
		connectionBD();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsMeta= rs.getMetaData();
			rs.last();
		patients= new Object[rs.getRow()][rsMeta.getColumnCount()];
			  rs.beforeFirst();
			int cpt=0;
			while(rs.next()) {
				patients[cpt][0] = rs.getString(1);patients[cpt][1] = rs.getString(2);
				patients[cpt][2] = rs.getString(3);patients[cpt][3] = rs.getString(4);
				patients[cpt][4] = rs.getDate(5);patients[cpt][5] = rs.getString(6);
				patients[cpt][6] = rs.getString(7);patients[cpt][7] = rs.getString(8);
				patients[cpt][8] = rs.getDate(9);
			    cpt++;
			}
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		connectionBDClose();
	}
	public void afficherPatients()
	{
		afficherPatients("select * from patient;");
	}
}
