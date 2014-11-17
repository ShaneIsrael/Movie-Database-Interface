import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;


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
		String mediaTitle = "ET";
		String mediaType = "movie";
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[467.00][45.00,grow][177.00,grow]", "[684.00,grow]"));
		
		poster = new PosterArt(mediaTitle, mediaType, this);
		
		JPanel posterPanel = new JPanel();
		contentPane.add(posterPanel, "cell 0 0,grow");
		posterPanel.setLayout(new MigLayout("", "[]", "[]"));
		posterPanel.add(poster.scaleSize(405, 600));
		
		JPanel typePanel = new JPanel();
		contentPane.add(typePanel, "cell 1 0,alignx right,growy");
		typePanel.setLayout(new GridLayout(10, 1, 10, 10));
		
		JLabel lblTitle_1 = new JLabel("Title:");
		lblTitle_1.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblTitle_1);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblYear);
		
		JLabel lblMpaaRating = new JLabel("MPAA Rating:");
		lblMpaaRating.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblMpaaRating);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblGenre);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblReleaseDate);
		
		JLabel lblTitle = new JLabel("Run Time:");
		lblTitle.setFont(new Font("Georgia", Font.BOLD, 20));
		typePanel.add(lblTitle);
		
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel, "cell 2 0,grow");
		infoPanel.setLayout(new GridLayout(10, 1, 10, 10));
		
		JLabel lblEdgeOfTomorrow = new JLabel("Edge of Tomorrow");
		lblEdgeOfTomorrow.setFont(new Font("Georgia", Font.PLAIN, 20));
		infoPanel.add(lblEdgeOfTomorrow);
		
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
