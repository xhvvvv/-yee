package Entity;
import others.Exception_solvetion;
import others.connectpool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import javax.swing.JOptionPane;

import Util.Dateutil;
public class wordDAO{
	static connectpool connectpool=new connectpool(5);
	/*yyyy-MM-dd   HH:mm:ss  hh:mm:ss  都是不一样的效果HH hh分别为12小时制和24小时制，严格得很
	 * 
	 */
	static  String DATE_FORMAT_NOW = "yyyy-MM-dd ";
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
	 static  String DATE_FORMAT_NOW1 = "yyyy-MM-dd HH:mm:ss";
	 SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(DATE_FORMAT_NOW1);
	 public static  String DATE_FORMAT_NOW2 = "HH:mm:ss";
	 SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DATE_FORMAT_NOW2);
	 public String isss(ResultSet rs) throws SQLException {
		 String aa=simpleDateFormat.format(rs.getDate("intime"));
         String bb=simpleDateFormat2.format(rs.getTime("intime"));
         return aa+bb;
	 }
	 

	public String idont_konw(int a) {
		Date date=Dateutil.oneday(a);
		String Date1 = simpleDateFormat.format(date);
		Date1=Date1+"00:00:00" ;
		return Date1;
	}
	
	/////////获取特定时间内的单词       
	public   ArrayList<word> getwords(String chose){
		ArrayList <word> wordsgroup=new ArrayList<word>();
		
		String Date   =idont_konw(0);
		String Date11 =idont_konw(-1);
		String Date22 =idont_konw(-3);
		String Date33   = simpleDateFormat1.format(new Date());
		String sql ="" ;
		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();) {
			if(chose.equals("今天")) {
				sql ="select * from word where intime > ' "//时间必须转换为sql的时间
        				+ Date+" ' ";
        				
			}else if(chose.equals("昨天")) {
				sql ="select * from word where intime between ' "//时间必须转换为sql的时间
        				+ Date11
        				+ " ' and  ' "
        				+ Date33  +" ' ";
			
				
	        }else if(chose.equals("三天内")){
	        		sql ="select * from word where intime between ' "//时间必须转换为sql的时间
	        				+ Date22
	        				+ " ' and  ' "
	        				+ Date33  +" ' ";
	        		
		      	}     
            ResultSet rs =  s.executeQuery(sql);
            while (rs.next()) {
            	word a=new word();
            	a.id     =rs.getInt("id");
            	a.words	 =rs.getString("words");
                a.meand  =rs.getString("meand");
                a.intime =isss(rs);
                a.field  =rs.getString("field");
                a.marks =rs.getString("marks");
//                Date  date =rs.getDate("intime");
                wordsgroup.add(a);
               
            }
            connectpool.returnConnection(c);
            return wordsgroup;
        } catch (SQLException e) {
        	e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
                return null;
            }
 
	}
	
	///////////////
	public int getNBofwords() {
		int NBofwords = 0;
		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();) {
			String sql = "select count(*) from word";
			ResultSet rs = s.executeQuery(sql);
			 while (rs.next()) {
				 NBofwords= rs.getInt(1);
			 }
			
		  } catch (SQLException e) {				
			  e.printStackTrace();
				Exception_solvetion.Exception_solvetion1();
              return -1;
          }
		 connectpool.returnConnection(c);
		 return  NBofwords;
	}
	public  int getARknows() {
		int ARknows = 0;
		String aa="完全掌握" ;
		String sql = "select count(*) from word where marks = \""+aa+"\"";
		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();) {
			
			ResultSet rs = s.executeQuery(sql);
			 while (rs.next()) {
				 ARknows= rs.getInt(1);
			 }
			
		  } catch (SQLException e) {				
			  e.printStackTrace();
				Exception_solvetion.Exception_solvetion1();
              return -1;
          }
		 connectpool.returnConnection(c);
		 
		 return  ARknows;
	}
	/////////////////////////////////
	public  ArrayList<word> selectBofwords(String what) {
		ArrayList <word> wordsgroup=new ArrayList<word>();
		String sql="select * from word where words = ?" ;//废弃 \"输出双引号，这里双引号"\"与" \"有区别，前面有空格，运行的时候会将着一空格当做查询变量
		Connection c = connectpool.getConnection();//PreparedStatementz自动给字符进行格式化
		try (  PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1, what);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				word a   =new word();
            	a.id     =rs.getInt("id");
            	a.words	 =rs.getString("words");
                a.meand  =rs.getString("meand");
                a.intime =isss(rs);
                a.marks=rs.getString("marks");
                a.field=rs.getString("field");
                
                wordsgroup.add(a);
            }
			connectpool.returnConnection(c);
			return wordsgroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return null;
		}
	}
	//////////////////////////////
	public boolean select_word_if_exit(String id) {
		int i;
		String sql="select words from word  where id ="+id;
		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();){
			
			i=s.executeUpdate(sql);
			connectpool.returnConnection(c);
			if(i==0)
				return false;
			else 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return false;
		}
	}
	//////////////////////////////////////////检查相同的单词
	public  ArrayList<word> inspectsame(String what) {
		ArrayList <word> wordsgroup=new ArrayList<word>();
		String sql="select * from word where words like '"+what+"%'" ;

		Connection c = connectpool.getConnection();
		try ( Statement s = c.createStatement();){
			ResultSet rs =s.executeQuery(sql);
			while (rs.next()) {
				word a   =new word();
            	a.id     =rs.getInt("id");
            	a.words	 =rs.getString("words");
                a.meand  =rs.getString("meand");
                a.intime =isss(rs);
                a.field  =rs.getString("field");
                a.marks =rs.getString("marks");
                wordsgroup.add(a);
            }
			 connectpool.returnConnection(c);
			return wordsgroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return null;
		}
	}
	//////////////////////////////////////用中文查询单词
	public  ArrayList<word> selectCHIofwords(String what) {
		ArrayList <word> wordsgroup=new ArrayList<word>();
		
		String sql="select * from word where meand like '%"+what+"%'" ;//

		 Connection cs = connectpool.getConnection();
		try (Statement s = cs.createStatement();){//Connection cs如果放在try中，运行完程序后会直接关闭返回空连接
			ResultSet rs =s.executeQuery(sql);					//,如果不反回连接，线程用完会wiat();
			 
			while (rs.next()) {
				word a   =new word();
				a.id     =rs.getInt("id");
            	a.words	 =rs.getString("words");
                a.meand  =rs.getString("meand");
                a.intime =isss(rs);
                a.field  =rs.getString("field");
                a.marks =rs.getString("marks");
                wordsgroup.add(a);
            }
			
			
			connectpool.returnConnection(cs);
//			println(connectpool.cs.size());
			return wordsgroup;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return null;
		}
		
		
	}
	///////////////////////////////////////////增
	public  void add(word word) {
		String sql="insert into word values(null,?,?,?,?,?)" ;//"insert into word values(\"\",'?',\"测试sdsss\",'?',\"?\",\"?\")" ;

		String Date   = simpleDateFormat1.format(new Date());
		Connection c = connectpool.getConnection();
		try (PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1, word.words);
            ps.setString(2, word.meand);
            ps.setString(3, Date );
            ps.setString(4, word.field);
            ps.setString(5, word.marks);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                word.id = id;
            }  
            connectpool.returnConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
		}	
	}
	////////////////删除 ,,,如果有外键约束，需要先删除外键
	public static int deleteword(String id) {
		int  rs;
		String sql="delete from word where id= "+id;
		Connection c=connectpool.getConnection();
		try(Statement s = c.createStatement();){
			rs =s.executeUpdate(sql);
			 connectpool.returnConnection(c);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败");
			return 0;
		}
		
	}
	public static boolean modify(String id,word word) {
		int rs;
		Connection c=connectpool.getConnection();
		String sql="update word set words=?, meand= ? , field=? , marks=?  where id= ? ";
		try(PreparedStatement ps=c.prepareStatement(sql);){
			ps.setString(1, word.words);
            ps.setString(2, word.meand);
            ps.setString(3, word.field);
            ps.setString(4, word.marks);
            ps.setString(5, id);
            rs =ps.executeUpdate();
            connectpool.returnConnection(c);
            if(rs==0)
				return false;
			else 
				return true;
			
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Exception_solvetion.Exception_solvetion1();
			return false;
		}
	}
	/*
	 * 修改所有领域
	 */
	public static int modifyfield(String field,String turntofield) {
		int rs;
		Connection c=connectpool.getConnection();
		String sql="update word set field= ?  where field= ? ";
		try(PreparedStatement ps=c.prepareStatement(sql);){
			ps.setString(1, turntofield);
            ps.setString(2, field);
            rs =ps.executeUpdate();//注意executeUpdate()有无sql的区别
            connectpool.returnConnection(c);
			return rs;     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败了");
			return -1;
		}
	}

	public static void main(String[] args) {
		wordDAO newwordDAO=new wordDAO();
		ArrayList<word> test=newwordDAO.getwords("昨日");
		System.out.println(test.size());
	}
}

