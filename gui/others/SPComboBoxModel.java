package others;
import java.util.ArrayList;
//Jcombobox��ֱ�Ӷ�ȡSPComboBoxModel�����������Ϊ������
import java.util.List;

import javax.swing.ComboBoxModel;
/////////////������ʾcombox�������е����ݣ���������ʾ���뿪��
import javax.swing.event.ListDataListener;
public class SPComboBoxModel implements ComboBoxModel{
	    public List<String> cs = new ArrayList<>();
	    String c;
	    
	    
	    public SPComboBoxModel(ArrayList<String> aa){
	    	for(int i=0;i<aa.size();i++) {
	        cs.add(aa.get(i));
	       	
	    	}
	    	c=cs.get(0);
	    }
	    public int getSize() {
	        return cs.size();
	    }
	 
	    public String getElementAt(int index) {
	        return cs.get(index);
	    }
	 
	    public void addListDataListener(ListDataListener l) {
	        // TODO Auto-generated method stub
	         
	    }
	 
	    public void removeListDataListener(ListDataListener l) {
	        // TODO Auto-generated method stub
	         
	    }
	    
		@Override
		public Object getSelectedItem() {
			// TODO Auto-generated method stub
			return c;
		}

		@Override
		public void setSelectedItem(Object anItem) {
			// TODO Auto-generated method stub
			 c = (String) anItem;
		}
	 
	}

