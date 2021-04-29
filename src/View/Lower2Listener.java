package View;

import java.io.IOException;

import exceptions.FullHandException;

public interface Lower2Listener {

	public void play();

	public void setP2(String string);

	public void setHeroes() throws FullHandException, IOException, CloneNotSupportedException;

	public void StartPlay();

}
