package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class HeroWin extends JPanel {
	private JLabel winner;
	private Cards listener;
	private ExitBtn exit;
	private JButton mainmenu;
	private final String backgroundPath = "src/Images/Extra2.jpg";

	public HeroWin(Viewer viewer) {
		// ////initializing////////////

		listener = viewer;
		exit = new ExitBtn(this);

		mainmenu = new JButton("Main Menu");
		try {
			mainmenu.setFont(new GameFont().deriveFont(36.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		mainmenu.setPreferredSize(new Dimension(300, 100));

		mainmenu.setForeground(new Color(215, 178, 88));
		mainmenu.setBackground(new Color(46, 32, 26, 200));
		// btn.setOpaque(false);
		// btn.setContentAreaFilled(false);
		mainmenu.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainmenu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainmenu.setForeground(new Color(215, 178, 88));
				revalidate();
				repaint();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainmenu.setForeground(Color.WHITE);
				revalidate();
				repaint();

			}

		});
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.start();
			}
		});

		 winner = new JLabel(listener.getWinner() + " is The Winner!!");
//		winner = new JLabel("Omar is The Winner!!");
		try {
			winner.setFont(new GameFont());
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		// //// layout ///////////////

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 0.2;

		// /////////first row////////

		gc.gridx = 0;
		gc.gridy = 0;
		add(winner, gc);
		gc.anchor = GridBagConstraints.CENTER;

		// /////////next row///////////

		gc.gridy++;
		add(mainmenu, gc);
		gc.anchor = GridBagConstraints.NORTH;

		// /////////next row///////////

		gc.gridy++;
		add(exit, gc);

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
