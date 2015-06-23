package segundoCorte.view;

import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import segundoCorte.view.listener.TrapecioCompuestoTableViewListener;
import utilidades.Documentacion;

@SuppressWarnings("serial")
public class TrapecioCompuestoTablaView extends JDialog {

	private final JPanel contentPanel;;
	private int cantidadPuntos; 
	private int columnaActual;
	private int filaActual;
	
	public JTable tabla;
	public JTextField txtTamanioPaso;

	public TrapecioCompuestoTablaView(Window parent, boolean modal, int iteraciones) {
		setTitle("Trapecio Compuesto");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 241);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{31, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPane);
		
		JLabel lblIngreseLosValores = new JLabel("Ingrese los valores de las columnas 'Xm' y 'Ym'");
		GridBagConstraints gbc_lblIngreseLosValores = new GridBagConstraints();
		gbc_lblIngreseLosValores.anchor = GridBagConstraints.WEST;
		gbc_lblIngreseLosValores.insets = new Insets(0, 0, 5, 0);
		gbc_lblIngreseLosValores.gridx = 0;
		gbc_lblIngreseLosValores.gridy = 0;
		contentPanel.add(lblIngreseLosValores, gbc_lblIngreseLosValores);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		tabla = new JTable();
		
		/*Restringir los campos de la tabla a que solo se puedan ingreasar
		 * n&uacute;meros y puntos*/
		tabla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					String texto = (String) tabla.getModel().getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
					if (!texto.contains(".") && cantidadPuntos != 0) {
						cantidadPuntos = 0;
					}
				}
				else if (e.getKeyChar() == '.' && cantidadPuntos == 1) {
					e.consume();
				}
				else if (!(e.getKeyChar() == '.') &&
					!Character.isDigit(e.getKeyChar()) || 
					tabla.getSelectedColumn() == 2)
				{
					e.consume();
				}
				if (e.getKeyChar() == '.' && cantidadPuntos == 0) {
					cantidadPuntos = 1;
				}
				if (!(columnaActual == tabla.getSelectedColumn()) || !(filaActual == tabla.getSelectedRow())) {
					columnaActual = tabla.getSelectedColumn();
					filaActual = tabla.getSelectedRow();
					cantidadPuntos = 0;
				}
			}
		});
		
		tabla.setModel(new DefaultTableModel(
			getArregloModeloTabla(iteraciones + 1),
			new String[] {
				"Xm", "Ym"
			}
		));
		scrollPane.setViewportView(tabla);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblTramaoDePaso = new JLabel("Trama\u00F1o de paso:");
		GridBagConstraints gbc_lblTramaoDePaso = new GridBagConstraints();
		gbc_lblTramaoDePaso.insets = new Insets(0, 0, 0, 5);
		gbc_lblTramaoDePaso.anchor = GridBagConstraints.EAST;
		gbc_lblTramaoDePaso.gridx = 0;
		gbc_lblTramaoDePaso.gridy = 0;
		panel_1.add(lblTramaoDePaso, gbc_lblTramaoDePaso);
		
		txtTamanioPaso = new JTextField();
		txtTamanioPaso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					String texto = txtTamanioPaso.getText();
					if (!texto.contains(".") && cantidadPuntos != 0) {
						cantidadPuntos = 0;
					}
				}
				else if (e.getKeyChar() == '.' && cantidadPuntos == 1) {
					e.consume();
				}
				else if (!(e.getKeyChar() == '.') &&
					!Character.isDigit(e.getKeyChar()) || 
					tabla.getSelectedColumn() == 2)
				{
					e.consume();
				}
				if (e.getKeyChar() == '.' && cantidadPuntos == 0) {
					cantidadPuntos = 1;
				}
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(txtTamanioPaso, gbc_textField);
		txtTamanioPaso.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new TrapecioCompuestoTableViewListener(this, iteraciones));
		panel.add(btnCalcular);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnCerrar);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Documentacion doc = new Documentacion();
				DocumentacionView docuView = new DocumentacionView(null, true, doc.getDocumentacion());
				docuView.setVisible(true);
			}
		});
		panel.add(btnAyuda);
		setLocationRelativeTo(null);
	}
	
	private Object[][] getArregloModeloTabla(int iteraciones) {
		Object[][] arreglo = new Object[iteraciones][3];
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < 3; j++) {
				arreglo[i][j] = "";
			}
		}
		return arreglo;
	}

	/*** * Getters * ***/
	public JTable getTabla() { return tabla; }
	public JTextField getTxtTamanioPaso() { return txtTamanioPaso; }
	
}
