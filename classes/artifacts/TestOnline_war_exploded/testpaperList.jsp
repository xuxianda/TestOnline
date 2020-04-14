<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>这里是试卷管理</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">

<link href="css/te.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>		
	</head>
	<body style="margin: 0;padding: 0;">
	
	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input type="text" id="tvalue" name="tvalue"
				class="form-control"></td>
			<td><input class="btn btn-default" type="button" id="tname"
				value="试卷名称查询" ></td>
		</tr>
	</table>
	
	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input type="text" id="pvalue" name="pvalue"
				class="form-control"></td>
			<td><input class="btn btn-default" type="button" id="type"
				value="试卷科目查询" ></td>
		</tr>
	</table>
	
	
		<table id="tb"></table>
		
	</body>
	<script type="text/javascript">
		$(function() {
			$("#tb").datagrid({
				title: '试卷列表',
				url: 'paper/all',
				method: 'get',
				pagination: true,
				columns: [
					[{
							field: 'tid',
							title: '试卷编号',
							width: 80,
							align: 'center'
						},
						{
							field: 'tname',
							title: '试卷名称',
							width: 270,
							align: 'center'
						},
						{
							field: 'sname',
							title: '科目',
							width: 80,
							align: 'center'
						},
						{
							field: 'tsum',
							title: '试卷总分',
							width: 100,
							align: 'center'
						},
						{
							field: 'time',
							title: '考试时间',
							width: 100,
							align: 'center'
						},
						{
							field: 'tdate',
							title: '创建日期',
							width: 250,
							align: 'center'
						},
						{
							field: 'qsname',
							title: '试卷状态',
							width: 100,
							align: 'center'
						},
						{
							field: 'uname',
							title: '出卷人',
							width: 100,
							align: 'center'
						}, {
							field: 'cz1',
							title: '修改',
							width: 100,
							align: 'center',
							formatter: function(value, row, index) {
								var bth = "<button onclick = 'editQuestion(" + index + ")'>编辑</button>"
								return bth;
							}
						}, {
							field: 'cz3',
							title: '使用',
							width: 100,
							align: 'center',
							formatter: function(value, row, index) {
								var bth;
								if (row.state == -1) {
									bth = "<button onclick = 'employ(" + index + ")'>启用</button>"
								}
								if (row.state == 1) {
									bth = "<button onclick = 'employ(" + index + ")'>禁用</button>"
								}
								if (row.state == 0) {
									bth = "<button onclick = 'employ(" + index + ")'>待审核</button>"
								}
								return bth;
							}
						}
					]
				]
			});
		});
		
		function editQuestion(index){
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			var tid = row.tid;
			var tname = row.tname;
			var time = row.time;
			var sid = row.sid;
			
			<%%>
			
			console.log(tname);
			console.log(time);
			
			if (row.state == 1) {
				
				alert("已审核的试卷无法修改");
				
			}else if(row.state == -1){
				
				alert("已禁用的试卷无法修改");
				
			}else{
				 //将获取到的courseid传入到session
			    sessionStorage.setItem("tname",row.tname);
			    sessionStorage.setItem("time",row.time);
			    sessionStorage.setItem("tid",row.tid);
			    sessionStorage.setItem("sid",row.sid);
			    
			    //跳转到修改页面
				window.location.href="${sessionScope.path}/TestOnline/updatePaper.jsp";
				
			}
		}
		
		// 启用/禁用
		function employ(index)
		{
			$('#tb').datagrid('selectRow', index);
			var row = $('#tb').datagrid('getSelected');
			var qsname = row.qsname;
			var tid = row.tid;
			if (row.state == 1) {
				
				var r = confirm(" 确定要禁用吗----🐴");
				if (r) {
					$.ajax({
						url:'paper?tid='+tid,
						type:'DELETE',
						success: function(msg){
					   		if(msg==true){
					   			$('#tb').datagrid('reload'); 
					   			alert( "已禁用" );
					   			
					   		}else{
					   			alert( "禁用失败" );
					   		}
					   	}
					})
				}
				
			}else if(row.state == -1){
				
				var r = confirm(" 确定要启用吗----🐴");
				if (r) {
					var index = 2; 
					$.ajax({
						url:'paper?tid='+tid+'&'+'index='+index,
						type:'PATCH',
						success: function(msg){
					   		if(msg==true){
					   			$('#tb').datagrid('reload'); 
					   			alert( "已启用" );
					   			
					   		}else{
					   			alert( "启用失败" );
					   		}
					   	}
					})
				}
			}
		}
		
		/* 试卷名查询模糊查询 */
		document.getElementById("tname").onclick = function(){
			var index = 1;
			var name = $("#tvalue").val();
			
			$("#tb").datagrid({
				url:'paper',
				type:'get',
				pagination: true,
				queryParams:{
					index:index,
					name:name
				}
			});
			
			alert("---"+name);
		};
		
		/* 科目名查询试卷 */
		document.getElementById("type").onclick = function(){
			
			var index = 2;
			var name = $("#pvalue").val();
			
			$("#tb").datagrid({
				url:'paper',
				type:'get',
				pagination: true,
				queryParams:{
					index:index,
					name:name
				}
			});
			alert("---"+name);
		};
		
		
		
		
		
		
		
		
	</script>
</html>
