<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="gzsxt" uri="http://java.sun.com/jsp/jstl/mytag" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<gzsxt:hello></gzsxt:hello><hr>
<%
List list = new ArrayList();
list.add("a");
list.add("b");
list.add("c");
list.add("d");
pageContext.setAttribute("userlist", list);
%>
<gzsxt:foreach items="${userlist}" var="u">
${u }
<hr>
</gzsxt:foreach>
</body>
</html>