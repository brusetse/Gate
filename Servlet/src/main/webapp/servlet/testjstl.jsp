<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bruse.jstl.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
User user = new User();
pageContext.setAttribute("uname", "<div>lalala</div>");
%>
</head>
<body>
<c:out value="${uname }" default="" escapeXml="false"></c:out><hr>
<c:set var="t1" value="测试set" scope="request"></c:set>
${t1 }<hr>
<c:out value="${t1 }"></c:out><hr>
<c:remove var="t1" scope="request"/>
${t1 }<hr>
<%
pageContext.setAttribute("n1", 123);
%>
<c:if test="${n1>100}" var="aa" scope="application">n1大于100</c:if><hr>

</body>
</html>