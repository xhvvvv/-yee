package Listener;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import Entity.FieldtypeDAO;
import Entity.sentence;
import Entity.word;
import Entity.wordDAO;
import Service.SecondFrameServe;
import gui_Panel.Configure_Panel;
import gui_Panel.secondFrame;
import gui_Panel.select_Panel;

import javax.swing.JOptionPane;
	 
public class SelectPListener implements ActionListener{
	Configure_Panel configure_Panel1=Configure_Panel. configure_Panel;
	SecondFrameServe secondFrameServe1;	
//	String confirm ="";
	public void div(ArrayList<word> wordsgroup,secondFrame secondFrame1) {
		ArrayList<sentence> sentencegroup=SecondFrameServe.getsentencealone(wordsgroup);//获取sentencegroup
		secondFrameServe1=new  SecondFrameServe(secondFrame1,wordsgroup,sentencegroup);//将对象名加在按钮中并显示在面板中
	    secondFrame1.selectdialog.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		 SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() { 
             @Override
             protected Void doInBackground() throws Exception {
				 wordDAO newwordDAO=new wordDAO();
				 select_Panel select_Panel1=select_Panel.select_Panel;//引进panel对象
				 JButton source = (JButton)e.getSource();//e.getSource() 获得产生事件的对象！！！！！！！！同时对多个对象监听
				
				 if(source.equals(select_Panel1.button2A2)) {//搜索单词
					String what=select_Panel1.textfield2A1.getText();//获取文本框的内容
					secondFrame secondFrame1=new secondFrame();
					ArrayList<word> wordsgroup=newwordDAO.selectBofwords(what);
					div(wordsgroup,secondFrame1);
				
				
				 
				 }else if(source.equals(select_Panel1.button2B2)) {//搜索中文
					secondFrame secondFrame1=new secondFrame();
					String what              = select_Panel1.textfield2B1.getText();//获取文本框的内容
					ArrayList<word> wordsgroup = newwordDAO.selectCHIofwords(what);
					div(wordsgroup,secondFrame1);
				
				 
				 }else if(source.equals(select_Panel1.deletefield)) {
					 String field=(String)  select_Panel1.fieldbox .getSelectedItem();
					 /*
					  * 点击取消，结果是null，  什么也不输入，结果是""
					  */
					 String confirm =
								(String) JOptionPane.showInputDialog(null,"已存在单词的领域改为：\n","title",JOptionPane.PLAIN_MESSAGE,null,null,"普通");
						/*
						 *  ""表示只有地址，地址上什么也没有，而null表示连地址都没有
						 */
						try {
							if(confirm!=null) {//消除空指针
								if(!confirm.equals("")) {
					
										 Runnable runnable =new  Runnable() {
												@Override
												public void run() {
													int rs=wordDAO.modifyfield(field,confirm );
												}
									   	 };
									   	new Thread(runnable).start();
									   	int consequence=FieldtypeDAO.deletefield(field);
										if(consequence==1) {
											JOptionPane.showMessageDialog(null,"修改成功");
										}else if(consequence==0) {
											JOptionPane.showMessageDialog(null,"没有所指定的领域");
										}
								}else 
									JOptionPane.showMessageDialog(null,"修改不能为空");
							
							}else {
								
							}
								
						}catch(Exception ee) {
							JOptionPane.showMessageDialog(null,"修改失败");
						}	
				
				
				
				
				 
				 }else if(source.equals(select_Panel1.button2A)) {//查找昨天或者其他时间添加的单词
					secondFrame secondFrame1=new secondFrame();
					String chose= (String)select_Panel1.aa.getSelectedItem();//获取box的数据
					ArrayList <word> wordsgroup= newwordDAO.getwords (chose);
					
					div(wordsgroup,secondFrame1);
				}
				 return null;
            }
        };
             worker.execute();
	}          
}

