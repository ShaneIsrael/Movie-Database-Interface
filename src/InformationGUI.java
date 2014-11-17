import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;


public class InformationGUI extends JFrame {

	private JPanel contentPane;
	private PosterArt poster;


	/**
	 * Create the frame.
	 */
	public InformationGUI(HashMap map) {
		
		/*
		 * All data about the movie search should be sent here
		 * in a hashmap so that we can pull the data and correctly
		 * display it on this info frame.
		 */
		
		
		/*
		 * These strings for example will come from the
		 * hash table
		 */
		String mediaTitle = (String) map.get("title");
		String mediaType = (String) map.get("kind");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[467.00][45.00,grow,center]", "[684.00,grow]"));
		
		poster = new PosterArt(mediaTitle, mediaType, this);
		
		JPanel posterPanel = new JPanel();
		contentPane.add(posterPanel, "cell 0 0,grow");
		posterPanel.setLayout(new MigLayout("", "[]", "[]"));
		posterPanel.add(poster.scaleSize(405, 600));
		
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel, "cell 1 0,grow");
		infoPanel.setLayout(new MigLayout("", "[214.00px,grow,center]", "[20px][][][][][][][][][][][][][][][][149.00,grow][][][][]"));
		
		JLabel labelTitle = new JLabel((String) map.get("movie"));
		labelTitle.setFont(new Font("Georgia", Font.BOLD, 24));
		infoPanel.add(labelTitle, "cell 0 1,alignx center,aligny top");
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblGenre, "cell 0 3");
		
		JLabel labelGenre = new JLabel((String)map.get("genres"));
		infoPanel.add(labelGenre, "cell 0 4");
		
		JLabel lblMpaaRating = new JLabel("MPAA Rating");
		lblMpaaRating.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblMpaaRating, "cell 0 6");
		
		JLabel labelMPAA = new JLabel((String)map.get("mpaa"));
		infoPanel.add(labelMPAA, "cell 0 7");
		
		JLabel lblRuntime = new JLabel("Runtime");
		lblRuntime.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblRuntime, "cell 0 9");
		
		JLabel labelRuntime = new JLabel((String)map.get("runtimes"));
		infoPanel.add(labelRuntime, "cell 0 10");
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblReleaseDate, "cell 0 12");
		
		JLabel labelReleaseDate = new JLabel((String)map.get("release dates"));
		infoPanel.add(labelReleaseDate, "cell 0 13");
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblPlot, "cell 0 15");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		infoPanel.add(scrollPane, "cell 0 16,grow");
		
		JTextPane plotPane = new JTextPane();
		plotPane.setText((String)map.get("plot"));
		scrollPane.setViewportView(plotPane);
		
		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblBudget, "cell 0 17");
		
		JLabel labelBudget = new JLabel((String)map.get("budget"));
		infoPanel.add(labelBudget, "cell 0 18");
		
		JLabel lblGross = new JLabel("Gross");
		lblGross.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblGross, "cell 0 19");
		
		JLabel labelGross = new JLabel((String)map.get("gross"));
		infoPanel.add(labelGross, "cell 0 20");
		
		this.setTitle("Search Results");
		this.setVisible(true);
	}
	
	public void refresh()
	{
		contentPane.repaint();
	}
	public static void main(String... args)
	{
	}

}
