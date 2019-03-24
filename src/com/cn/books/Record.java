package com.cn.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;
import com.cn.service.BorrowsVo;

public class Record {
	public List<BorrowsVo> showByPage(int page){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BorrowsVo> list = new ArrayList<BorrowsVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from borrowinfo order by xuehao desc limit?,5";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(page-1)*5);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BorrowsVo borrowsVo = new BorrowsVo();
				//	把各属性放入CarsVo对象中
				borrowsVo.setXuehao(rs.getString("xuehao"));
				borrowsVo.setReader_name(rs.getString("reader_name"));
				borrowsVo.setClassname(rs.getString("classname"));
				borrowsVo.setShuhao(rs.getString("shuhao"));
				borrowsVo.setBookname(rs.getString("bookname"));
				borrowsVo.setBorrowtime(rs.getString("borrowtime"));
				borrowsVo.setBacktime(rs.getString("backtime"));
				borrowsVo.setTimepass(rs.getInt("timepass"));
				list.add(borrowsVo);//把CarsVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
	public int maxpage(){//获取最大页数查询方法
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from borrowinfo";//查询总记录数的SQL语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}

}

