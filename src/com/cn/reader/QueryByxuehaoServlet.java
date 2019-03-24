package com.cn.reader;

import java.io.IOException;
import java.io.PrintWriter;
import com.cn.service.ReadersVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryByxuehaoServlet extends HttpServlet {
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
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
		String xuehao = request.getParameter("xuehao");//获得页面传递过来的书号
		ReadersVo readersVo = new ReadersVo();
		QueryByxuehao byxuehao = new QueryByxuehao();
		readersVo = byxuehao.queryByxuehao(xuehao);//调用查询方法
		request.setAttribute("readersVo", readersVo);//把查询出的数据放入request中
		request.getRequestDispatcher("webs/readers/updatereader.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}

