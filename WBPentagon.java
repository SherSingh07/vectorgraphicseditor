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

class WBPentagon extends WBShape{

	int size;

	public WBPentagon (int x, int y, int w, int h,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.size = size;
	}

	WBPentagon(WBPentagon wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBPentagon>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<size>" + size + "</size>";
		xml += "</WBPentagon>";
		return xml;
	}


	public void draw(Graphics g){
		g.setColor(col);

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			int ax[] = {x+w/2, x+w, x+(5*w)/6, x+w/6, x};
			int ay[] = {y, y+h/3, y+h, y+h, y+h/3};
			g2d.drawPolygon(ax, ay ,5);
		}
		else{

			int ax[] = {x+w/2, x+w, x+(5*w)/6, x+w/6, x};
			int ay[] = {y, y+h/3, y+h, y+h, y+h/3};
			g.fillPolygon(ax, ay, 5);

		}
	}

	public String getName() {
        return "WBPentagon";
    }
}
