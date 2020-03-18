package gui_Panel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listener.SelectPListener;
import Util.GUIutil;
import others.SPComboBoxModel;
/**
 * @author xuhangvvvv
 *根据单词查找，根据中文查找，根据日期查找
 */
public class select_Panel extends JPanel{
	static {
        GUIutil.useLNF();
    }
	public static select_Panel select_Panel=new select_Panel ();
	
	public String numbers="0"; ;String command;
	public SPComboBoxModel aa=new SPComboBoxModel (setsomething());
	public JComboBox jcombobox = new JComboBox(aa);
	public JButton button2A=new JButton("确定");
	
	public SPComboBoxModel bb 		=new SPComboBoxModel (Record_Panel.Record_Panel.setsomething2());

	JLabel jlable2A=new JLabel("wordsquery"); public  JTextField textfield2A1=new JTextField(); public  JButton button2A2=new JButton("确定");
	JLabel jlable2B=new JLabel("CHquery");    public JTextField textfield2B1=new JTextField();  public  JButton button2B2=new JButton("确定");
	JLabel jlable2C=new JLabel("fieldNumber"); public JComboBox  fieldbox 		= new JComboBox(bb);  public  JButton     deletefield   =new JButton("删除类型");
	JLabel jlable2D=new JLabel("ranges");
	
	
	
	
	
	/////////////////////////////

	
	
	public select_Panel () {
		this.setLayout(new GridLayout(4,3));
		fieldbox.setEditable(true);
		jcombobox.setBounds(50, 50, 80, 30);
		fieldbox.setBounds(50, 50, 80, 20);
		command=(String) jcombobox.getSelectedItem() ;
		add(jlable2A);  add( textfield2A1);  add( button2A2);  
		add(jlable2B);  add(textfield2B1);   add(button2B2);  
		add(jlable2C);  add(fieldbox);      add( deletefield);  
		add(jlable2D);  add(jcombobox);      add(button2A);   
		 addListener();
		
	}
	public ArrayList<String> setsomething(){
		ArrayList<String> stringbox=new  ArrayList<String>();
		stringbox.add("今天");stringbox.add("昨天"); stringbox.add("三天内");
		return stringbox;
	}
	
	public void addListener() {
        // TODO Auto-generated method stub
		SelectPListener listener = new SelectPListener();
		button2A2.addActionListener(listener);
		button2B2.addActionListener(listener);
		deletefield.addActionListener(listener);
		button2A.addActionListener(listener);
    }
	
	
	public static void main(String[] args) {
         
	        GUIutil.showPanel(select_Panel.select_Panel );
	    }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
}
