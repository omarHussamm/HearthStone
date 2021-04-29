package View;

import java.awt.BorderLayout;
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements currHeroListener,
		opponentHeroListener {
	private Cards listener;
	private JSplitPane pane;
	private JPanel right;
	private currHero curr;
	private opponentHero opp;
	private JButton useHeroPower;
	private JButton deselect;
	private ExitBtn exit;
	private JButton endTurn;
	private JButton instructions;
	private kroot heroStats;
	private kroot oppHero;
	private JButton mainmenu;
	private JPanel left;
	private JPanel options;
	private boolean usepower;
	private final String backgroundPath = "src/Images/Extra.jpg";

	public GamePanel(Viewer viewer) throws InterruptedException {

		// ////////initializing////////

		listener = viewer;
		usepower = false;

		left = new JPanel();
		right = new JPanel();
		right.setOpaque(false);
		left.setOpaque(false);

		pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setOpaque(false);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, pane);
		pane.setDividerLocation(151);
		pane.setDividerSize(0);
		pane.setEnabled(false);

		options = new JPanel();

		curr = new currHero(this);
		opp = new opponentHero(this);
		exit = new ExitBtn(this);
		setButton(exit);

		mainmenu = new JButton("Main Menu");
		setButton(mainmenu);
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.start();
			}
		});

		endTurn = new JButton("End Turn");
		setButton(endTurn);
		endTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				endturn();
			}
		});

		instructions = new JButton("Game Rules");
		setButton(instructions);
		instructions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				listener.showInstructions();
			}
		});

		deselect = new JButton("Deselect");
		setButton(deselect);
		deselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deselect();
			}
		});

		useHeroPower = new JButton("Hero Power");
		setButton(useHeroPower);
		useHeroPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curr.getHand().getPressedkart() == -3
						&& curr.getField().getAttackerPressedKart().getIndex() == -3) {
					String x = listener.getHeroType();
					switch (x) {
					case "Hunter":
					case "Paladin":
					case "Warlock":
						listener.useHeroPower();
						useHeroPower.setBorder(null);
						break;
					case "Priest":
					case "Mage":
						usepower = true;
						useHeroPower.setBorder(new LineBorder(Color.BLACK));
						break;
					}
				} else
					deselect();
				revalidate();
				repaint();
			}
		});

		// ////////setting layout////////
		left.setLayout(new BorderLayout());
		setOptionsLayout();
		left.add(options, BorderLayout.CENTER);
		updateHeroStats();
		updateoppHeroStats();

		right.setLayout(new BorderLayout());
		right.add(curr, BorderLayout.SOUTH);
		right.add(opp, BorderLayout.NORTH);

	}

	public void updateHeroStats() {
		curr.getDeckCount().setText(getDeckCount());
		if (heroStats != null) {
			left.remove(heroStats);
		}
		String x = getHeroStats();
		heroStats = new kroot(x, -1);
		heroStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curr.getPressedKart() != -3) {
					playSpell(curr.getPressedKart(),
							getCardType(curr.getPressedKart()), -1);
				} else if (isUsepower()) {
					useHeroPower(-1);
					getUseHeroPower().setBorder(null);
				} else
					deselect();
				revalidate();
				repaint();
			}
		});
		left.add(heroStats, BorderLayout.SOUTH);
	}

	public void updateoppHeroStats() {
		opp.getDeckCount().setText(listener.getoppDeckCount());
		if (oppHero != null)
			left.remove(oppHero);
		String x = listener.getoppHeroStats();
		oppHero = new kroot(x, -2);
		oppHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getPressedkart() != -3) {
					playSpell(getPressedkart(), getCardType(getPressedkart()),
							-2);
				} else if (isUsepower()) {
					useHeroPower(-2);
					getUseHeroPower().setBorder(null);
				} else if (getAttackerPressedKart().getIndex() != -3) {
					attackminion(getAttackerPressedKart().getIndex(), -2);
					getAttackerPressedKart().setBorder(null);
				} else
					deselect();
				revalidate();
				repaint();
			}
		});
		left.add(oppHero, BorderLayout.NORTH);
	}

	private void setOptionsLayout() {
		options.setOpaque(false);
		options.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;

		// /////////first row////////

		gc.gridx = 0;
		gc.gridy = 0;
		options.add(useHeroPower, gc);

		// /////////next row///////////

		gc.gridy++;
		options.add(endTurn, gc);

		// /////////next row///////////

		gc.gridy++;
		options.add(deselect, gc);

		// /////////next row///////////

		gc.gridy++;
		options.add(instructions, gc);

		// /////////next row///////////

		gc.gridy++;
		options.add(mainmenu, gc);

		// /////////next row///////////

		gc.gridy++;
		options.add(exit, gc);

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

	public Cards getListener() {
		return listener;
	}

	public void setListener(Cards listener) {
		this.listener = listener;
	}

	public String getHeroStats() {
		return listener.getHeroStats();
	}

	@Override
	public String getoppHeroStats() {
		return listener.getoppHeroStats();
	}

	@Override
	public String getHandCardsStats(int i) {
		return listener.getHandCardsStats(i);
	}

	@Override
	public int getHandSize() {
		return listener.getHandSize();
	}

	@Override
	public String getoppHandCardsStats(int i) {
		return listener.getoppHandCardsStats(i);
	}

	@Override
	public int getoppHandSize() {
		return listener.getoppHandSize();
	}

	@Override
	public void endturn() {
		listener.endturn();
	}

	public currHero getCurr() {
		return curr;
	}

	public void setCurr(currHero curr) {
		this.curr = curr;
	}

	public opponentHero getOpp() {
		return opp;
	}

	public void setOpp(opponentHero opp) {
		this.opp = opp;
	}

	@Override
	public void playCard(int index) {
		listener.playCard(index);
	}

	@Override
	public String getFieldCardStats(int i) {
		return listener.getFieldCardStats(i);
	}

	@Override
	public int getFieldSize() {
		return listener.getFieldSize();
	}

	@Override
	public int getFieldoppSize() {
		return listener.getFieldoppSize();
	}

	@Override
	public String getFieldoppCardStats(int i) {
		return listener.getFieldoppCardStats(i);
	}

	@Override
	public String getCardType(int i) {
		return listener.getCardType(i);
	}

	@Override
	public void playSpell(int i, String type) {
		listener.playSpell(i, type);
	}

	@Override
	public void playSpell(int i, String type, int index) {
		listener.playSpell(i, type, index);
	}

	@Override
	public void playSpell(int i, String type, boolean b) {
		listener.playSpell(i, type, b);
	}

	@Override
	public int getPressedkart() {
		return curr.getHand().getPressedkart();
	}

	@Override
	public void playSpelloncurr(int pressedkart, String cardType, int index) {
		listener.playSpelloncurr(pressedkart, cardType, index);
	}

	public void setUseHeroPower(JButton useHeroPower) {
		this.useHeroPower = useHeroPower;
	}

	public boolean isUsepower() {
		return usepower;
	}

	public void setUsepower(boolean usepower) {
		this.usepower = usepower;
	}

	public void setDeselect(JButton deselect) {
		this.deselect = deselect;
	}

	public JButton getDeselect() {
		return deselect;
	}

	public JButton getUseHeroPower() {
		return useHeroPower;
	}

	@Override
	public void useHeroPower(int index) {
		listener.useHeroPower(index);
	}

	@Override
	public void useHeroPoweropp(int index) {
		listener.useHeroPoweropp(index);
	}

	@Override
	public kroot getAttackerPressedKart() {
		return curr.getField().getAttackerPressedKart();
	}

	@Override
	public void attackminion(int attackerPressedKart, int i) {
		listener.attackminion(attackerPressedKart, i);
	}

	public void updatePower() {
		useHeroPower.setBorder(BorderFactory.createEmptyBorder());
		useHeroPower.setBorderPainted(false);
	}

	public void deselect() {
		if (getAttackerPressedKart() != null)
			getAttackerPressedKart().setBorder(null);
		if (useHeroPower != null)
			useHeroPower.setBorder(null);
		usepower = false;
		curr.getHand().updateHand();
		curr.getField().updateField();
		this.updateHeroStats();
		this.updateoppHeroStats();
		opp.getField().updateFieldopp();
		opp.getHand().updateHand();

		revalidate();
		repaint();
	}

	private void setButton(JButton btn) {
		try {
			btn.setFont(new GameFont().deriveFont(20.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		btn.setPreferredSize(new Dimension(150, 30));

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

		});

	}

	@Override
	public String getoppDeckCount() {
		return listener.getoppDeckCount();
	}

	@Override
	public String getDeckCount() {
		return listener.getDeckCount();
	}
}
