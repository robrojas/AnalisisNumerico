package segundoCorte.src;

import java.math.BigDecimal;


public class IntegracionDesigualImp implements IntegracionDesigual {

	private double areaTotal = 0;
	private double[][] tabla;
	
	@Override
	public double calcular(double[][] tabla) {
		this.tabla = tabla;
		
		int iteraciones = 1;
		int indice = 0;
		
		while (indice != (tabla.length-1)) {
			
			BigDecimal a = new BigDecimal(String.valueOf(tabla[indice][0]));
			BigDecimal b = new BigDecimal(String.valueOf(tabla[indice + 1][0]));
			
			BigDecimal tendencia = b.subtract(a);
			
			for (int i = indice; i < tabla.length - 1; i++) {
				a = new BigDecimal(String.valueOf(tabla[i][0]));
				b = new BigDecimal(String.valueOf(tabla[i+1][0]));
				if (i < (tabla.length - 1) && tendencia.equals(b.subtract(a))) {
					iteraciones = iteraciones + 1;
					indice = i;
				}
				else {
					indice = i;
					break;
				}
			}
			if (indice == tabla.length-2) { indice = indice + 1; }
			if (iteraciones == 3) { calcularSimpsonUnTercio(indice); }
			else if (iteraciones == 4) { calcularSimpsonTresOctavos(indice); }
			else { getTrapecio(indice) ;}
			iteraciones = 1;
		}
		return areaTotal;
	}
	
	private void getTrapecio(int indice) {
		areaTotal = areaTotal + 
				   ((tabla[indice][0] - tabla[indice - 1][0]) * 
				   ((tabla[indice - 1][1] + tabla[indice][1]) / 2));
	}
	
	private void calcularSimpsonTresOctavos(int indice) {
		areaTotal = areaTotal +
				   ((tabla[indice][0] - tabla[indice - 3][0]) *
				   ((tabla[indice][1] + (3 * tabla[indice - 2][1]) + (3 * tabla[indice - 1][1]) + tabla[indice - 3][1]) / 8));
	}
	
	private void calcularSimpsonUnTercio(int indice) {
		
		areaTotal = areaTotal + 
				    (((tabla[indice][0] - tabla[indice - 2][0]) / 6) *
				    (tabla[indice - 2][1] + (4 * tabla[indice - 1][1]) + tabla[indice][1]));
	}
	
	

	
	
}
