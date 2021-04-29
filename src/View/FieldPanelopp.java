package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FieldPanelopp extends JPanel {
	private ArrayList<kroot> field;
	private FieldPaneloppListener listener;

	public FieldPanelopp() {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		field = new ArrayList<kroot>();
		revalidate();
		repaint();
	}

	public void updateFieldopp() {
		while (!field.isEmpty()) {
			remove(field.remove(0));
		}

		for (int i = 0; i < listener.getFieldoppSize(); i++) {
			kroot kart = new kroot(listener.getFieldoppCardStats(i), i);
			add(kart);
			field.add(kart);
			kart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int spellIndex = listener.getPressedkart();
					if (spellIndex > -3) {
						kroot kart = (kroot) e.getSource();
						listener.playSpell(spellIndex,
								listener.getCardType(spellIndex),
								kart.getIndex());
					} else if (listener.isUsepower()) {
						listener.useHeroPoweropp(kart.getIndex());
					} else if (listener.getAttackerPressedKart().getIndex() != -3) {
						listener.attackminion(listener.getAttackerPressedKart()
								.getIndex(), kart.getIndex());
						listener.getAttackerPressedKart().setBorder(null);
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

	public FieldPaneloppListener getListener() {
		return listener;
	}

	public void setListener(FieldPaneloppListener listener) {
		this.listener = listener;
	}
}