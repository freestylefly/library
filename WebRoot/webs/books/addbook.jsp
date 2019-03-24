<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新书</title>
    <script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="../../login/logout.jsp";
				}
			}
		</script>
    <script src="../../JS/onclock.JS" type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../../css/style1.css" type="text/css" rel="stylesheet">
	<script type="text/javascript">
  	function check(){
  		if(document.getElementById("shuhao").value.length ==0 ){
			document.getElementById("shuhao1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("bookname").value.length ==0 ){
			document.getElementById("bookname1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("author").value.length ==0 ){
			document.getElementById("author1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("publishing").value.length ==0 ){
			document.getElementById("publishing1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("publishingtime").value.length ==0 ){
			document.getElementById("publishingtime1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("price").value.length ==0 ){
			document.getElementById("price1").innerHTML="不能为空！";
			return false;
		}else if(document.getElementById("adress").value.length ==0 ){
			document.getElementById("adress1").innerHTML="不能为空！";
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
      <li><a href="searchbook.jsp" title="welcome"><span>图书查询</span></a></li>
      <li><a href="addbook.jsp" title="welcome"><span>添加新书</span></a></li>
      <li><a href="borrowedsearch.jsp" title="welcome"><span>借阅记录</span></a></li>
      <li><a href="../readers/readermanger.jsp" title="welcome"><span>读者管理</span></a></li>
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
      <div id="addbook2_1"></div>
      <div id="main_2_2_2">
	  <form name="form" method="post" action="/library/AddbookServlet" onsubmit="return check();" >
       <table>
	   <caption style="font-size:110%px">
         请填写书单
       </caption>
          <tr>
           <td>书&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
           <td><input type="text" class="ip" name="shuhao" id="shuhao"/></td>
	       <td class="tdleft"><span id="shuhao1"></span>填写唯一书号</td>
           </tr>
                <tr>
                  <td>书&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
        <td><input type="text" class="ip" name="bookname" id="bookname"  /></td>
        <td class="tdleft"><span id="bookname1"></span>填写书名</td>
                </tr>
				<tr>
		 <td>作&nbsp;&nbsp;&nbsp;&nbsp;者：</td>
		 <td><input type="text" class="ip" name="author" id="author" /></td>
		 <td class="tdleft"><span id="author1"></span>填写作者姓名</td>
	</tr>
    <tr>
		 <td>出版社名：</td>
		 <td><input type="text" class="ip" name="publishing" id="publishing" /></td>
		 <td class="tdleft"><span id="publishing1"></span>填写出版社名</td>
	</tr>
    <tr>
		 <td>出版时间：</td>
		 <td><input type="text" class="ip" name="publishingtime" id="publishingtime"  /></td>
		 <td class="tdleft"><span id="publishingtime1"></span>格式：2011-11</td>
   </tr>
   <tr>
		 <td>价&nbsp;&nbsp;&nbsp;&nbsp;格：</td>
		 <td><input type="text" class="ip" name="price" id="price" /></td>
		 <td class="tdleft"><span id="price1"></span>购书价格</td>
  </tr>
  <tr>
		 <td>位&nbsp;&nbsp;&nbsp;&nbsp;置：</td>
		 <td><input type="text" class="ip" name="adress" id="adress" /></td>
		 <td class="tdleft"><span id="adress"></span>藏书物理位置</td>
  </tr>
  <tr>
		 <td></td>
		 <td><input type="submit" name="button" value="添加" size="12" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="button" value="重置" size="12" /></td>
		 <td></td>
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

