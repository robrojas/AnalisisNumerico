package segundoCorte.src;

public class MinCuadAproximacionAUnaRectaImp implements MinCuadAproximacionAUnaRecta {

	private double sumXi = 0;
	private double sumYi = 0;
	private double sumXiCuadrado = 0;
	private double sumProductoXiYi = 0;
	private double[][] tablaInicial; 
	private double bLogaritmo;
	private double m;
	private double B;
	private double Y[];
	
	@Override
	public double[] calcular(double[][] tabla) {
		this.tablaInicial = tabla;
		
		calcularSumaXi();
		calcularSumaYi();
		calcularSumaXiCuadrado();
		calcularSumaProductoXiYi();
		calcularBLogaritmico();
		calcularM();
		calcularB();
		calcularY();
		return Y;
	}
	
	/**
	 * Calcular la sumatoria de los valores de la columna Xi de la tabla
	 * inicial y almacenarlo en sumaXi.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularSumaXi() {
		for(int i = 0; i < tablaInicial.length; i++) {
			sumXi = sumXi + tablaInicial[i][0];
		}
	}
	
	/**
	 * Calcular la sumatoria de los valores de la columna Yi de la tabla
	 * inicial y almacenarlo en sumayi.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularSumaYi() {
		for(int i = 0; i < tablaInicial.length; i++) {
			sumYi = sumYi + tablaInicial[i][1];
		}
	}
	
	/**
	 * Calcular la sumatoria potencia al cuadrado de los valores de la 
	 * columna Xi de la tabla inicial y almacenarlo en sumaXiCuadrado.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularSumaXiCuadrado() {
		for(int i = 0; i < tablaInicial.length; i++) {
			sumXiCuadrado = sumXiCuadrado + Math.pow(tablaInicial[i][0], 2);
		}
	}
	
	/**
	 * Calcular la sumatoria del producto de los valores de las columnas Xi  
	 * y Yi de la tabla inicial y almacenarlo en sumProductoXiYi.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularSumaProductoXiYi() {
		for(int i = 0; i < tablaInicial.length; i++) {
			sumProductoXiYi = sumProductoXiYi + (tablaInicial[i][0] * tablaInicial[i][1]);
		}
	}
	
	/**
	 * Calcular Valor de B^.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularBLogaritmico() {
		double sumaAC = (tablaInicial.length * (-sumXiCuadrado)) + (sumXi * sumXi);
		double sumaBD = (sumYi * (-sumXiCuadrado)) + (sumProductoXiYi * sumXi);
		bLogaritmo = sumaBD / sumaAC;
	}
	
	/**
	 * Calcular Valor de m.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularM() {
		m = (sumYi - (tablaInicial.length * bLogaritmo)) / sumXi;
	}
	
	/**
	 * Calcular Valor de B.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularB() {
		B = Math.exp(bLogaritmo);
	}
	
	/**
	 * Calcular Valores de Y.
	 * @author Roberto Rojas
	 * @fecha 17/06/2015
	 */
	private void calcularY() {
		Y = new double[tablaInicial.length];
		for (int i = 0; i < Y.length; i++) {
			Y[i] = m * tablaInicial[i][0] + B;
		}
	}
}
