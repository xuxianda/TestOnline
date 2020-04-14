<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>积分排名</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<style type="text/css">
		</style>
	</head>
	<body style="padding: 0;margin: 0;">
		<div id="utils" style="position: absolute;top: 0;z-index: 10;left: 100px;">
			<span>筛选:</span>
			<a id="a1" class="easyui-linkbutton">0-999</a>
			<a id="a2" class="easyui-linkbutton">1000-2999</a>
			<a id="a3" class="easyui-linkbutton">3000+</a>
		</div>
		<div>
			<table id="allIntegral" style="padding: 0;margin: 0;"></table>
		</div>

	</body>

	<script type="text/javascript">
		$('#a1').linkbutton({
			onClick: function() {
				$("#allIntegral").datagrid({
					url: "studentTest/firstIntegral",
					method: "get"
				})
			}
		});
		$('#a2').linkbutton({
			onClick: function() {
				$("#allIntegral").datagrid({
					url: "studentTest/secondIntegral",
					method: "get"
				})
			}
		});
		$('#a3').linkbutton({
			onClick: function() {
				$("#allIntegral").datagrid({
					url: "studentTest/lastIntegral",
					method: "get"
				})
			}
		});

		$('#allIntegral').datagrid({
			title: '积分排名',
			url: 'studentTest/findIntegral',
			method: 'get',
			pagination: true,
			pageSize: 10,
			singleSelect: true,
			pagination: true,
			columns: [
				[{
						field: 'username',
						title: '账号',
						width: 400,
						align: 'center'
					},
					{
						field: 'uname',
						title: '姓名',
						width: 400,
						align: 'center'
					},
					{
						field: 'integral',
						title: '编号',
						width: 400,
						align: 'center'
					}
				]
			]
		})
	</script>
</html>
