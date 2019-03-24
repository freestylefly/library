package com.cn.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cn.service.ReadersVo;

import com.cn.jdbc.JDBC_Connection;

public class UpdateReader {
	public ReadersVo updatereader(ReadersVo readersVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句

		try {
			//修改sql语句
			String sql = 
				"update readerinfo set xuehao=?, reader_name=? ,classname=?, borrow_num=? where xuehao = ?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到修改的sql语句中
			
			pstmt.setString(1, readersVo.getXuehao());
			pstmt.setString(2, readersVo.getReader_name());
			pstmt.setString(3, readersVo.getClassname());
			pstmt.setInt(4, readersVo.getBorrow_num());
			pstmt.setString(5, readersVo.getXuehao());
			
			pstmt.executeUpdate();//执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
		return readersVo;
	}

}

