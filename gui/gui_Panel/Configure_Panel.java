package gui_Panel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Listener.Configure_PanelLIistener;
import Util.GUIutil;
public class Configure_Panel extends JPanel{
	public static Configure_Panel configure_Panel=new  Configure_Panel();
	public JTextField backup		=new JTextField();//1单词
	public JTextField restore		=new JTextField();//1单词
	public  JButton     backupbutton    =new JButton("备份");
	public  JButton     restorebutton   =new JButton("恢复");
	public  JButton     reflushbutton   =new JButton("更新");
	public  JPanel     panel  =new JPanel();
	public JLabel sql=new JLabel("sql连接信息");

	public JLabel remind=new JLabel("ip-port-database");
	public JLabel remind1=new JLabel("encoding-loginName-password");
	public JTextField sql1		=new JTextField("127.0.0.1");
	public JTextField sql2		=new JTextField("3306");
	public JTextField sql3		=new JTextField("english");
	public JTextField sql4		=new JTextField("UTF-8");
	public JTextField sql5		=new JTextField("root");
	public JTextField sql6		=new JTextField("admin");
	
	String remind2="mysql 5.5路径";
	public  void panel() {
		sql4.setEditable(false);
		panel.add(sql1);panel.add(sql2);
		panel.add(sql3);panel.add(sql4);
		panel.add(sql5);panel.add(sql6);
	}
	public Configure_Panel() {
		this.setLayout(null);
		panel.setLayout(new GridLayout(2,3));

		panel();
		backupbutton .setBounds(10, 10,60,40);    backup.setBounds     (100, 20, 310, 20); backup.setText(remind2);
		restorebutton.setBounds(10, 60,60,40);    restore.setBounds    (100, 70, 310, 20); restore.setText(remind2);
		sql.setBounds          (10, 100,100,40);  remind.setBounds     (100, 90, 150, 50);
																		remind1.setBounds(100, 105, 200, 50);
		panel.setBounds        (10, 140,400,80);  reflushbutton.setBounds(10, 250,60,50);
		
		this.add(backupbutton);
		this.add(backup);	this.add(restorebutton);		this.add(restore);
		this.add(panel);this.add(sql);this.add(remind);this.add(remind1);this.add(reflushbutton);

		addListener();
	}
	public  void addListener() {
				Configure_PanelLIistener configure_PanelLIistener=new Configure_PanelLIistener();
				backupbutton.addActionListener(configure_PanelLIistener);
				restorebutton.addActionListener(configure_PanelLIistener);
				reflushbutton.addActionListener(configure_PanelLIistener);

	}
	public static void main(String[] args) {
        GUIutil.showPanel(Configure_Panel.configure_Panel );
    }
}
