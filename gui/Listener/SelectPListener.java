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
		ArrayList<sentence> sentencegroup=SecondFrameServe.getsentencealone(wordsgroup);//��ȡsentencegroup
		secondFrameServe1=new  SecondFrameServe(secondFrame1,wordsgroup,sentencegroup);//�����������ڰ�ť�в���ʾ�������
	    secondFrame1.selectdialog.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		 SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() { 
             @Override
             protected Void doInBackground() throws Exception {
				 wordDAO newwordDAO=new wordDAO();
				 select_Panel select_Panel1=select_Panel.select_Panel;//����panel����
				 JButton source = (JButton)e.getSource();//e.getSource() ��ò����¼��Ķ��󣡣�������������ͬʱ�Զ���������
				
				 if(source.equals(select_Panel1.button2A2)) {//��������
					String what=select_Panel1.textfield2A1.getText();//��ȡ�ı��������
					secondFrame secondFrame1=new secondFrame();
					ArrayList<word> wordsgroup=newwordDAO.selectBofwords(what);
					div(wordsgroup,secondFrame1);
				
				
				 
				 }else if(source.equals(select_Panel1.button2B2)) {//��������
					secondFrame secondFrame1=new secondFrame();
					String what              = select_Panel1.textfield2B1.getText();//��ȡ�ı��������
					ArrayList<word> wordsgroup = newwordDAO.selectCHIofwords(what);
					div(wordsgroup,secondFrame1);
				
				 
				 }else if(source.equals(select_Panel1.deletefield)) {
					 String field=(String)  select_Panel1.fieldbox .getSelectedItem();
					 /*
					  * ���ȡ���������null��  ʲôҲ�����룬�����""
					  */
					 String confirm =
								(String) JOptionPane.showInputDialog(null,"�Ѵ��ڵ��ʵ������Ϊ��\n","title",JOptionPane.PLAIN_MESSAGE,null,null,"��ͨ");
						/*
						 *  ""��ʾֻ�е�ַ����ַ��ʲôҲû�У���null��ʾ����ַ��û��
						 */
						try {
							if(confirm!=null) {//������ָ��
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
											JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
										}else if(consequence==0) {
											JOptionPane.showMessageDialog(null,"û����ָ��������");
										}
								}else 
									JOptionPane.showMessageDialog(null,"�޸Ĳ���Ϊ��");
							
							}else {
								
							}
								
						}catch(Exception ee) {
							JOptionPane.showMessageDialog(null,"�޸�ʧ��");
						}	
				
				
				
				
				 
				 }else if(source.equals(select_Panel1.button2A)) {//���������������ʱ����ӵĵ���
					secondFrame secondFrame1=new secondFrame();
					String chose= (String)select_Panel1.aa.getSelectedItem();//��ȡbox������
					ArrayList <word> wordsgroup= newwordDAO.getwords (chose);
					
					div(wordsgroup,secondFrame1);
				}
				 return null;
            }
        };
             worker.execute();
	}          
}

