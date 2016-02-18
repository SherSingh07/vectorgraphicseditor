import java.awt.*;
import java.awt.event.*;

class WBMoon extends WBShape{

	int size;

	public WBMoon (int x, int y, int w, int h,int size, Color col, boolean draw){
		super(x, y, w, h, col, draw);
		this.size = size;
	}

	WBMoon(WBMoon wbs){
		super(wbs.x, wbs.y, wbs.w, wbs.h, wbs.col, wbs.draw);
		this.size = wbs.size;
	}

	public String toXml(){ 
		String xml = "<WBMoon>";  
        xml += "<x>" + x + "</x>";
        xml += "<y>" + y + "</y>"; 
        xml += "<w>" + w + "</w>";
        xml += "<h>" + h + "</h>";
        xml += "<col>" + col.getRed() + "," + col.getGreen() + "," + col.getBlue()+ "</col>";
		xml += "<draw>" + draw + "</draw>";
		xml += "<size>" + size + "</size>";
		xml += "</WBMoon>";
		return xml;
	}


	public void draw(Graphics g){
		g.setColor(col);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(size));

		if(w<0) { x = x + w; w = w * -1; }
        if(h<0) { y = y + h; h = h * -1; }

		if(draw){
			g2d.drawArc(x, y, 2*w, h, 90, 180);
			g2d.drawArc(x+w/2, y, w, h, 90, 180);
		}
	/*	else{

			int ax[] = {x+w/4, x+(3*w)/4, x+(3*w)/4, x+w, x+w, x+(3*w)/4, x+(3*w)/4, x+w/4, x+w/4, x, x, x+w/4};
			int ay[] = {y, y, y+h/4, y+h/4, y+(3*h)/4, y+(3*h)/4, y+h, y+h, y+(3*h)/4, y+(3*h)/4, y+h/4, y+h/4};
			g.fillPolygon(ax, ay, 12);

		}*/
	}
	public String getName() {
        return "WBMoon";
    }
}
