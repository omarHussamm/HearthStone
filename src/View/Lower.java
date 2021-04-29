package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lower extends JPanel {
	private JLabel hunterlabel;
	private JLabel magelabel;
	private JLabel paladinlabel;
	private JLabel warlocklabel;
	private JLabel priestlabel;
	private JButton hunter;
	private JButton mage;
	private JButton paladin;
	private JButton warlock;
	private JButton priest;
	private ExitBtn exit;
	private LowerListener listener;

	public Lower() {
		setOpaque(false);
		// ////initializing buttons and labels /////

		exit = new ExitBtn(this);

		// ///////////hunter Button ////////

		URL url1 = System.class.getResource("/Images/Hunter.png");
		hunter = new JButton(new ImageIcon(url1));
		setHeroButton(hunter, "Hunter");
		hunterlabel = new JLabel("Hunter");
		try {
			hunterlabel.setFont(new GameFont().deriveFont(50.0f));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		hunterlabel.setForeground(new Color(98, 63, 22));

		// ////Mage Button////////////

		URL url2 = System.class.getResource("/Images/Mage_1.png");
		mage = new JButton(new ImageIcon(url2));
		setHeroButton(mage, "Mage");
		magelabel = new JLabel("Mage");
		try {
			magelabel.setFont(new GameFont().deriveFont(50.0f));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		magelabel.setForeground(new Color(98, 63, 22));

		// ////// paladin ///////////////////

		URL url3 = System.class.getResource("/Images/Paladin.png");
		paladin = new JButton(new ImageIcon(url3));
		setHeroButton(paladin, "Paladin");
		paladinlabel = new JLabel("Paladin");
		try {
			paladinlabel.setFont(new GameFont().deriveFont(50.0f));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		paladinlabel.setForeground(new Color(13, 41, 27));

		// //////////// priest ///////////////

		URL url4 = System.class.getResource("/Images/Priest.png");
		priest = new JButton(new ImageIcon(url4));
		setHeroButton(priest, "Priest");
		priestlabel = new JLabel("Priest");
		try {
			priestlabel.setFont(new GameFont().deriveFont(50.0f));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		priestlabel.setForeground(new Color(98, 63, 22));

		// ///Warlock/////////////////

		URL url5 = System.class.getResource("/Images/Warlock.png");
		warlock = new JButton(new ImageIcon(url5));
		setHeroButton(warlock, "Warlock");
		warlocklabel = new JLabel("Warlock");
		try {
			warlocklabel.setFont(new GameFont().deriveFont(50.0f));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		warlocklabel.setForeground(new Color(98, 63, 22));

		// ///////setLOWER/////////

		setLower();
		validate();
		repaint();

	}

	private void setHeroButton(final JButton btn, String name) {
//		btn.setOpaque(false);
//		btn.setContentAreaFilled(false);
		btn.setBackground(new Color(46, 32, 26, 200));
		btn.setPreferredSize(new Dimension(300, 500));
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				super.mouseEntered(arg0);
				btn.setBackground(new Color(255, 255, 255, 80));
				revalidate();
				repaint();

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				super.mouseExited(arg0);
				btn.setBackground(new Color(46, 32, 26, 200));
				revalidate();
				repaint();

			}
		});
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setP1(name);
				listener.secondHero();
			}
		});
		validate();
		repaint();
	}

	public JLabel getHunterlabel() {
		return hunterlabel;
	}

	public void setHunterlabel(JLabel hunterlabel) {
		this.hunterlabel = hunterlabel;
	}

	public JLabel getMagelabel() {
		return magelabel;
	}

	public void setMagelabel(JLabel magelabel) {
		this.magelabel = magelabel;
	}

	public JLabel getPaladinlabel() {
		return paladinlabel;
	}

	public void setPaladinlabel(JLabel paladinlabel) {
		this.paladinlabel = paladinlabel;
	}

	public JLabel getWarlocklabel() {
		return warlocklabel;
	}

	public void setWarlocklabel(JLabel warlocklabel) {
		this.warlocklabel = warlocklabel;
	}

	public JLabel getPriestlabel() {
		return priestlabel;
	}

	public void setPriestlabel(JLabel priestlabel) {
		this.priestlabel = priestlabel;
	}

	public JButton getHunter() {
		return hunter;
	}

	public void setHunter(JButton hunter) {
		this.hunter = hunter;
	}

	public JButton getMage() {
		return mage;
	}

	public void setMage(JButton mage) {
		this.mage = mage;
	}

	public JButton getPaladin() {
		return paladin;
	}

	public void setPaladin(JButton paladin) {
		this.paladin = paladin;
	}

	public JButton getWarlock() {
		return warlock;
	}

	public void setWarlock(JButton warlock) {
		this.warlock = warlock;
	}

	public JButton getPriest() {
		return priest;
	}

	public void setPriest(JButton priest) {
		this.priest = priest;
	}

	public LowerListener getListener() {
		return listener;
	}

	public void setListener(LowerListener selectSecondHero) {
		this.listener = selectSecondHero;
	}

	private void setLower() {
		// /////////Layout//////////////////

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1.5;

		// ////////first Column/////////////

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(hunterlabel, gc);

		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		add(hunter, gc);

		// /////////////next column/////////

		gc.gridx++;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(magelabel, gc);

		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		add(mage, gc);

		// /////////////next column/////////

		gc.gridx++;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(paladinlabel, gc);

		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		add(paladin, gc);

		// /////////////next column/////////

		gc.gridx++;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(priestlabel, gc);

		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		add(priest, gc);

		// /////////////next column/////////

		gc.gridx++;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.SOUTH;
		add(warlocklabel, gc);

		gc.gridy = 1;
		gc.anchor = GridBagConstraints.NORTH;
		add(warlock, gc);

		// ///////exit btn//////////////
		gc.weightx = 1;
		gc.weighty = 0.05;
		gc.gridy = 2;
		add(exit, gc);

	}

	public ExitBtn getExit() {
		return exit;
	}

	public void setExit(ExitBtn exit) {
		this.exit = exit;
	}
}
