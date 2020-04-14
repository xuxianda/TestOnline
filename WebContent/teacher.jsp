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
<link rel="stylesheet" type="text/css"
	href="easyui/themes/gray/easyui.css">
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
	<div id="cc" class="easyui-layout"
		style="width: 100%; height: 100%; border: 0;">
		<div data-options="region:'west',title:'',split:false"
			style="width: 264px;">
			<div id="menu">
				<!--隐藏菜单-->
				<div id="ensconce">
					<h2></h2>
				</div>
				<!--显示菜单-->
				<div id="open">
					<div class="navH">
						老师管理界面 <span><img class="obscure"></span>
					</div>
					<div class="navBox">
						<ul>
							<li>
								<h2 class="obtain">
									试卷管理<i></i>
								</h2>
								<div class="secondary">
									<h3>
										<a href="testpaperList.jsp" target="fm"
											url="testpaperList.jsp">试卷管理</a>
									</h3>
									<h3>
										<a href="javascript:;" target="fm" url="">试卷批阅</a>
									</h3>
									<h3>
										<a href="paperRank.jsp" target="fm" url="paperRank.jsp">试卷排名</a>
									</h3>
								</div>
							</li>
							<li>
								<h2 class="obtain">
									题库管理<i></i>
								</h2>
								<div class="secondary">
									<h3>
										<a href="questionsList.jsp" target="fm"
											url="questionsList.jsp">题库管理</a>
									</h3>
								</div>
							</li>
							<li>
								<h2 class="obtain">
									科目管理<i></i>
								</h2>
								<div class="secondary">
									<h3>
										<a href="subjectList.jsp" target="fm" url="subjectList.jsp">科目管理</a>
									</h3>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div data-options="region:'center',title:''"
			style="padding: 5px; background: #eee;">
			<div id="homePage" class="easyui-tabs" style="height: 100%;">
				<!-- 首页-->
				<div title="首页" id='bottom'>
					<iframe src="indexHome.jsp" width="100%" height="100%"
						style="border: 0;" scrolling="yes" id="fm" name="fm"
						frameborder="0"></iframe>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="application/javascript">
	
		$(function() {
			// $("a").click(tab(this));

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
								alert('refresh');
							}
						}]
					});
				}
			});


			function tab(node) {
				if ($('#homePage').tree('isLeaf', node.target)) { //判断是否是叶子节点
					if ($("#homePage").tabs("exists", node.text)) {
						$("#homePage").tabs("select", node.text);
					} else {
						$('#homePage').tabs('add', {
							title: node.text,
							content: "<iframe src=" + node.href + " style='width:100%;height:100%;border:0'></iframe>",
							closable: true,
							tools: [{
								iconCls: 'icon-mini-refresh',
								handler: function() {
									$('.panel:visible > .panel-body > iframe').get(0).contentDocument.location.reload(true);
								}
							}]
						});
					}
				}
			}
		});
	
</script>
</html>
