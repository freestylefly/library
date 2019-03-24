<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/style2.css" type="text/css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>My JSP 'showBookManger.jsp' starting page</title>
    
    
  </head>
  
 <body background="Images/back.gif">
  <form name="form" method="post">
  <table align="center">
      <caption>高级查询</caption>
  <tr>
  <td>书号：</td>
  <td class="even">${booksVo.shuhao }</td>
  </tr>
  
  <tr>
  <td>书名：</td>
  <td class="even">${booksVo.bookname }</td>
  </tr>
  
  <tr>
  <td>作者：</td>
  <td class="even">${booksVo.author }</td>
  </tr>
  
  <tr>
  <td>出版社：</td>
  <td class="even">${booksVo.publishing }</td>
  </tr>
  
  <tr>
  <td>出版时间：</td>
  <td class="even">${booksVo.publishingtime }</td>
  </tr>
  
  <tr>
  <td>价格：</td>
  <td class="even">${booksVo.price }</td>
  </tr>
  
  <tr>
  <td>地址：</td>
  <td class="even">${booksVo.adress }</td>
  </tr>
  
  <tr>
  <td>借阅情况：</td>
  <td class="even">
      <c:if test="${booksVo.isrenting==1}">已借阅</c:if>
      <c:if test="${booksVo.isrenting==0}">未借阅</c:if>
  </td>
  </tr>
  
  <tr>
  <td><input type="button" value="返回" onclick="javascript:history.go(-1);"/></td>
  <td class="even">&nbsp;</td>
  </tr>
  
  </table>
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
