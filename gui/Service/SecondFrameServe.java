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
//得到单词，并将他们显示在secondFrame中
public class SecondFrameServe {//将单词组放进方法中
//	public  secondFrame secondFrame1;secondFrame1=new secondFrame();
	secondFrame secondFrame1;
	public   SecondFrameServe(secondFrame secondFrame1,ArrayList<word> word,ArrayList<sentence> sentencegroup) {//得到多少个words，把这个集合都传进来然后加载在panel
		this.secondFrame1=secondFrame1;
		JButton[] JButtongroup=new JButton[word.size()];
		for(int i=0;i<word.size();i++) {
				JButtongroup[i]=new JButton(word.get(i).words);
				switchPic(JButtongroup[i],word.get(i),sentencegroup.get(i));//给每个按钮增加监听
				secondFrame1.pLeft1.add(JButtongroup[i]);
		}
	}
	public static ArrayList<sentence> getsentencealone(ArrayList<word> wordsgroup){//由word单id得到sentence单id
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
			secondFrame1.marksbox.updateUI();//不添加这个东西，combox组件会保持原有状态，Text可能自带updateui方法
			secondFrame1.fieldbox .updateUI();
		}
		});
	}
	
}
