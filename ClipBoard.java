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
import javax.swing.*;

class ClipBoard extends JPanel 
{
	WBShape copiedShape = null;

	private ClipBoard(){
	 setVisible(true);
	 setSize(100, 100);
	}

	public void setShape(WBShape wbs){
		copiedShape = WBShape.clone(wbs);
        copiedShape.setXY(0, 0);
		copiedShape.setWH(100, 100);
		repaint();
	}

	private static ClipBoard  _instance = new ClipBoard();

	public static ClipBoard getInstance() { return _instance; } 


	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawRect(0, 0, 100, 100);
		if(copiedShape == null) return;
		copiedShape.draw(g);
	}


	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
