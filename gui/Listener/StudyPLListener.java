package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Util.GUIutil;
import gui_Panel.Study_Panel;

public class StudyPLListener implements ActionListener{
	
	JButton B = new JButton();
	public   StudyPLListener(JButton B){
		this.B=B;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Study_Panel studyPanel1=Study_Panel.Study_Panel;//这个放在方法外面就会出现空指针异常
		// TODO Auto-generated method stub

		
		if(B.equals(studyPanel1.button3A)) {
			studyPanel1.secondAppearance();
			
		}else if(B.equals(studyPanel1.button3B)) {
			studyPanel1.secondAppearance();
		}else if(B.equals(studyPanel1.button3C)) {
			studyPanel1.secondAppearance();
		}
		
	}

}
