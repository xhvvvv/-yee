package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Service.BackUpServe;
import gui_Panel.thirdJDialog;
///////////·ÏÆúÀà 0312159!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class RemindListener implements ActionListener {
	
	JButton  sure;
	JButton  Regrets;
	public RemindListener(JButton  sure,JButton  Regrets) {
	
		this.Regrets=Regrets;
		this. sure= sure;	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		thirdJDialog  thirdJDialog11=thirdJDialog.thirdJDialog1;;
//		thirdJDialog  thirdJDialog12=thirdJDialog.thirdJDialog2;
//		// TODO Auto-generated method stub
//		JButton     source 	=  (JButton)e.getSource();
//		if( source.equals(Regrets)) {
//			thirdJDialog11.setVisible(false);
//			thirdJDialog12.setVisible(false);
//		}else if(source.equals(thirdJDialog11.sure)){
//			BackUpServe aa=new BackUpServe();
//			System.out.print("1111111111111111");
//		}else if(source.equals(thirdJDialog12.sure)) {
//			System.out.print("2222222222222");
//		}
	}

}
