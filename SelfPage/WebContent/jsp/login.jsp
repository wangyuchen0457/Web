<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/denglu.js"></script>
<link rel="stylesheet" href="../css/Css.css" type="text/css">
<link rel="shortcut icon" href="../ico/login.ico" />
<script type="text/javascript" src="../js/time.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body id="logbody" onload="time()">
	<h1>登录界面</h1>
	<hr/>
	<div align="right" style="opacity: 0.8">
		<img src="../image/touxiang.png" style="margin-right: 10%;"> <br />
		<form action="/SelfPage/servlet/Login" method="post">
			<table>
				<tr>
					<td><img alt="用户名" title="输入用户名" src="../image/yonghuming.png"
						width="30" height="30" style="opacity: 1"></td>
					<td colspan="2"><input name="usrname" type="text"
						title="请输入少于16个字符" value="请输入用户名" id="y1" 
						style="width: 240px; height: 30px; "
						onFocus="if(value==defaultValue){this.value=''}" maxlength="16"></td>
					<td colspan="2"></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td><img alt="密码" title="输入密码" src="../image/mima.png"
						width="30" height="30" style="opacity: 1"></td>
					<td colspan="2"><input name="password" type="text" id="m1"
						title="请输入少于16个字符" maxlength="16" value="请输入密码"
						style="width: 240px; height: 30px;"
						onfocus="if(value==defaultValue){this.value='';this.type='password'}"></td>
					<td colspan="2"></td>
				</tr>
				<td colspan="2"><center>
						<input class="bt" name="submit" type="submit" title="点击登录"
							value="登录" ><!-- onclick="changeA()" -->
					</center></td>
				<td colspan="3"><a href="register.jsp"><input class="bt" name="register" type="button"
					title="点击注册新用户" value="注册"></td></a>
			</table>
		</form>
	</div>
	<%-- <%
		String name = request.getParameter("usrname");
		String password = request.getParameter("password");

		if (!((name == null || "".equals(name)) && (password == null || "".equals(password)))) {
			if ("wangyuchen".equals(name) && "123456".equals(password)) {
				response.setHeader("refresh", "1;url=welcome.jsp");
				session.setAttribute("userid", name);
	%>
	<div class="div1">
		<h6>用户登录成功，两秒后自动跳转！</h6>
		<h6>
			如果没有跳转，请按<a href="welcome.jsp">这里</a>
		</h6>
	</div>
	<%
		} 
		}
	%> --%>
	<br/><br/><br/><br/><br/><br/><br/><br/>
<div id="showtime" align="right" style="margin-right: 100px;"></div>
</body>
</html>