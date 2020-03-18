package Service;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import Util.MysqlUtil;
import gui_Panel.Configure_Panel;
import gui_Panel.Main_panel;

 

public class RecoverServe {
	static JPanel remindpanel=new JPanel();//Ã·–—√Ê∞Â
	public RecoverServe() {
		Configure_Panel configure_Panel1=Configure_Panel. configure_Panel;
        String mysqlPath= configure_Panel1.restore.getText();
	        if(0==mysqlPath.length()){
	            JOptionPane.showMessageDialog(remindpanel, "ª÷∏¥«∞«Î ¬œ»≈‰÷√mysqlµƒ¬∑æ∂");
	            Main_panel .mainpanel1.panel.show(configure_Panel1);
	            configure_Panel1.backup.grabFocus();
	            return;
	        }
	        JFileChooser fc = new JFileChooser();
	        fc.setSelectedFile(new File("hutubill.sql"));
	        fc.setFileFilter(new FileFilter() {
	             
	            @Override
	            public String getDescription() {
	                return ".sql";
	            }
	             
	            @Override
	            public boolean accept(File f) {
	                return f.getName().toLowerCase().endsWith(".sql");
	            }
	        });
	 
	         int returnVal =  fc.showOpenDialog(remindpanel);
	         File file = fc.getSelectedFile();

	         if (returnVal == JFileChooser.APPROVE_OPTION) {
	            try {
	                MysqlUtil.recover(mysqlPath,file.getAbsolutePath());
	                JOptionPane.showMessageDialog(remindpanel, "ª÷∏¥≥…π¶");
	            } catch (Exception e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(remindpanel, "ª÷∏¥ ß∞‹\r\n,¥ÌŒÛ:\r\n"+e1.getMessage());  
	            }
	              
	         }
}
}
