import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enregistrement extends JWindow implements MouseListener {
	
	protected String ville;
	protected int mouseX;
	protected int mouseY;
	protected Robot robot;
	protected ContentPanel panel;
	
	public void init(String s) {
		ville = s;
		addMouseListener(this);
		//setSize(200, 200);
		try {
			robot = new Robot();
			panel = new ContentPanel();
			setContentPane(panel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		createCapture();
	}

	public void mouseClicked(MouseEvent e) {
		PointerInfo pointer = MouseInfo.getPointerInfo();
		Point location = pointer.getLocation(); 
		System.out.println("La souris se trouve en "+location);
		mouseX = location.x;
		mouseY = location.y;
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void createCapture(){
		try{
			Point point = new Point(0,0);
			SwingUtilities.convertPointToScreen(point,panel);
			setVisible(false);
			Image image = robot.createScreenCapture(new Rectangle(point,panel.getSize()));
			setVisible(true);
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(image,0);
			mt.waitForAll();
			panel.setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
