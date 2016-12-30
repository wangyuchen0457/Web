<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改数据</title>
</head>
<body>
<center>
<%
String[] chname = request.getParameterValues("check"); //获取checked的checkbox对应的value
String checkname=chname[0];
System.out.println("checkname:"+checkname);
//request.setAttribute("checkname", checkname);
%>
<form action="/SelfPage/servlet/Update?checkname=<%=checkname%>" method="post">
	<span>姓名：</span><input type="text" name="cname" value="<%=checkname%>"><br/>
	<input type="submit" value="更改">
</form>
</center>
</body>
</html>