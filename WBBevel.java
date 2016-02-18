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

class WBBevel extends WBShape{

	WBBevel (int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}
	
	WBBevel(WBBevel wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}

	public String toXml(){ 
		String xml = "<WBBevel>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBBevel>";
		return xml;
	}

	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);
		if(draw){
			g.setColor(new Color(205, 205, 205));

			int ax1[] = {x+w, x+w, x, x+w/8, x+(7*w)/8, x+(7*w)/8};
			int ay1[] = {y, y+h, y+h, y+(7*h)/8, y+(7*h)/8, y+h/8};
			g.fillPolygon(ax1, ay1, 6);
			
			g.setColor(col);
			g.drawRect(x, y, w, h);
			g.drawRect(x+w/8, y+h/8, w-w/4, h-h/4);
			g.drawLine(x, y, x+w/8, y+h/8);
			g.drawLine(x+w, y, x+(7*w)/8, y+h/8);
			g.drawLine(x, y+h, x+w/8, y+(7*h)/8);
			g.drawLine(x+w, y+h, x+(7*w)/8, y+(7*h)/8);
		}
		else{

			int ax[] = {x, x, x+w, x+(7*w)/8, x+w/8, x+w/8};
			int ay[] = {y+h, y, y, y+h/8, y+h/8, y+(7*h)/8};

			g.fillPolygon(ax, ay, 6);

			g.setColor(new Color(205, 205, 205));

			int ax1[] = {x+w, x+w, x, x+w/8, x+(7*w)/8, x+(7*w)/8};
			int ay1[] = {y, y+h, y+h, y+(7*h)/8, y+(7*h)/8, y+h/8};
			g.fillPolygon(ax1, ay1, 6);

			g.setColor(Color.BLACK);

			g.drawRect(x, y, w, h);
			g.drawRect(x+w/8, y+h/8, w-w/4, h-h/4);
			g.drawLine(x, y, x+w/8, y+h/8);
			g.drawLine(x+w, y, x+(7*w)/8, y+h/8);
			g.drawLine(x, y+h, x+w/8, y+(7*h)/8);
			g.drawLine(x+w, y+h, x+(7*w)/8, y+(7*h)/8);
		}
	}
}
