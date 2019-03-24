package com.cn.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryByIdServlet extends HttpServlet {
	
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
		String shuhao = request.getParameter("shuhao");//获得页面传递过来的书号
		String code =request.getParameter("code");//获得隐藏域中的code
		BooksVo booksVo = new BooksVo();
		QueryById byId = new QueryById();
		booksVo = byId.queryById(shuhao);//调用查询方法
		request.setAttribute("booksVo", booksVo);//把查询出的数据放入request中
		if(code.equals("update")){//判断当凑得值为update时，转发到修改页面
			request.getRequestDispatcher("webs/books/updateBook.jsp").forward(request, response);
		}else if(code.equals("select")){//判断当code值为celect时，转发到显示单条信息页面
			request.getRequestDispatcher("webs/books/showBookManger.jsp").forward(request, response);
		}
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
