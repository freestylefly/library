package com.cn.reader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cn.service.ReadersVo;

public class AddreaderServlet extends HttpServlet {
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
		ReadersVo readersVo=new ReadersVo();
		String xuehao=request.getParameter("xuehao");//学号
		String reader_name=request.getParameter("reader_name");//姓名
		String classname=request.getParameter("classname");//班级
		
		readersVo.setXuehao(xuehao);
		readersVo.setReader_name(reader_name);
		readersVo.setClassname(classname);
		
		Addreader addreader=new Addreader();
		int message=addreader.addreader(readersVo);//调用添加方法
		System.out.println("添加成功"+message);
        if(message==1){
        	response.sendRedirect("webs/readers/readermanger.jsp?flag=1");//定向到添加成功页面
        }else{
        	response.sendRedirect("login/false.jsp?flag=0");//定向到添加成功页面
        }
		out.flush();
		out.close();
	}
}
