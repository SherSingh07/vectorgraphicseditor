/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * WBString.java is the java file for writing the Text on Drawing Area.
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

class WBString extends WBShape{
    String text;
	String name;
    int    size;
	int style;
    WBString(int x, int y, int w, int h, String text, String name, int style, int size, Color col){
        super(x, y, w, h, col, true);
        this.text = text;
        this.size = size;
		this.style = style;
		this.name = name;
    }

	public String toXml(){ 
		String xml = "<WBString>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<text>" + text + "</text>";
        xml += "<name>" + name + "</name>";
        xml += "<style>" + style + "</style>";
		xml += "<size>" + size + "</size>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "</WBString>";
		return xml;
	}


    public void draw(Graphics g){
        Font font = new Font(name, style, size);
        g.setFont(font);
        g.setColor(col);
        g.drawString(text, x, y);
    }
}
