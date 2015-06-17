package segundoCorte;

import segundoCorte.src.TrapecioCompuesto;
import segundoCorte.src.TrapecioCompuestoImp;


public class Principal {
	
	public static void main(String[] args) {
		
		String funcion = "e^x + sin(x)";
		int iteraciones = 5;
		double limInferior = 0.0;
		double limSuperior = 30;
		
		TrapecioCompuesto metodo = new TrapecioCompuestoImp();
		metodo.trapecioCompuesto(limInferior, limSuperior, iteraciones, funcion);
//		MinimosCuadradosLogaritmicos minimos = new MinimosCuadradosLogaritmicosImp();
//		minimos.calcular(a);
//		MinimosCuadradoExponencial minimos = new MinimosCuadradoExponencialImp();
//		minimos.calcular(a);
	}
	/**
	 * Cadena de MinimoCuadradoLogaritmico:
	 * 
	 * 
	 * double[][] a = new double[][] {  {1.0, 0.5}, 
										{2.0, 1.7},
										{3.0, 3.4},
										{4.0, 5.7},
										{5.0, 8.4},
									};
	 * 		
	 */
	
	/**
	 * Cadena de MinimoCuadradoExponenciales
	 * 
	 * 
	 * double[][] a = new double[][] {  {1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
	 * 		
	 */
	
}
