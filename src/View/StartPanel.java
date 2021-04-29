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
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	private JButton start;
	private JButton instructions;
	private ExitBtn exit;
	private JLabel label;
	private Cards listener;
	private final String backgroundPath = "src/Images/Start.jpg";

	public StartPanel(Viewer viewer) {
		listener = viewer;

		setLayout(new GridBagLayout());

		// ///////label features/////////

		URL url1 = System.class.getResource("/Images/Name.png");
		label = new JLabel(new ImageIcon(url1));

		// ////start Button features/////

		start = new JButton("START");
		setButton(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.firstHero();
			}
		});

		instructions = new JButton("Game Rules");
		 setButton(instructions);
		 instructions.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
		 listener.showInstructions1();
		 }
		 });

		exit = new ExitBtn(this);

		// ////////////gc features///////
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 0.6;

		// /////////Row One////////////////

		gc.gridx = 0;
		gc.gridy = 0;
		add(label, gc);
		gc.weighty = 0.2;
		// /////////Next Row////////////////
		gc.gridy++;
		add(start, gc);

		// // /////////Next Row////////////////
		
		gc.gridy++;
		 add(instructions, gc);

		// /////////Next Row////////////////
		gc.gridy++;
		add(exit, gc);

		revalidate();
		repaint();
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
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

	public ExitBtn getExit() {
		return exit;
	}

	public void setExit(ExitBtn exit) {
		this.exit = exit;
	}

	private void setButton(JButton btn) {
		try {
			btn.setFont(new GameFont().deriveFont(36.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		btn.setPreferredSize(new Dimension(300, 100));

		btn.setForeground(new Color(215, 178, 88));
		btn.setBackground(new Color(46, 32, 26, 200));
		// btn.setOpaque(false);
		// btn.setContentAreaFilled(false);
		btn.setBorder(new EmptyBorder(10, 10, 10, 10));

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent arg0) {
				btn.setForeground(new Color(215, 178, 88));
				revalidate();
				repaint();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn.setForeground(Color.WHITE);
				revalidate();
				repaint();

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

		});

	}
}