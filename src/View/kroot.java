package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class kroot extends JButton {
	private int index;
	private String stats;

	public kroot(String x, int i) {
		super();
		index = i;
		stats = x;
		setText(stats);
		Color yello = new Color(215, 178, 88);
		setPreferredSize(new Dimension(150, 220));
		setBackground(new Color(168, 40, 19));
		setForeground(yello);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, yello,
				yello));
		try {
			setFont(new GameFont().deriveFont(13.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	// protected void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// try {
	// BufferedImage image = ImageIO.read(new File("src/Images/FrontCard.jpg"));
	// g.drawImage(image, 0, 0, this);
	//
	// } catch (IOException ex) {
	// System.out.println("frontcard");
	// }
	// }


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
