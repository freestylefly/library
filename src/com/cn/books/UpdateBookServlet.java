package com.cn.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateBookServlet extends HttpServlet {


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
		

		String shuhao= request.getParameter("shuhao");//书号
		String bookname=request.getParameter("bookname");//书名
		String author=request.getParameter("author");//作者
		String publishing= request.getParameter("publishing");//出版社
		String publishingtime=request.getParameter("publishingtime");//出版时间
		String price=request.getParameter("price");//价格
		String adress=request.getParameter("adress");//位置
		int isrenting=Integer.parseInt(request.getParameter("isrenting"));//借阅情况
		BooksVo booksVo = new BooksVo();
		//把页面数据设置到booksVo对象中
		booksVo.setShuhao(shuhao);
		booksVo.setBookname(bookname);
		booksVo.setAuthor(author);
		booksVo.setPublishing(publishing);
		booksVo.setPublishingtime(publishingtime);
		booksVo.setPrice(price);
		booksVo.setAdress(adress);
		booksVo.setIsrenting(isrenting);
		UpdateBook updateBook = new UpdateBook();
		updateBook.updatebook(booksVo);//调用修改方法
		//重定向到显示全部的页面
		response.sendRedirect("ShowBooksServlet");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}