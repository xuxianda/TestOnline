<%@page import="com.online.domain.UserDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>考试系统登陆</title>
	</head>
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

	<!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
	<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!--jquery文件-->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<!--easyui核心文件-->
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<!--对应的语言包-->
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--皮肤文件-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<!--图标文件-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<!--初始化文件-->

	<style>
		/* Make the image fully responsive */
.carousel-inner img {
	height: 500px;
	text-align: center;
}

* {
	padding: 0;
	margin: 0;
}

#box {
	position: relative;
	width: 300px;
	height: 40px;
	margin: 0 auto;
	margin-top: 10px;
	background-color: #e8e8e8;
	box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
}

.bgColor {
	position: absolute;
	left: 0;
	top: 0;
	width: 40px;
	height: 40px;
	background-color: lightblue;
}

.txt {
	position: absolute;
	width: 100%;
	height: 40px;
	line-height: 40px;
	font-size: 14px;
	color: #000;
	text-align: center;
}

.slider {
	position: absolute;
	left: 0;
	top: 0;
	width: 50px;
	height: 38px;
	border: 1px solid #ccc;
	background: #fff;
	text-align: center;
	cursor: move;
}

.slider>i {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.slider.active>i {
	color: green;
}

body {
	width: 100%;
	height: 100vh;
	background-color: #000;
	background-image: radial-gradient(circle at top right, rgba(121, 68, 154, 0.13),
		transparent),
		radial-gradient(circle at 20% 80%, rgba(41, 196, 255, 0.13),
		transparent);
	overflow: hidden
}

canvas {
	position: fixed;
	width: 100%;
	height: 100%;
}

a {
	position: absolute;
	bottom: 2vmin;
	right: 2vmin;
	color: rgba(255, 255, 255, 0.2);
	text-decoration: none;
}

a:hover {
	color: #fff;
}
</style>
	<body style="margin: 0; padding: 0;">


		<canvas></canvas>



		<script>
			const STAR_COUNT = (window.innerWidth + window.innerHeight) / 8,
				STAR_SIZE = 3,
				STAR_MIN_SCALE = 0.2,
				OVERFLOW_THRESHOLD = 50;
		
			const canvas = document.querySelector('canvas'),
				context = canvas.getContext('2d');
		
			let scale = 1, // device pixel ratio
				width,
				height;
		
			let stars = [];
		
			let pointerX,
				pointerY;
		
			let velocity = {
				x: 0,
				y: 0,
				tx: 0,
				ty: 0,
				z: 0.0005
			};
		
			let touchInput = false;
		
			generate();
			resize();
			step();
		
			window.onresize = resize;
			canvas.onmousemove = onMouseMove;
			canvas.ontouchmove = onTouchMove;
			canvas.ontouchend = onMouseLeave;
			document.onmouseleave = onMouseLeave;
		
			function generate() {
		
				for (let i = 0; i < STAR_COUNT; i++) {
					stars.push({
						x: 0,
						y: 0,
						z: STAR_MIN_SCALE + Math.random() * (1 - STAR_MIN_SCALE)
					});
				}
		
			}
		
			function placeStar(star) {
		
				star.x = Math.random() * width;
				star.y = Math.random() * height;
		
			}
		
			function recycleStar(star) {
		
				let direction = 'z';
		
				let vx = Math.abs(velocity.x),
					vy = Math.abs(velocity.y);
		
				if (vx > 1 || vy > 1) {
					let axis;
		
					if (vx > vy) {
						axis = Math.random() < vx / (vx + vy) ? 'h' : 'v';
					} else {
						axis = Math.random() < vy / (vx + vy) ? 'v' : 'h';
					}
		
					if (axis === 'h') {
						direction = velocity.x > 0 ? 'l' : 'r';
					} else {
						direction = velocity.y > 0 ? 't' : 'b';
					}
				}
		
				star.z = STAR_MIN_SCALE + Math.random() * (1 - STAR_MIN_SCALE);
		
				if (direction === 'z') {
					star.z = 0.1;
					star.x = Math.random() * width;
					star.y = Math.random() * height;
				} else if (direction === 'l') {
					star.x = -OVERFLOW_THRESHOLD;
					star.y = height * Math.random();
				} else if (direction === 'r') {
					star.x = width + OVERFLOW_THRESHOLD;
					star.y = height * Math.random();
				} else if (direction === 't') {
					star.x = width * Math.random();
					star.y = -OVERFLOW_THRESHOLD;
				} else if (direction === 'b') {
					star.x = width * Math.random();
					star.y = height + OVERFLOW_THRESHOLD;
				}
		
			}
		
			function resize() {
		
				scale = window.devicePixelRatio || 1;
		
				width = window.innerWidth * scale;
				height = window.innerHeight * scale;
		
				canvas.width = width;
				canvas.height = height;
		
				stars.forEach(placeStar);
		
			}
		
			function step() {
		
				context.clearRect(0, 0, width, height);
		
				update();
				render();
		
				requestAnimationFrame(step);
		
			}
		
			function update() {
		
				velocity.tx *= 0.96;
				velocity.ty *= 0.96;
		
				velocity.x += (velocity.tx - velocity.x) * 0.8;
				velocity.y += (velocity.ty - velocity.y) * 0.8;
		
				stars.forEach((star) => {
		
					star.x += velocity.x * star.z;
					star.y += velocity.y * star.z;
		
					star.x += (star.x - width / 2) * velocity.z * star.z;
					star.y += (star.y - height / 2) * velocity.z * star.z;
					star.z += velocity.z;
		
					// recycle when out of bounds
					if (star.x < -OVERFLOW_THRESHOLD || star.x > width + OVERFLOW_THRESHOLD || star.y < -OVERFLOW_THRESHOLD || star.y >
						height + OVERFLOW_THRESHOLD) {
						recycleStar(star);
					}
		
				});
		
			}
		
			function render() {
		
				stars.forEach((star) => {
		
					context.beginPath();
					context.lineCap = 'round';
					context.lineWidth = STAR_SIZE * star.z * scale;
					context.strokeStyle = 'rgba(255,255,255,' + (0.5 + 0.5 * Math.random()) + ')';
		
					context.beginPath();
					context.moveTo(star.x, star.y);
		
					var tailX = velocity.x * 2,
						tailY = velocity.y * 2;
		
					// stroke() wont work on an invisible line
					if (Math.abs(tailX) < 0.1) tailX = 0.5;
					if (Math.abs(tailY) < 0.1) tailY = 0.5;
		
					context.lineTo(star.x + tailX, star.y + tailY);
		
					context.stroke();
		
				});
		
			}
		
			function movePointer(x, y) {
		
				if (typeof pointerX === 'number' && typeof pointerY === 'number') {
		
					let ox = x - pointerX,
						oy = y - pointerY;
		
					velocity.tx = velocity.tx + (ox / 8 * scale) * (touchInput ? 1 : -1);
					velocity.ty = velocity.ty + (oy / 8 * scale) * (touchInput ? 1 : -1);
		
				}
		
				pointerX = x;
				pointerY = y;
		
			}
		
			function onMouseMove(event) {
		
				touchInput = false;
		
				movePointer(event.clientX, event.clientY);
		
			}
		
			function onTouchMove(event) {
		
				touchInput = true;
		
				movePointer(event.touches[0].clientX, event.touches[0].clientY, true);
		
				event.preventDefault();
		
			}
		
			function onMouseLeave() {
		
				pointerX = null;
				pointerY = null;
		
			}
		</script>


		<div id="tabs" style="width: 100%;">

			<div id="demo" class="carousel slide" data-ride="carousel">

				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>

			</div>

			<div class="alert alert-danger alert-dismissible fade show" style="display: none;font-size:25px;" id="no">
				<button type="button" class="close" id="xx">&times;</button>
				<strong>错误!</strong> 账号或密码错误！也可能账号被停用。
			</div>
			<div id="div1" style="float: left; background-color: rgba(0, 0, 0, 0);">
				<div id="login ">
					<div id="login-tops" style="width: 100%;">
						<div id="cent" style="width: 100%;">
							<p class="text-muted" id="texthead" style="color: #FFFFFF;font-size:30px;width: 100%;">考试系统登录</p>
						</div>
					</div>
					<form method="post">
						<div id="login-divs">
							<div id="login_username">
								<span></span> <input type="text" id="username" name="userid" placeholder="输入账号" onblur="onname()" class="easyui-textbox"
								 style="width:300px; height: 40px; margin: 5px;" prompt="账号" />
							</div>
							<div id="login_password">
								<spa>
									</span> <input id="password" name="pwd" placeholder="输入密码" class="easyui-passwordbox" prompt="密码" iconWidth="28"
									 style="width:300px; height: 40px; margin-top: 20px;" />
							</div>
							<input id="login-submit" type="button" value="登陆" style="width:300px; height: 30px; margin: 20px 0px 2px 20px; background-color: limegreen; color: #FFFFFF; border: 0px;" />
							<input onclick="lor()" type="button" value="前去注册" style="width: 300px; height: 30px; margin: 20px 0px 2px 20px; background-color: orange; color: #FFFFFF; border: 0px;" />
						</div>
					</form>
				</div>
				<!-- 注册-->
				<div id="Re" style="display: none;">
					<!-- <div id="t-temp" style="color: #FFFFFF;width: 100%;position: relative;right: 40px;">前去登录</div> -->
					<div id="inputAccount">
						<input type="text" id="account" name="userid" placeholder="输入账号" class="easyui-textbox" style="width:300px; height: 40px; margin: 2px;"
						 prompt="账号" />
					</div>

					<div id="inputPassword">
						<input id="pwd" name="pwd" placeholder="输入密码" class="easyui-passwordbox" prompt="密码" iconWidth="28" style="width: 300px; height: 40px; margin-top: 2px;" />
					</div>

					<div id="inputUserName">
						<input type="text" id="uname" name="userid" placeholder="输入用户名" class="easyui-textbox" style="width: 300px; height: 40px; margin: 1px;"
						 prompt="名称" />
					</div>

					<div id="inputRadio" style="color: #FFFFFF;">
						<input type="radio" name="sex" value="男" />男 <input type="radio" name="sex" value="女" />女
					</div>
					<input id="zhuce-submit" type="button" value="注册" style="width: 300px; height: 30px; margin: 20px 0px 2px 20px; background-color: limegreen; color: #FFFFFF; border: 0px;" />
					<input onclick="lor()" type="button" value="前去登录" style="width: 300px; height: 30px; margin: 20px 0px 2px 20px; background-color: orange; color: #FFFFFF; border: 0px;" />
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$('#username').textbox({
			iconCls: 'icon-man',
			iconAlign: 'left'
		})
		var a = 1;
		//入口函数
		//登录/注册切换页面
		function lor() {
			if (a == 1) {
				$("#texthead").text("考试系统注册");
				$('#login-divs').hide();
				$('#Re').show();
				a++;
			} else {
				$("#texthead").text("考试系统登陆");
				$('#login-divs').show();
				$('#Re').hide();
				a--;
			}
		}
		$(function() {
			$("#xx").click(function() {
				$("#no").hide();
			});
			//登陆

			$('#login-submit').click(function() {
				var user_account = $('#username').val();
				var user_password = $('#password').val();
				if (user_account == "" || user_account == undefined) {
					alert("账号不能为空");
					return false;
				} else if (user_password == "" || user_password == undefined) {
					alert("请输入密码");
					return false;
				}
				$.ajax({
					url: 'user/login',
					type: 'post',
					data: {
						username: user_account,
						password: user_password
					},
					success: function(result) {
						if (result == true) {
							window.location.href = "index.action";
						} else {
							$("#no").show();
						}
					},
				})

			})

			//注册
			$('#zhuce-submit').click(function() {
				var account = $('#account').val();
				var pwd = $('#pwd').val();
				var uname = $('#uname').val();
				var inputRadio = $("input[name='sex']:checked").val();;
				if (uname == "" || uname == undefined) {
					alert("请输入姓名");
					return false;
				} else if (account == "" || account == undefined) {
					alert("请输入帐号");
					return false;
				} else if (pwd == "" || pwd == undefined) {
					alert("请输入密码");
					return false;
				} else if (uname.trim().length < 2 || uname.trim().length > 8) {
					alert("姓名长度为2~8");
					return false;
				} else if (account.trim().length < 6 || account.trim().length > 15) {
					alert("账号长度为6~15");
					return false;
				} else if ((pwd.length < 6 || pwd.length > 15) || (pwd.length < 6 || pwd.length > 15)) {
					alert("密码长度为6~15")
					return false;
				}
				$.ajax({
					url: 'user',
					type: 'post',
					data: {
						username: account,
						password: pwd,
						uname: uname,
						gender: inputRadio,
						type: 1
					},
					success: function(data) {
						//跳转的页面
						if (data == true) {
							alert("注册成功");
							window.location.href = "login.jsp";
						} else {
							alert("注册失败，账号可能冲突");
						}
					},
				})
			})
		})
	</script>
</html>
