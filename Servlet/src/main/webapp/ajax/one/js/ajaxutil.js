function ajaxutil(method,url,data,async,loading,hander200,hander404,hander500){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function(){
		if(4 == request.readyState){
			if(200 == request.status){
				if(hander200){
					hander200(request);
				}
//				document.getElementById("info").innerHTML = "";
			}
			if(404 == request.status){
				if(hander404){
					hander404();
				}
			}
			if(500 == request.status){
				if(hander500){
					hander500();
				}
			}
		}else{
			if(loading){
				loading();
			}
		}
	};
	if("get"==method.toLowerCase()){
		request.open("get", url+"?"+data, async);
		request.send(null);		
	}else if("post"==method.toLowerCase()){
		request.open("post", url, async);
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send(data);		
	}
}