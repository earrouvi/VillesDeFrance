import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Automate extends Robot {
	
	public Automate() throws AWTException {
	}
	
	public void click(int x, int y) throws AWTException {
		mouseMove(x, y);
		mousePress(InputEvent.BUTTON1_MASK);
		mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public void capture(int type, int mode, String nom) throws AWTException { 
		// screen size and position inits
		int x, y, xx, yy;
		x = 270; y = 210; xx = 150; yy = 35;
		if (type == 0) {
			x = 270;
		} else if (type == 1) {
			x = 283;
		} 
		if (mode == 0) {
			xx = 150;
		} else if (mode == 1) {
			xx = 15;
		}

		// screen capture
		OutputStream out = null; 
		try {
			Thread.currentThread().sleep(2000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		try {
			BufferedImage shot = createScreenCapture(new Rectangle(x, y, xx, yy)); 
			out = new BufferedOutputStream(new FileOutputStream("images/"+nom+".jpg")); 
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			encoder.encode(shot); 
		} 
		catch (Exception exc) {
			exc.printStackTrace(); 
		}
		
		// grey scale transformation
		try {
			Image im = new Image("images/"+nom+".jpg");
			//im.greyScale("images/grey/"+nom);
		}

		// image out
		finally {
			try {
				if (out != null) {
					out.close(); 
				} 
				//System.exit(0); 
			} 
			catch (Throwable t) {} 
		} 
	}

}
