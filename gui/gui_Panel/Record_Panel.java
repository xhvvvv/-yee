package gui_Panel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import Entity.FieldtypeDAO;
import Listener.RecordPLListener;
import Util.GUIutil;
import others.SPComboBoxModel;

//Record_Panel.jbutton4G
public class Record_Panel extends JPanel{
	static  {
        GUIutil.useLNF();
    }
	public static Record_Panel Record_Panel=new Record_Panel();
	
	public SPComboBoxModel aa  		=new SPComboBoxModel (setsomething());
	public SPComboBoxModel bb  		=new SPComboBoxModel (setsomething2());
	public JTextField words4A		=new JTextField();//1单词
	public JTextArea meand4B		=new JTextArea();//2意思
	public JTextArea sentence4C	 	=new JTextArea();//3句子
	public JComboBox marks4D 		= new JComboBox(aa);//4标记
	public JComboBox field4E 		= new JComboBox(bb);//5领域
	public JXDatePicker datepick4F  = new JXDatePicker(new Date());//6添加时间
	
	public JButton jbutton4G		=new JButton("确定");
	public JButton jbutton4H		=new JButton("检测");
	public JLabel  label4A1			=new JLabel("单词");
	public JLabel  label4B1			=new JLabel("意思");
	public JLabel  label4C1			=new JLabel("句子");
	public JLabel  label4D1			=new JLabel("标记");
	public JLabel  label4E1			=new JLabel("领域");
	public JLabel  label4F1			=new JLabel("时间");
	
	public JScrollPane gdt1 = new JScrollPane(sentence4C);
	public JScrollPane gdt0 = new JScrollPane(meand4B);
	public Record_Panel() {
		this.setLayout(new BorderLayout());//Layout中所定义的Bounds属性会覆盖掉你自己的Bounds属性
//		this.setPreferredSize(new Dimension(100,50));
		this.add(west(), BorderLayout.WEST);
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
//		this.setLayout(new GridLayout(1,2,20,10));

		meand4B.setLineWrap(true);
		sentence4C.setLineWrap(true);
		datepick4F.setEditable(false);
		field4E.setEditable(true);//设置下拉框可编辑
		addListener();
	}
	
	
	public JPanel west() {//西方面板
		JPanel west=new JPanel();
		west.setLayout(null);	
		west.setLayout(new GridLayout(7,1,20,10));
		west.add(label4A1);		//	label4A1.setBounds(0, 0, 50, 50);
		west.add(label4B1);		//	label4B1.setBounds(50, 0, 100, 20);
		west.add(label4D1);		//	label4D1.setBounds(50, 0, 100, 20);
		west.add(label4E1);		//	label4E1.setBounds(50, 0, 100, 20);
		west.add(label4F1);		//	label4F1.setBounds(50, 0, 100, 20);
		west.add(label4C1);		//	label4C1.setBounds(50, 0, 100, 20);
		
		return west;
	}
	public JPanel center() {//中央面板
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setLayout(new GridLayout(7,1,0,25));//设置网格之间的距离
		center.setPreferredSize(new Dimension(100,50));//设置每个组件的适合大小 
		center.add(words4A);		//	words4A.setBounds(50, 0, 100, 20);
		center.add(gdt0);		//	meand4B.setBounds(50, 0, 100, 20);
		center.add(deputy0());		//	marks4D.setBounds(50, 0, 100, 20);
		center.add(deputy1());		//	field4E.setBounds(50, 0, 100, 20);
		center.add(deputy2());	//	datepick4F.setBounds(50, 0, 100, 20);
		center.add(gdt1);	//	sentence4C.setBounds(50, 0, 100, 20);
		return center;
	}
	public JPanel south() {//北方面板
		JPanel south=new JPanel();
		south.setLayout(null);
		south.setLayout(new GridLayout(1,2,20,0));//设置网格之间的距离
		south.add(jbutton4G);	//	jbutton4G.setBounds(50, 0, 100, 20);
//		south.add(jbutton4H);	//	jbutton4G.setBounds(50, 0, 100, 20);
		return south;
	}
	public JPanel deputy0() {
		JPanel deputy0=new JPanel();
		deputy0.setLayout(null);
		marks4D.setBounds(220, 10, 150, 20);
		deputy0.add(marks4D);
		return deputy0;
	}
	public JPanel deputy1() {
		JPanel deputy1=new JPanel();
		deputy1.setLayout(null);
		field4E.setBounds(220, 10, 150, 20);
		deputy1.add(field4E);
		return deputy1;
	}
	public JPanel deputy2() {
		JPanel deputy2=new JPanel();
		deputy2.setLayout(null);
		datepick4F.setBounds(220, 10, 150, 20);
		deputy2.add(datepick4F);
		return deputy2;
	}

	
	
	public static ArrayList<String> setsomething(){
		ArrayList<String> stringbox=new  ArrayList<String>();
		stringbox.add("完全生疏");	stringbox.add("差不多");
		stringbox.add("完全掌握");
		return stringbox;
	}
	
	public static  ArrayList<String> setsomething2(){
		ArrayList<String> stringbox=FieldtypeDAO.selectfield();
		if(stringbox.size()==0)
			stringbox.add("普通");
		return stringbox;
	}
	
	public  void addListener() {//如果重写的方法里面没有主体-会报错
	        // TODO Auto-generated method stub
		RecordPLListener listener = new RecordPLListener();
		jbutton4G.addActionListener(listener);
//		jbutton4H.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GUIutil.showPanel(Record_Panel. Record_Panel );
	}

}
