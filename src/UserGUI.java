import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class UserGUI extends JFrame {

	public JTextField title, year, person;
	public JButton search;
	
	private JPanel panel;
	InformationGUI infoGui;
	
	int w;
	int h;
	int x;
	int y;
	
	public UserGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		panel = new JPanel(new GridLayout(7,1));
		panel.add(new JLabel("Title"));
		
		title = new JTextField();
		title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add things to do here
			}
		});
		panel.add(title);
		
		panel.add(new JLabel("Year"));
		
		year = new JTextField();
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add things to do here
			}
		});
		panel.add(year);
		
		panel.add(new JLabel("Person"));
		
		person = new JTextField();
		person.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add things to do here
			}
		});
		panel.add(person);
		
		search = new JButton("Search");
		search.addActionListener(new Search());
		panel.add(search);
        
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        w = this.getWidth();
        h = this.getHeight();
        x = (dim.width - w + 120) / 5;
        y = (dim.height - h) / 6;
        this.setLocation(x, y);
        
	}
	
	private class Search implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			infoGui = new InformationGUI();
			infoGui.setLocation(x + w, y);
		}
	}
	
	public static void main(String... args)
	{
		new UserGUI();
	}
}
