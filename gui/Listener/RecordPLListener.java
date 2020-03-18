package Listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import Entity.FieldtypeDAO;
import Entity.SentenceDAO;
import Entity.field;
import Entity.sentence;
import Entity.word;
import Entity.wordDAO;
import Service.SecondFrameServe;
import gui_Panel.Record_Panel;
import gui_Panel.secondFrame;
import others.fielidtype;

public class RecordPLListener implements ActionListener{
	wordDAO newwordDAO=new wordDAO();
	FieldtypeDAO newfieldtypeDAO=new FieldtypeDAO();
	public  String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//                System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
				Record_Panel  Record_Panel1			= Record_Panel.Record_Panel;
				JButton       source 				=  (JButton)e.getSource();
				String 		  stringwords			= Record_Panel1.words4A.getText();
				String 		  stringfield			= (String) Record_Panel1.field4E .getSelectedItem();
				String words=Record_Panel1.words4A.getText();
				ArrayList<word> wordsgroup=newwordDAO.inspectsame(words);//获取近似单词组
				Object[] options ={ "查看","继续保存" ,"取消" }; 
				if(!stringwords.equals("")) {//null与""还是有区别的，
					
						if(source.equals(Record_Panel1.jbutton4G)) {//确定按钮
							int confirm = 
							JOptionPane.showConfirmDialog(null,"是否执行", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if(confirm==0){	
								word word	 =new word();
								word.setwords(words);
								word.setmeand (Record_Panel1.meand4B.getText());
								word.settime (simpleDateFormat.format(new Date()));
								word.field (stringfield);
								word.marks ((String) Record_Panel1.marks4D.getSelectedItem());
								if(wordsgroup.size()!=0) {
									int m = JOptionPane.showOptionDialog(null, "检测到有重复单词", "标题",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);  
									if(m==0) {
										secondFrame secondFrame1=new secondFrame();
										ArrayList<sentence> sentencegroup=SecondFrameServe.getsentencealone(wordsgroup);
										SecondFrameServe secondFrameServe1=new SecondFrameServe(secondFrame1,wordsgroup,sentencegroup);		
										secondFrame1.selectdialog.setVisible(true);
									}
									if(m==1) {
										newwordDAO.add(word);
										/*
										 * 检测是否加入了新的field，如果有就往数据库中加入新字段
										 */
										if(!fielidtype.fielidtype1(stringfield)) {
											field field	=new field();
											field.field	=stringfield;
											newfieldtypeDAO.add(field);
										}
									/*
									 *是否有句子
										 */
										String stringsentence=Record_Panel1.sentence4C.getText();
										if(!stringsentence.equals("")) {
											sentence sentence =new sentence ();
											sentence.id=word.id;
											sentence.sentence=Record_Panel1.sentence4C.getText();
											SentenceDAO.add(sentence);
										}
									}
								}else {
									newwordDAO.add(word);
									/*
									 * 检测是否加入了新的field，如果有就往数据库中加入新字段
									 */
									if(!fielidtype.fielidtype1(stringfield)) {
										field field	=new field();
										field.field	=stringfield;
										newfieldtypeDAO.add(field);
									}
								/*
								 *是否有句子
									 */
									String stringsentence=Record_Panel1.sentence4C.getText();
									if(!stringsentence.equals("")) {
										sentence sentence =new sentence ();
										sentence.id=word.id;
										sentence.sentence=Record_Panel1.sentence4C.getText();
										SentenceDAO.add(sentence);
									}
								}
									
							}

//						}else if(source.equals(Record_Panel1.jbutton4H)) {//检测按钮	}
						}
				}else
					JOptionPane.showMessageDialog(null,"请选择要修改的单词");
             }

	
}
