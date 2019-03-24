<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>读者管理</title>
    <script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
    <script src="../../JS/onclock.JS" type="text/javascript"></script>
          <style type="text/css">
</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../../css/style1.css" type="text/css" rel="stylesheet">
	<script type="text/javascript">
  	function check(){
  		if(document.getElementById("xuehao").value.length ==0 ){
			document.getElementById("xuehao1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("reader_name").value.length ==0 ){
			document.getElementById("reader_name1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("classname").value.length ==0 ){
			document.getElementById("classname1").innerHTML="不能为空！";
			return false;
		}
		else{
			return true;
		}
  	}
  </script>
<% 
  String flag=request.getParameter("flag");
  if("1".equals(flag)){
%>
<script language='javascript' type='text/javascript'>alert('添加成功')</script>
<%
  }else{
%>

<%
  }
%>
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
      <li><a href="../books/searchbook.jsp" title="welcome"><span>图书查询</span></a></li>
      <li><a href="../books/addbook.jsp" title="welcome"><span>添加新书</span></a></li>
      <li><a href="../books/borrowedsearch.jsp" title="welcome"><span>借阅记录</span></a></li>
      <li><a href="readermanger.jsp" title="welcome"><span>读者管理</span></a></li>
      <li><a href="#" onClick="quit()" title="welcome"><span>退出系统</span></a></li>
      <li style="clear:left:"></li>
    </ul>
    <div id="time"><div id="txt"></div></div>
    <div style="clear:right;"></div>
  </div>
  <div style="font-size:0;line-height:0;padding:0;margin:0;clear:both;"></div>
  <div id="main">
    <div id="main_1"><br />
      &nbsp;&nbsp;当前位置：添加新书 > > </div>
    <div id="main_2">
      <div id="addreader"></div>
    <div id="main_2_2_2">
	  <form name="form1" method="post" action="/library/AddreaderServlet" onsubmit="return check();" >
       <table>
	    <caption style="font-size:100%">
         请填写读者信息
       </caption>
          <tr>
           <td>学&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
           <td><input type="text" name="xuehao"  class="ip" id="xuehao"  /></td>
	       <td class="tdleft"><span id="xuehao1"></span>填写读者学号</td>
           </tr>
                <tr>
                  <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
        <td><input type="text" name="reader_name"  class="ip" id="bookname" /></td>
        <td class="tdleft"><span id="bookname1"></span>填写读者姓名</td>
                </tr>
				<tr>
		 <td>班&nbsp;&nbsp;&nbsp;&nbsp;级：</td>
		 <td><input type="text" name="classname"  class="ip" id="classname"/></td>
		 <td class="tdleft"><span id="classname1"></span>填写读者班级</td>
	</tr>
  <tr>
		 <td></td>
		 <td><input type="submit" name="button" value="添加" size="12" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="button" value="重置" size="12" /></td>
		 <td></td>
  </tr>
            </table>
	</form>
    <br />	
	<form name="form2" method="post" action="/library/SearchReaderServlet">
	<table>
       <caption style="font-size:100%">
         高级查找
       </caption>
       <tr>
       <td><select name="readerinfo" id="readerinfo" >
<option value="xuehao">学号</option>
<option value="reader_name">姓名</option>
<option value="classname">班级</option>
</select></td>
        <td><input type="text" name="keyinfo" class="ip" id="keyinfo"> </td>
       <td width="57"><input type="submit" name="button" value="查找" /></td>
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
