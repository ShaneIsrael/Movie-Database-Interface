import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


public class InformationGUI extends JFrame {

	private JPanel contentPane;
	private PosterArt poster;


	/**
	 * Create the frame.
	 */
	public InformationGUI() {
		
		/*
		 * All data about the movie search should be sent here
		 * in a hashmap so that we can pull the data and correctly
		 * display it on this info frame.
		 */
		
		
		/*
		 * These strings for example will come from the
		 * hash table
		 */
		String mediaTitle = "Edge Of Tomorrow";
		String mediaType = "movie";
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[579.00][386.00]", "[684.00,grow]"));
		
			poster = new PosterArt(mediaTitle, mediaType, this);
		
		JPanel posterPanel = new JPanel();
		contentPane.add(posterPanel, "cell 0 0,grow");
		posterPanel.setLayout(new MigLayout("", "[]", "[]"));
		posterPanel.add(poster.scaleSize(405, 600));
		
		this.setTitle("Search Information");
		this.setVisible(true);
	}
	
	public void refresh()
	{
		contentPane.repaint();
	}
	public static void main(String... args)
	{
		new InformationGUI();
	}

}
