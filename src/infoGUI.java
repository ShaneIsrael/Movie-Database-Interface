import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class infoGUI extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public infoGUI(ImageComponent poster) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[579.00][386.00]", "[684.00,grow]"));
		
		JPanel posterPanel = new JPanel();
		contentPane.add(posterPanel, "cell 0 0,grow");
		posterPanel.setLayout(new MigLayout("", "[]", "[]"));
		posterPanel.add(poster.newSize(405, 600));
		
		this.setTitle("Search Information");
		this.setVisible(true);
	}

}
