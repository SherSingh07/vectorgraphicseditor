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

public class BasicTools extends Tools implements ActionListener{
    VegEdit VE;
	JButton btnRect;
	JButton btnFRect;
	JButton btnOval;
	JButton btnFOval;
	JButton btnRoundRect;
	JButton btnFRoundRect;
	JButton btnLine;
	JButton btnText;
	JButton btnPicture;
	JButton btnTarget;
	JButton btnHScroll;
	JButton btnVScroll;
	JButton btnTriangle;
	JButton btnFTriangle;
	JButton btnFRhombus;
	JButton btnERhombus;
	JButton btnPentagon;
	JButton btnFPentagon;
	JButton btnHexagon;
	JButton btnFHexagon;
	JButton btnOctagon;
	JButton btnFOctagon;
	JButton btnFHeart;
	JButton btnHeart;
	JButton btnStar;
	JButton btnFStar;
	JButton btnMoon;
	JButton btnCall;
	JButton btnFCall;
	JButton btnFCross;
	JButton btnSpiral;
	JButton btnCancel;

    public BasicTools(VegEdit VE) {
        super(VE);
        this.VE=VE;

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(12, 4));
        //Rectangle
        btnRect = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/rectangle.png")));
        btnRect.setToolTipText("Draw Rectangle");
        btnRect.setActionCommand(Config.CMD_DRAW_RECTANGLE);
        btnRect.addActionListener(this);
        btnRect.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnRect);

        //FillRectangle
        btnFRect = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_rect.png")));
        btnFRect.setToolTipText("Fill Rectangle");
        btnFRect.setActionCommand(Config.CMD_FILL_RECTANGLE);
        btnFRect.addActionListener(this);
        btnFRect.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFRect);

        //Oval
        btnOval = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/oval1.png")));
        btnOval.setToolTipText("Draw Oval/Circle");
        btnOval.setActionCommand(Config.CMD_DRAW_OVAL);
        btnOval.addActionListener(this);
        btnOval.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnOval);

		//Fills Oval
        btnFOval = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_oval.png")));
        btnFOval.setToolTipText("Fills Oval/Circle");
        btnFOval.setActionCommand(Config.CMD_FILL_OVAL);
        btnFOval.addActionListener(this);
        btnFOval.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFOval);

		//Round Rect
        btnRoundRect = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/roundrect.png")));
        btnRoundRect.setToolTipText("Draw Round Rectangle");
        btnRoundRect.setActionCommand(Config.CMD_DRAW_ROUND_RECT);
        btnRoundRect.addActionListener(this);
        btnRoundRect.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnRoundRect);

		//Fills Round Rect
        btnFRoundRect = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_round_rect.png")));
        btnFRoundRect.setToolTipText("Fill Round Rectangle");
        btnFRoundRect.setActionCommand(Config.CMD_FILL_ROUND_RECT);
        btnFRoundRect.addActionListener(this);
		btnFRoundRect.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFRoundRect);
		
        //Line
        btnLine = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/line.png")));
        btnLine.setToolTipText("Draw Line");
        btnLine.setActionCommand(Config.CMD_DRAW_LINE);
        btnLine.addActionListener(this);
        btnLine.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnLine);

		//Horizontal Scroll
        btnHScroll = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/scroll.png")));
        btnHScroll.setToolTipText("Draw Horizontal Scroll");
        btnHScroll.setActionCommand(Config.CMD_DRAW_HSCROLL);
        btnHScroll.addActionListener(this);
        btnHScroll.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHScroll);
		
		//Vertical Scroll
        btnVScroll = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/vertical_scroll.png")));
        btnVScroll.setToolTipText("Draw Vertical Scroll");
        btnVScroll.setActionCommand(Config.CMD_DRAW_VSCROLL);
        btnVScroll.addActionListener(this);
        btnVScroll.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnVScroll);

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
        panel.add(btnFRhombus);

        //Draw Pentagon
        btnPentagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/pentagon.png")));
        btnPentagon.setToolTipText("Draw Pentagon");
        btnPentagon.setActionCommand(Config.CMD_DRAW_PENTAGON);
        btnPentagon.addActionListener(this);
		btnPentagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnPentagon);

		//Fills Pentagon
        btnFPentagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_penta.png")));
        btnFPentagon.setToolTipText("Fills Pentagon");
        btnFPentagon.setActionCommand(Config.CMD_FILL_PENTAGON);
        btnFPentagon.addActionListener(this);
		btnFPentagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFPentagon);

        //Hexagon
        btnHexagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hexagon.png")));
        btnHexagon.setToolTipText("Draw Hexagon");
		btnHexagon.setActionCommand(Config.CMD_DRAW_HEXAGON);
        btnHexagon.addActionListener(this);
		btnHexagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHexagon);

        //Fills Hexagon
        btnFHexagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_hex.png")));
        btnFHexagon.setToolTipText("Fills Hexagon");
        btnFHexagon.setActionCommand(Config.CMD_FILL_HEXAGON);
        btnFHexagon.addActionListener(this);
		btnFHexagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFHexagon);

        //Octagon
        btnOctagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/octagon.png")));
        btnOctagon.setToolTipText("Draw Octagon");
        btnOctagon.setActionCommand(Config.CMD_DRAW_OCTAGON);
        btnOctagon.addActionListener(this);
		btnOctagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnOctagon);

        //Fills Octagon
        btnFOctagon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_octa.png")));
        btnFOctagon.setToolTipText("Fills Octagon");
        btnFOctagon.setActionCommand(Config.CMD_FILL_OCTAGON);
        btnFOctagon.addActionListener(this);
		btnFOctagon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFOctagon);

        //Heart
        btnHeart = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Heart.png")));
        btnHeart.setToolTipText("Draw Heart Sign");
        btnHeart.setActionCommand(Config.CMD_DRAW_HEART);
        btnHeart.addActionListener(this);
		btnHeart.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHeart);

        //Fill Heart
        btnFHeart = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_heart.png")));
        btnFHeart.setToolTipText("Fills Heart");
        btnFHeart.setActionCommand(Config.CMD_FILL_HEART);
        btnFHeart.addActionListener(this);
		btnFHeart.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFHeart);

        //Star
        btnStar = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/star.png")));
        btnStar.setToolTipText("Draw Star");
        btnStar.setActionCommand(Config.CMD_DRAW_STAR);
        btnStar.addActionListener(this);
		btnStar.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnStar);

        //Fills Star
        btnFStar = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_star.png")));
        btnFStar.setToolTipText("Fills Star");
        btnFStar.setActionCommand(Config.CMD_FILL_STAR);
        btnFStar.addActionListener(this);
		btnFStar.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFStar);

        //Moon
        btnMoon = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/moon.png")));
        btnMoon.setToolTipText("Draw Moon");
        btnMoon.setActionCommand(Config.CMD_DRAW_MOON);
        btnMoon.addActionListener(this);
        btnMoon.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnMoon);

        //CallOut
        btnCall = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/call.png")));
        btnCall.setToolTipText("Draw Oval CallOut");
        btnCall.setActionCommand(Config.CMD_DRAW_CALL);
        btnCall.addActionListener(this);
		btnCall.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnCall);
        
        //Fills CallOut
        btnFCall = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_call.png")));
        btnFCall.setToolTipText("Fills Oval CallOut");
        btnFCall.setActionCommand(Config.CMD_FILL_CALL);
        btnFCall.addActionListener(this);
		btnFCall.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFCall);
        
        //Fills Cross
        btnFCross = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_cross.png")));
        btnFCross.setToolTipText("Fills Cross Sign");
        btnFCross.setActionCommand(Config.CMD_FILL_CROSS);
        btnFCross.addActionListener(this);
		btnFCross.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFCross);
        
        // Spiral
        btnSpiral = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/spiral.png")));
        btnSpiral.setToolTipText("Draw Spiral");
        btnSpiral.setActionCommand(Config.CMD_DRAW_SPIRAL);
        btnSpiral.addActionListener(this);
        btnSpiral.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSpiral);

        // Target
        btnTarget = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Target.png")));
        btnTarget.setToolTipText("Draw Target");
        btnTarget.setActionCommand(Config.CMD_DRAW_TARGET);
        btnTarget.addActionListener(this);
		btnTarget.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnTarget);
        
        //Picture
        btnPicture = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/picture.png")));
        btnPicture.setToolTipText("Import Picture");
		btnPicture.setActionCommand(Config.CMD_DRAW_PICTURE);
        btnPicture.addActionListener(this);
        btnPicture.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnPicture);

        /*Text
        btnText = new JButton("A");
        btnText.setToolTipText("Draw Text...");
        btnText.setActionCommand(Config.CMD_DRAW_TEXT);
        btnText.addActionListener(this);
		btnText.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnText);*/


        getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(250, 150);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        if(ae.getActionCommand() == Config.CMD_DRAW_PICTURE) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(VE);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String imgPath = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName();
                System.out.println("Adding Picture : " + imgPath);
                DrawingPanel.getInstance().addPicture(imgPath);
            }

        }
        else {
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
        }
    }
}
