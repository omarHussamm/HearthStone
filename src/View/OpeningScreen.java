package View;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpeningScreen extends JPanel {
	private Cards listener;

	public OpeningScreen(Viewer viewer) {
		listener = viewer;

		setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon(
				System.class.getResource("/Images/Opening.jpg"));
		JLabel backgroundLabel = new JLabel(img, JLabel.CENTER);
		add(backgroundLabel, BorderLayout.CENTER);
		revalidate();
		repaint();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				listener.start();

			}
		}).start();

	}

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
	}
}
