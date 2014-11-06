import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;


public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setTitle("Movie Database Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[1077.00,grow]", "[231.00,grow][470.00,grow]"));
		
		JPanel queryPanel = new JPanel();
		panel.add(queryPanel, "cell 0 0,grow");
		GridBagLayout gbl_queryPanel = new GridBagLayout();
		gbl_queryPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_queryPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_queryPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_queryPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		queryPanel.setLayout(gbl_queryPanel);
		
		JLabel lblMediaTitle = new JLabel("Media Title");
		GridBagConstraints gbc_lblMediaTitle = new GridBagConstraints();
		gbc_lblMediaTitle.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMediaTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediaTitle.gridx = 1;
		gbc_lblMediaTitle.gridy = 0;
		queryPanel.add(lblMediaTitle, gbc_lblMediaTitle);
		
		JLabel lblInformationType = new JLabel("Information Type");
		GridBagConstraints gbc_lblInformationType = new GridBagConstraints();
		gbc_lblInformationType.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblInformationType.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformationType.gridx = 4;
		gbc_lblInformationType.gridy = 0;
		queryPanel.add(lblInformationType, gbc_lblInformationType);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		queryPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"* ALL", "Genre", "Runtime", "Language", "Production Year", "Plot"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		queryPanel.add(comboBox, gbc_comboBox);
		
		JLabel lblActorActress = new JLabel("Actor / Actress / Other");
		GridBagConstraints gbc_lblActorActress = new GridBagConstraints();
		gbc_lblActorActress.anchor = GridBagConstraints.WEST;
		gbc_lblActorActress.insets = new Insets(0, 0, 5, 5);
		gbc_lblActorActress.gridx = 1;
		gbc_lblActorActress.gridy = 2;
		queryPanel.add(lblActorActress, gbc_lblActorActress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		queryPanel.add(textField_1, gbc_textField_1);
		
		JLabel lblCharacterName = new JLabel("Character Name");
		GridBagConstraints gbc_lblCharacterName = new GridBagConstraints();
		gbc_lblCharacterName.anchor = GridBagConstraints.WEST;
		gbc_lblCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharacterName.gridx = 1;
		gbc_lblCharacterName.gridy = 4;
		queryPanel.add(lblCharacterName, gbc_lblCharacterName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		queryPanel.add(textField_2, gbc_textField_2);
		
		JButton btnNewButton = new JButton("Search");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 6;
		queryPanel.add(btnNewButton, gbc_btnNewButton);
		
		JPanel dataPanel = new JPanel();
		panel.add(dataPanel, "cell 0 1,grow");
		dataPanel.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		dataPanel.add(textPane, BorderLayout.CENTER);
	}

}
