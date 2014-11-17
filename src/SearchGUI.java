import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


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
		frame.setBounds(100, 100, 283, 238);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[421.00,grow,center]", "[][][][][][]"));
		
		JLabel lblTitle = new JLabel("Title");
		panel.add(lblTitle, "cell 0 0");
		
		titleField = new JTextField();
		titleField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titleField, "cell 0 1,growx");
		titleField.setColumns(10);
		
		JLabel label = new JLabel("");
		panel.add(label, "flowx,cell 0 2");
		
		JLabel lblProductionYear = new JLabel("Production Year");
		panel.add(lblProductionYear, "cell 0 2");
		
		productionField = new JTextField();
		productionField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(productionField, "cell 0 3,growx");
		productionField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = titleField.getText();
				String prod = productionField.getText();
				
				HashMap infoMap = Database.search(title, "movie", prod);
				
				new InformationGUI(infoMap);
				
			}
		});
		panel.add(btnSearch, "cell 0 5");
	}

}
