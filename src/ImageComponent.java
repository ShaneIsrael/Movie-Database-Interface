import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.json.JSONObject;

class ImageComponent extends JComponent {
	private final BufferedImage img;

	public ImageComponent(BufferedImage image) throws IOException {
		this.img = image;
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);

	}

	public static void main(String[] args) throws Exception {

		// final URL connURL = new
		// URL("http://en.wikipedia.org/wiki/File:Edge_of_Tomorrow_Poster.jpg");
		BufferedImage image = null;
		try {
			URL url = new URL(
					"https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=ET_Movie");
			URLConnection connection = url.openConnection();

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			JSONObject json = new JSONObject(builder.toString());
			String imageUrl = json.getJSONObject("responseData")
					.getJSONArray("results").getJSONObject(0).getString("url");

			image = ImageIO.read(new URL(imageUrl));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Failure",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		final ImageComponent imageComponent = new ImageComponent(image);

		JFrame frame = new JFrame("Poster Art");
		frame.add(new JScrollPane(imageComponent));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}