<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>上传下载站</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#test5,#test8{
border:1px solid grey;
background-color:#99CC00;
text-align:center;
font-size:18px;
padding-top:2px;
padding-bottom:2px;
}
#test8{
background-color: #999933;
}
#test1,#test2,#test3{
color:#FFF;
background-color:#99CC00;
}
#test6{
border:1px solid grey;
position: absolute;
	top: 20%;
	left: 40%;
	padding: 20px;
	padding-top:30px;
	padding-bottom:0px;
}
#test7{
	color: green;
	font-size:22px;
	font-weight: bold;
}
*{
text-decoration:none;
font-family:Consolas;

}
</style>
<script src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("div#test1").mouseover(function(){
    $("div#test1").css("background-color","#6600FF");
  });
  $("div#test1").mouseout(function(){
    $("div#test1").css("background-color","#99CC00");
  });
});
$(document).ready(function(){
  $("div#test2").mouseover(function(){
    $("div#test2").css("background-color","#6600FF");
  });
  $("div#test2").mouseout(function(){
    $("div#test2").css("background-color","#99CC00");
  });
});

$(document).ready(function(){
  $("div#test3").mouseover(function(){
    $("div#test3").css("background-color","#6600FF");
  });
  $("div#test3").mouseout(function(){
    $("div#test3").css("background-color","#99CC00");
  });
});
$(document).ready(function(){
  $("div#test5").mouseover(function(){
    $("div#test5").css("background-color","#6600FF");
  });
  $("div#test5").mouseout(function(){
    $("div#test5").css("background-color","#99CC00");
  });
});

$(document).ready(function(){
  $("div#test8").mouseover(function(){
    $("div#test8").css("background-color","#6600FF");
  });
  $("div#test8").mouseout(function(){
    $("div#test8").css("background-color","#999933");
  });
});
$(document).ready(function(){
  $("div#test4").mouseover(function(){
    $("div#test4").fadeTo(50,0.5);
  });
  $("div#test4").mouseout(function(){
    $("div#test4").fadeTo(50,1);
  });
});
</script>	
</head>

<body>
			
			<form action="servlet/upload" enctype="multipart/form-data" method="post">
				<div id="test6">
				<div id="test7">欢迎使用免费云盘</div><br />
				<div id="test1"><input type="file" name="Demo1" style="font-size:18px;width:230px;"/></div><br />
				<div id="test2"><input type="file" name="Demo2" style="font-size:18px;width:230px;"/></div><br />
				<div id="test3"><input type="file" name="Demo3" style="font-size:18px;width:230px;"/></div><br />
				<div id="test4"><input type="submit" value="上传" mouseover="myfunction()" mouseover="myfunction1()" style="font-size:18px;background-color:#99CC00;width:230px;color:white;border:1px solid grey;"/></div><br />
				<div id="test5"><a href="servlet/listfileDownload" style="color:#FFF;width:230px;">>>文件下载页</a></div><br />
				<div id="test8"><a href="login.jsp" style="color:#FFF;width:230px;"><<<退出登录</a></div>
				<br /><font size="4" color="green" id="test9">${message}</font>
				</div>
			</form>
</body>
</html>
