<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function initAjax() {

	var xmlHttp;

	try
	   {
	  // Firefox, Opera 8.0+, Safari
	   xmlHttp=new XMLHttpRequest();
	   }
	catch (e)
	   {

	 // Internet Explorer
	  try
	     {
	     xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	     }
	  catch (e)
	     {
	     try
	        {
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	        }
	     catch (e)
	        {
	        alert("您的浏览器不支持AJAX！");
	        }
	     }
	   }
	   return xmlHttp;
	}


function changeimg(){
	document.getElementById("img1").src="code?"+Math.random();
	
}

function check_nick() {
	var http_request = initAjax();
	
	var nickname = document.getElementById("uname").value;
	var res="null";
	http_request.open("get", "checknick?nick="+encodeURI(nickname), true);
	
	http_request.onreadystatechange = function() {
		if(http_request.readyState == 4) {
			if(http_request.status == 200) {
				 res=http_request.responseText;
					var issub=0;
					if(nickname.length==0)
						{
						document.getElementById("d1").style.color="red";
						document.getElementById("d1").innerHTML="昵称不能为空";
						issub=0;
						}
					else  
						{
						if(res=="yes")
						{
							document.getElementById("d1").style.color="red";
							document.getElementById("d1").innerHTML="该昵称已经被占用";
							issub=0;
						}
						else if(res=="no")
						{
						document.getElementById("d1").style.color="green";
						document.getElementById("d1").innerHTML="√";
					
						issub=1;
						}
						}
					
					if(issub==1)
						{
						document.getElementById("subm").removeAttribute("disabled");
						}
					else
						{
						document.getElementById("subm").setAttribute("disabled", "disabled");
						}
					
			}
		}
	};

	http_request.send();
}

</script>
</head>
<body>
<h1>Welcome to ChatRoom</h1>
<form name="form1" id="form1" action ="sortuser" method="get">
<table>
<tr><td>请输入你的昵称</td></tr>
<tr><td><input name="uname" id="uname" onchange="check_nick()"></td><td><div id="d1"style="color:#f00"></div></td>
<td><div id="d1"style="color:#f00"></div></td></tr>
<tr><td><input name="code" id="code"></td><td><img id="img1" name="img1" src="code"></td></tr>
<tr><td><input id="subm" type="submit" value="进入聊天室" disabled="disabled"></td></tr>
</table>
</form>
</body>
</html>