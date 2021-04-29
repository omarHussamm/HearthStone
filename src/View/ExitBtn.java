package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ExitBtn extends JButton {
	public ExitBtn(JPanel p) {
		super("Exit");
		setButton(p);

	}

	private void setButton(JPanel p) {
		try {
			setFont(new GameFont().deriveFont(36.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		setPreferredSize(new Dimension(300, 100));

		setForeground(new Color(215, 178, 88));
		setBackground(new Color(46, 32, 26, 200));
		// setOpaque(false);
		// setContentAreaFilled(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent arg0) {
				setForeground(new Color(215, 178, 88));
				p.revalidate();
				p.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setForeground(Color.WHITE);
				p.revalidate();
				p.repaint();

			}

		});

		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
