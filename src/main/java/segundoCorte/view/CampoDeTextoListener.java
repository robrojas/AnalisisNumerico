package segundoCorte.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import sun.security.krb5.internal.ktab.KeyTabConstants;

public class CampoDeTextoListener implements ActionListener{

	private AnalisisNumericoView view;
	
	public CampoDeTextoListener(AnalisisNumericoView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		System.out.println(e.getSource().getClass());
		if (e.getSource().getClass().toString().equals("class javax.swing.JButton")) {
		}
	}

}
