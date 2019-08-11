<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'borrowbook.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
 <body>
<TABLE align="center" width="70%" border="1">
  <TR>
	<TD>学号</TD>
	<TD>姓名</TD>
	<TD>班级</TD>
	<TD>书号</TD>
	<TD>书名</TD>
	<TD>借阅时间</TD>
	<TD>应还时间</TD>
	<TD>是否过期</TD>
  </TR>
  <c:forEach items="${list}" var="list">
<TR>
	<TD>${list.xuehao }</TD>
	<TD>${list.reader_name }</TD>
	<TD>${list.classname }</TD>
	<TD>${list.shuhao }</TD>
	<TD>${list.bookname }</TD>
	<TD>${list.borrowtime }</TD>
	<TD>${list.backtime }</TD>
	<TD>
		<c:if test="${list.timepass ==0}"></c:if>
		<c:if test="${list.timepass ==1}">已过期</c:if>
	</TD>
</TR>
</c:forEach>
</TABLE>
<div align="center">
		<c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="/library/RecordServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="/library/RecordServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/RecordServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/RecordServlet?page=${maxpage }">末页</a></c:if>
    </div>
  </body>
</html>
