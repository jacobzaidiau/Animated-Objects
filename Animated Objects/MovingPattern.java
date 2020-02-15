/*
 *  ============================================================================================
 *  MovingPattern.java : Draws a spiral using the current borderColor.
 *  YOUR UPI: ssah933
 *  YOUR NAME: Saqib Zaidi Sahib
 *  YOUR AUID: 222479856
 *  ============================================================================================
 */

import java.awt.*;

public class MovingPattern extends MovingShape {
	public MovingPattern(){
		super();
	}
	
	public MovingPattern(int x, int y, int w, int h, int mw, int mh, Color c, Color fc, int pathType){
		super(x, y, w, h, mw, mh, c, fc, pathType); 
	}

	@Override
	public void draw(Graphics g) {
        int x = this.getX() + (int) (width / 2);
        int y = this.getY() + (int) (height / 2);
        int width = 0;
        int height = 0;
        g.setColor(this.fillColor);
        
        for (int i = 0;; i++) {
        	if (width > this.width || height > this.height) {
        		break;
        	}
            if (i % 2 == 0) {
                y -=1;
                width += 2;
                height += 2;
                g.drawArc(x, y, width, height, 0, -180);
            } else {
                x = x - 2 ;
                y -= 1;
                width = width + 2;
                height = height + 2;
                g.drawArc(x, y, width, height, 0, 180);
            }
        }
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
