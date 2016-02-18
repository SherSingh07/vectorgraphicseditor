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

class WBPlaque extends WBShape{

	public WBPlaque (int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}

	WBPlaque(WBPlaque wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}

	public String toXml(){ 
		String xml = "<WBPlaque>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBPlaque>";
		return xml;
	}


	public void draw(Graphics g){
		g.setColor(col);
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			g.drawLine(x+h/6, y, x+w-h/6, y);
			g.drawArc(x+w-h/6, y-h/6, h/3, h/3, 180, 90);
			g.drawLine(x+w, y+h/6, x+w, y+(5*h)/6);
			g.drawArc(x+w-h/6, y+(5*h)/6, h/3, h/3, 90, 90);
			g.drawLine(x+h/6, y+h, x+w-h/6, y+h);
			g.drawArc(x-h/6, y+(5*h)/6, h/3, h/3, 0, 90);
			g.drawLine(x, y+h/6, x, y+(5*h)/6);
			g.drawArc(x-h/6, y-h/6, h/3, h/3, 270, 90);
			
		}
		/*else{

			g.drawArc(x+w-h/6, y-h/6, h/3, h/3, 180, 90);
			g.drawArc(x+w-h/6, y+(5*h)/6, h/3, h/3, 90, 90);
			g.drawArc(x-h/6, y+(5*h)/6, h/3, h/3, 0, 90);
			g.drawArc(x-h/6, y-h/6, h/3, h/3, 270, 90);
			

			int ax[] = {x+h/6, x+w-h/6, x+w, x+w, x+w-h/6, x+h/6, x, x};
			int ay[] = {y, y, y+h/6, y+(5*h)/6, y+h, y+h, y+(5*h)/6, y+h/6};

			g.fillPolygon(ax, ay, 8);
			
		}*/
	}
	public String getName() {
        return "WBPlaque";
    }
}
