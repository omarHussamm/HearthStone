package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Upper extends JPanel {
	private JLabel choosehero;

	public Upper() {
		setOpaque(false);
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		choosehero = new JLabel("Player One Choose Your Hero",
				SwingConstants.CENTER);
		choosehero.setForeground(new Color(98, 63, 22));
		choosehero.setOpaque(false);
		try {
			choosehero.setFont(new GameFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		add(choosehero, BorderLayout.SOUTH);
	}
}