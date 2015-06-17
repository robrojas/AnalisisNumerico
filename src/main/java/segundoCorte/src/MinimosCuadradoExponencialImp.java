package segundoCorte.src;


/**
 * Implementaci&oacute;n de la interfaz {@link MinimosCuadradoExponencial}
 * 
 * @author Roberto Rojas
 * @fecha 07/06/2015
 */
public class MinimosCuadradoExponencialImp implements MinimosCuadradoExponencial {

	private double sumaXi = 0.0;
	private double sumaYiLogaritmico = 0.0;
	private double sumaXiCuadrado = 0.0;
	private double sumaProcuctoYiLogXi = 0.0;
	private double tablaInicial[][];
	
	@Override
	public double[] calcular(double[][] tabla) {
		this.tablaInicial = tabla;
		
		double[] yiLogaritmico = calcularYiLogaritmico();
		calcularXiCuadrado();
		calcularProductoYiLogXi(yiLogaritmico);
		double bLogaritmico = calcularBLogaritmico();
		double m = calcularM(bLogaritmico);
		double b = calcularB(bLogaritmico);
		double[] y = calcularY(b, m);

		return y;
	}
	
	/**
	 * @return Arreglo con la columna Y^.
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double[] calcularYiLogaritmico() {
		
		double[] yiLogaritmico = new double[tablaInicial.length];
		
		for (int i = 0; i < tablaInicial.length; i++) {
			yiLogaritmico[i] = Math.log10(tablaInicial[i][1]);
			sumaYiLogaritmico = sumaYiLogaritmico + yiLogaritmico[i];
		}
		return yiLogaritmico;
	}
	
	/**
	 * @return Arreglo con la columna Xi�.
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double[] calcularXiCuadrado() {
		double[] xiCuadrado = new double[tablaInicial.length];
		
		for (int i = 0; i < tablaInicial.length; i++) {
			xiCuadrado[i] = Math.pow(tablaInicial[i][0], 2);
			sumaXi = sumaXi + tablaInicial[i][0];
			sumaXiCuadrado = sumaXiCuadrado + xiCuadrado[i];
		}
		return xiCuadrado;
	}
	
	/**
	 * @oaram yiLogaritmico Arreglo con los valores de la columna YiLogaritmico.
	 * @return Arreglo con la column (YiLog * Xi).
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double[] calcularProductoYiLogXi(double[] yiLogaritmico) {
		double[] productoYiLogXi = new double[tablaInicial.length];
		
		for (int i = 0; i < tablaInicial.length; i++) {
			productoYiLogXi[i] = yiLogaritmico[i] * tablaInicial[i][0];
			sumaProcuctoYiLogXi = sumaProcuctoYiLogXi + productoYiLogXi[i];
		}
		return productoYiLogXi;
	}
	
	/**
	 * @return Valor de B^.
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double calcularBLogaritmico() {
		double sumaAC = (tablaInicial.length * (-sumaXiCuadrado)) + (sumaXi * sumaXi);
		double sumaBD = (sumaYiLogaritmico * (-sumaXiCuadrado)) + (sumaProcuctoYiLogXi * sumaXi);
		return sumaBD / sumaAC;
	}
	
	/**
	 * @param bLogaritmico Valor B^.
	 * @return Valor de M^.
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double calcularM(double bLogaritmico) {
		return (sumaYiLogaritmico + (-(bLogaritmico * tablaInicial.length))) / sumaXi;
	}
	
	/**
	 * @param bLogaritmico Valor de B^.
	 * @return Valor de B
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private static double calcularB(double bLogaritmico) {
		return Math.exp(bLogaritmico);
	}
	
	/**
	 * @param b Valor de M
	 * @param m Valor de B
	 * @return Arreglo con los valores de la columna X�.
	 * @author Roberto Rojas
	 * @fecha 07/06/2015
	 */
	private double[] calcularY(double b, double m) {
		double[] y = new double[tablaInicial.length];
		
		for (int i = 0; i < tablaInicial.length; i++) {
			y[i] = b * Math.exp(m * tablaInicial[i][0]);
		}
		return y;
	}
}
