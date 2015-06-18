package segundoCorte.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import segundoCorte.src.MinimosCuadradosLogaritmicos;
import segundoCorte.src.MinimosCuadradosLogaritmicosImp;
import sun.security.krb5.internal.ktab.KeyTabConstants;

public class CalcularMinimoscuadradosListener implements ActionListener{

	private MinimosCuadradosView view;
	
	public CalcularMinimoscuadradosListener(MinimosCuadradosView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MinimosCuadradosLogaritmicos metodo = new MinimosCuadradosLogaritmicosImp();
	}

}
