package View;

public interface HandPanelListener {

	public String getHandCardsStats(int i);

	public int getHandSize();

	public void playCard(int index);

	public String getCardType(int i);

	public void playSpell(int i,String type, int index);

	public void playSpell(int i,String type);

	public void playSpell(int i,String type, boolean b);

	public boolean isUsepower();

	public kroot getAttackerPressedKart();

	public void deselect();

}
