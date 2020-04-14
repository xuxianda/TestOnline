<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>科目管理</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
	</head>
	<body style="margin: 0;padding: 0;">
		<!--添加科目-->
		<div id="add" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<div style="margin-bottom: 20px; ">
				科目名称：&emsp;<input id="addUserName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
			</div>
		</div>


		<!-- 修改题目 -->
		<div id="content" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<form id="amendQuestion">
				<div style="margin-bottom: 20px; ">
					新科目名称：&emsp;<input id="updateUserName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
				</div>
			</form>
		</div>
		<table id="tb"></table>
		<div id="win"></div>
	</body>
	<script type="text/javascript">
		$(function() {
			$("#tb").datagrid({
				title: '科目列表',
				url: 'subject',
				method: 'get',
				pagination: true,
				singleSelect: true,
				fit: true,
				columns: [
					[{
						field: 'sid',
						title: '科目编号',
						width: 300,
						align: 'center'
					}, {
						field: 'sname',
						title: '科目名称',
						width: 300,
						align: 'center'
					}, {
						field: 'cz',
						title: '操作',
						width: 300,
						align: 'center',
						formatter: function(value, row, index) {
							var bth = "<button onclick = 'editQuestion(" + index + ")'>修改</button>"
							return bth;
						}
					}]
				],
				toolbar: [{
					iconCls: 'icon-add',
					text: "添加",
					handler: function() {
						$('#add').dialog({
							title: '添加用户',
							width: 500,
							height: 700,
							closed: false,
							modal: true,
							buttons: [{
								text: '保存',
								handler: function() {
									var username = $("#addUserName").val();
									$.ajax({
										url: "subject",
										type: "post",
										data: {
											sname: username,
										},
										success: function(result) {
											$.messager.progress('close'),
												$('#add').dialog("close");
											$("#tb").datagrid("reload");
											if (result == true) {
												alert("增加成功");
											} else {
												alert("增加失败");
											}
											$('#tb').window('close');
										}
									})
								}
							}, {
								text: '关闭',
								handler: function() {
									$.messager.progress('close'),
										$('#add').dialog("close");
									$("#tb").datagrid("reload");
								}
							}]
						});
					}
				}]
			});
		});

		function editQuestion(index) {
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			console.log(row);
			if (row) {
				$('#content').dialog({
					title: '编辑资料',
					width: 500,
					height: 700,
					closed: false,
					modal: true,
					buttons: [{
						text: '保存',
						handler: function() {
							var username = $("#updateUserName").val();
							$.ajax({
								url: "subject/up",
								type: "post",
								data: {
									sid: row.sid,
									sname: username,
								},
								success: function(result) {
									$.messager.progress('close'),
										$('#content').dialog("close");
									$("#tb").datagrid("reload");
									if (result == true) {
										alert("保存成功");
									} else {
										alert("保存失败");
									}
									$('#tb').window('close');
								}
							})
						}
					}, {
						text: '关闭',
						handler: function() {
							$.messager.progress('close'),
								$('#content').dialog("close");
							$("#tb").datagrid("reload");
						}
					}]
				});
			}
		}
	</script>
</html>
