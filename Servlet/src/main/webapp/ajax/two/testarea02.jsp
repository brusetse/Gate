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
	function getCity(father){
		ajaxutil("get","cityServlet","father="+father,true,null,
		function(req){
			eval("data="+req.responseText);
			var tb = "<table width='200' border='1' bordercolor='red'><tr>";
			for (var i = 0; i < data.length; i++) {
				tb += "<td onmouseover='getArea("+data[i].cityID+")' >"+data[i].city+"</td>";
			}
			tb += "</tr></table>";
			document.getElementById("city").innerHTML = tb;
		});
	}
	function getArea(father){
		ajaxutil("get","areaServlet","father="+father,true,null,
		function(req){
			eval("data="+req.responseText);
			var tb = "<table width='200' border='1' bordercolor='red'><tr>";
			for (var i = 0; i < data.length; i++) {
				tb += "<td>"+data[i].area+"</td>";
			}
			tb += "</tr></table>";
			document.getElementById("area").innerHTML = tb;
		});
	}
</script>
<body>
	<table width='200' border='1' bordercolor='red'>
	<tr>
	<c:forEach items="${plist }" var="plist">
	<td onmouseover="getCity(${plist.provinceID})">${plist.province }</td>
	</c:forEach>
	</tr>
	</table>
	<div id="city"></div>
	<div id="area"></div>
</body>
</html>