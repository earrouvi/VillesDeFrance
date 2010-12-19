
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Image im = new Image("images/villes/montargis.jpg");
		
		for (int i=12;i<21;i++) {
			Image im2 = new Image ("images/alphabet/"+i+".jpg");
			boolean egale = im.compareTo(im2);
			if (egale) {
				System.out.println(i+" : true");
			}
		}
		
	}

}
