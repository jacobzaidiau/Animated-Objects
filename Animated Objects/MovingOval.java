/*
 *  ============================================================================================
 *  MovingOval.java : Draws an oval.
 *  YOUR UPI: ssah933
 *  YOUR NAME: Saqib Zaidi Sahib
 *  YOUR AUID: 222479856
 *  ============================================================================================
 */

import java.awt.*;

public class MovingOval extends MovingShape {
	public MovingOval(){
		super();
	}
	
	public MovingOval(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType); 
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(this.borderColor);
		g.fillOval(this.topLeft.x, this.topLeft.y, this.width, this.height);
		g.setColor(this.fillColor);
		g.drawOval(this.getX(), this.getY(), this.width, this.height);
		drawHandles(g);
	}
	
	@Override
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
		dx = (2 * mousePt.x - topLeft.x - EndPt.x) / (double) width;
		dy = (2 * mousePt.y - topLeft.y - EndPt.y) / (double) height;
		return dx * dx + dy * dy < 1.0;
	}
}
