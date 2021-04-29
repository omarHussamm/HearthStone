package View;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;

import Controller.Controller;
import exceptions.FullHandException;

@SuppressWarnings("serial")
public class Viewer extends JFrame implements Cards {
	private StartPanel start;
	private selectFirstHero selectfirsthero;
	private selectSecondHero selectsecondhero;
	private CardLayout mainlayout;
	private GamePanel play;
	private OpeningScreen opening;
	private HeroWin endGame;
	private EndTurn endTurn;
	private InstructionsPanel instructions;
	private InstructionsPanel1 instructions1;
	private ViewListener listener;

	public Viewer(Controller controller) {
		// //////JFrame////////////////

		listener = controller;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// /////initializig cards////////////

		start = new StartPanel(this);
		endTurn = new EndTurn();
		selectfirsthero = new selectFirstHero();
		selectfirsthero.setListener(this);
		selectsecondhero = new selectSecondHero();
		selectsecondhero.setListener(this);
		instructions = new InstructionsPanel();
		instructions.setListener(this);
		instructions1 = new InstructionsPanel1();
		instructions1.setListener(this);

		// ////////adding cards/////////////

		mainlayout = new CardLayout();
		setLayout(mainlayout);

		add(start, "start");
		add(endTurn, "endturn");
		add(selectfirsthero, "selectfirsthero");
		add(selectsecondhero, "selectsecondhero");
		add(instructions, "instructions");
		add(instructions1,"instructions1");
		opening = new OpeningScreen(this);
		add(opening, "opening");
		mainlayout.show(getContentPane(), "opening");

		// //////////re//////////////////

		revalidate();
		repaint();
	}

	public StartPanel getStart() {
		return start;
	}

	public void setStart(StartPanel start) {
		this.start = start;
	}

	public selectFirstHero getSelectfirsthero() {
		return selectfirsthero;
	}

	public void setSelectfirsthero(selectFirstHero selectfirsthero) {
		this.selectfirsthero = selectfirsthero;
	}

	public selectSecondHero getSelectsecondhero() {
		return selectsecondhero;
	}

	public void setSelectsecondhero(selectSecondHero selectsecondhero) {
		this.selectsecondhero = selectsecondhero;
	}

	public CardLayout getMainlayout() {
		return mainlayout;
	}

	public void setMainlayout(CardLayout mainlayout) {
		this.mainlayout = mainlayout;
	}

	public GamePanel getPlay() {
		return play;
	}

	public void setPlay(GamePanel play) {
		this.play = play;
	}

	public void firstHero() {
		mainlayout.show(getContentPane(), "selectfirsthero");
	}

	public void secondHero() {
		mainlayout.show(getContentPane(), "selectsecondhero");
	}

	public void play() {
		mainlayout.show(getContentPane(), "play");
	}

	public void start() {
		mainlayout.show(getContentPane(), "start");
	}

	public ViewListener getListener() {
		return listener;
	}

	public void setListener(ViewListener listener) {
		this.listener = listener;
	}

	public void setP2(String string) {
		((Controller) listener).setP2(string);
	}

	public void setP1(String string) {
		((Controller) listener).setP1(string);
	}

	public void setHeroes() throws FullHandException, IOException,
			CloneNotSupportedException {
		listener.setHeroes();
	}

	public String getHeroStats() {
		return listener.getHeroStats();
	}

	@Override
	public void StartPlay() {
		try {
			play = new GamePanel(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(play, "play");
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
	public void playSpelloncurr(int pressedkart, String cardType, int index) {
		listener.playSpelloncurr(pressedkart, cardType, index);
	}

	@Override
	public void useHeroPower() {
		listener.useHeroPower();
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
	public String getHeroType() {
		return listener.getHeroType();
	}

	@Override
	public void attackminion(int attackerPressedKart, int i) {
		listener.attackminion(attackerPressedKart, i);
	}

	public OpeningScreen getOpening() {
		return opening;
	}

	public void setOpening(OpeningScreen opening) {
		this.opening = opening;
	}

	@Override
	public String getoppDeckCount() {
		return listener.getoppDeckCount();
	}

	@Override
	public String getDeckCount() {
		return listener.getDeckCount();
	}

	@Override
	public String getWinner() {
		return listener.getWinner();
	}

	public void showendTurn() {
		mainlayout.show(getContentPane(), "endturn");
	}

	public void showheroWin() {
		endGame = new HeroWin(this);
		add(endGame, "endgame");
		mainlayout.show(getContentPane(), "endgame");
	}

	@Override
	public void showInstructions() {
		mainlayout.show(getContentPane(), "instructions");
	}

	@Override
	public void showInstructions1() {
		mainlayout.show(getContentPane(), "instructions1");
	}

}
