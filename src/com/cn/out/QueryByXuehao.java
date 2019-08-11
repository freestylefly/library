package com.cn.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class QueryByXuehao {
	public ReadersVo queryByXuehao(String xuehao){
		ReadersVo readersVo=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=JDBC_Connection.getConnection();
			pstmt=conn.prepareStatement("select*from readerinfo where xuehao=?");
			pstmt.setString(1, xuehao);
			rs=pstmt.executeQuery();
			while(rs.next()){
				readersVo=new ReadersVo();
//				readersVo.setId(rs.getInt("id"));
				readersVo.setXuehao(rs.getString("xuehao"));
				readersVo.setReader_name(rs.getString("reader_name"));
				readersVo.setClassname(rs.getString("classname"));
				readersVo.setBorrow_num(rs.getInt("borrow_num"));
			}
		}catch (SQLException e){
			//todo Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs,conn,pstmt);
		}
		return readersVo;
	}

}
