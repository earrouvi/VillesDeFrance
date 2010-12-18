import java.awt.*;
import java.io.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;

public class Capture { 

	public Capture(int type, int mode, String nom) { 
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
			BufferedImage shot = (new Robot()).createScreenCapture(new Rectangle(x, y, xx, yy)); 
			out = new BufferedOutputStream(new FileOutputStream("images/"+nom+".jpg")); 
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			encoder.encode(shot); 
		} 
		catch (Exception exc) {
			exc.printStackTrace(); 
		} 
		
		// image out
		finally {
        try {
            if (out != null) {
                out.close(); 
            } 
            System.exit(0); 
        } 
        catch (Throwable t) {} 
    } 

	}
}