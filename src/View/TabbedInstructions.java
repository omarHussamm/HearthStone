package View;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class TabbedInstructions extends JTabbedPane {

	private JPanel rules;
	private JPanel heroes;
	private JPanel spells;
	private JPanel minions;
	private JPanel credits;

	public TabbedInstructions() {
		setOpaque(false);
		rules = new JPanel();
		rules.setOpaque(false);
		setRules();
		heroes = new JPanel();
		heroes.setOpaque(false);
		setHeroes();
		spells = new JPanel();
		spells.setOpaque(false);
		setSpells();
		minions = new JPanel();
		minions.setOpaque(false);
		setMinions();
		credits = new JPanel();
		credits.setOpaque(false);
		setCredits();

		addTab("Game Rules", rules);
		addTab("Heroes", heroes);
		addTab("Spells", spells);
		addTab("Minions", minions);
		addTab("Credits", credits);

		revalidate();
		repaint();
	}

	private void setCredits() {
		JLabel label = new JLabel("<html>" + "Omar Hussam" + "<br>" + "&"
				+ "<br>" + "Mohamed Zaki" + "<br>" + "&" + "<br>"
				+ "Youssef Alaa" + "<br>" + "&" + "<br>" + "YOU" + "</html>");
		try {
			label.setFont(new GameFont().deriveFont(45.0f));
			label.setForeground(new Color(215, 178, 88));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		credits.add(label);
	}

	private void setMinions() {
		JLabel label = new JLabel(
				"<html>"
						+ "Charged minions can attack in their first turn"
						+ "<br>"
						+ "Divine minions can block one attack only once from all minions and some of the spells"
						+ "<br>"
						+ "All opponent taunt minoions must be destroyed before a minion can attcack a non-taunt opponent minion"
						+ "<br>"
						+ "Special minions"
						+ "<br>"
						+ "Chromaggus:"
						+ "<br>"
						+ "Whenever a hero draws a card while Chromaggus is on his field, a copy from the drawn card will be added to his hand (if there is an empty slot for the copy)"
						+ "<br>"
						+ "Kalycgos:"
						+ "<br>"
						+ "Whenever a mage hero casts a spell while Kalycgos is on his field, reduce the mana cost of this spell by 4"
						+ "<br>"
						+ "Prophet Velen:"
						+ "<br>"
						+ " If a priest hero has Prophet Velen on his field, his hero power restores 8 health instead of 2"
						+ "<br>"
						+ "Wilfred Fizzlebang:"
						+ "<br>"
						+ "If the warlock hero draws a minion card with his hero power while Wilfred Fizzlebang is on his field, the mana cost of the drawn minion is reduced to 0"
						+ "<br>"
						+ "Note: In case the warlock hero has both Chromaggus and Wilfred Fizzlebang on his field, the effect of Wilfred Fizzlebang should trigger first before Chromaggus copies the drawn minion"
						+ "<br>" + "</html>");
		try {
			label.setFont(new GameFont().deriveFont(22.0f));
			label.setForeground(new Color(215, 178, 88));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minions.add(label);
	}

	private void setSpells() {
		JLabel label = new JLabel(
				"<html>"
						+ "Spells effect:"
						+ "<br>"
						+ "Curse of Weakness:"
						+ "<br>"
						+ "Decreases the attack of all enemy minions by 2"
						+ "<br>"
						+ "Divine spirit:"
						+ "<br>"
						+ "Doubles the current and max HP of a minion"
						+ "<br>"
						+ "Flame Strike:"
						+ "<br>"
						+ "Deals 4 damage to all enemy minions. Make sure you will pass by all enemy minions"
						+ "<br>"
						+ "Holy Nova"
						+ "<br>"
						+ "Deals 2 damage to all enemy minions. Restores 2 health to all friendly minions"
						+ "<br>"
						+ "Kill Command:"
						+ "<br>"
						+ " Deals 5 damage to a minion or 3 damage to a hero"
						+ "<br>"
						+ "Level Up!:"
						+ "<br>"
						+ " Increase the attack, current, and max HP of all silver hand recruits by 1"
						+ "<br>"
						+ "Multi-Shot:"
						+ "<br>"
						+ " Deals 3 damage to two random enemy minions. If the opponent has only one minion, it deals 3 damage once to this minion. If the opponent’s field is empty then nothing happens"
						+ "<br>"
						+ "Polymorph:"
						+ "<br>"
						+ "Transforms a minion into a minion with the following attributes:"
						+ "<br>"
						+ "– CurrentHP, maxHp and attack value (all with a value of 1)"
						+ "<br>"
						+ "– Name is ”Sheep”"
						+ "<br>"
						+ "– A non-taunt, non-divine and non-charge minion"
						+ "<br>"
						+ "– Mana cost is 1 mana crystal"
						+ "<br>"
						+ "Pyroblast:"
						+ "<br>"
						+ "Deals 10 damage to a chosen target (a hero or a minion)"
						+ "<br>"
						+ "Seal Of Champions"
						+ "<br>"
						+ "Shadow Word Death:"
						+ "<br>"
						+ "Destroys a minion that his attack is 5 or more even if it has a divine shield"
						+ "<br>"
						+ "Siphon Soul:"
						+ "<br>"
						+ "Destroys a minion even if it has a divine shield and restores 3 health points to the hero"
						+ "<br>"
						+ "Twisting nether:"
						+ "<br>"
						+ "Destroys all minions of both heroes even if any of them has a divine shield"
						+ "<br>"
						+ "Note: Taunt rule does not apply to spells!!"
						+ "</html>");
		try {
			label.setFont(new GameFont().deriveFont(22.0f));
			label.setForeground(new Color(215, 178, 88));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spells.add(label);
	}

	private void setHeroes() {
		JLabel label = new JLabel(
				"<html>"
						+ "Heroes' max manacrystals are incrmented by 1 each turn and the current manacrystals is set to max also until the hero reaches 10 manacrystals"
						+ "<br>"
						+ "At the start of each turn the hero draws a card until his/her deck is empty then he/she is damaged one point and is incremented by 1 each turn "
						+ "<br>" + "Hero power always is 2 manacrysrtals worth"
						+ "<br>" + "Hunter's hero power:" + "<br>"
						+ "Inflicts 2 damage points on the opponent hero"
						+ "<br>" + "Mage's hero power:" + "<br>"
						+ "Inflicts 1 damage point on any choosen target"
						+ "<br>" + "Paladin's hero power:" + "<br>"
						+ "Recruits a SilverHandRecruit minion on the field"
						+ "<br>" + "Priest's hero power:" + "<br>"
						+ "Restores 2 health points to any target" + "<br>"
						+ "Warlock's hero power:" + "<br>"
						+ "Draw a Card and loses 2 health points" + "<br>"
						+ "</html>");
		try {
			label.setFont(new GameFont().deriveFont(22.0f));
			label.setForeground(new Color(215, 178, 88));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		heroes.add(label);
	}

	private void setRules() {
		JLabel label = new JLabel(
				"<html>"
						+ "Press on the picture of the hero to choose him/her"
						+ "<br>"
						+ "The current hero is located at the bottom of the screen while the opponent is at the top"
						+ "<br>"
						+ "To play a minion just click its button in the hand"
						+ "<br>"
						+ "If the spell is AOE or Field spell click it to cast the spell"
						+ "<br>"
						+ "If the spell is MinionTarget or HeroTarget or Leeching spell click it then click the target you want the spell to be casted on"
						+ "<br>"
						+ "If your choosen hero is Mage or Priest press on HeroPower button then on your target to apply the HeroPower"
						+ "<br>"
						+ "If your choosen hero is Hunter or Paladin or Warlock click on HeroPower button to apply the Hero Power"
						+ "<br>"
						+ "To end Your turn click the button EndTurn"
						+ "<br>"
						+ "If the player made any invalid action any selected button will be deselected"
						+ "<br>"
						+ "More rules regarding the game in the other tabs"
						+ "</html>");
		try {
			label.setFont(new GameFont().deriveFont(22.0f));
			label.setForeground(new Color(215, 178, 88));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rules.add(label);
	}
}
