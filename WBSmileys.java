/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * 
 * Copyright (c) 2011 onwards by WeaveBytes, Inc. 
 * Please reports bugs at weavebytes@gmail.com
 * 
 * This file may be distributed and/or modified under the terms of the 
 * GNU General Public License version 2 as published by the Free Software 
 * Foundation. (See COPYING.GPL for details.)
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 * 
 */
import java.awt.*;
import java.awt.event.*;

class WBSmileys extends WBShape{
	int type;

	WBSmileys(int x, int y, int w, int h, int type, Color col){
		super(x, y, w, h, col,false);
		this.type = type;
	}

	WBSmileys(WBSmileys wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, false);
		this.type = wbs.type;
	}

	public String toXml(){ 
		String xml = "<WBSmileys>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<type>" + type + "</type>";
		xml += "</WBSmileys>";
		return xml;
	}

	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		g.setColor(col);
			switch(type){
				case 1:
					g.fillOval(x,y,w,h);
					g.setColor(Color.BLACK);
					g.fillOval(x+(w/5),y+(h/5),w/5,h/5);
					g.fillOval(x+((3*w)/5),y+(h/5),w/5,h/5);
					g2.drawArc(x+w/5,y+h/5,(3*w)/5,(3*h)/5,210,120);
					break;
					
				case 2:
					g.fillOval(x,y,w,h);
					g.setColor(Color.BLACK);
					g.fillOval(x+(w/5),y+(h/5),w/5,h/5);
					g.fillOval(x+((3*w)/5),y+(h/5),w/5,h/5);
					g2.drawArc(x+w/5,y+(3*h)/5,(3*w)/5,(3*h)/5,30,120);
					break;

				case 3:
					g.fillOval(x,y,w,h);
					g.setColor(Color.BLACK);
					g.fillOval(x+((3*w)/5),y+(h/5),w/5,h/5);
					
					g2.drawArc(x+w/5,y+h/5,w/5,h/5,180,180);
					g2.drawArc(x+w/5,y+h/5,(3*w)/5,(3*h)/5,200,100);
					break;
				
				case 4:
					g.fillOval(x,y,w,h);
					g.setColor(Color.BLACK);
					g.fillOval(x+((3*w)/10),y+((3*h)/5),w/20,h/10);
					g.fillOval(x+((3*w)/5),y+((6*h)/25),w/5,h/5);
					g.drawLine(x+((3*w)/5),y+((7*h)/10),x+((7*w)/10),y+((7*h)/10));
					g.drawOval(x,y,w,h);
					break;
				
				case 5:
					g.fillOval(x,y,w,h);
					g.setColor(Color.BLACK);
					g.fillOval(x+(w/5),y+(h/5),w/5,h/5);
					g.fillOval(x+((3*w)/5),y+(h/5),w/5,h/5);
					g.drawOval(x,y,w,h);
					//g.drawArc(x+15,y+20,20,20,180,180);
					g.setColor(Color.RED);
					g2.drawArc(x+w/5,y+(3*h)/10,(3*w)/5,(3*h)/5,180,180);
					break;
				
				case 8:
					g.fillArc(x, y, w, h,0, 180);
					g.setColor(Color.BLACK);
					g.fillArc(x, y, w, h, 180, 180);
					g.setColor(col);
					g.fillArc(x, y+h/4, w/2, h/2, 180, 180);
					g.setColor(Color.BLACK);
					g2.drawOval(x, y, w, h);
					g.fillArc(x+w/2, y+h/4, w/2, h/2,350,200);
					g.fillOval(x+w/8, y+(3*h)/8, w/4, h/4);
					g.setColor(col);
					g.fillOval(x+(w*5)/8, y+(3*h)/8, w/4, h/4);
					g2.drawArc(x+w/8, y+h/8, (3*w)/4, (3*h)/4, 240, 60);
					break;

				/*case 12:
					g.fillOval(x, y, w, h);
					g.setColor(Color.BLACK);
					g2.drawOval(x, y, w, h);
					g2.drawArc(x, y, );*/
			}
	}
	public String getName() {
        return "WBSmileys";
    }
}
