import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;


public class SearchGUI {

	private JFrame frame;
	private JTextField titleField;
	private JTextField productionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI window = new SearchGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 283, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Search");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[421.00,grow,center]", "[][][][][][][][][]"));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblTitle, "cell 0 0");
		
		titleField = new JTextField();
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titleField, "cell 0 1,growx");
		titleField.setColumns(10);
		
		JLabel lblMediaType = new JLabel("Media Type");
		lblMediaType.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblMediaType, "flowx,cell 0 2");
		
		JLabel label = new JLabel("");
		panel.add(label, "cell 0 2");
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = titleField.getText();
				String prod = productionField.getText();
				
				if(productionField.getText().equals(""))
					prod = "*";
				
				HashMap<String, String> infoMap = Database.search(title, "movie", prod);
				
				new InformationGUI(infoMap);
				
			}
		});
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"movie", "tv series", "tv movie", "video movie", "tv miniseries", "video game"}));
		((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(comboBox, "cell 0 3,growx");
		
		JLabel lblProductionYear = new JLabel("Production Year");
		lblProductionYear.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblProductionYear, "cell 0 5");
		
		productionField = new JTextField();
		productionField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		productionField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(productionField, "cell 0 6,growx");
		productionField.setColumns(10);
		panel.add(btnSearch, "cell 0 8");
	}

}
