<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/style2.css" type="text/css" rel="stylesheet">
    <title>My JSP 'updateBook.jsp' starting page</title>

  </head>
  
 <body background="Images/back.gif">

    <form name="form" method="post" action="UpdateBookServlet">
<TABLE align="center">
    <caption>修改信息</caption>
<TR>
	<TD>书号：</TD>
	<TD class="even"><input name="shuhao" value="${booksVo.shuhao }" readonly/></TD>
</TR>
<TR>
	<TD>书名：</TD>
	<TD class="even"><input name="bookname" value="${booksVo.bookname }" readonly/></TD>
</TR>
<TR>
	<TD>作者：</TD>
	<TD class="even"><input name="author" value="${booksVo.author }"/></TD>
</TR>
<TR>
	<TD>出版社：</TD>
	<TD class="even"><input name="publishing" value="${booksVo.publishing }"/></TD>
</TR>
<TR>
	<TD>出版时间：</TD>
	<TD class="even"><input name="publishingtime" value="${booksVo.publishingtime }"/></TD>
</TR>
<TR>
	<TD>价格：</TD>
	<TD class="even"><input name="price" value="${booksVo.price }"/></TD>
</TR>
<TR>
	<TD>位置：</TD>
	<TD class="even"><input name="adress" value="${booksVo.adress }"/></TD>
</TR>
<TR>
	<TD>借阅情况：</TD>
	<TD class="even">
		<SELECT NAME="isrenting" id="isRent">
			<option value="${booksVo.isrenting }"><c:if test="${booksVo.isrenting == 1 }">已出租</c:if>
			<c:if test="${booksVo.isrenting == 0 }">未出租</c:if>
			</option>
			<option value="1">已出租</option>
			<option value="0">未出租</option>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD>借阅者查询</TD>
	<TD class="even">&nbsp;</TD>
</TR>
<TR>
	<TD><input type="button" value="返回" onclick="javascript:history.go(-1);"/></TD>
	<TD class="even">
		<input type="submit" value="提交">
	</TD>
</TR>
</TABLE>
</form>
<!--[if lte IE 6]>
<script language="javascript">
var rows = document.getElementsByTagName('tr');
for (var i=0;i<rows.length;i++){
	rows[i].onmouseover = function(){		//鼠标指针在行上面的时候
		this.className += ' hover';
	}
	rows[i].onmouseout = function(){		//鼠标指针离开时
		this.className = this.className.replace(/hover/, '');
	}
}
</script>
<![endif]-->
  </body>
</html>