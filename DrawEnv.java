/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * DrawEnv.java is the drawing environment singleton...
 * 
 * Copyright (c) 2011 onwards by WeaveBytes, Inc. 
 * Please report bugs at weavebytes@gmail.com
 * 
 * This file may be distributed and/or modified under the terms of the 
 * GNU General Public License version 2 as published by the Free Software 
 * Foundation. (See COPYING.GPL for details.)
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 * 
 */

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.*;;

class DrawEnv {    
    private static DrawEnv _instance = new DrawEnv(); 

    private Color     foreground;
    private JComboBox ftSize;
	private JComboBox ftStyle;
	private JComboBox ftName;
	private JComboBox StrokeSize;
	String name[];

    //return singleton
    public static DrawEnv getInstance() { return _instance; } 


    private DrawEnv() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		name = ge.getAvailableFontFamilyNames();

		ftName = new JComboBox();
		for(int i=0; i<name.length; i++) ftName.addItem(""+name[i]);

        foreground = Color.BLACK;
        ftSize = new JComboBox();
        for(int i=8; i<=72; i=i+2) ftSize.addItem(""+i);
		ftStyle = new JComboBox();
		ftStyle.addItem("PLAIN");
		ftStyle.addItem("BOLD");
		ftStyle.addItem("ITALICS");
		ftStyle.addItem("BOLD+ITALICS");

		StrokeSize = new JComboBox();
		StrokeSize.addItem("1");
		StrokeSize.addItem("3");
		StrokeSize.addItem("5");
		StrokeSize.addItem("8");

	    }

    public Color getForeground() {
        return foreground;
    }

    public JComboBox getFontList() {
        return ftSize;
    }

	public JComboBox getFontType(){
		return ftStyle;
	}

	public JComboBox getFontName(){
		return ftName;
	}

	public JComboBox getStrokeSize(){
		return StrokeSize;
	}

    public void setForeground(Color col) {
        foreground = col;
    }

    public int getFontSize() {
        int size =  Integer.parseInt((String)ftSize.getSelectedItem());
        return size;
    }

	public String getFontNames() {
        String font =  (String)ftName.getSelectedItem();
        return font;
    }

	public int getFontStyle(){
		int style = ftStyle.getSelectedIndex();
		return style;
	}

	public int getStrokeSizes(){
		int size = Integer.parseInt((String)StrokeSize.getSelectedItem());
		return size;
	}
}//DrawEnv
