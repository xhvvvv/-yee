package Listener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Service.Initial_PanelService;
import gui_Panel.Initial_Panel;

public class InitialPLListener implements ActionListener{
	int frequency=0;
	public void realaction() {
		Initial_PanelService initial_PanelService=new Initial_PanelService();
		Initial_Panel		 Initial_Panel1			=Initial_Panel. Initial_Panel;//��仰Ϊʲô���ܷ��ڳ�Ա�У�������������
		//��Ϊ���췽���в�û��ִ����仰��������ڳ�Ա��ͨ������������ֻ��ִ��action�������������ʼ��Ա����
		String NBofwords  = initial_PanelService.NBofwords;
		String  ARknows   = initial_PanelService.ARknows; 
		String  ETfield   = initial_PanelService.ETfield;
		
		Initial_Panel1. jlable1A1.setText(NBofwords);
		Initial_Panel1.	jlable1B1.setText(ARknows);
		Initial_Panel1.	jlable1C1.setText(ETfield);
		frequency++;
	}
	
	public void actionPerformed(ActionEvent e) {
		realaction();
		Runnable runnable=new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(frequency!=0) {
						frequency=0;
					}
				}
			}
		};
		
		if(frequency==5) {
			frequency=0;
			JOptionPane.showMessageDialog(null,"�벻Ҫ�ظ����");
		}
		new Thread(runnable).start();
	}

}
