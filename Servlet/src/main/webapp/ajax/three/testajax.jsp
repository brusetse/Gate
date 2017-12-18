<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/ajaxutil.js"></script>
	<script type="text/javascript">
		function fresh(){
			ajaxutil("get","freshServlet",null,true,null,
			function(req){
				eval("data="+req.responseText);
				var rs = "";
				for (var i = 0; i < data.length; i++) {
					rs += "<div>"+data[i].username+":"+data[i].content+"</div>";
				}
				document.getElementById("dialog").innerHTML = rs;
			});
		}
		function clearMsg(){
			ajaxutil("get","clearServlet",null,true,null,
			function(req){
				eval("data="+req.responseText);
				var rs = "";
				for (var i = 0; i < data.length; i++) {
					rs += "<div>"+data[i].username+":"+data[i].content+"</div>";
				}
				document.getElementById("dialog").innerHTML = rs;
			});
		}
		window.onload = function(){
			window.setInterval("fresh()",100);
		};
	</script>
</head>
<body>
<div id="dialog" style="border:red solid 1px;width:638px">
<c:forEach items="${list }" var="list">
	<div>${list.username }:${list.content }</div>
</c:forEach>
</div>
<form action="ajaxServlet" method="post" enctype="application/x-www-form-urlencoded">
用户名：<input style="width:100px" type="text" name="username">
内容：<input style="width:300px" type="text" name="message">
<input type="submit" value="发送">
<input type="button" onclick="clearMsg()" value="清空">
</form>
</body>
</html>