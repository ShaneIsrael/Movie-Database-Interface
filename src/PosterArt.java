import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import org.json.JSONObject;

class PosterArt extends JComponent implements Runnable {
	private Image img;
	private BufferedImage image = null;

	private int scaleWidth = 0;
	private int scaleHeight = 0;

	InformationGUI infoGui;
	
	private String mediaTitle;
	private String mediaType;
	
	/**
	 * All this class does is get the poster art. Nothing more needs to be
	 * done with this class. However, you should read through it so you get
	 * an understanding of what's going on. It's pretty simple and straight
	 * forward.
	 */

	public PosterArt(String title, String type, InformationGUI gui) {

		this.mediaTitle = title;
		this.mediaType = type;
		this.infoGui = gui;
		
		//replace any spaces in the title with an underscore
		mediaTitle = mediaTitle.replace(" ", "_");
		
		/*
		 * We start a new thread. This thread will run on its own
		 * process and got out to the internet and find the correct
		 * poster art for the media based on an algorithm I wrote.
		 * 
		 * We put this in a thread because this could take between 1
		 * and 4 seconds and we don't want our users to have to wait
		 * 4 secodns to view the other movie data. By puttin this in
		 * a thread, the rest of the data will display on the the
		 * information gui frame, and the poster art will show up
		 * as soon as it is found.
		 */
		new Thread(this).start();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*
		 * If our image is not null, we want to draw it to our component.
		 */
		if (img != null)
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this),
					this);

	}

	public Component scaleSize(int width, int height) {
		
		/*
		 * Since our images we get may vary in size, we want
		 * them to all be in a common scaled aspect ratio. which
		 * is set in InformationGUI
		 */
		this.scaleWidth = width;
		this.scaleHeight = height;

		return this;
	}

	@Override
	public void run() {

		
		try {
			String backupURL = null;
			String imageUrl = null;
			String line;
			boolean linkFound = false;
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < 5; i++) {
				
				/*
				 * If we found a link, we can immediately stop searching
				 * to save time.
				 */
				if (linkFound)
					break;

				/*
				 * This is the Google API. We are telling it to give us the max of 8 results
				 * per page. we say "start="+i which tells it which page we want results from.
				 * 
				 * Thats why this whole thing is in a for loop. We want to search a max of 5 pages
				 * worth of results for a wikipedia link that matches.
				 */
				URL url = new URL(
						"https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q="
								+ mediaTitle + "_"+mediaType+"&start=" + i + "&rsz=8");
				URLConnection connection = url.openConnection();

				/*
				 * Get the reply from Google
				 */
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}

				/*
				 * Create a json object from the reply we got from Google.
				 */
				JSONObject json = new JSONObject(builder.toString());

				/*
				 * Looks for a wikipedia link first since that is most likely to
				 * have the correct poster art image. If it can't find a
				 * wikipedia link it then chooses the first result.
				 */
				for (int j = 0; j < json.getJSONObject("responseData")
						.getJSONArray("results").length(); j++) {
					imageUrl = json.getJSONObject("responseData")
							.getJSONArray("results").getJSONObject(j)
							.getString("url");
					if (imageUrl.toLowerCase().contains("wikipedia")) {
						System.out
								.println("FOUND! wikipedia link\n" + imageUrl);
						linkFound = true;
						break;
					} else {
						imageUrl = null;

					}
				}

				if (i == 0)
					backupURL = json.getJSONObject("responseData")
							.getJSONArray("results").getJSONObject(0)
							.getString("url");
			}

			/*
			 * If we couldn't find a wikipedia image, we will use the top result
			 * that google returns as our image and hope for the best. 95% of the
			 * time this ends up returning correct poster art.
			 */
			if (imageUrl == null)
			{
				System.out.println("No Wikipedia link found.");
				imageUrl = backupURL;
			}

			/*
			 * Read the image from the web into our BufferedImage variable
			 */
			image = ImageIO.read(new URL(imageUrl));

			/*
			 * Set our image to the image we found so that it is no longer
			 * null and will be drawn.
			 */
			this.img = (Image) image;
			/*
			 * Scale our image to the aspect ration we set. 
			 */
			img = img.getScaledInstance(scaleWidth, scaleHeight,Image.SCALE_SMOOTH);
			/*
			 * Set the size of our JComponent to be the size of our image, else it wont
			 * have a size and wouldn't show up on our frame.
			 */
			this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
			/*
			 * This is a pointer to our InformationGUI frame. Here we are packing everything
			 * nicely against the image.
			 */
			infoGui.pack();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BufferedImage getPosterArt() {
		return image;
	}
}