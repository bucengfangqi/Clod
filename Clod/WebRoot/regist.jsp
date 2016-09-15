<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>免费云盘注册页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	font-size: 18px;
	font-family: 华康楷体W5;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

input#test1,test2,test3 {
	color: #808080;
}

#test5 {
	text-align: center;
}

#test6 {
	padding-top: 20px;
	padding-left: 10px;
	padding-right: 10px;
}

#test7 {
	text-align: center;
	padding-bottom: 5px;
	color:grey;
	
}

#test8 {
	background-color: green;
	width: 272px;
	height: 30px;
	text-align: center;
	color: white;
	border:1px solid grey;
}

#test9 {
	position: absolute;
	border: 1px solid grey;
	top: 20%;
	left: 40%
}

#test10 {
	padding-top: 10px;
	font-size: 20px;
	color: green;
	font-weight: bold;
}
</style>
<script src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function myfunction() {
		var x = document.getElementById("test1").value;
		var y = document.getElementById("test5");
		/* 去除素有空格是否为空 */
		if (x.replace(/\s+/g, "").length == 0) {
			y.innerHTML = "请您输入用户名~(空格不算字符)";
			$(document).ready(function() {
				$("#test5").slideDown(300);
			});
		} else {
			$(document).ready(function() {
				$("#test5").slideUp(300);
			});
			$(document).ready(function() {
				$("#test11").fadeOut(300);
			});
		}
	}

	function myfunction1() {
		var z = document.getElementById("test2").value;
		var y = document.getElementById("test5");
		/* 去除素有空格是否为空 */
		if (z.replace(/\s+/g, "").length == 0) {
			y.innerHTML = "请您输入密码~(空格不算字符)";
			$(document).ready(function() {
				$("#test5").slideDown(300);
			});
		} else {
			$(document).ready(function() {
				$("#test5").slideUp(300);
			});
			$(document).ready(function() {
				$("#test11").fadeOut(300);
			});
		}
	}

	function myfunction2() {
		var w = document.getElementById("test3").value;
		var y = document.getElementById("test5");
		/* 去除素有空格是否为空 */
		if (w.replace(/\s+/g, "").length == 0) {
			y.innerHTML = "请您输入确认密码~(空格不算字符)";
			$(document).ready(function() {
				$("#test5").slideDown(300);
			});
		} else {
			$(document).ready(function() {
				$("#test5").slideUp(300);
			});
			$(document).ready(function() {
				$("#test11").fadeOut(300);
			});
		}
	}
	$(document).ready(function(){
	$("#test5").hide();
	});
	
	$(document).ready(function(){
  $("#test8").mouseover(function(){
    $("#test8").fadeTo(50,0.5);
  });
  $("#test8").mouseout(function(){
    $("#test8").fadeTo(50,1);
  });
});
</script>
</head>

<body>

	<form action="servlet/regist" method="post">
		<div id="test9">
			<div id="test6">
				<div id="test10">欢迎注册免费云盘！</div><font color="#99CC00" id="test11">${message}</font>
				<br />新用户名:<input type="text" name="username"
					placeholder="手机号/QQ号/邮箱" id="test1" onblur="myfunction()" /><br />
				<br />用户密码:<input type="password" name="password"
					placeholder="请输入您的密码" id="test2" onblur="myfunction1()" /> <br />
				<br />确认密码:<input type="password" name="password1"
					placeholder="请确认您的密码" id="test3" onblur="myfunction2()" /> <br />
				<br /> <input type="submit" value="提交新账户" id="test8" />
			</div>
			<hr />
			<div id="test7">
				<a href="login.jsp"><font color="grey">返回登录界面</font></a>
			</div>
			<font color="#99CC00"><div id="test5">亲~别来无恙呀！</div>
			</font>
		</div>
	</form>

</body>
</html>
