package segundoCorte.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;

import segundoCorte.src.TrapecioCompuesto;
import segundoCorte.src.TrapecioCompuestoImp;
import segundoCorte.view.TrapecioCompuestoView;

public class TrapecioCompuestoViewListener implements ActionListener {

	private TrapecioCompuestoView view;
	
	public TrapecioCompuestoViewListener(TrapecioCompuestoView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		double limiteInferior;
		double limiteSuperior;
		double resultado;
		TrapecioCompuesto trapecio = new TrapecioCompuestoImp();
		
		if (view.getTxtLimiteInferior().getText().equals("") || 
			view.getTxtLimiteSuperior().getText().equals("") || 
			view.getTxtFuncion().getText().equals(""))
		{
			mensajeCampoVacio();
		}
		else {
			if (view.getRbtnGrados().isSelected()) {
				limiteInferior = calcularLimiteGrados(Integer.parseInt(view.getTxtLimiteInferior().getText()));
				limiteSuperior = calcularLimiteGrados(Integer.parseInt(view.getTxtLimiteSuperior().getText()));
				resultado = trapecio.trapecioCompuesto(limiteInferior, 
						   limiteSuperior, 
						   view.getIteraciones(), 
						   view.getTxtFuncion().getText());
				JOptionPane.showMessageDialog(view, 
											 "El resultado es: " + resultado,
											 "Trapecio Compuesto",
											 JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				if (isParseable(view.getTxtLimiteInferior().getText()) && isParseable(view.getTxtLimiteSuperior().getText())) {
					
					limiteInferior = calcularLimiteRadianes(view.getTxtLimiteInferior().getText());
					limiteSuperior = calcularLimiteRadianes(view.getTxtLimiteSuperior().getText());
					if (limiteInferior < 0 || limiteSuperior < 0) {
						JOptionPane.showMessageDialog(view, 
								                     "Alguno de los límites cargados no contiene denominador", 
								                     "Trapecio Compuesto", 
								                     JOptionPane.ERROR_MESSAGE);
					}
					else {
						resultado = trapecio.trapecioCompuesto(limiteInferior, 
								   limiteSuperior, 
								   view.getIteraciones(), 
								   view.getTxtFuncion().getText());
						JOptionPane.showMessageDialog(view, 
													 "El resultado es: " + resultado,
													 "Trapecio Compuesto",
													 JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(view, 
							 "Uno de los limites ingresados no es válido.",
							 "Trapecio Compuesto",
							 JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		}
	}
	
	private double calcularLimiteGrados(int limite) {
		return (limite * Math.PI) / 180;
	}
	
	private double calcularLimiteRadianes(String limite) {
		Jep jep = new Jep();
		try {
			jep.parse(limite);
			return (Double) jep.evaluate();
		} catch (ParseException e) {
			return -1;
		} 
		  catch (EvaluationException e) { 
			  return -1;
		  }
	}
	
	private void mensajeCampoVacio() {
		JOptionPane.showMessageDialog(view,
								      "Todos los campos son de llenado obligatorio",
								      "Error",
								      JOptionPane.ERROR_MESSAGE);
	}
	
	private boolean isParseable(String cadena) {
		Jep jep = new Jep();
		try {
			jep.parse(cadena);
			jep.evaluate();
			return true;
		} catch (ParseException e) {
			return false;
		} catch (EvaluationException e) {
			return false;
		}
	}

}
