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
	public JTextField words4A		=new JTextField();//1����
	public JTextArea meand4B		=new JTextArea();//2��˼
	public JTextArea sentence4C	 	=new JTextArea();//3����
	public JComboBox marks4D 		= new JComboBox(aa);//4���
	public JComboBox field4E 		= new JComboBox(bb);//5����
	public JXDatePicker datepick4F  = new JXDatePicker(new Date());//6���ʱ��
	
	public JButton jbutton4G		=new JButton("ȷ��");
	public JButton jbutton4H		=new JButton("���");
	public JLabel  label4A1			=new JLabel("����");
	public JLabel  label4B1			=new JLabel("��˼");
	public JLabel  label4C1			=new JLabel("����");
	public JLabel  label4D1			=new JLabel("���");
	public JLabel  label4E1			=new JLabel("����");
	public JLabel  label4F1			=new JLabel("ʱ��");
	
	public JScrollPane gdt1 = new JScrollPane(sentence4C);
	public JScrollPane gdt0 = new JScrollPane(meand4B);
	public Record_Panel() {
		this.setLayout(new BorderLayout());//Layout���������Bounds���ԻḲ�ǵ����Լ���Bounds����
//		this.setPreferredSize(new Dimension(100,50));
		this.add(west(), BorderLayout.WEST);
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
//		this.setLayout(new GridLayout(1,2,20,10));

		meand4B.setLineWrap(true);
		sentence4C.setLineWrap(true);
		datepick4F.setEditable(false);
		field4E.setEditable(true);//����������ɱ༭
		addListener();
	}
	
	
	public JPanel west() {//�������
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
	public JPanel center() {//�������
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setLayout(new GridLayout(7,1,0,25));//��������֮��ľ���
		center.setPreferredSize(new Dimension(100,50));//����ÿ��������ʺϴ�С 
		center.add(words4A);		//	words4A.setBounds(50, 0, 100, 20);
		center.add(gdt0);		//	meand4B.setBounds(50, 0, 100, 20);
		center.add(deputy0());		//	marks4D.setBounds(50, 0, 100, 20);
		center.add(deputy1());		//	field4E.setBounds(50, 0, 100, 20);
		center.add(deputy2());	//	datepick4F.setBounds(50, 0, 100, 20);
		center.add(gdt1);	//	sentence4C.setBounds(50, 0, 100, 20);
		return center;
	}
	public JPanel south() {//�������
		JPanel south=new JPanel();
		south.setLayout(null);
		south.setLayout(new GridLayout(1,2,20,0));//��������֮��ľ���
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
		stringbox.add("��ȫ����");	stringbox.add("���");
		stringbox.add("��ȫ����");
		return stringbox;
	}
	
	public static  ArrayList<String> setsomething2(){
		ArrayList<String> stringbox=FieldtypeDAO.selectfield();
		if(stringbox.size()==0)
			stringbox.add("��ͨ");
		return stringbox;
	}
	
	public  void addListener() {//�����д�ķ�������û������-�ᱨ��
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
