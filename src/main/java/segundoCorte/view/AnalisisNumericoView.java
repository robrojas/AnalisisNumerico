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


@SuppressWarnings("serial")
public class AnalisisNumericoView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public AnalisisNumericoView() {
		setTitle("Minimo Cuadrado Exponencial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {  {1.0, 0.5}, 
						{2.0, 1.7},
						{3.0, 3.4},
						{4.0, 5.7},
						{5.0, 8.4},
			},
			new String[] {
				"Xi", "Yi", "YiLog", "Xi\u00B2", "YiLog * Xi", "Y"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCalcular = new JButton("Calcular");
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.gridx = 0;
		gbc_btnCalcular.gridy = 3;
		contentPane.add(btnCalcular, gbc_btnCalcular);
		setLocationRelativeTo(null);
		
	}
}
