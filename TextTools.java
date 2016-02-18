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

public class TextTools extends Tools implements ActionListener{
	VegEdit VE;
	JButton btnOk;
	JButton btnCancel;

	   TextTools(VegEdit VE){
		super(VE);
		this.VE = VE;
		
		JPanel panel = new JPanel();
        
	    panel.add(new JLabel("Font:"));
	    panel.add(DrawEnv.getInstance().getFontName());
        panel.add(new JLabel("Size:"));
        panel.add(DrawEnv.getInstance().getFontList());
	    panel.add(new JLabel("Font Style:"));
	    panel.add(DrawEnv.getInstance().getFontType());
        panel.add(new JLabel("                                  "));
        panel.add(new JLabel("Enter Text Here:"));
        panel.add(TextContainer.getInstance().getTextField());
		
		btnOk = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/yes.png")));
		btnOk.setToolTipText("Draw");
		btnOk.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		btnOk.addActionListener(this);
        btnOk.setActionCommand(Config.CMD_DRAW_TEXT);
        panel.add(btnOk);
		
		btnCancel = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/no.png")));
		btnCancel.setToolTipText("Cancel");
		btnCancel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		btnCancel.addActionListener(this);
        panel.add(btnCancel);
		
		getContentPane().add(panel, "Center");

		setUndecorated(true);
        setSize(370, 150);
	  
	  }

	  public void actionPerformed(ActionEvent ae) {
			setVisible(false);
            if(ae.getActionCommand() == Config.CMD_DRAW_TEXT){
			DrawingPanel.getInstance().setOperation(ae.getActionCommand());}
		
			
		}
        
  }