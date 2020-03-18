package others;

import java.util.ArrayList;

import Entity.FieldtypeDAO;
/*判断是否有重复的，如果有就返回true
 * 
 * 
 * 
 * fielidtype 
 */

public class fielidtype {
	static FieldtypeDAO newfieldtypeDAO=new FieldtypeDAO();
	static ArrayList<String> fieldgroup=newfieldtypeDAO.selectfield(); //获取数据库的全部field
	public static boolean fielidtype1(String stringfield) {//输入一个field，检测是否有重复，有返回t
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