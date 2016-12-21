<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<h2>欢迎新用户注册</h2><hr/>
<form action="/SelfPage/servlet/Register" method="post">
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
						<input class="bt" name="submit" type="submit" title="点击确定注册"
							value="注册" ><!-- onclick="changeA()" -->
					</center></td>
				<td colspan="3"><input class="bt" name="reset" type="reset"
					title="点击重置" value="重置"></td>
			</table>
		</form>
</form>
</body>
</html>