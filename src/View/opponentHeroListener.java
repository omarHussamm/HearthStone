package View;

import javax.swing.JComponent;

public interface opponentHeroListener {

	public String getoppHeroStats();

	public String getoppHandCardsStats(int i);

	public int getoppHandSize();

	public void endturn();

	public int getFieldoppSize();

	public String getFieldoppCardStats(int i);

	public int getPressedkart();

	public String getCardType(int i);

	public void playSpell(int spellIndex, String cardType, int index);

	public boolean isUsepower();

	public void useHeroPower(int index);

	public void useHeroPoweropp(int index);

	public kroot getAttackerPressedKart();

	public void attackminion(int attackerPressedKart, int i);

	public void deselect();

	public JComponent getUseHeroPower();

	public String getoppDeckCount();

}
