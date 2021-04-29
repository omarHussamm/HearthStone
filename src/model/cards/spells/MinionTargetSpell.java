package model.cards.spells;

import model.cards.minions.Minion;
import exceptions.InvalidTargetException;

public interface MinionTargetSpell {
	public void performAction(Minion m) throws InvalidTargetException;
}
