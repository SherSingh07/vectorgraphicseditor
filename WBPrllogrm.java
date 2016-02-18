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

class WBPrllogrm extends WBShape{

	WBPrllogrm(int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}

	WBPrllogrm(WBPrllogrm wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
	}

	public String toXml(){ 
		String xml = "<WBPrllogrm>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		//xml += "<type>" + type + "</type>";
		//xml += "<size>" + size + "</size>";
		xml += "</WBPrllogrm>";
		return xml;
	}

	public void draw(Graphics g){
		g.setColor(col);
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			int[]ax1 = {x+w/6, x+w, x+(5*w)/6, x}; 
			int[]ay1 = {y, y, y+h, y+h};
			g.drawPolygon(ax1, ay1, 4);
					
		}
		
		else {
			int[]ax = {x+w/6, x+w, x+(5*w)/6, x}; 
			int[]ay = {y, y, y+h, y+h};
			g.fillPolygon(ax, ay, 4);
		}
	}

	public String getName() {
        return "WBPrllogrm";
    }
}
