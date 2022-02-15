package projet;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Acceuil extends JTabbedPane{

	private V_Liste_Patients patients;
	private Ordonnance ordonnance;
	private Visite visite;
	private Liste_visites consultations;
	private Liste_rdvs rdvs;
	private Agenda agenda;
	private Statistiques sts;
	public Acceuil()
	
	{
		super();
		patients=new V_Liste_Patients(new Model2());
		this.addTab("Patients", patients);
		ordonnance=new Ordonnance();
		this.addTab("Ordonnance", ordonnance);
		visite=new Visite();
		this.addTab("Visite", visite);
		consultations=new Liste_visites();
		this.addTab("Consultations", consultations);
		rdvs=new Liste_rdvs();
		this.addTab("Liste Rdvs", rdvs);
		agenda=new Agenda();
		this.addTab("Agenda", agenda);
		sts=new Statistiques();
		this.addTab("Statistiques",sts);
		
		
		
	}
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame fen=new JFrame();
Acceuil a=new Acceuil();
fen.setContentPane(a);
fen.pack();
fen.setVisible(true);
fen.setTitle("Acceuil");
fen.setBounds(0, 100, 1350,700);
	}*/

	
}
	