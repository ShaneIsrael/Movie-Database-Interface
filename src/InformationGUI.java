import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import net.miginfocom.swing.MigLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;


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
		
		poster = new PosterArt(mediaTitle, mediaType, (String)map.get("production_year"), this);
		
		JPanel posterPanel = new JPanel();
		contentPane.add(posterPanel, "cell 0 0,grow");
		posterPanel.setLayout(new MigLayout("", "[]", "[]"));
		posterPanel.add(poster.scaleSize(405, 600));
		
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel, "cell 1 0,grow");
		infoPanel.setLayout(new MigLayout("", "[214.00px,grow,center]", "[20px][][][][][][][58.00][][][][][][][][][149.00][][][][]"));
		
		JLabel labelTitle = new JLabel((String) map.get("title"));
		labelTitle.setFont(new Font("Georgia", Font.BOLD, 26));
		infoPanel.add(labelTitle, "cell 0 1,alignx center,aligny top");
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblGenre, "cell 0 3");
		
		JLabel labelGenre = new JLabel((String)map.get("genres"));
		labelGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoPanel.add(labelGenre, "cell 0 4");
		
		JLabel lblMpaaRating = new JLabel("MPAA Rating");
		lblMpaaRating.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblMpaaRating, "cell 0 6");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		infoPanel.add(scrollPane_1, "cell 0 7,grow");
		
		JTextArea mpaaArea = new JTextArea();
		mpaaArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DefaultCaret caret = (DefaultCaret)mpaaArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		mpaaArea.setText((String)map.get("mpaa"));
		scrollPane_1.setViewportView(mpaaArea);
		
		JLabel lblRuntime = new JLabel("Runtime");
		lblRuntime.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblRuntime, "cell 0 9");
		
		JLabel labelRuntime = new JLabel((String)map.get("runtimes") + " Minutes");
		labelRuntime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoPanel.add(labelRuntime, "cell 0 10");
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblReleaseDate, "cell 0 12");
		
		JLabel labelReleaseDate = new JLabel((String)map.get("release dates"));
		labelReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoPanel.add(labelReleaseDate, "cell 0 13");
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblPlot, "cell 0 15");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		infoPanel.add(scrollPane, "cell 0 16,grow");
		
		JTextPane plotPane = new JTextPane();
		plotPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DefaultCaret plotCaret = (DefaultCaret)plotPane.getCaret();
		plotCaret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		plotPane.setEditable(false);
		plotPane.setText((String)map.get("plot"));
		scrollPane.setViewportView(plotPane);
		
		JLabel lblBudget = new JLabel("Budget");
		lblBudget.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblBudget, "cell 0 17");
		
		JLabel labelBudget = new JLabel((String)map.get("budget"));
		labelBudget.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoPanel.add(labelBudget, "cell 0 18");
		
		JLabel lblGross = new JLabel("Gross");
		lblGross.setFont(new Font("Tahoma", Font.BOLD, 18));
		infoPanel.add(lblGross, "cell 0 19");
		
		JLabel labelGross = new JLabel((String)map.get("gross"));
		labelGross.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoPanel.add(labelGross, "cell 0 20");
		
		this.setResizable(false);
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
