package Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import Util.MysqlUtil;
import gui_Panel.Configure_Panel;
import gui_Panel.Main_panel;
public class BackUpServe {
	static JPanel remindpanel=new JPanel();//�������
	public BackUpServe(){
			Configure_Panel configure_Panel1=Configure_Panel. configure_Panel;
	        String mysqlPath= configure_Panel1.backup.getText();
	        
	        if(0==mysqlPath.length()){
	            JOptionPane.showMessageDialog(remindpanel, "����ǰ����������mysql��·��");
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
	 
	         int returnVal =  fc.showSaveDialog(configure_Panel1);
	         File file = fc.getSelectedFile();
	         System.out.println(file);
	         
	         if (returnVal == JFileChooser.APPROVE_OPTION) {
	             //���������ļ���û����.sql��β���Զ�����.sql
	             
	             if(!file.getName().toLowerCase().endsWith(".sql"))
	                 file = new File(file.getParent(),file.getName()+".sql");

	              
	            try { System.out.println("ok");
	                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
		            
		             
	                JOptionPane.showMessageDialog(remindpanel, "���ݳɹ�,�����ļ�λ��:\r\n"+file.getAbsolutePath());
	            } catch (Exception e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(remindpanel, "����ʧ��\r\n,����:\r\n"+e1.getMessage());  
	            }
	              
	         }     
	  
	 
	}
}
