<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function testajax(){
		//1 创建XMLHttpRequest对象
		var request = new XMLHttpRequest();
		//4 构造响应函数
		//请求状态改变的事件触发器
		request.onreadystatechange = function(){
			/* readyState表示XMLHttpRequest对象的状态：
			0：未初始化。对象已创建，未调用open；
			1：open方法成功调用，但Send方法未调用；
			2：send方法已经调用，尚未开始接受数据；
			3：正在接受数据。Http响应头信息已经接受，但尚未接收完成；
			4：完成，即响应数据接受完成。 */
			if(4 == request.readyState){
				if(200 == request.status){
					var data = request.responseText;
					alert(data);
					document.getElementById("info").innerHTML = "";
				}
			}else{
				document.getElementById("info").innerHTML = "<img src='img/1.gif' />";
			}
		};
		//2 open 交互方法
		request.open("get", "testAjax?cmd="+encodeURIComponent("我是后台"), true);
		//3 发送请求信息
		request.send(null);
	}
</script>
<body>
<input type="button" onclick="testajax()" value="testajax">
<div id="info"></div>
</body>
</html>