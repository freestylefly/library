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
      <li><a href="/library/out/reader.jsp" title="welcome"><span>书目检索</span></a></li>
      <li><a href="/library/out/readerinfo.jsp" title="welcome"><span>借阅查询</span></a></li>
      <li><a href="#" onClick="quit()" class="word_white" title="welcome"><span>退出系统</span></a></li>
      <li style="clear:left:"></li>
    </ul>
    <div id="time"><div id="txt"></div></div>
    <div style="clear:right;"></div>
  </div>
  <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
  <div id="main">
    <div id="main_1"><br />
      &nbsp;&nbsp;当前位置：书目检索 > >检索信息> > </div>
    <div id="main_3">
    <TABLE>
    <thead>
  <TR>
	<TD>书号</TD>
	<TD>书名</TD>
	<TD>作者</TD>
	<TD>出版社</TD>
	<TD>出版时间</TD>
	<TD>价格</TD>
	<TD>位置</TD>
	<TD>借阅情况</TD>
  </TR>
  </thead>
<c:forEach items="${list}" var="list">
<TR>
	<TD>${list.shuhao}</TD>
	<TD>${list.bookname}</TD>
	<TD>${list.author }</TD>
	<TD>${list.publishing }</TD>
	<TD>${list.publishingtime }</TD>
	<TD>${list.price }</TD>
	<TD>${list.adress}</TD>
	<TD class="r">
		<c:if test="${list.isrenting ==0}">未借出</c:if>
		<c:if test="${list.isrenting ==1}">已借出</c:if>
	</TD>
</c:forEach>
</TABLE>
    </div>
    <div id="fenye"> <br />
       <c:if test="${page ==1}">首页</c:if>
    	<c:if test="${page > 1}"><a href="/library/SearchbookServlet?page=1">首页</a></c:if>
    	<c:if test="${page ==1}">上一页</c:if>
    	<c:if test="${page > 1}"><a href="/library/SearchbookServlet?page=${page-1 }">上一页</a></c:if>
    	<c:if test="${page == maxpage}">下一页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/SearchbookServlet?page=${page+1 }">下一页</a></c:if>
    	<c:if test="${page == maxpage}">末页</c:if>
    	<c:if test="${page < maxpage}"><a href="/library/SearchbookServlet?page=${maxpage }">末页</a></c:if>
    </div>
    <div id="footer1">
      <div id="footer1_1">本系统使用IE6.0或以上版本&nbsp;1024*768为最佳显示效果</div>
    </div>
  </div>
</div>
<div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
</body>
</html>
