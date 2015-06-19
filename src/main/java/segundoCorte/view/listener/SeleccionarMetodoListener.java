package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.ComboBox;

import javax.swing.JOptionPane;

import segundoCorte.view.SeleccionMetodoView;
import segundoCorte.view.TrapecioCompuestoView;

public class SeleccionarMetodoListener implements ActionListener {

	private SeleccionMetodoView view;
	
	public SeleccionarMetodoListener(SeleccionMetodoView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (view.getMetodosComboBox().getSelectedIndex() == 0) {
			mensajeComboBox();
		}
		else {
			levantarVista();
			resetearValores();
		}
	}
	
	private void mensajeComboBox() {
		JOptionPane.showMessageDialog(view,
								      "Debe seleccionar un m\u00e9todo de la lista",
								      "Error",
								      JOptionPane.ERROR_MESSAGE);
	}
	
	private void levantarVista() {
		
		if (view.getMetodosComboBox().getSelectedItem().equals("Trapecio Compuesto")) {
			TrapecioCompuestoView trapecio = new TrapecioCompuestoView(view, true);
			trapecio.setVisible(true);
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado Exponencial")) {
			// TODO
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado Logar�tmico")) {
			// TODO
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado con Aproximaci�n a una Recta")) {
			// TODO
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("Integraci�n Desigual")) {
			// TODO
		}
	}
	
	private void resetearValores() {
		view.getMetodosComboBox().setSelectedIndex(0);
		view.rbtnTabla.setSelected(true);
		view.rbtnFormula.setSelected(false);
	}

}

//modeloComboBox.addElement("Seleccionar...");
//modeloComboBox.addElement("Trapecio Compuesto");
//modeloComboBox.addElement("M�nimo Cuadrado Exponencial");
//modeloComboBox.addElement("M�nimo Cuadrado Logar�tmico");
//modeloComboBox.addElement("M�nimo Cuadrado con Aproximaci�n a una Recta");
//modeloComboBox.addElement("Integraci�n Desigual");
