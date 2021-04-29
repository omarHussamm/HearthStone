package View;

import java.io.IOException;

import exceptions.FullHandException;

public interface ViewListener {

	public void setHeroes() throws IOException, CloneNotSupportedException,
			FullHandException;

	public String getHeroStats();

	public String getoppHeroStats();

	public int getHandSize();

	public String getHandCardsStats(int i);

	public int getoppHandSize();

	public String getoppHandCardsStats(int i);

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

}
