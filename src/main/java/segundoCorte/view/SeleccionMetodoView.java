package segundoCorte.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SeleccionMetodoView extends JFrame {

	private JPanel contentPane;
	public JComboBox<String> metodosComboBox = new JComboBox<String>();
	public JRadioButton rbtnFormula = new JRadioButton("F\u00F3rmula");
	public JRadioButton rdbtnTabla = new JRadioButton("Tabla");

	public SeleccionMetodoView() {
		setTitle("Análisis Númerico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{25, 30, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneElMtodo = new JLabel("Seleccionar un m\u00E9todo a continuaci\u00F3n:");
		GridBagConstraints gbc_lblSeleccioneElMtodo = new GridBagConstraints();
		gbc_lblSeleccioneElMtodo.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccioneElMtodo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSeleccioneElMtodo.gridx = 0;
		gbc_lblSeleccioneElMtodo.gridy = 0;
		panel.add(lblSeleccioneElMtodo, gbc_lblSeleccioneElMtodo);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel.add(metodosComboBox, gbc_comboBox);
		
		JLabel lblIndicarTipoDe = new JLabel("Indicar tipo de implementaci\u00F3n:");
		GridBagConstraints gbc_lblIndicarTipoDe = new GridBagConstraints();
		gbc_lblIndicarTipoDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblIndicarTipoDe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIndicarTipoDe.gridx = 0;
		gbc_lblIndicarTipoDe.gridy = 2;
		panel.add(lblIndicarTipoDe, gbc_lblIndicarTipoDe);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		
		panel_1.add(rbtnFormula);
		panel_1.add(rdbtnTabla);
		cargarComboBox();
		setLocationRelativeTo(null);
	}
	
	private void cargarComboBox() {
		DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>();
		modeloComboBox.addElement("Seleccionar...");
		modeloComboBox.addElement("Trapecio Compuesto");
		modeloComboBox.addElement("Mínimo Cuadrado Exponencial");
		modeloComboBox.addElement("Mínimo Cuadrado Logarítmico");
		modeloComboBox.addElement("Mínimo Cuadrado con Aproximación a una Recta");
		modeloComboBox.addElement("Integración Desigual");
		metodosComboBox.setModel(modeloComboBox);
	}
	

}
