package View;

import java.io.IOException;

import exceptions.FullHandException;

public interface Cards {
	public void firstHero();

	public void secondHero();

	public void play();

	public void start();

	public void setP2(String n);

	public void setP1(String n);

	public void setHeroes() throws FullHandException, IOException,
			CloneNotSupportedException;

	public String getHeroStats();

	public void StartPlay();

	public String getoppHeroStats();

	public String getHandCardsStats(int i);

	public int getHandSize();

	public String getoppHandCardsStats(int i);

	public int getoppHandSize();

	public void endturn();

	public void playCard(int index);

	public String getFieldCardStats(int i);

	public int getFieldSize();

	public int getFieldoppSize();

	public String getFieldoppCardStats(int i);

	public String getCardType(int i);

	public void playSpell(int i, String type);

	public void playSpell(int i, String type, int index);

	public void playSpell(int i, String type, boolean b);

	public void playSpelloncurr(int pressedkart, String cardType, int index);

	public void useHeroPower();

	public void useHeroPower(int index);

	public void useHeroPoweropp(int index);

	public String getHeroType();

	public void attackminion(int attackerPressedKart, int i);

	public String getoppDeckCount();

	public String getDeckCount();

	public String getWinner();

	public void showheroWin();

	public void showInstructions();

	public void showInstructions1();

}
