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
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.filechooser.*;

public class ArrowTools extends Tools implements ActionListener{
    VegEdit VE;
	JButton btnRight;
	JButton btnLeft;
	JButton btnUp;
	JButton btnDown;
	JButton btnDownLeft;
	JButton btnDownRight;
	JButton btnTopLeft;
	JButton btnTopRight;
	JButton btnLeftRight;
	JButton btnUpDown;
	
    public ArrowTools(VegEdit VE) {
        super(VE);
        this.VE=VE;

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(12, 4));
        //Right
        btnRight = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/arrow_right.png")));
        btnRight.setToolTipText("Right Arrow");
        btnRight.setActionCommand(Config.CMD_FILL_RIGHTARROW);
        btnRight.addActionListener(this);
        btnRight.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnRight);

        //Left
        btnLeft = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/arrow_left.png")));
        btnLeft.setToolTipText("Left Arrow");
        btnLeft.setActionCommand(Config.CMD_FILL_LEFTARROW);
        btnLeft.addActionListener(this);
        btnLeft.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnLeft);

        //Up
        btnUp = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/arrow_top.png")));
        btnUp.setToolTipText("Up Arrow");
        btnUp.setActionCommand(Config.CMD_FILL_UPARROW);
        btnUp.addActionListener(this);
        btnUp.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnUp);

		//Down
        btnDown = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/arrow_bottom.png")));
        btnDown.setToolTipText("Down Arrow");
        btnDown.setActionCommand(Config.CMD_FILL_DOWNARROW);
        btnDown.addActionListener(this);
        btnDown.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDown);

		//Left-Right
        btnLeftRight = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/left-right.png")));
        btnLeftRight.setToolTipText("Left-Right Arrow");
        btnLeftRight.setActionCommand(Config.CMD_FILL_LEFTRIGHTARROW);
        btnLeftRight.addActionListener(this);
        btnLeftRight.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnLeftRight);

		//Up-Down
        btnUpDown = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/up-down.png")));
        btnUpDown.setToolTipText("Up-Down Arrow");
        btnUpDown.setActionCommand(Config.CMD_FILL_UPDOWNARROW);
        btnUpDown.addActionListener(this);
		btnUpDown.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnUpDown);
		/*
        //Down-Left
        btnDownLeft = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/line.png")));
        btnDownLeft.setToolTipText("Down-Left Arrow");
        //btnDownLeft.setActionCommand(Config.CMD_FILL_DOWNLEFTARROW);
        //btnDownLeft.addActionListener(this);
        btnDownLeft.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDownLeft);*/

		/*//Scroll
        btnScroll = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/scroll.png")));
        btnScroll.setToolTipText("Draw A Scroll Figure");
        btnScroll.setActionCommand(Config.CMD_DRAW_SCROLL);
        btnScroll.addActionListener(this);
        btnScroll.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnScroll);

        //Triangle
        btnTriangle = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Triangle.png")));
        btnTriangle.setToolTipText("Draw Triangle");
        btnTriangle.setActionCommand(Config.CMD_DRAW_TRIANGLE);
        btnTriangle.addActionListener(this);
		btnTriangle.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnTriangle);

		//Fills Triangle
        btnFTriangle = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_tri.png")));
        btnFTriangle.setToolTipText("Fills Triangle");
        btnFTriangle.setActionCommand(Config.CMD_FILL_TRIANGLE);
        btnFTriangle.addActionListener(this);
		btnFTriangle.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFTriangle);

        //Fills Rhombus
        btnFRhombus = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_rhombus.png")));
        btnFRhombus.setToolTipText("Fills Rhombus");
        btnFRhombus.setActionCommand(Config.CMD_FILL_RHOMBUS);
        btnFRhombus.addActionListener(this);
		btnFRhombus.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFRhombus);*/


        getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(250, 50);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
    }
}
