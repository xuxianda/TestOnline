<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>题目列表</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<style type="text/css">
		</style>
	</head>
	<body style="padding: 0;margin: 0;">

		<div id="utils" style="z-index: 100;position: absolute;left:8%;">
			<span style="position: relative;top: 2px;font-size: 15px;">筛选:</span>
			<a id="all" class="easyui-linkbutton">全部</a>
			<a id="yes" class="easyui-linkbutton">已审核</a>
			<a id="no" class="easyui-linkbutton">未审核</a>
			<a id="stop" class="easyui-linkbutton">已禁用</a>
		</div>
		<!-- 题目列表 -->
		<table id="sa" style="padding: 0;margin: 0;"></table>


	</body>
	<script type="text/javascript">
		$(function() {

			$('#all').linkbutton({
				onClick: function() {
					$("#sa").datagrid({
						url: "requestion",
						method: "get"
					})
				}
			});
			$('#yes').linkbutton({
				onClick: function() {
					$("#sa").datagrid({
						url: "requestion/getYes",
						method: "get"
					})
				}
			});
			$('#no').linkbutton({
				onClick: function() {
					$("#sa").datagrid({
						url: "requestion/getNo",
						method: "get"
					})
				}
			});
			$('#stop').linkbutton({
				onClick: function() {
					$("#sa").datagrid({
						url: "requestion/getStop",
						method: "get"
					})
				}
			});


			$("#sa").datagrid({
				title: '题目列表',
				url: 'requestion',
				method: 'get',
				pagination: true,
				pageSize: 10,
				singleSelect: true,
				pagination: true,
				fit:true,
				pagePosition: "bottom",
				columns: [
					[{
						field: 'qid',
						title: '编号',
						width: 50,
						align: 'center'
					}, {
						field: 'sname',
						title: '科目',
						width: 70,
						align: 'center'
					}, {
						field: 'tyname',
						title: '类型',
						width: 70,
						align: 'center'
					}, {
						field: 'gname',
						title: '等级',
						width: 70,
						align: 'center'
					}, {
						field: 'qname',
						title: '题目内容',
						width: 130,
						align: 'center'
					}, {
						field: 'a',
						title: 'A',
						width: 70,
						align: 'center'
					}, {
						field: 'b',
						title: 'B',
						width: 70,
						align: 'center'
					}, {
						field: 'c',
						title: 'C',
						width: 70,
						align: 'center'
					}, {
						field: 'd',
						title: 'D',
						width: 70,
						align: 'center'
					}, {
						field: 'qkey',
						title: '正确答案',
						width: 70,
						align: 'center'
					}, {
						field: 'score',
						title: '分数',
						width: 70,
						align: 'center'
					}, {
						field: 'username',
						title: '出题人',
						width: 100,
						align: 'center'
					}, {
						field: 'qdate',
						title: '出题日期',
						width: 150,
						align: 'center'
					}, {
						field: 'qsname',
						title: '状态',
						width: 70,
						align: 'center'
					}, {
						field: 'cz',
						title: '操作',
						width: 100,
						align: 'center',
						formatter: function(value, row, index) {
							var bth;
							if (row.qstate == -1) {
								bth = "<button onclick = 'openQuestion(" + index + ")'>启用</button>"
							}
							if (row.qstate == 0) {
								bth = "<button onclick = 'yesQuestion(" + index + ")'>审核</button>"
							}
							if (row.qstate == 1) {
								bth = "<button onclick = 'stopQuestion(" + index + ")'>禁用</button>"
							}
							return bth;
						}
					}, ]
				],
			})
		});

		function openQuestion(index) {
			$('#sa').datagrid('selectRow', index); // 关键在这里  
			var row = $('#sa').datagrid('getSelected');
			console.log(row);
			if (row) {
				var is = confirm("您确定要启用嘛？");
				if (is) {
					$.ajax({
						url: "requestion/updateYesState",
						type: "post",
						data: {
							_method: "put",
							qid: row.qid
						},
						success: function(result) {
							alert(result);
							$("#sa").datagrid("reload");
						}
					})
				}
			}

		}

		function yesQuestion(index) {
			$('#sa').datagrid('selectRow', index); // 关键在这里  
			var row = $('#sa').datagrid('getSelected');
			console.log(row);
			if (row) {
				var is = confirm("您确定要审核通过嘛？");
				if (is) {
					$.ajax({
						url: "requestion/updateYesState",
						type: "post",
						data: {
							_method: "put",
							qid: row.qid
						},
						success: function(result) {
							alert(result);
							$("#sa").datagrid("reload");
						}
					})
				}
			}
		}

		function stopQuestion(index) {
			$('#sa').datagrid('selectRow', index); // 关键在这里  
			var row = $('#sa').datagrid('getSelected');
			console.log(row);
			if (row) {
				var is = confirm("您确定要禁用嘛？");
				if (is) {
					$.ajax({
						url: "requestion/updateStopState",
						type: "post",
						data: {
							_method: "put",
							qid: row.qid
						},
						success: function(result) {
							alert(result);
							$("#sa").datagrid("reload");
						}
					})
				}
			}

		}
	</script>
</html>
