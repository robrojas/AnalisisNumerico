package segundoCorte.src;


public class IntegracionDesigualImp implements IntegracionDesigual {

	private double areaTotal = 0;
	private double[][] tabla;
	
	@Override
	public double calcular(double[][] tabla) {
		this.tabla = tabla;
		
		int iteraciones = 0;
		int indice = 0;
		
		while (indice <= tabla.length - 1) {
			double tendencia = tabla[indice + 1][0] - tabla[indice][0];
		
			for (int i = indice; i < tabla.length; i++) {
				System.out.println((tabla[i+1][0] - tabla[i][0]));
				if ((tabla[i+1][0] - tabla[i][0]) == tendencia) {
//					tendencia = tabla[i+1][0] - tabla[i][0];
					iteraciones = iteraciones + 1;
				}
				else {
					indice = i;
					iteraciones = 0;
//					tendencia = 0;
					break;
				}
			}
			if (iteraciones == 3) { calcularSimpsonUnTercio(indice); }
			else if (iteraciones == 4) { calcularSimpsonTresOctavos(indice); }
			else { getTrapecio(indice) ;}
		}
		
		return 0;
	}
	
	private void getTrapecio(int indice) {
		areaTotal = areaTotal + 
				   ((tabla[indice][0] - tabla[indice - 1][0]) * 
				   ((tabla[indice - 1][1] + tabla[indice][1]) / 2)); 
	}
	
	private void calcularSimpsonTresOctavos(int indice) {
		areaTotal = areaTotal +
				   ((tabla[indice][0] - tabla[indice - 3][0]) *
				   (tabla[indice][1] + (3 * tabla[indice - 2][1]) + (3 * tabla[indice - 1][1]) + tabla[indice - 3][1]));
	}
	
	private void calcularSimpsonUnTercio(int indice) {
		areaTotal = areaTotal + 
				    (((tabla[indice][0] - tabla[indice - 2][0]) / 6) *
				    (tabla[indice - 2][1] + (4 * tabla[indice - 1][1]) + tabla[indice][1]));
	}
	
	

	
	
}
