<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/ajaxutil.js"></script>
<script type="text/javascript">
	function test(id){
		ajaxutil("get","studentQuery","id="+id,true,null,
		function(req){
			eval("data="+req.responseText);
			var tb = "<table width='200' border='1' bordercolor='red'>";
			for (var i = 0; i < data.length; i++) {
				tb += "<tr>"+"<td>"+data[i].name+"</td>"+"<td>"+data[i].class_id+"</td>"+"<tr>";
			}
			tb += "</table>";
			document.getElementById("info").innerHTML = tb;
		});
	}
</script>
<body>
<c:forEach items="${list }" var="list">
	<div onmouseover="test(${list.class_id})" style="border:red solid 2px;width:100px" >${list.class_name }</div>
</c:forEach>
<div id="info"></div>
</body>
</html>