package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import segundoCorte.view.TrapecioCompuestoView;

public class TrapecioCompuestoViewListener implements ActionListener {

	private TrapecioCompuestoView view;
	
	public TrapecioCompuestoViewListener(TrapecioCompuestoView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (view.getTxtLimiteInferior().getText().equals("") || 
			view.getTxtLimiteSuperior().getText().equals("") || 
			view.getTxtIteraciones().getText().equals("") ||
			view.getTxtFuncion().getText().equals(""))
		{
			mensajeCampoVacio();
		}
		
		
	}
	
	private void mensajeCampoVacio() {
		JOptionPane.showMessageDialog(view,
								      "Todos los campos son de llenado obligatorio",
								      "Error",
								      JOptionPane.ERROR_MESSAGE);
	}

}
