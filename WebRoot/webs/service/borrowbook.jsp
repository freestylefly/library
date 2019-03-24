<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>borrowbook.jsp</title>
        <script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="/library/login/logout.jsp";
				}
			}
		</script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="JS/onclock.JS" type="text/javascript"></script>
    <link href="css/style0.css" rel="stylesheet" type="text/css" />
    <% 
  if("1".equals(request.getParameter("flag"))){
%>
<script language='javascript' type='text/javascript'>alert('无此书记录')</script>
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
      &nbsp;&nbsp;当前位置：图书借还 》》 </div>
    <div id="main_2">
      <div id="main_2_1"></div>
      <div id="main_2_2">
        <div id="main_2_2_1">
          <form name="form1" method="post" action="/library/ShowBorrowsServlet">
            <table>
              <tr>
                <td><img src="Images/main_2_2_1bg.gif" width="142" height="30" /></td>
                <td> 读者条形码:
                    <input type="text" name= "xuehao" class="ip2" />
                  <span id="xuehao1"></span> </td>
                <td><input name="Submit"  type="submit" value="确定" /></td>
              </tr>
            </table>
          </form>
        </div>
        <form name="form2" method="post" action="/library/Borrowservlet">
          <div id="main_2_2_2">
            <table>
              <c:forEach items="${list2}" var="list2">
                <tr>
                  <td>&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;号:
                    <input type="text" name="xuehao" value="${list2.xuehao}" readonly class="ip" /></td>
                  <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名:
                    <input type="text" name="reader_name" value="${list2.reader_name}" readonly class="ip" /></td>
                  <td>班级:
                    <input type="text" name="classname" value="${list2.classname }" readonly class="ip" /></td>
                </tr>
                <tr>
                  <td>&nbsp;已借数量:
                    <input type="text" style= "color:#ff0000 " name="borrow_num" value="${list2.borrow_num }" readonly class="ip1" />
                    &nbsp;册</td>
                  <td>可借数量:
                    <input type="text" style= "color:#ff0000 " name="borrow_num" value="${10-list2.borrow_num}"readonly class="ip1" />
                    &nbsp;册</td>
                  <td></td>
                </tr>
              </c:forEach>
            </table>
          </div>
          <div id="main_2_2_3">
            <table>
              <tr>
                <td><img src="Images/main_2_2_3bg.gif" width="142" height="30" /></td>
                <td>图书条形码:
                  <input type="text" name= "shuhao" class="ip2" /></td>
                <td><input name="Submit"  type="submit" value="确定" /></td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
    <div id="main_3">
      <table>
        <thead>
          <tr>
            <td></td>
            <td>书号</td>
            <td class="even">书名</td>
            <td>借阅时间</td>
            <td>应还时间</td>
            <td>是否过期</td>
            <td>操作</td>
          </tr>
        </thead>
        <c:forEach items="${list1}" var="list1">
          <tr>
            <td>+</td>
            <td>${list1.shuhao }</td>
            <td>${list1.bookname }</td>
            <td>${list1.borrowtime }</td>
            <td>${list1.backtime }</td>
            <td ><c:if test="${list1.timepass ==0}"></c:if>
                <c:if test="${list1.timepass ==1}">已过期</c:if>
            </td>
            <td><c:if test="${list1.shuhao !=null}"><a href="/library/BackServlet?shuhao=${list1.shuhao }&xuehao=${list1.xuehao }">还书</a></c:if>
                <c:if test="${list1.shuhao ==null}"></c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
    <div id="fenye"> <br />
        <c:if test="${page ==1}">首页</c:if>
        <c:if test="${page > 1}"><a href="/library/ShowBorrowsServlet?page=1">首页</a></c:if>
        <c:if test="${page ==1}">上一页</c:if>
        <c:if test="${page > 1}"><a href="/library/ShowBorrowsServlet?page=${page-1 }">上一页</a></c:if>
        <c:if test="${page == maxpage}">下一页</c:if>
        <c:if test="${page < maxpage}"><a href="/library/ShowBorrowsServlet?page=${page+1 }">下一页</a></c:if>
        <c:if test="${page == maxpage}">末页</c:if>
        <c:if test="${page < maxpage}"><a href="/library/ShowBorrowsServlet?page=${maxpage }">末页</a></c:if>
    </div>
    <div id="footer1">
      <div id="footer1_1">本系统使用IE6.0或以上版本&nbsp;1024*768为最佳显示效果</div>
    </div>
  </div>
</div>
</body>
</html>

