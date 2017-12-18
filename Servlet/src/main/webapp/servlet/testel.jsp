<%@page import="cn.gzsxt.po.User"%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%
//按照”pageContext,request,session,application”的顺序
pageContext.setAttribute("cmd", "pageContext");
session.setAttribute("cmd", "session");
request.setAttribute("cmd", "request");
application.setAttribute("cmd", "application");
%>

</head>
<body>
<%=((User)request.getAttribute("user")).getUname() %>
<hr/>
${cmd }
<hr/>
${user.uname }
${user.phone }
${user.addr.country }
<hr/>
${sessionScope.cmd }
<hr/>
${pageScope.user.uname }
<hr/>
${requestScope.user.addr.city }
</body>
</html>