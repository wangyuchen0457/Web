/**
 * 
 */
$(function () {
		//打印table标签，同时设置属性
		var table = "<table border='1' id='tb1' class='blue'>"
		var ssSum = new Array();//竖行统计 数组
		var sum=0//总统计
		for (var i = 1; i <= 10; i++) {//循环打印十行
			ssSum[i - 1] = 0;//初始化数组每个值
			var hSum = 0; //横行统计
			if (i < 10) {         //十行以内打印乘法表
			table += "<tr>";//打印每一行的tr标签
				for (var j = 1; j <= 10; j++) {  //每行循环打印10列
					if (j <= i) {          // j<=i时打印乘法表
						ssSum[j - 1] += i * j;  //统计每一列的乘积和
						hSum += i * j;				//统计每一行的乘积和
						var data = ( "" + j + " * " + i + " = " + i * j
								+ "&nbsp;" );         			
						table += "<td>" + data + "</td>"; //打印乘法表
					} else if (j < 10) {				//j>i时打印空表格
						table += "<td></td>";
					} else if (j == 10) {
						//j=10打印统计数据  同时给统计数据的td一个class 用来控制隐藏和显示
						table += "<td class='sum'>" + hSum + "</td>";
						sum+=hSum;//计算总统计
					}
				}
			} else {  //最后一行时
				table += "<tr  class='sum'>";//打印最后一行的tr标签
				for (var k = 1; k < 10; k++) {   //循环打印最后一行的内容
					table += "<td class='sum'>" + ssSum[k - 1] + "</td>";
				}
				table += "<td class='sum'>" + sum + "</td>";
			}
			table += "</tr>";
		}
		table += "</table>";
		$("#p1").after(table);
	})
//控制打印
$(function () {
	$('#bt1').bind('click', function() {
		$('table').show('slow');
	})
})
//控制统计的显示
$(function () {
	$('#bt2').bind('click', function() {
		$('.sum').show('slow');
	})
})
//控制样式
$(function () {
	$('#bt3').bind('click', function() {
		if($('#tb1').attr('class') == "blue")
		{
			$('#tb1').attr('class','gray');
		}
		else {
			$('#tb1').attr('class','blue');
		}
	})
})