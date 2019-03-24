package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cn.jdbc.JDBC_Connection;

public class AddBook {
	public int addBook(BooksVo booksVo){
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try{
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn=JDBC_Connection.getConnection();
			//添加数据的SQL语句
			String sql="insert into bookinfo(shuhao,bookname,author,publishing," +
					"publishingtime,price,adress)value(?,?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, booksVo.getShuhao());
			pstm.setString(2, booksVo.getBookname());
			pstm.setString(3, booksVo.getAuthor());
			pstm.setString(4, booksVo.getPublishing());
			pstm.setString(5, booksVo.getPublishingtime());
			pstm.setString(6, booksVo.getPrice());
			pstm.setString(7, booksVo.getAdress());
			pstm.executeUpdate();//提交pstm对象
			System.out.println("添加成功");
			System.out.println();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstm);
		}
		return 1;
	}

}
