/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * WbStars.java is the java file for drawing 4pt, 5pt or 6pt star.
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

class WBStars extends WBShape{

	int type;
	int size;

	WBStars(int x, int y, int w, int h, int type,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.type = type;
		this.size = size;
	}

	WBStars(WBStars wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.type = wbs.type;
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBStars>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<type>" + type + "</type>";
		xml += "<size>" + size + "</size>";
		xml += "</WBStars>";
		return xml;
	}

	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(draw) {
			switch(type){
				case 1 :
					int ax[] = {x+(w/2), x+(2*w)/3, x+w, x+(2*w)/3, x+(w/2), x+(w/3), x, x+(w/3)};
					int ay[] = {y, y+(h/3), y+(h/2), y+(2*h)/3, y+h, y+(2*h)/3, y+(h/2), y+(h/3)};
					g2d.drawPolygon(ax, ay, 8);
					break;
				case 2:
					int ax1[] = {x+w/2, x+(2*w)/3, x+w, x+(3*w)/4, x+(5*w)/6, x+w/2, x+w/6, x+w/4, x, x+w/3};
					int ay1[] = {y, y+h/3, y+h/3, y+(5*h)/8, y+h, y+(3*h)/4, y+h, y+(5*h)/8, y+h/3, y+h/3};
					g2d.drawPolygon(ax1, ay1, 10);
					break;
				case 3:
					int ax2[] = {x+w/2, x+(2*w)/3, x+w, x+(5*w)/6, x+w, x+(2*w)/3, x+w/2, x+w/3, x, x+w/6, x, x+w/3};
					int ay2[] = {y, y+h/4, y+h/4, y+h/2, y+(3*h)/4, y+(3*h)/4, y+h, y+(3*h)/4, y+(3*h)/4, y+h/2, y+h/4, y+h/4, y};
					g2d.drawPolygon(ax2, ay2, 12);
					break;
			}	
		}
		else{
			switch(type){
				case 1 :
					int ax[] = {x+(w/2), x+(2*w)/3, x+w, x+(2*w)/3, x+(w/2), x+(w/3), x, x+(w/3)};
					int ay[] = {y, y+(h/3), y+(h/2), y+(2*h)/3, y+h, y+(2*h)/3, y+(h/2), y+(h/3)};
					g.fillPolygon(ax, ay, 8);
					break;
				case 2:
					int ax1[] = {x+w/2, x+(2*w)/3, x+w, x+(3*w)/4, x+(5*w)/6, x+w/2, x+w/6, x+w/4, x, x+w/3};
					int ay1[] = {y, y+h/3, y+h/3, y+(5*h)/8, y+h, y+(3*h)/4, y+h, y+(5*h)/8, y+h/3, y+h/3};
					g.fillPolygon(ax1, ay1, 10);
					break;
				case 3:
					int ax2[] = {x+w/2, x+(2*w)/3, x+w, x+(5*w)/6, x+w, x+(2*w)/3, x+w/2, x+w/3, x, x+w/6, x, x+w/3};
					int ay2[] = {y, y+h/4, y+h/4, y+h/2, y+(3*h)/4, y+(3*h)/4, y+h, y+(3*h)/4, y+(3*h)/4, y+h/2, y+h/4, y+h/4, y};
					g.fillPolygon(ax2, ay2, 12);
					break;
			}
		}
	}
	public String getName() {
        return "WBStars";
    }
}
