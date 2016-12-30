<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
	<h4>
		请输入管理员密码
	</h4>
	<form action="/SelfPage/servlet/AdminLogin">
	<input name="adminPwd" type="text" id="m1" title="请输入少于16个字符" maxlength="16" 
		value="请输入管理员密码"style="width: 240px; height: 30px;" 
		onfocus="if(value==defaultValue){this.value='';this.type='password'}"><br/>
	<input id="rg1" class="bt" name="submit" type="submit" title="点击登录" value="管理员登录" >
	<a href="welcome.jsp"><input class="bt" name="register" type="button"
					title="返回" value="退出" onclick="<%	session.removeAttribute("aPwd");%>"></a>
	</form>
</body>
</html>