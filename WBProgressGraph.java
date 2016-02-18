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

class WBProgressGraph extends WBShape{
	String s;
	int max = 0;
	int hp, bw;
	int items;
	int maxBH = 0;
	int no;
	int New=0;
	int sum = 0;
	
    int xInc;
	int HPro;

    Color col;
	public WBProgressGraph (int x, int y, int w, int h, Color col, String s){
		super(x, y, w, h,col, true);
		this.s   = s;
	    //this.col = col;
		
	}
	public void draw(Graphics g) {

		String values[] = s.split("\\s");
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x, y+h);
		g.drawLine(x, y+h, x+w, y+h);

		int dx = x; 
		for (int i=0;i<values.length ;i++)		{
			int next = Integer.parseInt((String)values[i]);
			sum = sum + next; 
		}

		System.out.println(""+sum);

		if(sum<=100)       { maxBH = ((sum/10)+1);}
		if(sum<=1000)      { maxBH = ((sum/100)+1);}
		if(sum<=10000)     { maxBH = ((sum/1000)+1);}

		hp = h/(maxBH);
		bw = w/(values.length);

		for (int i=0;i<values.length ;i++)		{
			int previous = Integer.parseInt((String)values[i]);
			
			New = New + previous;
			
			g.setColor(Color.RED);
			g.fillOval(x+((2*i)+1)*w/(2*values.length), (y+h)-((New*hp)/sum), 5, 5);
			
		    g.setColor(Color.BLACK);
		    g.fillOval(x+((i+1)*w)/(values.length), y+w-2, 4, 4);	
		}				
	}		
}
