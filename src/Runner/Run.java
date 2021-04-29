package Runner;

import java.io.IOException;

import javax.swing.SwingUtilities;

import exceptions.FullHandException;
import Controller.Controller;

public class Run {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Controller();
				} catch (FullHandException | IOException
						| CloneNotSupportedException e) {
					System.out.println("Controller can not Run!");
				}
			}
		});
	}

}
