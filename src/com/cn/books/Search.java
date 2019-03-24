package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;
public class Search {
	public List<BooksVo> showSearch(int page,String bookinfo,String keyinfo){//查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BooksVo> list = new ArrayList<BooksVo>();
		if(bookinfo.equals("bookname")){
			try {
				conn = JDBC_Connection.getConnection();
				
				String sql = "select * from bookinfo where bookname like ? order by shuhao desc limit?,5";//查询的SQL语句，
				pstmt = conn.prepareStatement(sql);
				System.out.println("参数传值成功"+keyinfo);
				pstmt.setString(1,"%"+keyinfo+"%");
				pstmt.setInt(2,(page-1)*5);
				rs=pstmt.executeQuery();
				System.out.println("检索方法执行");
				while(rs.next()){
					BooksVo booksVo = new BooksVo();
					//	把各属性放入borrowsVo对象中
					booksVo.setShuhao(rs.getString("shuhao"));
					booksVo.setBookname(rs.getString("bookname"));
					booksVo.setAuthor(rs.getString("author"));
					booksVo.setPublishing(rs.getString("publishing"));
					booksVo.setPublishingtime(rs.getString("publishingtime"));
					booksVo.setPrice(rs.getString("price"));
					booksVo.setAdress(rs.getString("adress"));
					booksVo.setIsrenting(rs.getInt("isrenting"));
					
					list.add(booksVo);//把borrowsVo对象放入集合中
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}else if(bookinfo.equals("author")){
			try {
				conn = JDBC_Connection.getConnection();
				
				String sql = "select * from bookinfo where author like ? order by shuhao desc limit?,5";//查询的SQL语句，
				pstmt = conn.prepareStatement(sql);
				System.out.println("参数传值成功"+keyinfo);
				pstmt.setString(1,"%"+keyinfo+"%");
				pstmt.setInt(2,(page-1)*5);
				rs=pstmt.executeQuery();
				System.out.println("检索方法执行");
				while(rs.next()){
					BooksVo booksVo = new BooksVo();
					//	把各属性放入borrowsVo对象中
					booksVo.setShuhao(rs.getString("shuhao"));
					booksVo.setBookname(rs.getString("bookname"));
					booksVo.setAuthor(rs.getString("author"));
					booksVo.setPublishing(rs.getString("publishing"));
					booksVo.setPublishingtime(rs.getString("publishingtime"));
					booksVo.setPrice(rs.getString("price"));
					booksVo.setAdress(rs.getString("adress"));
					booksVo.setIsrenting(rs.getInt("isrenting"));
					
					list.add(booksVo);//把borrowsVo对象放入集合中
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}else if(bookinfo.equals("publishing")){
			try {
				conn = JDBC_Connection.getConnection();
				
				String sql = "select * from bookinfo where publishing like ? order by shuhao desc limit?,5";//查询的SQL语句，
				pstmt = conn.prepareStatement(sql);
				System.out.println("参数传值成功"+keyinfo);
				pstmt.setString(1,"%"+keyinfo+"%");
				pstmt.setInt(2,(page-1)*5);
				rs=pstmt.executeQuery();
				System.out.println("检索方法执行");
				while(rs.next()){
					BooksVo booksVo = new BooksVo();
					//	把各属性放入borrowsVo对象中
					booksVo.setShuhao(rs.getString("shuhao"));
					booksVo.setBookname(rs.getString("bookname"));
					booksVo.setAuthor(rs.getString("author"));
					booksVo.setPublishing(rs.getString("publishing"));
					booksVo.setPublishingtime(rs.getString("publishingtime"));
					booksVo.setPrice(rs.getString("price"));
					booksVo.setAdress(rs.getString("adress"));
					booksVo.setIsrenting(rs.getInt("isrenting"));
					
					list.add(booksVo);//把borrowsVo对象放入集合中
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		return list;
	}
	
	public int maxpage(String bookinfo,String keyinfo){//获取最大页数查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		if(bookinfo.equals("bookname")){
			try {
				conn  = JDBC_Connection.getConnection();
				String sql ="select count(*) from bookinfo where bookname like ?";//查询总记录数的SQL语
				pstmt = conn.prepareStatement(sql);
				System.out.println("keyinfo传值："+keyinfo);
				pstmt.setString(1, "%"+keyinfo+"%");
				rs=pstmt.executeQuery();
				System.out.println("分页方法调用成功");
				while (rs.next()) {
					count = rs.getInt(1);//?如果结果集存在，记录数初始化值为1
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}else if(bookinfo.equals("author")){
			try {
				conn  = JDBC_Connection.getConnection();
				String sql ="select count(*) from bookinfo where author like ?";//查询总记录数的SQL语
				pstmt = conn.prepareStatement(sql);
				System.out.println("keyinfo传值："+keyinfo);
				pstmt.setString(1, "%"+keyinfo+"%");
				rs=pstmt.executeQuery();
				System.out.println("分页方法调用成功");
				while (rs.next()) {
					count = rs.getInt(1);//?如果结果集存在，记录数初始化值为1
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}else if(bookinfo.equals("publishing")){
			try {
				conn  = JDBC_Connection.getConnection();
				String sql ="select count(*) from bookinfo where publishing like ?";//查询总记录数的SQL语
				pstmt = conn.prepareStatement(sql);
				System.out.println("keyinfo传值："+keyinfo);
				pstmt.setString(1, "%"+keyinfo+"%");
				rs=pstmt.executeQuery();
				System.out.println("分页方法调用成功");
				while (rs.next()) {
					count = rs.getInt(1);//?如果结果集存在，记录数初始化值为1
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		System.out.println("测试执行"+maxpage);
		return maxpage;
	}

}