package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import segundoCorte.view.TrapecioCompuestoTablaView;

public class TrapecioCompuestoTableViewListener implements ActionListener{

	private TrapecioCompuestoTablaView view;
	private int iteraciones;
	
	public TrapecioCompuestoTableViewListener(TrapecioCompuestoTablaView view, int iteraciones) {
		super();
		this.view = view;
		this.iteraciones = iteraciones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (validarContenidoColumna(0)) { mensajeFaltanValoresTabla("Xi"); }
		else if (validarContenidoColumna(1)) { mensajeFaltanValoresTabla("Yi"); }
		else if (view.getTxtTamanioPaso().getText().equals("")) { mensajeTamanioPasoVacio(); }
		else {
			double resultado = getArea(Double.parseDouble(view.getTxtTamanioPaso().getText()), 
									   getTablaMetodo(getDatosModeloTabla()), 
									   iteraciones);
			mensajeExito(resultado);
		}
		
	}
	
	private boolean validarContenidoColumna(int columna) {
		
		TableModel modeloTabla = view.getTabla().getModel();
		
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if (modeloTabla.getValueAt(i, columna) == "") {
				
				return true;
			}
		}
		return false;
	}
	
	private void mensajeFaltanValoresTabla(String columna) {
		JOptionPane.showMessageDialog(view, 
				                     "Los valores la columna " + columna + " están incompletos",
				                      view.getTitle(), 
				                      JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeTamanioPasoVacio() {
		JOptionPane.showMessageDialog(view, 
				                     "El campo Tamaño de Paso esta vacío",
				                      view.getTitle(), 
				                      JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeExito(double resultado) {
		JOptionPane.showMessageDialog(view, 
				                     "El resultado es: " + resultado,
				                      view.getTitle(), 
				                      JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double[][] getTablaMetodo(Double[][] tablaModelo) {
		TableModel modelo = view.getTabla().getModel();
		double[][] tabla = new double[modelo.getRowCount()][modelo.getColumnCount()];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = tablaModelo[i][0];
			tabla[i][1] = tablaModelo[i][1];
		}
		return tabla;
	}
	
	private Double[][] getDatosModeloTabla() {
		TableModel modelo = view.getTabla().getModel();
		
		Double[][] tabla = new Double[modelo.getRowCount()][modelo.getColumnCount()];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = Double.parseDouble((String) modelo.getValueAt(i, 0));
			tabla[i][1] = Double.parseDouble((String) modelo.getValueAt(i, 1));
		}
		return tabla;
	}
	
	private static double getArea(double tamanioDePaso, double[][] tabla, int iteraciones) {

		double sumatoria = 0; 
		for (int i = 1; i <= iteraciones - 1; i++){
			for (int j = 1; j < 2; j++) {
				sumatoria = sumatoria + tabla[i][j];
			}
		}
		return (tamanioDePaso / 2) * (tabla[0][1] + tabla[iteraciones][1] + (2 * sumatoria));  
	}

}
