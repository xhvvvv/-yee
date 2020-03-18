package gui_Panel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Listener.StudyPLListener;
import Util.GUIutil;

public class Study_Panel extends JPanel{
	static {
        GUIutil.useLNF();
    }

	public static Study_Panel Study_Panel=new Study_Panel();
//	public JComboBox<String> jcombobox = new JComboBox<>(new SPComboBoxModel (setsomething()));
	public JButton button3A=new JButton("����");
	public JButton button3B=new JButton("������");
	public JButton button3C=new JButton("һ��������");
	public JLabel  jlabel   =new JLabel("�ù�����δ����");
	
	public Study_Panel () {
		this.setLayout(new GridLayout(3,1));
//		jcombobox.setBounds(100,100, 150, 100);
//		add(jcombobox);
		add(button3A);
		add(button3B);
		add(button3C);
		
		addListener(button3A) ;
		addListener(button3B) ;
		addListener(button3C) ;
	}
	
	public void secondAppearance() {
		this.remove(button3A);this.remove(button3B);
		this.remove(button3C);
		this.add(jlabel);
		this.updateUI();
		this.repaint();
		
		
	}
	
//	public ArrayList<String> setsomething(){//����combox�������
//		ArrayList<String> stringbox=new  ArrayList<String>();
//		stringbox.add("����"); 
//		stringbox.add("������");
//		stringbox.add("һ��������"); 
//		
//		return stringbox;
//	}
	public void addListener(JButton B) {
        // TODO Auto-generated method stub
		StudyPLListener Listener=new StudyPLListener( B );
		B.addActionListener(Listener);
    }
	public static void main(String[] args) {
          
	      GUIutil.showPanel(Study_Panel.Study_Panel );
	}
}
