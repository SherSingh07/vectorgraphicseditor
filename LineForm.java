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
import javax.swing.*;
import java.awt.event.*;

class LineForm extends JFrame implements ActionListener {
	JLabel     lblX;
	JLabel     lblY;
	JLabel     lblW;
	JLabel     lblH;
	JLabel     lblValues;
	JTextField tfX;
	JTextField tfY;
	JTextField tfW;
	JTextField tfH;
	JTextField tfValues;
	JButton    btnDraw;

	int hgap = 20;
	int vgap = 20;
	

	LineForm(){
		super("Graph values");
		setLayout(null);
		
		lblX      = new JLabel("X :");
		lblY      = new JLabel("Y :");
		lblW      = new JLabel("W :");
		lblH      = new JLabel("H :");
		lblValues = new JLabel("Values :");
		
		lblX.setBounds(hgap, vgap, 50, vgap);
		lblY.setBounds(hgap, 3*vgap, 50, vgap);
		lblW.setBounds(hgap, 5*vgap, 50, vgap);
		lblH.setBounds(hgap, 7*vgap, 50, vgap);
		lblValues.setBounds(hgap, 9*vgap, 50, vgap);

		add(lblX);
		add(lblY);
		add(lblW);
		add(lblH);
		add(lblValues);

		tfX      = new JTextField();
		tfY      = new JTextField();
		tfW      = new JTextField();
		tfH      = new JTextField();
		tfValues = new JTextField();

		tfX.setBounds(hgap+50, vgap, 140, vgap);
		tfY.setBounds(hgap+50, 3*vgap, 140, vgap);
		tfW.setBounds(hgap+50, 5*vgap, 140, vgap);
		tfH.setBounds(hgap+50, 7*vgap, 140, vgap);
		tfValues.setBounds(hgap+50, 9*vgap, 140, vgap);

		add(tfX);
		add(tfY);
		add(tfW);
		add(tfH);
		add(tfValues);

		btnDraw = new JButton("Draw");
		btnDraw.setBounds(75, 11*vgap, 100, vgap);
		add(btnDraw);
		btnDraw.addActionListener(this);

		setVisible(true);
		setSize(250, 300);
	}

	public void actionPerformed(ActionEvent ae){
		DrawingPanel.getInstance().drawLinegraph(X(),Y(),W(),H(),Color.RED, getValues());
		setVisible(false);
	}

	public int X(){
		int X = Integer.parseInt((String)tfX.getText());
		return X;
	}

	public int Y(){
		int Y = Integer.parseInt((String)tfY.getText());
		return Y;
	}

	public int W(){
		int W = Integer.parseInt((String)tfW.getText());
		return W;
	}

	public int H(){
		int H = Integer.parseInt((String)tfH.getText());
		return H;
	}

	

	public String getValues(){
		String S = tfValues.getText();
		return S;
	}

	/*public void setX(String s){ tfX.setText(s); }
	public void setY(String s){ tfY.setText(s); }
	public void setW(String s){ tfW.setText(s); }
	public void setH(String s){ tfH.setText(s); }
	public void setValues(String s){ tfValues.setText(s); }*/

}
