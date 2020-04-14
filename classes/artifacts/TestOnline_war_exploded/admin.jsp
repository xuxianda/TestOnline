<%@page import="com.online.domain.UserDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台管理</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script src="js/menu.js"></script>
		<script src="js/adapter.js"></script>
		<link rel="stylesheet" href="css/base.css">
		<link rel="stylesheet" href="css/menu.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<style>
			a {
	color: #FFFFFF;
}

a:visited {
	font-size: 12px;
	color: #FFFFFF;
	text-decoration: none;
}

a:hover {
	font-size: 18px;
	color: #FFFFFF text-decoration: none;
}
</style>
	</head>
	<body style="margin: 0px; padding: 0px;">
		<div id="cc" class="easyui-layout" style="width: 100%; height: 100%; border: 0;">
			<div data-options="region:'west',title:'',split:false" style="width: 264px;">
				<div id="menu">
					<!--隐藏菜单-->
					<div id="ensconce">
						<h2></h2>
					</div>
					<!--显示菜单-->
					<div id="open">
						<div class="navH">
							<a href="index.jsp">返回前台</a> <span><img class="obscure"></span>
						</div>
						<div class="navBox">
							<ul>
								<li>
									<h2 class="obtain">
										用户管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="userList.jsp">用户管理</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="userCheck.jsp">用户审核</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="integralRank.jsp">积分排名</a>
										</h3>
									</div>
								</li>
								<li>
									<h2 class="obtain">
										试卷管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="testpaperList.jsp">试卷管理</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="paperAdd.jsp">试卷增加</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="paperCheck.jsp">试卷审核</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="testGrade.jsp">试卷批阅</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="paperRank.jsp">试卷排名</a>
										</h3>
									</div>
								</li>
								<li>
									<h2 class="obtain">
										题库管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="questionsList.jsp">题库管理</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="subjectAudit.jsp">题目审核</a>
										</h3>
									</div>
								</li>
								<li>
									<h2 class="obtain">
										科目管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="subjectList.jsp">科目管理</a>
										</h3>
									</div>
								</li>
								<li>
									<h2 class="obtain">
										系统管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="systemLog.jsp">系统日志</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="about.jsp">关于</a>
										</h3>
									</div>
								</li>
								<li>
									<h2 class="obtain">
										学习区管理<i></i>
									</h2>
									<div class="secondary">
										<h3>
											<a href="#" target="fm" url="datumAdd.jsp">资料管理</a>
										</h3>
										<h3>
											<a href="#" target="fm" url="studyAudit.jsp">资料审核</a>
										</h3>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>


			<div data-options="region:'center',title:''" style="padding: 5px; background: #eee;">
				<div id="homePage" class="easyui-tabs" style="height: 100%;">
					<!-- 首页-->


				</div>
			</div>
		</div>
		<div id="role_error" style="display: none;font-size: 20px;text-align: center;">没有访问后台的权限！</div>

	</body>
	<script type="application/javascript">
		var rname = '${user.rname}';
		if (rname != "管理员") {
			$('#role_error').dialog({
				title: '错误',
				width: 400,
				height: 200,
				closed: false,
				cache: false,
				modal: true,
				buttons: [{
					text: '关闭', ////对话框内容关闭
					handler: function() {
						$("#role_error").dialog("close");
						window.location.href = "index.action";
					}
				}]
			});
		}
		$(function() {
			$('#homePage').tabs('add', {
				title: "首页",
				content: "<iframe src='indexHome.jsp' style='width:100%;height:100%;scrolling : no'></iframe>",
				closable: false,
				tools: [{
					iconCls: 'icon-mini-refresh',
					handler: function() {
						$('.panel:visible > .panel-body > iframe').get(0).contentDocument.location.reload(true);
					}
				}]
			});

			$("a").click(function(node) {
				console.log(node.target.attributes[2].nodeValue);
				console.log(node.target.innerText);
				console.log(node.target.baseURI);
				if ($("#homePage").tabs("exists", node.target.innerText)) {
					$("#homePage").tabs("select", node.target.innerText);
				} else {
					$('#homePage').tabs('add', {
						title: node.target.innerText,
						content: "<iframe src='" + node.target.attributes[2].nodeValue +
							"' style='width:100%;height:100%;scrolling : no'></iframe>",
						closable: true,
						tools: [{
							iconCls: 'icon-mini-refresh',
							handler: function() {
								$('.panel:visible > .panel-body > iframe').get(0).contentDocument.location.reload(true);
							}
						}]
					});
				}
			});
		});
	</script>
</html>
