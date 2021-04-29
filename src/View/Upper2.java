package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Upper2 extends JPanel {
	private JLabel choosehero;

	public Upper2() {
		setOpaque(false);
		setLayout(new BorderLayout());
		choosehero = new JLabel("Player Two Choose Your Hero", JLabel.CENTER);
		choosehero.setForeground(new Color(98, 63, 22));
		try {
			choosehero.setFont(new GameFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		// URL url = System.class.getResource("/fonts/LHFUncialCaps.ttf");
		// try {
		// Font font = Font.createFont(Font.TRUETYPE_FONT, url.openStream());
		// choosehero.setFont(font.deriveFont(60.0f));
		// // btn.setFont(new GameFont());
		// } catch (FontFormatException | IOException e1) {
		// e1.printStackTrace();
		// }

		add(choosehero, BorderLayout.CENTER);
	}
}
