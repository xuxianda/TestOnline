<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
	</head>
	<body style="margin: 0;padding: 0;">
		<table id="tb"></table>
		<div id="win"></div>
	</body>
	<script type="text/javascript">
		$(function() {
			$("#tb").datagrid({
				title: '用户列表',
				url: 'user/no',
				method: 'get',
				pagination: true,
				fit: true,
				singleSelect: true,
				columns: [
					[{
						field: 'uid',
						title: '用户编号',
						width: 100,
						align: 'center'
					}, {
						field: 'username',
						title: '帐号',
						width: 200,
						align: 'center'
					}, {
						field: 'password',
						title: '密码',
						width: 200,
						align: 'center'
					}, {
						field: 'uname',
						title: '姓名',
						width: 150,
						align: 'center'
					}, {
						field: 'gender',
						title: '性别',
						width: 50,
						align: 'center'
					}, {
						field: 'integral',
						title: '积分',
						width: 150,
						align: 'center'
					}, {
						field: 'state',
						title: '状态',
						width: 100,
						align: 'center'
					}, {
						field: 'rid',
						title: '角色编号',
						width: 150,
						align: 'center'
					}, {
						field: 'rname',
						title: '角色名称',
						width: 100,
						align: 'center'
					}, {
						field: 'cz',
						title: '操作',
						width: 200,
						align: 'center',
						formatter: function(value, row, index) {
							var bth = "<button onclick = 'editQuestion(" + index + ")'>过审</button>"
							return bth;
						}
					}]
				]
			});
		});

		function editQuestion(index) {
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			var username = row.username;
			var r = confirm("确定要过审🐴");
			if (r == true) {
				$.ajax({
					type: "post",
					url: "user/check?username=" + row.username,
					data: "username = " + row.username,
					success: function(msg) {
						if (msg == true) {
							$('#tb').datagrid('reload');
							alert("已过审");
						} else {
							alert("未过审");
						}
					}
				});
			}
		}
	</script>
</html>
