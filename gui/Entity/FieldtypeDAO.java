package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import others.Exception_solvetion;
import others.connectpool;
//FieldtypeDAO.selectfield() 
public class FieldtypeDAO {
	static connectpool connectpool=new connectpool(10);
	
	public static ArrayList<String> selectfield() {
		ArrayList <String> fieldgroup=new ArrayList<>();
		String sql="select * from fieldtype field ";
		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();){
			ResultSet rs =s.executeQuery(sql);
			 
			while (rs.next()) {
				fieldgroup.add(rs.getString("field"));
            }
			connectpool.returnConnection(c);
			return fieldgroup;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return null;
		}	
	}
	
	
	public static void add(field field) {
		String sql="insert into fieldtype values(null,?)" ;//"insert into word values(\"\",'?',\"测试sdsss\",'?',\"?\",\"?\")" ;	
		Connection c = connectpool.getConnection();
		try ( PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, field.field);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
               field.id = id;
            } 
            connectpool.returnConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
		}	
	}
	/*
	 * 删除类型的功能
	 * executeUpdate返回收影响数据的个数，其括号里面没有sql
	 */
	public static int deletefield(String field) {
		int  rs;
		String sql="delete from fieldtype where Field= ? ";
		Connection c=connectpool.getConnection();
		try(PreparedStatement ps = c.prepareStatement(sql);){
			 ps.setString(1, field);
			rs =ps.executeUpdate();
			 connectpool.returnConnection(c);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败");
			return 0;
		}
		
	}
}
