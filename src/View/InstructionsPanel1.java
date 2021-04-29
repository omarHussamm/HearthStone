package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InstructionsPanel1 extends JPanel {

	private JSplitPane pane;
	private TabbedInstructions instructions;
	private JButton back;
	private JPanel upper;
	private Cards listener;

	public InstructionsPanel1() {
		setBackground(new Color(46, 32, 26));
		upper = new JPanel();
		upper.setOpaque(false);
		UIManager.put("TabbedPane.contentOpaque", false);
		instructions = new TabbedInstructions();
		pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upper, instructions);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setOpaque(false);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, pane);
		pane.setDividerLocation(150);
		pane.setDividerSize(0);
		pane.setEnabled(false);

		try {
			back = new JButton(new ImageIcon(ImageIO.read(getClass()
					.getResource("/Images/Back.png"))));
			back.setOpaque(false);
			back.setContentAreaFilled(false);
			back.setBorderPainted(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		upper.setLayout(new FlowLayout(FlowLayout.LEFT));
		upper.add(back);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				listener.start();
			}
		});

		revalidate();
		repaint();

	}

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
	}

}
