<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
#test1{
position: absolute;
	top: 20%;
	left: 40%;
	border-collapse: collapse;
	background-color:#999933;
    border:"1px solid grey";
}
#test2{
background-color:#99CC00;
}
*{
text-decoration:none;
font-family:Consolas;
padding:10px;
padding-bottom:0px;
font-size:18px;
color:white;
text-align:center;
}
</style>
<script src="script/jquery-1.7.2.js"></script>
<script>
$(document).ready(function(){
  $("#test5").mouseover(function(){
    $("#test5").css("background-color","#6600FF");
  });
  $("#test5").mouseout(function(){
    $("#test5").css("background-color","#999933");
  });
</script>
</head>

<body >
	<table id="test1" border="1px solid green">
		<c:forEach var="me" items="${fileNameMap}">
			<c:url var="downurl" value="/servlet/Download">
				<c:param name="filename" value="${me.key}"></c:param>
			</c:url>
			<c:url var="deleteurl" value="/servlet/Delete">
				<c:param name="filename1" value="${me.key}"></c:param>
			</c:url>
			<tr>
				<td id="test6"><a href="${downurl}" >>>Download</a></td>
				<td>${me.key}</bold></td>
				<td id="test3"><a href="${deleteurl}">删除文件</a></td>
			</tr>
		</c:forEach>
		<tr id="test2">
			<td ><a href="upload.jsp">>>>上传页</a>
			</td>
			<td id="test4"><a href="servlet/DeleteAllFile">>>>删除所有文件</a>
			</td>
			<td>${message}</td>
		</tr>
	</table>
</body>
</html>
