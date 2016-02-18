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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ColorLabel extends JLabel implements MouseListener, MouseMotionListener {
    Color col;
    Color col1 = Color.LIGHT_GRAY;

    public void mouseEntered(MouseEvent me) {
        System.out.println("Mouse Entered");
        col1 = new Color(100, 20, 15);
        repaint();
    }

    public void mouseExited(MouseEvent me)  {
        System.out.println("Mouse Exited");
        col1 = Color.LIGHT_GRAY;
        repaint();
    }

    public void mousePressed(MouseEvent me) {
        DrawEnv.getInstance().setForeground(col);
    }
    public void mouseClicked(MouseEvent me) {}
    public void mouseReleased(MouseEvent me){}
    public void mouseDragged(MouseEvent e)  {}

    public void mouseMoved(MouseEvent e) { }

    ColorLabel(Color col) {
        this.col = col;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paint(Graphics g) {
        g.setColor(col);
        g.fillRect(1, 1, getWidth()-2, getHeight()-2);
        g.setColor(col1);
        g.drawRect(1, 1, getWidth()-2, getHeight()-2);
        g.setColor(Color.WHITE);
        g.drawRect(2, 2, getWidth()-4, getHeight()-4);
    }
}

class ColorPanel extends JPanel 
{	
	ColorLabel lbl1;
	ColorLabel lbl2;
	ColorLabel lbl3;
	ColorLabel lbl4;
	ColorLabel lbl5;
	ColorLabel lbl6;
	ColorLabel lbl7;
	ColorLabel lbl8;
	ColorLabel lbl9;
	ColorLabel lbl10;
	ColorLabel lbl11;
	ColorLabel lbl12;
	ColorLabel lbl13;
	ColorLabel lbl14;
	ColorLabel lbl15;
	ColorLabel lbl16;
	ColorLabel lbl17;
	ColorLabel lbl18;
	ColorLabel lbl19;
	ColorLabel lbl20;
	ColorLabel lblColor1;
	ColorLabel lblColor2;
	ColorPanel(){
		super();
		setLayout(new GridLayout(2,10));
	
		lbl1 = new ColorLabel(Color.BLACK);
		add(lbl1);

		lbl2 = new ColorLabel(new Color(127, 127, 127));
		add(lbl2);

		lbl3 = new ColorLabel(new Color(136, 0, 21));
		add(lbl3);

		lbl4 = new ColorLabel(new Color(237, 28, 36));
		add(lbl4);

		lbl5 = new ColorLabel(new Color(255, 127, 39));
		add(lbl5);
		
		lbl6 = new ColorLabel(new Color(255, 242, 0));
		add(lbl6);
		
		lbl7 = new ColorLabel(new Color(34, 177, 76));
		add(lbl7);

		lbl8 = new ColorLabel(new Color(0, 162, 232));
		add(lbl8);

		lbl9 = new ColorLabel(new Color(63, 72, 204));
		add(lbl9);

		lbl10 = new ColorLabel(new Color(163, 73, 163));
		add(lbl10);

		lbl11 = new ColorLabel(Color.WHITE);
		add(lbl11);

		lbl12 = new ColorLabel(new Color(195, 195, 195));
		add(lbl12);

		lbl13 = new ColorLabel(new Color(185, 120, 90));
		add(lbl13);

		lbl14 = new ColorLabel(new Color(255, 175, 200));
		add(lbl14);

		lbl15 = new ColorLabel(new Color(255, 200, 15));
		add(lbl15);

		lbl16 = new ColorLabel(new Color(239, 228, 136));
		add(lbl16);

		lbl17 = new ColorLabel(new Color(181, 230, 29));
		add(lbl17);

		lbl18 = new ColorLabel(new Color(157, 215, 234));
		add(lbl18);

		lbl19 = new ColorLabel(new Color(112, 146, 190));
		add(lbl19);

		lbl20 = new ColorLabel(new Color(200, 190, 230));
		add(lbl20);	
		
		setVisible(true);
		setSize(150,30);
	}

	public static void main(String[] args) 
	{   
		ColorPanel cs = new ColorPanel();
	    JFrame f = new JFrame("abc");
		f.setLayout(null);
		cs.setBounds(100, 100, 200, 40);
		f.add(cs);
		f.setVisible(true);
		f.setSize(600, 600);
	
	}
}
