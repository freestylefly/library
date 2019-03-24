package com.cn.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cn.users.UsersVo;

public class LoginServlet extends HttpServlet{
	public void destroy(){
		super.destroy();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");//获取管理员账号
		String password=request.getParameter("password");//获取密码
		Login login=new Login();
		UsersVo usersVo=new UsersVo();
		if(username.length()!=0&&password.length()!=0){
			usersVo=login.check(username);
			if(usersVo!=null){
				if(username.equals(usersVo.getUsername())&&
						password.equals(usersVo.getPassword())){
					Login over=new Login();
					over.overdue();
					request.getSession().setAttribute("username", username);
					response.sendRedirect("webs/service/admin.jsp");
				}else{
					response.sendRedirect("login/false.html");
				}
			}else{
				
			}
				
			}else{
				
			}
			out.flush();
			out.close();
		}
		public void init() throws ServletException{
			
		}
}
