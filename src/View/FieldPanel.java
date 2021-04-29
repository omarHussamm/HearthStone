package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {
	private ArrayList<kroot> field;
	private FieldPanelListener listener;
	private kroot attackerPressedKart;

	public FieldPanel() {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		field = new ArrayList<kroot>();
		revalidate();
		repaint();
	}

	public void updateField() {
		attackerPressedKart = new kroot("", -3);
		while (!field.isEmpty()) {
			remove(field.remove(0));
		}
		for (int i = 0; i < listener.getFieldSize(); i++) {
			kroot kart = new kroot(listener.getFieldCardStats(i), i);
			add(kart);
			field.add(kart);
			kart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kroot kart = (kroot) e.getSource();
					int pressedkart = listener.getPressedKart();
					if (pressedkart != -3) {
						listener.playSpelloncurr(pressedkart,
								listener.getCardType(pressedkart),
								kart.getIndex());
					} else if (listener.isUsepower()) {
						listener.useHeroPower(kart.getIndex());
					} else if (attackerPressedKart.getIndex() == -3) {
						attackerPressedKart = kart;
						kart.setBorder(new LineBorder(Color.BLACK));
						System.out.println("minion pressed");
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

	public ArrayList<kroot> getField() {
		return field;
	}

	public void setField(ArrayList<kroot> field) {
		this.field = field;
	}

	public FieldPanelListener getListener() {
		return listener;
	}

	public void setListener(FieldPanelListener listener) {
		this.listener = listener;
	}

	public kroot getAttackerPressedKart() {
		return attackerPressedKart;
	}

	public void setAttackerPressedKart(kroot attackerPressedKart) {
		this.attackerPressedKart = attackerPressedKart;
	}
}
