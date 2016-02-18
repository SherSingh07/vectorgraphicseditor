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

class WBSpray extends WBShape{

	WBSpray(int x, int y, int w, int h, Color col, boolean draw){
		super(x, y, w, h, col, draw);
	}

	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);
		if(draw){
			for(int i=x; i<=x+w-5; i=i+3){
				for(int j=y; j<=y+h-5; j=j+3){ g.fillOval(i, j , 1, 1);}
			}
		}
		else{
			for(int i=x; i<=x+w-5; i=i+3){
				for(int j=y; j<=y+h-5; j=j+3){ g.fillOval(i, j , 2, 2);}
			}		
		}
	}
}
