package segundoCorte.src;


/**
 * Implementaci&oacute;n de la interfaz {@link MinimosCuadradosLogaritmicos}
 * 
 * @author Roberto Rojas
 * @fecha 04/06/2015
 */
public class MinimosCuadradosLogaritmicosImp implements
		MinimosCuadradosLogaritmicos {

	private double sumaXi = 0;
	private double sumaYi = 0;
	private double sumaCuadradoXi = 0;
	private double sumaProductoXiYi = 0;
	private double[][] tablaInicial;
	
	@Override
	public double[] calcular(double[][] tabla) {
		this.tablaInicial = tabla;
		
		double[][] xiYi = calcularXiYi();
		calcularCuadradoXi(xiYi);
		calcularProductoXiYi(xiYi);
		double bLogaritmo = calcularBLogaritmo();
		double m = calcularM(bLogaritmo);
		double b = calcularB(bLogaritmo);
		double[] y = calcularY(m, b);
		
		return y;
	}

	/**
	 * @return Arreglo con las columnas log(xi) / log(yi)
	 * @author Roberto Rojas
	 * @fecha 02/06/2015
	 */
	private double[][] calcularXiYi() {
		double[][] xiYi = new double[tablaInicial.length][2];
		
		for (int i = 0; i < tablaInicial.length; i ++) {
			for (int j = 0; j < 2; j++) {
				xiYi[i][j] = Math.log10(tablaInicial[i][j]);
				if (j == 0) { sumaXi = sumaXi + xiYi[i][j]; }
				else { sumaYi = sumaYi + xiYi[i][j]; }
			}
		}
		return xiYi;
	}
	
	/**
	 * @param xiYi Arreglo con los valores de las columnas log(xi) / log(yi)
	 * @return Arreglo con los valores de la columna X².
	 * @author Roberto Rojas
	 * @fecha 02/06/2015
	 */
	private void calcularCuadradoXi(double[][] xiYi) {
		double[] cuadradoXi = new double[xiYi.length];
		
		for (int i = 0; i < xiYi.length; i ++) {
			cuadradoXi[i] = Math.pow(xiYi[i][0], 2);
			sumaCuadradoXi = sumaCuadradoXi + cuadradoXi[i];
		}
	}
	
	/**
	 * @param xiYi Arreglo con los valores de las columnas log(xi) / log(yi)
	 * @return Arreglo con los valores resultantes del producto de las columnas log(xi) / log(yi)
	 * @author Roberto Rojas
	 * @fecha 02/06/2015
	 */
	private void calcularProductoXiYi(double[][] xiYi) {
		double[] productoXiYi = new double[xiYi.length];
		
		for (int i = 0; i < xiYi.length; i ++) {
			productoXiYi[i] = xiYi[i][0] * xiYi[i][1];
			sumaProductoXiYi = sumaProductoXiYi + productoXiYi[i]; 
		}
	}
	
	/**
	 * Calcular B^.<br>
	 * Se genera un sistema de ecuaciones con dos ecuaciones sustituyendo los valores de sumaXi, 
	 * sumaYi, sumaCuadradoXi y sumaProductoXiYi en las formulas principales.
	 * <pre><b>Formulas:</b>
	 *    M E Xi^ + (B^ * n) =  E Yi^.
	 *    M E Xi^ï¿½ + (B^ * E Xi^) = E (Yi^ * Xi^).</pre>
	 * <b>NOTA: Para conocer la leyenda de las formulas consultar la clase {@link MinimosCuadradosLogaritmicos}</b>
	 * 
	 * @return Valor de B^.
	 * @author Roberto Rojas
	 * @fecha 04/06/2015
	 */
	private double calcularBLogaritmo() {
		
		/* En sumaAC, a = (B^ * n) ; c =  (B^ * E Xi^) */
		double sumaAC = (tablaInicial.length * (sumaCuadradoXi * -1)) + (sumaXi * sumaXi);
		
		/* En suma BD, b = E Yi^ ; d = E (Yi^ * Xi^) */
		double sumaBD = (sumaYi * (sumaCuadradoXi * -1)) + (sumaProductoXiYi * sumaXi);
		
		return sumaBD / sumaAC;
	}
	
	/**
	 * Carcular M.<br>
	 * Sustituir el valor de b en la primera formula principal del sistema de ecuaciones y se despeja M.
	 * 
	 * <pre><b>Formula:</b>
	 *     M E Xi^ + (B^ * n) =  E Yi^.</pre>
	 * <b>NOTA: Para conocer la leyenda de las formulas consultar la clase {@link MinimosCuadradosLogaritmicos}</b>
	 * 
	 * @param b El valor de B^.
	 * @return Valor de M.
	 * @author Roberto Rojas
	 * @fecha 04/06/2015
	 */
	private double calcularM(double b) {
		return (sumaYi + ((b * tablaInicial.length) * -1)) / sumaXi;
	}
	
	/**
	 * Calcular b.<br>
	 * Sustituir el valor de B^ en la formula B = e^^B^.<br>
	 * 
	 * <b>NOTA: Para conocer la leyenda de las formulas consultar la clase {@link MinimosCuadradosLogaritmicos}</b>
	 * @param bLogaritmo
	 * @return
	 * @author Roberto Rojas
	 * @fecha 04/06/2015
	 */
	private static double calcularB(double bLogaritmo) {
		return Math.exp(bLogaritmo);
	}
	
	/**
	 * Calcular Y.<br>
	 * 
	 * Sustituir los valores de B, X y M en la formula y = b * X^^M. Realizar esta operaci&oacute;n
	 * por cada uno de los valores contenidos en la columna de X de la tablaIncial.<br>
	 * <b>NOTA: Para conocer la leyenda de las formulas consultar la clase {@link MinimosCuadradosLogaritmicos}</b>
	 * 
	 * @param m Valor de m
	 * @param b Valor de B
	 * @return Arreglo con todos los valores de Y1 hasta Yn, siendo n = iteraciones.
	 * @author Roberto Rojas
	 * @fecha 04/06/2015
	 */
	private double[] calcularY(double m, double b) {
		double[] y = new double[tablaInicial.length];
		
		for (int i = 0; i < tablaInicial.length; i++) {
			y[i] = b * Math.pow(tablaInicial[i][0], m);
		}
		return y;
	}
	
}
