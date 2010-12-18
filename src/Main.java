
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Image im = new Image("images/test2.jpg");
		//im.greyScale("grey");
//		Image im = new Image("images/parti_grey.png");
//		
//		for (int i=1;i<8;i++) {
//			Image im2 = new Image ("images/alphabet/"+i+".jpg");
//			boolean egale = im.compareTo(im2);
//			if (egale) {
//				System.out.println(i+" : true");
//			}
//		}
		
		for (int i=22;i<23;i++) {
			Image im2 = new Image ("images/alphabet/"+i+".jpg");
			im2.greyScale("/alphabet/grey/"+String.valueOf(i));
		}
		
	}

}
