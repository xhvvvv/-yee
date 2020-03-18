package others;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.SqlConnect;
  //�ٷ��汾��pooledconnection�ò������Լ���һ��
public class connectpool {
    public List<Connection> cs = new ArrayList<Connection>();
    int size;
    public connectpool(int size) {
        this.size = size;
        init();
    }

    public void init() {       
        //����ǡǡ����ʹ��try-with-resource�ķ�ʽ����Ϊ��Щ���Ӷ���Ҫ��"��"�ģ���Ҫ���Զ��ر���
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = SqlConnect.getConnection();
                cs.add(c);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }
  
    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }
  
    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
  
}