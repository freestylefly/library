package com.cn.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.cn.service.ReadersVo;

import com.cn.jdbc.JDBC_Connection;

public class Addreader {
	public int addreader(ReadersVo readersVo){
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try{
			//调用JDBC_Connection类的getConnection方法连接数据库
			conn=JDBC_Connection.getConnection();
			//添加数据的SQL语句
			String sql="insert into readerinfo(xuehao,reader_name,classname)value(?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, readersVo.getXuehao());
			pstm.setString(2, readersVo.getReader_name());
			pstm.setString(3, readersVo.getClassname());
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
