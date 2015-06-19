package segundoCorte.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class MinimosCuadradosView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private int cantidadPuntos; 

	public MinimosCuadradosView(int iteraciones) {
		setTitle("Minimo Cuadrado Exponencial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 31, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMtodoMnimoCuadrado = new JLabel("M\u00E9todo M\u00EDnimo Cuadrado Exponencial");
		lblMtodoMnimoCuadrado.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMtodoMnimoCuadrado = new GridBagConstraints();
		gbc_lblMtodoMnimoCuadrado.insets = new Insets(0, 0, 5, 0);
		gbc_lblMtodoMnimoCuadrado.gridx = 0;
		gbc_lblMtodoMnimoCuadrado.gridy = 0;
		contentPane.add(lblMtodoMnimoCuadrado, gbc_lblMtodoMnimoCuadrado);
		
		JLabel lblIngreseLosValores = new JLabel("Ingrese los valores de las columnas 'Xi' y 'Yi'");
		GridBagConstraints gbc_lblIngreseLosValores = new GridBagConstraints();
		gbc_lblIngreseLosValores.anchor = GridBagConstraints.WEST;
		gbc_lblIngreseLosValores.insets = new Insets(0, 0, 5, 0);
		gbc_lblIngreseLosValores.gridx = 0;
		gbc_lblIngreseLosValores.gridy = 1;
		contentPane.add(lblIngreseLosValores, gbc_lblIngreseLosValores);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		
		/*Restringir los campos de la tabla a que solo se puedan ingreasar
		 * n&uacute;meros y puntos*/
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					String texto = (String) table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					if (!texto.contains(".") && cantidadPuntos != 0) {
						cantidadPuntos = 0;
					}
				}
				else if (e.getKeyChar() == '.' && cantidadPuntos == 1) {
					e.consume();
				}
				else if (!(e.getKeyChar() == '.') &&
					!Character.isDigit(e.getKeyChar()) || 
					table.getSelectedColumn() == 2)
				{
					e.consume();
				}
				if (e.getKeyChar() == '.' && cantidadPuntos == 0) {
					cantidadPuntos = 1;
				}
			}
		});
		
		
		
		table.setModel(new DefaultTableModel(
			getArregloModeloTabla(iteraciones),
			new String[] {
				"Xi", "Yi", "Y"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCalcular = new JButton("Calcular");
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.gridx = 0;
		gbc_btnCalcular.gridy = 3;
		contentPane.add(btnCalcular, gbc_btnCalcular);
		btnCalcular.addActionListener(new CalcularMinimoscuadradosListener(this));
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
}
