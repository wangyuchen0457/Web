var $divDS; //显示所有地鼠的层
var $spansum; //显示击中个数
var $spantime; //显示当前用时

var sum = 0; //点击到的个数
var time = 0; //用时
var closetime; //计时方法
var closeShow; //显示地鼠方法

//随机显示地鼠
function showDS() {
	//产生一个0~24之间的随机数
	var num = parseInt(Math.random() * 10000 % 25);
	//得到对应下标的图片
	var $img = $divDS.find("img").eq(num);
	//显示该图片
	$img.attr("src", "img/01.jpg").show();

	//每隔200毫秒随机显示下一只地鼠
	clearTimeout(closeShow);
	closeShow = setTimeout("showDS()", 200);
}
//开始记时
function startTime() {
	time = time + 0.01;
	$spantime.text(time.toFixed(2));
}
//开始游戏
function gameStart(div1, span1, span2) {
	$divDS = div1;
	$spansum = span1;
	$spantime = span2;

	//生成地鼠界面
	for (var i = 0; i < 25; i++) {
		var $ds = $("<div class='ds'></div>");
		$ds.append($("<img src='img/01.jpg' />").hide());
		$divDS.append($ds);
	}
	
	//添加地鼠的点击事件
	$("img").click(function() {
		$(this).attr("src", "img/02.jpg");
		$(this).fadeOut(1000); //1秒之内慢慢消失
		sum = sum + 1;
		$spansum.text(sum);		//改变击中的次数
		//如果击中100次，则停止游戏
		if (sum == 100) {
			clearTimeout(closeShow);
			clearInterval(closetime);
			alert("消灭100只用时：" + time.toFixed(2));
		}
	});
	//每隔10毫秒改变当前用时
	closetime = setInterval("startTime()", 10);
	showDS();
}
//重置游戏
function gamereset(){
	clearTimeout(closeShow);
	clearInterval(closetime);
	$divDS.html("");
	$spansum.text("0");
	$spantime.text("0.00");
	sum = 0; 
	time = 0; 
}
