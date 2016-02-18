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

class WBPieChart extends WBShape{
	String s;
	int sum = 0;
	int hp, bw;
	int items;
	int maxBH = 0;

	int previous = 0;
	
    int xInc;
	int HPro;

	public WBPieChart (int x, int y, int w, String s){
		super(x, y, w, w,Color.BLACK, true);
		this.s   = s;
	}

	public void draw(Graphics g) {
		String values[] = s.split("\\s");
		
		for (int i=0;i<values.length ;i++)		{
			int next = Integer.parseInt((String)values[i]);
			sum=sum+next;
		}	
		
		System.out.println(""+sum);
			
		for (int i=0;i<values.length ;i++)		{
			int next = Integer.parseInt((String)values[i]);
			
			int red   = (int)(Math.random()*255);
			int green = (int)(Math.random()*255);
			int blue  = (int)(Math.random()*255);

			Color col = new Color(red, green, blue);
			g.setColor(col);

			g.fillArc(x, y, w, w, (previous*360)/sum, (next*360)/sum);
			
			g.setColor(Color.BLACK);
			g.drawArc(x, y, w, w, (previous*360)/sum, (next*360)/sum);
			previous = previous+next;
		}
		g.drawOval(x, y ,w, w);
	}		
}
