<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <body>
<%
session.invalidate();
out.println("<script language='javascript'>");
out.println("window.location.href='login.html'");
out.println("</script>");
%>	


</body>
</html>
