<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/Css.css" type="text/css">
<link rel="shortcut icon" href="../ico/index.ico" />
<script type="text/javascript" src="../js/time.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页</title>
</head>
<body background="../image/zisejianbian.jpg" onload="time()">
	<hr />
	<%

		if (session.getAttribute("userid") != null) {
		//if (request.getAttribute("userid") != null) {
	%>
	<h4>
		欢迎<%=session.getAttribute("userid")%>光临本系统 <br />
		<%-- 欢迎<%=request.getAttribute("userid")%>光临本系统 <br /> --%>
		<center>
			<a href="../nineNine/NineNine.html"><input class="bt"
				type="button" name="nineNine" title="打印乘法表" value="打印九九乘法表"
				style="width: 15%;"></a> <a href="../game/DDS/dadishu.html"><input
				class="bt" type="button" name="DDS" title="打地鼠" value="打地鼠游戏"
				style="width: 15%;"></a>
		
			<a href="../game/tanchishe/tanchishe.html"><input class="bt"
				type="button" name="tanchishe" title="贪吃蛇" value="贪吃蛇游戏"
				style="width: 15%;"></a>
		
			<a href="../game/tanchishe2/tanchishe2.html"><input class="bt"
				type="button" name="tanchishe" title="贪吃蛇" value="贪吃蛇游戏2"
				style="width: 15%;"></a>
		
			<a href="../game/eluosifangkuai/eluosifangkuai.html"><input class="bt"
				type="button" name="tanchishe" title="俄罗斯方块" value="俄罗斯方块"
				style="width: 15%;"></a>
		</center>
	</h4>

<div>
<h3>在线用户人数</h3>
<%-- <%
	Set all = (Set)this.getServletContext().getAttribute("online");
%>		
 <%= all.size()%> --%>
<%
	Set all = (Set)this.getServletContext().getAttribute("online");
	Iterator iter = all.iterator();
	int i=1;
	while(iter.hasNext()){

%>		
	第<%=i%>位用户	<%=iter.next()%>
<%		
	i++;}
%>
</div>
	<hr />
	<div align="center">
		<input type="image" src="../image/tuichudenglu.png" title="注销"
			width="20" height="20"> <a href="../jsp/logout.jsp"> <input
			class="bt" name="button" type="button" title="点击注销" value="注销"
			style="background-image: url('../image/chengsebolang.gif');"></a>
	</div>
	<%
		} else {
	%>
	<h4>
		请先进行<a href="../jsp/login.jsp">登录</a>
	</h4>
	<%
		}
	%>

	<div id="showtime" align="center"></div>

</body>
</html>