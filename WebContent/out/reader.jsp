<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="../JS/onclock.JS" type="text/javascript"></script>
<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
	<link href="../css/style1.css" type="text/css" rel="stylesheet">
</head>
<body onLoad="clockon()">
<div id="box">
  <div id="top">
    <div id="close"><a href="../login/login.html">管理员登陆</a>|<a href="#" onClick="myclose()" class="word_dark">关闭系统</a></div>
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
      <li><a href="reader.jsp" title="welcome"><span>书目检索</span></a></li>
      <li><a href="readerinfo.jsp" title="welcome"><span>借阅查询</span></a></li>
      <li><a href="#" onClick="quit()"  title="welcome"><span>退出系统</span></a></li>
      <li style="clear:left:"></li>
    </ul>
    <div id="time"><div id="txt"></div></div>
    <div style="clear:right;"></div>
  </div>
  <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
  <div id="main">
    <div id="main_1"><br />
      &nbsp;&nbsp;当前位置：图书查询 > > </div>
    <div id="main_2">
      <div id="searcbook2_1"></div>
      <div id="main_2_2_2">
	  <br />
	  <br />
	 <form method="post" action="/library/SearchbookServlet">
       <table>
	   <caption style="font-size:120%px">
         书目检索
       </caption>
       <tr>
       <td><select name="bookinfo" id="bookinfo" >
<option value="bookname">书名</option>
<option value="author">作者</option>
<option value="publishing">出版社</option>
</select></td>
        <td><input type="text" class="ip" name="keyinfo" id="keyinfo"> </td>
       <td><input type="submit" name="button" value="检索" /></td>
       </tr>
       <tr>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
       </tr>
        <tr>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
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
