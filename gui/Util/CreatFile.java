package Util;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
public class CreatFile {
	/*
	 * �˷�����������Ҫ���жϴ����ļ��Ƿ�ɹ����ɹ��򷵻�true�������򷵻�false
	 * @param destFileName is Ŀ���ļ�
	 * @return true or false
	 */
	public static boolean createFile(File file){
		
//		File file = new File(destFileName);//����ָ�����ļ�������File����

		//Ҫ�����ĵ����ļ���ͬ���ļ����Ѵ���
		if ( file.exists()){  
			return true;
		}
		
		
//		//���������ļ����Էָ�����β�ģ���˵��File������Ŀ¼�������ļ�
//		if ( destFileName.endsWith(File.separator)){  
//			System.out.println("�ļ�"+destFileName+"��Ŀ¼��Ŀ���ļ�������Ŀ¼������ʧ�ܣ�" );
//			return false;
//		}
		
		//�ж�Ŀ���ļ�����Ŀ¼�Ƿ���ڣ�����������ͬ�ϼ����ϼ���
		if (!file.getParentFile().exists()){//���Ŀ���ļ������ļ��в����ڣ��򴴽����ļ���
			System.out.println("����"+file.getName()+"����Ŀ¼�����ڣ����ڴ�����" );
			//�жϸ��ļ����Ƿ����
			if ( !file.getParentFile().mkdirs() ){
				JOptionPane.showMessageDialog(null, "����Ŀ���ļ�����Ŀ¼ʧ��,���ֶ�����"+file);
				return false;
			}
		}
		//����Ŀ���ļ�
		try{
			if ( file.createNewFile() ){
				return true;
			}else{
				JOptionPane.showMessageDialog(null, "����Ŀ���ļ�ʧ��,���ֶ�����"+file);
				return false;
			}
		}catch(IOException e){//IOException�쳣������java.io.IOException��
			e.printStackTrace(); //�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
			System.out.println("���������ļ�"+file+"ʧ�ܣ�" +e.getMessage());//e.getMessage()ֻ���þ�����쳣����
			return false;
		}
	}
}
