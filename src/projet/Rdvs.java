package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
public class Rdvs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private Connection con;
	private String url;
	private Object rdvs[][];
	private String nomC[] = {"Id_Rdv","Nom_Patient","Tel_Patient","Email_Patient","Date","Heure","But_Consultation"};
	private Date date,date_c;
	private SimpleDateFormat sdf;
	private String s;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rdvs frame = new Rdvs();
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
	public Rdvs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des rendez_vous");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(486, 0, 342, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 466, 496);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un nouveau rendez_vous");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setBounds(112, 11, 293, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom_patient:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 53, 126, 24);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(212, 52, 244, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelpatient = new JLabel("Tel_patient:");
		lblTelpatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelpatient.setBounds(10, 104, 126, 24);
		panel_1.add(lblTelpatient);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 103, 243, 31);
		panel_1.add(textField_1);
		
		JLabel lblEmailpatient = new JLabel("Email_patient:");
		lblEmailpatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmailpatient.setBounds(10, 154, 126, 24);
		panel_1.add(lblEmailpatient);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(213, 153, 243, 31);
		panel_1.add(textField_2);
		
		JLabel lblDateconsultation = new JLabel("Date_consultation(AAAA-MM-JJ):");
		lblDateconsultation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateconsultation.setBounds(10, 207, 193, 24);
		panel_1.add(lblDateconsultation);
		
		JLabel lblHeureconsultation = new JLabel("Heure_consultation(HH:MM):");
		lblHeureconsultation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeureconsultation.setBounds(10, 269, 178, 24);
		panel_1.add(lblHeureconsultation);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(213, 267, 243, 31);
		panel_1.add(textField_4);
		
		JLabel lblButconsultation = new JLabel("But_consultation:");
		lblButconsultation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblButconsultation.setBounds(10, 334, 142, 24);
		panel_1.add(lblButconsultation);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(212, 335, 244, 93);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String n_p=textField.getText().toString();
				String t_p=textField_1.getText().toString();
				String e_p=textField_2.getText().toString();
				String heure=textField_4.getText().toString();
				String but_cons=textArea.getText().toString();
				
				date=dateChooser.getDate();
				sdf=new SimpleDateFormat("yyyy-MM-dd");
				
			    s=sdf.format(date);
			  
			
			  if(n_p.contentEquals("")||t_p.contentEquals("")||e_p.contentEquals("")||heure.contentEquals("")||but_cons.contentEquals(""))
				{
					JOptionPane.showMessageDialog(null,"Aucun champ ne doit etre vide" ,"Erreur",JOptionPane.ERROR_MESSAGE);
				}
				else if(Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$",e_p.toLowerCase())==false)
				{
	           			JOptionPane.showMessageDialog(null,"Adresse mail non valide , Veuillez respecter la syntaxe d'email ","Problème de saisie",JOptionPane.ERROR_MESSAGE);	
				}		
				else if(verifier_si_creneau_reserve(s,heure)==1)
				{
					JOptionPane.showMessageDialog(null,"Ce creneau est deja reserve veuillez choisir un autre ","Erreur",JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
					AjouterRdv(n_p,t_p,e_p,s,heure,but_cons);
					JOptionPane.showMessageDialog(null,"Rendez_vous ajouté" ,"Message",JOptionPane.INFORMATION_MESSAGE);
				}
			
				  
			
				}
			
		});
	
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(212, 454, 244, 31);
		panel_1.add(btnNewButton);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(212, 207, 244, 31);
		panel_1.add(dateChooser);
	    dateChooser.setDateFormatString("yyyy-MM-dd");
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(476, 46, 763, 490);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		afficherRdvs();
		JTable table=new JTable(getRdvs(),getNomsC());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 760, 490);
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
	