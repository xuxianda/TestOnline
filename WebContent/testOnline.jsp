<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线考试</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script src="js/countdown.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<link rel="stylesheet" href="css/normalize.min.css">
		<link rel="stylesheet" href="css/load.css">
		<style>
			#button {
	width: 40px;
	height: 40px;
	font-size: 20px;
	padding: 10px;
}

#question {
	font-size:20px;
	position: relative;
	left: 50px;
}

#select {
	
}

.checkbox {
	width: 30px;
	height: 30px;
}

.ys1{
		color: #009AC1;
		font-weight: bold;
	}
</style>
	</head>
	<script src="js/donut-chart.min.js"></script>
	<body style="margin: 0px; padding: 0px; overflow: hidden; width: 100%">
		<div id="cc" class="easyui-layout" style="width: 100%; height: 100%">
			<div data-options="region:'north',split:true" style="height:60px;" id="North">
				<div style="">
					<table>
						<tr>
							<td>
								<div id="user" style="display: none;">
									<div>考生姓名：${user.uname}</div>
									<div>考生帐号：${user.username}</div>
								</div>
							</td>
							<td><button type="button" id="submit" onclick="submit()" style="display: none; width: 100px; height: 50px;">交卷</button></td>
							<td width="20%"></td>
							<td width="20%"></td>
							<td width="20%"></td>
							<td></td>
							<td><button id="back" onclick="reload()">刷新页面</button>
								<a href="index.action">返回首页</a></td>
							<td>
								<div id="login" style="display: none;">
									<a href="login.jsp">考生还未登陆</a>
								</div>
							</td>
						</tr>
					</table>





				</div>
			</div>



			<div data-options="region:'east',title:'答题卡',split:true" style="width: 300px;" id="East">
				<div id="card"></div>
			</div>


			<div data-options="region:'west',title:'试卷列表',split:true" style="width: 300px;" id="West">
				<ul id="menu" class="easyui-tree">
				</ul>
				<div id="text"></div>
			</div>


			<div data-options="region:'center',title:''" style="padding: 5px; background: #eee;text-align:left;">
				<span id="time" style="font-size: 20px; display: none;">
					<div class="container">
						考试剩余时间：<div class="container timeBar ys1" disabled="true" id="timeValue"></div>
					</div>
				</span>
				<div id="question">
					<span id="tyname"></span><br> <br>
					<div id="order" style="color:white;background: orange;width: 40px;text-align: center;float: left;"></div>
					<span id="qname" style="position: relative;left: 20px;"></span> <br>
					<hr width="75%" style="position: absolute;" /> <br> <br>
					<div id="select" style="display: none;">
						<span id="A" name="A"></span><br> <br> <span id="B" name="B"></span><br> <br> <span id="C" name="C"></span><br>
						<br> <span id="D" name="D"></span><br> <br>
					</div>


					<div id="jieda" style="display: none;">
						<span><textarea rows="25" cols="100" id="inputkey" oninput="input(this)">
							  </textarea> </span>
					</div>


					<div id="util" style="display: none;">
						<button type="button" id="left" onclick="left()" style="font-size: 20px; background:seagreen; border: 0; color: #FFFFFF;width:130px;height: 40px;">上一题</button>
						<button type="button" id="right" onclick="right()" style="font-size: 20px; background:seagreen; border: 0; color: #FFFFFF;width:130px;height: 40px;">下一题</button>
						<br /> <br />
					</div>

					<form method="post">
						<input id="mykey" type="hidden" name="mykey">
					</form>
				</div>
			</div>
		</div>
		<div id="ts" style="display: none;font-size: 20px;text-align: center;">您要进行在线考试吗?</div>
		<div id="login_error" style="display: none;font-size: 20px;text-align: center;">您还没有登陆！</div>
		<div id="question_over" style="display: none;font-size: 20px;text-align: center;">没有题目了！</div>
		<div id="test_over" style="display: none;font-size: 20px;text-align: center;">考试时间到，系统为您自动交卷，祝您有一个理想的成绩！</div>
		<div id="test_submit" style="display: none;font-size: 20px;text-align: center;">交卷成功，祝您有一个理想的成绩！</div>
		<div id="test_questions_error" style="display: none;font-size: 20px;text-align: center;">没有获取到该试卷的内容，请刷新网页后重试！</div>
		<div id="content" style="display: none;text-align: center;">
			<div class="load-wrapp">
				<div class="load-3">
					<div class="line"></div>
					<div class="line"></div>
					<div class="line"></div>
				</div>
			</div>
		</div>
	</body>
	<script type="application/javascript">
		var username = "${user.username}";
		console.log(username);
		var order = 0;
		var tqlist = null;
		var timess;
		var minute = 0;
		var maxminute = 0;
		var keyjson = "";
		var mykeylist = new Array();


		function reload() {
			location.reload();
		}


		if (username == undefined || username == null || username == "") {
			$("#login").css("display", "block");
			$("#user").css("display", "none");
		} else {
			$("#login").css("display", "none");
			$("#user").css("display", "block");
		}
		$(function() {
			var screeheight = $(window).height();
			var screewidth = $(window).width();
			$("#cc").width(screewidth);
			$("#cc").height(screeheight);
			$('#menu').tree({
				url: 'exam',
				method: 'get',
				onClick: function(node) {
					console.log(node.tid);
					$('#ts').dialog({
						title: '受否进行考试',
						width: 400,
						height: 200,
						closed: false,
						cache: false,
						modal: true,
						buttons: [{
							text: '是的',
							handler: function() {
								openload();
								$.ajax({
									type: "post",
									url: "exam/3",
									data: "tid=" + node.tid,
									dataType: "json",
									success: function(result) {
										tqlist = null;
										setTimeout(function() {
											tqlist = result;
											if (username == undefined || username == null || username == "") {
												$('#login_error').dialog({
													title: '错误',
													width: 400,
													height: 200,
													closed: false,
													cache: false,
													modal: true,
													buttons: [{
														text: '关闭', ////对话框内容关闭
														handler: function() {
															$("#login_error").dialog("close");
															$("#ts").dialog("close");
														}
													}]
												});
												return;
											}
											if (tqlist == undefined || tqlist == null || tqlist.length <= 0) {
												$('#test_questions_error').dialog({
													title: '错误',
													width: 400,
													height: 200,
													closed: false,
													cache: false,
													modal: true,
													buttons: [{
														text: '关闭', ////对话框内容关闭
														handler: function() {
															$("#test_questions_error").dialog("close");
															$("#ts").dialog("close");
														}
													}]
												});
												return;
											}
											$("#tname").text(tqlist[0].tname);
											$("#tsum").text(tqlist[0].tsum);
											$("#iframe").attr("src", "usertest.action");
											$("#ts").dialog("close");
											$("#util").css("display", "block");
											minute = tqlist[0].time;
											maxminute = tqlist[0].time;
											minute = Number(minute);
											$("#minute").text(minute);
											$("#time").css("display", "block");
											$("#menu").css("display", "none");
											$("#submit").css("display", "block");
											fortext();
											printQuestion(0);
											printCard();
											$("#timeValue").attr("data", minute * 60);
											$("#timeValue").attr("disabled", "false");
											$(".timeBar").each(function() {
												$(this).countdownsync({
													dayTag: "",
													hourTag: "<label class='tt hh dib vam'>00</label><span>时</span>",
													minTag: "<label class='tt mm dib vam'>00</label><span>分</span>",
													secTag: "<label class='tt ss dib vam'>00</label><span>秒</span>",
													dayClass: ".dd",
													hourClass: ".hh",
													minClass: ".mm",
													secClass: ".ss",
													isDefault: false,
													showTemp: 1
												}, function() {
													timeOver();
												});
											});
											closeload();
										}, 5 * 1000); //延迟5000毫米
									}
								})
							}
						}, {
							text: '关闭', ////对话框内容关闭
							handler: function() {
								$("#ts").dialog("close");
							}
						}]
					});
				}
			});

			function printCard() {
				for (var i = 0; i < tqlist.length; i++) {
					var button = "<button value=&quot;" + tqlist[i].qid + "&quot; id='button' onclick=printQuestion(" + i + ")>" + (
						i + 1) + "</button>";
					$("#card").append(button);
				}
			}

			function openload() {
				$('#content').dialog({
					title: '加载中',
					width: 400,
					height: 200,
					closed: false,
					cache: false,
					modal: true,
					buttons: [{
						text: '关闭', ////对话框内容关闭
						handler: function() {
							$("#content").dialog("close");
						}
					}]
				});
			}

			function closeload() {
				$("#content").dialog("close");
			}

		})

		function timeOver() {
			$('#test_over').dialog({
				title: '考试结束',
				width: 400,
				height: 200,
				closed: false,
				cache: false,
				modal: true,
				buttons: [{
					text: '关闭', ////对话框内容关闭
					handler: function() {
						$("#test_over").dialog("close");
						window.location.href = "index.action";
					}
				}]
			});
		}

		function left() {
			printQuestion(order - 1);
			getkey();
		}

		function right() {
			printQuestion(order + 1);
			getkey();
		}

		function printQuestion(index) {
			order = index;
			if (index < 0 || index >= tqlist.length) {
				$('#question_over').dialog({
					title: '错误',
					width: 400,
					height: 200,
					closed: false,
					cache: false,
					modal: true,
					buttons: [{
						text: '关闭', ////对话框内容关闭
						handler: function() {
							$("#question_over").dialog("close");
						}
					}]
				});
				if (index < 0) {
					order += 1;
				} else {
					order -= 1;
				}
			} else {
				$("#tyname").text(tqlist[index].tyname);
				$("#qname").text(tqlist[index].qname);
				$("#order").text(index + 1);
				console.log(tqlist[index]);
				if (tqlist[index].tyname == "单选题" || tqlist[index].tyname == "多选题") {
					$("#select").css("display", "block");
					$("#jieda").css("display", "none");
					console.log(tqlist[index].a);
					$("#A").html("<input id='Acheck' type='checkbox' name='A' value='A' class='checkbox' onclick='checkbox()'/>" +
						"A. " + tqlist[
							index].a);
					$("#B").html("<input id='Bcheck' type='checkbox' name='B' value='B' class='checkbox' onclick='checkbox()'/>" +
						"B. " + tqlist[
							index].b);
					$("#C").html("<input id='Ccheck' type='checkbox' name='C' value='C' class='checkbox' onclick='checkbox()'/>" +
						"C. " + tqlist[
							index].c);
					$("#D").html("<input id='Dcheck' type='checkbox' name='D' value='D' class='checkbox' onclick='checkbox()'/>" +
						"D. " + tqlist[
							index].d);
					getkey();
				} else if (tqlist[index].tyname == "解答题") {
					$("#inputkey").val("");
					$("#jieda").css("display", "block");
					$("#select").css("display", "none");
					getValue();
				}
			}
		}

		function getValue() {
			$("#inputkey").val(mykeylist[order].value);
		}

		function savet(index, key) {
			mykeylist.set("" + index, key);
		}

		function input(node) {
			console.log(node);
			save(order, node.value);
		}

		function checkbox() {
			let mykey = "";
			let aaa = -1;
			for (var i = 0; i < $(".checkbox").length; i++) {
				var checkbox = $(".checkbox")[i];
				if (checkbox.checked) {
					if (i == 0) {
						mykey += "A";
					} else if (i == 1) {
						mykey += "B";
					} else if (i == 2) {
						mykey += "C";
					} else if (i == 3) {
						mykey += "D";
					}
					aaa = i;
				}
			}
			if (aaa != -1) {
				save(order, mykey);
			}
		}


		function save(index, key) {
			var obj = {
				"order": index,
				"value": key
			};
			console.log(obj);
			if (mykeylist[index] == undefined) {
				mykeylist.push(obj);
			} else {
				mykeylist[index] = obj;
			}
		}

		function getkey() {
			// console.log("第" + order + "题，选" + mykey);
			if (mykeylist[order] != undefined) {
				let ss = mykeylist[order].value;
				for (var i = 0; i < ss.length; i++) {
					if (ss.indexOf("A") != -1) {
						$("#Acheck").attr("checked", true);
					}
					if (ss.indexOf("B") != -1) {
						$("#Bcheck").attr("checked", true);
					}
					if (ss.indexOf("C") != -1) {
						$("#Ccheck").attr("checked", true);
					}
					if (ss.indexOf("D") != -1) {
						$("#Dcheck").attr("checked", true);
					}
				}
			}
			console.log(mykeylist);
			keyjson = JSON.stringify(mykeylist);
			console.log(keyjson);
		}

		function submit() {
			$.ajax({
				type: "post",
				data: keyjson,
				contentType: 'application/json;charset=UTF-8',
				url: "exam/2",
				success: function(result) {
					$('#test_submit').dialog({
						title: '考试结束',
						width: 400,
						height: 200,
						closed: false,
						cache: false,
						modal: true,
						buttons: [{
							text: '关闭', ////对话框内容关闭
							handler: function() {
								$("#test_submit").dialog("close");
								window.location.href = "index.action";
							}
						}]
					});
				}
			})
		}

		function fortext() {
			for (var i = 0; i < 40; i++) {
				$("#text").append("<div>沉 着 冷 静 认 真 守 纪</div>");
			}
		}
	</script>
</html>
