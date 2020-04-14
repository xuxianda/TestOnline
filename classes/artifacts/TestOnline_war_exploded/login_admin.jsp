<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>欢迎登录后台管理系统</title>
		<link href="css/login2.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	</head>

	<body>
		<div class="main-login">

			<div class="login-content">
				<h2>管理员登录</h2>
				<div class="login-info">
					<span class="user">&nbsp;</span>
					<input name="username" id="username" type="text" value="" class="login-input" />
				</div>
				<div class="login-info">
					<span class="pwd">&nbsp;</span>
					<input name="password" id="password" type="password" value="" class="login-input" />
				</div>
				<div class="login-oper">
					<input style="margin:1px 10px 0px 2px; float:left;" name="" type="checkbox" value="" checked="checked" /><span>记住密码</span>
				</div>
				<div class="login-oper">
					<button name="" value="登 录" class="login-btn" onclick="login()">登 录</button>
					<button name="" value="重 置" class="login-reset">重 置</button>
				</div>
			</div>

		</div>
		<div id="login_error" style="display: none;font-size: 20px;text-align: center;">账号或密码错误，请检查后重新登录！</div>
		<div id="role_error" style="display: none;font-size: 20px;text-align: center;">没有权限，无法登录！</div>
	</body>
	<script type="application/javascript">
		var role;

		function login() {
			$.ajax({
				type: "post",
				url: "user/adminLogin",
				data: {
					username: $("#username").val(),
					password: $("#password").val()
				},
				success: function(result) {
					if (result.username != null || result.username != undefined || result.username == "") {
						if (result.rname == "管理员") {
							window.location.href = "admin.action";
						} else {
							$('#role_error').dialog({
								title: '权限错误',
								width: 400,
								height: 200,
								closed: false,
								cache: false,
								modal: true,
								buttons: [{
									text: '关闭', ////对话框内容关闭
									handler: function() {
										$("#role_error").dialog("close");
									}
								}]
							});
						}
					} else {
						$('#login_error').dialog({
							title: '账号或密码错误',
							width: 400,
							height: 200,
							closed: false,
							cache: false,
							modal: true,
							buttons: [{
								text: '关闭', ////对话框内容关闭
								handler: function() {
									$("#login_error").dialog("close");
								}
							}]
						});
					}
				},
				error: function(e) {
					console.log(e.status);
					console.log(e.responseText);
				}
			})
		}
	</script>
</html>
