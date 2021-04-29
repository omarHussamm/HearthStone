package View;

public interface FieldPaneloppListener {

	public int getFieldoppSize();

	public String getFieldoppCardStats(int i);

	public int getPressedkart();

	public String getCardType(int i);

	public void playSpell(int spellIndex, String cardType, int index);

	public void useHeroPower(int index);

	public boolean isUsepower();

	public void useHeroPoweropp(int index);

	public kroot getAttackerPressedKart();

	public void attackminion(int attackerPressedKart, int i);

	public void deselect();

}
