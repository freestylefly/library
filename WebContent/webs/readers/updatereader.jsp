<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="css/style2.css" type="text/css" rel="stylesheet">
    <title>My JSP 'updateBook.jsp' starting page</title>
  </head>
 <body>
    <form name="form" method="post" action="UpdateReaderServlet">
<TABLE align="center">
    <caption>修改信息</caption>
<TR>
	<TD>学号：</TD>
	<TD class="even"><input name="xuehao" value="${readersVo.xuehao }" readonly/></TD>
</TR>
<TR>
	<TD>姓名：</TD>
	<TD class="even"><input name="reader_name" value="${readersVo.reader_name }" readonly/></TD>
</TR>
<TR>
	<TD>班级：</TD>
	<TD class="even"><input name="classname" value="${readersVo.classname}"/></TD>
</TR>
<TR>
	<TD>已借数量：</TD>
	<TD class="even"><input name="borrow_num" value="${readersVo.borrow_num }"/></TD>
</TR>
<TR>
	<TD><input type="button" value="返回" onclick="javascript:history.go(-1);"/></TD>
	<TD class="even">
		<input type="submit" value="提交">
	</TD>
</TR>
</TABLE>
</form>
  </body>
</html>