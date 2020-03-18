package Util;

import java.awt.Color;

import javax.swing.JComponent;
//另外再引进几个颜色
public class Colorutil {
	
	    public static Color blueColor = Color.decode("#3399FF"); // blueColor 淡蓝色
	    public static Color grayColor = Color.decode("#999999"); // grayColor 灰色
	    public static Color backgroundColor = Color.decode("#eeeeee");//backgroundColor 背景色
	    public static Color warningColor = Color.decode("#FF3333");//warningColor 警告红色
	    public static void setColor(Color color,JComponent... cs) {
	  	    	for (JComponent c : cs) {
	    	        c.setForeground(color);
//	    	       c.setBackgroundColor();没用过
	    	    }
	    	
	    }
//	    public static Color getByPercentage(int per) {
//	        if (per > 100)
//	            per = 100;
//	        int r = 51;
//	        int g = 255;
//	        int b = 51;
//	        float rate = per / 100f;
//	        r = (int) ((255 - 51) * rate + 51);
//	        g = 255 - r + 51;
//	        Color color = new Color(r, g, b);
//	        return color;
//	    }
	
}
