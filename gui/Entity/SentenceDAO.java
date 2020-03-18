package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import others.Exception_solvetion;
import others.connectpool;

public class SentenceDAO {
	static connectpool connectpool=new connectpool(5);
	static Connection abbc= connectpool.getConnection();//拿出一条循环连接
	//////////////////////////////////////////
	public static void add(sentence sentence) {
		String sql="insert into sentence values(?,?)" ;
		Connection c = connectpool.getConnection();
		try ( PreparedStatement ps = c.prepareStatement(sql);){
			ps.setInt(1, sentence.id);
			ps.setString(2, sentence.sentence);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            
            while (rs.next()) {
            	int id = rs.getInt(1);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
		  }
			
	}
		//////////////////////////////////////
		public static sentence wordidtogetsentence(int wordsid) {//一次只能查询一个，我蒙蔽了，后期有办法就改进
			sentence sentence1=new sentence();
			try ( Statement s = abbc.createStatement();){
					String sql="select * from sentence where id= "+wordsid;
					s.execute(sql);
		            ResultSet rs = s.getResultSet();
		            if(rs.next()) {
		            	sentence1.id=rs.getInt("id");
		            	sentence1.sentence=rs.getString("sentences");
		            }
		         return sentence1;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Exception_solvetion.Exception_solvetion1();
					return null;
				}
		}
		
		public static int deletesentence(String id) {
			int  rs;
			String sql="delete from sentence where id= "+id;
			Connection c=connectpool.getConnection();
			try(Statement s = c.createStatement();){
				rs =s.executeUpdate(sql);
				 connectpool.returnConnection(c);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Exception_solvetion.Exception_solvetion1();
				return 0;
			}
			
		}
		public static int selectsentence(String id) {
			int rs1=0;;
			String sql="select count(*) from sentence where id= "+id;
			Connection c=connectpool.getConnection();
			try(Statement s = c.createStatement();){
				 ResultSet rs = s.executeQuery(sql);
		            if(rs.next()) {
		                rs1 = rs.getInt(1);
		            }
				 connectpool.returnConnection(c);
				return rs1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Exception_solvetion.Exception_solvetion1();
				return 0;
			}
			
		}
		public static boolean modify(String id,sentence sentence) {
			int rs;
			Connection c=connectpool.getConnection();
			String sql="update sentence set sentences= ?  where id= ?";
			try(PreparedStatement ps=c.prepareStatement(sql);){
				ps.setString(1, sentence.sentence);
	            ps.setString(2, id);
	            rs =ps.executeUpdate();//注意executeUpdate()没有sql，已经预执行了
	            connectpool.returnConnection(c);
	            if(rs==1)
					return true;
				else 
					return false;     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Exception_solvetion.Exception_solvetion1();
				return false;
			}
		}
}
