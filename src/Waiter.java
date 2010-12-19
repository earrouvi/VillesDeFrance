import java.awt.*;
import java.io.*;


public class Waiter extends Thread {

	public Waiter() {
		super();
	}

	public void run() {
		int compteur = 0;
		int type;
		while (compteur<20) {
			compteur++;
			try {
				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader read = new BufferedReader(input);
				String nom = read.readLine(); 
				Automate auto = new Automate();
				
				if (compteur<10) {
					type = 0;
				} else {
					type = 1;
				}
				auto.capture(type, 0, "villes/"+nom);
				
				TimerRec tm = new TimerRec(nom);
				System.out.println(tm.storeInDB());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
