<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'borrowbook0.jsp' starting page</title>
  </head>
  <body>
    <form name="form" method="post" action="">
<TABLE>
<TR>
	<TD>学号：</TD>
	<TD><input name="xuehao" value="${readersVo.xuehao}" readonly/></TD>
	<TD>姓名：</TD>
	<TD><input name="reader_name" value="${readersVo.reader_name}" readonly/></TD>
</TR>
<TR>
	<TD>班级：</TD>
	<TD><input name="classname" value="${readersVo.classname }" readonly/></TD>
	<TD>已借：</TD>
	<TD><input name="borrow_num" value="${readersVo.borrow_num }" readonly/>本</TD>
</TR>
<TR>
	<TD>图书号码：</TD>
	<TD><input name="shuhao"}"/></TD>
	<TD></TD>
	<TD><input type="submit" value="完成借阅"></TD>
</TR>
</TABLE>
</form>
<a href="/library/ShowBorrowsServlet?xuehao=${readersVo.xuehao}">查看已借</a>
  </body>
</html>
