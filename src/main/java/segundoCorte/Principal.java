package segundoCorte;

import javax.swing.JOptionPane;

import segundoCorte.src.MinCuadAproximacionAUnaRecta;
import segundoCorte.src.MinCuadAproximacionAUnaRectaImp;
import segundoCorte.src.MinimosCuadradoExponencial;
import segundoCorte.src.MinimosCuadradoExponencialImp;
import segundoCorte.src.MinimosCuadradosLogaritmicos;
import segundoCorte.src.MinimosCuadradosLogaritmicosImp;
import segundoCorte.src.TrapecioCompuesto;
import segundoCorte.src.TrapecioCompuestoImp;
import segundoCorte.view.AnalisisNumericoView;


public class Principal {
	
	public static void main(String[] args) {
		
		
			
//		trapecioCompuesto();
//		
//		AnalisisNumericoView view = new AnalisisNumericoView();
//		view.setVisible(true);
//		
//		MinimosCuadradosLogaritmicos cuadradoLog = new MinimosCuadradosLogaritmicosImp();
//		System.out.println("\nMinimos Cuadrados Logaritmicos:");
//		imprimir(cuadradoLog.calcular(getCuadradoLog()));
//		
//		MinimosCuadradoExponencial cuadradoExp = new MinimosCuadradoExponencialImp();
//		System.out.println("\nMinimos Cuadrados Exponenciales:");
//		imprimir(cuadradoExp.calcular(getCuadradoExp()));
		
		MinCuadAproximacionAUnaRecta aprox = new MinCuadAproximacionAUnaRectaImp();
		System.out.println("\n Minimos Cuadrados con Aproximacion a una recta: ");
		imprimir(aprox.calcular(getCuadradoAprox()));
//		
	}
	
	private static void trapecioCompuesto() {
//		String funcion = "e^x + sin(x)";
		String funcion = JOptionPane.showInputDialog(null, "Ingrese la funcion:","Trapecio Compuesto",JOptionPane.INFORMATION_MESSAGE);
		
		int iteraciones = 5;
		double limInferior = 0.0;
		double limSuperior = 30;
		
		TrapecioCompuesto metodo = new TrapecioCompuestoImp();
		JOptionPane.showMessageDialog(null, 
									  "Resultado = " + metodo.trapecioCompuesto(limInferior, limSuperior, iteraciones, funcion),
									  "Método Trapecio Compuesto",
									  JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void imprimir(double[] tablaImprimir) {
		for (int i = 0; i < tablaImprimir.length; i++) {
			System.out.println("     y" + (i+1) + " = " + tablaImprimir[i]);
		}
	}
	
	private static double[][] getCuadradoLog() {
		double[][] a = new double[][] {  
				{1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
		return a;
	}
	
	private static double[][] getCuadradoExp() {
		double[][] a = new double[][] {  
				{1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
		return a;
	}
	
	private static double[][] getCuadradoAprox() {
		double[][] a = new double[][] {  
				{1.0, 6.350}, 
				{2.0, 5.695},
				{3.0, 5.790},
				{4.0, 5.885},
				{5.0, 4.985},
				{6.0, 4.890},
			};
		return a;
	}
}
