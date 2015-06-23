package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import segundoCorte.src.IntegracionDesigual;
import segundoCorte.src.IntegracionDesigualImp;
import segundoCorte.view.IntegracionDesigualView;

public class IntegracionDesigualViewListener implements ActionListener{

	private IntegracionDesigualView view;
	
	public IntegracionDesigualViewListener(IntegracionDesigualView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (validarContenidoColumna(0)) { mensajeFaltanValoresTabla("Xi"); }
		else if (validarContenidoColumna(1)) { mensajeFaltanValoresTabla("Yi"); }
		else {
			IntegracionDesigual integracion = new IntegracionDesigualImp();
			mensajeExito(integracion.calcular(getTablaMetodo(getDatosModeloTabla())));
		}
	}
	
	private boolean validarContenidoColumna(int columna) {
		
		TableModel modeloTabla = view.getTable().getModel();
		
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if (modeloTabla.getValueAt(i, columna) == "") {
				
				return true;
			}
		}
		return false;
	}
	
	private double[][] getTablaMetodo(Double[][] tablaModelo) {
		TableModel modelo = view.getTable().getModel();
		double[][] tabla = new double[modelo.getRowCount()][modelo.getColumnCount()];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = tablaModelo[i][0];
			tabla[i][1] = tablaModelo[i][1];
		}
		return tabla;
	}
	
	private Double[][] getDatosModeloTabla() {
		TableModel modelo = view.getTable().getModel();
		
		Double[][] tabla = new Double[modelo.getRowCount()][modelo.getColumnCount()];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = Double.parseDouble((String) modelo.getValueAt(i, 0));
			tabla[i][1] = Double.parseDouble((String) modelo.getValueAt(i, 1));
		}
		return tabla;
	}
	
	private void mensajeFaltanValoresTabla(String columna) {
		JOptionPane.showMessageDialog(view, 
				                     "Los valores la columna " + columna + " están incompletos",
				                      view.getTitle(), 
				                      JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeExito(double resultado) {
		JOptionPane.showMessageDialog(view, 
				                     "El resultado es: " + resultado,
				                      view.getTitle(), 
				                      JOptionPane.INFORMATION_MESSAGE);
	}

}
