import java.awt.*;
import javax.swing.*;

public class TestTransparence extends JWindow{
	private MonContentPane contentpane;
	private Robot robot;
	
	public TestTransparence(){
		try {
			robot = new Robot();
		} catch(Exception e) {
			e.printStackTrace();
		}
			contentpane = new MonContentPane();
			setContentPane(contentpane);
			getContentPane().add(new JLabel(new ImageIcon("image.gif")));
			pack();setLocationRelativeTo(null);
			createCapture();setVisible(true);	
			try{
				Thread.sleep(5000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.exit(0);
	}
	
	private void createCapture(){
		try{
			Point point = new Point(0,0);
			SwingUtilities.convertPointToScreen(point,contentpane);
			setVisible(false);
			Image image = robot.createScreenCapture(new Rectangle(point,contentpane.getSize()));
			setVisible(true);
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(image,0);
			mt.waitForAll();
			contentpane.setImage(image);
		}catch(Exception e){e.printStackTrace();}
	}
	
	private class MonContentPane extends JPanel{
		private Image image;
		public MonContentPane(){
			super();
			setOpaque(false);
		}
		public void setImage(Image capture){image=capture;repaint();}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(image!=null)g.drawImage(image,0,0,this);
		}	
	}
	public static void main(String[] args){new TestTransparence();}
}
