package segundoCorte.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import segundoCorte.view.listener.SeleccionarMetodoListener;

@SuppressWarnings("serial")
public class SeleccionMetodoView extends JFrame {

	private JPanel contentPane;
	public JComboBox<String> metodosComboBox = new JComboBox<String>();
	public JRadioButton rbtnTabla = new JRadioButton("Tabla");
	public JRadioButton rbtnFormula = new JRadioButton("F\u00F3rmula");

	public SeleccionMetodoView() {
		setTitle("Análisis Númerico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{112, 0, 0};
		gbl_panel.rowHeights = new int[]{25, 30, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneElMtodo = new JLabel("Seleccionar un m\u00E9todo a continuaci\u00F3n:");
		GridBagConstraints gbc_lblSeleccioneElMtodo = new GridBagConstraints();
		gbc_lblSeleccioneElMtodo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneElMtodo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSeleccioneElMtodo.gridx = 0;
		gbc_lblSeleccioneElMtodo.gridy = 0;
		panel.add(lblSeleccioneElMtodo, gbc_lblSeleccioneElMtodo);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		rbtnTabla.setEnabled(false);
		panel_1.add(rbtnTabla);
		rbtnFormula.setEnabled(false);
		
		panel_1.add(rbtnFormula);
		
		rbtnTabla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rbtnFormula.isSelected()) {
					rbtnTabla.setSelected(true);
					rbtnFormula.setSelected(false);
					
				}
			}
		});
		
		rbtnFormula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rbtnTabla.isSelected()) {
					rbtnFormula.setSelected(true);
					rbtnTabla.setSelected(false);
				}
			}
		});
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		metodosComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarRadioButtons();
			}
		});
		panel.add(metodosComboBox, gbc_comboBox);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new SeleccionarMetodoListener(this));
		panel_2.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Salir");
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panel_2.add(btnCerrar);
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
	
	private void habilitarRadioButtons() {
			
		if (metodosComboBox.getSelectedIndex() == 0) {
			rbtnTabla.setSelected(false);
			rbtnFormula.setSelected(false);
			rbtnTabla.setEnabled(false);
			rbtnFormula.setEnabled(false);
		}
		else if (metodosComboBox.getSelectedIndex() == 1) {
			rbtnFormula.setEnabled(true);
			rbtnTabla.setEnabled(true);
			rbtnFormula.setSelected(true);
		}
		
		else {
			rbtnFormula.setSelected(false);
			rbtnFormula.setEnabled(false);
			rbtnTabla.setEnabled(true);
			rbtnTabla.setSelected(true);
		}
	}

	/*** * Getters * ***/
	public JComboBox<String> getMetodosComboBox() { return metodosComboBox; }
	public JRadioButton getRbtnTabla() { return rbtnTabla; }
	public JRadioButton getRbtnFormula() { return rbtnFormula; }
	
	
	

}
