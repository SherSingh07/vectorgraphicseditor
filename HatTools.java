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

public class HatTools extends Tools implements ActionListener{
    VegEdit VE;
	JButton btnHat1;
	JButton btnHat2;
	JButton btnHat3;
	JButton btnHat4;
	JButton btnHat5;
	JButton btnHat6;
	JButton btnHat7;
	JButton btnHat8;
	JButton btnHat9;
	JButton btnHat10;
	JButton btnHat11;
	JButton btnHat12;
	JButton btnHat13;
	JButton btnHat14;
	JButton btnHat15;
	JButton btnHat16;
	JButton btnHat17;
	JButton btnHat18;
	JButton btnHat19;
	JButton btnHat20;
	JButton btnHat21;
	JButton btnHat22;
	JButton btnHat23;
	JButton btnHat24;
	JButton btnHat25;
	JButton btnHat26;
	JButton btnHat27;
	JButton btnHat28;
	JButton btnHat29;
	JButton btnHat30;
	JButton btnHat31;
	JButton btnHat32;
	JButton btnHat33;
	JButton btnHat34;
	JButton btnHat35;
	JButton btnHat36;
	JButton btnHat37;
	JButton btnHat38;
	JButton btnHat39;
	JButton btnHat40;
	JButton btnHat41;
	JButton btnHat42;
	JButton btnHat43;
	JButton btnHat44;
	JButton btnHat45;
	JButton btnHat46;
	JButton btnHat47;
	JButton btnHat48;
	JButton btnHat49;
	JButton btnHat50;
	JButton btnHat51;
	JButton btnHat52;
	JButton btnHat53;
	JButton btnHat54;
	JButton btnHat55;
	JButton btnHat56;
	JButton btnHat57;
	JButton btnHat58;
	JButton btnHat59;
	JButton btnHat60;
	JButton btnHat61;
	JButton btnHat62;

    public HatTools(VegEdit VE) {
        super(VE);
        this.VE=VE;

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(12, 4));
        //Hat 1
        btnHat1 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat1.png")));
        btnHat1.setToolTipText("Hat 1");
        btnHat1.setActionCommand(Config.CMD_HAT_1);
        btnHat1.addActionListener(this);
        btnHat1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat1);

        //Hat 2
        btnHat2 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat2.png")));
        btnHat2.setToolTipText("Hat 2");
        btnHat2.setActionCommand(Config.CMD_HAT_2);
        btnHat2.addActionListener(this);
        btnHat2.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat2);
		
		//Hat 3
        btnHat3 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat3.png")));
        btnHat3.setToolTipText("Hat 3");
        btnHat3.setActionCommand(Config.CMD_HAT_3);
        btnHat3.addActionListener(this);
        btnHat3.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat3);

        //Hat 4
        btnHat4 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat4.png")));
        btnHat4.setToolTipText("Hat 4");
        btnHat4.setActionCommand(Config.CMD_HAT_4);
        btnHat4.addActionListener(this);
        btnHat4.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat4);
		
		//Hat 5
        btnHat5 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat5.png")));
        btnHat5.setToolTipText("Hat 5");
        btnHat5.setActionCommand(Config.CMD_HAT_5);
        btnHat5.addActionListener(this);
        btnHat5.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat5);
		
		//Hat 6
        btnHat6 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat6.png")));
        btnHat6.setToolTipText("Hat 6");
        btnHat6.setActionCommand(Config.CMD_HAT_6);
        btnHat6.addActionListener(this);
        btnHat6.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat6);

		//Hat 7
        btnHat7 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat7.png")));
        btnHat7.setToolTipText("Hat 7");
        btnHat7.setActionCommand(Config.CMD_HAT_7);
        btnHat7.addActionListener(this);
        btnHat7.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat7);
		
		//Hat 8
        btnHat8 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat8.png")));
        btnHat8.setToolTipText("Hat 8");
        btnHat8.setActionCommand(Config.CMD_HAT_8);
        btnHat8.addActionListener(this);
        btnHat8.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat8);

		//Hat 9
        btnHat9 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat9.png")));
        btnHat9.setToolTipText("Hat 9");
        btnHat9.setActionCommand(Config.CMD_HAT_9);
        btnHat9.addActionListener(this);
        btnHat9.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat9);
		
		//Hat 10
        btnHat10 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat10.png")));
        btnHat10.setToolTipText("Hat 10");
        btnHat10.setActionCommand(Config.CMD_HAT_10);
        btnHat10.addActionListener(this);
        btnHat10.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat10);
		
		//Hat 11
        btnHat11 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat11.png")));
        btnHat11.setToolTipText("Hat 11");
        btnHat11.setActionCommand(Config.CMD_HAT_11);
        btnHat11.addActionListener(this);
        btnHat11.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat11);

		//Hat 12
        btnHat12 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat12.png")));
        btnHat12.setToolTipText("Hat 12");
        btnHat12.setActionCommand(Config.CMD_HAT_12);
        btnHat12.addActionListener(this);
        btnHat12.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat12);
		
		//Hat 13
        btnHat13 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat13.png")));
        btnHat13.setToolTipText("Hat 13");
        btnHat13.setActionCommand(Config.CMD_HAT_13);
        btnHat13.addActionListener(this);
        btnHat13.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat13);
		
		//Hat 14
        btnHat14 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat14.png")));
        btnHat14.setToolTipText("Hat 14");
        btnHat14.setActionCommand(Config.CMD_HAT_14);
        btnHat14.addActionListener(this);
        btnHat14.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat14);
		
		//Hat 15
        btnHat15 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat15.png")));
        btnHat15.setToolTipText("Hat 15");
        btnHat15.setActionCommand(Config.CMD_HAT_15);
        btnHat15.addActionListener(this);
        btnHat15.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat15);
		
		//Hat 16
        btnHat16 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat16.png")));
        btnHat16.setToolTipText("Hat 16");
        btnHat16.setActionCommand(Config.CMD_HAT_16);
        btnHat16.addActionListener(this);
        btnHat16.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat16);
		
		//Hat 17
        btnHat17 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat17.png")));
        btnHat17.setToolTipText("Hat 17");
        btnHat17.setActionCommand(Config.CMD_HAT_17);
        btnHat17.addActionListener(this);
        btnHat17.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat17);
		
		//Hat 18
        btnHat18 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat18.png")));
        btnHat18.setToolTipText("Hat 18");
        btnHat18.setActionCommand(Config.CMD_HAT_18);
        btnHat18.addActionListener(this);
        btnHat18.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat18);
		
		//Hat 19
        btnHat19 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat19.png")));
        btnHat19.setToolTipText("Hat 19");
        btnHat19.setActionCommand(Config.CMD_HAT_19);
        btnHat19.addActionListener(this);
        btnHat19.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat19);
		
		//Hat 20
        btnHat20 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat20.png")));
        btnHat20.setToolTipText("Hat 20");
        btnHat20.setActionCommand(Config.CMD_HAT_20);
        btnHat20.addActionListener(this);
        btnHat20.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat20);
		
		//Hat 21
        btnHat21 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat21.png")));
        btnHat21.setToolTipText("Hat 21");
        btnHat21.setActionCommand(Config.CMD_HAT_21);
        btnHat21.addActionListener(this);
        btnHat21.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat21);
		
		//Hat 22
        btnHat22 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat22.png")));
        btnHat22.setToolTipText("Hat 22");
        btnHat22.setActionCommand(Config.CMD_HAT_22);
        btnHat22.addActionListener(this);
        btnHat22.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat22);
		
		//Hat 23
        btnHat23 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat23.png")));
        btnHat23.setToolTipText("Hat 23");
        btnHat23.setActionCommand(Config.CMD_HAT_23);
        btnHat23.addActionListener(this);
        btnHat23.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat23);

		//Hat 24
        btnHat24 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat24.png")));
        btnHat24.setToolTipText("Hat 24");
        btnHat24.setActionCommand(Config.CMD_HAT_24);
        btnHat24.addActionListener(this);
        btnHat24.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat24);

		//Hat 25
        btnHat25 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat25.png")));
        btnHat25.setToolTipText("Hat 25");
        btnHat25.setActionCommand(Config.CMD_HAT_25);
        btnHat25.addActionListener(this);
        btnHat25.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat25);

		//Hat 26
        btnHat26 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat26.png")));
        btnHat26.setToolTipText("Hat 26");
        btnHat26.setActionCommand(Config.CMD_HAT_26);
        btnHat26.addActionListener(this);
        btnHat26.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat26);
		
		//Hat 27
        btnHat27 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat27.png")));
        btnHat27.setToolTipText("Hat 27");
        btnHat27.setActionCommand(Config.CMD_HAT_27);
        btnHat27.addActionListener(this);
        btnHat27.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat27);
		
		//Hat 28
        btnHat28 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat28.png")));
        btnHat28.setToolTipText("Hat 28");
        btnHat28.setActionCommand(Config.CMD_HAT_28);
        btnHat28.addActionListener(this);
        btnHat28.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat28);
		
		//Hat 29
        btnHat29 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat30.png")));
        btnHat29.setToolTipText("Hat 29");
        btnHat29.setActionCommand(Config.CMD_HAT_29);
        btnHat29.addActionListener(this);
        btnHat29.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat29);
		
		//Hat 30
        btnHat30 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat30.png")));
        btnHat30.setToolTipText("Hat 30");
        btnHat30.setActionCommand(Config.CMD_HAT_30);
        btnHat30.addActionListener(this);
        btnHat30.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat30);
		
		//Hat 31
        btnHat31 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat31.png")));
        btnHat31.setToolTipText("Hat 31");
        btnHat31.setActionCommand(Config.CMD_HAT_31);
        btnHat31.addActionListener(this);
        btnHat31.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat31);
		
		//Hat 32
        btnHat32 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat32.png")));
        btnHat32.setToolTipText("Hat 32");
        btnHat32.setActionCommand(Config.CMD_HAT_32);
        btnHat32.addActionListener(this);
        btnHat32.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat32);
		
		//Hat 33
        btnHat33 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat33.png")));
        btnHat33.setToolTipText("Hat 33");
        btnHat33.setActionCommand(Config.CMD_HAT_33);
        btnHat33.addActionListener(this);
        btnHat33.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat33);
		
		//Hat 34
        btnHat34 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat34.png")));
        btnHat34.setToolTipText("Hat 34");
        btnHat34.setActionCommand(Config.CMD_HAT_34);
        btnHat34.addActionListener(this);
        btnHat34.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat34);

		//Hat 35
        btnHat35 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat35.png")));
        btnHat35.setToolTipText("Hat 35");
        btnHat35.setActionCommand(Config.CMD_HAT_35);
        btnHat35.addActionListener(this);
        btnHat35.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat35);
		
		//Hat 36
        btnHat36 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat36.png")));
        btnHat36.setToolTipText("Hat 36");
        btnHat36.setActionCommand(Config.CMD_HAT_36);
        btnHat36.addActionListener(this);
        btnHat36.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat36);
		
		//Hat 37
        btnHat37 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat37.png")));
        btnHat37.setToolTipText("Hat 37");
        btnHat37.setActionCommand(Config.CMD_HAT_37);
        btnHat37.addActionListener(this);
        btnHat37.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat37);
		
		//Hat 38
        btnHat38 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat38.png")));
        btnHat38.setToolTipText("Hat 38");
        btnHat38.setActionCommand(Config.CMD_HAT_38);
        btnHat38.addActionListener(this);
        btnHat38.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat38);
		
		//Hat 39
        btnHat39 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat39.png")));
        btnHat39.setToolTipText("Hat 39");
        btnHat39.setActionCommand(Config.CMD_HAT_39);
        btnHat39.addActionListener(this);
        btnHat39.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat39);
		
		//Hat 40
        btnHat40 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat40.png")));
        btnHat40.setToolTipText("Hat 40");
        btnHat40.setActionCommand(Config.CMD_HAT_40);
        btnHat40.addActionListener(this);
        btnHat40.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat40);
		
		//Hat 41
        btnHat41 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat41.png")));
        btnHat41.setToolTipText("Hat 41");
        btnHat41.setActionCommand(Config.CMD_HAT_41);
        btnHat41.addActionListener(this);
        btnHat41.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat41);
		
		//Hat 42
        btnHat42 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat42.png")));
        btnHat42.setToolTipText("Hat 42");
        btnHat42.setActionCommand(Config.CMD_HAT_42);
        btnHat42.addActionListener(this);
        btnHat42.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat42);
		
		//Hat 43
        btnHat43 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat43.png")));
        btnHat43.setToolTipText("Hat 43");
        btnHat43.setActionCommand(Config.CMD_HAT_43);
        btnHat43.addActionListener(this);
        btnHat43.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat43);
		
		//Hat 44
        btnHat44 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat44.png")));
        btnHat44.setToolTipText("Hat 44");
        btnHat44.setActionCommand(Config.CMD_HAT_44);
        btnHat44.addActionListener(this);
        btnHat44.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat44);

		//Hat 45
        btnHat45 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat45.png")));
        btnHat45.setToolTipText("Hat 45");
        btnHat45.setActionCommand(Config.CMD_HAT_45);
        btnHat45.addActionListener(this);
        btnHat45.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat45);
		
		//Hat 46
        btnHat46 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat46.png")));
        btnHat46.setToolTipText("Hat 46");
        btnHat46.setActionCommand(Config.CMD_HAT_46);
        btnHat46.addActionListener(this);
        btnHat46.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat46);
		
		//Hat 47
        btnHat47 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat47.png")));
        btnHat47.setToolTipText("Hat 47");
        btnHat47.setActionCommand(Config.CMD_HAT_47);
        btnHat47.addActionListener(this);
        btnHat47.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat47);
		
		//Hat 48
        btnHat48 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat48.png")));
        btnHat48.setToolTipText("Hat 48");
        btnHat48.setActionCommand(Config.CMD_HAT_48);
        btnHat48.addActionListener(this);
        btnHat48.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat48);
		
		//Hat 49
        btnHat49 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat49.png")));
        btnHat49.setToolTipText("Hat 49");
        btnHat49.setActionCommand(Config.CMD_HAT_49);
        btnHat49.addActionListener(this);
        btnHat49.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat49);
		
		//Hat 50
        btnHat50 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat50.png")));
        btnHat50.setToolTipText("Hat 50");
        btnHat50.setActionCommand(Config.CMD_HAT_50);
        btnHat50.addActionListener(this);
        btnHat50.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat50);
		
		//Hat 51
        btnHat51 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat51.png")));
        btnHat51.setToolTipText("Hat 51");
        btnHat51.setActionCommand(Config.CMD_HAT_51);
        btnHat51.addActionListener(this);
        btnHat51.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat51);
		
		//Hat 52
        btnHat52 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat52.png")));
        btnHat52.setToolTipText("Hat 52");
        btnHat52.setActionCommand(Config.CMD_HAT_52);
        btnHat52.addActionListener(this);
        btnHat52.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat52);
		
		//Hat 53
        btnHat53 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat53.png")));
        btnHat53.setToolTipText("Hat 53");
        btnHat53.setActionCommand(Config.CMD_HAT_53);
        btnHat53.addActionListener(this);
        btnHat53.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat53);
		
		//Hat 54
        btnHat54 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat54.png")));
        btnHat54.setToolTipText("Hat 54");
        btnHat54.setActionCommand(Config.CMD_HAT_54);
        btnHat54.addActionListener(this);
        btnHat54.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat54);
		
		//Hat 55
        btnHat55 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat55.png")));
        btnHat55.setToolTipText("Hat 55");
        btnHat55.setActionCommand(Config.CMD_HAT_55);
        btnHat55.addActionListener(this);
        btnHat55.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat55);
		
		//Hat 56
        btnHat56 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat56.png")));
        btnHat56.setToolTipText("Hat 56");
        btnHat56.setActionCommand(Config.CMD_HAT_56);
        btnHat56.addActionListener(this);
        btnHat56.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat56);
		
		//Hat 57
        btnHat57 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat57.png")));
        btnHat57.setToolTipText("Hat 57");
        btnHat57.setActionCommand(Config.CMD_HAT_57);
        btnHat57.addActionListener(this);
        btnHat57.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat57);
		
		//Hat 58
        btnHat58 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat58.png")));
        btnHat58.setToolTipText("Hat 58");
        btnHat58.setActionCommand(Config.CMD_HAT_58);
        btnHat58.addActionListener(this);
        btnHat58.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat58);
		
		//Hat 59
        btnHat59 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat59.png")));
        btnHat59.setToolTipText("Hat 59");
        btnHat59.setActionCommand(Config.CMD_HAT_59);
        btnHat59.addActionListener(this);
        btnHat59.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat59);
        
		//Hat 60
        btnHat60 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat60.png")));
        btnHat60.setToolTipText("Hat 60");
        btnHat60.setActionCommand(Config.CMD_HAT_60);
        btnHat60.addActionListener(this);
        btnHat60.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat60);
        
		//Hat 61
        btnHat61 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat61.png")));
        btnHat61.setToolTipText("Hat 61");
        btnHat61.setActionCommand(Config.CMD_HAT_61);
        btnHat61.addActionListener(this);
        btnHat61.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat61);
		
		//Hat 62
        btnHat62 = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hat62.png")));
        btnHat62.setToolTipText("Hat 62");
        btnHat62.setActionCommand(Config.CMD_HAT_62);
        btnHat62.addActionListener(this);
        btnHat62.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnHat62);

        getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(250, 210);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
	}
}
