package segundoCorte.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AnalisisNumericoView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalisisNumericoView frame = new AnalisisNumericoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AnalisisNumericoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelDatosTabla = new JPanel();
		panelDatosTabla.setBorder(new TitledBorder(null, "Datos Tabla", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosTabla = new GridBagConstraints();
		gbc_panelDatosTabla.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatosTabla.fill = GridBagConstraints.BOTH;
		gbc_panelDatosTabla.gridx = 0;
		gbc_panelDatosTabla.gridy = 0;
		contentPane.add(panelDatosTabla, gbc_panelDatosTabla);
		GridBagLayout gbl_panelDatosTabla = new GridBagLayout();
		gbl_panelDatosTabla.columnWidths = new int[]{0, 0, 0};
		gbl_panelDatosTabla.rowHeights = new int[]{0, 0, 0};
		gbl_panelDatosTabla.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDatosTabla.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelDatosTabla.setLayout(gbl_panelDatosTabla);
		
		JPanel panelDatosXi = new JPanel();
		panelDatosXi.setBorder(new TitledBorder(null, "Xi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosXi = new GridBagConstraints();
		gbc_panelDatosXi.insets = new Insets(0, 0, 5, 5);
		gbc_panelDatosXi.fill = GridBagConstraints.BOTH;
		gbc_panelDatosXi.gridx = 0;
		gbc_panelDatosXi.gridy = 0;
		panelDatosTabla.add(panelDatosXi, gbc_panelDatosXi);
		
		JButton botonX = new JButton("+");
		botonX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelValoresTabla p = new PanelValoresTabla();
//				panelDatosXi.add(panelValoresTabla);
			}
		});
		GridBagConstraints gbc_botonX = new GridBagConstraints();
		gbc_botonX.insets = new Insets(0, 0, 5, 0);
		gbc_botonX.gridx = 1;
		gbc_botonX.gridy = 0;
		panelDatosTabla.add(botonX, gbc_botonX);
		
		JPanel panelDatosYi = new JPanel();
		panelDatosYi.setBorder(new TitledBorder(null, "Yi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosYi = new GridBagConstraints();
		gbc_panelDatosYi.insets = new Insets(0, 0, 0, 5);
		gbc_panelDatosYi.fill = GridBagConstraints.BOTH;
		gbc_panelDatosYi.gridx = 0;
		gbc_panelDatosYi.gridy = 1;
		panelDatosTabla.add(panelDatosYi, gbc_panelDatosYi);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		PanelValoresTabla panelTablaXi = new PanelValoresTabla();
		GridBagLayout gridBagLayout = (GridBagLayout) panelTablaXi.getLayout();
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		panelDatosXi.add(panelTablaXi);
		PanelValoresTabla panelTablaYi = new PanelValoresTabla();
		panelDatosYi.add(panelTablaYi);
		
		JButton botonY = new JButton("+");
		GridBagConstraints gbc_botonY = new GridBagConstraints();
		gbc_botonY.gridx = 1;
		gbc_botonY.gridy = 1;
		panelDatosTabla.add(botonY, gbc_botonY);
		
	}

}
