package others;

import javax.swing.JOptionPane;
import Util.GUIutil;
import gui_Panel.Configure_Panel;
import gui_Panel.MainFrame;
public class Exception_solvetion {
	
	public static void Exception_solvetion() {
		Thread t = Thread.currentThread();
   	 Runnable runnable =new  Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "初始化系统失败，请检查数据库连接");
				GUIutil.showPanel(Configure_Panel.configure_Panel );
			}
   	 };
   	 new Thread(runnable ).start();
   	 MainFrame . mainFrame.setVisible(false);
   	 t.stop();
	}
	
	public static void Exception_solvetion1() {
		Thread t = Thread.currentThread();
   	 Runnable runnable =new  Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "初始化系统失败，请检查数据库字段设置，可直接使用恢复文件进行恢复");
				GUIutil.showPanel(Configure_Panel.configure_Panel );
			}
   	 };
   	 new Thread(runnable ).start();
   	 MainFrame . mainFrame.setVisible(false);
   	 t.stop();
	}
}
