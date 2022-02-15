package projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class C_Liste_Patients implements ActionListener{
	private Model2 m;
	private V_Liste_Patients v;
	public C_Liste_Patients(V_Liste_Patients v1,Model2 m1) {
		m = m1;
		v = v1;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getActionCommand();
		

	}

}
