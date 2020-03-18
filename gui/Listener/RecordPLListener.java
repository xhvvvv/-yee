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
//                System.out.println("ִ�����SwingWorder���߳��ǣ�" + Thread.currentThread().getName());
				Record_Panel  Record_Panel1			= Record_Panel.Record_Panel;
				JButton       source 				=  (JButton)e.getSource();
				String 		  stringwords			= Record_Panel1.words4A.getText();
				String 		  stringfield			= (String) Record_Panel1.field4E .getSelectedItem();
				String words=Record_Panel1.words4A.getText();
				ArrayList<word> wordsgroup=newwordDAO.inspectsame(words);//��ȡ���Ƶ�����
				Object[] options ={ "�鿴","��������" ,"ȡ��" }; 
				if(!stringwords.equals("")) {//null��""����������ģ�
					
						if(source.equals(Record_Panel1.jbutton4G)) {//ȷ����ť
							int confirm = 
							JOptionPane.showConfirmDialog(null,"�Ƿ�ִ��", "��ȷ��",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if(confirm==0){	
								word word	 =new word();
								word.setwords(words);
								word.setmeand (Record_Panel1.meand4B.getText());
								word.settime (simpleDateFormat.format(new Date()));
								word.field (stringfield);
								word.marks ((String) Record_Panel1.marks4D.getSelectedItem());
								if(wordsgroup.size()!=0) {
									int m = JOptionPane.showOptionDialog(null, "��⵽���ظ�����", "����",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);  
									if(m==0) {
										secondFrame secondFrame1=new secondFrame();
										ArrayList<sentence> sentencegroup=SecondFrameServe.getsentencealone(wordsgroup);
										SecondFrameServe secondFrameServe1=new SecondFrameServe(secondFrame1,wordsgroup,sentencegroup);		
										secondFrame1.selectdialog.setVisible(true);
									}
									if(m==1) {
										newwordDAO.add(word);
										/*
										 * ����Ƿ�������µ�field������о������ݿ��м������ֶ�
										 */
										if(!fielidtype.fielidtype1(stringfield)) {
											field field	=new field();
											field.field	=stringfield;
											newfieldtypeDAO.add(field);
										}
									/*
									 *�Ƿ��о���
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
									 * ����Ƿ�������µ�field������о������ݿ��м������ֶ�
									 */
									if(!fielidtype.fielidtype1(stringfield)) {
										field field	=new field();
										field.field	=stringfield;
										newfieldtypeDAO.add(field);
									}
								/*
								 *�Ƿ��о���
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

//						}else if(source.equals(Record_Panel1.jbutton4H)) {//��ⰴť	}
						}
				}else
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵĵ���");
             }

	
}
