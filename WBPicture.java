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
import java.awt.Toolkit;

class WBPicture extends WBShape {

    private Image img;
    WBPicture(int x, int y, String imgPath){
        super(x, y, 0, 0, Color.BLACK, false);
        this.img = Toolkit.getDefaultToolkit().getImage(imgPath);
    }

	WBPicture(WBPicture wbs){
		super(wbs.x, wbs.y, 0, 0, Color.BLACK, false);
		this.img = wbs.img;
	}

	public String toXml(){ 
		String xml = "<WBPicture>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<img>" + img + "</img>";
		xml += "</WBPicture>";
		return xml;
	}


    public void draw(Graphics g){
        g.drawImage(img, x, y, null);
    }
	public String getName() {
        return "WBPicture";
    }
}
