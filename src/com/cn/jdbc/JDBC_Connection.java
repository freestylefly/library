package com.cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	static String drivername="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/library";
	static String username="root";
	static String password="aaaaa123";
	
	static {
		try{
			Class.forName(drivername);
			System.out.println("创建驱动成功");
		}catch (ClassNotFoundException e){
			System.out.println("创建驱动失败，请检查");
			e.printStackTrace();
		}
	}
   public static Connection getConnection(){
	   Connection conn=null;
	   try{
		   conn=(Connection)DriverManager.getConnection(url,username,
				   password);
		   System.out.println("连接数据库成功");
	   }catch(SQLException e){
		   System.out.println("连接数据库失败，请检查");
		   e.printStackTrace();
	   }
	   return conn;
   }
   public static void free(ResultSet rs,Connection conn,Statement stmt){
	   try{
		   if(rs!=null)
			   rs.close();
	   }catch (SQLException e){
		   System.out.println("关闭ResultSet失败");
		   e.printStackTrace();
	   }finally {
		   try{
			   if(conn!=null)
				   conn.close();
		   }catch(SQLException e){
			   System.out.println("关闭connection失败");
			   e.printStackTrace();
		   }finally{
			   try{
				   if(stmt!=null)
					   stmt.close();
			   }catch (SQLException e){
				   System.out.println("关闭Statement失败");
				   e.printStackTrace();
			   }
		   }
	   }
   }
   public static void main(String[] args){
	   JDBC_Connection.getConnection();
   }
}
