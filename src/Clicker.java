import java.awt.*;
import java.awt.event.*;

public class Clicker extends Robot {
	
	public Clicker() throws AWTException {
	}
	
	public void click(int x, int y) throws AWTException {
		mouseMove(x, y);
		mousePress(InputEvent.BUTTON1_MASK);
		mouseRelease(InputEvent.BUTTON1_MASK);
	}

}
