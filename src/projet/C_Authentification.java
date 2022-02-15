package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class C_Authentification implements ActionListener{
	private V_Authentification vue;
	private Model1 modele;
	
	public C_Authentification(V_Authentification v1,Model1 m1)
	{
		vue=v1;
		modele=m1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object s=e.getSource();
		 if(s==vue.getBtnConnection())
		 {
			 if(vue.getMotdePasse().contentEquals(""))
			 {
				 JOptionPane.showMessageDialog(null,"Veuillez saisir le mot de passe","Problème de saisie",JOptionPane.ERROR_MESSAGE);
			 }
			 else if(modele.tester_compte(vue.getUtilisateur(),vue.getMotdePasse(),vue.getCategorie())==1)
			 {
				 if(vue.getCategorie().contentEquals("Secretaire"))
				 {
			   Rdvs v=new Rdvs();
			   v.setVisible(true);
			   vue.setVisible(false);
				 }
				 else
				 {
					 V_Acceuil_1 v=new V_Acceuil_1();
					 v.setVisible(true);
					 vue.setVisible(false);
				 }
			 }
			 else if(modele.tester_compte(vue.getUtilisateur(),vue.getMotdePasse(),vue.getCategorie())==0)
			 {
				 JOptionPane.showMessageDialog(null,"Mot de passe erroné","Erreur",JOptionPane.ERROR_MESSAGE);
			 }
			 else if(modele.tester_compte(vue.getUtilisateur(),vue.getMotdePasse(),vue.getCategorie())==-1)
			 {
				 JOptionPane.showMessageDialog(null,"Cet utilisateur n'existe pas","Erreur",JOptionPane.ERROR_MESSAGE);
			 }
			 
			 
		 }
	}
	
}
