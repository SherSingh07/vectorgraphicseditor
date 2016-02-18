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
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.filechooser.*;

public class FlowChartTools extends Tools implements ActionListener{
    VegEdit VE;
	JButton btnProcess;
	JButton btnAltProcess;
	JButton btnDecision;
	JButton btnData;
	JButton btnPredefinedProcess;
	JButton btnInternalStorage;
	JButton btnDocument;
	JButton btnMultiDocument;
	JButton btnTermination;
	JButton btnPreparation;
	JButton btnManualInput;
	JButton btnManualOperation;
	JButton btnConnector;
	JButton btnOffPageConnector;
	JButton btnCard;
	JButton btnPunchedTape;
	JButton btnSummation;
	JButton btnOr;
	JButton btnCollate;
	JButton btnSort;
	JButton btnExtract;
	JButton btnMerge;
	JButton btnStoredData;
	JButton btnDelay;
	JButton btnSeqAcsStorage;
	JButton btnMagneticDisk;
	JButton btnDirAccessStorage;
	JButton btnDisplay;
	
    public FlowChartTools(VegEdit VE) {
        super(VE);
        this.VE=VE;

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(12, 4));
        //Process
        btnProcess = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/rectangle.png")));
        btnProcess.setToolTipText("Process");
        btnProcess.setActionCommand(Config.CMD_FLOWCHART_PROCESS);
        btnProcess.addActionListener(this);
        btnProcess.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnProcess);

        //Alternate Process
        btnAltProcess = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/roundrect.png")));
        btnAltProcess.setToolTipText("Alternate Process");
        btnAltProcess.setActionCommand(Config.CMD_FLOWCHART_ALTPROCESS);
        btnAltProcess.addActionListener(this);
        btnAltProcess.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnAltProcess);

		//Decision
        btnDecision = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_rhombus.png")));
        btnDecision.setToolTipText("Decision");
        btnDecision.setActionCommand(Config.CMD_FLOWCHART_DECISION);
        btnDecision.addActionListener(this);
		btnDecision.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDecision);
		
        //Data
        btnData = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/parallelogram.png")));
        btnData.setToolTipText("Data");
        btnData.setActionCommand(Config.CMD_FLOWCHART_DATA);
        btnData.addActionListener(this);
        btnData.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnData);

		//Predefined Process
        btnPredefinedProcess = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/scroll.png")));
        btnPredefinedProcess.setToolTipText("Predefined Process");
        btnPredefinedProcess.setActionCommand(Config.CMD_FLOWCHART_PREDEFPROCESS);
        btnPredefinedProcess.addActionListener(this);
        btnPredefinedProcess.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnPredefinedProcess);

        // Extract
        btnExtract = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Triangle.png")));
        btnExtract.setToolTipText("Extract");
        btnExtract.setActionCommand(Config.CMD_FLOWCHART_EXTRACT);
        btnExtract.addActionListener(this);
		btnExtract.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnExtract);

		//Merge
        btnMerge = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Merge.png")));
        btnMerge.setToolTipText("Merge");
        btnMerge.setActionCommand(Config.CMD_FLOWCHART_MERGE);
        btnMerge.addActionListener(this);
		btnMerge.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnMerge);

        //Internal Storage
        btnInternalStorage = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_rhombus.png")));
        btnInternalStorage.setToolTipText("Internal Storage");
        btnInternalStorage.setActionCommand(Config.CMD_FLOWCHART_INTSTORAGE);
        btnInternalStorage.addActionListener(this);
		btnInternalStorage.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnInternalStorage);

        //Termination
        btnTermination = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/pentagon.png")));
        btnTermination.setToolTipText("Termination");
        btnTermination.setActionCommand(Config.CMD_FLOWCHART_TERMINATION);
        btnTermination.addActionListener(this);
		btnTermination.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnTermination);

		//Manual Input
        btnManualInput = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_penta.png")));
        btnManualInput.setToolTipText("Manual Input");
        btnManualInput.setActionCommand(Config.CMD_FLOWCHART_MANINPUT);
        btnManualInput.addActionListener(this);
		btnManualInput.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnManualInput);

        //Preparation
        btnPreparation = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/hexagon.png")));
        btnPreparation.setToolTipText("Preparation");
		btnPreparation.setActionCommand(Config.CMD_FLOWCHART_PREPARATION);
        btnPreparation.addActionListener(this);
		btnPreparation.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnPreparation);

        //Manual Operation
        btnManualOperation = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_hex.png")));
        btnManualOperation.setToolTipText("Manual Operation");
        btnManualOperation.setActionCommand(Config.CMD_FLOWCHART_MANOPERATION);
        btnManualOperation.addActionListener(this);
		btnManualOperation.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnManualOperation);

        //Connector
        btnConnector = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/oval.png")));
        btnConnector.setToolTipText("Connector");
        btnConnector.setActionCommand(Config.CMD_FLOWCHART_CONNECTOR);
        btnConnector.addActionListener(this);
		btnConnector.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnConnector);

        //Off-Page Connector
        btnOffPageConnector = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_octa.png")));
        btnOffPageConnector.setToolTipText("Off-Page Connector");
        btnOffPageConnector.setActionCommand(Config.CMD_FLOWCHART_OFFPAGECONNECTOR);
        btnOffPageConnector.addActionListener(this);
		btnOffPageConnector.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnOffPageConnector);

        //Card
        btnCard = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Heart.png")));
        btnCard.setToolTipText("Card");
        btnCard.setActionCommand(Config.CMD_FLOWCHART_CARD);
        btnCard.addActionListener(this);
		btnCard.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnCard);

        //Punched Tape
        btnPunchedTape = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_heart.png")));
        btnPunchedTape.setToolTipText("Punched Tape");
        btnPunchedTape.setActionCommand(Config.CMD_FLOWCHART_PUNCHEDTAPE);
        btnPunchedTape.addActionListener(this);
		btnPunchedTape.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnPunchedTape);

        //OR
        btnOr = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/star.png")));
        btnOr.setToolTipText("OR");
        btnOr.setActionCommand(Config.CMD_FLOWCHART_OR);
        btnOr.addActionListener(this);
		btnOr.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnOr);

		// Summation
        btnSummation = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_oval2.png")));
        btnSummation.setToolTipText("Summation");
        btnSummation.setActionCommand(Config.CMD_FLOWCHART_SUMMATION);
        btnSummation.addActionListener(this);
		btnSummation.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSummation);

        //Collate
        btnCollate = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_star.png")));
        btnCollate.setToolTipText("Collate");
        btnCollate.setActionCommand(Config.CMD_FLOWCHART_COLLATE);
        btnCollate.addActionListener(this);
		btnCollate.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnCollate);

        //Sort
        btnSort = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/moon.png")));
        btnSort.setToolTipText("Sort");
        btnSort.setActionCommand(Config.CMD_FLOWCHART_SORT);
        btnSort.addActionListener(this);
        btnSort.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSort);

        //Sequential Access Storage
        btnSeqAcsStorage = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/call.png")));
        btnSeqAcsStorage.setToolTipText("Sequential Access Storage");
        btnSeqAcsStorage.setActionCommand(Config.CMD_FLOWCHART_SEQACSSTORAGE);
        btnSeqAcsStorage.addActionListener(this);
		btnSeqAcsStorage.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnSeqAcsStorage);
        
        //Stored Data
        btnStoredData = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_call.png")));
        btnStoredData.setToolTipText("Stored Data");
        btnStoredData.setActionCommand(Config.CMD_FLOWCHART_STOREDDATA);
        btnStoredData.addActionListener(this);
		btnStoredData.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnStoredData);
        
        //Delay
        btnDelay = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/fill_cross.png")));
        btnDelay.setToolTipText("Delay");
        btnDelay.setActionCommand(Config.CMD_FLOWCHART_DELAY);
        btnDelay.addActionListener(this);
		btnDelay.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDelay);
        
		// Display
        btnDisplay = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/spiral.png")));
        btnDisplay.setToolTipText("Display");
        btnDisplay.setActionCommand(Config.CMD_FLOWCHART_DISPLAY);
        btnDisplay.addActionListener(this);
        btnDisplay.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDisplay);

		// Direct Access Storage
        btnDirAccessStorage = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/Target.png")));
        btnDirAccessStorage.setToolTipText("Direct Access Storage");
        btnDirAccessStorage.setActionCommand(Config.CMD_FLOWCHART_DIRACSSTORAGE);
        btnDirAccessStorage.addActionListener(this);
		btnDirAccessStorage.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnDirAccessStorage);
        
		// Magnetic Disk
        btnMagneticDisk = new JButton(new ImageIcon(getClass().getResource("images/icons/16x16/picture.png")));
        btnMagneticDisk.setToolTipText("Magnetic Disk");
		btnMagneticDisk.setActionCommand(Config.CMD_FLOWCHART_MAGNETICDISK);
        btnMagneticDisk.addActionListener(this);
        btnMagneticDisk.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panel.add(btnMagneticDisk);

        getContentPane().add(panel, "Center");
        setUndecorated(true);
        setSize(250, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
            DrawingPanel.getInstance().setOperation(ae.getActionCommand());
       
    }
}
