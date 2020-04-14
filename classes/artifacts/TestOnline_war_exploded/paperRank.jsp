<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>试卷列表</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<style type="text/css">
			#box1 {
				position: absolute;

			}
		</style>
	</head>
	<body style="padding: 0;margin: 0;">
		<div id="d1" style="position: absolute;z-index: 10;left: 200px;top: 1px;">
			试卷：<input id="tname" class="easyui-textbox">
			<a id="search" class="easyui-linkbutton">搜索</a>
		</div>
		<div id="d2" style="display:none;position: absolute;z-index: 10;left: 200px;top: 1px;">
			<a id="return" class="easyui-linkbutton">返回</a>
		</div>
		<!-- 试卷排名 -->
		<div id="allP" style="display:block">
			<table id="allPaper" style="padding: 0;margin: 0;"></table>
		</div>
		<div id="allStu" style="display:none">
			<table id="allStudent" style="padding: 0;margin: 0;" class="easyui-datagrid"></table>
		</div>

	</body>

	<script type="text/javascript">
		$('#search').linkbutton({
			onClick: function() {
				var tname = $("#tname").textbox("getText");
				if (tname == "") {
					tname = "";
				}
				$("#allPaper").datagrid({
					url: "studentTest/testName",
					method: "get",
					queryParams: {
						tname: tname
					}
				})
			}
		});
		$('#return').linkbutton({
			onClick: function() {
				$("#allP").css("display", "block");
				$("#allStu").css("display", "none");
				$("#d1").css("display", "block")
				$("#d2").css("display", "none")
			}
		});

		$('#allPaper').datagrid({
			title: '试卷列表',
			url: 'studentTest/allTest',
			method: 'get',
			pageSize: 10,
			singleSelect: true,
			pagination: true,
			columns: [
				[{
					field: 'tid',
					title: '编号',
					width: 100,
					align: 'center'
				}, {
					field: 'tname',
					title: '试卷名称',
					width: 250,
					align: 'center',
					formatter: function(value, row, index) {
						bth = "<a style='color:blue;text-decoration: none' onClick='searchStudent(" + index + ")'>" + row.tname +
							"</a>"
						return bth;
					}
				}, {
					field: 'sname',
					title: '试卷科目',
					width: 140,
					align: 'center'
				}, {
					field: 'gname',
					title: '试卷等级',
					width: 140,
					align: 'center'
				}, {
					field: 'tsum',
					title: '试卷总分',
					width: 140,
					align: 'center'
				}, {
					field: 'time',
					title: '考试时长',
					width: 140,
					align: 'center'
				}, {
					field: 'tdate',
					title: '出卷日期',
					width: 300,
					align: 'center'
				}]
			]
		});

		function searchStudent(index) {
			$('#allPaper').datagrid('selectRow', index); // 关键在这里  
			var row = $('#allPaper').datagrid('getSelected');
			console.log(row.tid);
			if (row) {
				$("#allP").css("display", "none");
				$("#allStu").css("display", "block");
				$("#d1").css("display", "none")
				$("#d2").css("display", "block")
				$('#allStudent').datagrid({
					title: row.tname,
					url: 'studentTest/findStudent2',
					method: 'get',
					queryParams: {
						tid: row.tid
					},
					close: false,
					pagination: true,
					pageSize: 10,
					singleSelect: true,
					pagination: true,
					pagePosition: "bottom",
					columns: [
						[{
							field: 'username',
							title: '账号',
							width: 220,
							align: 'center'
						}, {
							field: 'uname',
							title: '姓名',
							width: 220,
							align: 'center'
						}, {
							field: 'gender',
							title: '性别',
							width: 150,
							align: 'center'
						}, {
							field: 'score',
							title: '分数',
							width: 150,
							align: 'center'
						}, {
							field: 'rank',
							title: '排名',
							width: 150,
							align: 'center'
						}, {
							field: 'date',
							title: '考试时间',
							width: 300,
							align: 'center'
						}]
					]
				})
			}
		}
	</script>
</html>
