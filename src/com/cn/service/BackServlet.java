package com.cn.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackServlet extends HttpServlet {


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
		
		String shuhao=request.getParameter("shuhao");//书号
		String xuehao=request.getParameter("xuehao");//学号
		Back book = new Back();
		book.back(shuhao);
		book.updatebookinfo(shuhao);
		book.backnum(xuehao);
		request.setAttribute("xuehao", xuehao);
		request.getRequestDispatcher("ShowBorrowsServlet").forward(request,response);
		System.out.println("还书成功！");
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		
	}

}
