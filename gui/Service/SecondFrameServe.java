package Service;

//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Entity.SentenceDAO;
import Entity.sentence;
import Entity.word;
import Util.Dateutil;
import gui_Panel.secondFrame;
//�õ����ʣ�����������ʾ��secondFrame��
public class SecondFrameServe {//��������Ž�������
//	public  secondFrame secondFrame1;secondFrame1=new secondFrame();
	secondFrame secondFrame1;
	public   SecondFrameServe(secondFrame secondFrame1,ArrayList<word> word,ArrayList<sentence> sentencegroup) {//�õ����ٸ�words����������϶�������Ȼ�������panel
		this.secondFrame1=secondFrame1;
		JButton[] JButtongroup=new JButton[word.size()];
		for(int i=0;i<word.size();i++) {
				JButtongroup[i]=new JButton(word.get(i).words);
				switchPic(JButtongroup[i],word.get(i),sentencegroup.get(i));//��ÿ����ť���Ӽ���
				secondFrame1.pLeft1.add(JButtongroup[i]);
		}
	}
	public static ArrayList<sentence> getsentencealone(ArrayList<word> wordsgroup){//��word��id�õ�sentence��id
	ArrayList<sentence> sentencegroup= new ArrayList<sentence>();
		for(int i=0;i<wordsgroup.size();i++) {
			sentencegroup.add(SentenceDAO.wordidtogetsentence(wordsgroup.get(i).id));
		}
	return sentencegroup;
	}
	private  void switchPic(JButton b1,word word,sentence sentence1) {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			secondFrame1.wordtextfile.setText(word.words);
			secondFrame1.marksbox.setSelectedItem(word.marks);
			secondFrame1.fieldbox.setSelectedItem(word.field);

			secondFrame1.timetextfile.setText(word.intime);//Dateutil.DatetoString(word.intime)
		
			secondFrame1.meandtextarea.setText(word.meand);
			secondFrame1.wordID.setText(String.valueOf(word.id));
			secondFrame1.sentencetextarea.setText(sentence1.sentence); 
			secondFrame1.marksbox.updateUI();//��������������combox����ᱣ��ԭ��״̬��Text�����Դ�updateui����
			secondFrame1.fieldbox .updateUI();
		}
		});
	}
	
}
