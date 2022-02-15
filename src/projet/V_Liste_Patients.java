package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V_Liste_Patients extends JPanel implements ActionListener{

	private JPanel contentPane;
	private JTable tab;
	 private JMenu mnNewMenu;
	 private JMenuItem liste_p;
	 private JMenuItem ajout_p;
	 private JMenuItem modifier_p;
	 private JMenuItem supprimer_p;
	 private JPanel table;
	 private JButton btnNewButton,btnNewButton_1,btnNewButton_2;
		
		
	 
/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					V_Liste_Patients frame = new V_Liste_Patients(new Model2());
					frame.setVisible(true);
					
				         
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public V_Liste_Patients(Model2 m) {
		C_Liste_Patients c=new C_Liste_Patients(this,m);
		
		setBounds(50, 100, 1359, 602);

		
	
		panelTable(m);
		 this.setLayout(null);
		 
		 this.add(table);
		 
		 JLabel lblNewLabel = new JLabel("Liste des patients");
		 lblNewLabel.setForeground(new Color(25, 25, 112));
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		 lblNewLabel.setBounds(537, 11, 339, 37);
		 this.add(lblNewLabel);
		 
	 btnNewButton = new JButton("Ajouter un nouveau patient");
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setBackground(new Color(25, 25, 112));
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		 btnNewButton.setBounds(128, 498, 282, 42);
		 this.add(btnNewButton);
		 btnNewButton.addActionListener(this);
		 
		  btnNewButton_1 = new JButton("Modifier Infos Patient");
		 
		 btnNewButton_1.setBackground(new Color(25, 25, 112));
		 btnNewButton_1.setForeground(new Color(255, 255, 255));
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		 btnNewButton_1.setBounds(532, 498, 257, 42);
		 this.add(btnNewButton_1);
		 btnNewButton_1.addActionListener(this);
		 
		  btnNewButton_2 = new JButton("Supprimer un patient");
		 btnNewButton_2.setForeground(new Color(255, 255, 255));
		 btnNewButton_2.setBackground(new Color(25, 25, 112));
		 btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		 btnNewButton_2.setBounds(930, 498, 257, 42);
		 this.add(btnNewButton_2);
		 btnNewButton_2.addActionListener(this);
		 
		 JLabel lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\poste\\Documents\\a6.jpg"));
		 lblNewLabel_1.setBounds(0, 0, 1359, 602);
		 add(lblNewLabel_1);
		
		
		
	   
		
		
		
table.setVisible(true);


	}
	private void panelTable(Model2 m){
		table = new JPanel();
		table.setBounds(61, 76, 1210, 389);
		tab= new JTable(m.getPatients(),m.getNomsColonnes());
		JScrollPane s = new JScrollPane(tab);
		s.setPreferredSize(new Dimension(1200,379));
		tab.getColumnModel().getColumn(0).setPreferredWidth(200);
		tab.getColumnModel().getColumn(1).setPreferredWidth(200);
		tab.getColumnModel().getColumn(2).setPreferredWidth(200);
		tab.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		tab.getColumnModel().getColumn(5).setPreferredWidth(300);
		tab.getColumnModel().getColumn(6).setPreferredWidth(200);
		tab.getColumnModel().getColumn(7).setPreferredWidth(200);
		tab.getColumnModel().getColumn(8).setPreferredWidth(200);
		table.add(s);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source==btnNewButton)
		{
			Ajouter_Patient v=new Ajouter_Patient();
			v.setVisible(true);
		}
		if(source==btnNewButton_1)
		{
			Modifier_Patient v=new Modifier_Patient();
			v.setVisible(true);
		}
		if(source==btnNewButton_2)
		{
			Supprimer_Patient v=new Supprimer_Patient();
			v.setVisible(true);
		}
	}
	public void actualiserTable(Model2 m){
		TableModel model = new DefaultTableModel(m.getPatients(),m.getNomsColonnes()); 
		tab.setModel(model);
		tab.repaint();
		table.repaint();
		table.revalidate();
	}
}

