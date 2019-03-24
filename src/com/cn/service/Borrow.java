package com.cn.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cn.jdbc.JDBC_Connection;

public class Borrow {
	
	public static String byshuhao(String shuhao){//获取书名的方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		String bookname="";//声明一个bookname变量
		try {
			conn  = JDBC_Connection.getConnection();
			String sql ="select bookname from bookinfo where bookinfo.shuhao=?";//查询
			pstmt = conn.prepareStatement(sql);
			System.out.println("检验书号传值："+shuhao);
			pstmt.setString(1, shuhao);
			rs=pstmt.executeQuery();
			System.out.println("11111111");
			while (rs.next()) {
				bookname= rs.getString("bookname");//如果结果集存在，获取书名
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return bookname;
		//返回
	}
	
	public void updateborrownum(int borrow_num,String xuehao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句
		try {
			//修改sql语句
			String sql = 
				"update readerinfo set borrow_num=? where xuehao=?";
			conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			int num=borrow_num+1;
			//把值设置到修改的sql语句中
			pstmt.setInt(1, num);
			pstmt.setString(2, xuehao);
			pstmt.executeUpdate();//执行修改sql语句
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}
	
	public void updatebookinfo(String shuhao){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//根据id修改的sql语句
		try {
			//修改sql语句
			String sql = 
				"update bookinfo set isrenting=1 where shuhao=?";
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
	
	
	public void updateborrow(BorrowsVo borrowsVo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//添加借书记录

		try {
			String sql = "insert into borrowinfo(xuehao,reader_name,classname,shuhao,bookname,borrowtime,backtime)value(?,?,?,?,?,?,?)";
		    conn=JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement(sql);
			//把值设置到SQL语句中
			pstmt.setString(1, borrowsVo.getXuehao());
			pstmt.setString(2, borrowsVo.getReader_name());
			pstmt.setString(3, borrowsVo.getClassname());
			pstmt.setString(4, borrowsVo.getShuhao());
			pstmt.setString(5, borrowsVo.getBookname());
			pstmt.setString(6, borrowsVo.getBorrowtime());
			pstmt.setString(7, borrowsVo.getBacktime());
			pstmt.executeUpdate();//提交pstm对象
			System.out.println("添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

}
