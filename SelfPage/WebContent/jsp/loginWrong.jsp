<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误的用户名密码</title>
</head>
<body>
	<!-- <script type="text/javascript">
	alert("登录失败！错误的用户名密码！请重新输入");
	
	</script> -->
	登录失败！错误的用户名密码！请重新输入!一秒后跳转
	<%response.setHeader("refresh", "1;url=login.jsp");%>
</body>
</html>