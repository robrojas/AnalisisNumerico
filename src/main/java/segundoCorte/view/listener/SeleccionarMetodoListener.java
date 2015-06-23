package segundoCorte.view.listener;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import segundoCorte.view.IntegracionDesigualView;
import segundoCorte.view.MinimosCuadradosView;
import segundoCorte.view.SeleccionMetodoView;
import segundoCorte.view.TrapecioCompuestoTablaView;
import segundoCorte.view.TrapecioCompuestoView;
import utilidades.MinimosCuadradosTipos.tipos;

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
			while(true) {
				try {
					levantarVista(Integer.parseInt(JOptionPane.showInputDialog(view, "Ingrese el n�mero de iteraciones: ","An�lisis Numerico",JOptionPane.INFORMATION_MESSAGE)));
					resetearValores();
					break;
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(view, "El valor ingresado es incorrecto, debe ingresar un n�mero entero","An�lisis Numerico",JOptionPane.ERROR_MESSAGE);
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(view, "El valor ingresado es incorrecto, debe ingresar un n�mero entero","An�lisis Numerico",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	private void mensajeComboBox() {
		JOptionPane.showMessageDialog(view,
								      "Debe seleccionar un m\u00e9todo de la lista",
								      "Error",
								      JOptionPane.ERROR_MESSAGE);
	}
	
	private void levantarVista(int iteraciones) {
		JOptionPane.showMessageDialog(view, 
				 "Es importante que antes de llenar los campos consulte la documentac�n. Estar� disponible en el bot�n ayuda",
                "Ateni�n", 
                JOptionPane.WARNING_MESSAGE); 
		
		if (view.getMetodosComboBox().getSelectedItem().equals("Trapecio Compuesto")) {
			
			if (view.getRbtnFormula().isSelected()) {
				TrapecioCompuestoView trapecio = new TrapecioCompuestoView(view, true, iteraciones);
				trapecio.setVisible(true);
			}
			else {
				TrapecioCompuestoTablaView trapecioTabla = new TrapecioCompuestoTablaView(view, true, iteraciones);
				trapecioTabla.setVisible(true);
			}
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado Exponencial")) {
			MinimosCuadradosView minimos = new MinimosCuadradosView(view, true, iteraciones, "M�nimo Cuadrado Exponencial", tipos.EXPONENCIAL);
			minimos.setVisible(true);
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado Logar�tmico")) {
			MinimosCuadradosView minimos = new MinimosCuadradosView(view, true, iteraciones, "M�nimo Cuadrado Logar�tmico", tipos.LOGARITMICO);
			minimos.setVisible(true);
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("M�nimo Cuadrado con Aproximaci�n a una Recta")) {
			MinimosCuadradosView minimos = new MinimosCuadradosView(view, true, iteraciones, "M�nimo Cuadrado con Aproximaci�n a una Recta", tipos.APROXIMACION);
			minimos.setVisible(true);
		}
		
		if (view.getMetodosComboBox().getSelectedItem().equals("Integraci�n Desigual")) {
			IntegracionDesigualView integracion = new IntegracionDesigualView(view, true, iteraciones);
			integracion.setVisible(true);
		}
	}
	
	private void resetearValores() {
		view.getMetodosComboBox().setSelectedIndex(0);
		view.rbtnTabla.setSelected(false);
		view.rbtnFormula.setSelected(false);
	}

}