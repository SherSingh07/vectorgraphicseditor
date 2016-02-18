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
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BottomToolbar extends JToolBar {

    private VegEdit VE;

    public BottomToolbar(VegEdit VE) {

        this.VE=VE;

        //Color Picker
        JButton btnColorPicker = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/colors.png")));
        btnColorPicker.setToolTipText("Select Color");
        btnColorPicker.setActionCommand(Config.CMD_PICK_COLOR);
        btnColorPicker.addActionListener(VE);
        add(btnColorPicker);

        //Color Themes
        JButton btnColorThemes = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/color_settings.png")));
        btnColorThemes.setToolTipText("Select Color Theme");
        add(btnColorThemes);

        //Free Hand Drawing
        JButton btnFreeHandDrawing = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/pencil.png")));
        btnFreeHandDrawing.setToolTipText("Free Hand Drawing");
        add(btnFreeHandDrawing);

        //Eraser
        JButton btnEraser = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/eraser.png")));
        btnEraser.setToolTipText("Eraser...");
        add(btnEraser);

        add(new JLabel("Stroke Size:"));
	    add(DrawEnv.getInstance().getStrokeSize());
        add(new JLabel("pixels                               "));
        add(new JLabel("Stroke Colour"));
        add(new ColorPanel());
        add(new JLabel("                                                                                     ")); 

    }
}//BottomToolbar
