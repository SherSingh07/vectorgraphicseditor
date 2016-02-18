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

public class SaloonTools extends Tools implements ActionListener{
    VegEdit VE;
	JButton btnWig1;
	JButton btnWig2;
	JButton btnWig3;
	JButton btnWig4;
	JButton btnWig5;
	JButton btnWig6;
	JButton btnWig7;
	JButton btnWig8;
	JButton btnWig9;
	JButton btnWig10;
	JButton btnWig11;
	JButton btnWig12;
	JButton btnWig13;
	JButton btnWig14;
	JButton btnWig15;
	JButton btnWig16;
	JButton btnWig17;
	JButton btnWig18;
	JButton btnWig19;
	JButton btnWig20;
	JButton btnWig21;
	JButton btnWig22;
	JButton btnWig23;
	JButton btnWig24;
	JButton btnWig25;
	JButton btnWig26;
	JButton btnWig27;
	JButton btnWig28;
	JButton btnWig29;
	JButton btnWig30;
	JButton btnWig31;
	JButton btnWig32;
	JButton btnWig33;
	JButton btnWig34;
	JButton btnWig35;
	JButton btnWig36;
	JButton btnWig37;
	JButton btnWig38;
	JButton btnWig39;
	JButton btnWig40;
	JButton btnWig41;
	JButton btnWig42;
	JButton btnWig43;
	JButton btnWig44;
	JButton btnWig45;
	JButton btnWig46;
	JButton btnWig47;
	JButton btnWig48;
    public SaloonTools(VegEdit VE) {
        super(VE);
        this.VE=VE;

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(12, 4));
        //Wig 1
        btnWig1 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig1.png")));
        btnWig1.setToolTipText("Wig 1");
        btnWig1.setActionCommand(Config.CMD_WIG_1);
        btnWig1.addActionListener(this);
        btnWig1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig1);

        //Wig 2
        btnWig2 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig2.png")));
        btnWig2.setToolTipText("Wig 2");
        btnWig2.setActionCommand(Config.CMD_WIG_2);
        btnWig2.addActionListener(this);
        btnWig2.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig2);
		
		//Wig 3
        btnWig3 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig3.png")));
        btnWig3.setToolTipText("Wig 3");
        btnWig3.setActionCommand(Config.CMD_WIG_3);
        btnWig3.addActionListener(this);
        btnWig3.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig3);

        //Wig 4
        btnWig4 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig4.png")));
        btnWig4.setToolTipText("Wig 4");
        btnWig4.setActionCommand(Config.CMD_WIG_4);
        btnWig4.addActionListener(this);
        btnWig4.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig4);
		
		//Wig 5
        btnWig5 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig5.png")));
        btnWig5.setToolTipText("Wig 5");
        btnWig5.setActionCommand(Config.CMD_WIG_5);
        btnWig5.addActionListener(this);
        btnWig5.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig5);
		
		//Wig 6
        btnWig6 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig6.png")));
        btnWig6.setToolTipText("Wig 6");
        btnWig6.setActionCommand(Config.CMD_WIG_6);
        btnWig6.addActionListener(this);
        btnWig6.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig6);

		//Wig 7
        btnWig7 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig7.png")));
        btnWig7.setToolTipText("Wig 7");
        btnWig7.setActionCommand(Config.CMD_WIG_7);
        btnWig7.addActionListener(this);
        btnWig7.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig7);
		
		//Wig 8
        btnWig8 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig8.png")));
        btnWig8.setToolTipText("Wig 8");
        btnWig8.setActionCommand(Config.CMD_WIG_8);
        btnWig8.addActionListener(this);
        btnWig8.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig8);

		//Wig 9
        btnWig9 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig9.png")));
        btnWig9.setToolTipText("Wig 9");
        btnWig9.setActionCommand(Config.CMD_WIG_9);
        btnWig9.addActionListener(this);
        btnWig9.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig9);
		
		//Wig 10
        btnWig10 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig10.png")));
        btnWig10.setToolTipText("Wig 10");
        btnWig10.setActionCommand(Config.CMD_WIG_10);
        btnWig10.addActionListener(this);
        btnWig10.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig10);
		
		//Wig 11
        btnWig11 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig11.png")));
        btnWig11.setToolTipText("Wig 11");
        btnWig11.setActionCommand(Config.CMD_WIG_11);
        btnWig11.addActionListener(this);
        btnWig11.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig11);

		//Wig 12
        btnWig12 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig12.png")));
        btnWig12.setToolTipText("Wig 12");
        btnWig12.setActionCommand(Config.CMD_WIG_12);
        btnWig12.addActionListener(this);
        btnWig12.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig12);
		
		//Wig 13
        btnWig13 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig13.png")));
        btnWig13.setToolTipText("Wig 13");
        btnWig13.setActionCommand(Config.CMD_WIG_13);
        btnWig13.addActionListener(this);
        btnWig13.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig13);
		
		//Wig 14
        btnWig14 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig14.png")));
        btnWig14.setToolTipText("Wig 14");
        btnWig14.setActionCommand(Config.CMD_WIG_14);
        btnWig14.addActionListener(this);
        btnWig14.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig14);
		
		//Wig 15
        btnWig15 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig15.png")));
        btnWig15.setToolTipText("Wig 15");
        btnWig15.setActionCommand(Config.CMD_WIG_15);
        btnWig15.addActionListener(this);
        btnWig15.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig15);
		
		//Wig 16
        btnWig16 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig16.png")));
        btnWig16.setToolTipText("Wig 16");
        btnWig16.setActionCommand(Config.CMD_WIG_16);
        btnWig16.addActionListener(this);
        btnWig16.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig16);
		
		//Wig 17
        btnWig17 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig17.png")));
        btnWig17.setToolTipText("Wig 17");
        btnWig17.setActionCommand(Config.CMD_WIG_17);
        btnWig17.addActionListener(this);
        btnWig17.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig17);
		
		//Wig 18
        btnWig18 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig18.png")));
        btnWig18.setToolTipText("Wig 18");
        btnWig18.setActionCommand(Config.CMD_WIG_18);
        btnWig18.addActionListener(this);
        btnWig18.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig18);
		
		//Wig 19
        btnWig19 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig19.png")));
        btnWig19.setToolTipText("Wig 19");
        btnWig19.setActionCommand(Config.CMD_WIG_19);
        btnWig19.addActionListener(this);
        btnWig19.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig19);
		
		//Wig 20
        btnWig20 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig20.png")));
        btnWig20.setToolTipText("Wig 20");
        btnWig20.setActionCommand(Config.CMD_WIG_20);
        btnWig20.addActionListener(this);
        btnWig20.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig20);
		
		//Wig 21
        btnWig21 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig21.png")));
        btnWig21.setToolTipText("Wig 21");
        btnWig21.setActionCommand(Config.CMD_WIG_21);
        btnWig21.addActionListener(this);
        btnWig21.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig21);
		
		//Wig 22
        btnWig22 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig22.png")));
        btnWig22.setToolTipText("Wig 22");
        btnWig22.setActionCommand(Config.CMD_WIG_22);
        btnWig22.addActionListener(this);
        btnWig22.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig22);
		
		//Wig 23
        btnWig23 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig23.png")));
        btnWig23.setToolTipText("Wig 23");
        btnWig23.setActionCommand(Config.CMD_WIG_23);
        btnWig23.addActionListener(this);
        btnWig23.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig23);

		//Wig 24
        btnWig24 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig24.png")));
        btnWig24.setToolTipText("Wig 24");
        btnWig24.setActionCommand(Config.CMD_WIG_24);
        btnWig24.addActionListener(this);
        btnWig24.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig24);

		//Wig 25
        btnWig25 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig25.png")));
        btnWig25.setToolTipText("Wig 25");
        btnWig25.setActionCommand(Config.CMD_WIG_25);
        btnWig25.addActionListener(this);
        btnWig25.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig25);

		//Wig 26
        btnWig26 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig26.png")));
        btnWig26.setToolTipText("Wig 26");
        btnWig26.setActionCommand(Config.CMD_WIG_26);
        btnWig26.addActionListener(this);
        btnWig26.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig26);
		
		//Wig 27
        btnWig27 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig27.png")));
        btnWig27.setToolTipText("Wig 27");
        btnWig27.setActionCommand(Config.CMD_WIG_27);
        btnWig27.addActionListener(this);
        btnWig27.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig27);
		
		//Wig 28
        btnWig28 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig28.png")));
        btnWig28.setToolTipText("Wig 28");
        btnWig28.setActionCommand(Config.CMD_WIG_28);
        btnWig28.addActionListener(this);
        btnWig28.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig28);
		
		//Wig 29
        btnWig29 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig30.png")));
        btnWig29.setToolTipText("Wig 29");
        btnWig29.setActionCommand(Config.CMD_WIG_29);
        btnWig29.addActionListener(this);
        btnWig29.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig29);
		
		//Wig 30
        btnWig30 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig30.png")));
        btnWig30.setToolTipText("Wig 30");
        btnWig30.setActionCommand(Config.CMD_WIG_30);
        btnWig30.addActionListener(this);
        btnWig30.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig30);
		
		//Wig 31
        btnWig31 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig31.png")));
        btnWig31.setToolTipText("Wig 31");
        btnWig31.setActionCommand(Config.CMD_WIG_31);
        btnWig31.addActionListener(this);
        btnWig31.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig31);
		
		//Wig 32
        btnWig32 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig32.png")));
        btnWig32.setToolTipText("Wig 32");
        btnWig32.setActionCommand(Config.CMD_WIG_32);
        btnWig32.addActionListener(this);
        btnWig32.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig32);
		
		//Wig 33
        btnWig33 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig33.png")));
        btnWig33.setToolTipText("Wig 33");
        btnWig33.setActionCommand(Config.CMD_WIG_33);
        btnWig33.addActionListener(this);
        btnWig33.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig33);
		
		//Wig 34
        btnWig34 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig34.png")));
        btnWig34.setToolTipText("Wig 34");
        btnWig34.setActionCommand(Config.CMD_WIG_34);
        btnWig34.addActionListener(this);
        btnWig34.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig34);

		//Wig 35
        btnWig35 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig35.png")));
        btnWig35.setToolTipText("Wig 35");
        btnWig35.setActionCommand(Config.CMD_WIG_35);
        btnWig35.addActionListener(this);
        btnWig35.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig35);
		
		//Wig 36
        btnWig36 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig36.png")));
        btnWig36.setToolTipText("Wig 36");
        btnWig36.setActionCommand(Config.CMD_WIG_36);
        btnWig36.addActionListener(this);
        btnWig36.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig36);
		
		//Wig 37
        btnWig37 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig37.png")));
        btnWig37.setToolTipText("Wig 37");
        btnWig37.setActionCommand(Config.CMD_WIG_37);
        btnWig37.addActionListener(this);
        btnWig37.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig37);
		
		//Wig 38
        btnWig38 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig38.png")));
        btnWig38.setToolTipText("Wig 38");
        btnWig38.setActionCommand(Config.CMD_WIG_38);
        btnWig38.addActionListener(this);
        btnWig38.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig38);
		
		//Wig 39
        btnWig39 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig39.png")));
        btnWig39.setToolTipText("Wig 39");
        btnWig39.setActionCommand(Config.CMD_WIG_39);
        btnWig39.addActionListener(this);
        btnWig39.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig39);
		
		//Wig 40
        btnWig40 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig40.png")));
        btnWig40.setToolTipText("Wig 40");
        btnWig40.setActionCommand(Config.CMD_WIG_40);
        btnWig40.addActionListener(this);
        btnWig40.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig40);
		
		//Wig 41
        btnWig41 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig41.png")));
        btnWig41.setToolTipText("Wig 41");
        btnWig41.setActionCommand(Config.CMD_WIG_41);
        btnWig41.addActionListener(this);
        btnWig41.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig41);
		
		//Wig 42
        btnWig42 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig42.png")));
        btnWig42.setToolTipText("Wig 42");
        btnWig42.setActionCommand(Config.CMD_WIG_42);
        btnWig42.addActionListener(this);
        btnWig42.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig42);
		
		//Wig 43
        btnWig43 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig43.png")));
        btnWig43.setToolTipText("Wig 43");
        btnWig43.setActionCommand(Config.CMD_WIG_43);
        btnWig43.addActionListener(this);
        btnWig43.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig43);
		
		//Wig 44
        btnWig44 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig44.png")));
        btnWig44.setToolTipText("Wig 44");
        btnWig44.setActionCommand(Config.CMD_WIG_44);
        btnWig44.addActionListener(this);
        btnWig44.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig44);

		//Wig 45
        btnWig45 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig45.png")));
        btnWig45.setToolTipText("Wig 45");
        btnWig45.setActionCommand(Config.CMD_WIG_45);
        btnWig45.addActionListener(this);
        btnWig45.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig45);
		
		//Wig 46
        btnWig46 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig46.png")));
        btnWig46.setToolTipText("Wig 46");
        btnWig46.setActionCommand(Config.CMD_WIG_46);
        btnWig46.addActionListener(this);
        btnWig46.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig46);
		
		//Wig 47
        btnWig47 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig47.png")));
        btnWig47.setToolTipText("Wig 47");
        btnWig47.setActionCommand(Config.CMD_WIG_47);
        btnWig47.addActionListener(this);
        btnWig47.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig47);
		
		//Wig 48
        btnWig48 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/wig48.png")));
        btnWig48.setToolTipText("Wig 48");
        btnWig48.setActionCommand(Config.CMD_WIG_48);
        btnWig48.addActionListener(this);
        btnWig48.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnWig48);

        getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(250, 180);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
	}
}
