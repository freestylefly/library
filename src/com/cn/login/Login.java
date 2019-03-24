package com.cn.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.cn.jdbc.JDBC_Connection;
import com.cn.users.UsersVo;

public class Login {
	public UsersVo check(String username){
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection conn=null;
		UsersVo usersVo=new UsersVo();
		try{
			conn=JDBC_Connection.getConnection();
			String sql="select*from users where username=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs=pstmt.executeQuery();
			while(rs.next()){
//				把各属性放入UsersVo对象中
				usersVo.setId(rs.getInt("id"));
				usersVo.setUsername(rs.getString("username"));
				usersVo.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs,conn,pstmt);
		}
		return usersVo;
	}
	public void overdue(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//获取当前日期
		Date dateU=new Date();
		java.sql.Date ate_str=new java.sql.Date(dateU.getTime());
		String nowtime=String.valueOf(ate_str);
		//修改的sql语句
		try {
			//修改sql语句
			String sql = 
				"update borrowinfo set timepass=1 where borrowinfo.backtime<?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到修改的sql语句中
			pstmt.setString(1, nowtime);
			pstmt.executeUpdate();//执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
}
