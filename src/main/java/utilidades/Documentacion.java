package utilidades;

public class Documentacion {
	
	public Object[][] getDocumentacion() {
		
		Object[][] documentcacion = new Object[][] {  
				{"Ejemplo:", "((e^x * sin(x)) + ((tan(sin(x) - 5) / 2) ))^2"},
				{"Operadores", "+ , - , * , /"},
				{"PI", "pi"},
				{"Raiz Cuadrada", "sqrt(x)"},
				{"Separador", "( , )"}, 
				{"Seno", "sin(x)"}, 
				{"Coseno", "cos(x)"},
				{"Tangente", "tan(x)"},
				{"Arcoseno", "asin(x)"},
				{"Arcocoseno", "acos(x)"},
				{"Arcotangente", "atan(x)"},
				{"Arcotangente (2 Parametros)", "atan2(x,y)"},
				{"Secante", "sec(x)"},
				{"Cosecante", "cosec(x)"}, 
				{"Cotangente", "cot(x)"},
				{"Seno Hiperbo�lico", "sinh(x)"},
				{"Coseno Hiperbo�lico", "cosh(x)"},
				{"Tangente Hiperbo�lica", "tanh(x)"},
				{"Seno Hiperbo�lico inverso", "asinh(x)"},
				{"Coseno Hiperbo�lico inverso", "acosh(x)"},
				{"Tangente Hiperbo�lica inversa", "atanh(x)"}, 
				{"Logaritmo Natural", "ln(x)"},
				{"Logaritmo Base 10", "log(x)"},
				{"Logaritmo Base 2", "lg(x)"},
				{"Exponencial", "e^x"},
				{"Potencia", "x^n"},
			};
		return documentcacion;
	}

}
