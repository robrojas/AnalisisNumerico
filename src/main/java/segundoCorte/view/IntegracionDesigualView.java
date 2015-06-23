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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import segundoCorte.view.listener.IntegracionDesigualViewListener;
import utilidades.Documentacion;

@SuppressWarnings("serial")
public class IntegracionDesigualView extends JDialog {

	private JPanel contentPane;
	private int cantidadPuntos; 
	private int columnaActual;
	private int filaActual;
	
	public JTable tabla;

	public IntegracionDesigualView(Window parent, boolean modal, int iteraciones) {
		setTitle("Integración Desigual");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{31, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIngreseLosValores = new JLabel("Ingrese los valores de las columnas 'Xi' y 'Yi'");
		GridBagConstraints gbc_lblIngreseLosValores = new GridBagConstraints();
		gbc_lblIngreseLosValores.anchor = GridBagConstraints.WEST;
		gbc_lblIngreseLosValores.insets = new Insets(0, 0, 5, 0);
		gbc_lblIngreseLosValores.gridx = 0;
		gbc_lblIngreseLosValores.gridy = 0;
		contentPane.add(lblIngreseLosValores, gbc_lblIngreseLosValores);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
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
			getArregloModeloTabla(iteraciones),
			new String[] {
				"Xi", "Yi"
			}
		));
		scrollPane.setViewportView(tabla);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new IntegracionDesigualViewListener(this));
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
	public JTable getTable() { return tabla; }

}
