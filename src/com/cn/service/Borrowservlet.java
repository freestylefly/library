package com.cn.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class Borrowservlet extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);//调用doPost方法
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//获得页面传过来的数据
		String shuhao=request.getParameter("shuhao");//书号
		String bookname = Borrow.byshuhao(shuhao);//调用查询书名的方法
		if(bookname!=""){
			String xuehao= request.getParameter("xuehao");//学号
			String reader_name=request.getParameter("reader_name");//姓名
			String classname=request.getParameter("classname");//班级
			int borrow_num=Integer.parseInt(request.getParameter("borrow_num"));//数量
			System.out.println(bookname);
			//获取借书时间
			Date dateU=new Date();
			java.sql.Date ate_str=new java.sql.Date(dateU.getTime());
			String borrowtime=String.valueOf(ate_str);
			//System.out.println(borrowtime);//检验
			//计算应该归还日期
			String dd=borrowtime.substring(8,10);
			String DD=borrowtime.substring(0, 8)+String.valueOf(Integer.parseInt(dd)+60);
			java.sql.Date Time=java.sql.Date.valueOf(DD);
			String backtime=String.valueOf(Time);
			//System.out.println(backtime);//检验
			BorrowsVo borrowsVo = new BorrowsVo();
			//把页面数据设置到borrowsVo对象中
			borrowsVo.setXuehao(xuehao);
			borrowsVo.setReader_name(reader_name);
			borrowsVo.setClassname(classname);
			borrowsVo.setShuhao(shuhao);
			borrowsVo.setBookname(bookname);
			borrowsVo.setBorrowtime(borrowtime);
			borrowsVo.setBacktime(backtime);
			Borrow borrow=new Borrow();
			borrow.updateborrow(borrowsVo);//调用修改方法
			borrow.updateborrownum(borrow_num, xuehao);//调用修改已借数量的方法
			borrow.updatebookinfo(shuhao);//调用修改借书信息的方法
			request.setAttribute("xuehao", xuehao);
			request.getRequestDispatcher("ShowBorrowsServlet").forward(request,response);
			out.flush();
			out.close();
		}else{
			
			request.setAttribute("flag", 1);
			request.getRequestDispatcher("ShowBorrowsServlet").forward(request,response);
			out.flush();
			out.close();
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
