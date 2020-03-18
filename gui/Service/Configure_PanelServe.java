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
	
	public static Sqlconnection  Readtxt(File f) {//��ȡ�ļ�
		 Sqlconnection  sqlconnection=new Sqlconnection ();
		 ArrayList<String> str1=new ArrayList<>();
			try (FileReader fr=new FileReader(f);BufferedReader br=new BufferedReader(fr);){
				String str;
				while((str=br.readLine())!=null) {//readLine()����һ�ζ�ȡһ������
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
						JOptionPane.showMessageDialog(null, "��ʼ��ϵͳʧ�ܣ��������ݿ�����");
						GUIutil.showPanel(Configure_Panel.configure_Panel );
					}
		    	 };
		    	 new Thread(runnable ).start();
		    	 MainFrame . mainFrame.setVisible(false);
		    	 t.stop();
				
				return null;
				
			}
//			}finally {//���funally�����δ֪���쳣
//				return null;
//			}
		}
	public static  void Writetxt(File f,Sqlconnection sqlconnection) {//д���ļ�
		
		try(	FileWriter fw=new FileWriter(f);
				BufferedWriter bw=new BufferedWriter(fw);) {
			bw.write("�����������ļ����벻Ҫɾ���������ɾ����Ҷ����Ӣ�������������\r\n");
			bw.write(sqlconnection.ip+"\r\n");//\r\n��Ϊ����
			bw.write(sqlconnection.port+"\r\n");
			bw.write(sqlconnection.database+"\r\n");
			bw.write(sqlconnection.encoding+"\r\n");
			bw.write(sqlconnection.loginName+"\r\n");
			bw.write(sqlconnection.password+"\r\n");
			bw.flush();            //������ѹ���ı�
		}catch(IOException e) {
			e.printStackTrace();
			 Thread t = Thread.currentThread();
	    	 Runnable runnable =new  Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "��ʼ��ϵͳʧ�ܣ��������ݿ�����");
					GUIutil.showPanel(Configure_Panel.configure_Panel );
				}
	    	 };
	    	 new Thread(runnable ).start();
	    	 MainFrame . mainFrame.setVisible(false);
	    	 t.stop();
			
		}
	}

}
