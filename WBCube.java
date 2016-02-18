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

class WBCube extends WBShape{

	public WBCube (int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}
	
	WBCube(WBCube wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}

	public String toXml(){ 
		String xml = "<WBCube>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBCube>";
		return xml;
	}


	public void draw(Graphics g){
		g.setColor(col);
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			g.drawRect(x, y+h/4, w-h/4, h-h/4);
			g.drawLine(x, y+h/4, x+h/4, y);
			g.drawLine(x+h/4, y, x+w, y);
			g.drawLine(x+w, y, x+w-h/4, y+h/4);
			g.drawLine(x+w, y, x+w, y+(3*h)/4);
			g.drawLine(x+w, y+(3*h)/4, x+w-h/4, y+h);
		
		}
		else{
			g.fillRect(x, y+h/4, w-h/4, h-h/4);

			int ax[] = {x, x+h/4, x+w, x+w-h/4};
			int ay[] = {y+h/4, y, y, y+h/4};

			g.fillPolygon(ax, ay, 4);

			g.setColor(Color.LIGHT_GRAY);

			int ax1[] = {x+w, x+w-h/4, x+w-h/4, x+w};
			int ay1[] = {y, y+h/4, y+h, y+(3*h)/4};

			g.fillPolygon(ax1, ay1, 4);

			g.setColor(Color.BLACK);
			g.drawRect(x, y+h/4, w-h/4, h-h/4);
			g.drawLine(x, y+h/4, x+h/4, y);
			g.drawLine(x+h/4, y, x+w, y);
			g.drawLine(x+w, y, x+w-h/4, y+h/4);
			g.drawLine(x+w, y, x+w, y+(3*h)/4);
			g.drawLine(x+w, y+(3*h)/4, x+w-h/4, y+h);
		}
	}
}
