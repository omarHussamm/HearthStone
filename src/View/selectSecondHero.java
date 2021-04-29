package View;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import exceptions.FullHandException;

@SuppressWarnings("serial")
public class selectSecondHero extends JPanel implements Lower2Listener {
	private Upper2 upper;
	private Lower2 lower;
	private JSplitPane pane;
	private Cards listener;
	private final String backgroundPath = "src/Images/Choose.jpg";

	public selectSecondHero() {
		upper = new Upper2();
		lower = new Lower2();
		lower.setListener(this);
		pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upper, lower);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setOpaque(false);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, pane);
		pane.setDividerLocation(100);
		pane.setDividerSize(0);
		pane.setEnabled(false);

	}

	public Upper2 getUpper() {
		return upper;
	}

	public Lower2 getLower() {
		return lower;
	}

	public JSplitPane getPane() {
		return pane;
	}

	public void play() {
		listener.play();
	}

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
	}

	@Override
	public void setP2(String string) {
		listener.setP2(string);
	}

	@Override
	public void setHeroes() throws FullHandException, IOException,
			CloneNotSupportedException {
		listener.setHeroes();
	}

	public void StartPlay() {
		listener.StartPlay();

	}

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
