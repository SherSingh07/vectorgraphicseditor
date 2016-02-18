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
import java.awt.event.*;
import java.awt.*;
import javax.swing.filechooser.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class Smileys extends Tools implements ActionListener{

    private VegEdit VE;

	JButton btnHappy;
	JButton btnSmile;
	JButton btnConfused;
	JButton btnScared;
	JButton btnMad;
	JButton btnYingYang;
	JButton btnSad;
	JButton btnGrin;
	JButton btnRedFace;
	JButton btnEvilGrin;
	JButton btnWaii;
	JButton btnSurprised;
	JButton btnCool;
	JButton btnCry;
	JButton btnFat;
	JButton btnRoll;
	JButton btnYell;
	JButton btnSlim;
	JButton btnEek;
	JButton btnTongue;
	JButton btnWink;

    public Smileys(VegEdit VE) {
        super(VE);
        JPanel panel = new JPanel();
		
        this.VE=VE;
        
		btnHappy     = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/happy.png")));
		btnHappy.setToolTipText("Happy");	
		btnHappy.setActionCommand(Config.CMD_SMILEY_HAPPY);
		btnHappy.addActionListener(this);
		btnHappy.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHappy);
	    
		btnSmile     = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/smile.png")));
		btnSmile.setToolTipText("Smile");
		btnSmile.setActionCommand(Config.CMD_SMILEY_SMILE);
		btnSmile.addActionListener(this);
		btnSmile.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSmile);
	    
		btnWink      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wink.png")));
		btnWink.setToolTipText("Wink");
		btnWink.setActionCommand(Config.CMD_SMILEY_WINK);
		btnWink.addActionListener(this);
        btnWink.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWink);
	    
		btnConfused  = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/confuse.png")));
	    btnConfused.setToolTipText("Confused");
		btnConfused.setActionCommand(Config.CMD_SMILEY_CONFUSED);
		btnConfused.addActionListener(this);
		btnConfused.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnConfused);
	     
		btnSad       = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/sad.png")));
	    btnSad.setToolTipText("Sad");
		btnSad.setActionCommand(Config.CMD_SMILEY_SAD);
		btnSad.addActionListener(this);
		btnSad.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSad);
	    
		btnScared    = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/scared.png")));
		btnScared.setToolTipText("Scared");
	    //btnScared.setActionCommand(Config.CMD_SMILEY_SCARED);
		btnScared.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnScared);
	    
		btnMad       = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/mad.png")));
	    btnMad.setToolTipText("Mad");
		//btnMad.setActionCommand(Config.CMD_SMILEY_MAD);
		btnMad.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnMad);
	    
		btnYingYang  = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/yingyang.png")));
	    btnYingYang.setToolTipText("YingYang");
		btnYingYang.setActionCommand(Config.CMD_SMILEY_YINGYANG);
		btnYingYang.addActionListener(this);
		btnYingYang.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnYingYang);
	    
		btnGrin      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/grin.png")));
	    btnGrin.setToolTipText("Grin");
		//btnGrin.setActionCommand(Config.CMD_SMILEY_GRIN);
		btnGrin.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnGrin);
	    
		btnRedFace   = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/redface.png")));
	    btnRedFace.setToolTipText("RedFace");
		//btnRedFace.setActionCommand(Config.CMD_SMILEY_REDFACE);
		btnRedFace.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnRedFace);
	    
		btnEvilGrin  = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/evilgrin.png")));
		btnEvilGrin.setToolTipText("EvilGrin");
	    btnEvilGrin.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnEvilGrin);
	    
		btnWaii      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/waii.png")));
		btnWaii.setToolTipText("Waii");
	    btnWaii.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWaii);
	    
		btnSurprised = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/surprised.png")));
		btnSurprised.setToolTipText("Surprised");
	    btnSurprised.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSurprised);
	    
		btnCool      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/cool.png")));
		btnCool.setToolTipText("Cool");
	    btnCool.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnCool);
	    
		btnCry       = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/cry.png")));
		btnCry.setToolTipText("Cry");
	    btnCry.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnCry);
	    
		btnFat       = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fat.png")));
		btnFat.setToolTipText("Fat");
		btnFat.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnFat);
	    
		btnRoll      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/roll.png")));
		btnRoll.setToolTipText("Roll");
		btnRoll.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnRoll);
	    
		btnYell      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/yell.png")));
		btnYell.setToolTipText("Yell");
		btnYell.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnYell);
	    
		btnSlim      = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/slim.png")));
		btnSlim.setToolTipText("Slim");
	    btnSlim.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSlim);
	    
		btnEek       = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/eek.png")));
		btnEek.setToolTipText("Eek");
	    btnEek.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnEek);
	    
		btnTongue    = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/tongue.png")));
		btnTongue.setToolTipText("Tongue");
		btnTongue.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnTongue);

		getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(200, 100);
	
	}
    
   public void actionPerformed(ActionEvent ae) {
        setVisible(false);
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
        
    }
}//Smileys
