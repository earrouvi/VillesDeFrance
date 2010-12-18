public class Image extends ImageTraitement {
	
	protected String nom;

	public Image(String path) {
		super(path);
	}

	public Image(int w, int h) {
		super(w, h);
	}
	
	public void greyScale(String nom){
		int w = getWidth();
		int h = getHeight();
		Image image2 = new Image(w, h);
		int i,j,k;
		double y,r,v,b;
		for (i=0;i<w;i++){
			for(j=0;j<h;j++){
				r = getPixel(i,j)[0];
				v = getPixel(i,j)[0];
				b = getPixel(i,j)[0];
				y = 0.299*r+0.587*v+0.114*b;
				k = (int) Math.floor(y);
				image2.setPixel(i,j,k);
			}
		}
		image2.saveAsPng("images/"+nom+".png");
	}
	
	public boolean compareTo(Image im) {
		int w, h;
		w = im.getWidth(); h = im.getHeight();
		
		for (int i=0;i<w;i++) {
			for (int j=0;j<h;j++) {
				if (!(Math.abs(getPixel(i, j)[0] - im.getPixel(i, j)[0]) < 50)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
