package segundoCorte.src;

/**
 * Implementa el m&eacute;todo para resoluci&oacute;n de ecuaciones diferenciales llamado
 * Minimos Cuadrado Exponencial.
 * <pre><b>Formulas:</b>
 *    M E Xi + (B^ * n) =  E Yi^.
 *    M E Xi² + (B^ * E Xi) = E (Yi^ * Xi). 
 *    b = e^^B^.
 *    y = b * e^^M*X.</pre>
 * 
 * <pre><b>Leyenda:</b>
 *    E = Sumatoria. 
 *    ^ = Logaritmico. Ejem: B^ = BLogaritmico. 
 *    ² = Cuadrado de. ejem: 2² = 2*2. 
 *    ^^ = Potencia.</pre> 
 *    
 * @author Roberto Rojas
 * @fecha 04/06/2015
 */
public interface MinimosCuadradoExponencial {
	
	public double[] calcular(double[][] tabla);

}
