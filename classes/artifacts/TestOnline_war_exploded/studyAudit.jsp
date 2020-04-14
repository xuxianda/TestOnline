<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
<body>
	<table id="tb" style="padding: 0;margin: 0;"></table>
	<script type="text/javascript">
	$("#tb").datagrid({
		title: '资料列表',
		url: 'Datum',
		method: 'get',
		pagination: true,
		pageSize:10,
		singleSelect:true,
		pagination : true,
		fit:true,
		pagePosition:"bottom",
		type:"number",
		columns: [
			[{
				field: 'id',
				title: '编号',
				width: 50,
				align: 'center'
			}, {
				field: 'name',
				title: '标题',
				width: 200,
				align: 'center'
			}, {
				field: 'content',
				title: '内容',
				width: 400,
				align: 'center'
			},{
				field: 'data',
				title: '发布日期',
				width: 100,
				align: 'center'
			}, {
				field: 'cla',
				title: '资料类型',
				width:150,
				align: 'center'
			}, {
				field: 'views',
				title: '浏览次数',
				width: 70,
				align: 'center'
				
			}, {
				field: 'state',
				title: '资料状态(0为审核,1为展示)',
				width: 70,
				align: 'center',
				formatter: function(value, row, index) {
					console.log(value+""+ row+""+ index);
					var bth
					if(row.state==0){
						bth = "未审核";
					}else if(row.state==1){
						bth="已审核";
					}else if(row.state==-1){
						bth="已禁用";
					}
					return bth;
				}
			}, {
				field: 'cz',
				title: '操作',
				width: 120,
				align: 'center',
				formatter: function(value, row, index) {
					console.log(value+""+ row+""+ index);
					if(row.state==0){
						var bth = "<button onclick = 'editQuestion(" + index + ")'>审核</button>"
					}else if(row.state==1){
						var bth = "<button onclick = 'stopQuestion(" + index + ")'>禁用</button>"
					}else{
						var bth = "<button onclick = 'openQuestion(" + index + ")'>启用</button>"
					}
					return bth;
				}
			},]
		]
	});
	function openQuestion(index){
		$('#tb').datagrid('selectRow', index); // 关键在这里  
		var row = $('#tb').datagrid('getSelected');
		$.ajax({
			url:"Datum/start",
			data:{
				id:row.id
			},
			success:function(){
				$.messager.progress('close'),
				$('#add').dialog("close");
				$("#tb").datagrid("reload");
				alert("启用成功");
			}
			
		})
	}
	
	function stopQuestion(index){
		$('#tb').datagrid('selectRow', index); // 关键在这里  
		var row = $('#tb').datagrid('getSelected');
		console.log(row);
		$.ajax({
			url:"Datum?id="+row.id,
			type:"DELETE",
			success:function(){
				$.messager.progress('close'),
				$('#add').dialog("close");
				$("#tb").datagrid("reload");
				alert("禁用成功");
			}
			
		})
	}
	
	function editQuestion(index){
		$('#tb').datagrid('selectRow', index); // 关键在这里  
		var row = $('#tb').datagrid('getSelected');
		$.ajax({
			url:"Datum/start",
			data:{
				id:row.id
			},
			success:function(){
				$.messager.progress('close'),
				$('#add').dialog("close");
				$("#tb").datagrid("reload");
				alert("审核成功");
			}
			
		})
	}
	</script>
</body>
</html>