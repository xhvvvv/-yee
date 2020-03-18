package Util;
import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Entity.Sqlconnection;
import Service.Configure_PanelServe;
import gui_Panel.Configure_Panel;
import gui_Panel.MainFrame;
import others.Exception_solvetion;
public class SqlConnect {
//    static String ip = "127.0.0.1";
//    static int port = 3306;
//    static String database = "english";
//    static String encoding = "UTF-8";
//    static String loginName = "root";
//    static String password = "admin";
//	ip   port   encoding   loginName
	static JPanel remindpanel=new JPanel();//提醒面板
	static String ip ;
 	static int port ;
    static String database ;
    static String encoding ;
    static String loginName ;
    static String password;
    static{
    	File sqlfile=new File("D:\\\\confine\\\\SQLMATION.txt");
		Sqlconnection  sqlconnection=Configure_PanelServe.Readtxt(sqlfile) ;
		ip=sqlconnection.ip;
		database=sqlconnection.database;
		port=Integer.valueOf(sqlconnection.port).intValue();
		encoding=sqlconnection.encoding;
		loginName=sqlconnection.loginName;
		password=sqlconnection.password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()  {
    	try {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    	}catch(SQLException e) {
    		Exception_solvetion.Exception_solvetion();
			   return null;
		 }
    	
    }
    public static void main(String[] args) {
    	try (Connection c = getConnection(); ) {
    		if(c==null)
    			System.out.println("连接不成功");	
    		else 
    			System.out.println("连接成功");		
        } catch (SQLException e) {
             e.printStackTrace();
            System.out.println("连接不成功");
        }
    
    }
}