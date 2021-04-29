package View;

public interface FieldPanelListener {

	public int getFieldSize();

	public String getFieldCardStats(int i);

	public int getPressedKart();

	public String getCardType(int pressedkart);

	public void playSpelloncurr(int pressedkart, String cardType, int index);

	public boolean isUsepower();

	public void useHeroPower(int index);

	public void deselect();

}
