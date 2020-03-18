package gui_Panel;
import javax.swing.JFrame;
import Util.GUIutil;

public class MainFrame extends JFrame{
	static {
        GUIutil.useLNF();
    }
		public static  MainFrame  mainFrame=new  MainFrame();
		private  MainFrame() {
			this.setTitle("叶子香_英语学习软件");
			this.setSize(700, 700);
			this.setLocation(600,0);
//			this.setLayout(null);
			this.add(Main_panel .mainpanel1);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//会把主程序一起关掉
		}
		public static void main (String[] args ) {
			MainFrame . mainFrame.setVisible(true);
		}
}
