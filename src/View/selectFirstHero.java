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

@SuppressWarnings("serial")
public class selectFirstHero extends JPanel implements LowerListener {
	private JSplitPane pane;
	private Upper upper;
	private Lower lower;
	private Cards listener;
	private final String backgroundPath = "src/Images/Choose.jpg";

	public selectFirstHero() {
		upper = new Upper();
		lower = new Lower();
		lower.setListener(this);
		pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upper, lower);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setOpaque(false);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, pane);
		pane.setDividerLocation(100);
		pane.setDividerSize(0);
		pane.setEnabled(false);
		revalidate();
		repaint();

	}

	public JSplitPane getPane() {
		return pane;
	}

	public void setPane(JSplitPane pane) {
		this.pane = pane;
	}

	public Upper getUpper() {
		return upper;
	}

	public void setUpper(Upper upper) {
		this.upper = upper;
	}

	public Lower getLower() {
		return lower;
	}

	public void setLower(Lower lower) {
		this.lower = lower;
	}

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
	}

	@Override
	public void secondHero() {
		listener.secondHero();
	}

	@Override
	public void setP1(String n) {
		listener.setP1(n);
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
