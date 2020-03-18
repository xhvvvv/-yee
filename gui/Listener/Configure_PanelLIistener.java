package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Entity.Sqlconnection;
import Service.BackUpServe;
import Service.Configure_PanelServe;
import Service.RecoverServe;
import Util.CreatFile;
import gui_Panel.Configure_Panel;

public class Configure_PanelLIistener implements ActionListener{
	File sqlfile=new File("D:\\confine\\SQLMATION.txt");
	static JPanel remindpanel=new JPanel();//提醒面板
	String confirm ="";
	@Override
	public void actionPerformed(ActionEvent e) {
		Configure_Panel configure_Panel1=Configure_Panel. configure_Panel;
		JButton       source 				=  (JButton)e.getSource();
		BackUpServe aa;RecoverServe bb;
		/*
		 * 
		 */
		if(source.equals(configure_Panel1. backupbutton)) {
			aa=new BackUpServe();
		}
		/*
		 * 
		 */
		else if(source.equals(configure_Panel1. restorebutton)) {
			bb=new RecoverServe();
			
		}
		/*
		 * 
		 */
		else if(source.equals(configure_Panel1. reflushbutton)) {
			int confirm = 
			JOptionPane.showConfirmDialog(remindpanel,"是否执行", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(confirm==0) {
				Sqlconnection sqlconnection=new Sqlconnection();
				sqlconnection.ip=configure_Panel1.sql1.getText();
				sqlconnection.port=configure_Panel1.sql2.getText();
				sqlconnection.database=configure_Panel1.sql3.getText();
				sqlconnection.encoding=configure_Panel1.sql4.getText();
				sqlconnection.loginName=configure_Panel1.sql5.getText();
				sqlconnection.password=configure_Panel1.sql6.getText();
				boolean consequence=CreatFile.createFile(sqlfile);
				if(consequence) {
					Configure_PanelServe.Writetxt(sqlfile,sqlconnection);
				}
				JOptionPane.showMessageDialog(remindpanel, "设置成功"); 
			}

		}
	
//	public static void main(String[] args) {
//		remind().setVisible(true);
//    }
}
}