package Util;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
public class CreatFile {
	/*
	 * 此方法的作用主要是判断创建文件是否成功，成功则返回true，否则则返回false
	 * @param destFileName is 目标文件
	 * @return true or false
	 */
	public static boolean createFile(File file){
		
//		File file = new File(destFileName);//根据指定的文件名创建File对象

		//要创建的单个文件连同父文件夹已存在
		if ( file.exists()){  
			return true;
		}
		
		
//		//如果输入的文件是以分隔符结尾的，则说明File对象是目录而不是文件
//		if ( destFileName.endsWith(File.separator)){  
//			System.out.println("文件"+destFileName+"是目录，目标文件不能是目录，创建失败！" );
//			return false;
//		}
		
		//判断目标文件所在目录是否存在？？？？是连同上级的上级吗
		if (!file.getParentFile().exists()){//如果目标文件所在文件夹不存在，则创建父文件夹
			System.out.println("创建"+file.getName()+"所在目录不存在，正在创建！" );
			//判断父文件夹是否存在
			if ( !file.getParentFile().mkdirs() ){
				JOptionPane.showMessageDialog(null, "创建目标文件所在目录失败,请手动创建"+file);
				return false;
			}
		}
		//创建目标文件
		try{
			if ( file.createNewFile() ){
				return true;
			}else{
				JOptionPane.showMessageDialog(null, "创建目标文件失败,请手动创建"+file);
				return false;
			}
		}catch(IOException e){//IOException异常需引入java.io.IOException包
			e.printStackTrace(); //在命令行打印异常信息在程序中出错的位置及原因。
			System.out.println("创建单个文件"+file+"失败！" +e.getMessage());//e.getMessage()只会获得具体的异常名称
			return false;
		}
	}
}
