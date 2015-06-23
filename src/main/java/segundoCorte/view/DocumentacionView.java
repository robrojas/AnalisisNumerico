package segundoCorte.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DocumentacionView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tabla;

	public DocumentacionView(Window parent, boolean modal, Object[][] documentacion) {
		super((JDialog) parent, modal);
		setBounds(100, 100, 500, 400);
		setTitle("Documentación");
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAContinuacinAyuda = new JLabel("A continuaci\u00F3n ayuda para el llenado de los campos");
			GridBagConstraints gbc_lblAContinuacinAyuda = new GridBagConstraints();
			gbc_lblAContinuacinAyuda.anchor = GridBagConstraints.WEST;
			gbc_lblAContinuacinAyuda.insets = new Insets(0, 0, 5, 0);
			gbc_lblAContinuacinAyuda.gridx = 0;
			gbc_lblAContinuacinAyuda.gridy = 0;
			contentPanel.add(lblAContinuacinAyuda, gbc_lblAContinuacinAyuda);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 1;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				tabla = new JTable();
				tabla.setEnabled(false);
				tabla.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				tabla.setModel(new DefaultTableModel(
					documentacion,
					new String[] {
						"Nombre", "Descripción"
					}
				));
				scrollPane.setViewportView(tabla);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cerrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setLocationRelativeTo(null);
	}

}
