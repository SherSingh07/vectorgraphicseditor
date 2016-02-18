import java.awt.*;
import java.awt.event.*;

class WBFlow extends WBShape{

	int type;

	WBFlow(int x, int y, int w, int h, int type, Color col){
		super(x, y, w, h, col, false);
		this.type = type;
	}

	WBFlow(WBFlow wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.type = wbs.type;
	}

	public String toXml(){ 
		String xml = "<WBFlow>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<type>" + draw + "</type>";
		xml += "</WBFlow>";
		return xml;
	}


	public void draw(Graphics g){
		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		g.setColor(col);
			switch(type){
				// Process
				case 1 :
					g.drawRect(x, y, w, h);
					break;
				// Alternate Process
				case 2:
					g.drawRoundRect(x, y, w, h, 20, 20);
					break;
				// Decision
				case 3:
					int[]ax = {x + (w/2), x + w, x + (w/2), x}; 
					int[]ay = {y, y+h/2, y+h, y+h/2};
					g.drawPolygon(ax, ay, 4);	
					break;
				// Data
				case 4:
					int[]ax1 = {x+w/6, x+w, x+(5*w)/6, x}; 
					int[]ay1 = {y, y, y+h, y+h};
					g.drawPolygon(ax1, ay1, 4);
					break;
				// Predefined Process
				case 5:
					g.drawRect(x, y, w, h);
					g.drawLine(x+w/8, y, x+w/8, y+h);
					g.drawLine(x+(7*w)/8, y, x+(7*w)/8, y+h);
					break;
				// Internal Storage
				case 6:
					g.drawRect(x, y, w, h);
					g.drawLine(x+w/8, y, x+w/8, y+h);
					g.drawLine(x, y+h/8, x+w, y+h/8);
					break;
				// Document
				// Multi Document
				//Termination
				case 9:
					g.drawLine(x+w/8, y, x+(7*w)/8, y);
					g.drawLine(x+w/8, y+h, x+(7*w)/8, y+h);
					g.drawArc(x, y, w/4, h, 90, 180);
					g.drawArc(x+(3*w)/4, y, w/4, h, 270, 180);
					break;
				// Preparation
				case 10:
					int ax10[] = {x+w/4, x+(3*w)/4, x+w, x+(3*w)/4, x+w/4, x};
					int ay10[] = {y, y, y+h/2, y+h, y+h, y+h/2};
					g.drawPolygon(ax10, ay10 ,6);
					break;
				// Manual Input
				case 11:
					int ax11[] = {x, x+w, x+w, x};
					int ay11[] = {y+h/6, y, y+h, y+h};
					g.drawPolygon(ax11, ay11, 4);
					break;
				// Manual Operation
				case 12:
					int ax12[] = {x, x+w, x+(5*w)/6, x+w/6};
					int ay12[] = {y, y, y+h, y+h};
					g.drawPolygon(ax12, ay12, 4);
					break;
				// Connection
				case 13:
					g.drawOval(x, y, w, h);
					break;
				// Off-Page Connection
				case 14:
					int ax14[] = {x, x+w, x+w, x+w/2, x};
					int ay14[] = {y, y, y+(5*w)/6, y+h, y+(5*w)/6};
					
					g.drawPolygon(ax14, ay14, 5);
					break;
				//Card
				case 15:
					int ax15[] = {x+w/6, x+w, x+w, x, x};
					int ay15[] = {y, y, y+h, y+h, y+h/6};

					g.drawPolygon(ax15, ay15, 5);
					break;
				// Punched Tape
				case 16:
					g.drawLine(x, y+h/12, x, y+(11*h)/12);
					g.drawLine(x+w, y+h/12, x+w, y+(11*h)/12);

					g.drawArc(x, y, w/2, h/6, 180, 180);
					g.drawArc(x, y+(5*h)/6, w/2, h/6, 180, 180);
					g.drawArc(x+w/2, y, w/2, h/6, 0, 180);
					g.drawArc(x+w/2, y+(5*h)/6, w/2, h/6, 0, 180);
					break;
				//Summation
				case 17:
					g.drawOval(x, y, w, h);
					g.drawLine(x+(15*w)/100, y+(15*h)/100, x+(85*w)/100, y+(85*h)/100);
					g.drawLine(x+(15*w)/100, y+(85*h)/100, x+(85*w)/100, y+(15*h)/100);
					break;
				//Or
				case 18:
					g.drawOval(x, y, w, h);
					g.drawLine(x+w/2, y, x+w/2, y+h);
					g.drawLine(x, y+h/2, x+w, y+h/2);
					break;
				//Collate
				case 19:
					int ax19[] = {x, x+w, x, x+w};
					int ay19[] = {y, y, y+h, y+h};

					g.drawPolygon(ax19, ay19, 4);
					break;
				// Sort
				case 20:
					int[]ax20 = {x + (w/2), x + w, x + (w/2), x}; 
					int[]ay20= {y, y+h/2, y+h, y+h/2};
					g.drawPolygon(ax20, ay20, 4);
					
					g.drawLine(x, y+h/2, x+w, y+h/2);
					break;
				// Extract
				case 21:
					int[]ax21 = {x + (w/2), x + w, x}; 
					int[]ay21 = {y, y+h, y+h};
					g.drawPolygon(ax21, ay21, 3);
					break;
				// Merge
				case 22:
					int ax22[] = {x, x+w, x+w/2};
					int ay22[] = {y, y, y+h};
					g.drawPolygon(ax22, ay22, 3);
					break;
				// Stored Data
				case 23:
					g.drawLine(x+w/8, y, x+w, y);
					g.drawLine(x+w/8,y+h, x+w, y+h);
					g.drawArc(x, y, w/4,h, 90, 180);
					g.drawArc(x+(7*w)/8, y, w/4,h, 90, 180);
					break;
				// Delay
				case 24:
					g.drawLine(x, y, x+w/2, y);
					g.drawLine(x, y, x, y+h);
					g.drawLine(x, y+h, x+w/2, y+h);
					g.drawArc(x, y, w, h, 270, 180);
					break;
				// Sequential Access Storage
				case 25:
					g.drawArc(x, y, w, h, 330, 300);
					g.drawLine(x+w/2, y+h, x+w, y+h);
					//d.drawLine(x+(w*93)/100, y+);
					break;
				// Magnetic Disk
				case 26:
					g.drawArc(x, y+(3*h)/4, w, h/4, 180, 180);
					g.drawLine(x, y+h/8, x, y+(7*h)/8);
					g.drawLine(x+w, y+h/8, x+w, y+(7*h)/8);
					g.drawOval(x, y, w, h/4);
					break;
				// Direct Access Storage
				case 27:
					g.drawArc(x, y, w/4, h, 90, 180);
					g.drawLine(x+w/8, y, x+(7*w)/8, y);
					g.drawLine(x+w/8, y+h, x+(7*w)/8, y+h);
					g.drawOval(x+(3*w)/4, y, w/4, h);
					break;
				// Display
				case 28:
					g.drawLine(x+w/4, y, x+(3*w)/4, y);
					g.drawLine(x+w/4, y, x, y+h/2);
					g.drawLine(x, y+h/2, x+w/4, y+h);
					g.drawLine(x+w/4, y+h, x+(3*w)/4, y+h);
					g.drawArc(x+w/2, y, w/2, h, 270, 180);
					break;
		}
	}
	
	public String getName() {
        return "WBFlow";
    }
}
