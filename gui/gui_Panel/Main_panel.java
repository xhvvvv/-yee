package gui_Panel;

	import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Listener.MainPLLIstener1;
import Util.GUIutil;


public class Main_panel extends JPanel{
		static {
	        GUIutil.useLNF();
	    }
		
			public static  CenterPanel panel =new CenterPanel(0.9);
			public static JToolBar tb = new JToolBar();
			public static JButton button1=new JButton();
			public static JButton button2=new JButton();
			public static JButton button3=new JButton();
			public static JButton button4=new JButton();
			public static JButton button5=new JButton();
			

			public static Main_panel mainpanel1=new Main_panel();//Сϸ�ڣ���䲻�ܷ��ڵ�һλ
			public  Main_panel() {
				this.setLayout(null);
				this.setLayout(new BorderLayout());

				GUIutil.setImageIcon(button1 , "home.png","ͳ��");
		        GUIutil.setImageIcon(button2 , "report.png","��ѯ");
		        GUIutil.setImageIcon(button3 , "restore.png", "��ϰ");
		        GUIutil.setImageIcon(button4 , "record.png", "��¼");
		        GUIutil.setImageIcon(button5 , "config.png", "����");
		        
				tb.add( button1);		
		        tb.add( button2);
		        tb.add( button3);
		        tb.add( button4);
		        tb.add( button5);
		        tb.setFloatable(false);//�����������ƶ�
		        tb.setPreferredSize(new Dimension(100,70));
//		        tb.setBounds(0,-30, 500, 100);
		      
//		        this.add(tb);
//		        this.add(panel);
		        this.add(tb, BorderLayout.NORTH);
		        this.add(panel , BorderLayout.CENTER);
		        addListener();
		       
			}
			public static void addListener() {
				MainPLLIstener1 mainPLLIstener1=new MainPLLIstener1();
				button1.addActionListener(mainPLLIstener1);
				button2.addActionListener(mainPLLIstener1);
				button3.addActionListener(mainPLLIstener1);
				button4.addActionListener(mainPLLIstener1);
				button5.addActionListener(mainPLLIstener1);
			}
			public static void main(String[] args ) {
				 GUIutil.showPanel(Main_panel.mainpanel1);

			}
	}