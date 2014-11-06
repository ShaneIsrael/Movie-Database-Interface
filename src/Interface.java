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
	private JTextField mediaField;
	private JTextField personField;
	private JTextField charField;
	private JTextField prodField;

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
		gbl_queryPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_queryPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		queryPanel.setLayout(gbl_queryPanel);
		
		JLabel lblMediaTitle = new JLabel("Media Title");
		GridBagConstraints gbc_lblMediaTitle = new GridBagConstraints();
		gbc_lblMediaTitle.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMediaTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediaTitle.gridx = 1;
		gbc_lblMediaTitle.gridy = 0;
		queryPanel.add(lblMediaTitle, gbc_lblMediaTitle);
		
		JLabel lblProductionYear = new JLabel("Production Year");
		GridBagConstraints gbc_lblProductionYear = new GridBagConstraints();
		gbc_lblProductionYear.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblProductionYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblProductionYear.gridx = 4;
		gbc_lblProductionYear.gridy = 0;
		queryPanel.add(lblProductionYear, gbc_lblProductionYear);
		
		mediaField = new JTextField();
		GridBagConstraints gbc_mediaField = new GridBagConstraints();
		gbc_mediaField.gridwidth = 2;
		gbc_mediaField.insets = new Insets(0, 0, 5, 5);
		gbc_mediaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mediaField.gridx = 1;
		gbc_mediaField.gridy = 1;
		queryPanel.add(mediaField, gbc_mediaField);
		mediaField.setColumns(10);
		
		prodField = new JTextField();
		GridBagConstraints gbc_prodField = new GridBagConstraints();
		gbc_prodField.gridwidth = 2;
		gbc_prodField.insets = new Insets(0, 0, 5, 5);
		gbc_prodField.fill = GridBagConstraints.HORIZONTAL;
		gbc_prodField.gridx = 4;
		gbc_prodField.gridy = 1;
		queryPanel.add(prodField, gbc_prodField);
		prodField.setColumns(10);
		
		JLabel lblActorActress = new JLabel("Actor / Actress / Other");
		GridBagConstraints gbc_lblActorActress = new GridBagConstraints();
		gbc_lblActorActress.anchor = GridBagConstraints.WEST;
		gbc_lblActorActress.insets = new Insets(0, 0, 5, 5);
		gbc_lblActorActress.gridx = 1;
		gbc_lblActorActress.gridy = 2;
		queryPanel.add(lblActorActress, gbc_lblActorActress);
		
		JLabel lblInformationType = new JLabel("Information Type");
		GridBagConstraints gbc_lblInformationType = new GridBagConstraints();
		gbc_lblInformationType.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblInformationType.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformationType.gridx = 4;
		gbc_lblInformationType.gridy = 2;
		queryPanel.add(lblInformationType, gbc_lblInformationType);
		
		personField = new JTextField();
		personField.setColumns(10);
		GridBagConstraints gbc_personField = new GridBagConstraints();
		gbc_personField.gridwidth = 2;
		gbc_personField.insets = new Insets(0, 0, 5, 5);
		gbc_personField.fill = GridBagConstraints.HORIZONTAL;
		gbc_personField.gridx = 1;
		gbc_personField.gridy = 3;
		queryPanel.add(personField, gbc_personField);
		
		JComboBox infoBox = new JComboBox();
		infoBox.setModel(new DefaultComboBoxModel(new String[] {"* ALL", "Genre", "Runtime", "Language", "Production Year", "Plot"}));
		GridBagConstraints gbc_infoBox = new GridBagConstraints();
		gbc_infoBox.gridwidth = 2;
		gbc_infoBox.insets = new Insets(0, 0, 5, 5);
		gbc_infoBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_infoBox.gridx = 4;
		gbc_infoBox.gridy = 3;
		queryPanel.add(infoBox, gbc_infoBox);
		
		JLabel lblCharacterName = new JLabel("Character Name");
		GridBagConstraints gbc_lblCharacterName = new GridBagConstraints();
		gbc_lblCharacterName.anchor = GridBagConstraints.WEST;
		gbc_lblCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharacterName.gridx = 1;
		gbc_lblCharacterName.gridy = 4;
		queryPanel.add(lblCharacterName, gbc_lblCharacterName);
		
		JLabel lblMediaType = new JLabel("Media Type");
		GridBagConstraints gbc_lblMediaType = new GridBagConstraints();
		gbc_lblMediaType.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMediaType.insets = new Insets(0, 0, 5, 5);
		gbc_lblMediaType.gridx = 4;
		gbc_lblMediaType.gridy = 4;
		queryPanel.add(lblMediaType, gbc_lblMediaType);
		
		charField = new JTextField();
		charField.setColumns(10);
		GridBagConstraints gbc_charField = new GridBagConstraints();
		gbc_charField.gridwidth = 2;
		gbc_charField.insets = new Insets(0, 0, 5, 5);
		gbc_charField.fill = GridBagConstraints.HORIZONTAL;
		gbc_charField.gridx = 1;
		gbc_charField.gridy = 5;
		queryPanel.add(charField, gbc_charField);
		
		JComboBox mediaBox = new JComboBox();
		mediaBox.setModel(new DefaultComboBoxModel(new String[] {"Any", "Movie", "TV Series", "TV Mini Series", "TV Movie", "Video Movie", "Video Game", "Episode"}));
		GridBagConstraints gbc_mediaBox = new GridBagConstraints();
		gbc_mediaBox.gridwidth = 2;
		gbc_mediaBox.insets = new Insets(0, 0, 5, 5);
		gbc_mediaBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_mediaBox.gridx = 4;
		gbc_mediaBox.gridy = 5;
		queryPanel.add(mediaBox, gbc_mediaBox);
		
		JButton searchButton = new JButton("Search");
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 0, 5);
		gbc_searchButton.gridx = 10;
		gbc_searchButton.gridy = 6;
		queryPanel.add(searchButton, gbc_searchButton);
		
		JPanel dataPanel = new JPanel();
		panel.add(dataPanel, "cell 0 1,grow");
		dataPanel.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		dataPanel.add(textPane, BorderLayout.CENTER);
	}

}
