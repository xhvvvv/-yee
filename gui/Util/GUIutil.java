package Util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui_Panel.CenterPanel;

public class GUIutil {
	private static String imageFolder = "src/img";
	//////////////////////////Ƥ����
	public static void useLNF() {
	    try {
	        javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	}
	///////////////////////////������ɫ
	public static void setColor(Color color, JComponent... cs) {
	    for (JComponent c : cs) {
	        c.setForeground(color);
	    }
	}
	////////////////////////////showPnael�������ʾ���,��panel������
	public static void showPanel(JPanel p,double strech) {
	    GUIutil.useLNF();
	    JFrame f = new JFrame();
	   
	    f.setSize(500, 500);
	    f.setLocationRelativeTo(null);
	    CenterPanel cp = new CenterPanel(strech);
	    f.setContentPane(cp);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    cp.show(p);
	}
	 public void updateData() {
	        
//		 panel.updateUI();
//		 repaint();
	      
	    }
	public static void showPanel(JPanel p) {
	    showPanel(p,0.85);
	} 
	public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
}
