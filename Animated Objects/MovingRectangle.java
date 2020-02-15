/*
 *  ============================================================================================
 *  MovingRectangle.java : Draws a rectangle.
 *  YOUR UPI: ssah933
 *  YOUR NAME: Saqib Zaidi Sahib
 *  YOUR AUID: 222479856
 *  ============================================================================================
 */

import java.awt.*;

public class MovingRectangle extends MovingShape {
	public MovingRectangle(){
		super();
	}
	
	public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType); 
	}

	@Override
	public boolean contains(Point mousePt) {
		return (topLeft.x <= mousePt.x && mousePt.x <= topLeft.x + width  && topLeft.y <= mousePt.y && mousePt.y <= topLeft.y + height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.borderColor);
		g.fillRect(this.topLeft.x, this.topLeft.y, this.width, this.height);
		g.setColor(this.fillColor);
		g.drawRect(this.getX(), this.getY(), this.width, this.height);
		drawHandles(g);
	}

}
