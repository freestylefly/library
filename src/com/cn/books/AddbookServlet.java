package com.cn.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddbookServlet extends HttpServlet {
	public void destroy(){
		super.destroy();//put your code here
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	       throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	       throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		BooksVo booksVo=new BooksVo();
		String shuhao=request.getParameter("shuhao");//书号
		String bookname=request.getParameter("bookname");//书名
		String author=request.getParameter("author");//作者
		String publishing=request.getParameter("publishing");//出版社
		String publishingtime=request.getParameter("publishingtime");//出版时间
		String price=request.getParameter("price");//价格
		String adress=request.getParameter("adress");//位置
		
		booksVo.setShuhao(shuhao);
		booksVo.setBookname(bookname);
		booksVo.setAuthor(author);
		booksVo.setPublishing(publishing);
		booksVo.setPublishingtime(publishingtime);
		booksVo.setPrice(price);
		booksVo.setAdress(adress);
		
		AddBook addBook=new AddBook();
		int message=addBook.addBook(booksVo);//调用添加方法
		System.out.println("添加成功"+message);
        if(message==1){
        	response.sendRedirect("webs/books/addbook.jsp?flag=1");//定向到添加成功页面
        }else{
        	response.sendRedirect("login/false.jsp?flag=0");//定向到添加成功页面
        }
		out.flush();
		out.close();
	}
}
