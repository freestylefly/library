package com.cn.reader;

import java.io.IOException;
import java.io.PrintWriter;
import com.cn.service.ReadersVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateReaderServlet extends HttpServlet {


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
		

		String xuehao= request.getParameter("xuehao");//学号
		String reader_name=request.getParameter("reader_name");//姓名
		String classname=request.getParameter("classname");//作者
		int borrow_num=Integer.parseInt(request.getParameter("borrow_num"));//借阅情况
	
		ReadersVo readersVo = new ReadersVo();
		//把页面数据设置到readersVo对象中
		readersVo.setXuehao(xuehao);
		readersVo.setReader_name(reader_name);
		readersVo.setClassname(classname);
		readersVo.setBorrow_num(borrow_num);
		
		UpdateReader updateReader = new UpdateReader();
		readersVo=updateReader.updatereader(readersVo);//调用修改方法
		request.setAttribute("readersVo", readersVo);
		//重定向到显示全部的页面
		request.getRequestDispatcher("webs/readers/updatereader.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
