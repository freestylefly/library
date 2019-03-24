package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class QueryById {
	public BooksVo queryById(String shuhao){
		BooksVo booksVo=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=JDBC_Connection.getConnection();
			pstmt=conn.prepareStatement("select*from bookinfo where shuhao=?");
			pstmt.setString(1, shuhao);
			rs=pstmt.executeQuery();
			while(rs.next()){
				booksVo=new BooksVo();
				booksVo.setShuhao(rs.getString("shuhao"));
				booksVo.setBookname(rs.getString("bookname"));
				booksVo.setAuthor(rs.getString("author"));
				booksVo.setPublishing(rs.getString("publishing"));
				booksVo.setPublishingtime(rs.getString("publishingtime"));
				booksVo.setPrice(rs.getString("Price"));
				booksVo.setAdress(rs.getString("adress"));
				booksVo.setIsrenting(rs.getInt("isrenting"));
			}
		}catch (SQLException e){
			//todo Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs,conn,pstmt);
		}
		return booksVo;
	}

}
