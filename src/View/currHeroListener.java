package View;

import javax.swing.JComponent;

public interface currHeroListener {

	public String getHeroStats();

	public String getHandCardsStats(int i);

	public int getHandSize();

	public void endturn();

	public void playCard(int index);

	public String getFieldCardStats(int i);

	public int getFieldSize();

	public String getCardType(int i);

	public void playSpell(int i,String type);

	public void playSpell(int i,String type, int index);

	public void playSpell(int i,String type, boolean b);

	public void playSpelloncurr(int pressedkart, String cardType, int index);

	public boolean isUsepower();

	public void useHeroPower(int index);

	public void deselect();

	public JComponent getUseHeroPower();

	public String getDeckCount();


}
