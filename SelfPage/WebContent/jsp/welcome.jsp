<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/Css.css" type="text/css">
<script type="text/javascript" src="../js/time.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页</title>
</head>
<body background="../image/zisejianbian.jpg" onload="time()">
<hr/>
	<%
		if (session.getAttribute("userid") != null) {
	%>
	<h4>
		欢迎<%=session.getAttribute("userid")%>光临本系统
			<br/>
			<center><a href="../nineNine/NineNine.html"><input class="bt" type="button" name="nineNine" title="打印乘法表" value="打印九九乘法表" style=" width:15%;"></a>
			<a href="../DDS/dadishu.html"><input class="bt" type="button" name="DDS" title="打地鼠" value="打地鼠游戏" style=" width:15%;"></a></center>
	</h4>
	
	<img class="welimg1" alt="新年快乐" src="../image/jinian2017.png"><img class="welimg2" alt="圣诞快乐" src="../image/shengdan.png">
	<hr/>
	<div align="center">
			<input type="image"src="../image/tuichudenglu.png" title="注销" width="20" height="20">
			<a href="logout.jsp">
			<input class="bt" name="button" type="button" title="点击注销" value="注销" style="background-image: url('../image/chengsebolang.gif');"></a>
	</div>
	<%
		} else {
	%>
	<h4>
		请先进行<a href="login.jsp">登录</a>
	</h4>
	<%
		}
	%>

<div id="showtime" align="center"></div>

</body>
</html>