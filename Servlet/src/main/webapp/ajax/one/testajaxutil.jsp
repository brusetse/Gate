<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/ajaxutil.js"></script>
<script type="text/javascript">
	function testajax(){
		ajaxutil("get","testAjax","cmd=test01",true,
			function(){
			document.getElementById("info").innerHTML = "<img src='img/1.gif' />";
			},
			function(){
				alert("200");
			},
			function(){
				alert("404");
			},
			function(){
				alert("500");
			});
	}
</script>
<body>
<input type="button" onclick="testajax()" value="testajax">
<div id="info"></div>
</body>
</html>