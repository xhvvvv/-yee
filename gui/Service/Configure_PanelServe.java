package Service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Sqlconnection;
import Util.GUIutil;
import gui_Panel.Configure_Panel;
import gui_Panel.MainFrame;
public class Configure_PanelServe {
	
	public static Sqlconnection  Readtxt(File f) {//读取文件
		 Sqlconnection  sqlconnection=new Sqlconnection ();
		 ArrayList<String> str1=new ArrayList<>();
			try (FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr);){
				String str;
				while((str=br.readLine())!=null) {//readLine()方法一次读取一行数据
					str1.add(str);
				}
				sqlconnection.ip=str1.get(1);
				sqlconnection.port=str1.get(2);
				sqlconnection.database=str1.get(3);
				sqlconnection.encoding=str1.get(4);
				sqlconnection.loginName=str1.get(5);
				sqlconnection.password=str1.get(6);
				return sqlconnection;
			}catch(IOException e) {
				e.printStackTrace();
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
				
				return null;
				
			}
//			}finally {//这个funally会出现未知单异常
//				return null;
//			}
		}
	public static  void Writetxt(File f,Sqlconnection sqlconnection) {//写入文件
		
		try(	FileWriter fw=new FileWriter(f);
				BufferedWriter bw=new BufferedWriter(fw);) {
			bw.write("这里是配置文件，请不要删除，如果误删请在叶子香英语软件重新配置\r\n");
			bw.write(sqlconnection.ip+"\r\n");//\r\n即为换行
			bw.write(sqlconnection.port+"\r\n");
			bw.write(sqlconnection.database+"\r\n");
			bw.write(sqlconnection.encoding+"\r\n");
			bw.write(sqlconnection.loginName+"\r\n");
			bw.write(sqlconnection.password+"\r\n");
			bw.flush();            //将缓存压入文本
		}catch(IOException e) {
			e.printStackTrace();
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
	}

}
