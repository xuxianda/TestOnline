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
	</body>
	<script type="text/javascript">
		$(function() {
			$("#tb").datagrid({
				title: '用户列表',
				url: 'user',
				method: 'get',
				pagination: true,
				pageSize:10,
				fit:true,
				columns: [
					[{
						field: 'uid',
						title: '用户编号',
						width: 100,
						align: 'center'
					}, {
						field: 'username',
						title: '帐号',
						width: 300,
						align: 'center'
					}, {
						field: 'password',
						title: '密码',
						width: 300,
						align: 'center'
					}, {
						field: 'uname',
						title: '姓名',
						width: 200,
						align: 'center'
					}, {
						field: 'gender',
						title: '性别',
						width: 150,
						align: 'center'
					}, {
						field: 'integral',
						title: '积分',
						width: 200,
						align: 'center'
					}, {
						field: 'state',
						title: '状态',
						width: 150,
						align: 'center'
					}, {
						field: 'rid',
						title: '角色编号',
						width: 100,
						align: 'center'
					}, {
						field: 'rname',
						title: '角色名称',
						width: 200,
						align: 'center'
					}]
				]
			});
		});
	</script>
</html>
