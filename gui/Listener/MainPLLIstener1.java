package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import gui_Panel.Main_panel;
import gui_Panel.Configure_Panel;
import gui_Panel.Initial_Panel;
import gui_Panel.Record_Panel;
import gui_Panel.select_Panel;
import gui_Panel.Study_Panel;

public class MainPLLIstener1 implements ActionListener{
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   Main_panel mainpanel =Main_panel .mainpanel1;
		   JButton  b = (JButton) e.getSource();
		   if (b == mainpanel. button1)
	        	mainpanel.panel.show(Initial_Panel .Initial_Panel);
	        if (b == Main_panel. button2)
	        	Main_panel.panel.show(select_Panel .select_Panel);
	        
	        if (b == mainpanel. button3)

	        	mainpanel.panel.show(Study_Panel.Study_Panel);
	        	
	        if (b == mainpanel. button4)
	        	mainpanel.panel.show(Record_Panel. Record_Panel);
	        
	        if (b == mainpanel. button5)
	        	mainpanel.panel.show(Configure_Panel.configure_Panel);
	        
	        
	       
	 
	   }

}

