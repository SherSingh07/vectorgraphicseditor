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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.Rectangle;

public class LeftToolbar extends JToolBar implements ActionListener {

    private VegEdit VE;
	JButton btnBasicShapes;
	JButton btnArrows;
	JButton btnSmileys;
	JButton btnText;
	JButton btnImage;
	JButton btnFlowChart;
	JButton btnSaloon;
	JButton btnHat;

    TextTools      textTools;
	BasicTools     basicTools;
	Smileys        smileys;
	ArrowTools     arrowTools;
	FlowChartTools flowChartTools;
	SaloonTools    saloonTools;
	HatTools       hatTools;

	public LeftToolbar(VegEdit VE) {

        setLayout(new GridLayout(13, 1));
        this.VE=VE;
		textTools = new TextTools(VE);
		textTools.setVisible(false);

		basicTools = new BasicTools(VE);
		basicTools.setVisible(false);

		smileys = new Smileys(VE);
		smileys.setVisible(false);

		arrowTools = new ArrowTools(VE);
		arrowTools.setVisible(false);

		flowChartTools = new FlowChartTools(VE);
		flowChartTools.setVisible(false);
		
		saloonTools = new SaloonTools(VE);
		saloonTools.setVisible(false);
		
		hatTools = new HatTools(VE);
		hatTools.setVisible(false);
		
		//Basic Shapes
        btnBasicShapes = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/basicShapes.png")));
        btnBasicShapes.setToolTipText("Draw Basic Shapes");
        add(btnBasicShapes);
		btnBasicShapes.addActionListener(this);
		btnBasicShapes.setActionCommand(Config.CMD_DRAW_BASICSHAPES);
		
		//Arrows
        btnArrows = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/Arrow.png")));
        btnArrows.setToolTipText("Draw Arrows");
        add(btnArrows);
		btnArrows.addActionListener(this);
		btnArrows.setActionCommand(Config.CMD_DRAW_ARROWS);

        //Histogram
        JButton btnLineGraph = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/linegraph.png")));
        btnLineGraph.setToolTipText("Draw LineGraph");
        add(btnLineGraph);
		btnLineGraph.addActionListener(VE);
		btnLineGraph.setActionCommand(Config.CMD_DRAW_LINEGRAPH);

        //Bar Graph
        JButton btnBarGraph = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/bar_graph.png")));
        btnBarGraph.setToolTipText("Draw Bar Graph");
        add(btnBarGraph);
		btnBarGraph.addActionListener(VE);
		btnBarGraph.setActionCommand(Config.CMD_DRAW_BARGRAPH);

        //Pie Chart
        JButton btnPieChart = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/pie_chart.png")));
        btnPieChart.setToolTipText("Draw Pie Chart");
        add(btnPieChart);
		btnPieChart.addActionListener(VE);
		btnPieChart.setActionCommand(Config.CMD_DRAW_PIECHART);

		//Progress Graph
        JButton btnProgressGraph = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/progress graph.png")));
        btnProgressGraph.setToolTipText("Draw Progress Graph");
        add(btnProgressGraph);
		btnProgressGraph.addActionListener(VE);
		btnProgressGraph.setActionCommand(Config.CMD_DRAW_PROGRESSGRAPH);

        //Flow Chart
        btnFlowChart = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/flow_chart.png")));
        btnFlowChart.setToolTipText("Draw Flow Chart");
        add(btnFlowChart);
		btnFlowChart.setActionCommand(Config.CMD_DRAW_FLOWCHART);
		btnFlowChart.addActionListener(this);

		//Smileys
        btnSmileys = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/smileys.png")));
        btnSmileys.setToolTipText("Draw Smileys");
        add(btnSmileys);
		btnSmileys.setActionCommand(Config.CMD_DRAW_SMILEYS);
		btnSmileys.addActionListener(this);

        //Tooth
        JButton btnTooth = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/tooth.png")));
        btnTooth.setToolTipText("Dental Graphics...");
        btnTooth.setActionCommand(Config.CMD_DRAW_TOOTH);
        btnTooth.addActionListener(VE);
        add(btnTooth);

        //Saloon
        btnSaloon = new JButton(new ImageIcon(getClass().getResource("images/icons/48x48/saloon.png")));
        btnSaloon.setToolTipText("Saloon & Grooming...");
		btnSaloon.setActionCommand(Config.CMD_SALOON);
        btnSaloon.addActionListener(this);
        add(btnSaloon);

        //Hat
        btnHat = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/hat.png")));
        btnHat.setToolTipText("Hat styling...");
        btnHat.setActionCommand(Config.CMD_HAT);
        btnHat.addActionListener(this);
        add(btnHat);
		
		//Text
		btnText = new JButton(new ImageIcon(getClass().getResource("images/icons/32x32/text_letter.png")));
        btnText.setToolTipText("Draw Text...");
        btnText.setActionCommand(Config.CMD_DRAW_TEXT);
        btnText.addActionListener(this);
		add(btnText);

		//Images
		btnImage = new JButton("I");
        btnImage.setToolTipText("Insert Images...");
        //btnText.setActionCommand(Config.CMD_DRAW_TEXT);
        ///btnText.addActionListener(this);
		add(btnImage);
    }

	public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(Config.CMD_DRAW_BASICSHAPES))  {
            Rectangle rect = btnBasicShapes.getBounds();

            if(basicTools.isVisible() == false) {
             basicTools.setLocation(VE.getX() + rect.x + rect.width + 5, VE.getY() + rect.y+rect.height);
             basicTools.setVisible(true);
			}
			else {
				basicTools.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_DRAW_SMILEYS))  {
			Rectangle rect1 = btnSmileys.getBounds();

            if(smileys.isVisible() == false) {
             smileys.setLocation(VE.getX() + rect1.x + rect1.width + 5, VE.getY() + rect1.y +rect1.height);
             smileys.setVisible(true);
			}
			else {
				smileys.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_DRAW_TEXT)) {
            Rectangle rect2 = btnText.getBounds();

            if(textTools.isVisible() == false) {
             textTools.setLocation(VE.getX() + rect2.x + rect2.width + 5, VE.getY() + rect2.y+rect2.height);
             textTools.setVisible(true);
			}
			else {
				textTools.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_DRAW_ARROWS)) {
            Rectangle rect3 = btnArrows.getBounds();

            if(arrowTools.isVisible() == false) {
             arrowTools.setLocation(VE.getX() + rect3.x + rect3.width + 5, (2*VE.getY()) + rect3.y+rect3.height);
             arrowTools.setVisible(true);
			}
			else {
				arrowTools.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_DRAW_FLOWCHART)) {
            Rectangle rect4 = btnFlowChart.getBounds();

            if(flowChartTools.isVisible() == false) {
             flowChartTools.setLocation(VE.getX() + rect4.x + rect4.width + 5, VE.getY() + rect4.y+rect4.height);
             flowChartTools.setVisible(true);
			}
			else {
				flowChartTools.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_SALOON)) {
            Rectangle rect5 = btnSaloon.getBounds();

            if(saloonTools.isVisible() == false) {
             saloonTools.setLocation(VE.getX() + rect5.x + rect5.width + 5, VE.getY() + rect5.y+rect5.height);
             saloonTools.setVisible(true);
			}
			else {
				saloonTools.setVisible(false);
			}
        }

		else if(event.getActionCommand().equals(Config.CMD_HAT)) {
			Rectangle rect6 = btnHat.getBounds();

            if(hatTools.isVisible() == false) {
             hatTools.setLocation(VE.getX() + rect6.x + rect6.width + 5, VE.getY() + rect6.y+rect6.height);
             hatTools.setVisible(true);
			}
			else {
				hatTools.setVisible(false);
			}
        }
	}    
}//LeftToolbar
