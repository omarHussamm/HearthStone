package Controller;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import View.ViewListener;
import View.Viewer;
import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class Controller implements GameListener, ViewListener {

	private Hero player1;
	private Hero player2;
	private Game model;
	private Viewer view;
	private String p1;
	private String p2;

	// /////////initializing View/////////////

	public Controller() throws IOException, CloneNotSupportedException,
			FullHandException {
		view = new Viewer(this);

	}

	// ////////////initializing model////////////
	public void setHeroes() throws IOException, CloneNotSupportedException,
			FullHandException {
		switch (p1) {
		case "Hunter":
			player1 = new Hunter();
			break;
		case "Priest":
			player1 = new Priest();
			break;
		case "Paladin":
			player1 = new Paladin();
			break;
		case "Mage":
			player1 = new Mage();
			break;
		case "Warlock":
			player1 = new Warlock();
			break;
		}

		switch (p2) {

		case "Hunter":
			player2 = new Hunter();
			break;
		case "Priest":
			player2 = new Priest();
			break;
		case "Paladin":
			player2 = new Paladin();
			break;
		case "Mage":
			player2 = new Mage();
			break;
		case "Warlock":
			player2 = new Warlock();
			break;

		}
		model = new Game(player1, player2);
		model.setListener(this);
	}

	public Game getModel() {
		return model;
	}

	public void setModel(Game model) {
		this.model = model;
	}

	@Override
	public void onGameOver() {
		view.showheroWin();
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public Viewer getView() {
		return view;
	}

	public void setView(Viewer view) {
		this.view = view;
	}

	public Hero getPlayer1() {
		return player1;
	}

	public void setPlayer1(Hero player1) {
		this.player1 = player1;
	}

	public Hero getPlayer2() {
		return player2;
	}

	public void setPlayer2(Hero player2) {
		this.player2 = player2;
	}

	public String getHeroStats() {
		return model.getCurrentHero().getHeroStats();
	}

	@Override
	public String getoppHeroStats() {
		return model.getOpponent().getHeroStats();
	}

	@Override
	public int getHandSize() {
		return model.getCurrentHero().getHand().size();
	}

	@Override
	public String getHandCardsStats(int i) {
		return model.getCurrentHero().getHand().get(i).getCardStats();
	}

	@Override
	public int getoppHandSize() {
		return model.getOpponent().getHand().size();
	}

	@Override
	public String getoppHandCardsStats(int i) {
		return model.getOpponent().getHand().get(i).getCardStats();
	}

	@Override
	public void endturn() {
		try {
			model.getCurrentHero().endTurn();
		} catch (FullHandException e) {
			JOptionPane.showMessageDialog(new JDialog(), "<html>"
					+ "Your Hand is Full" + "<br>"
					+ e.getBurned().getCardStats(), "Error",
					JOptionPane.ERROR_MESSAGE);
			updateGame();
		} catch (CloneNotSupportedException e) {
			generateErrorMessage(e);
		}
	}

	@Override
	public void updateGame() {
		view.getPlay().deselect();
	}

	@Override
	public void playCard(int index) {
		Card x = model.getCurrentHero().getHand().get(index);
		if (x instanceof Minion) {

			try {
				model.getCurrentHero().playMinion((Minion) x);
			} catch (NotYourTurnException | NotEnoughManaException
					| FullFieldException e) {
				generateErrorMessage(e);
			}

		}
	}

	@Override
	public String getFieldCardStats(int i) {
		return model.getCurrentHero().getField().get(i).getCardStats();
	}

	@Override
	public int getFieldSize() {
		return model.getCurrentHero().getField().size();

	}

	@Override
	public int getFieldoppSize() {
		return model.getOpponent().getField().size();
	}

	@Override
	public String getFieldoppCardStats(int i) {
		return model.getOpponent().getField().get(i).getCardStats();
	}

	@Override
	public String getCardType(int i) {
		Card c = model.getCurrentHero().getHand().get(i);
		if (c instanceof Minion) {
			return "Minion";
		} else if (c instanceof FieldSpell) {
			return "FieldSpell";
		} else if (c instanceof MinionTargetSpell
				&& c instanceof HeroTargetSpell) {
			return "Double";
		} else if (c instanceof MinionTargetSpell) {
			return "MinionTargetSpell";
		} else if (c instanceof LeechingSpell) {
			return "LeechingSpell";
		} else if (c instanceof HeroTargetSpell) {
			return "HeroTargetSpell";
		} else
			return "AOESpell";

	}

	@Override
	public void playSpell(int i, String type) {
		try {
			model.getCurrentHero().castSpell(
					(FieldSpell) model.getCurrentHero().getHand().get(i));
		} catch (NotYourTurnException | NotEnoughManaException e) {
			generateErrorMessage(e);
		}

	}

	@Override
	public void playSpell(int i, String type, int index) {
		if (type.equals("Double")) {
			if (index == -1) {
				try {
					model.getCurrentHero().castSpell(
							(HeroTargetSpell) model.getCurrentHero().getHand()
									.get(i), model.getCurrentHero());
				} catch (NotYourTurnException | NotEnoughManaException e) {
					generateErrorMessage(e);
				}

			} else if (index == -2) {
				try {
					model.getCurrentHero().castSpell(
							(HeroTargetSpell) model.getCurrentHero().getHand()
									.get(i), model.getOpponent());
				} catch (NotYourTurnException | NotEnoughManaException e) {
					generateErrorMessage(e);
				}

			} else
				try {
					model.getCurrentHero().castSpell(
							(MinionTargetSpell) model.getCurrentHero()
									.getHand().get(i),
							model.getOpponent().getField().get(index));
				} catch (NotYourTurnException | NotEnoughManaException
						| InvalidTargetException e) {
					generateErrorMessage(e);
				}

		} else if (type.equals("MinionTargetSpell")) {
			try {
				model.getCurrentHero().castSpell(
						(MinionTargetSpell) model.getCurrentHero().getHand()
								.get(i),
						model.getOpponent().getField().get(index));
			} catch (NotYourTurnException | NotEnoughManaException
					| InvalidTargetException e) {
				generateErrorMessage(e);
			}
		} else {
			try {
				model.getCurrentHero()
						.castSpell(
								(LeechingSpell) model.getCurrentHero()
										.getHand().get(i),
								model.getOpponent().getField().get(index));
			} catch (NotYourTurnException | NotEnoughManaException e) {
				generateErrorMessage(e);
			}
		}
	}

	@Override
	public void playSpell(int i, String type, boolean b) {
		try {
			model.getCurrentHero().castSpell(
					(AOESpell) model.getCurrentHero().getHand().get(i),
					model.getOpponent().getField());
		} catch (NotYourTurnException | NotEnoughManaException e) {
			generateErrorMessage(e);
		}
	}

	@Override
	public void playSpelloncurr(int i, String type, int index) {
		try {
			if (type.equals("Double")) {
				if (index == -1) {
					model.getCurrentHero().castSpell(
							(HeroTargetSpell) model.getCurrentHero().getHand()
									.get(i), model.getCurrentHero());
				} else if (index == -2) {
					model.getCurrentHero().castSpell(
							(HeroTargetSpell) model.getCurrentHero().getHand()
									.get(i), model.getCurrentHero());
				} else {
					model.getCurrentHero().castSpell(
							(MinionTargetSpell) model.getCurrentHero()
									.getHand().get(i),
							model.getCurrentHero().getField().get(index));
				}
			} else if (type.equals("MinionTargetSpell")) {
				model.getCurrentHero().castSpell(
						(MinionTargetSpell) model.getCurrentHero().getHand()
								.get(i),
						model.getCurrentHero().getField().get(index));
			} else {
				model.getCurrentHero()
						.castSpell(
								(LeechingSpell) model.getCurrentHero()
										.getHand().get(i),
								model.getCurrentHero().getField().get(index));
			}
		} catch (NotYourTurnException | NotEnoughManaException
				| InvalidTargetException e) {
			generateErrorMessage(e);
		}
	}

	@Override
	public void useHeroPower() {
		try {
			model.getCurrentHero().useHeroPower();
		} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
				| NotYourTurnException | FullFieldException
				| CloneNotSupportedException e) {
			generateErrorMessage(e);
		} catch (FullHandException e) {
			JOptionPane.showMessageDialog(new JDialog(), "<html>"
					+ "Your Hand is Full" + "<br>"
					+ e.getBurned().getCardStats(), "Error",
					JOptionPane.ERROR_MESSAGE);
			updateGame();
		}
	}

	@Override
	public void useHeroPower(int index) {
		try {
			if (model.getCurrentHero() instanceof Mage) {
				if (index == -1) {
					((Mage) model.getCurrentHero()).useHeroPower(model
							.getCurrentHero());
				} else if (index == -2) {
					((Mage) model.getCurrentHero()).useHeroPower(model
							.getOpponent());
				} else
					((Mage) model.getCurrentHero()).useHeroPower(model
							.getCurrentHero().getField().get(index));

			} else {
				if (index == -1) {
					((Priest) model.getCurrentHero()).useHeroPower(model
							.getCurrentHero());
				} else if (index == -2) {
					((Priest) model.getCurrentHero()).useHeroPower(model
							.getOpponent());
				} else
					((Priest) model.getCurrentHero()).useHeroPower(model
							.getCurrentHero().getField().get(index));
			}
		} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
				| NotYourTurnException | FullFieldException
				| CloneNotSupportedException e) {
			generateErrorMessage(e);
		} catch (FullHandException e) {
			JOptionPane.showMessageDialog(new JDialog(), "<html>"
					+ "Your Hand is Full" + "<br>"
					+ e.getBurned().getCardStats(), "Error",
					JOptionPane.ERROR_MESSAGE);
			updateGame();
		}
	}

	@Override
	public void useHeroPoweropp(int index) {
		try {
			if (model.getCurrentHero() instanceof Mage) {
				((Mage) model.getCurrentHero()).useHeroPower(model
						.getOpponent().getField().get(index));

			} else {
				((Priest) model.getCurrentHero()).useHeroPower(model
						.getOpponent().getField().get(index));
			}
		} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
				| NotYourTurnException | FullFieldException
				| CloneNotSupportedException e) {
			generateErrorMessage(e);
		} catch (FullHandException e) {
			JOptionPane.showMessageDialog(new JDialog(), "<html>"
					+ "Your Hand is Full" + "<br>"
					+ e.getBurned().getCardStats(), "Error",
					JOptionPane.ERROR_MESSAGE);
			updateGame();
		}
	}

	@Override
	public String getHeroType() {
		if (model.getCurrentHero() instanceof Mage) {
			return "Mage";
		} else if (model.getCurrentHero() instanceof Hunter) {
			return "Hunter";
		} else if (model.getCurrentHero() instanceof Priest) {
			return "Priest";
		} else if (model.getCurrentHero() instanceof Warlock) {
			return "Warlock";
		} else
			return "Paladin";
	}

	@Override
	public void attackminion(int attackerPressedKart, int i) {
		try {
			if (i == -2) {

				model.getCurrentHero().attackWithMinion(
						model.getCurrentHero().getField()
								.get(attackerPressedKart), model.getOpponent());

			} else {
				model.getCurrentHero().attackWithMinion(
						model.getCurrentHero().getField()
								.get(attackerPressedKart),
						model.getOpponent().getField().get(i));
			}
		} catch (CannotAttackException | NotYourTurnException
				| TauntBypassException | NotSummonedException
				| InvalidTargetException e) {
			generateErrorMessage(e);
		}
	}

	public void generateErrorMessage(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
		updateGame();
	}

	@Override
	public String getoppDeckCount() {
		return "" + model.getOpponent().getDeck().size();
	}

	@Override
	public String getDeckCount() {
		return "" + model.getCurrentHero().getDeck().size();
	}

	@Override
	public String getWinner() {
		if (model.getFirstHero().getCurrentHP() == 0) {
			return "Player Two";
		}
		return "Player One";
	}

	@Override
	public void showendTurn() {
		if (model.getCurrentHero().getCurrentHP() > 0
				&& model.getOpponent().getCurrentHP() > 0) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						view.showendTurn();
						Thread.sleep(2000);
						view.play();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}
	}
}
