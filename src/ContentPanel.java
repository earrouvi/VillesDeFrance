import java.awt.*;
import javax.swing.*;

public class ContentPanel extends JPanel {
		private Image image;
		
		public ContentPanel() {
			super();
			setOpaque(false);
		}
		
		public void setImage(Image capture) {
			image=capture;repaint();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(image!=null)g.drawImage(image,0,0,this);
		}	
		
}