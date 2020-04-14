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
					<input id="qname2" class="easyui-textbox" name="qname" data-options="label:'题目内容:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;">
					技术名称：<input id="sname2" name="sname" >
				</div>
				<div style="margin-bottom: 20px;">
					题目类型：<input id="tyname2" name="tyname" >
				</div>
				<div style="margin-bottom: 20px;">
					题目等级：<input id="gname2" name="gname" >
				</div>
				<div style="margin-bottom: 20px;" id="d1">
					<input id="a2" class="easyui-textbox" name="a" data-options="label:'选项一:',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;" id="d2">
					<input id="b2" class="easyui-textbox" name="b" data-options="label:'选项二:',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;" id="d3">
					<input id="c2" class="easyui-textbox" name="c" data-options="label:'选项三:',width:300,height:50">
				</div>
				
				<div style="margin-bottom: 20px;" id="d4">
					<input id="dd2" class="easyui-textbox" name="d" data-options="label:'选项四:',width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;">
					<input id="qkey2" class="easyui-textbox" name="qkey" data-options="label:'答案:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;">
					<input id="score2" class="easyui-textbox" name="score" data-options="label:'分值:',required:true,width:300">
				</div>
			
		</div>
		<!-- 修改题目 -->
		<div id="content" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<form id="amendQuestion" >
				<input type="hidden" name="_method" value="post" />
				<div style="margin-bottom: 20px;display:none" >
					<input id="qid" class="easyui-textbox" name="qid" data-options="label:'题目编号:',required:true,closed:true">
				</div>
				
				<div style="margin-bottom: 20px; ">
					<input id="qname" class="easyui-textbox" name="qname" data-options="label:'题目内容:',required:true,width:300,height:50">
				</div>
				
				<div style="margin-bottom: 20px;">
					技术名称：<input id="sname" name="sname" >
				</div>
				<div style="margin-bottom: 20px;">
					题目类型：<input id="tyname" name="tyname" >
				</div>
				<div style="margin-bottom: 20px;">
					题目等级：<input id="gname" name="gname" >
				</div>
				<div style="margin-bottom: 20px;" id="one" >
					<input id="a" class="easyui-textbox" name="a" data-options="label:'选项一:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;" id="two">
					<input id="b" class="easyui-textbox" name="b" data-options="label:'选项二:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;" id="three">
					<input id="c" class="easyui-textbox" name="c" data-options="label:'选项三:',required:true,width:300,height:50">
				</div>
				
				<div style="margin-bottom: 20px;" id="four">
					<input id="d" class="easyui-textbox" name="d" data-options="label:'选项四:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;">
					<input id="qkey" class="easyui-textbox" name="qkey" data-options="label:'答案:',required:true,width:300,height:50">
				</div>
				<div style="margin-bottom: 20px;">
					<input id="score" class="easyui-textbox" name="score" data-options="label:'分值:',required:true,width:300">
				</div>
				<div style="margin-bottom: 20px;">
					<input id="qsname" class="easyui-textbox" name="qsname" data-options="label:'题目状态:',required:true,width:300,disabled:true">
				</div>
			</form>
		</div>
		
		<div id="find" class="easyui-dialog" data-options="resizable:true,closed:true,width:500,height:700">
			<p><span>题目：</span><span id="qname3"></span></p>
			<p><span>题目类型：</span><span id="tyname3"></span></p>
			<p><span>科目类型：</span><span id="sname3"></span></p>
			<p><span>等级：</span><span id="gname3"></span></p>
			<p><span>选项一</span><span id="a3"></span></p>
			<p><span>选项二：</span><span id="b3"></span></p>
			<p><span>选项三：</span><span id="c3"></span></p>
			<p><span>选项四：</span><span id="d3"></span></p>
			<p><span>答案：</span><span id="qkey3"></span></p>
			<p><span>分值：</span><span id="score3"></span></p>
			<p><span>题目状态：</span><span id="qstate3"></span></p>
			<p><span>出题日期：</span><span id="qdate3"></span></p>
			<p><span>出题人：</span><span id="username3"></span></p>
		</div>

		<div id="utils" style="position:absolute;top:5px;left:220px;font-size: 14px;">
			等級：<input id="gname4" name="gname" >
			科目：<input id="sname4" name="sname" >
			題目：<input id="qname4" class="easyui-textbox">
			<a id="search" class="easyui-linkbutton" >搜索</a>    
		</div>
	</body>
	<script type="text/javascript">
		$(function() {
			
			$('#search').linkbutton({ 
				onClick:function(){
					console.log("----");
					var sid=$("#sname4").combobox("getValue");
					var gid=$("#gname4").combobox("getValue");
					console.log(sid+","+gid);
					var qname=$("#qname4").textbox("getText");
					if(sid==""&&gid==""&&qname==""){
						sid=0;
						gid=0;
						qname="";
					}else if(sid==""&&gid!=""&&qname!=""){
						sid=0;
					}else if(sid==""&&gid==""&&qname!=""){
						sid=0;
						gid=0;
					}else if(sid!=""&&gid!=""&&qname==""){
						qname="";
					}else if(sid!=""&&gid==""&&qname==""){
						gid=0;
						qname="";
					}else if(sid==""&&gid!=""&&qname==""){
						sid=0;
						qname="";
					}else if(sid!=""&&gid==""&&qname!=""){
						gid=0;
					}
					 $("#tb").datagrid({
				    	url:"requestion/combination",
				    	method:"get",
				    	queryParams :{
				    		qname:qname,
				    		sid:sid,
				    		gid:gid
				    	}
				     })
				}
			});
			$("#gname4").combobox({
				url:"grade",
				method:"get",
				editable:false,
				valueField:"gid",
				textField:"gname"
			});
			$("#sname4").combobox({
				url:"subject/findAll2",
				method:"get",
				editable:false,
				valueField:"sid",
				textField:"sname"
			});
			
			$("#tb").datagrid({
				title: '题目列表',
				url: 'requestion',
				method: 'get',
				pagination: true,
				pageSize:10,
				singleSelect:true,
				pagination : true,
				fit:true,
				pagePosition:"bottom",
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
					},{
						field: 'gname',
						title: '等级',
						width: 70,
						align: 'center'
					}, {
						field: 'qname',
						title: '题目内容',
						width:150,
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
						field: 'qsname',
						title: '状态',
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
						width: 120,
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
						$("#qname2").textbox("setText","");
						$("#score2").textbox("setText","");
						$("#a2").textbox("setText","");
						$("#b2").textbox("setText","");
						$("#c2").textbox("setText","");
						$("#dd2").textbox("setText","");
						$("#qkey2").textbox("setText","");
						$("#gname2").combobox({
							url:"grade",
							method:"get",
							editable:false,
							valueField:"gid",
							textField:"gname"
						});
						$("#tyname2").combobox({
							url:"questionType",
							method:"get",
							editable:false,
							valueField:"tyid",
							textField:"tyname",
							onSelect:function(obj){
								if(obj.tyname=="解答题"){
									$("#d1").hide();
									$("#d2").hide();
									$("#d3").hide();
									$("#d4").hide();
								}else{
									$("#d1").show();
									$("#d2").show();
									$("#d3").show();
									$("#d4").show();
								}
								
							}
						});
						$("#sname2").combobox({
							url:"subject/findAll2",
							method:"get",
							editable:false,
							valueField:"sid",
							textField:"sname"
						});
						
						$('#add').dialog({
							title: '添加题目',
							width: 500,
							height: 700,
							closed: false,
							modal: true,
							buttons:[{
								text:'保存',
								handler:function(){
									var sid=$("#sname2").combobox("getValue");
									var tyid=$("#tyname2").combobox("getValue");
									var gid=$("#gname2").combobox("getValue");
									var qname=$("#qname2").textbox("getText");
									var score=$("#score2").textbox("getText");
									var a="";
									var b="";
									var c="";
									var d="";
									if($("#tyname2").combobox("getText")!="解答题"){
										a=$("#a2").textbox("getText");
										b=$("#b2").textbox("getText");
										c=$("#c2").textbox("getText");
										d=$("#dd2").textbox("getText");
									}
									var qkey=$("#qkey2").textbox("getText");
									console.log(sid+","+tyid+","+gid);
									//console.log(decodeURI($("#amendQuestion").serialize()));
									$.ajax({
										url:"requestion",
										type:"post",
										data:{
											sid:sid,
											tyid:tyid,
											gid:gid,
											qname:qname,
											score:score,
											a:a,
											b:b,
											c:c,
											d:d,
											qkey:qkey
										},
										success : function(result) {
											$.messager.progress('close'),
											$('#add').dialog("close");
											$("#tb").datagrid("reload");
											alert(result);
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
		
		function findQuestion(index){
			$('#tb').datagrid('selectRow', index); // 关键在这里  
			var row = $('#tb').datagrid('getSelected');
			console.log(row);
			if(row){
				$("#qname3").text(row.qname);
				$("#tyname3").text(row.tyname);
				$("#sname3").text(row.sname);
				$("#gname3").text(row.gname);
				$("#a3").text(row.a);
				$("#b3").text(row.b);
				$("#c3").text(row.c);
				$("#d3").text(row.d);
				$("#qkey3").text(row.qkey);
				$("#score3").text(row.score);
				$("#qstate3").text(row.qstate);
				$("#qdate3").text(row.qdate);
				$("#username3").text(row.username);
				$('#find').dialog({
					title: '查看题目',
					width: 500,
					height: 700,
					closed: false,
					modal: true,
					buttons:[{
						text:'关闭',
						handler:function(){
							$.messager.progress('close'),
							$('#find').dialog("close");
							$("#tb").datagrid("reload");
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
				if(row.qstate==1){
					alert("已审核，不可修改！");
				}else if(row.qstate==-1){
					alert("已禁用，不可修改!");
				}else{
				$("#gname").combobox({
					url:"grade",
					method:"get",
					editable:false,
					valueField:"gid",
					textField:"gname"
				});
				$("#tyname").combobox({
					url:"questionType",
					method:"get",
					editable:false,
					valueField:"tyid",
					textField:"tyname",
					onSelect:function(obj){
						if(obj.tyname=="解答题"){
							$("#one").hide();
							$("#two").hide();
							$("#three").hide();
							$("#four").hide();
						}else{
							$("#one").show();
							$("#two").show();
							$("#three").show();
							$("#four").show();
						}
						
					}
				});
				$("#sname").combobox({
					url:"subject/findAll2",
					method:"get",
					editable:false,
					valueField:"sid",
					textField:"sname"
				});
				
				$('#content').dialog({
					title: '编辑题目',
					width: 500,
					height: 700,
					closed: false,
					modal: true,
					buttons:[{
						text:"保存",
						handler:function(){
							var sid=$("#sname").combobox("getValue");
							var tyid=$("#tyname").combobox("getValue");
							var tyname=$("#tyname").combobox("getText");
							var gid=$("#gname").combobox("getValue");
							//console.log(decodeURI($("#amendQuestion").serialize()));
							$("#amendQuestion").form("submit",{
								url:"requestion/update",
								method:"post",
								queryParams:{
									sid:sid,
									tyid:tyid,
									gid:gid
								},
								success : function(result) {
									$.messager.progress('close'),
									$('#content').dialog("close");
									$("#tb").datagrid("reload");
									alert(result);
								}
							})
						}
					},{
						text:'关闭',
						handler:function(){
							$.messager.progress('close'),
							$('#content').dialog("close");
							$("#tb").datagrid("reload");
						}
					}]
				});
				$('#amendQuestion').form('load',row);  
				}
			}
			
		}
	</script>
</html>
