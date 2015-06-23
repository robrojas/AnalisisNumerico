package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import segundoCorte.src.MinCuadAproximacionAUnaRecta;
import segundoCorte.src.MinCuadAproximacionAUnaRectaImp;
import segundoCorte.src.MinimosCuadradoExponencial;
import segundoCorte.src.MinimosCuadradoExponencialImp;
import segundoCorte.src.MinimosCuadradosLogaritmicos;
import segundoCorte.src.MinimosCuadradosLogaritmicosImp;
import segundoCorte.view.MinimosCuadradosView;
import utilidades.MinimosCuadradosTipos.tipos;

public class MinimosCuadradosViewLisetener implements ActionListener {

	private MinimosCuadradosView view;
	
	public MinimosCuadradosViewLisetener(MinimosCuadradosView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (validarContenidoColumna(0)) { mensajeFaltanValoresTabla("Xi"); }
		else if (validarContenidoColumna(1)) { mensajeFaltanValoresTabla("Yi"); }
		else {
			double[] resultado = getResultado();
			actualizarView(resultado);
			view.validate();
		}
	}
	
	private void mensajeFaltanValoresTabla(String columna) {
		JOptionPane.showMessageDialog(view, 
				                     "Los valores la columna " + columna + " están incompletos",
				                      view.getTitle(), 
				                      JOptionPane.ERROR_MESSAGE);
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
	
	private double[] getResultado() {
		if (view.getMetodo().equals(tipos.EXPONENCIAL)) {
			MinimosCuadradoExponencial minimos = new MinimosCuadradoExponencialImp();
			return minimos.calcular(getTablaMetodo(getDatosModeloTabla()));
		}
		else if (view.getMetodo().equals(tipos.LOGARITMICO)) {
			MinimosCuadradosLogaritmicos minimos = new MinimosCuadradosLogaritmicosImp();
			return minimos.calcular(getTablaMetodo(getDatosModeloTabla()));
		}
		else {
			MinCuadAproximacionAUnaRecta minimos = new MinCuadAproximacionAUnaRectaImp();
			return minimos.calcular(getTablaMetodo(getDatosModeloTabla()));
		}
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
	
	private void actualizarView(double[] resultado) {
		TableModel modelo = view.getTable().getModel();
		
		for (int i = 0; i < resultado.length; i++) {
			modelo.setValueAt(resultado[i], i, 2);
		}
	}
	

}
