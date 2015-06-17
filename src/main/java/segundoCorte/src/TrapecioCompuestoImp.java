package segundoCorte.src;

import javax.swing.JOptionPane;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;


public class TrapecioCompuestoImp implements TrapecioCompuesto {

	@Override
	public double trapecioCompuesto(double limInferior, 
									double limSuperiorParcial, 
									int iteraciones,
									String funcion) 
	{
		double limiteSuperior = calcularLimiteSuperior(limSuperiorParcial);
		double tamanioDePaso = calcularTamanioDePaso(limInferior, limiteSuperior, iteraciones);
		
		double[][] tabla = new double[iteraciones + 1][2];
		tabla[0][0] = limInferior;
		
		/*calcular valorer de la columna Xm*/
		for (int i = 1; i < iteraciones + 1; i++) {
			tabla[i][0] = tabla[i - 1][0] + tamanioDePaso;
		}
		
		try {
			tabla = calcularYm(funcion, tabla);
		} catch (JepException e) {
			JOptionPane.showMessageDialog(null, 
										  "No se pudo parsear la funcion", 
										  "Error en parseo",
										  JOptionPane.ERROR_MESSAGE);
			System.out.println("Error parseando la funcion: " + e);
		}
		
		return getArea(tamanioDePaso, tabla, iteraciones);
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
	 * @param tamanioDePaso Tamanio de paso
	 * @param tabla Tabla sobre la que se har&aacute; la interaci&oacute;n.
	 * @param iteraciones Cantidad de interaciones que se har&aacute;n sobre la tabla.
	 * @return Resultado del calculo del &aacute;rea.
	 * @author Roberto Rojas
	 * @fecha 01/06/2015
	 */
	private static double getArea(double tamanioDePaso, double[][] tabla, int iteraciones) {

		double sumatoria = 0; 
		for (int i = 1; i <= iteraciones - 1; i++){
			for (int j = 1; j < 2; j++) {
				sumatoria = sumatoria + tabla[i][j];
			}
		}
		return (tamanioDePaso / 2) * (tabla[0][1] + tabla[iteraciones][1] + (2 * sumatoria));  
		
	}
	
	private static double[][] calcularYm(String funcion, double[][] tabla) throws JepException {
		
		for (int i = 0; i < tabla.length; i++) {
			Jep jep = new Jep();
			
			/*Agregar variables al jep para el parseo de la funci&oacute;n*/
			if (funcion.contains("x")) { jep.addVariable("x", tabla[i][0]); }

			jep.parse(funcion);
			tabla[i][1] = jep.evaluateD();
		}
		
		return tabla;
	}
}
