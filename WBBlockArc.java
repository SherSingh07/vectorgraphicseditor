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
class  WBBlockArc extends WBShape
{

	WBBlockArc (int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}

	WBBlockArc(WBBlockArc wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}

	public String toXml(){ 
		String xml = "<WBBlockArc>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBBlockAtc>";
		return xml;
	}


	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);
		if(draw){
			g.drawArc(x, y, w, 2*h, 0, 180);
			g.drawArc(x+w/4, y+h/2, w/2, h, 0, 180);
			g.drawLine(x, y+h, x+w/4, y+h);
			g.drawLine(x+(3*w)/4, y+h, x+w, y+h);
		}

		else{
			//g.fillArc(x, y, w, 2*h, 0, 180);
			//g.clearArc(x+w/4, y+h/2, w/2, h, 0, 180);					
		}
	}	
}
