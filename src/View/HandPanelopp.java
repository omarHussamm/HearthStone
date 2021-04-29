package View;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HandPanelopp extends JPanel {
	private ArrayList<BackCard> hand;
	private HandPaneloppListener listener;
	private kroot AttackedKart;

	public HandPanelopp(opponentHero opponentHero) {
		setOpaque(false);
		listener = opponentHero;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		hand = new ArrayList<BackCard>();
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < listener.getoppHandSize(); i++) {
					BackCard kart = new BackCard();
					hand.add(kart);
					add(kart);
					try {
						revalidate();
						repaint();
						Thread.sleep(500);
						revalidate();
						repaint();
					} catch (InterruptedException e) {
						System.out.println("opp Thread problem");
					}
				}
				revalidate();
				repaint();
				listener.deselect();
			}
		});
		t.start();
		revalidate();
		repaint();
	}

	public void updateHand() {
		while (!hand.isEmpty()) {
			this.remove(hand.get(0));
			hand.remove(0);
		}
		for (int i = 0; i < listener.getoppHandSize(); i++) {
			BackCard kart = new BackCard();
			hand.add(kart);
			add(kart);
		}
		revalidate();
		repaint();
	}

	public HandPaneloppListener getListener() {
		return listener;
	}

	public void setListener(HandPaneloppListener opponentHero) {
		this.listener = opponentHero;
	}

	public kroot getPressedKart() {
		return AttackedKart;
	}

	public void setPressedKart(kroot pressedKart) {
		this.AttackedKart = pressedKart;
	}

}
