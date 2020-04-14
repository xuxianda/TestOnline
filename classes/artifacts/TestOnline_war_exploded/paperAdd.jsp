<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷增加</title>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/gray/easyui.css">

<link href="css/te.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<style>
input {
	margin: 5px;
}
</style>


<body style="margin: 0; padding: 0;">

	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input type="text" id="tname" name="tname"
				class="form-control"></td>
			<td><input class="btn btn-default" type="button" name="tname"
				value="试卷名称" required></td>
		</tr>
	</table>

	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input type="text" id="time" name="time"
				class="form-control"></td>
			<td><input class="btn btn-default" type="button" name="time"
				value="考试时长" required></td>
		</tr>
	</table>

	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input id="cc" name="qname" style="width: 50%"></td>
			<td><input class="btn btn-default" type="button" value="科目"></td>
		</tr>
	</table>

	<table class="table table-hover " style="text-align: center">
		<tr>
			<td><input id="gid" name="gname" style="width: 50%"></td>
			<td><input class="btn btn-default" type="button" value="级别"></td>
		</tr>
	</table>


	<table class="table table-hover " style="text-align: center">
		<tr>
			<td id="del"><input class="btn btn-default" type="button"
				id="start" name="start" value="开始选题"></td>
			<td id="del"><input class="btn btn-default" type="button"
				id="end" name="start" value="生成试卷" style="display: none"></td>
		</tr>
	</table>


	<table id="gd">
	</table>

	<div id="id">
		<%-- <%=request.setAttribute("",)%> --%>
	</div>



</body>

<script type="text/javascript">
	//科目
	$('#cc').combobox({
		url : 'subject/findAll2',
		method : 'get',
		valueField : 'sid',
		textField : 'sname',
	});
	$('#gid').combobox({
		url : 'grade',
		method : 'get',
		valueField : 'gid',
		textField : 'gname'
	});

	/* window.onload = function () {
		$('#gd').datagrid("getPanel").hide();
	} */

	document.getElementById("start").onclick = function() {

		var sid = $("#cc").val();
		var qname = "";
		var gid = $("#gid").val();
		console.log(sid);

		if (sid == 0) {
			alert("--- 您还未选择科目");
		}else if (gid == 0) {
			alert("--- 您还未选择难度")
		}else{
		
		$("#gd").datagrid({
			url : "paper/type1",
			method : 'get',
			pagination : true,
			checkOnSelect : false,
			queryParams : {
				sid : sid,
				gid : gid
			},
			columns : [ [ {
				field : 'k',
				title : 'k',
				checkbox : true
			}, {
				field : 'qid',
				title : '题目编号',
				width : 100,
				align : 'center'

			}, {
				field : 'qname',
				title : '题目名称',
				width : 130,
				align : 'center'

			}, {
				field : 'score',
				title : '题目分值',
				width : 80,
				align : 'center'

			}, {
				field : 'a',
				title : 'A',
				width : 135,
				align : 'center'

			}, {
				field : 'b',
				title : 'B',
				width : 135,
				align : 'center'

			}, {
				field : 'c',
				title : 'C',
				width : 135,
				align : 'center'

			}, {
				field : 'd',
				title : 'D',
				width : 135,
				align : 'center'

			}, {
				field : 'qkey',
				title : '题目答案',
				width : 80,
				align : 'center'

			}, {
				field : 'sname',
				title : '科目',
				width : 100,
				align : 'center'

			}, {
				field : 'gname',
				title : '等级',
				width : 100,
				align : 'center'

			}, {
				field : 'tyname',
				title : '类型',
				width : 100,
				align : 'center'

			} ] ]
		});

		/* var e = document.getElementById("start");
		document.getElementById("del").removeChild(e); */

		$('#end').show();
		}
	}

	document.getElementById("end").onclick = function() {

		var tname = $("#tname").val();
		var time = $("#time").val();
		var sid = $("#cc").val();
		var gid = $("#gid").val();
		
		console.log(tname + "--" + time + "--" + sid + "--" + gid);

		var rows = $('#gd').datagrid('getChecked');
		var paper = [];
		var score = [];
		
		for (var i = 0; i < rows.length; i++) {
			paper.push(rows[i].qid);
			score.push(rows[i].score);
		}
		
		if (paper.length >= 3) {
			$.ajax({
				type : 'POST',
				url : 'paper',
				dataType : 'json',
				data : {
					tname : tname,
					time : time,
					sid : sid,
					gid : gid,
					paper : JSON.stringify(paper),
					score:JSON.stringify(score) 
				},
				success : function(xx) {
					
					if (xx) {
						alert("添加完成----");
					}else{
						alert("添加错误---");
					}
					
				}
			})
		}else{
			alert(" 您添加题目太少了------ ");
		}

	}
	
</script>






</html>
