package com.cn.reader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.cn.service.ReadersVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchReaderServlet extends HttpServlet {

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
		SearchReader searchreader = new SearchReader();
		List<ReadersVo> list = new ArrayList<ReadersVo>();
	    String readerinfo = request.getParameter("readerinfo");//获得页面传递过来的查询类别
		String keyinfo = request.getParameter("keyinfo");//获得页面传递过来的检索关键字	
		String page1 = request.getParameter("page");//获得页面传递过来的page值赋值给page1
		int page =1;
		System.out.println("获取参数成功："+keyinfo);
		if(page1 != null){
			page = Integer.parseInt(page1);//如果页面传递过来的page值存在，则把该page1赋值给page变量
		}
		list = searchreader.showSearch(page,readerinfo,keyinfo);//调用查询方法
		int maxpage = searchreader.maxpage(readerinfo,keyinfo);//调用最大页数方法
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("readerinfo", readerinfo);
		request.setAttribute("keyinfo", keyinfo);
		System.out.println(maxpage);
		request.getRequestDispatcher("webs/readers/showreader.jsp").forward(request, response);//转发到页面
		out.flush();
		out.close();
	}

}

