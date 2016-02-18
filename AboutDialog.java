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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class AboutDialog extends JDialog implements ActionListener {
  public AboutDialog(JFrame parent, String title, String message) {
    super(parent, title, true);
    if (parent != null) {
      Dimension parentSize = parent.getSize(); 
      Point p = parent.getLocation(); 
      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
    }
    JPanel messagePane = new JPanel();
    messagePane.add(new JLabel(new ImageIcon(getClass().getResource("images/icons/128x128/graphics.png"))));
    messagePane.add(new JLabel("VeGEdit Beta 1.0"));
    messagePane.add(new JLabel("Generic, All Purpose Graphics Editor"));
    messagePane.add(new JLabel("Developed By WeaveBytes, Inc."));
    messagePane.add(new JLabel("Japanese Research & Development Company"));
    messagePane.add(new JLabel("www.weavebytes.com"));
    getContentPane().add(messagePane);
    JPanel buttonPane = new JPanel();
    JButton button = new JButton("OK"); 
    buttonPane.add(button); 
    button.addActionListener(this);
    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack(); 
	setSize(400, 300);
    setVisible(true);

  }
  public void actionPerformed(ActionEvent e) {
    setVisible(false); 
    dispose(); 
  }
  public static void main(String[] a) {
	 JFrame f = new JFrame("Hello...........");
	 f.setSize(600, 600);
	 f.setVisible(true);
    AboutDialog dlg = new AboutDialog(f, "title", "message");
  }
}
