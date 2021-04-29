package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Deck extends JPanel {
	public Deck() {
		setOpaque(false);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(150, 220));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			BufferedImage image = ImageIO.read(new File(
					"src/Images/BackCard.png"));
			g.drawImage(image, 0, 0, this);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
