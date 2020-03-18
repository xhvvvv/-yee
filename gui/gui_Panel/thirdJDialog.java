package gui_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Listener.RemindListener;
///////////废弃类0312159

public class thirdJDialog extends JDialog{
	public  JLabel 	remindlabel;
	public  JButton  sure    =new JButton("确定");
	public  JButton  Regrets  =new JButton("手痒点错了");
	public static thirdJDialog thirdJDialog1=new thirdJDialog("确定修改");
	
	public  thirdJDialog(String tip) {
		remindlabel=new JLabel("确定备份?");
		this.setSize    (400,200);
		this.setLocation(500,300);
		this.setLayout  (null);
		remindlabel.setBounds  (10,10, 100, 30) ;
		sure .setBounds   (20,70, 100, 40) ;
		Regrets.setBounds (150,70, 100, 40) ;
		
		this.add(remindlabel);this.add(sure);this.add(Regrets);
//		sure.addActionListener(new  ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//        	
//        };
        Regrets.addActionListener(new  ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				return;
			}
        	
        });
	}
}
