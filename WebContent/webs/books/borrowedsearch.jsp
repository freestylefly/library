<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="../../JS/onclock.JS" type="text/javascript"></script>
<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
	<link href="../../css/style1.css" type="text/css" rel="stylesheet">
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
      <li><a href="../service/admin.jsp" title="welcome"><span>借书还书</span></a></li>
      <li><a href="searchbook.jsp" title="welcome"><span>图书查询</span></a></li>
      <li><a href="addbook.jsp" title="welcome"><span>添加新书</span></a></li>
      <li><a href="borrowedsearch.jsp" title="welcome"><span>借阅记录</span></a></li>
      <li><a href="../readers/readermanger.jsp" title="welcome"><span>读者管理</span></a></li>
      <li><a href="#" onClick="quit()"  title="welcome"><span>退出系统</span></a></li>
      <li style="clear:left:"></li>
    </ul>
    <div id="time"><div id="txt"></div></div>
    <div style="clear:right;"></div>
  </div>
  <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
  <div id="main">
    <div id="main_1"><br />
      &nbsp;&nbsp;当前位置：记录查询 > > </div>
    <div id="main_2">
      <div id="borrowsearch"></div>
      <div id="main_2_2_2">
	  <br />
	  <br />
	  <br />
	 <form method="post" action="/library/SearchServlet">
       <table>
       <tr>
         <td>&nbsp;</td>
         <td><a href="/library/ShowallBorrowServlet">全部记录查询</a></td>
         <td>&nbsp;</td>
       </tr>
       <tr>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
       </tr>
        <tr>
         <td>&nbsp;</td>
         <td><a href="/library/OverdueServlet">过期记录查询</a></td>
         <td>&nbsp;</td>
       </tr>
            </table>
	</form>
      </div>
    </div>
    <div id="footer1">
      <div id="footer1_1">本系统使用IE6.0或以上版本&nbsp;1024*768为最佳显示效果</div>
    </div>
  </div>
</div>
<div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
</body>
</html>
