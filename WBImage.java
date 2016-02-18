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

class WBImage extends WBShape{

    Image img;
    WBImage(int x, int y, int w, int h, Color col, String imgPath){
        super(x, y, w, h, col, true);
        img = Toolkit.getDefaultToolkit().getImage(imgPath);
        //img = Toolkit.getDefaultToolkit().getImage("images/icons/512x512/hat.png");
    }

	WBImage(WBImage wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, true);
		this.img = wbs.img;
	}

	public String toXml(){ 
		String xml = "<WBImage>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<img>" + img + "</img>";
		xml += "</WBImage>";
		return xml;
	}


    public void draw(Graphics g){
        g.setColor(col);
        if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

        g.drawImage(img, x, y, w, h, null);
    }

	public String getName() {
        return "WBImage";
    }
}
