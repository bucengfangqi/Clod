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

<title>免费云盘登录页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input#test1,#test2 {
	font-size: 18px;
	color: #808080;
}

* {
	font-size: 18px;
	font-family: 华康楷体W5;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

#test3 {
	font-size: 16px;
	color:grey;
}

#test6 {
	padding-top: 20px;
	position: absolute;
	border: 1px solid grey;
	position: absolute;
	top: 20%;
	left: 40%;
}

#test7 {
	padding-bottom: 8px;
	text-align: center;
}

#test8 {
	background-color: green;
	width: 188px;
	height: 30px;
	text-align: center;
	color: white;
	border:1px solid grey;
}

#test9 {
	padding-top: 10px;
	font-size: 20px;
	color: green;
	font-weight: bold;
}

#test10 {
	padding-left: 20px;
	padding-right: 10px;
}
</style>
<script src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function myfunction() {
		var x = document.getElementById("test1").value;
		var y = document.getElementById("test5");
		/* 去除素有空格是否为空 */
		if (x.replace(/\s+/g, "").length == 0) {
			y.innerHTML = ">>小提示:账号别忘了哈";
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
			y.innerHTML = ">>小提示:记得输入密码哈";
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
	<form action="servlet/judge" method="post">
		<div id="test6">
			<div id="test10">
				<div id="test9">欢迎使用免费云盘！</div>
				<font color="#99CC00" id="test11">${message}</font>
				<br /> <input type="text" name="username" placeholder="用户名/手机/QQ号"
					id="test1" onblur="myfunction()" /><br /> <br /> <input
					type="password" name="password" placeholder="请输入您的密码" id="test2"
					onblur="myfunction1()" /> <br /> <br /> <input type="submit"
					value="登录" id="test8" />
			</div>
			<hr />
			<div id="test7">
				忘记密码?&nbsp;|&nbsp;<a href="regist.jsp" id="test3">注册新账号</a>
			</div>
			<font color="#99CC00"><div id="test5" align="center">亲~别来无恙呀~</div>
			</font>
		</div>
	</form>

</body>
</html>
