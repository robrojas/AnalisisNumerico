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
		double d =  Math.sin(valor);
		return d;
	}
	
	/**
	 * Calcular el valor del coseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double get_Coseno(double valor) {
		double d =  Math.cos(valor);
		return d;
	}
	
	/**
	 * Calcular el valor de la tangente de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getTangente(double valor) {
		double d =  Math.tan(valor);
		return d;
	}
	
	/**
	 * Calcular el valor del arcocoseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoCoseno(double valor) {
		double d =  Math.acos(valor);
		return d;
	}
	
	/**
	 * Calcular el valor del arcoseno de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoSeno(double valor) {
		double d =  Math.asin(valor);
		return d;
	}
	
	/**
	 * Calcular el valor del arcotangente de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getArcoTangente(double valor) {
		double d =  Math.atan(valor);
		return d;
	}
	
	/**
	 * Calcular la raiz de una constante.
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getRaiz(@SuppressWarnings("unused") double valor) {
		// TODO
		return 0;
	}
	
	/**
	 * Calcular el logaritmo neperiano de una constante 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getLogaritmo(double valor) {
		double d = Math.log(valor);
		return d;
	}
	
	/**
	 * Calcular el valor Euler de un exponencial constante. 
	 * @param valor Valor constante
	 * @return Valor calculado
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	public double getEuler(double valor) {
		double d = Math.exp(valor);
		return d;
	}
	
}
