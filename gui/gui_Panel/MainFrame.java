package gui_Panel;
import javax.swing.JFrame;
import Util.GUIutil;

public class MainFrame extends JFrame{
	static {
        GUIutil.useLNF();
    }
		public static  MainFrame  mainFrame=new  MainFrame();
		private  MainFrame() {
			this.setTitle("Ҷ����_Ӣ��ѧϰ���");
			this.setSize(700, 700);
			this.setLocation(600,0);
//			this.setLayout(null);
			this.add(Main_panel .mainpanel1);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���������һ��ص�
		}
		public static void main (String[] args ) {
			MainFrame . mainFrame.setVisible(true);
		}
}
