package segundoCorte;

import segundoCorte.src.MinimosCuadradoExponencial;
import segundoCorte.src.MinimosCuadradoExponencialImp;
import segundoCorte.src.MinimosCuadradosLogaritmicos;
import segundoCorte.src.MinimosCuadradosLogaritmicosImp;
import segundoCorte.src.TrapecioCompuesto;
import segundoCorte.src.TrapecioCompuestoImp;


public class Principal {
	
	public static void main(String[] args) {
		
		String funcion = "e^x + sin(x)";
		int iteraciones = 5;
		double limInferior = 0.0;
		double limSuperior = 30;
		
		System.out.println("Trapecio Compuesto: \n");
		
		TrapecioCompuesto metodo = new TrapecioCompuestoImp();
		metodo.trapecioCompuesto(limInferior, limSuperior, iteraciones, funcion);
		
		System.out.println("*********************************************\n");
		
		System.out.println("Minimos Cuadrado Logaritmico");
		MinimosCuadradosLogaritmicos cuadradoLog = new MinimosCuadradosLogaritmicosImp();
		cuadradoLog.calcular(getCuadradoLog());
		
		System.out.println("*********************************************\n");
		
		System.out.println("Minimos Cuadrado Exponencial");
		MinimosCuadradoExponencial cuadradoExp = new MinimosCuadradoExponencialImp();
		cuadradoExp.calcular(getCuadradoExp());
	}
	
	private static double[][] getCuadradoLog() {
		double[][] a = new double[][] {  {1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
		return a;
	}
	
	private static double[][] getCuadradoExp() {
		double[][] a = new double[][] {  {1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
		return a;
	}
}
