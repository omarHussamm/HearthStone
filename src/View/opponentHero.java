package View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class opponentHero extends JPanel implements HandPaneloppListener,
		FieldPaneloppListener {
	private opponentHeroListener listener;
	private HandPanelopp hand;
	private FieldPanelopp field;
	private Deck deck;
	private JLabel deckCount;

	public opponentHero(GamePanel gamePanel) {
		setOpaque(false);
		listener = gamePanel;
		// /////initializing////////////
		hand = new HandPanelopp(this);
		hand.setListener(this);
		// hand.updateHand();
		deckCount = new JLabel(listener.getoppDeckCount(),
				SwingConstants.CENTER);
		deckCount.setFont(deckCount.getFont().deriveFont(60.0f));
		deck = new Deck();
		field = new FieldPanelopp();
		field.setListener(this);

		// //////layout///////////
		setLayout(new BorderLayout());
		deck.add(deckCount, BorderLayout.CENTER);
		add(deck, BorderLayout.EAST);
		add(hand, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}

	public FieldPanelopp getField() {
		return field;
	}

	public void setField(FieldPanelopp field) {
		this.field = field;
	}

	public opponentHeroListener getListener() {
		return listener;
	}

	public void setListener(opponentHeroListener listener) {
		this.listener = listener;
	}

	public HandPanelopp getHand() {
		return hand;
	}

	public void setHand(HandPanelopp hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public JLabel getDeckCount() {
		return deckCount;
	}

	public void setDeckCount(JLabel deckCount) {
		this.deckCount = deckCount;
	}

	@Override
	public int getoppHandSize() {
		return listener.getoppHandSize();
	}

	@Override
	public String getoppHandCardsStats(int i) {
		return listener.getoppHandCardsStats(i);
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
	public int getPressedkart() {
		return listener.getPressedkart();
	}

	@Override
	public String getCardType(int i) {
		return listener.getCardType(i);
	}

	@Override
	public void playSpell(int spellIndex, String cardType, int index) {
		listener.playSpell(spellIndex, cardType, index);
	}

	@Override
	public void useHeroPower(int index) {
		listener.useHeroPower(index);
	}

	@Override
	public boolean isUsepower() {
		return listener.isUsepower();
	}

	@Override
	public void useHeroPoweropp(int index) {
		listener.useHeroPoweropp(index);
	}

	@Override
	public kroot getAttackerPressedKart() {
		return listener.getAttackerPressedKart();
	}

	@Override
	public void attackminion(int attackerPressedKart, int i) {
		listener.attackminion(attackerPressedKart, i);
	}

	@Override
	public void deselect() {
		listener.deselect();
	}
}
