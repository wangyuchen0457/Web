<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/Css.css" type="text/css">
<title>注销</title>
</head>
<body>
	<hr />
	<%
		response.setHeader("refresh", "1;url=../index.html");
		session.invalidate();
	%>

	<div id="div1"><img class="zaijian" alt="再见" src="../image/zaijian.jpg">
		<div id="div2">您已成功退出，两秒后自动跳转。<br /> 如果没有跳转，请按<a href="../index.html">这里 </a>
		</div></div>
</body>
</html>