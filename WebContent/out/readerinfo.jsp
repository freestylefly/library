<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>借书还书</title>
    <script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
    <script src="../JS/onclock.JS" type="text/javascript"></script>
          <style type="text/css">
</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../css/style1.css" type="text/css" rel="stylesheet">
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
      &nbsp;&nbsp;当前位置：借阅查询 > > </div>
    <div id="main_2">
      <div id="main_2_1"></div>
      <div id="main_2_2">
	    <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
        <div id="main_2_2_1">
          <form name="form1" method="post" action="/library/ReaderinfoServlet" onSubmit="return check();">
            <table>
              <tr>
                <td><img src="../Images/main_2_2_1bg.gif" width="142" height="30" /></td>
                <td> 读者条形码(学号或工行）:
                    <input type="text" name= "xuehao" class="ip2" />
                  <span id="xuehao1"></span> </td>
                <td><input name="Submit"  type="submit" value="确定" /></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </div>
    <div id="footer1">
      <div id="footer1_1">本系统使用IE6.0或以上版本&nbsp;1024*768为最佳显示效果</div>
    </div>
  </div>
</div>
</body>
</html>