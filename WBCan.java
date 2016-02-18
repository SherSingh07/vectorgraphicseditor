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

class WBCan extends WBShape{

	public WBCan (int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}
	
	WBCan(WBCan wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}
	
	public String toXml(){ 
		String xml = "<WBCan>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBCan>";
		return xml;
	}

	public void draw(Graphics g){
		g.setColor(col);
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			g.drawOval(x, y, w, h/6);
			g.drawLine(x, y+h/12, x, y+(11*h)/12);
			g.drawLine(x+w, y+h/12, x+w, y+(11*h)/12);
			g.drawArc(x, y+(h*5)/6, w, h/6, 180, 180);
		}
		else{

			int ax[] = {x, x+w, x+w, x};
			int ay[] = {y+h/12, y+h/12, y+(11*h)/12, y+(11*h)/12};
			g.fillPolygon(ax, ay, 4);
			g.fillArc(x, y+(h*5)/6, w, h/6, 180, 180);

			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(x, y, w, h/6);

		}
	}
}
