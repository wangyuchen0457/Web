<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户名不存在</title>
</head>
<body>
<!-- 	<script type="text/javascript">
	alert("用户名不存在！请重新输入");
	</script>  -->
 登录失败！用户名不存在！请重新输入!一秒后跳转
	<%response.setHeader("refresh", "2;url=login.jsp");%>
</body>
</html>