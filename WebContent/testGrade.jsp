<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>试卷批阅</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<style>
			span {
	font-size: 22px;
}

input {
	width: 40px;
	height: 30px;
}
</style>
	</head>
	<body style="margin: 0px; padding: 0px;">

		<div id="d1">
			<table id="tb1" style="padding: 0; margin: 0;" class="easyui-datagrid">
			</table>
		</div>

		<div id="content"></div>

		<div>
			<button type="button" id="b1" style="width: 200px; height: 30px; background-color: mediumseagreen; color: white; border: 0px;display: none;"
			 onclick="submit()">提交分数</button>
		</div>
		<div id="gender_ts" style="display: none; font-size: 20px; text-align: center;">请认真仔细检查，是否还有未批改的题目！</div>
		<div id="submit_success" style="display: none; font-size: 20px; text-align: center;">提交成功！</div>
	</body>
	<script type="application/javascript">
		var type = "all";
		var value = null;
		var questions;
		var testid = "";
		$('#tb1').datagrid({
			title: '试卷批阅',
			url: 'view/userexam',
			method: 'get',
			queryParams: {
				type: type,
				value: value
			},
			pagination: true,
			pageSize: 10,
			singleSelect: true,
			pagination: true,
			pagePosition: "bottom",
			columns: [
				[{
					field: 'testid',
					title: '考试编号',
					width: 100,
					align: 'center'
				}, {
					field: 'tname',
					title: '试卷名称',
					width: 300,
					align: 'center'
				}, {
					field: 'uid',
					title: '考生编号',
					width: 100,
					align: 'center'
				}, {
					field: 'uname',
					title: '考生姓名',
					width: 200,
					align: 'center'
				}, {
					field: 'username',
					title: '考生账号',
					width: 200,
					align: 'center'
				}, {
					field: 'date',
					title: '考试日期',
					width: 200,
					align: 'center'
				}, {
					field: 'tid',
					title: '试卷编号',
					width: 150,
					align: 'center'
				}, {
					field: 'tsum',
					title: '试卷总分',
					width: 100,
					align: 'center'
				}, {
					field: 'score',
					title: '考生成绩',
					width: 100,
					align: 'center'
				}, {
					field: 'cz',
					title: '操作',
					width: 220,
					align: 'center',
					formatter: function(value, row, index) {
						bth = "<button style='text-decoration: none' onClick='read(" + index + ")'>阅卷</button>"
						return bth;
					}
				}]
			]
		});

		function read(index) {
			var temp = $('#tb1').datagrid('getRows')[index];
			$.ajax({
				type: "get",
				url: "examGrade/student",
				data: {
					testid: temp.testid,
					page: 1,
					rows: 100
				},
				success: function(result) {
					console.log(result);
					printQuestion(result);
					questions = result;
					testid = temp.testid;
				}
			})
			$("#d1").css("display", "none");
			$("#b1").css("display", "block");
		}

		function printQuestion(questions) {
			for (var i = 0; i < questions.total; i++) {
				var question = questions.rows[i];
				console.log(question);
				$("#content").append("<div id=q" + i + "></div>");
				$("#q" + i).append(
					'<div style="height: 30px;width: 100%;background: #3889d4;text-align: center;color: white;font-weight: bold;">' +
					question.tyname + '</div>');
				$("#q" + i).append("<span class=order>" + (i + 1) + "</span>&nbsp;");
				$("#q" + i).append("<span class='qname' ids=" + question.score + ">" + question.qname + "</span>&nbsp;&nbsp;&nbsp;");
				if (question.tyname == "单选题" || question.tyname == "多选题") {
					$("#q" + i).append(
						"<span class='truekey' style='color:green'>标准答案：" + question.tqkey + "</span><br>" +
						"<span class='qkey'>" +
						"<span class='section'>" +
						"<input id='selectA" + i + "' type='checkbox' disabled='true'><span class='A'>A." + question.a +
						"</span><br /><br />" +
						"<input id='selectB" + i + "' type='checkbox' disabled='true'><span class='B'>B." + question.b +
						"</span><br /><br />" +
						"<input id='selectC" + i + "' type='checkbox' disabled='true'><span class='C'>C." + question.c +
						"</span><br /><br />" +
						"<input id='selectD" + i + "' type='checkbox' disabled='true'><span class='D'>D." + question.d +
						"</span><br /><br />" +
						"<span id='txt" + i + "' style='display: none;'>" +
						"<textarea id='value" + i + "' readonly='readonly'></textarea>" +
						"</span></span>");
					console.log("i:" + i + "," + question.qname);
					console.log(question.userQkey);
					if (question.userQkey.indexOf("A") != -1 || question.userQkey.indexOf("a") != -1) {
						$("#selectA" + i).attr("checked", "checked");
					}
					if (question.userQkey.indexOf("B") != -1 || question.userQkey.indexOf("b") != -1) {
						$("#selectB" + i).attr("checked", "checked");
					}
					if (question.userQkey.indexOf("C") != -1 || question.userQkey.indexOf("c") != -1) {
						$("#selectC" + i).attr("checked", "checked");
					}
					if (question.userQkey.indexOf("D") != -1 || question.userQkey.indexOf("d") != -1) {
						$("#selectD" + i).attr("checked", "checked");
					}
					$("#q" + i).append(
						" <span> 分值：<input class='score" + i +
						"' name='pwd' placeholder='输入分数' class='easyui-numberbox' prompt='输入分数' value=" +
						question.score +
						" iconWidth='28' style='width:100px; height: 40px; margin-top: 20px;text-align: center;font-size:20px'/></span><br/><br/>"
					);
				} else if (question.tyname == "解答题") {
					$("#q" + i).append('<span class="truekey" style="color:green">标准答案：' + question.tqkey +
						'</span><br><br/><br/><span class="txt"><textarea readonly="readonly">' + question.userQkey +
						'</textarea></span><br/><br/>');
					$("#q" + i).append(
						" <span> 分值：<input class='score" + i +
						"' name='pwd' placeholder='输入分数' class='easyui-numberbox' prompt='输入分数' value='0' iconWidth='28' style='width:100px; height: 40px; margin-top: 20px;text-align: center;font-size:20px'/></span><br/><br/>"
					);
				}
			}

		}

		function submit() {
			$('#gender_ts').dialog({
				title: '提示',
				width: 400,
				height: 200,
				closed: false,
				cache: false,
				modal: true,
				buttons: [{
						text: '确认无误', ////对话框内容关闭
						handler: function() {
							var sum = "";
							for (var i = 0; i < questions.total; i++) {
								var question = questions.rows[i];
								sum += $(".score" + i).val();
							}
							$.ajax({
								type: "post",
								data: {
									testid: testid,
									score: sum
								},
								url: "examGrade/set",
								success: function() {
									$('#submit_success').dialog({
										title: '提交成功',
										width: 400,
										height: 200,
										closed: false,
										cache: false,
										modal: true,
										buttons: [{
											text: '关闭', ////对话框内容关闭
											handler: function() {
												$("#submit_success").dialog("close");
												$("#gender_ts").dialog("close");
												window.location.reload();
											}
										}]
									});
								}
							});
							$("#gender_ts").dialog("close");
						}
					},
					{
						text: '我再改改', ////对话框内容关闭
						handler: function() {
							$("#gender_ts").dialog("close");
						}
					}
				]
			});
		}
	</script>
</html>
