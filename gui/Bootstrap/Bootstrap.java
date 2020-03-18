package Bootstrap;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import Log.Log4j;
import Util.GUIutil;
import gui_Panel.Initial_Panel;
import gui_Panel.MainFrame;
import gui_Panel.Main_panel;
import others.Exception_solvetion;

/**
 * 
 * @author ΰ�й���
 * @Description: v1.1.7
 * @date 2020��3��17��14:55:392
 */

public class Bootstrap {
	    public static void main(String[] args) throws Exception{	
			    {GUIutil.useLNF();}

			    SwingUtilities.invokeAndWait(new Runnable() {
			            @Override
			            public void run() {	
			            	try {
								MainFrame.mainFrame.setVisible(true);
				            	Main_panel .mainpanel1.panel.show(Initial_Panel .Initial_Panel);
//			            	}catch(ExceptionInInitializerError a) {
//			            		Exception_solvetion.Exception_solvetion();
//			            	}InvocationTargetException
				            }catch(Exception a) {
				            	Exception_solvetion.Exception_solvetion();
				            }catch(Throwable t) {
			            	  Exception_solvetion.Exception_solvetion();}
			            }
			    });
			    Log4j log=new Log4j();
			  
	    
	    }
}