package projet;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.print.*;
import javax.swing.JTextArea;


public class Ordonnance extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtaaaammjj;
public JPanel panel;
private JLabel lblNewLabel_8,label,label_1;
private JButton btnNewButton,btnImprimer;
private JTextArea textArea,textArea_1;

	/**
	 * Create the panel.
	 */
	public Ordonnance() {
		setLayout(null);
		setBounds(50, 100, 1359, 602);
		JLabel lblNewLabel = new JLabel("Nouvelle Ordonnance");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(585, 11, 332, 30);
		add(lblNewLabel);
		panelOrdonnance();
	
		this.add(panel);
		
		 textArea_1 = new JTextArea();
		 textArea_1.setTabSize(15);
		textArea_1.setBounds(10, 342, 471, 175);
		panel.add(textArea_1);
		panel.setVisible(false);
		JLabel lblNewLabel_1 = new JLabel("Nom Complet du patient:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 74, 173, 30);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(359, 76, 313, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom du m\u00E9decin consultant:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 141, 195, 30);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 143, 313, 30);
		add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Date de consultation (AAAA-MM-JJ):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(38, 205, 252, 30);
		add(lblNewLabel_3);
		
		txtaaaammjj = new JTextField();
		txtaaaammjj.setToolTipText("");
		txtaaaammjj.setColumns(10);
		txtaaaammjj.setBounds(359, 207, 313, 30);
		add(txtaaaammjj);
		
		JLabel lblNewLabel_4 = new JLabel("Pr\u00E9scrire des m\u00E9dicaments avec Dosage:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(36, 275, 275, 30);
		add(lblNewLabel_4);
		
		btnNewButton = new JButton("Aper\u00E7u");
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(350, 541, 133, 35);
		add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnImprimer = new JButton("Imprimer");
		
		btnImprimer.setForeground(Color.BLACK);
		btnImprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnImprimer.setBackground(new Color(30, 144, 255));
		btnImprimer.setBounds(585, 541, 133, 35);
		add(btnImprimer);
		btnImprimer.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setBounds(359, 280, 352, 250);
		add(textArea);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\poste\\Documents\\ordonnance.jpg"));
		label_2.setBounds(0, 0, 1359, 602);
		add(label_2);
		
	}
	public void panelOrdonnance()
	{
	 panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(833, 63, 491, 528);
	add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel_5 = new JLabel("Cabinet du Docteur XXXX");
	lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 27));
	lblNewLabel_5.setBounds(76, 11, 363, 44);
	panel.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Ordonnance");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
	lblNewLabel_6.setBounds(176, 74, 242, 32);
	panel.add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("M\u00E9decin consultant:");
	lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_7.setBounds(10, 134, 173, 32);
	panel.add(lblNewLabel_7);
	
lblNewLabel_8 = new JLabel("");
	lblNewLabel_8.setBounds(192, 134, 289, 32);
	panel.add(lblNewLabel_8);
	
	JLabel lblNomCompletDu = new JLabel("Nom complet du patient:");
	lblNomCompletDu.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNomCompletDu.setBounds(10, 188, 186, 32);
	panel.add(lblNomCompletDu);
	
label = new JLabel("");
	label.setBounds(206, 188, 276, 44);
	panel.add(label);
	
	JLabel lblLe = new JLabel("Date de consultation:");
	lblLe.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblLe.setBounds(10, 243, 186, 32);
	panel.add(lblLe);
	
 label_1 = new JLabel("");
	label_1.setBounds(202, 243, 261, 32);
	panel.add(label_1);
	
	JLabel lblMdicamentsAvecDosage = new JLabel("M\u00E9dicaments avec Dosage:");
	lblMdicamentsAvecDosage.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblMdicamentsAvecDosage.setBounds(10, 298, 201, 32);
	panel.add(lblMdicamentsAvecDosage);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source==btnNewButton)
		{

		  if(textField_1.getText().toString().contentEquals("")||textField.getText().toString().contentEquals("")||txtaaaammjj.getText().toString().contentEquals("")||textArea.getText().toString().contentEquals(""))
		  {
				JOptionPane.showMessageDialog(null,"Aucun champ ne doit etre vide ","Erreur",JOptionPane.ERROR_MESSAGE);
		  }
		  else
		  {
            panel.setVisible(true);
		  lblNewLabel_8.setText(textField_1.getText().toString());
		   label.setText(textField.getText().toString());
		   label_1.setText(txtaaaammjj.getText().toString());
		   textArea_1.setText(textArea.getText().toString());
		  }
		  		}
		if(source==btnImprimer)
		{
			
			 lblNewLabel_8.setText(textField_1.getText().toString());
			   label.setText(textField.getText().toString());
			   label_1.setText(txtaaaammjj.getText().toString());
			   textArea_1.setText(textArea.getText().toString());
			   panel.setVisible(true);
			printRecord(panel);
		}
		
	}
	private void printRecord(JPanel panel1)
	{
		PrinterJob printerJob=PrinterJob.getPrinterJob();
		printerJob.setJobName("Print Record");
		printerJob.setPrintable(new Printable()
				{

					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						// TODO Auto-generated method stub
						if(pageIndex>0)
						{
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D graphics2D=(Graphics2D)graphics;
						graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
						graphics2D.scale(0.5, 0.5);
						
						panel1.paint(graphics2D);
						return Printable.PAGE_EXISTS;
						
					}
			
				});
		boolean returningResult=printerJob.printDialog();
		if(returningResult)
		{
			try {
				printerJob.print();
			}catch(PrinterException printerException)
			{
				JOptionPane.showMessageDialog(this, "Print Error: "+printerException.getMessage());
			}
		}
	}
}
