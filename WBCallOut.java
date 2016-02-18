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

class WBCallOut extends WBShape{
	
	int size;
	public WBCallOut (int x, int y, int w, int h,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.size=size;
	}

	WBCallOut(WBCallOut wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBCallOut>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "</WBCallOut>";
		return xml;
	}


	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(draw){
			g2d.drawArc(x, y, w, h, 240, 330);
			g2d.drawLine(x, y+h, x+(7*w)/100, y+(3*h)/4);
			g2d.drawLine(x, y+h, x+w/4, y+(93*h)/100);
		}
		else{

			int ax[] = {x, x+(7*w)/100, x+w/4, x};
			int ay[] = {y+h, y+(3*h)/4, y+(93*h)/100, y+h};
			g.fillOval(x, y, w, h);
			g.fillPolygon(ax, ay, 4);			
		}
	}

	public String getName() {
        return "WBCallOut";
    }
}
