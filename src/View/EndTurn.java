package View;

import java.awt.BorderLayout;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EndTurn extends JPanel {
	private final String backgroundPath = "src/Images/EndTurn.jpeg";
	private JLabel turn;

	public EndTurn() {
		setLayout(new BorderLayout());
		turn = new JLabel("Changing Turns...", SwingConstants.CENTER);
		add(turn, BorderLayout.CENTER);
		try {
			turn.setFont(new GameFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			BufferedImage image = ImageIO.read(new File(backgroundPath));
			g.drawImage(image, 0, 0, this);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
