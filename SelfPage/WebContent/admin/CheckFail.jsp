<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错了</title>
</head>
<body>
<h1>请选择一个数据进行修改,两秒后自动返回</h1>
<%response.setHeader("refresh","2;adminPage.jsp");%>
</body>
</html>