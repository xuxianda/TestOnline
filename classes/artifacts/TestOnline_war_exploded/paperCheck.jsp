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
				console.log(111);
			$("#tb").datagrid({
				title: '试卷审阅',
				url: 'paper/review',
				method: 'get',
				pagination: true,
				singleSelect:true,
				columns: [
					[{
						field: 'tid',
						title: '试卷编号',
						width: 100,
						align: 'center'
					}, {
						field: 'tname',
						title: '试卷名称',
						width: 250,
						align: 'center'
					}, {
						field: 'state',
						title: '试卷状态',
						width: 100,
						align: 'center'
					}, {
						field: 'tsum',
						title: '试卷总分',
						width: 100,
						align: 'center'
					}, {
						field: 'time',
						title: '考试时长',
						width: 100,
						align: 'center'
					}, {
						field: 'tdate',
						title: '生成时间',
						width: 250,
						align: 'center'
					},{
						field: 'sname',
						title: '科目',
						width: 100,
						align: 'center'
					},{
						field: 'uname',
						title: '出卷人',
						width: 150,
						align: 'center'
					},{
						field: 'cz',
						title: '操作',
						width: 150,
						align: 'center',
						formatter: function(value, row, index) {
							var bth = "<button onclick = 'editQuestion(" + index + ")'>过审</button>"
							return bth;
						}
					}]
				]
			});
		});
		
		function editQuestion(index)
		{
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			var tid = row.tid;
			
			console.log(tid);
			var r = confirm("确定要过审🐴");
			var index = 1;
			if (r == true)
			{
				$.ajax({
				   	type: "PATCH",
				   	url: "paper?index="+index+'&'+'tid='+tid,
				   	success: function(msg){
				   		if(msg==true){
				   			$('#tb').datagrid('reload'); 
				   			alert( "已过审" );
				   		}else{
				   			alert( "未过审" );
				   		}
				   	}
				});
			}
		}
		
	</script>
</html>
