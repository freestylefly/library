package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class UpdateBook {
	public void updatebook(BooksVo booksVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句

		try {
			//修改sql语句
			String sql = 
				"update bookinfo set shuhao=?, bookname=? ,author=?, publishing=?,publishingtime=?,price=?,adress=?,isrenting=? where shuhao = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到修改的sql语句中
			
			pstmt.setString(1, booksVo.getShuhao());
			pstmt.setString(2, booksVo.getBookname());
			pstmt.setString(3, booksVo.getAuthor());
			pstmt.setString(4, booksVo.getPublishing());
			pstmt.setString(5, booksVo.getPublishingtime());
			pstmt.setString(6, booksVo.getPrice());
			pstmt.setString(7, booksVo.getAdress());
			pstmt.setInt(8, booksVo.getIsrenting());
			pstmt.setString(9, booksVo.getShuhao());
			
			pstmt.executeUpdate();//执行修改sql语句
			System.out.println("修改成功"+booksVo.getShuhao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

}
