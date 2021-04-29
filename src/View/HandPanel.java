package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class HandPanel extends JPanel {
	private ArrayList<kroot> hand;
	private HandPanelListener listener;
	private int pressedkartIndex;

	public HandPanel(currHero currHero) {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		listener = currHero;
		hand = new ArrayList<kroot>();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < listener.getHandSize(); i++) {

					kroot kart = new kroot(listener.getHandCardsStats(i), i);
					try {
						hand.add(kart);
						add(kart);
						revalidate();
						repaint();
						Thread.sleep(500);
						revalidate();
						repaint();
					} catch (InterruptedException e) {
						System.out.println("problem with thread");
					}
				}
				revalidate();
				repaint();
			}
		});

		t.start();
		revalidate();
		repaint();
	}

	public void updateHand() {
		pressedkartIndex = -3;
		while (!hand.isEmpty()) {
			remove(hand.get(0));
			hand.remove(0);
		}
		for (int i = 0; i < listener.getHandSize(); i++) {

			kroot kart = new kroot(listener.getHandCardsStats(i), i);
			hand.add(kart);
			add(kart);
			kart.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (!listener.isUsepower()
							&& pressedkartIndex == -3
							&& listener.getAttackerPressedKart().getIndex() == -3) {
						kroot k = (kroot) e.getSource();
						String type = listener.getCardType(k.getIndex());
						System.out.println(type);
						switch (type) {
						case "Minion":
							listener.playCard(k.getIndex());
							break;
						case "FieldSpell":
							listener.playSpell(k.getIndex(), type);
							break;
						case "MinionTargetSpell":
						case "LeechingSpell":
						case "Double":
							pressedkartIndex = k.getIndex();
							k.setBorder(new LineBorder(Color.BLACK));
							break;

						case "AOESpell":
							listener.playSpell(k.getIndex(), type, true);
						}
					} else
						listener.deselect();
					revalidate();
					repaint();
				}
			});
		}
		revalidate();
		repaint();
	}

	public HandPanelListener getListener() {
		return listener;
	}

	public void setListener(HandPanelListener listener) {
		this.listener = listener;
	}

	public int getPressedkart() {
		return pressedkartIndex;
	}

	public void setPressedkart(int pressedkart) {
		this.pressedkartIndex = pressedkart;
	}

}
