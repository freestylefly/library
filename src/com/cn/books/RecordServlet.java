package com.cn.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.BorrowsVo;


public class RecordServlet extends HttpServlet {

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
		Record records = new Record();
		List<BorrowsVo> list = new ArrayList<BorrowsVo>();
		String page1 = request.getParameter("page");//获得页面传递过来的page值赋值给page1
		int page =1;
		if(page1 != null){
			page = Integer.parseInt(page1);//如果页面传递过来的page值存在，则把该page1赋值给page变量
		}
		list = records.showByPage(page);//调用查询方法
		int maxpage = records.maxpage();//调用最大页数方法
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		System.out.println(maxpage);
		request.getRequestDispatcher("webs/books/showrecords.jsp").forward(request, response);//转发到页面
		out.flush();
		out.close();
	}

}

