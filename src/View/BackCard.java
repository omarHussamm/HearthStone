package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BackCard extends JLabel {
	public BackCard() {
		super(new ImageIcon(System.class.getResource("/Images/BackCard.png")));
		setOpaque(false);
	}

}
