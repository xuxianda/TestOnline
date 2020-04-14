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
		
		
		<!--添加用户-->
		<div id="add" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
				
				<div style="margin-bottom: 20px; ">
					用户名：&emsp;<input id="addUserName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px; ">
 					用户密码：<input id="addPwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true" /><br> <br> 
					确认密码：<input id="addRpwd" name="rpwd" type="password" class="easyui-validatebox"     
    				required="required" validType="equals['#pwd']" />  
				</div>
				<div style="margin-bottom: 20px; ">
					姓名：&emsp;&emsp;<input id="addName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
				</div>
				性别：&emsp;&emsp;<select id="addSex" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="男">男</option>   
				    <option value="女">女</option>   
				</select>
				<br>
				<br>
				权限：&emsp;&emsp;<select id="addRole" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="1">学生</option>   
				    <option value="2">老师</option>   
				    <option value="3">管理员</option>   
				</select>
		</div>
		
		
		<!-- 修改题目 -->
		<div id="content" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<form id="amendQuestion" >
				<div style="margin-bottom: 20px; ">
					用户名：&emsp;<input id="updateUserName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px; ">
 					用户密码：<input id="updatePwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true" /><br> <br> 
					
				</div>
				<div style="margin-bottom: 20px; ">
					姓名：&emsp;&emsp;<input id="updateName" class="easyui-validatebox" name="qname" data-options="label:'',width:300,height:50">
				</div>
				性别：&emsp;&emsp;<select id="updateSex" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="男">男</option>   
				    <option value="女">女</option>   
				</select>
				<br>
				<br>
				权限：&emsp;&emsp;<select id="updateRole" class="easyui-combobox" name="dept" title="" style="width:200px;">   
				    <option value="1">学生</option>   
				    <option value="2">老师</option>   
				    <option value="3">管理员</option>   
				</select>
			</form>
		</div>
		
		<div id="find" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<p><span>用户id：&emsp;</span><span id="id"></span></p>
			<p><span>用户名：&emsp;</span><span id="username"></span></p>
			<p><span>密码：&emsp;</span><span id="password"></span></p>
			<p><span>姓名：&emsp;</span><span id="name"></span></p>
			<p><span>性别：&emsp;</span><span id="sex"></span></p>
			<p><span>积分：&emsp;</span><span id="integral"></span></p>
			<p><span>状态：&emsp;</span><span id="state"></span></p>
		</div>

		<div id="utils" style="position:absolute;top:5px;left:220px;font-size: 14px;">
		
		
		
			id：<input id="studyId" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 
			标题：<input id="studyTitle" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 
			<a id="search" class="easyui-linkbutton" >搜索</a>    
		</div>
	</body>
	<script type="text/javascript">
	
	
	
	
	
		$(function() {
			//联合查询
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
				title: '用户列表',
				url: 'user',
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
						field: 'username',
						title: '用户名',
						width: 200,
						align: 'center'
					}, {
						field: 'password',
						title: '密码',
						width: 400,
						align: 'center'
					},{
						field: 'uname',
						title: '姓名',
						width: 100,
						align: 'center'
					}, {
						field: 'gender',
						title: '性别',
						width:150,
						align: 'center'
					}, {
						field: 'integral',
						title: '积分',
						width: 70,
						align: 'center'
					}, {
						field: 'state',
						title: '用户状态(0为审核,1为展示)',
						width: 70,
						align: 'center'
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
							title: '添加用户',
							width: 500,
							height: 700,
							closed: false,
							modal: true,
							buttons:[{
								text:'保存',
								handler:function(){
									var username=$("#addUserName").val();
									var pwd=$("#addPwd").val();
									var rpwd=$("#addRpwd").val();
									
									if(pwd != rpwd){
										alert("第一次密码跟第二次密码不一致");
									}else{
										var name=$("#addName").val();
										var sex=$("#addSex").val();
										var role=$("#addRole").val();
										console.log(name+"-----------"+pwd+"-------------"+name+"---------"+sex);
										//console.log(decodeURI($("#amendQuestion").serialize()));
										$.ajax({
											url:"user",
											type:"post",
											data:{
												username:username,
												password:pwd,
												uname:name,
												gender:sex,
												type:role
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
		
		function findQuestion(index){
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			console.log(row);
			debugger
			if(row){
				$("#id").text(row.uid);
				$("#username").text(row.username);
				$("#password").text(row.password);
				$("#name").text(row.uname);
				$("#sex").text(row.gender);
				$("#integral").text(row.integral);
				$("#state").text(row.state);
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
									var username=$("#updateUserName").val();
									var pwd=$("#updatePwd").val();
									var name=$("#updateName").val();
									var sex=$("#updateSex").val();
									var role=$("#updateRole").val();
									console.log(username+"-----------"+pwd+"-------------"+name);
									console.log(sex+"-----------"+role+"-------------");
									//console.log(decodeURI($("#amendQuestion").serialize()));
									
									$.ajax({
										url:"user",
										type:"post",
										data:{
											_method:"PUT",
											uid:row.uid,
											username:username,
											password:pwd,
											uname:name,
											gender:sex,
											rid:role
										},
										success : function(result) {
											debugger
											console.log(result)
											$.messager.progress('close'),
											$('#add').dialog("close");
											$("#tb").datagrid("reload");
											  /* close此处有问题 */
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
		
		

		window.onresize = function(){
		   setTimeout(function () {
		            var sheight = 291;
		            if ($.browser.msie && ($.browser.version == "7.0" || $.browser.version == "6.0")) {
		                sheight = 800;
		            }
		            $("#sdatatab").datagrid('resize', {
		                width: $("#datadiv").width(),
		                height: sheight
		            });
		        }, 300);
		};
	</script>
</html>
