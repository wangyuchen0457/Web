/**
 * 
 */


function changeA() {
	
	var y1=document.getElementById("y1");
	var m1=document.getElementById("m1");
	if(y1.value=="请输入用户名" || y1.value==""){
		alert("请输入用户名！");
	}else if(m1.value=="请输入密码" || m1.value==""){
		alert("请输入密码！");
	}else if (y1.value=="wangyuchen" && m1.value=="123456") {
		alert("登录成功！");
	}else {
		alert("登录失败！错误的用户名密码！请重新输入");
	}
}
