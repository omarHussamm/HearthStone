package View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class currHero extends JPanel implements HandPanelListener,
		FieldPanelListener {
	private currHeroListener listener;
	private HandPanel hand;
	private Deck deck;
	private FieldPanel field;
	private JLabel deckCount;

	public currHero(GamePanel gamePanel) {
		setOpaque(false);
		listener = gamePanel;
		// /////initializing////////////
		hand = new HandPanel(this);
		hand.setListener(this);
		// hand.updateHand();
		deckCount = new JLabel(listener.getDeckCount(), SwingConstants.CENTER);
		deckCount.setFont(deckCount.getFont().deriveFont(60.0f));
		deck = new Deck();
		field = new FieldPanel();
		field.setListener(this);

		// //////layout///////////
		setLayout(new BorderLayout());
		deck.add(deckCount, BorderLayout.CENTER);
		add(deck, BorderLayout.EAST);
		add(field, BorderLayout.NORTH);
		add(hand, BorderLayout.CENTER);

		revalidate();
		repaint();
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

	public FieldPanel getField() {
		return field;
	}

	public void setField(FieldPanel field) {
		this.field = field;
	}

	

	public currHeroListener getListener() {
		return listener;
	}

	public void setListener(currHeroListener listener) {
		this.listener = listener;
	}

	public HandPanel getHand() {
		return hand;
	}

	public void setHand(HandPanel hand) {
		this.hand = hand;
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
	public void playCard(int index) {
		listener.playCard(index);
	}

	@Override
	public int getFieldSize() {
		return listener.getFieldSize();
	}

	@Override
	public String getFieldCardStats(int i) {
		return listener.getFieldCardStats(i);
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
	public int getPressedKart() {
		return hand.getPressedkart();
	}

	@Override
	public void playSpelloncurr(int pressedkart, String cardType, int index) {
		listener.playSpelloncurr(pressedkart, cardType, index);
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
	public kroot getAttackerPressedKart() {
		return field.getAttackerPressedKart();
	}

	@Override
	public void deselect() {
		listener.deselect();

	}

}
