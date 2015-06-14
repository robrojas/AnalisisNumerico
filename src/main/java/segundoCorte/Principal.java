package segundoCorte;

import segundoCorte.src.MinimosCuadradosLogaritmicos;
import segundoCorte.src.MinimosCuadradosLogaritmicosImp;


public class Principal {
	
	public static void main(String[] args) {
		double[][] a = new double[][] {  {1.0, 0.5}, 
				{2.0, 1.7},
				{3.0, 3.4},
				{4.0, 5.7},
				{5.0, 8.4},
			};
		
		MinimosCuadradosLogaritmicos minimos = new MinimosCuadradosLogaritmicosImp();
		minimos.calcular(a);
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
	
	/*
	 * Cadenas a evaluar para la interfaz del metodo TRrapecio compuesto:
	 * 
	 * sen, cos, tan, arcosen, arcocos, arcotan 
	 * 
	 * + - * / ^ e PI
	 * 
	 * */
}
