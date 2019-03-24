package com.cn.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.jdbc.JDBC_Connection;
import com.cn.service.BorrowsVo;
import com.cn.service.ReadersVo;

public class Readerinfo {
	public List<ReadersVo> showReader(String xuehao){//查询读者
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<ReadersVo> list2 = new ArrayList<ReadersVo>();
		try {
			conn = JDBC_Connection.getConnection();
			
			String sql = "select * from readerinfo where xuehao=?";//查询的SQL语句，
			pstmt = conn.prepareStatement(sql);
			System.out.println("参数传值成功"+xuehao);
			pstmt.setString(1, xuehao);
			rs=pstmt.executeQuery();
			System.out.println("000000");
			while(rs.next()){
				ReadersVo readersVo = new ReadersVo();
				//	把各属性放入borrowsVo对象中
				readersVo.setXuehao(rs.getString("xuehao"));
				readersVo.setReader_name(rs.getString("reader_name"));
				readersVo.setClassname(rs.getString("classname"));
				readersVo.setBorrow_num(rs.getInt("borrow_num"));
				
				list2.add(readersVo);//把borrowsVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list2;
	}
	
	public List<BorrowsVo> showByPage(int page,String xuehao){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BorrowsVo> list1 = new ArrayList<BorrowsVo>();
		try {
			conn = JDBC_Connection.getConnection();
			
			String sql = "select readerinfo.xuehao,readerinfo.reader_name,readerinfo.classname,readerinfo.borrow_num,borrowinfo.shuhao,borrowinfo.bookname,borrowinfo.borrowtime,borrowinfo.backtime,borrowinfo.timepass from readerinfo left join borrowinfo on readerinfo.xuehao=borrowinfo.xuehao where readerinfo.xuehao=? order by xuehao desc limit?,5";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			System.out.println("参数传值成功"+xuehao);
			pstmt.setString(1, xuehao);
			pstmt.setInt(2,(page-1)*5);
			rs=pstmt.executeQuery();
			System.out.println("222222");
			while(rs.next()){
				BorrowsVo borrowsVo = new BorrowsVo();
				//	把各属性放入borrowsVo对象中
				borrowsVo.setXuehao(rs.getString("xuehao"));
				borrowsVo.setReader_name(rs.getString("reader_name"));
				borrowsVo.setClassname(rs.getString("classname"));
				borrowsVo.setShuhao(rs.getString("shuhao"));
				borrowsVo.setBookname(rs.getString("bookname"));
				borrowsVo.setBorrowtime(rs.getString("borrowtime"));
				borrowsVo.setBacktime(rs.getString("backtime"));
				borrowsVo.setTimepass(rs.getInt("timepass"));
				
				
				list1.add(borrowsVo);//把borrowsVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list1;
	}
	public int maxpage(String xuehao){//获取最大页数查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			String sql ="select count(*) from readerinfo left join borrowinfo on readerinfo.xuehao=borrowinfo.xuehao where readerinfo.xuehao=?";//查询总记录数的SQL语
			pstmt = conn.prepareStatement(sql);
			System.out.println("maxpage学号传值："+xuehao);
			pstmt.setString(1, xuehao);
			rs=pstmt.executeQuery();
			System.out.println("11111111");
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}

}

