<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看具体公告信息</title>
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
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#bigbig-addAnnouncement-div {
	height: 100%;
	width: 100%;
	margin: auto;
	position: relative;
	background-size: 100%;
}

#big-addAnnouncement-div {
	position: absolute;
	margin-left: 20%;
	width: 70%;
	height: 60%;
}

#addname {
	margin-top: 3.25rem;
	height: 40px;
	width: 100%;
	font-weight: bolder;
	font-size: 40px;
	text-align: center;
}

#addauthor {
	margin-top: 1.25rem;
	height: 50px;
	width: 70%;
	text-align: right;
	font-size: 20px;
	margin-left: 270px;
	text-align: right;
}

#adate {
	margin-top: 50px;
	margin-bottom: 10px;
	font-weight: bolder;
	text-align: center;
	margin-left: 420px;
	/* border: 1px solid red; */
	font-size: 20px;
}

#texts {
	padding-top: 30px;
	margin-top: 1.875rem;
	margin-bottom: 30px;
	/* margin-left: 23%; */
	font-size: 28px;
	font-weight: bolder;
	height:550px;
	width:100%;
	/* text-index:20px; */
	/* border: 0.5px solid #00281C; */
	/* text-align: center; */
	border: 1px solid #BBBBBB;
}

#up-announ-but {
	margin:0px 8px 0px 0px;
	text-align: center;
}

#del-announ-but {
	/* margin:0px 8px 0px 0px;
	text-align: center; */
}

#out-announ-but {
	/* height: 30px;
	width: 100px;
	text-align: center; */
}

#div-button {
    height:30px;
	/* background-color: #F7E1B5; */
	/*   border:1px solid red;  */
	 width:22%;
	/* margin-left:320px */
}
#big-ceng-div-announ-log{
	color: white;
	font-size:18px;
	/* margin-left:18%; */
	padding-top:13px ;
	
}
#big-ceng-div-announ-log a{
	color: beige;
	text-decoration: none;
	line-height: 100%;
}
#big-ceng-div-announ-log:first-child{
	padding-top:50px ;
}
#big-cent-div-announ-top{
	background-color: royalblue;
	height: 80px;
}
body {
	/* background-image: url(img/bj2.jpg); */
	background-size: 100% 100%;
	/* border: 1px solid blue; */
}
</style>
</head>
<body>
<div id="big-cent-div-announ-top">
			<div id="big-ceng-div-announ-log">
				<a href="index.jsp" target="首页" id="aa">首页 &nbsp;&nbsp;</a> |
				<a href="announcement.jsp" target="公告页面" id="aa">公告 </a>&nbsp;&nbsp;|
				<a href="addAnnouncement.jsp" target="添加公告" id="aa">添加公告 &nbsp;&nbsp; </a>| 
				<span id="up-announ-but">修改公告 &nbsp;&nbsp;|</span> <span id="del-announ-but">删除公告 &nbsp;&nbsp;|</span>
				<a href="studyArea.action" target="资料" id="aa">资料
					&nbsp;&nbsp; </a> | <a href="#" target="考试介绍" id="aa">考试介绍
					&nbsp;&nbsp; </a> | <a href="#" target="考试规范" id="aa">考试规范&nbsp;&nbsp;
				</a>| <a href="examinationRank.action" target="考试排名" id="aa">考试排名
					&nbsp;&nbsp; </a> | <a href="http://localhost:8080/TestOnline/#tr2"
					target="机构介绍" id="aa">项目介绍 &nbsp;&nbsp;</a> |
			</div>
		</div>
	<div id="bigbig-addAnnouncement-div">
		<div id="big-addAnnouncement-div" style="height:100%;">
			<p id="addname">c#考试了</p><br/><br/>
			<div style="width: 100%;"><hr/></div>
			<p id="adate">发布时间：2020年3月日</p>

			<input id="adds" type="hidden" value="${user.uid}" />
			 <textarea id="texts" style="overflow: scroll; overflow-x: hidden;"
				 readonly="readonly"></textarea> 
			 <!--  <div id="texts" contenteditable="true" placeholder="文本内容..."> 
			  </div> -->
			   <p id="addauthor"><input type="button" id="out-announ-but" value="上一页"
					style="background-color: forestgreen; width: 80px; height: 30px; font-size: 17px;"></p>
			
			<br />
			<div id="div-button">
				<!-- <input type="button" id="up-announ-but" value="修改"
					style="background-color: forestgreen; width: 80px; height: 30px; font-size: 17px;">
				<input type="button" id="del-announ-but" value="删除"
					style="background-color: forestgreen; width: 80px; height: 30px; font-size: 17px;"> -->
				
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//获得url中的参数
		function GetQueryString(name)

		{
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");

			var r = window.location.search.substr(1).match(reg);

			if (r != null)
				return unescape(r[2]);
			return null;
		}

		var aid = GetQueryString("aid"); //根据url中的参数名获得值
		$.ajax({
			url : 'announcement/singleObject',
			type : 'get',
			data : {
				'aid' : aid
			},
			success : function(result) {
				$("#addname").text(result.aname);
				$("#addauthor").text("编辑者：" + result.author);
				$("#texts").text(result.avalue);
				$("#adate").text("发布时间："+result.adate);
			}

		})
		var uid = $("#adds").val();
		 $.ajax({//判断取消，是否显示删除/修改按钮
				url : 'announcement/isuid',
				type : 'get',
				data : {
					'aid' : aid,
					'uid' : uid
				},
				success : function(result) {
					
					if(result){
						$("#up-announ-but").show();
						$("#del-announ-but").show();
					
					}else{
						$("#up-announ-but").hide();
						$("#del-announ-but").hide();
						
						
					}
				
				}
		})
 
		//跳转到修改页面
		
		$("#up-announ-but").click(function() {
							$.ajax({
								url : 'announcement/isuid',
								type : 'get',
								data : {
									'aid' : aid,
									'uid' : uid
								},
								success : function(result) {
									if (result == true) {
										window.location.href = "addAnnouncement.jsp?aid="
												+ aid;
									} else {
										alert("很抱歉，您无该权限！");
									}
								}

							})
						})

		var bo = false;
		
		//逻辑删除公告，发布者或管理者才可以删除
		$("#del-announ-but").click(function() {//判断是否是发布者或管理员
			$.ajax({
				url : 'announcement',
				type : 'post',
				data : {
					_method:"delete",
					'aid' : aid
				},
				success : function(result) {
					if (result>0) {
						window.location.href = "announcement.jsp";
					} else {
						alert("删除失败。。。。。。。");
					}
				}
			})

			/* if (uid == "3") {//符合权限，可以逻辑删除
				$("#up-announ-but").show();
				$("#del-announ-but").show();
				$.ajax({
					url : 'announcement',
					type : 'pots',
					data : {
						_method : "DELETE",
						'aid' : aid
					},
					success : function(result) {
						if (result>0) {
							window.location.href = "announcement.jsp";
						} else {
							alert("删除失败。。。。。。。");
						}
					}
				})
			} */

		})
 
		$("#out-announ-but").click(function(){
			window.location.href = "announcement.jsp";
		})
	})
</script>
</html>