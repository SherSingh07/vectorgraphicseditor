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
 * Description     :   This draws symbol for prohibited, a circle with slash in it.
 * Author          :   Shikha Singla, singla.shikha24@gmail.com
 * Project Manager :   Navjot Singh, weavebytes@gmail.com
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
class  WBNo extends WBShape {

    public WBNo (int x, int y, int w, int h, Color col, boolean draw){
        super(x, y, w, h, col, draw);
    }

    public String toXml(){ 
        String xml = "<WBNo>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
        xml += "<draw>" + draw + "</draw>";
        xml += "</WBNo>";
        return xml;
    }

    public void draw(Graphics g){
        g.setColor(col);
        if(draw){
            g.drawOval(x, y, w, h);
            g.drawArc(x+(w)/4, y+h/8, (3*w)/4, (3*h)/4, 330, 180);
            g.drawArc(x+w/8, y+h/4, (3*w)/4, (3*h)/4, 150, 180);
            //g.drawLine(x, y+h, x+w/4, y+h);
            //g.drawLine(x+(3*w)/4, y+h, x+w, y+h);
        }

        else{
            //g.fillArc(x, y, w, 2*h, 0, 180);
            //g.clearArc(x+w/4, y+h/2, w/2, h, 0, 180);

        }
    }

}
