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

class WBArrow extends WBShape{

    int type;

    WBArrow(int x, int y, int w, int h, int type, Color col, boolean draw){
        super(x, y, w, h, col, draw);
        this.type = type;
    }

    WBArrow(WBArrow wbs) {
        super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
        this.type = wbs.type;
    }
	
	public String toXml(){ 
		String xml = "<WBArrow>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<type>" + type + "</type>";
		xml += "</WBArrow>";
		return xml;
	}

    public void draw(Graphics g){
        if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

        g.setColor(col);
        if(draw) {
            switch(type){
                //Right Arrow
                case 1 :
                    int ax[] = {x+(w/2), x+w, x+(w/2), x+(w/2), x, x, x+(w/2)};
                    int ay[] = {y, y+(h/2), y+h, y+(3*h)/4, y+(3*h)/4, y+(h/4), y+(h/4)};
                    g.drawPolygon(ax, ay, 7);
                    break;
                    //Left Arrow
                case 2:
                    int ax1[] = {x+w/2, x+w/2, x+w, x+w, x+w/2, x+w/2, x};
                    int ay1[] = {y, y+h/4, y+h/4, y+(3*h)/4, y+(3*h)/4, y+h, y+h/2};
                    g.drawPolygon(ax1, ay1, 7);
                    break;
                    //Up Arrow
                case 3:
                    int ax2[] = {x+w/2, x+w, x+(3*w)/4, x+(3*w)/4, x+w/4, x+w/4, x};
                    int ay2[] = {y, y+h/2, y+h/2, y+h, y+h, y+h/2, y+h/2};
                    g.drawPolygon(ax2, ay2,7);
                    break;
                    //Down Arrow
                case 4:
                    int ax3[] = {x+w/4, x+(3*w)/4, x+(3*w)/4, x+w, x+w/2, x, x+w/4};
                    int ay3[] = {y, y, y+h/2, y+h/2, y+h, y+h/2, y+h/2};
                    g.drawPolygon(ax3, ay3, 7);
                    break;

                    //Left-Right Arrow
                case 5:
                    int ax4[] = {x+w/4, x+w/4, x+(3*w)/4, x+(3*w)/4, x+w, x+(3*w)/4, x+(3*w)/4, x+w/4, x+w/4, x};
                    int ay4[] = {y, y+h/4, y+h/4, y, y+h/2, y+h, y+(3*h)/4, y+(3*h)/4, y+h, y+h/2};
                    g.drawPolygon(ax4, ay4, 10);
                    break;

                    //Up-Down Arrow
                case 6:
                    int ax5[] = {x+w/2, x+w, x+(3*w)/4, x+(3*w)/4, x+w, x+w/2, x, x+w/4, x+w/4, x};
                    int ay5[] = {y, y+h/4, y+h/4, y+(3*h)/4, y+(3*h)/4, y+h, y+(3*h)/4, y+(3*h)/4, y+h/4, y+h/4};
                    g.drawPolygon(ax5, ay5, 10);
                    break;
                    /*case 7:
                      int ax6[] = {};*/
            }	
        }
        else{
            switch(type){
                case 1 :
                    int ax[] = {x+(w/2), x+w, x+(w/2), x+(w/2), x, x, x+(w/2)};
                    int ay[] = {y, y+(h/2), y+h, y+(3*h)/4, y+(3*h)/4, y+(h/4), y+(h/4)};
                    g.fillPolygon(ax, ay, 7);
                    break;
                case 2:
                    int ax1[] = {x+w/2, x+w/2, x+w, x+w, x+w/2, x+w/2, x};
                    int ay1[] = {y, y+h/4, y+h/4, y+(3*h)/4, y+(3*h)/4, y+h, y+h/2};
                    g.fillPolygon(ax1, ay1, 7);
                    break;
                case 3:
                    int ax2[] = {x+w/2, x+w, x+(3*w)/4, x+(3*w)/4, x+w/4, x+w/4, x};
                    int ay2[] = {y, y+h/2, y+h/2, y+h, y+h, y+h/2, y+h/2};
                    g.fillPolygon(ax2, ay2,7);
                    break;
                case 4:
                    int ax3[] = {x+w/4, x+(3*w)/4, x+(3*w)/4, x+w, x+w/2, x, x+w/4};
                    int ay3[] = {y, y, y+h/2, y+h/2, y+h, y+h/2, y+h/2};
                    g.fillPolygon(ax3, ay3, 7);
                    break;
                case 5:
                    int ax4[] = {x+w/4, x+w/4, x+(3*w)/4, x+(3*w)/4, x+w, x+(3*w)/4, x+(3*w)/4, x+w/4, x+w/4, x};
                    int ay4[] = {y, y+h/4, y+h/4, y, y+h/2, y+h, y+(3*h)/4, y+(3*h)/4, y+h, y+h/2};
                    g.fillPolygon(ax4, ay4, 10);
                    break;
                case 6:
                    int ax5[] = {x+w/2, x+w, x+(3*w)/4, x+(3*w)/4, x+w, x+w/2, x, x+w/4, x+w/4, x};
                    int ay5[] = {y, y+h/4, y+h/4, y+(3*h)/4, y+(3*h)/4, y+h, y+(3*h)/4, y+(3*h)/4, y+h/4, y+h/4};
                    g.fillPolygon(ax5, ay5, 10);
                    break;
            }	

        }
    }
    public String getName() {
        return "WBArrow";
    }
}
