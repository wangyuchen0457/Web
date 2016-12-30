<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function del() {
		document.form1.action = "/SelfPage/servlet/Delete";
		document.form1.submit();
	}
	function update() {
		document.form1.action = "Update.jsp";
		document.form1.submit();
	}
</script>
<title>管理员界面</title>
</head>
<body>
	<center>
		<h2>用户管理</h2>
		<hr />
		<form name="form1" method="post">
			<input type="button" value="修改用户信息" onclick="update()">
			<input type="button" value="删除用户" onclick="del()">
			<a href="../jsp/welcome.jsp"><input class="bt" name="register" type="button"
					title="返回" value="退出"></a>
			<table>
				<thead>
					<tr>
						<td>&nbsp;</td>
						<td>用户名</td>
					</tr>
				</thead>
				<tbody>
				<% 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/db_selfpage","root","root");
				System.out.println("数据库连接成功！");
				String sql="select name from user limit 20;";
				Statement prestmt = connect.createStatement();
				ResultSet rs = prestmt.executeQuery(sql);
				int i=1;
				while (rs.next()) {
					String sqlname=rs.getString("name");
					%>
					<tr><td><input type="checkbox" value="<%=sqlname%>" name="check"><%=i%></td>
						<td><%=sqlname%></td></tr>
					<%
					i++;
				}
				rs.close();
				prestmt.close();
				connect.close();
				%>
				</tbody>
			</table>
		</form>
	</center>
</body>
</html>