<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
<!--jquery文件-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!--easyui核心文件-->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!--对应的语言包-->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!--皮肤文件-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<!--图标文件-->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/annuoncement.css" />

<style type="text/css">
#lidi {
	font-size: 23px;
	font-weight: bolder;
	margin-top: 190px;
	letter-spacing: 2px;
	text-decoration: none;
	margin-left: 20px;
	color: #000000;
}

#data {
	border: 1px solid red;
	text-align: left;
	/* position: relative */;
	width: 60%;
	float: left;
	margin: auto;
}

#datetime {
	/* border: 1px solid green; */
	/* position: relative; */
	text-align: left;
	float: right;
	width: 40%;
	margin-left: 8px;
}

#announDate {
	/* background-image: url(img/bj1.jpg);
     background-size: 100% 100%;
	 border: 1px solid #0000FF ; */
	
}

.announ-button-div {
	height: 50px;
	width: 130px;
	margin: 5px 0px 0px 20px;
}

#gj {
	/*  background-color:lightblue; */
	margin-top: 80px;
	height: 50px;
	/*  border:1px solid red; */
	position: fixed;
	left: 0px;
	bottom: 0;
	_position: absolute;
	_top: expression(document.documentElement.clientHeight +  
		 document.documentElement.scrollTop - this.offsetHeight);
}

#announDates {
	margin-left: 50px;
	/*  background-color: lightgrey; */
	/* height: document.body.clientHeight; */
}
</style>

</head>
<body style="height: 100%; widht: 100%;">

	<div id="cc" class="easyui-layout" style="width: 100%; height: 0px;">
		<!-- <div data-options="region:'north',split:true" style="height: 300px;"id="North">
			<div id="big-top-div-announ"
				style="background-image: url(img/t4.jpg); height:300px; background-size: 100% 100%;">
				<div id="xito-div">18合一在线考试系统公告</div>
			</div>
		</div> -->


	</div>
	<div data-options="region:'center',title:'公告通知'"
		style="padding: 5px; height: 100%; background: #eee; /* background-image: url(img/bj1.jpg) */; background-size: 100% 100%;">


		<!-- 红色背景的div开始 -->
		<div id="big-cent-div-announ-top">
			<div id="big-ceng-div-announ-log">
				<a href="index.jsp" target="首页" id="aa">首页 &nbsp;&nbsp;</a> | <a
					href="addAnnouncement.jsp" target="登陆页面" id="aa">添加公告
					&nbsp;&nbsp; </a>| <a href="#" target="成绩发布" id="aa">学习
					&nbsp;&nbsp;</a> | <a href="studyArea.action" target="资料" id="aa">资料
					&nbsp;&nbsp; </a> | <a href="#" target="考试介绍" id="aa">考试介绍
					&nbsp;&nbsp; </a> | <a href="#" target="考试规范" id="aa">考试规范&nbsp;&nbsp;
				</a>| <a href="examinationRank.action" target="考试排名" id="aa">考试排名
					&nbsp;&nbsp; </a> | <a href="http://localhost:8080/TestOnline/#tr2"
					target="机构介绍" id="aa">项目介绍 &nbsp;&nbsp;</a> |
			</div>
		</div>
		<!-- 红色背景的div结束 -->
		<div id="announDates"
			style="height:1500px ;padding-top: 100px;">
			<div>
				<ul id="announDate"></ul>
			</div>
			<div id="gj">
				<input type="button" class="announ-button-div" id="indexpage"
					value="首页" /> <input type="button" class="announ-button-div"
					id="uppage" value="上一页" /> <input type="button"
					class="announ-button-div" id="bopage" value="下一页" /> <input
					type="button" class="announ-button-div" id="lastpage" value="尾页" />
				<span class="announ-button-div" id="totalpage"></span>

			</div>
		</div>


	</div>

	</div>


</body>
<script>
	//入口函数

	var page = 1;
	var w = 1;
	$("#uppage").click(function() {//上一页
		if (page >= 1) {
			page = page - 1;
			publicspage(page);
		}

	})
	$("#bopage").click(function() {//下一页
		if (page < w) {
			page = page + 1;
			publicspage(page);
		}

	})
	$("#indexpage").click(function() {//首页
		if (page != 1) {
			page = 1;
			publicspage(page);
		}
	})
	$("#lastpage").click(function() {//尾页
		if (page != w) {
			publicspage(w);
		}

	})

	function publicspage(temp) {

		$
				.ajax({
					url : 'announcement',
					type : 'get',
					data : {
						page : temp,
						row : 10
					},
					success : function(result) {
						$("#announDate").empty();
						
						for (var i = 0; i < result.rows.length; i++) {
							$("#announDate")
									.append(
											"<a id='lidi' href='queryAnnouncementSingle.jsp?aid="
													+ result.rows[i].aid
													+ "'><li>"
													+ result.rows[i].aname
													+ "<span id='datetime'>"
													+ result.rows[i].adate
													+ "</span></li></a><hr style='border:1 dashed #987cb9' width='80%' /* color=#fffff */ /* SIZE=1 */ /><br/><br/>")
						}
						page = result.sum;
						w = result.sum;
						$("#totalpage").text("总页数:" + result.sum);

					},

				})
	}

	$(function() {

		
		$.ajax({
			url : 'announcement',
			type : 'get',
			data : {
				page : 1,
				row : 10
			},
			success : function(result) {
				$("#announDate").empty();
				for (var i = 0; i < result.rows.length; i++) {
					$("#announDate")
							.append(
									"<a id='lidi' href='queryAnnouncementSingle.jsp?aid="
											+ result.rows[i].aid
											+ "'><li>"
											+ result.rows[i].aname
											+ "<span id='datetime'>"
											+ result.rows[i].adate
											+ "</span> </li></a><hr style='border:1 dashed #987cb9' width='80%' /* color=#fffff */ /* SIZE=1 */ /><br/><br/>")
				}
				$("#totalpage").text("总页数:" + result.sum);
				w = result.sum;

			},

		})

	})
</script>
</html>