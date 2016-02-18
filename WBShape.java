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
import java.awt.*;
import java.awt.event.*;

public class WBShape {
    int x, y, w, h;
    Color col;
    boolean draw;
    boolean selected;
    boolean firstDrag;

    int dx1, dx2, dy1, dy2;

    public WBShape(int x, int y, int w, int h, Color col, boolean draw){
        this.x   = x;
        this.y   = y;
        this.w   = w;
        this.h   = h;	
        this.col = col;
        this.draw = draw;
        firstDrag=false;
        dx1=0;
        dx2=0;
        dy1=0;
        dy2=0;
    }

    public WBShape(WBShape wbs) {
        this.x    = wbs.x;
        this.y    = wbs.y;
        this.w    = wbs.w;
        this.h    = wbs.h;	
        this.col  = wbs.col;
        this.draw = wbs.draw;
        firstDrag=false;
        dx1=0;
        dx2=0;
        dy1=0;
        dy2=0;
    }

    public void draw(Graphics g){}
    public String toXml(){ return "<WBShape></WBShape>";}


    public void highlight(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(x, y, w, h);

        // To Do :- draw the dotted Rectangle	
    }

    public boolean hasXY(int xS, int yS){
        if(xS<x+w && xS>x && yS<y+h && yS>y) return true;
        return false;
    }


    public void select()         { selected = true; firstDrag=true; }
    public void deselect()       { selected = false; firstDrag=false; }
    public boolean isSelected()  { return selected; }

    public void setX (int x)          {this.x = x; }
    public void setY (int y)          {this.y = y; }
    public void setXY(int x, int y)   {setX(x);  setY(y);}

	public void setW (int w)          {this.w = w; }
    public void setH (int h)          {this.h = h; }
    public void setWH(int w, int h)   {setW(w);  setH(h);}


    public void incX (int delta)      {x+=delta;}
    public void incY (int delta)      {y+=delta;}
    public void incXY(int dx, int dy) {	
        incX(dx); incY(dy);
    }


    public void drag(int dragX, int dragY) {	
        if(firstDrag) { dx1=dragX; dx2=dragX; dy1=dragY; dy2=dragY; firstDrag=false;}
        else                { dx2=dragX; dy2=dragY;}
        incXY(dx2-dx1, dy2-dy1);
        dx1=dx2;
        dy1=dy2;
    }

    static public WBShape clone(WBShape wbs) {
        if(wbs.getName().equals("WBArrow"))          return new WBArrow((WBArrow) wbs);
        else if(wbs.getName().equals("WBBevel"))     return new WBBevel((WBBevel) wbs);
        else if(wbs.getName().equals("WBCallOut"))   return new WBCallOut((WBCallOut) wbs);
        else if(wbs.getName().equals("WBCross"))     return new WBCross((WBCross) wbs);
        else if(wbs.getName().equals("WBFlow"))      return new WBFlow((WBFlow) wbs);
        else if(wbs.getName().equals("WBHeart"))     return new WBHeart((WBHeart) wbs);
        else if(wbs.getName().equals("WBLine"))      return new WBLine((WBLine) wbs);
        else if(wbs.getName().equals("WBMoon"))      return new WBMoon((WBMoon) wbs);
        else if(wbs.getName().equals("WBOctagon"))   return new WBOctagon((WBOctagon) wbs);
        else if(wbs.getName().equals("WBOval"))      return new WBOval((WBOval) wbs);
        else if(wbs.getName().equals("WBPentagon"))  return new WBPentagon((WBPentagon) wbs);
        else if(wbs.getName().equals("WBPrllogrm"))  return new WBPrllogrm((WBPrllogrm) wbs);
        else if(wbs.getName().equals("WBRect"))      return new WBRect((WBRect) wbs);
        else if(wbs.getName().equals("WBRhombus"))   return new WBRhombus((WBRhombus) wbs);
        else if(wbs.getName().equals("WBRoundRect")) return new WBRoundRect((WBRoundRect) wbs);
        else if(wbs.getName().equals("WBSmileys"))   return new WBSmileys((WBSmileys) wbs);
        else if(wbs.getName().equals("WBSpiral"))    return new WBSpiral((WBSpiral) wbs);
        else if(wbs.getName().equals("WBStars"))     return new WBStars((WBStars) wbs);
        else if(wbs.getName().equals("WBTarget"))    return new WBTarget((WBTarget) wbs);
        else if(wbs.getName().equals("WBTooth"))     return new WBTooth((WBTooth) wbs);
        else if(wbs.getName().equals("WBTriangle"))  return new WBTriangle((WBTriangle) wbs);
		else if(wbs.getName().equals("WBImage")) return new WBImage((WBImage) wbs);
        else if(wbs.getName().equals("WBPicture"))   return new WBPicture((WBPicture) wbs);

        return new WBShape(wbs);
    }

    public String getName() {
        return "WBShape";
    }
}
