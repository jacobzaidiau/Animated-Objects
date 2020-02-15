/*
 *  ============================================================================================
 *  MovingChecker.java : Creates a checker with a random number of rows and columns.
 *  YOUR UPI: ssah933
 *  YOUR NAME: Saqib Zaidi Sahib
 *  YOUR AUID: 222479856
 *  ============================================================================================
 */



import java.awt.*;
import java.util.Random;

public class MovingChecker extends MovingRectangle {
	Random random = new Random();
	int right = random.nextInt(10) + 1;
	int down = random.nextInt(10) + 1;
	
	public MovingChecker(){
		super();
	}
	
	public MovingChecker(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType); 	
	}
	
	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < down; j++) {
			for (int i = 0; i < right; i++) {
				int theTopLeft = (this.topLeft.x + (this.width / right * i));
				int theTopUp = (this.topLeft.y + (this.height / down * j));
				if ((i + j) % 2 == 0) {
					g.setColor(this.borderColor);
					g.fillRect(theTopLeft, theTopUp, this.width / right, this.height / down);
				}
				else {
					g.setColor(this.fillColor);
					g.fillRect(theTopLeft, theTopUp, this.width / right, this.height / down);
		
				}
			}
		}
		drawHandles(g);
	}

}
