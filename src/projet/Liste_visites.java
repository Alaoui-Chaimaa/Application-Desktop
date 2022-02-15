package projet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;

public class Liste_visites extends JPanel {
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
	private Object visites[][];
	private String nomC[] = {"Nom_P","Maladie","Motif","Date","Prix","Observations","Traitement","Poids","Taille","Tension","T°","Gly","Cho","Fc","Gs"};
	private Connection con;
	private String url;
	private JTable table;
	private String n,m,mo,d_c,ob,t,c1,c2,c3,gs,mt,tmp,fc,p,ta,gly,cho,ten;
	private JPanel panel_2;
	/**
	 * Create the panel.
	 */
	public Liste_visites() {
		setLayout(null);
		afficherVisites();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1334, 41);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultations");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(523, 0, 178, 25);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 549, 496);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modification Infos Consultation");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(115, 0, 274, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom Patient:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 31, 125, 25);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 54, 164, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Maladie:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(197, 38, 72, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 54, 164, 30);
		panel_1.add(textField_1);
		
		JLabel lblMotif = new JLabel("Motif:");
		lblMotif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotif.setBounds(381, 31, 125, 25);
		panel_1.add(lblMotif);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(378, 54, 164, 30);
		panel_1.add(textField_2);
		
		JLabel lblDateDeConsultation = new JLabel("Date de consultation:");
		lblDateDeConsultation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeConsultation.setBounds(10, 95, 164, 25);
		panel_1.add(lblDateDeConsultation);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 122, 164, 30);
		panel_1.add(textField_3);
		
		JLabel lblPoidskg = new JLabel("Poids(Kg):");
		lblPoidskg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPoidskg.setBounds(197, 95, 72, 25);
		panel_1.add(lblPoidskg);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(197, 122, 72, 30);
		panel_1.add(textField_4);
		
		JLabel lblTaillecm = new JLabel("Taille(cm):");
		lblTaillecm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaillecm.setBounds(299, 95, 72, 25);
		panel_1.add(lblTaillecm);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(299, 122, 72, 30);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(401, 122, 112, 30);
		panel_1.add(textField_6);
		
		JLabel lblTensionmmhg = new JLabel("Tension(mmHg):");
		lblTensionmmhg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTensionmmhg.setBounds(401, 95, 112, 25);
		panel_1.add(lblTensionmmhg);
		
		JLabel lblTempc = new JLabel("Temp(\u00B0C):");
		lblTempc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempc.setBounds(10, 163, 112, 25);
		panel_1.add(lblTempc);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 190, 72, 30);
		panel_1.add(textField_7);
		
		JLabel lblGlycmiemmhg = new JLabel("Glyc\u00E9mie(g/l):");
		lblGlycmiemmhg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGlycmiemmhg.setBounds(115, 163, 125, 25);
		panel_1.add(lblGlycmiemmhg);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(115, 190, 93, 30);
		panel_1.add(textField_8);
		
		JLabel lblCholstmmoll = new JLabel("Chol\u00E9st(mmol/l):");
		lblCholstmmoll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCholstmmoll.setBounds(250, 163, 125, 25);
		panel_1.add(lblCholstmmoll);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(249, 190, 112, 30);
		panel_1.add(textField_9);
		
		JLabel lblFcbpm = new JLabel("FC(bpm):");
		lblFcbpm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFcbpm.setBounds(399, 163, 72, 25);
		panel_1.add(lblFcbpm);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(399, 190, 72, 30);
		panel_1.add(textField_10);
		
		JLabel lblObservations = new JLabel("Observations:");
		lblObservations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblObservations.setBounds(10, 231, 125, 25);
		panel_1.add(lblObservations);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 267, 240, 156);
		panel_1.add(textArea);
		
		JLabel lblTraitementPrescrit = new JLabel("Traitement Prescrit:");
		lblTraitementPrescrit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTraitementPrescrit.setBounds(283, 231, 164, 25);
		panel_1.add(lblTraitementPrescrit);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(272, 267, 240, 156);
		panel_1.add(textArea_1);
		
		JLabel lblMontantA = new JLabel("Montant \u00E0 payer:");
		lblMontantA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontantA.setBounds(10, 434, 125, 25);
		panel_1.add(lblMontantA);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(130, 434, 120, 30);
		panel_1.add(textField_11);
		
		JButton btnNewButton = new JButton("Valider la modification");
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(272, 441, 241, 44);
		panel_1.add(btnNewButton);
		panel_2 = new JPanel();
		panel_2.setBounds(559, 52, 743, 493);
		add(panel_2);
		panel_2.setLayout(null);
		table=new JTable(getVisites(),getNomsC());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 743, 493);
		panel_2.add(scrollPane);

		panel_2.setVisible(true);
        table.addMouseListener(new MouseListener()
        		{

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						int ligne=table.getSelectedRow();
						n=table.getModel().getValueAt(ligne, 0).toString();
						m=table.getModel().getValueAt(ligne, 1).toString();
						mo=table.getModel().getValueAt(ligne, 2).toString();
						d_c=table.getModel().getValueAt(ligne, 3).toString();
						mt=table.getModel().getValueAt(ligne, 4).toString();
						ob=table.getModel().getValueAt(ligne, 5).toString();
						t=table.getModel().getValueAt(ligne, 6).toString();
						p=table.getModel().getValueAt(ligne, 7).toString();
						ta=table.getModel().getValueAt(ligne, 8).toString();
						ten=table.getModel().getValueAt(ligne, 9).toString();
						tmp=table.getModel().getValueAt(ligne, 10).toString();
						gly=table.getModel().getValueAt(ligne, 11).toString();
						cho=table.getModel().getValueAt(ligne, 12).toString();
						fc=table.getModel().getValueAt(ligne, 13).toString();
						gs=table.getModel().getValueAt(ligne, 14).toString();
						textField.setText(n);textField_1.setText(m);textField_2.setText(mo);
						textField_3.setText(d_c);textField_4.setText(p);textField_5.setText(ta);
						textField_6.setText(ten);textField_7.setText(tmp);textField_8.setText(gly);
						textField_9.setText(cho);textField_10.setText(fc);textArea.setText(ob);
						textArea_1.setText(t);textField_11.setText(mt);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
        	
        		});
        btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifierVisite(textField.getText().toString(),textField_1.getText().toString(),textField_2.getText().toString(),
						textField_3.getText().toString(),Integer.parseInt(textField_11.getText().toString()),
						textArea.getText().toString(),textArea_1.getText().toString(),
						Float.parseFloat(textField_4.getText().toString()),Float.parseFloat(textField_5.getText().toString()),
						Float.parseFloat(textField_6.getText().toString()),Integer.parseInt(textField_7.getText().toString()),
						
						Float.parseFloat(textField_8.getText().toString()),Float.parseFloat(textField_9.getText().toString()),
						Integer.parseInt(textField_10.getText().toString()));
				actualiserTable();
				JOptionPane.showMessageDialog(null,"Cette consultation a été mis à jour" ,"Message",JOptionPane.INFORMATION_MESSAGE);
			}
        	
        });
	}
	public Object[][] getVisites(){
		return visites;
	}
	public String[] getNomsC(){
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
	public void afficherVisites(String query){
		connectionBD();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsMeta= rs.getMetaData();
			rs.last();
		visites= new Object[rs.getRow()][rsMeta.getColumnCount()];
			  rs.beforeFirst();
			int cpt=0;
			while(rs.next()) {
				visites[cpt][0] = rs.getString(1);visites[cpt][1] = rs.getString(2);
				visites[cpt][2] = rs.getString(3);visites[cpt][3] = rs.getString(4);
				visites[cpt][4] = rs.getInt(5);visites[cpt][5] = rs.getString(6);
				visites[cpt][6] = rs.getString(7);visites[cpt][7] = rs.getFloat(8);
				visites[cpt][8] = rs.getFloat(9);	visites[cpt][9] = rs.getFloat(10);
				visites[cpt][10] = rs.getInt(11);	visites[cpt][11] = rs.getFloat(12);
				visites[cpt][12] = rs.getFloat(13);	visites[cpt][13] = rs.getInt(14);
				visites[cpt][14] = rs.getString(15);
				
			    cpt++;
			}
		}
		catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		connectionBDClose();
	}
	public void afficherVisites()
	{
		afficherVisites("select * from visite;");
	}
	public void ModifierVisite(String n,String m,String mo,String d_c,int mt,String ob,String t,float p,float ta,float ten,int tmp,float gly,float cho,int fc)
	{
		connectionBD();
		try {
			Statement sta = con.createStatement();
			sta.executeUpdate("UPDATE visite SET maladie='"+m+"',motif='"+mo+"',date_cons='"+d_c+"',montant="+mt+",observations='"+ob+"',traitement='"+t+"',poids="+p+",taille="+ta+",tension="+ten+",temp="+tmp+",glycemie="+gly+",cholest="+cho+",fc="+fc+" WHERE nom_patient='"+n+"';");
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		connectionBDClose();
	}
	public void actualiserTable(){
		TableModel model = new DefaultTableModel(getVisites(),getNomsC()); 
		table.setModel(model);
		table.repaint();
		panel_2.repaint();
		panel_2.revalidate();
	}
}
