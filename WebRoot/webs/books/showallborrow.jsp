<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
    <script src="JS/onclock.JS" type="text/javascript"></script>
    <link href="css/style2.css" type="text/css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>showallbooks.jsp</title>
  </head>
 <body onLoad="clockon()">
<div id="box">
  <div id="top">
    <div id="close"><a href="#" onClick="myclose()" class="word_dark">关闭系统</a></div>
    <script language="javascript">
			function myclose(){
				if(confirm("真的要关闭当前窗口吗?")){
					window.close();
				}
			}
		</script>
  </div>
  <div id="nav">
    <ul>
      <li><a href="/library/webs/service/admin.jsp" title="welcome"><span>借书还书</span></a></li>
      <li><a href="/library/webs/books/searchbook.jsp" title="welcome"><span>图书查询</span></a></li>
      <li><a href="/library/webs/books/addbook.jsp" title="welcome"><span>添加新书</span></a></li>
      <li><a href="/library/webs/books/borrowedsearch.jsp" title="welcome"><span>借阅记录</span></a></li>
      <li><a href="/library/webs/readers/readermanger.jsp" title="welcome"><span>读者管理</span></a></li>
      <li><a href="#" onClick="quit()" class="word_white" title="welcome"><span>退出系统</span></a></li>
      <li style="clear:left:"></li>
    </ul>
    <div id="time"><div id="txt"></div></div>
    <div style="clear:right;"></div>
  </div>
  <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
  <div id="main">
    <div id="main_1"><br />
      &nbsp;&nbsp;当前位置：借阅记录> >全部部查询> > </div>
    <div id="main_3">
          <TABLE>
    <thead>
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
  </thead>
  <tbody>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.xuehao}</TD>
	<TD>${list.reader_name}</TD>
	<TD>${list.classname }</TD>
	<TD>${list.shuhao }</TD>
	<TD>${list.bookname }</TD>
	<TD>${list.borrowtime }</TD>
	<TD>${list.backtime }</TD>
	<TD>
		<c:if test="${list.timepass ==0}">未过期</c:if>
		<c:if test="${list.timepass ==1}">已过期</c:if>
	</TD>
</TR>
</c:forEach>
</tbody>
</TABLE>
    </div>
    <div id="fenye"> <br />
       <c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="/library/ShowallBorrowServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="/library/ShowallBorrowServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/ShowallBorrowServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/ShowallBorrowServlet?page=${maxpage }">末页</a></c:if>
    </div>
    <div id="footer1">
      <div id="footer1_1">本系统使用IE6.0或以上版本&nbsp;1024*768为最佳显示效果</div>
    </div>
  </div>
</div>
<div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
</body>
</html>
