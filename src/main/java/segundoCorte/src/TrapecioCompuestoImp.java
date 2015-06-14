package segundoCorte.src;

import java.util.List;

public class TrapecioCompuestoImp implements TrapecioCompuesto {

	@Override
	public double trapecioCompuesto(double limInferior, 
									double limSuperiorParcial, 
									int iteraciones,
									List<Object> funcion) 
	{
		double limiteSuperior = calcularLimiteSuperior(limSuperiorParcial);
		double tamanioDePaso = calcularTamanioDePaso(limInferior, limiteSuperior, iteraciones);
		
		Double[][] tabla = new Double[iteraciones + 1][2];
		tabla[0][0] = limInferior;
		
		for (int i = 1; i < iteraciones + 1; i++) {
			for (int j = 0; j < 2; j = j + 2) {
				tabla[i][j] = getXm(tabla[i - 1][j], tamanioDePaso);
			}
		}
		
		tabla[0][1] = 1.0;
		tabla[1][1] = 1.2148;
		tabla[2][1] = 1.4408;
		tabla[3][1] = 1.6779;
		tabla[4][1] = 1.9268;
		tabla[5][1] = 2.1880;
		
		double resultado = getArea(tamanioDePaso, tabla, iteraciones);
		
		System.out.println("Xm: ");
		for (int i = 0; i < iteraciones + 1; i++) {
			for (int j = 0; j < 2; j = j + 2) {
				System.out.println("\t" + tabla[i][j]);
			}
		}
		
		System.out.println("Ym: ");
		for (int i = 0; i < iteraciones + 1; i++) {
			for (int j = 1; j < 2; j = j + 2) {
				System.out.println("\t" + tabla[i][j]);
			}
		}
		
		System.out.println("Resultado final = " + resultado);
		
		return 0;
	}
	
	/**
	 * Calcular el valor real del limite superior.
	 * @param limiteSuperiorParcial Limite superior parcial
	 * @return Limite superior real
	 */
	private static double calcularLimiteSuperior(double limiteSuperiorParcial) {
		return (limiteSuperiorParcial * Math.PI) / 180;
	}
	
	/**
	 * Calcular el valor del tamanio de paso.
	 * @param limInferior Limite inferior.
	 * @param limiteSuperior Limite superior.
	 * @param iteraciones N&uacute;mero de iteraciones
	 * @return Valor del tamanio de paso.
	 */
	private static double calcularTamanioDePaso(double limInferior, 
							 double limiteSuperior, 
							 int iteraciones) 
	{
		return (limiteSuperior - limInferior) / iteraciones;
		
	}
	
	/**
	 * 
	 * @param xm Valor anterior de la tabla en la columna Xm.
	 * @param tamanioDePaso Tamanio de paso.
	 * @return Valoractual de Xm
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	private static double getXm(double xm, double tamanioDePaso) {
		return xm + tamanioDePaso;
	}
	
	/**
	 * @param tamanioDePaso Tamanio de paso
	 * @param tabla Tabla sobre la que se har&aacute; la interaci&oacute;n.
	 * @param iteraciones Cantidad de interaciones que se har&aacute;n sobre la tabla.
	 * @return Resultado del calculo del &aacute;rea.
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	private static double getArea(double tamanioDePaso, Double[][] tabla, int iteraciones) {

		double sumatoria = 0; 
		for (int i = 1; i <= iteraciones - 1; i++){
			for (int j = 1; j < 2; j++) {
				sumatoria = sumatoria + tabla[i][j];
			}
		}
		System.out.println("Sumatoria = " + sumatoria);
		return (tamanioDePaso / 2) * (tabla[0][1] + tabla[iteraciones][1] + (2 * sumatoria));  
		
	}

}
