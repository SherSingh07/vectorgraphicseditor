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
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TopToolbar extends JToolBar {

        private VegEdit VE;
        public TopToolbar(VegEdit VE) {

        this.VE=VE;

        //New
        JButton newButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/new_file.png")));
        newButton.setToolTipText("New:Creating VeGEdit graphics file... ");
        add(newButton);

        //Open
        JButton openButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/open_file.png")));
        openButton.setToolTipText("Open VeGEdit graphics file... ");
        add(openButton);
		
		//Save
        JButton saveButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/save.png")));
        saveButton.setToolTipText("Save your image...");
		saveButton.setActionCommand(Config.CMD_SAVE);
		saveButton.addActionListener(VE);
        add(saveButton);
		
		//Save As
        JButton saveAsButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/save_as.png")));
        saveAsButton.setToolTipText("Save As your image...");
		saveAsButton.setActionCommand(Config.CMD_SAVEAS);
		saveAsButton.addActionListener(VE);
        add(saveAsButton);

        //Cut
        JButton cutButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/cut.png")));
        cutButton.setToolTipText("Cut your image...");
        add(cutButton);

        //Copy
        JButton copyButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/copy.png")));
        copyButton.setToolTipText("Copy your image...");
		copyButton.setActionCommand(Config.CMD_COPY);
		copyButton.addActionListener(VE);
        add(copyButton);

        //Paste
        JButton pasteButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/paste.png")));
        pasteButton.setToolTipText("Paste your image...");
		pasteButton.setActionCommand(Config.CMD_PASTE);
		pasteButton.addActionListener(VE);
        add(pasteButton);

        //Undo
        JButton undoButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/undo.png")));
        undoButton.setToolTipText("Undo your changes...");
        undoButton.setActionCommand(Config.CMD_UNDO);
        undoButton.addActionListener(VE);
        add(undoButton);

        //Redo
        JButton redoButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/redo.png")));
        redoButton.setToolTipText("Redo your changes...");
        redoButton.setActionCommand(Config.CMD_REDO);
        redoButton.addActionListener(VE);
        add(redoButton);

        //Full Screen
        JButton fullScreenButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/fullscreen.png")));
        fullScreenButton.setToolTipText("Show full screen...");
        add(fullScreenButton);

		//Select 
		JButton selectButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/selection.png")));
        selectButton.setToolTipText("Select the object");
		selectButton.setActionCommand(Config.CMD_SELECT);
		selectButton.addActionListener(VE);
        add(selectButton);


        //Exit
        JButton exitButton = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/exit.png")));
        exitButton.setToolTipText("Exit from VeGEdit graphics editor...");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                System.exit(0);
                }

                });
	 
	}

}//TopToolbar
