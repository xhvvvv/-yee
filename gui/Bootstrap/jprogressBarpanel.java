package Bootstrap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
//extends Thread
public class jprogressBarpanel extends Thread{
	
	public void run() {
		JFrame frame = new JFrame("程序启动中");
    	JPanel jprogressBarpanel=new JPanel();
    	
    	JProgressBar pbar = new JProgressBar();
	    int MY_MINIMUM = 0;
	    int MY_MAXIMUM = 100;
        // 显示百分比
        pbar.setMinimum(MY_MINIMUM);
        pbar.setMaximum(MY_MAXIMUM);
        jprogressBarpanel.add(pbar);
	// TODO Auto-generated method stub
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jprogressBarpanel);
        frame.pack();
        pbar.setStringPainted(true);
        frame.setVisible(true);
        for (int i = MY_MINIMUM; i <MY_MAXIMUM; i++) {
	            final int percent = i;
	            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	pbar.setValue(percent);
                    }
                });
	            try {
					 java.lang.Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
        
        frame.dispose();//销毁窗口
	}
        public static void main(String args[]) {
        	jprogressBarpanel aa=new jprogressBarpanel();
        	aa.run();
        	System.out.print("ss");
        	jprogressBarpanel jprogressBarpanel1 =new jprogressBarpanel();
        	jprogressBarpanel1.start();
        }

}
