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

class Tools extends JDialog{
	VegEdit VE;
	JPanel northPanel;
	JPanel southPanel;
	JPanel eastPanel;
	JPanel westPanel;
	
	Tools(VegEdit VE){
		super(VE, "", false);
		this.VE = VE;
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		eastPanel  = new JPanel();
		westPanel  = new JPanel();
	    Color  borCol     = new Color(200, 200, 200);


		northPanel.setBackground(borCol);
		southPanel.setBackground(borCol);
		eastPanel.setBackground(borCol);
		westPanel.setBackground(borCol);
        
		getContentPane().add(northPanel, "North");
        getContentPane().add(southPanel, "South");
        getContentPane().add(eastPanel, "East");
        getContentPane().add(westPanel, "West");
	}
	
}
