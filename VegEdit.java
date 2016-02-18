/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * VegEdit.java is the main java file for starting the application.
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VegEdit extends JFrame implements ActionListener {

    // (1) Toolbars
    TopToolbar    top           = new TopToolbar(this);
    LeftToolbar   leftToolbar   = new LeftToolbar(this);
    BottomToolbar bottomToolbar = new BottomToolbar(this);
    RightToolbar  rightToolbar  = new RightToolbar(this);

    // (2) Central Drawing Area
    DrawingArea DA = new DrawingArea();

    JDialog dlgColPicker;


    public VegEdit(){
        super("VeGEdit - The Vector Graphics Editor By WeaveBytes, Inc.");
        setLayout(new BorderLayout());

        setupMenus();

        add(top, BorderLayout.NORTH);
        add(DA, BorderLayout.CENTER);
        add(leftToolbar, BorderLayout.WEST);
        add(bottomToolbar, BorderLayout.SOUTH);
		add(rightToolbar, BorderLayout.EAST);

        setSize(900, 700);
        setLocation(100, 50);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/icons/32x32/vg.png"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //initialize color picker
     //   initColorPicker(); 

        setVisible(true);
    }


    //function to setup GUI Menus
    private void setupMenus() {
        JMenuBar menubar = new JMenuBar();

        //File Menu.................................................................
        JMenu mFile = new JMenu("File");
        //enable file menu to be opened by ALT+F 
        mFile.setMnemonic(KeyEvent.VK_F);
        //adding file menu items
        JMenuItem miNew = new JMenuItem("New", new ImageIcon(getClass().getResource("images/icons/16x16/document_16.png")));
        miNew.setToolTipText("Creating VeGEdit graphics file... ");
        mFile.add(miNew);

        JMenuItem miOpen = new JMenuItem("Open", new ImageIcon(getClass().getResource("images/icons/16x16/folder_16.png")));
        miOpen.setToolTipText("Open VeGEdit graphics file... ");
        mFile.add(miOpen);

        mFile.addSeparator();

        JMenuItem miSave = new JMenuItem("Save", new ImageIcon(getClass().getResource("images/icons/16x16/save_16.png")));
        miSave.setToolTipText("Save VeGEdit graphics file... ");
        miSave.addActionListener(this);
        miSave.setActionCommand(Config.CMD_SAVE);
        mFile.add(miSave);

        JMenuItem miSaveAs = new JMenuItem("Save As", new ImageIcon(getClass().getResource("images/icons/16x16/saveas.png")));
        miSaveAs.setToolTipText("Save As VeGEdit graphics file... ");
		miSaveAs.setActionCommand(Config.CMD_SAVEAS);
        mFile.add(miSaveAs);

        mFile.addSeparator();

        JMenuItem miPrint = new JMenuItem("Print", new ImageIcon(getClass().getResource("images/icons/16x16/print.png")));
        miPrint.setToolTipText("Print the Selected File....");
        mFile.add(miPrint);

        mFile.addSeparator();

        JMenuItem miImport = new JMenuItem("Import", new ImageIcon(getClass().getResource("images/icons/16x16/import.png")));
        miImport.setToolTipText("Import VeGEdit graphics file... ");
        mFile.add(miImport);

        JMenuItem miExport = new JMenuItem("Export", new ImageIcon(getClass().getResource("images/icons/16x16/export_file.png")));
        miExport.setToolTipText("Export VeGEdit graphics file... ");
        mFile.add(miExport);

        mFile.addSeparator();

        JMenuItem miExit = new JMenuItem("Exit", new ImageIcon(getClass().getResource("images/icons/16x16/exit.png")));
        miExit.setMnemonic(KeyEvent.VK_X);
        miExit.setToolTipText("Exit application");

        //handler for Exit Clicked
        miExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                System.exit(0);
                }
                });
        mFile.add(miExit);

        //Edit Menu.................................................................
        JMenu mEdit = new JMenu("Edit");
        //enable edit menu to be opened by ALT+E 
        mEdit.setMnemonic(KeyEvent.VK_E);

        JMenuItem miCut = new JMenuItem("Cut", new ImageIcon(getClass().getResource("images/icons/16x16/cut.png")));
        miCut.setToolTipText("Cut your image...");
        mEdit.add(miCut);

        JMenuItem miCopy = new JMenuItem("Copy", new ImageIcon(getClass().getResource("images/icons/16x16/copy.png")));
        miCopy.setToolTipText("Copy your image...");
        mEdit.add(miCopy);

        JMenuItem miPaste = new JMenuItem("Paste", new ImageIcon(getClass().getResource("images/icons/16x16/paste.png")));
        miPaste.setToolTipText("Paste your image...");
        mEdit.add(miPaste);

        mEdit.addSeparator();

        JMenuItem miUndo = new JMenuItem("Undo", new ImageIcon(getClass().getResource("images/icons/16x16/undo.png")));
        miUndo.setToolTipText("Undo your changes...");
        miUndo.setActionCommand(Config.CMD_UNDO);
        miUndo.addActionListener(this);
        mEdit.add(miUndo);

        JMenuItem miRedo = new JMenuItem("Redo", new ImageIcon(getClass().getResource("images/icons/16x16/redo.png")));
        miRedo.setToolTipText("Redo your changes...");
        mEdit.add(miRedo);

        mEdit.addSeparator();

        JMenuItem miDel = new JMenuItem("Delete", new ImageIcon(getClass().getResource("images/icons/16x16/delete_16.png")));
        miDel.setToolTipText("Delete...");
        mEdit.add(miDel);

        mEdit.addSeparator();

        JMenuItem miSelectAll = new JMenuItem("Select All", new ImageIcon(getClass().getResource("images/icons/32x32/select_all.png")));
        miSelectAll.setToolTipText("Select images...");
        mEdit.add(miSelectAll);

        //View Menu.................................................................
        JMenu mView = new JMenu("View");
        //enable view menu to be opened by ALT+V 
        mView.setMnemonic(KeyEvent.VK_V);

        JMenuItem miZoomIn = new JMenuItem("Zoom In", new ImageIcon(getClass().getResource("images/icons/16x16/zoomin.png")));
        miZoomIn.setToolTipText("Zoom In on the current Picture..");
        mView.add(miZoomIn);

        JMenuItem miZoomOut = new JMenuItem("Zoom Out", new ImageIcon(getClass().getResource("images/icons/16x16/zoomout.png")));
        miZoomOut.setToolTipText("Zoom Out on the current Picture..");
        mView.add(miZoomOut);

        JMenuItem miFullScreen = new JMenuItem("Full Screen", new ImageIcon(getClass().getResource("images/icons/16x16/fullscreen.png")));
        miFullScreen.setToolTipText("View full screen");
        mView.add(miFullScreen);

        //Tools Menu.................................................................
        JMenu mTools = new JMenu("Tools");
        //enable tools menu to be opened by ALT+T 
        mTools.setMnemonic(KeyEvent.VK_T);

        JMenu mShapes = new JMenu("Shapes");
        mShapes.setToolTipText(" Select your shape & have fun !!! ");

        JMenuItem miRect = new JMenuItem("Rectangle", new ImageIcon(getClass().getResource("images/icons/16x16/rectangle.png")));
        miRect.setToolTipText("Draw Rectagnles on Screen.");
        mShapes.add(miRect);

        JMenuItem miOval = new JMenuItem("Oval", new ImageIcon(getClass().getResource("images/icons/16x16/oval1.png")));
        miOval.setToolTipText("Draw Oval on the Screen..");
        mShapes.add(miOval);

        JMenuItem miRoundRect = new JMenuItem("RoundRectangle", new ImageIcon(getClass().getResource("images/icons/16x16/roundrect.png")));
        miRoundRect.setToolTipText("Draw Rounded Rectangle on the Screen..");
        mShapes.add(miRoundRect);

        JMenuItem miLine = new JMenuItem("Line", new ImageIcon(getClass().getResource("images/icons/16x16/line.png")));
        miLine.setToolTipText("Draw Line on the Screen..");
        mShapes.add(miLine);

        JMenuItem miSmileys = new JMenuItem("Smileys", new ImageIcon(getClass().getResource("images/icons/16x16/emoticons.png")));
        miSmileys.setToolTipText("Draw Smileys on the Screen..");
        mShapes.add(miSmileys);

        JMenuItem miScroll = new JMenuItem("Scroll", new ImageIcon(getClass().getResource("images/icons/16x16/scroll.png")));
        miScroll.setToolTipText("Draw Scroll on the Screen..");
        mShapes.add(miScroll);

        JMenuItem miTriangle = new JMenuItem("Triangle", new ImageIcon(getClass().getResource("images/icons/16x16/Triangle.png")));
        miTriangle.setToolTipText("Draw Triangle on the Screen..");
        mShapes.add(miTriangle);

        JMenuItem miHeart = new JMenuItem("Heart", new ImageIcon(getClass().getResource("images/icons/16x16/Heart.png")));
        miHeart.setToolTipText("Draw Heart on the Screen..");
        mShapes.add(miHeart);

        JMenuItem miStar = new JMenuItem("Star", new ImageIcon(getClass().getResource("images/icons/16x16/star.png")));
        miStar.setToolTipText("Draw Heart on the Screen..");
        mShapes.add(miStar);

        JMenuItem miText = new JMenuItem("Text", new ImageIcon(getClass().getResource("images/icons/16x16/text.png")));
        miText.setToolTipText("Draw Text on the Screen..");
        mShapes.add(miText);

        mTools.add(mShapes);

        JMenuItem miToolBar = new JMenuItem("Toolbar", new ImageIcon(getClass().getResource("images/icons/16x16/toolbar.png")));
        miToolBar.setToolTipText(" Select tool(s) to show... ");
        mTools.add(miToolBar);

        //Settings Menu.................................................................
        JMenu mSettings = new JMenu("Settings");
        //enable settings menu to be opened by ALT+S 
        mSettings.setMnemonic(KeyEvent.VK_S);

        JMenuItem miTheme = new JMenuItem("Themes", new ImageIcon(getClass().getResource("images/icons/16x16/themes.png")));
        miTheme.setToolTipText(" Select theme !!! ");
        mSettings.add(miTheme);



        //Help Menu.................................................................
        JMenu mHelp = new JMenu("Help");
        mFile.setMnemonic(KeyEvent.VK_H);
        //adding help.png icon
        JMenuItem miHelp = new JMenuItem("VeGEdit Help", new ImageIcon(getClass().getResource("images/icons/32x32/help.png")));
        miHelp.setMnemonic(KeyEvent.VK_P);
        miHelp.setToolTipText("VeGEdit Help is a very user friendly help system that helps the users to quickly understand VeGEdit.");
        mHelp.add(miHelp);

        JMenuItem miAbout = new JMenuItem("About", new ImageIcon(getClass().getResource("images/icons/16x16/vg.png")));
        miAbout.setToolTipText("VeGEdit Help is a very user friendly help system that helps the users to quickly understand VeGEdit.");
        miAbout.setActionCommand(Config.CMD_ABOUT);
        miAbout.addActionListener(this);
        mHelp.add(miAbout);

        //Add menus to menubar.......................................................
        menubar.add(mFile);
        menubar.add(mEdit);
        menubar.add(mView);
        menubar.add(mTools);
        menubar.add(mSettings);
        menubar.add(mHelp);
        setJMenuBar(menubar);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(Config.CMD_ABOUT)) {     
            new AboutDialog(this, "VeGEdit- The Vector Graphics Editor", "Graphics Editor Under Construciton....");       
        }
        else if(event.getActionCommand().equals(Config.CMD_UNDO)) { DrawingPanel.getInstance().undo(); }
        else if(event.getActionCommand().equals(Config.CMD_REDO)) { DrawingPanel.getInstance().redo(); }
        else if(event.getActionCommand().equals(Config.CMD_SAVE)) { DrawingPanel.getInstance().save(); }
        else if(event.getActionCommand().equals(Config.CMD_SELECT)) { DrawingPanel.getInstance().setOperation(Config.CMD_SELECT); }
        else if(event.getActionCommand().equals(Config.CMD_COPY))   { DrawingPanel.getInstance().copyShape(); }
        else if(event.getActionCommand().equals(Config.CMD_PASTE))  { DrawingPanel.getInstance().pasteShape(); }
        //      else if(event.getActionCommand().equals(Config.CMD_PICK_COLOR)) { showColorPicker(); }
        else if(event.getActionCommand().equals(Config.CMD_DRAW_TOOTH))  {DrawingPanel.getInstance().setOperation(Config.CMD_DRAW_TOOTH); }
        else if(event.getActionCommand().equals(Config.CMD_DRAW_TEXT))  {DrawingPanel.getInstance().setOperation(Config.CMD_DRAW_TEXT); }
        else if(event.getActionCommand().equals(Config.CMD_DRAW_BARGRAPH))  {new BarForm();}
        else if(event.getActionCommand().equals(Config.CMD_DRAW_PIECHART))  {new PieForm();}
        else if(event.getActionCommand().equals(Config.CMD_DRAW_LINEGRAPH)) {new LineForm();}
        else if(event.getActionCommand().equals(Config.CMD_DRAW_PROGRESSGRAPH)) {new ProgressForm();}
    }

   /* public void initColorPicker() {
        final JColorChooser chooser = new JColorChooser();

        GrayScalePanel gsp = new GrayScalePanel();
        chooser.addChooserPanel(gsp);
        chooser.setPreviewPanel(new CustomPane());
        dlgColPicker = JColorChooser.createDialog(this,
                "Choose Color For VeGEdit", true, chooser, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                DrawEnv.getInstance().setForeground(chooser.getColor());
                }
                }, null);
        dlgColPicker.setLocation(300, 300);
    }

    public void showColorPicker() {
        dlgColPicker.setVisible(true);
    }*/
    public static void main(String[] args) {
        new VegEdit();
    }
}
