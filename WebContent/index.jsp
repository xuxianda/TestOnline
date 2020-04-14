<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线考试网</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet" href="css/button.css">
		<script src="js/modernizr.custom.js"></script>
		<script src="js/button.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
		<style type="text/css">
			body {
				overflow-x: hidden;
				overflow-y: hidden;
			}

			#menu {
				position: relative;
				z-index: 10;
			}

			a {
				color: #000000;
			}

			.title {
				font-size: 65px;
			}

			.content {
				text-align: center;
			}

			.text {
				font-size: 20px;
				position: relative;
				top: 60px;
			}

			::-webkit-scrollbar {
				width: 5px;
				height: 5px;
			}

			::-webkit-scrollbar-track {
				-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
				border-radius: 4px;
				background-color: #FFFFFF;
			}

			::-webkit-scrollbar-thumb {
				border-radius: 5px;
				-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, .3);
				background-color: #000000;
			}
		</style>
	</head>
	<body class="easyui-layout" style="margin: 0px; padding: 0px;">
		<div data-options="region:'north',split:false" style="border: 0px;height:55px;<!-- overflow-x: hidden; overflow-y: hidden; -->">

		</div>

		<!-- 内容 -->
		<div data-options="region:'center',split:false" style="border: 0px; overflow-x: hidden;">
			<table border="0" id="tb1">
				<tr id="tr1">
					<td style="background-image: url(img/b5.jpg);">
						<div class="content">
							<font size="5"><b>exam online system for ZNSD</b></font><br>
							<span class="title">智能时代学院在线考试系统</span><br />
							<div style="display: inline-block; width: 50px"></div>

							<div class="wrapper">
								<button id="index_button1" class="loader-button" style="width: 300px; height: 65px;" onclick="goToLogin()">LOGIN</button>
							</div>

							<br /> <span class="text">
							智能、专业、简单的在线考试系统，适用于各种考试、练习、培训、竞赛、笔试及作业。
							</span>
						</div>
					</td>
				</tr>

				<tr id="tr2">
					<td style="background-image: url(img/b1.jpg);">
						<div class="content">
							<font size="5"> <b>We've been working hard</b><br></font> <span class="title">稳扎稳打</span><br /> 
							<span class="text">前端：jquery + easyui + html5</span><br><br>
							<span class="text">后端：spring + springmvc + nutzDao</span>
						</div>
					</td>
				</tr>
				<tr id="tr3">
					<td style="background-image: url(img/b4.jpg);">
						<div class="content">
							<font size="5"> <b>developer</b><br></font> <span class="title">开发人员</span><br /> <span class="text">18合一班第一组全员<br><br> 
								<span>项目建立日期2020年1月4日</span><br> <br> 
								<span>再接再厉，持之以恒</span></span><br> 
						</div> </span>
					</td>
				</tr>
			</table>

			<div>
				<table border="1" id="tb2" style="display: none; position: relative; top: 150px;">
					<tr>
						<td width="10%"></td>
						<td width="10%"></td>
						<td width="10%"><img src="img/user.png"></td>
						<td></td>
						<td style="text-align: start; line-height: 40px;">帐号:${user.uname}<br />
							姓名:${user.uname}<br /> 账号:${user.username}<br />
							性别:${user.gender}<br /> 积分:${user.integral}<br />
							权限:${user.rname}
						</td>
					</tr>
					<tr>
						<td width="10%">考试记录:</td>
						<td width="10%"></td>
						<td width="10%"></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>

			<div></div>
		</div>




		<!-- 顶部菜单 -->
		<div id="menu">
			<div class="index-nav">
				<div class="index-nav-frame clearfix">
					<div class="nav-line"></div>
					<div class="nav-small" tabindex="-1">
						<div class="nav-small-focus" tabindex="-1"></div>
						<img src="img/icon.png">
					</div>
					<div class="index-nav-frame-line active" tabindex="-1" style="position: absolute; left: 0px; bottom: 5px;">
						<img src="img/logo.png" onclick="index()">
					</div>
					<div class="index-nav-frame-line active" tabindex="-1">
						<a href="javascript:;" onclick="index()">首页</a>
						<div class="index-nav-frame-line-center">
							<div class="index-nav-frame-line-li">
								<a href="http://localhost:8080/TestOnline/#tr1">欢迎页</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="http://localhost:8080/TestOnline/#tr2">项目介绍</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="http://localhost:8080/TestOnline/#tr3">关于</a>
							</div>
						</div>
						<div class="index-nav-frame-line-focus" tabindex="-1"></div>
					</div>
					<div class="index-nav-frame-line" tabindex="-1">
						学习
						<div class="index-nav-frame-line-center">
							<div class="index-nav-frame-line-li">
								<a href="studyArea.action">资料</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="itemBank.action">题库</a>
							</div>
						</div>
						<div class="index-nav-frame-line-focus" tabindex="-1"></div>
					</div>
					<div class="index-nav-frame-line" tabindex="-1">
						考试
						<div class="index-nav-frame-line-center">
							<div class="index-nav-frame-line-li">
								<a href="testOnline.action">在线考试</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="examinationRecord.action">考试记录</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="examinationRank.action">考试排名</a>
							</div>
						</div>
						<div class="index-nav-frame-line-focus" tabindex="-1"></div>
					</div>
					<div class="index-nav-frame-line" tabindex="-1">
						新闻
						<div class="index-nav-frame-line-center">
							<div class="index-nav-frame-line-li">
								<a href="announcement.action">网站公告</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="examNrom.jsp">考试大纲</a>
							</div>
						</div>
						<div class="index-nav-frame-line-focus" tabindex="-1"></div>
					</div>
					<div class="index-nav-frame-line" tabindex="-1" style="position: absolute; right: 60px; top: 0px;">
						<span id="uname">请先登陆</span>
						<div class="index-nav-frame-line-center" id="usermanager">
							<div class="index-nav-frame-line-li">
								<a href="UserMyCenter.jsp" id="userInfo">个人主页</a>
							</div>
							<div class="index-nav-frame-line-li" id="admin" style="display: none;">
								<a href="admin.action#" id="admin">后台管理</a>
							</div>
							<div class="index-nav-frame-line-li">
								<a href="javascript:;" onclick="outLogin()">退出登陆</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="position: absolute; bottom: 0px; right: 0px;">
			<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=834290920&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:834290920:53"
				 alt="与我取得联系" title="与我取得联系" /></a>
		</div>
		<div id="outLogin_infor" style="display: none;">退出登陆成功！</div>
	</body>
</html>
</div>
<div data-options="region:'center',split:false" style="border: 0px; overflow: hidden;"></div>
</body>
<script type="application/javascript">
	$(function() {
		var screeheight = $(window).height();
		var screewidth = $(window).width();
		// console.log(screeheight + "/" + screewidth + "/");
		$("#tb1").width(screewidth);
		$("#tr1").height(screeheight);
		$("#tr2").height(screeheight);
		$("#tr3").height(screeheight);
		$("#tb2").width(screewidth);
	})

	function goToTestOnline() {
		window.location.href = "testOnline.action";
	}

	function userInfo() {
		$("#tb1").css("display", "none");
		$("#tb2").css("display", "block");
	}

	function index() {
		window.location.reload();
	}

	function goToLogin() {
		window.location.href = "login.action";
	}

	function outLogin() {
		$.ajax({
			type: "post",
			data: "outLogin",
			url: "user/out",
			success: function(result) {
				alert("退出登陆成功！");
				index();
			}
		})
	}

	var uname = '${user.uname}';
	var rname = '${user.rname}';

	if (uname == undefined || uname == null || uname == "") {
		$("#usermanager").css("display", "none");
		$("#uname").attr("onclick", "goToLogin()");
	} else {
		$("#uname").attr("onclick", "");
		$("#uname").text(uname);
		$("#index_button1").attr("onclick", "goToTestOnline()");
		$("#index_button1").text("TestOnline");
		console.log('${user}');
		if (rname == "管理员") {
			$("#admin").css("display", "block");
		}
	}
</script>
</html>
