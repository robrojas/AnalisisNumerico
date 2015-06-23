package segundoCorte.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import segundoCorte.view.listener.TrapecioCompuestoViewListener;
import utilidades.Documentacion;

@SuppressWarnings("serial")
public class TrapecioCompuestoView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int cantidadPILimiteSuperior = 0;
	private int cantidadPILimiteInferior = 0;
	
	public JTextField txtLimiteInferior;
	public JTextField txtLimiteSuperior;
	public JTextField txtFuncion;
	public int iteraciones;
	
	
	public JRadioButton rbtnRadianes = new JRadioButton("Radianes");
	public JRadioButton rbtnGrados = new JRadioButton("Grados");

	public TrapecioCompuestoView(Window parent, boolean modal, int iteraciones) {
		super((Frame) parent, modal);
		this.iteraciones = iteraciones;
		setBounds(100, 100, 300, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{34, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gridBagLayout);
		{
			JLabel lblIngresarLosDatos = new JLabel("Ingresar los datos se\u00F1alados a continuaci\u00F3n:");
			GridBagConstraints gbc_lblIngresarLosDatos = new GridBagConstraints();
			gbc_lblIngresarLosDatos.insets = new Insets(0, 0, 5, 0);
			gbc_lblIngresarLosDatos.anchor = GridBagConstraints.WEST;
			gbc_lblIngresarLosDatos.gridx = 0;
			gbc_lblIngresarLosDatos.gridy = 0;
			contentPanel.add(lblIngresarLosDatos, gbc_lblIngresarLosDatos);
		}
		{
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			contentPanel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{98, 0, 109, 0};
			gbl_panel_1.rowHeights = new int[]{23, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				JLabel lblLimitesEn = new JLabel("Limites en:");
				GridBagConstraints gbc_lblLimitesEn = new GridBagConstraints();
				gbc_lblLimitesEn.anchor = GridBagConstraints.WEST;
				gbc_lblLimitesEn.insets = new Insets(0, 0, 0, 5);
				gbc_lblLimitesEn.gridx = 0;
				gbc_lblLimitesEn.gridy = 0;
				panel_1.add(lblLimitesEn, gbc_lblLimitesEn);
			}
			rbtnGrados.setSelected(true);
			{
				GridBagConstraints gbc_rbtnGrados = new GridBagConstraints();
				gbc_rbtnGrados.insets = new Insets(0, 0, 0, 5);
				gbc_rbtnGrados.anchor = GridBagConstraints.NORTH;
				gbc_rbtnGrados.gridx = 1;
				gbc_rbtnGrados.gridy = 0;
				panel_1.add(rbtnGrados, gbc_rbtnGrados);
			}
			
			rbtnGrados.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (rbtnRadianes.isSelected()) {
						rbtnGrados.setSelected(true);
						rbtnRadianes.setSelected(false);
						txtLimiteInferior.setText("");
						txtLimiteSuperior.setText("");
						cantidadPILimiteInferior = 0;
						cantidadPILimiteSuperior = 0;
						
					}
					else {
						rbtnGrados.setSelected(true);
					}
				}
			});
			{
				GridBagConstraints gbc_rbtnRadianes = new GridBagConstraints();
				gbc_rbtnRadianes.anchor = GridBagConstraints.NORTH;
				gbc_rbtnRadianes.gridx = 2;
				gbc_rbtnRadianes.gridy = 0;
				panel_1.add(rbtnRadianes, gbc_rbtnRadianes);
			}
			
			rbtnRadianes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (rbtnGrados.isSelected()) {
						rbtnRadianes.setSelected(true);
						rbtnGrados.setSelected(false);
						txtLimiteInferior.setText("");
						txtLimiteSuperior.setText("");
					}
					else {
						rbtnRadianes.setSelected(true);
					}
				}
			});
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{93, 125, 0};
			gbl_panel.rowHeights = new int[]{35, 34, 31, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblNewLabel = new JLabel("Limite Inferior:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				txtLimiteInferior = new JTextField();
				txtLimiteInferior.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if (rbtnGrados.isSelected()) {
							if (!Character.isDigit(e.getKeyChar()) &&
								!(e.getKeyChar() == '-')) {
								e.consume();
							}
						}
						else if (!Character.isDigit(e.getKeyChar()) &&
								 !(e.getKeyChar() == 'p') &&
							     !(e.getKeyChar() == 'i') && 
							     !(e.getKeyChar() == '.') && 
							     !(e.getKeyChar() == '/') &&
							     !(e.getKeyChar() == '*') && 
							     !(e.getKeyChar() == '-')) 
						{
							e.consume();
						}
					}
				});
				
				GridBagConstraints gbc_txtLimiteInferior = new GridBagConstraints();
				gbc_txtLimiteInferior.insets = new Insets(0, 0, 5, 0);
				gbc_txtLimiteInferior.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLimiteInferior.gridx = 1;
				gbc_txtLimiteInferior.gridy = 0;
				panel.add(txtLimiteInferior, gbc_txtLimiteInferior);
				txtLimiteInferior.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Limite superior:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 1;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				txtLimiteSuperior = new JTextField();
				txtLimiteSuperior.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if (rbtnGrados.isSelected()) {
							if (!Character.isDigit(e.getKeyChar()) &&
								!(e.getKeyChar() == '-')) {
								e.consume();
							}
						}
						else if (!Character.isDigit(e.getKeyChar()) &&
								 !(e.getKeyChar() == 'p') &&
							     !(e.getKeyChar() == 'i') && 
							     !(e.getKeyChar() == '.') && 
							     !(e.getKeyChar() == '/') &&
							     !(e.getKeyChar() == '*') && 
							     !(e.getKeyChar() == '-')) 
							{
								e.consume();
							}				
						}
				});
				GridBagConstraints gbc_txtLimiteSuperior = new GridBagConstraints();
				gbc_txtLimiteSuperior.insets = new Insets(0, 0, 5, 0);
				gbc_txtLimiteSuperior.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLimiteSuperior.gridx = 1;
				gbc_txtLimiteSuperior.gridy = 1;
				panel.add(txtLimiteSuperior, gbc_txtLimiteSuperior);
				txtLimiteSuperior.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Funci\u00F3n:");
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 2;
				panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
			}
			{
				txtFuncion = new JTextField();
				GridBagConstraints gbc_txtFuncion = new GridBagConstraints();
				gbc_txtFuncion.insets = new Insets(0, 0, 5, 0);
				gbc_txtFuncion.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFuncion.gridx = 1;
				gbc_txtFuncion.gridy = 2;
				panel.add(txtFuncion, gbc_txtFuncion);
				txtFuncion.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.gridwidth = 2;
				gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 3;
				panel.add(panel_1, gbc_panel_1);
				{
					JButton btnCalcular = new JButton("Calcular");
					btnCalcular.addActionListener(new TrapecioCompuestoViewListener(this));
					panel_1.add(btnCalcular);
				}
				{
					JButton btnCerrar = new JButton("Cerrar");
					btnCerrar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					panel_1.add(btnCerrar);
				}
				{
					JButton btnAyuda = new JButton("Ayuda");
					btnAyuda.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Documentacion doc = new Documentacion();
							DocumentacionView docuView = new DocumentacionView(null, true, doc.getDocumentacion());
							docuView.setVisible(true);
						}
					});
					panel_1.add(btnAyuda);
				}
			}
		}
		setTitle("Trapecio Compuesto");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	/*** * Getters * ***/
	public JTextField getTxtLimiteInferior() { return txtLimiteInferior; }
	public JTextField getTxtLimiteSuperior() { return txtLimiteSuperior; }
	public JTextField getTxtFuncion() { return txtFuncion; }
	public JRadioButton getRbtnRadianes() { return rbtnRadianes; }
	public JRadioButton getRbtnGrados() { return rbtnGrados; }
	public int getIteraciones() { return iteraciones; }
	
	
	

}
