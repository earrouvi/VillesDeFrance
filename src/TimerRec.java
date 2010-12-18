import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class TimerRec {
	
	protected String ville;
	protected int mouseX;
	protected int mouseY;
	
	public TimerRec(String s) {
		ville = s;
		try {
			Thread.currentThread().sleep(5000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation(); 
		System.out.println("La souris se trouve en "+location);
		mouseX = location.x;
		mouseY = location.y;
	}
	
	public boolean storeInDB() {
		Connexion co = new Connexion();
		co.insert(ville, mouseX, mouseY);
		return true;
	}

}
