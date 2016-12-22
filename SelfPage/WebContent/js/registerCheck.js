/**
 * 
 */
$(function(){ 
$("#rg2").click(function(event){
    var y2=document.getElementById("y2");
    var m2=document.getElementById("m2");
    if(y2.value=="请输入用户名" || y2.value==""){
    	alert("请输入用户名！");
    	event.preventDefault();/* 抑制默认事件 */
    }else if("请输入密码"== m2.value || m2.value==""){
    	alert("请输入密码！");
    	event.preventDefault();
    }
  }); 
});

	

	/*else if (y1.value=="wangyuchen" && m1.value=="123456") {
		alert("登录成功！");
	}else {
		alert("登录失败！错误的用户名密码！请重新输入");
	}*/
