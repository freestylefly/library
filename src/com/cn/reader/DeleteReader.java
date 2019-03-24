package com.cn.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class DeleteReader{
	
	public void deleteReader(String xuehao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from readerinfo where xuehao =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, xuehao);//给sql语句里的id赋值
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
