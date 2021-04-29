package View;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

@SuppressWarnings("serial")
public class GameFont extends Font {
	public GameFont() throws FontFormatException, IOException {

		super(Font.createFont(
				Font.TRUETYPE_FONT,
				System.class.getResource("/fonts/LHFUncialCaps.ttf")
						.openStream()).deriveFont(60.0f));
	}

}
