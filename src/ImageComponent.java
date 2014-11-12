import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
	private Image img;

	public ImageComponent(BufferedImage image) throws IOException {
		this.img = (Image) image;
		
		setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);

	}
	public Component newSize(int width, int height) {
		img = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
		
		return this;
	}
	public static void main(String[] args) throws Exception {

		BufferedImage image = null;
		
		String movie = "ET"; //spaces must be underscores
		try {
			String backupURL = null;
			String imageUrl = null;
			String line;
			boolean linkFound = false;
			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i<5; i++)
			{
				//since we found the link, we dont need to get any more results.
				if(linkFound)
					break;
				
				URL url = new URL(
						"https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q="
								+ movie + "_movie&start="+i+"&rsz=8");
				URLConnection connection = url.openConnection();
	
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
				
				JSONObject json = new JSONObject(builder.toString());
				
				/*
				 * Looks for a wikipedia link first since that is most likely
				 * to have the correct poster art image. If it can't find a
				 * wikipedia link it then chooses the first result.
				 */
				for(int j = 0; j < json.getJSONObject("responseData").getJSONArray("results").length(); j++)
				{
					imageUrl = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(j).getString("url");
					if(imageUrl.toLowerCase().contains("wikipedia"))
					{
						System.out.println("FOUND! wikipedia link\n"+imageUrl);
						linkFound = true;
						break;
					}
					else
					{
						System.out.println("Not wikipedia link: "+imageUrl);
						imageUrl = null;
						
					}
				}
			
				if(i == 0)
					backupURL = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0).getString("url");
			}
			
			if(imageUrl == null)
				imageUrl = backupURL;

			image = ImageIO.read(new URL(imageUrl));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Failure",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		new infoGUI(new ImageComponent(image));

	}
}