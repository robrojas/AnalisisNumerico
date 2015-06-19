package segundoCorte;

import javax.swing.JOptionPane;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;

import segundoCorte.src.TrapecioCompuesto;
import segundoCorte.src.TrapecioCompuestoImp;
import segundoCorte.view.SeleccionMetodoView;


public class Principal {
	
	public static void main(String[] args) {
		
//		Jep jep = new Jep();
//		try {
//			jep.parse("2pi/2");
//			System.out.println(jep.evaluate());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EvaluationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		SeleccionMetodoView principal = new SeleccionMetodoView();
		principal.setVisible(true);
//		
//		
		
//		MinimosCuadradosView view = new MinimosCuadradosView(5);
//		view.setVisible(true);
		
//		IntegracionDesigual integracion = new IntegracionDesigualImp();
//		System.out.println("Integracion Desigual: ");
//		System.out.println(integracion.calcular(getIntegracionDesigual()));
		
//		trapecioCompuesto();
//		
//		MinimosCuadradosLogaritmicos cuadradoLog = new MinimosCuadradosLogaritmicosImp();
//		System.out.println("\nMinimos Cuadrados Logaritmicos:");
//		imprimir(cuadradoLog.calcular(getCuadradoLog()));
//		
//		MinimosCuadradoExponencial cuadradoExp = new MinimosCuadradoExponencialImp();
//		System.out.println("\nMinimos Cuadrados Exponenciales:");
//		imprimir(cuadradoExp.calcular(getCuadradoExp()));
//		
//		MinCuadAproximacionAUnaRecta aprox = new MinCuadAproximacionAUnaRectaImp();
//		System.out.println("\n Minimos Cuadrados con Aproximacion a una recta: ");
//		imprimir(aprox.calcular(getCuadradoAprox()));
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
	
	private static double[][] getIntegracionDesigual() {
		double[][] a = new double[][] {  
				{0.0, 0.0}, 
				{0.1, 6.84},
				{0.3, 4.0},
				{0.5, 4.2},
				{0.7, 5.51},
				{0.95, 5.77},
				{1.2, 1.0},
			};
		return a;
	}
}
