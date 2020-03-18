package gui_Panel;
import javax.swing.*;

import Listener.InitialPLListener;
import Service.Initial_PanelService;
import Util.Colorutil;
import Util.GUIutil;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class Initial_Panel extends JPanel{
	static  {
        GUIutil.useLNF();
    }
	Initial_PanelService initial_PanelService=new Initial_PanelService();
	
	public static Initial_Panel Initial_Panel=new Initial_Panel();
	public  String NBofwords =initial_PanelService.NBofwords;;
	public  String ARknows   =initial_PanelService.ARknows;
	public  String ETfield   =initial_PanelService.ETfield;
	
	JLabel jlable1A=new JLabel(" NBofwords "); 
	JLabel jlable1B=new JLabel(" ARknows   ");
	JLabel jlable1C=new JLabel(" ETfield   ");
	public JLabel jlable1A1=new JLabel(NBofwords);
	public JLabel jlable1B1=new JLabel(ARknows);
	public JLabel jlable1C1=new JLabel(ETfield);
	JButton butoon=new JButton ("刷新");
	 
	
	public JPanel jpanel1 = new JPanel(); 
	public JPanel jpanel1D = new JPanel(); 
	public JPanel jpanel1E = new JPanel(); 
	public JPanel jpanel1F = new JPanel(); 
	public  JPanel UPpanel() {
		
		jpanel1.setLayout(null);
		Font font=new Font ("微软雅黑", Font.BOLD, 30);

		jlable1A.setFont(font);jlable1B1.setFont(font);
		jlable1C.setFont(font);jlable1C1.setFont(font);
		jlable1B.setFont(font);jlable1C.setFont(font);
		jlable1A1.setFont(font);
		GUIutil.setColor(Colorutil.blueColor,jlable1A,jlable1B,jlable1C);
		
			jpanel1D.add(jlable1A1); 
			jpanel1E.add(jlable1B1);
			jpanel1F.add(jlable1C1);
				jpanel1.add(jlable1A);jlable1A.setBounds(10, 20, 200,100);
				jpanel1.add(jpanel1D);jpanel1D.setBounds(240, 47, 100,100);
				
				jpanel1.add(jlable1B);jlable1B.setBounds(10, 110, 200,100);
				jpanel1.add(jpanel1E);jpanel1E.setBounds(190, 137, 200,100);
				
				jpanel1.add(jlable1C);jlable1C.setBounds(10, 210, 200,100);
				jpanel1.add(jpanel1F);jpanel1F.setBounds(190, 237, 200,100);

		return jpanel1;
	}
	
	JPanel jpanel2 = new JPanel();
	public JPanel DOWNpanel() {
		
		jpanel2.setLayout(new FlowLayout());	
		jpanel2.add(butoon);
		return jpanel2;
		
	}
	
	public  Initial_Panel () {
		this.setLayout(null);           //不然最底层布局是cont。。。 它的性质会影响BorderLayout的性质
		this.setLayout(new BorderLayout());
		 this.add(UPpanel(),  BorderLayout.CENTER);
	     this.add(DOWNpanel(),BorderLayout.SOUTH);
	     addListener();    	 
	}
	public  void addListener() {
		
	        // TODO Auto-generated method stub
		InitialPLListener listener = new InitialPLListener();
		butoon.addActionListener(listener);
	}
	 public static void main(String[] args) {
	        GUIutil.showPanel(Initial_Panel.Initial_Panel );
	    }
	
	
}