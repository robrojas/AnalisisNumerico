package utilidades;

/**
 * Dato un valor, realiza calculos matematicos como trigonometr&iacute;a, Euler, entre otros.
 * 
 * @author Roberto Rojas
 * @fecha 01/06/2015
 */
public class CalculoMatematico {
	
	/**
	 * Calcular el valor del seno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getSeno(double valor) {
		return Math.sin(valor);
	}
	
	/**
	 * Calcular el valor del coseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double get_Coseno(double valor) {
		return Math.cos(valor);
	}
	
	/**
	 * Calcular el valor de la tangente de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getTangente(double valor) {
		return Math.tan(valor);
	}
	
	/**
	 * Calcular el valor del arcocoseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoCoseno(double valor) {
		return Math.acos(valor);
	}
	
	/**
	 * Calcular el valor del arcoseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoSeno(double valor) {
		return Math.asin(valor);
	}
	
	/**
	 * Calcular el valor del arcotangente de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoTangente(double valor) {
		return Math.atan(valor);
	}
	
	/**
	 * Calcular la raiz de una constante.
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getRaiz(double valor) {
		return Math.sqrt(valor);
	}
	
	/**
	 * Calcular el logaritmo neperiano de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getLogaritmo(double valor) {
		return Math.log(valor);
	}
	
	/**
	 * Calcular el valor Euler de un exponencial constante. 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getEuler(double valor) {
		return Math.exp(valor);
	}
	
}
