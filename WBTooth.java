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

class WBTooth extends WBShape{
	int size;

    WBTooth(int x, int y, int w, int h,int size, Color col){
        super(x, y, w, h, col, true);
		this.size = size;
    }

	WBTooth(WBTooth wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, true);
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBTooth>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<size>" + size + "</size>";
		xml += "</WBTooth>";
		return xml;
	}


    public void draw(Graphics g){
        g.setColor(col);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

        if(draw){
            if(w<0) { x = x + w; w = w * -1; }
            if(h<0) { y = y + h; h = h * -1; }
            g2d.drawArc(x, y, w/2, h/2, 50, 130);
            g2d.drawArc(x+w/3, y-h/4, w/3, h/3, 235, 75);
            g2d.drawArc(x+w/2, y, w/2, h/2, 0, 130);

            g2d.drawArc(x+w/8,y+(3*h)/4, w/4, h/4, 180, 180);
            g2d.drawArc(x+(5*w)/8,y+(3*h)/4, w/4, h/4, 180, 180);
            g2d.drawArc(x+(5*w)/12,y+(5*h)/8, w/6, h/4, 0, 180);
            g2d.drawLine(x+(3*w)/8, y+(7*h)/8, x+(5*w)/12, y+(3*h)/4);
            g2d.drawLine(x+(5*w)/8, y+(7*h)/8, x+(7*w)/12, y+(3*h)/4);
            g2d.drawLine(x+w/8, y+(7*h)/8, x, y+h/4);
            g2d.drawLine(x+(7*w)/8, y+(7*h)/8, x+w, y+h/4);	
		}
    }
	public String getName() {
        return "WBTooth";
    }
}
