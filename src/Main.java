
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Image im = new Image ("images/im1.jpg");
		Image im2 = new Image ("images/im2.jpg");
		//im.greyScale();
		//im = new Image ("test3_grey.jpg");
		boolean egale = im.compareTo(im2);
		System.out.println(egale);
		
	}

}
