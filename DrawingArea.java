/*
 *   __      __      ____   _____      _   _    _
 *   \ \    / /___  / ___| |  ___|    | | |_| _| |_
 *    \ \  / // _ \/ /  __ | |_     __| |  _ |_   _|
 *     \ \/ /|  ___ |  |_ \|  _|   / _  | | |  | |
 *      \  / | |____ \___|   |___ | |_| | | |  | |_
 *       \/   \____/\_____/|_____| \____| |_|  |___| 
 *
 * DrawingArea.java is the drawing area on which all shapes will be rendered.
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

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.util.Vector;
import java.io.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;

class DrawingPanel extends JPanel  implements MouseListener,MouseMotionListener {
    int x1=0, y1=0, x2=0, y2=0;

    String   op = Config.CMD_DRAW_RECTANGLE;
    Vector   vectDo;
    Vector   vectRedo;
    Font     defaultFont = null;
    WBShape  selectedShape = null;
    WBShape  copyShape = null;
	FileReader             fr;
	BufferedReader         in;
	BufferedWriter         out;
	OutputStreamWriter     Sw;

    private static DrawingPanel _instance = new DrawingPanel(); 
    private DrawingPanel() {
        super();
        vectDo   = new Vector();
        vectRedo = new Vector();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //return singleton
    public static DrawingPanel getInstance() { return _instance; } 

    public void mouseDragged(MouseEvent e) {
        x2=e.getX();
        y2=e.getY();

        dragShape(x2, y2, x2-x1, y2-y1);  
        repaint();
    }

    public void mouseMoved(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) {
        x1=e.getX();
        y1=e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        Color foreground = DrawEnv.getInstance().getForeground();
        int       ftSize = DrawEnv.getInstance().getFontSize();
        int      ftStyle = DrawEnv.getInstance().getFontStyle();
        String    ftName = DrawEnv.getInstance().getFontNames();
        int       StSize = DrawEnv.getInstance().getStrokeSizes();

        if(op.equals(Config.CMD_DRAW_RECTANGLE))   {vectDo.addElement(new WBRect(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_RECTANGLE))   {vectDo.addElement(new WBRect(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_OVAL))        {vectDo.addElement(new WBOval(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_OVAL))        {vectDo.addElement(new WBOval(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_ROUND_RECT))  {vectDo.addElement(new WBRoundRect(x1, y1, x2-x1, y2-y1, 20, 20,StSize, foreground, true)); vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_ROUND_RECT))  {vectDo.addElement(new WBRoundRect(x1, y1, x2-x1, y2-y1, 20, 20,StSize, foreground, false)); vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_LINE))        {vectDo.addElement(new WBLine(x1, y1, x2, y2,StSize, foreground)); vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_HSCROLL))     {vectDo.addElement(new WBScroll(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true)); vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_VSCROLL))     {vectDo.addElement(new WBScroll(x1, y1, x2-x1, y2-y1, 1,StSize, foreground, true)); vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_TRIANGLE))    {vectDo.addElement(new WBTriangle(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_TRIANGLE))    {vectDo.addElement(new WBTriangle(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_RHOMBUS))     {vectDo.addElement(new WBRhombus(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_PENTAGON))    {vectDo.addElement(new WBPentagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_PENTAGON))    {vectDo.addElement(new WBPentagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_HEXAGON))     {vectDo.addElement(new WBHexagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_HEXAGON))     {vectDo.addElement(new WBHexagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_OCTAGON))     {vectDo.addElement(new WBOctagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_OCTAGON))     {vectDo.addElement(new WBOctagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false));vectRedo.clear();}

        if(op.equals(Config.CMD_DRAW_HEART))       {vectDo.addElement(new WBHeart(x1, y1, x2-x1, y2-y1,StSize, foreground, true)); vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_HEART))       {vectDo.addElement(new WBHeart(x1, y1, x2-x1, y2-y1,StSize, foreground, false)); vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_STAR))        {vectDo.addElement(new WBStars(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_STAR))        {vectDo.addElement(new WBStars(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_MOON))        {vectDo.addElement(new WBMoon(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_CALL))        {vectDo.addElement(new WBCallOut(x1, y1, x2-x1, y2-y1,StSize, foreground, true));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_CALL))        {vectDo.addElement(new WBCallOut(x1, y1, x2-x1, y2-y1, StSize, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_CROSS))       {vectDo.addElement(new WBCross(x1, y1, x2-x1, y2-y1, StSize, foreground, false));vectRedo.clear();}

        if(op.equals(Config.CMD_FILL_RIGHTARROW))      {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 1, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_LEFTARROW))       {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 2, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_UPARROW))         {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 3, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_DOWNARROW))       {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 4, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_LEFTRIGHTARROW))  {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 5, foreground, false));vectRedo.clear();}
        if(op.equals(Config.CMD_FILL_UPDOWNARROW))     {vectDo.addElement(new WBArrow(x1, y1, x2-x1, y2-y1, 6, foreground, false));vectRedo.clear();}

        if(op.equals(Config.CMD_DRAW_SPIRAL))      {vectDo.addElement(new WBSpiral(x1, y1, x2-x1, x2-x1, StSize, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_TARGET))      {vectDo.addElement(new WBTarget(x1, y1, x2-x1, x2-x1, StSize, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_SMILE))     {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 1, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_SAD))       {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 2, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_WINK))      {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 3, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_CONFUSED))  {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 4, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_HAPPY))     {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 5, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_SMILEY_YINGYANG))  {vectDo.addElement(new WBSmileys(x1, y1, x2-x1, y2-y1, 8, foreground));vectRedo.clear();}

        if(op.equals(Config.CMD_FLOWCHART_PROCESS))           {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 1, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_ALTPROCESS))        {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 2, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_DECISION))          {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 3, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_DATA))              {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 4, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_PREDEFPROCESS))     {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 5, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_INTSTORAGE))        {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 6, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_TERMINATION))       {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 9, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_PREPARATION))       {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 10, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_MANINPUT))          {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 11, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_MANOPERATION))      {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 12, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_CONNECTOR))         {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 13, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_OFFPAGECONNECTOR))  {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 14, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_CARD))              {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 15, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_PUNCHEDTAPE))       {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 16, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_SUMMATION))         {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 17, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_OR))                {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 18, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_COLLATE))           {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 19, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_SORT))              {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 20, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_EXTRACT))           {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 21, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_MERGE))             {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 22, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_STOREDDATA))        {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 23, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_DELAY))             {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 24, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_SEQACSSTORAGE))     {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 25, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_MAGNETICDISK))      {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 26, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_DIRACSSTORAGE))     {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 27, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_FLOWCHART_DISPLAY))           {vectDo.addElement(new WBFlow(x1, y1, x2-x1, y2-y1, 28, foreground));vectRedo.clear();}

        if(op.equals(Config.CMD_DRAW_TEXT))        {vectDo.addElement(new WBString(x1, y1, x2-x1, y2-y1, TextContainer.getInstance().getText(), ftName, ftStyle, ftSize, foreground));vectRedo.clear();}
        if(op.equals(Config.CMD_DRAW_TOOTH))       {vectDo.addElement(new WBTooth(x1, y1, x2-x1, y2-y1, StSize, foreground));vectRedo.clear();}
        
		if(op.equals(Config.CMD_WIG_1))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/1.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_2))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/2.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_3))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/3.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_4))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/4.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_5))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/5.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_6))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/6.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_7))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/7.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_8))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/8.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_9))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/9.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_10))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/10.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_11))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/11.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_12))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/12.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_13))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/13.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_14))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/14.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_15))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/15.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_16))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/16.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_17))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/17.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_18))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/18.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_19))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/19.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_20))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/20.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_21))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/21.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_22))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/22.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_23))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/23.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_24))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/24.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_25))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/25.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_26))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/26.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_27))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/27.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_28))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/28.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_29))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/29.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_30))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/30.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_31))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/31.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_32))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/32.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_33))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/33.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_34))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/34.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_35))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/35.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_36))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/36.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_37))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/37.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_38))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/38.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_39))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/39.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_40))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/40.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_41))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/41.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_42))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/42.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_43))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/43.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_44))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/44.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_45))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/45.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_46))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/46.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_47))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/47.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_WIG_48))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/48.png")); vectRedo.clear(); }
        
		if(op.equals(Config.CMD_HAT_1))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/1.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_2))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/2.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_3))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/3.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_4))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/4.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_5))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/5.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_6))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/6.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_7))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/7.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_8))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/8.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_9))             {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/9.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_10))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/10.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_11))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/11.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_12))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/12.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_13))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/13.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_14))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/14.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_15))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/15.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_16))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/16.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_17))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/17.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_18))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/18.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_19))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/19.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_20))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/20.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_21))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/21.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_22))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/22.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_23))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/23.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_24))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/24.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_25))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/25.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_26))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/26.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_27))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/27.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_28))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/28.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_29))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/29.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_30))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/30.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_31))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/31.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_32))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/32.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_33))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/33.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_34))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/34.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_35))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/35.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_36))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/36.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_37))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/37.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_38))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/38.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_39))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/39.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_40))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/40.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_41))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/41.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_42))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/42.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_43))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/43.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_44))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/44.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_45))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/45.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_46))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/46.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_47))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/47.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_48))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/48.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_49))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/49.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_50))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/50.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_51))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/51.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_52))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/52.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_53))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/53.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_54))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/54.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_55))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/55.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_56))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/56.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_57))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/57.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_58))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/58.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_59))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/59.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_60))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/60.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_61))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/61.png")); vectRedo.clear(); }
        if(op.equals(Config.CMD_HAT_62))            {vectDo.addElement(new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/61.png")); vectRedo.clear(); }

		if(op.equals( Config.CMD_SELECT))          { vectRedo.clear(); selectShape(); }

        repaint();
        x1=0; x2=0;y1=0;y2=0;
    }
    public void mouseEntered(MouseEvent e) { } 
    public void mouseExited(MouseEvent e)  { }

    public void paint(Graphics g) {
        //get default graphics font
        if(defaultFont == null ) defaultFont = g.getFont();

        //cleanup background
        g.setColor(new Color(255, 255, 255));  
        g.fillRect(0, 0, getWidth(), getHeight());

        for(int i=0; i<vectDo.size();i++){
            WBShape ws = (WBShape)vectDo.elementAt(i);
            ws.draw(g);
            if(ws.isSelected()) ws.highlight(g);
        }

        previewCurShape(g);
    }

    private void previewCurShape(Graphics g) {
        Color foreground = DrawEnv.getInstance().getForeground();
        int StSize = DrawEnv.getInstance().getStrokeSizes();

        if(op.equals(Config.CMD_DRAW_RECTANGLE))   new WBRect(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_RECTANGLE))   new WBRect(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_OVAL))        new WBOval(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_OVAL))        new WBOval(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_ROUND_RECT))  new WBRoundRect(x1, y1, x2-x1, y2-y1, 20, 20,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_ROUND_RECT))  new WBRoundRect(x1, y1, x2-x1, y2-y1, 20, 20,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_LINE))        new WBLine(x1, y1, x2, y2,StSize, foreground).draw(g); 
        if(op.equals(Config.CMD_DRAW_VSCROLL))     new WBScroll(x1, y1, x2-x1, y2-y1, 1,StSize, foreground, true).draw(g); 
        if(op.equals(Config.CMD_DRAW_HSCROLL))     new WBScroll(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true).draw(g); 
        if(op.equals(Config.CMD_DRAW_TRIANGLE))    new WBTriangle(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_TRIANGLE))    new WBTriangle(x1, y1, x2-x1, y2-y1, 2, StSize,foreground, false).draw(g);
        if(op.equals(Config.CMD_FILL_RHOMBUS))     new WBRhombus(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_PENTAGON))    new WBPentagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_PENTAGON))    new WBPentagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_HEXAGON))     new WBHexagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_HEXAGON))     new WBHexagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_OCTAGON))     new WBOctagon(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_OCTAGON))     new WBOctagon(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_HEART))       new WBHeart(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_HEART))       new WBHeart(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_STAR))        new WBStars(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_STAR))        new WBStars(x1, y1, x2-x1, y2-y1, 2,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_MOON))        new WBMoon(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_DRAW_CALL))        new WBCallOut(x1, y1, x2-x1, y2-y1,StSize, foreground, true).draw(g);
        if(op.equals(Config.CMD_FILL_CALL))        new WBCallOut(x1, y1, x2-x1, y2-y1,StSize, foreground, false).draw(g);
        if(op.equals(Config.CMD_DRAW_SPIRAL))      new WBSpiral(x1, y1, x2-x1, x2-x1,StSize, foreground).draw(g);
        if(op.equals(Config.CMD_DRAW_TARGET))      new WBTarget(x1, y1, x2-x1, x2-x1,StSize, foreground).draw(g);
        if(op.equals(Config.CMD_FILL_CROSS))       new WBCross(x1, y1, x2-x1, y2-y1,StSize, foreground,false).draw(g);

        if(op.equals(Config.CMD_FILL_RIGHTARROW))     new WBArrow(x1, y1, x2-x1, y2-y1, 1, foreground,false).draw(g);
        if(op.equals(Config.CMD_FILL_LEFTARROW))     new WBArrow(x1, y1, x2-x1, y2-y1, 2, foreground,false).draw(g);
        if(op.equals(Config.CMD_FILL_UPARROW))        new WBArrow(x1, y1, x2-x1, y2-y1, 3, foreground,false).draw(g);
        if(op.equals(Config.CMD_FILL_DOWNARROW))	  new WBArrow(x1, y1, x2-x1, y2-y1, 4, foreground,false).draw(g);
        if(op.equals(Config.CMD_FILL_LEFTRIGHTARROW)) new WBArrow(x1, y1, x2-x1, y2-y1, 5, foreground,false).draw(g);
        if(op.equals(Config.CMD_FILL_UPDOWNARROW))    new WBArrow(x1, y1, x2-x1, y2-y1, 6, foreground,false).draw(g);

        if(op.equals(Config.CMD_SMILEY_SMILE))     new WBSmileys(x1, y1, x2-x1, y2-y1,1, foreground).draw(g);
        if(op.equals(Config.CMD_SMILEY_SAD))       new WBSmileys(x1, y1, x2-x1, y2-y1,2, foreground).draw(g);
        if(op.equals(Config.CMD_SMILEY_WINK))      new WBSmileys(x1, y1, x2-x1, y2-y1,3, foreground).draw(g);
        if(op.equals(Config.CMD_SMILEY_CONFUSED))  new WBSmileys(x1, y1, x2-x1, y2-y1,4, foreground).draw(g);
        if(op.equals(Config.CMD_SMILEY_HAPPY))     new WBSmileys(x1, y1, x2-x1, y2-y1,5, foreground).draw(g);
        if(op.equals(Config.CMD_SMILEY_YINGYANG))  new WBSmileys(x1, y1, x2-x1, y2-y1,8, foreground).draw(g);

        if(op.equals(Config.CMD_FLOWCHART_PROCESS))            new WBFlow(x1, y1, x2-x1, y2-y1, 1, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_ALTPROCESS))         new WBFlow(x1, y1, x2-x1, y2-y1, 2, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_DECISION))           new WBFlow(x1, y1, x2-x1, y2-y1, 3, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_DATA))               new WBFlow(x1, y1, x2-x1, y2-y1, 4, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_PREDEFPROCESS))      new WBFlow(x1, y1, x2-x1, y2-y1, 5, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_INTSTORAGE))         new WBFlow(x1, y1, x2-x1, y2-y1, 6, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_TERMINATION))        new WBFlow(x1, y1, x2-x1, y2-y1, 9, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_PREPARATION))        new WBFlow(x1, y1, x2-x1, y2-y1, 10, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_MANINPUT))           new WBFlow(x1, y1, x2-x1, y2-y1, 11, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_MANOPERATION))       new WBFlow(x1, y1, x2-x1, y2-y1, 12, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_CONNECTOR))          new WBFlow(x1, y1, x2-x1, y2-y1, 13, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_OFFPAGECONNECTOR))   new WBFlow(x1, y1, x2-x1, y2-y1, 14, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_CARD))               new WBFlow(x1, y1, x2-x1, y2-y1, 15, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_PUNCHEDTAPE))        new WBFlow(x1, y1, x2-x1, y2-y1, 16, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_SUMMATION))          new WBFlow(x1, y1, x2-x1, y2-y1, 17, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_OR))                 new WBFlow(x1, y1, x2-x1, y2-y1, 18, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_COLLATE))            new WBFlow(x1, y1, x2-x1, y2-y1, 19, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_SORT))               new WBFlow(x1, y1, x2-x1, y2-y1, 20, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_EXTRACT))            new WBFlow(x1, y1, x2-x1, y2-y1, 21, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_MERGE))              new WBFlow(x1, y1, x2-x1, y2-y1, 22, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_STOREDDATA))         new WBFlow(x1, y1, x2-x1, y2-y1, 23, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_DELAY))              new WBFlow(x1, y1, x2-x1, y2-y1, 24, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_SEQACSSTORAGE))      new WBFlow(x1, y1, x2-x1, y2-y1, 25, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_MAGNETICDISK))       new WBFlow(x1, y1, x2-x1, y2-y1, 26, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_DIRACSSTORAGE))      new WBFlow(x1, y1, x2-x1, y2-y1, 27, foreground).draw(g);
        if(op.equals(Config.CMD_FLOWCHART_DISPLAY))            new WBFlow(x1, y1, x2-x1, y2-y1, 28, foreground).draw(g);

        if(op.equals(Config.CMD_DRAW_TOOTH))        new WBTooth(x1, y1, x2-x1, y2-y1,StSize, foreground).draw(g);
        if(op.equals(Config.CMD_WIG_1))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/1.png").draw(g);
        if(op.equals(Config.CMD_WIG_2))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/2.png").draw(g);
        if(op.equals(Config.CMD_WIG_3))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/3.png").draw(g);
        if(op.equals(Config.CMD_WIG_4))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/4.png").draw(g);
        if(op.equals(Config.CMD_WIG_5))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/5.png").draw(g);
        if(op.equals(Config.CMD_WIG_6))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/6.png").draw(g);
        if(op.equals(Config.CMD_WIG_7))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/7.png").draw(g);
        if(op.equals(Config.CMD_WIG_8))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/8.png").draw(g);
        if(op.equals(Config.CMD_WIG_9))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/9.png").draw(g);
        if(op.equals(Config.CMD_WIG_10))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/10.png").draw(g);
        if(op.equals(Config.CMD_WIG_11))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/11.png").draw(g);
        if(op.equals(Config.CMD_WIG_12))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/12.png").draw(g);
        if(op.equals(Config.CMD_WIG_13))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/13.png").draw(g);
        if(op.equals(Config.CMD_WIG_14))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/14.png").draw(g);
        if(op.equals(Config.CMD_WIG_15))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/15.png").draw(g);
        if(op.equals(Config.CMD_WIG_16))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/16.png").draw(g);
        if(op.equals(Config.CMD_WIG_17))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/17.png").draw(g);
        if(op.equals(Config.CMD_WIG_18))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/18.png").draw(g);
        if(op.equals(Config.CMD_WIG_19))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/19.png").draw(g);
        if(op.equals(Config.CMD_WIG_20))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/20.png").draw(g);
        if(op.equals(Config.CMD_WIG_21))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/21.png").draw(g);
        if(op.equals(Config.CMD_WIG_22))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/22.png").draw(g);
        if(op.equals(Config.CMD_WIG_23))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/23.png").draw(g);
        if(op.equals(Config.CMD_WIG_24))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/24.png").draw(g);
        if(op.equals(Config.CMD_WIG_25))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/25.png").draw(g);
        if(op.equals(Config.CMD_WIG_26))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/26.png").draw(g);
        if(op.equals(Config.CMD_WIG_27))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/27.png").draw(g);
        if(op.equals(Config.CMD_WIG_28))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/28.png").draw(g);
        if(op.equals(Config.CMD_WIG_29))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/29.png").draw(g);
        if(op.equals(Config.CMD_WIG_30))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/30.png").draw(g);
        if(op.equals(Config.CMD_WIG_31))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/31.png").draw(g);
        if(op.equals(Config.CMD_WIG_32))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/32.png").draw(g);
        if(op.equals(Config.CMD_WIG_33))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/33.png").draw(g);
        if(op.equals(Config.CMD_WIG_34))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/34.png").draw(g);
        if(op.equals(Config.CMD_WIG_35))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/35.png").draw(g);
        if(op.equals(Config.CMD_WIG_36))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/36.png").draw(g);
        if(op.equals(Config.CMD_WIG_37))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/37.png").draw(g);
        if(op.equals(Config.CMD_WIG_38))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/38.png").draw(g);
        if(op.equals(Config.CMD_WIG_39))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/39.png").draw(g);
        if(op.equals(Config.CMD_WIG_40))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/40.png").draw(g);
        if(op.equals(Config.CMD_WIG_41))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/41.png").draw(g);
        if(op.equals(Config.CMD_WIG_42))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/42.png").draw(g);
        if(op.equals(Config.CMD_WIG_43))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/43.png").draw(g);
        if(op.equals(Config.CMD_WIG_44))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/44.png").draw(g);
        if(op.equals(Config.CMD_WIG_45))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/45.png").draw(g);
        if(op.equals(Config.CMD_WIG_46))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/46.png").draw(g);
        if(op.equals(Config.CMD_WIG_47))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/47.png").draw(g);
        if(op.equals(Config.CMD_WIG_48))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/wigs/48.png").draw(g);
		
		if(op.equals(Config.CMD_HAT_1))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/1.png").draw(g);
        if(op.equals(Config.CMD_HAT_2))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/2.png").draw(g);
        if(op.equals(Config.CMD_HAT_3))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/3.png").draw(g);
        if(op.equals(Config.CMD_HAT_4))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/4.png").draw(g);
        if(op.equals(Config.CMD_HAT_5))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/5.png").draw(g);
        if(op.equals(Config.CMD_HAT_6))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/6.png").draw(g);
        if(op.equals(Config.CMD_HAT_7))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/7.png").draw(g);
        if(op.equals(Config.CMD_HAT_8))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/8.png").draw(g);
        if(op.equals(Config.CMD_HAT_9))             new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/9.png").draw(g);
        if(op.equals(Config.CMD_HAT_10))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/10.png").draw(g);
        if(op.equals(Config.CMD_HAT_11))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/11.png").draw(g);
        if(op.equals(Config.CMD_HAT_12))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/12.png").draw(g);
        if(op.equals(Config.CMD_HAT_13))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/13.png").draw(g);
        if(op.equals(Config.CMD_HAT_14))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/14.png").draw(g);
        if(op.equals(Config.CMD_HAT_15))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/15.png").draw(g);
        if(op.equals(Config.CMD_HAT_16))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/16.png").draw(g);
        if(op.equals(Config.CMD_HAT_17))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/17.png").draw(g);
        if(op.equals(Config.CMD_HAT_18))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/18.png").draw(g);
        if(op.equals(Config.CMD_HAT_19))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/19.png").draw(g);
        if(op.equals(Config.CMD_HAT_20))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/20.png").draw(g);
        if(op.equals(Config.CMD_HAT_21))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/21.png").draw(g);
        if(op.equals(Config.CMD_HAT_22))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/22.png").draw(g);
        if(op.equals(Config.CMD_HAT_23))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/23.png").draw(g);
        if(op.equals(Config.CMD_HAT_24))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/24.png").draw(g);
        if(op.equals(Config.CMD_HAT_25))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/25.png").draw(g);
        if(op.equals(Config.CMD_HAT_26))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/26.png").draw(g);
        if(op.equals(Config.CMD_HAT_27))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/27.png").draw(g);
        if(op.equals(Config.CMD_HAT_28))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/28.png").draw(g);
        if(op.equals(Config.CMD_HAT_29))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/29.png").draw(g);
        if(op.equals(Config.CMD_HAT_30))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/30.png").draw(g);
        if(op.equals(Config.CMD_HAT_31))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/31.png").draw(g);
        if(op.equals(Config.CMD_HAT_32))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/32.png").draw(g);
        if(op.equals(Config.CMD_HAT_33))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/33.png").draw(g);
        if(op.equals(Config.CMD_HAT_34))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/34.png").draw(g);
        if(op.equals(Config.CMD_HAT_35))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/35.png").draw(g);
        if(op.equals(Config.CMD_HAT_36))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/36.png").draw(g);
        if(op.equals(Config.CMD_HAT_37))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/37.png").draw(g);
        if(op.equals(Config.CMD_HAT_38))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/38.png").draw(g);
        if(op.equals(Config.CMD_HAT_39))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/39.png").draw(g);
        if(op.equals(Config.CMD_HAT_40))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/40.png").draw(g);
        if(op.equals(Config.CMD_HAT_41))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/41.png").draw(g);
        if(op.equals(Config.CMD_HAT_42))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/42.png").draw(g);
        if(op.equals(Config.CMD_HAT_43))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/43.png").draw(g);
        if(op.equals(Config.CMD_HAT_44))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/44.png").draw(g);
        if(op.equals(Config.CMD_HAT_45))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/45.png").draw(g);
        if(op.equals(Config.CMD_HAT_46))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/46.png").draw(g);
        if(op.equals(Config.CMD_HAT_47))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/47.png").draw(g);
        if(op.equals(Config.CMD_HAT_48))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/48.png").draw(g);
        if(op.equals(Config.CMD_HAT_49))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/49.png").draw(g);
        if(op.equals(Config.CMD_HAT_50))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/50.png").draw(g);
        if(op.equals(Config.CMD_HAT_51))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/51.png").draw(g);
        if(op.equals(Config.CMD_HAT_52))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/52.png").draw(g);
        if(op.equals(Config.CMD_HAT_53))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/53.png").draw(g);
        if(op.equals(Config.CMD_HAT_54))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/54.png").draw(g);
        if(op.equals(Config.CMD_HAT_55))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/55.png").draw(g);
        if(op.equals(Config.CMD_HAT_56))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/56.png").draw(g);
        if(op.equals(Config.CMD_HAT_57))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/57.png").draw(g);
        if(op.equals(Config.CMD_HAT_58))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/58.png").draw(g);
        if(op.equals(Config.CMD_HAT_59))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/59.png").draw(g);
        if(op.equals(Config.CMD_HAT_60))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/60.png").draw(g);
        if(op.equals(Config.CMD_HAT_61))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/61.png").draw(g);
        if(op.equals(Config.CMD_HAT_62))            new WBImage(x1, y1, x2-x1, y2-y1, foreground,"images/hats/62.png").draw(g);

    }

    public void dragShape(int x, int y, int dx, int dy){	   
        
        /*no need to continue if operation is not select*/
        if(!op.equals(Config.CMD_SELECT)) return;

        /*no need to continue if no shape is selected*/
        if(selectedShape == null) return; 

        /*no need to continue if mouse is not clicked on the selected shape*/	
        if(!selectedShape.hasXY(x, y)) return; 

        /*drag the trapped shape now !!!! (*_*) */
        selectedShape.drag(x, y);
    }

    public void addPicture(String imgPath) {
        setOperation(Config.CMD_DRAW_PICTURE);
        vectDo.addElement(new WBPicture(100, 100, imgPath));
        repaint();
    }

    public void drawBarGraph(int x, int y, int w, int h, Color col, String s){
        setOperation(Config.CMD_DRAW_BARGRAPH);
        vectDo.addElement(new WBBarGraph(x, y, w, h, col, s));
        repaint();
    }

    public void drawLinegraph(int x, int y, int w, int h, Color col, String s){
        setOperation(Config.CMD_DRAW_LINEGRAPH);
        vectDo.addElement(new WBLineGraph(x, y, w, h, col, s));
        repaint();
    }

    public void drawPieChart(int x, int y, int w, String s){
        setOperation(Config.CMD_DRAW_PIECHART);
        vectDo.addElement(new WBPieChart(x, y, w, s));
        repaint();
    }

    public void drawProgressGraph(int x, int y, int w, int h, Color col, String s){
        setOperation(Config.CMD_DRAW_PROGRESSGRAPH);
        vectDo.addElement(new WBProgressGraph(x, y, w, h, col, s));
        repaint();
    }


    public void setOperation(String op) { 
        this.op = op;
        if(op.equals( Config.CMD_SELECT)|| op.equals( Config.CMD_COPY)){ setCursor(new Cursor(Cursor.HAND_CURSOR));}
        else                         { setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}

        // we must deselect all shapes whenan operation is set
        for(int i=0; i<vectDo.size();i++){
            ((WBShape)vectDo.elementAt(i)).deselect();
        }
        selectedShape = null;
        repaint();
    }

    public void undo() { 
        if(vectDo.size() == 0) return;
        vectRedo.addElement( vectDo.elementAt(vectDo.size()-1));
        vectDo.removeElementAt(vectDo.size()-1);
        repaint();
    }

    public void redo() { 
        if(vectRedo.size() == 0) return;
        WBShape ws = (WBShape)vectRedo.elementAt(vectRedo.size()-1);

        //we must deselect a shape when we restore it with redo
        ws.deselect();
        vectDo.addElement(ws);
        vectRedo.removeElementAt(vectRedo.size()-1);
        repaint();
    }

    public void selectShape(){

        WBShape ws = null;
        for(int i = vectDo.size()-1; i>=0; i--){
            ws = (WBShape) vectDo.elementAt(i);
            if(ws.hasXY(x1, y1))    {
                ws.select(); 
                selectedShape = ws;
                break;
            }
        }

        if(ws == null) return;

        for(int i = 0; i < vectDo.size(); i++){
            WBShape ws1 = (WBShape) vectDo.elementAt(i);
            if(ws != ws1)    {ws1.deselect();}
        }

    }

    public void copyShape(){
        this.op   = Config.CMD_COPY;
        copyShape = WBShape.clone(selectedShape);	
        copyShape.setXY(0, 0);
		ClipBoard.getInstance().setShape(copyShape);
        selectedShape.deselect();
        selectedShape = null;
        repaint(); 
    }

    public void pasteShape(){
        this.op   = Config.CMD_PASTE;
        if (copyShape == null){ return;	}
        vectDo.addElement(copyShape);
        repaint();
    }
    public void save() {
        // Create an image to save
        RenderedImage rendImage = myCreateImage();

        // Write generated image to a file
        try {
            // Save as PNG
            File file = new File("newimage.png");
            ImageIO.write(rendImage, "png", file);

            // Save as JPEG
            file = new File("newimage.jpg");
            ImageIO.write(rendImage, "jpg", file);
        } catch (IOException e) {
            System.out.println("Save Exception: " + e);
        }

		saveVeg();
    }

    public void saveVeg() {
	  //fetch all shapes from the vecotor and call their toXml fn.
	  //get xml val and wrtie into noname.veg file
	  
	  //open file noname.veg

	  	try{
			File file = new File("noname.veg");
			OutputStream f = new FileOutputStream(file, false);
			Sw             = new OutputStreamWriter(f);  
			out            = new BufferedWriter(Sw);

			for(int i=0; i<vectDo.size();i++){
            WBShape ws = (WBShape)vectDo.elementAt(i);
			String xml = ws.toXml();
            int length = xml.length();
			
			//write xml in file

			Sw.write(xml, 0, length);
		    }
			Sw.flush();
			f.close();
			Sw.close();
			out.close();
			
		}
		catch(Exception e){System.out.println(e);}





      //close file

	}

    // Returns a generated image.
    public RenderedImage myCreateImage() {

        int width  = getWidth();
        int height = getHeight();

        /* Create a buffered image in which to draw */
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        /* Create a graphics contents on the buffered image */
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        for(int i=0; i<vectDo.size();i++){
            WBShape ws = (WBShape)vectDo.elementAt(i);
            ws.draw(g2d);
        }

        g2d.setColor(Color.RED);
        g2d.setFont(defaultFont);
        g2d.drawString("Generated By VegEdit By WeaveBytes", (getWidth()*5)/8, getHeight() - 50);

        // Graphics context no longer needed so dispose it
        g2d.dispose();

        return bufferedImage;

    }
}//DrawingPanel

public class DrawingArea extends JPanel implements AdjustmentListener {

    DrawingPanel dp;
    JScrollBar hbar; 
    JScrollBar vbar;
    int hVal = 0;
    int vVal = 0;

    public DrawingArea() {
        super(true);
        dp = DrawingPanel.getInstance();
        //dp.setSize(600, 600);
        //setSize(600, 600);
        dp.setBackground(new Color(70, 55, 25));
        setLayout(new BorderLayout());

        JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 20, 0, 300);
        JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 0, 40, 0, 300);

        hbar.setUnitIncrement(2);
        hbar.setBlockIncrement(1);

        hbar.addAdjustmentListener(this);
        vbar.addAdjustmentListener(this);

        add(hbar, BorderLayout.SOUTH);
        add(vbar, BorderLayout.EAST);
        add(dp, BorderLayout.CENTER);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        Point p = dp.getLocation();

        String type="";
        String src="";
        if(e.getAdjustable().getOrientation() == Adjustable.HORIZONTAL) {
            p.x  = p.x - e.getValue() + hVal;
            hVal = e.getValue();
        }
        if(e.getAdjustable().getOrientation() == Adjustable.VERTICAL) {
            p.y  = p.y - e.getValue() + vVal;
            vVal = e.getValue();
        }
        dp.setLocation(p);
        dp.repaint();
    }

    //sample usage of drawing area
    public static void main(String s[]) {
        JFrame frame = new JFrame("Scroll Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new SwingScrollBarExample());
        frame.setLayout(null);

        frame.add(new DrawingArea());
        frame.setSize(900, 800);
        frame.setVisible(true);
    }

}//DrawingArea

