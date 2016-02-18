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

public class WBHeart extends WBShape{

	int size;

	WBHeart(int x, int y, int w, int h,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.size = size;
	}

	WBHeart(WBHeart wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.size = wbs.size;
	}
	
	public String toXml(){ 
		String xml = "<WBHeart>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<size>" + size + "</size>";
		xml += "</WBHeart>";
		return xml;
	}


	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }
	
		g.setColor(col);

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(draw){			
			g2d.drawArc(x, y, w/2, h/2, 8, 192);
			g2d.drawArc(x+w/2, y, w/2, h/2, 340, 192);
			g2d.drawLine(x, y+h/3, x+w/2, y+h);
			g2d.drawLine(x+w, y+h/3, x+w/2, y+h);
		}
		else {
			g.fillArc(x, y, w/2, h/2, 8, 192);
			g.fillArc(x+w/2, y, w/2, h/2, 340, 192);
		
			int ax[] = {x, x+w/4,x+w/2, x+(3*w)/4, x+w, x+w/2};
			int ay[] = {y+h/3,y+h/4, y+h/5, y+h/4, y+h/3, y+h};
			g.fillPolygon(ax, ay, 6);
	
		}
	}

	public String getName() {
        return "WBHeart";
    }
}

