package com.cn.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.ReadersVo;
import com.cn.service.ShowBorrows;
import com.cn.service.BorrowsVo;

public class ReaderinfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);//调用dopost方法
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ShowBorrows showBorrows = new ShowBorrows();
		List<BorrowsVo> list1 = new ArrayList<BorrowsVo>();
		List<ReadersVo> list2 = new ArrayList<ReadersVo>();
		String page1 = request.getParameter("page");//获得页面传递过来的page值赋值给page1
		int page =1;
		String xuehao = request.getParameter("xuehao");//获得页面传递过来的xuehao值赋值给学号
		System.out.println("获取参数成功："+xuehao);
		if(page1 != null){
			page = Integer.parseInt(page1);//如果页面传递过来的page值存在，则把该page1赋值给page变量
		}
		list1 = showBorrows.showByPage(page,xuehao);//调用查询方法
		list2 = showBorrows.showReader(xuehao);
		int maxpage = showBorrows.maxpage(xuehao);//调用最大页数方法
		request.setAttribute("list2", list2);
		request.setAttribute("list1", list1);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		System.out.println(maxpage);
		request.getRequestDispatcher("out/readerborrow.jsp").forward(request, response);//转发到页面
		out.flush();
		out.close();
	}

}
