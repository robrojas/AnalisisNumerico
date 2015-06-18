package segundoCorte.src;

/**
 * Implementa el m&eacute;todo para resoluci&oacute;n de ecuaciones diferenciales llamado
 * Minimos Cuadrado con Aproximaci&oacute;n a una Recta.
 * <pre><b>Formulas:</b>
 *    M E Xi + (B^ * n) =  E Yi.
 *    M E Xi² + (B^ * E Xi) = E (Yi * Xi). 
 *    b = e^^B^.
 *    y = M * X + b.</pre>
 * 
 * <pre><b>Leyenda:</b>
 *    E = Sumatoria. 
 *    ^ = Logaritmico. Ejem: B^ = BLogaritmico. 
 *    ² = Cuadrado de. ejem: 2² = 2*2. 
 *    ^^ = Potencia.</pre> 
 *    
 * @author Roberto Rojas
 * @fecha 17/06/2015
 */
public interface MinCuadAproximacionAUnaRecta {
	
	public double[] calcular(double[][] tabla);
}
