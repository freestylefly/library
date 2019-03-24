package com.cn.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.jdbc.JDBC_Connection;

public class Back{
	
	public void back(String shuhao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn =JDBC_Connection.getConnection();
			String sql = "delete from borrowinfo where shuhao =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shuhao);//给sql语句里的shuhao赋值
			pstmt.executeUpdate();
			System.out.println("bakc方法操作成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//关闭连接
		}	
	}
	
	public void updatebookinfo(String shuhao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句
		try {
			//修改sql语句
			String sql = 
				"update bookinfo set isrenting=0 where shuhao=?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到修改的sql语句中
			pstmt.setString(1, shuhao);
			pstmt.executeUpdate();//执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
	
	public void backnum(String xuehao){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int borrow_num=0;
		try {
			conn =JDBC_Connection.getConnection();
			String sql1 ="select borrow_num from readerinfo where readerinfo.xuehao=?";//查询
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, xuehao);
			rs=pstmt.executeQuery();
			System.out.println("11111111");
			while (rs.next()) {
				borrow_num= rs.getInt("borrow_num");//如果结果集存在，获取借书数量
			}
			
			String sql2 = "update readerinfo set borrow_num=? where xuehao=?";
			pstmt = conn.prepareStatement(sql2);
			int num=borrow_num-1;
			pstmt.setInt(1, num);//给sql语句里的xuehao赋值
			pstmt.setString(2,xuehao);
			pstmt.executeUpdate();
			System.out.println("backnum方法操作成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);//关闭连接
		}	
	}

}

