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

class WBLineGraph extends WBShape{
	String s;
	int max = 0;
	int hp, bw;
	int items;
	int maxBH = 0;
	int no;
	
    int xInc;
	int HPro;

    Color col;
	public WBLineGraph (int x, int y, int w, int h, Color col, String s){
		super(x, y, w, h,col, true);
		this.s   = s;
	    this.col = col;
		
	}
	public void draw(Graphics g) {

		String values[] = s.split("\\s");
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x, y+h);
		g.drawLine(x, y+h, x+w, y+h);

		int dx = x; 
		for (int i=0;i<values.length ;i++)		{
			int next = Integer.parseInt((String)values[i]);
			if(max<next) max = next; 
		}

		System.out.println(""+max);

		if(max<=100)       { maxBH = ((max/10)+1);}
		if(max<=1000)      { maxBH = ((max/100)+1);}
		if(max<=10000)     { maxBH = ((max/1000)+1);}

		hp = h/(maxBH);
		bw = w/(values.length);

		for (int i=0;i<values.length ;i++)		{
			int next = Integer.parseInt((String)values[i]);
		 g.setColor(col);
		 g.fillOval(x+((2*i)+1)*w/(2*values.length), (y+h)-((next*hp)/max), 5, 5);

		 g.setColor(Color.BLACK);
		 g.fillOval(x+((i+1)*w)/(values.length), y+w-2, 4, 4);
		}				
	}		
}
