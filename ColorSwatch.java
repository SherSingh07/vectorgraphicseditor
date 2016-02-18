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

class ColorSwatch extends Panel implements MouseListener{
	int count =0, count1 = 0;
	int rows, cols, width, height;
	Label lbl;
	Color c1;
	Color c[][] = {{new Color(0,0,0), new Color(0, 51, 0), new Color(0, 102, 0), new Color(0, 153, 0), new Color(0, 204, 0), new Color(0, 255, 0), new Color(0,0,255), new Color(0,0,204), new Color(0,0,153), new Color(0,0,102), new Color(0,0,51)}, 
				   {new Color(51,0,0), new Color(51, 51, 0), new Color(51, 102, 0), new Color(51, 153, 0), new Color(51, 204, 0), new Color(51, 255, 0), new Color(51,0,255), new Color(51,0, 204), new Color(51,0,153), new Color(51,0,102), new Color(51,0,51)},
				   {new Color(102,0,0), new Color(102, 51, 0), new Color(102, 102, 0), new Color(102, 153, 0), new Color(102, 204, 0), new Color(102, 255, 0), new Color(102,0,255), new Color(102,0,204), new Color(102, 0, 153), new Color(102, 0, 102), new Color(102,0,51)},
				   {new Color(153,0,0), new Color(153, 51, 0), new Color(153, 102, 0), new Color(153, 153, 0), new Color(153, 204, 0), new Color(153, 255, 0), new Color(153,0,255), new Color(153, 0,204), new Color(153,0,153), new Color(153,0,102), new Color(153,0,51)},
				   {new Color(204,0,0), new Color(204, 51, 0), new Color(204, 102, 0), new Color(204, 153, 0), new Color(204, 204, 0), new Color(204, 255, 0), new Color(204,0,255), new Color(204,0,204), new Color(204,0,153), new Color(204,0,102), new Color(204,0,51)},
				   {new Color(255,0,0), new Color(255, 51, 0), new Color(255, 102, 0), new Color(255, 153, 0), new Color(255, 204, 0), new Color(255, 255, 0), new Color(255,0,255), new Color(255,0,204), new Color(255,0,153), new Color(255,0,102), new Color(255,0,51)},
				   {new Color(255, 0,51), new Color(255, 51, 51), new Color(255, 102, 51), new Color(255, 153, 51), new Color(255, 204, 51), new Color(255, 255,51), new Color(255,51,255), new Color(255,51,204), new Color(255,51,153), new Color(255,51,102), new Color(255,51,51)},
				   {new Color(204, 0,51), new Color(204, 51, 51), new Color(204, 102, 51), new Color(204, 153, 51), new Color(204, 204, 51), new Color(204, 255,51),new Color(204, 51, 255), new Color(204, 51, 204), new Color(204,51,153), new Color(204,51,102), new Color(204,51,51)},
			       {new Color(255, 0, 102), new Color(255, 51, 102), new Color(255, 102, 102), new Color(255, 153, 102), new Color(255, 204, 102), new Color(255, 255, 102), new Color(255, 102,255), new Color(255, 102,204), new Color(255, 102, 153), new Color(255, 102, 102), new Color(255, 102, 51)},
		           {new Color(204, 0, 102), new Color(204, 51, 102), new Color(204, 102, 102), new Color(204, 153, 102), new Color(204, 204, 102), new Color(204, 255, 102), new Color(204, 102,255), new Color(204, 102,204), new Color(204, 102,153), new Color(204, 102,102),new Color(204, 102, 51)},
				   {new Color(255, 0, 153), new Color(255, 51, 153), new Color(255, 102, 153), new Color(255, 153, 153), new Color(255, 204, 153), new Color(255, 255, 153), new Color(255, 153, 255), new Color(255, 153,204), new Color(255, 153,153), new Color(255, 153,102), new Color(255, 153, 51)},
		           {new Color(204, 0, 153), new Color(204, 51, 153), new Color(204, 102, 153), new Color(204, 153, 153), new Color(204, 204, 153), new Color(204, 255, 153), new Color(204, 153, 255), new Color(204, 153, 204), new Color(204, 153, 153), new Color(204, 153, 102), new Color(204, 153, 51)},
		           {new Color(255, 0, 204), new Color(255, 51, 204), new Color(255, 102, 204), new Color(255, 153, 204), new Color(255, 204, 204), new Color(255, 255, 204), new Color(255, 204, 255), new Color(255, 204, 204), new Color(255, 204, 153), new Color(255, 204, 102), new Color(255, 204, 51)},
				   {new Color(204, 0, 204), new Color(204, 51, 204), new Color(204, 102, 204), new Color(204, 153, 204), new Color(204, 204, 204), new Color(204, 255, 204), new Color(204, 204, 255), new Color(204, 204, 204), new Color(204, 204, 153), new Color(204, 204, 102), new Color(204, 204, 51)},
		           {new Color(255, 0, 255), new Color(255, 51, 255), new Color(255, 102, 255), new Color(255, 153, 255), new Color(255, 204, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 204), new Color(255, 255, 153), new Color(255, 255, 102), new Color(255, 255, 51)},	          
				   {new Color(204, 0, 204), new Color(204, 51, 255), new Color(204, 102, 255), new Color(204, 153, 255), new Color(204, 204, 255), new Color(204, 255, 255), new Color(204, 255, 255), new Color(204, 255, 204), new Color(204, 255, 153), new Color(204, 255, 102), new Color(204, 255, 51)}	          
	};

	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	
	public void mouseClicked(MouseEvent me) {
		int xpos, ypos, cX=0, cY=0;
		xpos = me.getX();
		ypos = me.getY();
		int incX = width/cols;
		int incY = height/rows;
		for(int i=0; i<cols; i++){
			for(int j=0; j<rows; j++){
				if(xpos<cX && ypos<cY){
					c1 = c[i][j];
				}
				cX = cX+incX;				
			}
			cY = cY+incY;
		}		
		repaint();
	}
	public void mouseReleased(MouseEvent me) {}
	
		
	public 	ColorSwatch(VegEdit ve, int cols, int rows, int width, int height)	{
		setLayout(null);
	  this.rows   = rows;
	  this.cols   = cols;
	  this.width  = width;
	  this.height = height;  
	  
	  lbl = new Label();
	  lbl.setBounds(200, 0, 50, 50);
	  add(lbl);
	  addMouseListener(this);
	  setVisible(true);
	  setSize(160,110);
	}

	public void paint(Graphics g){
		lbl.setBackground(c1);
		for(int l=0; l<cols; l++){
			for(int m=0; m<rows; m++){
				g.setColor(c[l][m]);
				g.fillRect(l*(width/cols), m*(height/rows), width/cols, height/rows);
				g.setColor(Color.BLACK);
				g.drawRect(l*(width/cols), m*(height/rows), width/cols, height/rows);
				count++;
			}
		}
    }

	/*public static void main(String[] args) 
	{   
		ColorSwatch cs = new ColorSwatch(16,11,160,110);
	    Frame f = new Frame("abc");
		f.setLayout(new FlowLayout());
		f.add(cs);
		f.setVisible(true);
		f.setSize(600, 600);
	
	}*/
}
