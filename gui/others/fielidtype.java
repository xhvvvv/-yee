package others;

import java.util.ArrayList;

import Entity.FieldtypeDAO;
/*�ж��Ƿ����ظ��ģ�����оͷ���true
 * 
 * 
 * 
 * fielidtype 
 */

public class fielidtype {
	static FieldtypeDAO newfieldtypeDAO=new FieldtypeDAO();
	static ArrayList<String> fieldgroup=newfieldtypeDAO.selectfield(); //��ȡ���ݿ��ȫ��field
	public static boolean fielidtype1(String stringfield) {//����һ��field������Ƿ����ظ����з���t
		int j=0;
		for(int i=0;i<fieldgroup.size();i++) {
			if(fieldgroup.get(i).equals(stringfield)) {
				j++;
				break ;
			}
		}
		if(j!=0)
			return true;
		else
			return false;
	
	}
}