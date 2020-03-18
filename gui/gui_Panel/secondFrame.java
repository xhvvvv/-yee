package gui_Panel;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Entity.SentenceDAO;
import Entity.sentence;
import Entity.word;
import Entity.wordDAO;
import Util.GUIutil;
import others.SPComboBoxModel;
public class secondFrame {
	static {
        GUIutil.useLNF();
    }
		
		public  JFrame  selectdialog	= new JFrame("查询结果");
//		public secondFrame secondFrame=new secondFrame();
		public  JScrollPane  pLeft 		= new JScrollPane();
		public  JScrollPane  pRight ;//		= new JScrollPane();
		public  JPanel  Right 		= new JPanel();
		public  JPanel  pLeft1 		= new JPanel(new FlowLayout());
		public JTextField wordtextfile   =new  JTextField();
		public JTextField timetextfile   =new  JTextField();
		public JTextArea meandtextarea   =new  JTextArea();
		public JTextArea  sentencetextarea = new JTextArea();
		public JLabel wordlabel=new JLabel("word");
		public JLabel markslabel=new JLabel("marks");
		public JLabel fieldlabel=new JLabel("field");
		public JLabel timelabel=new JLabel("time");
		public JLabel meandlabel=new JLabel("meand");
		public JLabel sentencelabel=new JLabel("sentence");
		
		public SPComboBoxModel aa = new SPComboBoxModel(Record_Panel.setsomething());
		public SPComboBoxModel bb = new SPComboBoxModel(Record_Panel.setsomething2());
		
		public JComboBox marksbox 		= new JComboBox(aa);
		public JComboBox fieldbox 		= new JComboBox(bb);
		
		public JScrollPane meandtextfilescroll=new JScrollPane(meandtextarea);
		public JScrollPane sentencetextareascroll=new JScrollPane(sentencetextarea);
		public  JSplitPane  sp ;
		public JButton buttonmodify= new JButton("MODIFY");
		public JButton buttonmodelete= new JButton("DELETE");
		public JTextField wordID=new JTextField();
//		public JPanel lllllll() {
//			JPanel aa=new JPanel();
//			return aa;
//		}
		public  JPanel Right() {
			Right.setLayout(null);
			timetextfile.setEditable(false);
//			marksbox.setEditable(true);fieldbox.setEditable(true);
			///////////////////(X,Y,length,wide)
			wordlabel.setBounds    (20,20, 100, 40);		Right.add(wordlabel);
			wordtextfile.setBounds (120,20, 150, 40);		Right.add(wordtextfile);
			fieldlabel.setBounds   (300,20, 50, 40);		Right.add(fieldlabel);
			fieldbox.setBounds(350,20,150, 40);		Right.add(fieldbox);
			
			markslabel.setBounds   (20,70, 100, 40) ;		Right.add(markslabel);
			marksbox.setBounds(120,70,150, 40);		Right.add(marksbox);
			timelabel.setBounds   (300,70, 50, 40) ;		Right.add(timelabel);
			timetextfile.setBounds(350,70,150, 40);			Right.add(timetextfile);
			
			meandlabel.setBounds   (20,120, 50, 40) ;		Right.add(meandlabel);
			meandtextarea.setLineWrap(true);//自动换行
			meandtextfilescroll.setBounds(20,150,545, 60);		Right.add(meandtextfilescroll);
		
			sentencelabel.setBounds   (20,200, 100, 40) ;		Right.add(sentencelabel);
			sentencetextarea.setLineWrap(true);//自动换行
			sentencetextareascroll.setBounds(20,230,545,370);		Right.add(sentencetextareascroll);
			
			
//			pRight = new JScrollPane(textarea2	,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			buttonmodify.setBounds   (450,620, 120, 30) ;  Right.add(buttonmodify);
			buttonmodelete.setBounds (200,620, 120, 30) ;  Right.add(buttonmodelete);
			wordID.setBounds (20,620, 30, 25) ;wordID.setEditable(false);  Right.add(wordID);

			
			return Right;
		}
		public secondFrame() {
			selectdialog.setSize(700, 700);
	        selectdialog.setLocation(600,0);
	        selectdialog.setLayout(null);
	//        pLeft.setViewportView(textarea);//不加这个不会显示文本域
	        pLeft1.setPreferredSize(new Dimension(100,3000));//      JScrollPane不能添加轻量级组件？！
	        pLeft = new JScrollPane(pLeft1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        sp 			= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, Right());
	        sp.setDividerLocation(100); // 设置分割条的 位置
	        selectdialog.setContentPane(sp);// 把sp当作ContentPane
	//        selectdialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//会把主程序一起关掉
	        buttonmodelete.addActionListener(new  ActionListener() {//删除功能
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int confirm = 
							JOptionPane.showConfirmDialog(null,"是否保存当前修改？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if(confirm==0) {
								String id=wordID.getText();
								if(!id.equals("")) {
									SentenceDAO.deletesentence(id);
									int b=wordDAO.deleteword(id);
									if(b==1)
										 JOptionPane.showMessageDialog(null,"已经删除");
									else 
										JOptionPane.showMessageDialog(null,"删除失败,单词不存在");
								}else
									JOptionPane.showMessageDialog(null,"请选择要删除的单词");
							}
						}
			        }
	        );
			buttonmodify.addActionListener(new  ActionListener() {//修改功能
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int confirm = 
							JOptionPane.showConfirmDialog(null,"是否保存当前修改？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if(confirm==0){		
								String id=wordID.getText();
								if(!id.equals("")) {
									word word=new word();
									sentence sentence=new sentence();
									word.words=wordtextfile.getText();
									word.marks=(String) marksbox.getSelectedItem();
									word.field=(String) fieldbox.getSelectedItem();
									word.meand=meandtextarea.getText();
									sentence.id=Integer.parseInt(id);
									sentence.sentence=sentencetextarea.getText();
									System.out.print(sentence.id);
									boolean word_consequence=wordDAO.modify(id,word);
									int consequence1=SentenceDAO.selectsentence(id);
									
									boolean sentence_consequence;
									if(consequence1==0) {//如果没有Sentenceid并且文本不为空，则创建一个sentence对象
										
											if(!sentence.sentence.equals(""))
												SentenceDAO.add(sentence);
												sentence_consequence=true;
												
									}else if(consequence1==1){//如果有Sentence id
										
											if(sentence.sentence.equals("")) {//如果有id,且文本为空
												SentenceDAO.deletesentence(id);
												sentence_consequence=true;
											}
											else {	
												sentence_consequence=SentenceDAO.modify(id,sentence);
											}
									if(word_consequence==true&&sentence_consequence==true)
										 JOptionPane.showMessageDialog(null,"已经修改");
									else if(word_consequence==false&&sentence_consequence==false)
										JOptionPane.showMessageDialog(null,"均修改失败");
									else if(word_consequence==true&&sentence_consequence==false)
										JOptionPane.showMessageDialog(null,"word表单修改成功，sentence修改失败");
									else if(word_consequence==false&&sentence_consequence==true)
										JOptionPane.showMessageDialog(null,"word表单修改失败，sentence修改成功");
									}
								}else 
								JOptionPane.showMessageDialog(null,"请选择要修改的单词");
							}
								
						}
							
			});
		}
		

	
	public static void main(String[] args) {
		secondFrame secondFrame1=new secondFrame();
		secondFrame1.selectdialog.setVisible(true);
	}
}
