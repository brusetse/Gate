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
			var op = "<option>请选择城市</option>";
			for (var i = 0; i < data.length; i++) {
				op += "<option value='"+data[i].cityID+"'>"+data[i].city+"</option>";
			}
			document.getElementById("city").innerHTML = op;
		});
	}
	function getArea(father){
		ajaxutil("get","areaServlet","father="+father,true,null,
		function(req){
			eval("data="+req.responseText);
			var op = "<option>请选择地区</option>";
			for (var i = 0; i < data.length; i++) {
				op += "<option value='"+data[i].areaID+"'>"+data[i].area+"</option>";
			}
			document.getElementById("area").innerHTML = op;
		});
	}
</script>
<body>
	<select onchange="getCity(this.value);getArea(this.value)">
		<option>请选择省份</option>
		<c:forEach items="${plist }" var="plist">
		<option value="${plist.provinceID }">${plist.province }</option>
		</c:forEach>
	</select>
	<select id="city" onchange="getArea(this.value)">
	</select>
	<select id="area">
	</select>
</body>
</html>