
public class ConnTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Connexion co = new Connexion();
		//co.insert("Draguignan", 20, 30);
		
		//auto.capture(1, 1, "abc");
		
		Automate auto;
		try {
			auto = new Automate();
			Thread.currentThread().sleep(500);
			auto.click(600, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
