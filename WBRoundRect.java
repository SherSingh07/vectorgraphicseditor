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

class WBRoundRect extends WBShape{
	int rw, rh;
	int size;

	WBRoundRect(int x, int y, int w, int h, int rw, int rh,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.rw = rw;
		this.rh = rh;
		this.size = size;
	}

	WBRoundRect(WBRoundRect wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.rw = wbs.rw;
		this.rh = wbs.rh;
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBRoundRect>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<rw>" + rw + "</rw>";
		xml += "<size>" + size + "</size>";
		xml += "</WBRoundRect>";
		return xml;
	}

	public void draw(Graphics g){
		g.setColor(col);
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(draw)        { g2d.drawRoundRect(x, y, w, h, rw, rh);}
		else  { g.fillRoundRect(x, y, w, h, rw, rh);}
	}
	public String getName() {
        return "WBRoundRect";
    }
}
