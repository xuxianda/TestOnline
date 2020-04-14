<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统日志</title>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
</head>
<body style="padding: 0;margin: 0;">
		<!-- 系统日志列表 -->
		<table id="sysLog" style="padding: 0;margin: 0;"></table>
</body>

	<script type="text/javascript">
	$('#sysLog').datagrid({
		title: '日志列表',
		url: 'log',
		method: 'get',
		pageSize: 10,
		singleSelect: true,
		pagination: true,
		fit:true,
		columns: [
			[{
				field: 'lid',
				title: '日志编号',
				width: 100,
				align: 'center'
			},
			{
				field: 'username',
				title: '用户名',
				width: 200,
				align: 'center'
			},{
				field: 'operation',
				title: '操作',
				width: 250,
				align: 'center'
			},
			{
				field: 'method',
				title: '方法',
				width: 150,
				align: 'center'
			},{
				field: 'params',
				title: '参数',
				width: 150,
				align: 'center'
			},{
				field: 'ip',
				title: 'IP',
				width: 150,
				align: 'center'
			},{
				field: 'createDate',
				title: '操作日期',
				width: 200,
				align: 'center'
			}]
		]
	});
	</script>
	
</html>