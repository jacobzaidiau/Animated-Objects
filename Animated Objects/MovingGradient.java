/*
 *  ============================================================================================
 *  MovingGradient.java : Draws a rectangle with a circular shaped gradient fill.
 *  YOUR UPI: ssah933
 *  YOUR NAME: Saqib Zaidi Sahib
 *  YOUR AUID: 222479856
 *  ============================================================================================
 */

import java.awt.*;
import java.util.Random; 

public class MovingGradient extends MovingRectangle {
	Random random = new Random();
	int radius = random.nextInt((int) (width * 0.75))+ (int) (width / 8);
	
	public MovingGradient() {
		super();
	}
	
	public MovingGradient(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType); 
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		float[] FRACTIONS = { 0.2f, 1.0f};
		Color[] COLORS = { this.borderColor, this.fillColor};
	    RadialGradientPaint blackToGray = new RadialGradientPaint(
	    		topLeft.x + (int) (0.5 * width),
                topLeft.y + (int) (0.5 * height),
               radius,
               FRACTIONS,
               COLORS,
               MultipleGradientPaint.CycleMethod.REFLECT);
	    g2.setPaint(blackToGray);
		g.fillRect(this.topLeft.x, this.topLeft.y, this.width, this.height);
		g.setColor(this.borderColor);
		drawHandles(g);
	}
}
