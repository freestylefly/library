package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class DeleteBook{
	
	public void deleteBook(String shuhao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from bookinfo where shuhao =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shuhao);//给sql语句里的id赋值
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//关闭连接
		}
		
	}
public static void main(String[] args) {
	}

}
