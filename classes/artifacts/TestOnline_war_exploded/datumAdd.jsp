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
	</head>
	<body style="padding: 0;margin: 0;">
		<!-- 题目列表 -->
		<table id="tb" style="padding: 0;margin: 0;"></table>
		
		
		<!--添加题目-->
		<div id="add" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
				
				<div style="margin-bottom: 20px; ">
					<input id="addName" class="easyui-textbox" name="qname" data-options="label:'题目名称:',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px; ">
					<input id="addNeir" class="easyui-textbox" name="qname" data-options="label:'题目内容:',width:300,height:50">
				</div>
				资料类型：<select id="studyType" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="初级资料">初级资料</option>   
				    <option value="中级资料">中级资料</option>   
				    <option value="高级资料">高级资料</option>   
				</select>
		</div>
		
		
		<!-- 修改题目 -->
		<div id="content" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<form id="amendQuestion" >
				<input type="hidden" name="_method" value="post" />
				
				<div style="margin-bottom: 20px; ">
					<input id="qname" class="easyui-textbox" name="qname" data-options="label:'题目名称:',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px; ">
					<input id="neir" class="easyui-textbox" name="qname" data-options="label:'题目内容:',width:300,height:50">
				</div>
				资料类型：<select id="type" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="初级资料">初级资料</option>   
				    <option value="中级资料">中级资料</option>   
				    <option value="高级资料">高级资料</option>   
				</select>
			</form>
		</div>
		
		<div id="find" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<p><span>资料id：&emsp;</span><span id="id"></span></p>
			<p><span>资料标题：&emsp;</span><span id="name"></span></p>
			<p><span>内容：&emsp;</span><span id="contentaa"></span></p>
			<p><span>发布日期：&emsp;</span><span id="dataaa"></span></p>
			<p><span>资料类型：&emsp;</span><span id="cla"></span></p>
			<p><span>浏览次数：&emsp;</span><span id="views"></span></p>
			<p><span>资料状态：&emsp;</span><span id="stateaa"></span></p>
		</div>

		<div id="utils" style="position:absolute;top:5px;left:220px;font-size: 14px;">
		
		
		
			id：<input id="studyId" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 
			标题：<input id="studyTitle" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 
			<a id="search" class="easyui-linkbutton" >搜索</a>    
		</div>
	</body>
	<script type="text/javascript">
		$(function() {
			
			$('#search').linkbutton({ 
				onClick:function(){
					console.log("----");
					var sid=$("#studyId").val();
					var gid=$("#studyTitle").val();
					if(sid==""&&gid==""){
						sid=0;
						gid=0;
					}else if(sid==""&&gid!=""){
						sid=0;
					}else if(sid==""&&gid==""){
						sid=0;
						gid=0;
					}else if(sid!=""&&gid==""){
						gid=0;
					}
					 $("#tb").datagrid({
				    	url:"Datum/"+sid+"",
				    	method:"post",
				    	queryParams :{
				    		sid:sid,
				    		gid:gid
				    	}
				     })
				}
			});
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
							}else{
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
							var bth = "<button onclick = 'editQuestion(" + index + ")'>编辑</button><button onclick='findQuestion("+index+")'>查看</button>"
							return bth;
						}
					},]
				],
				toolbar:[{
					iconCls: 'icon-add',
					text:"添加",
					handler: function(){
						$('#add').dialog({
							title: '添加资料',
							width: 500,
							height: 700,
							closed: false,
							modal: true,
							buttons:[{
								text:'保存',
								handler:function(){
									var name=$("#addName").val();
									var content=$("#addNeir").val();
									var cla=$("#studyType").val();
									console.log(name+"-----------"+content+"-------------"+cla);
									//console.log(decodeURI($("#amendQuestion").serialize()));
									$.ajax({
										url:"Datum",
										type:"post",
										data:{
											name:name,
											content:content,
											cla:cla
										},
										success : function(result) {
											$.messager.progress('close'),
											$('#add').dialog("close");
											$("#tb").datagrid("reload");
											alert("增加成功");
											$('#tb').window('close'); 
										}
									})
								}
							},{
								text:'关闭',
								handler:function(){
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
		
		function editQuestion(index){
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			console.log(row);
			debugger
			if(row){
				$("#id").text(row.id);
				$("#name").text(row.name);
				$("#contentaa").text(row.content);
				$("#dataaa").text(row.date);
				$("#cla").text(row.cla);
				$("#views").text(row.views);
				$("#stateaa").text(row.state);
				$('#find').dialog({
					title: '查看资料',
					width: 500,
					height: 700,
					closed: false,
					modal: true,
					buttons:[{
						text:'关闭',
						handler:function(){
							$.messager.progress('close'),
							
							$("#tb").datagrid("reload");
							$('#tb').window('close');  
						}
					}]
				});
			}
		}
		 
		
		
		
		
		
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
							buttons:[{
								text:'保存',
								handler:function(){
									var name=$("#qname").val();
									var content=$("#neir").val();
									var cla=$("#type").val();
									console.log(name+"-----------"+content+"-------------"+cla);
									//console.log(decodeURI($("#amendQuestion").serialize()));
									debugger
									$.ajax({
										url:"Datum",
										type:"post",
										data:{
											_method:"PUT",
											id:row.id,
											name:name,
											content:content,
											cla:cla
										},
										success : function(result) {
											console.log(result)
											$.messager.progress('close'),
											$('#add').dialog("close");
											$("#tb").datagrid("reload");
											alert("保存成功");
										}
									})
								}
							},{
								text:'关闭',
								handler:function(){
									$.messager.progress('close'),
									$('#add').dialog("close");
									$("#tb").datagrid("reload");
								}
							}]
						});
				}
			}
	</script>
</html>
