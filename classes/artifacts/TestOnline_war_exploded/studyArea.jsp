
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线考试网</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet" href="css/button.css">
		<script src="js/modernizr.custom.js"></script>
		<script src="js/button.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
		<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
		<script src="/follow.js" type="text/javascript"></script>
		<style type="text/css">
			body {
				overflow-x: hidden;
				overflow-y: hidden;
			}

			#menu {
				position: relative;
				z-index: 10;
			}

			a {
				color: #000000;
			}

			.title {
				font-size: 65px;
			}

			.content {
				text-align: center;
			}

			.text {
				font-size: 20px;
				position: relative;
				top: 60px;
			}

			::-webkit-scrollbar {
				width: 5px;
				height: 5px;
			}

			::-webkit-scrollbar-track {
				-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
				border-radius: 4px;
				background-color: #FFFFFF;
			}

			::-webkit-scrollbar-thumb {
				border-radius: 5px;
				-webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, .3);
				background-color: #000000;
			}
			.neir div{
                /* border:1px solid red; */
            }
            
            .neir>div{
                width: 45%;
                height: 25.3%;
                float: left;
               	margin-right:30px;
               	margin-bottom:80px;
                overflow:hidden;
			 text-overflow: ellipsis;
			display: -webkit-box;
			-webkit-line-clamp: 8;
			-webkit-box-orient: vertical;
            }
            /* .neir>div>div{
                width: 100%;
                height: 50%;
            } */
            .biaoti{
            	width:100%;
            	height:10%;
            }
            
			
            .neir>div>div:first-child {
            	line-height:40px;
				height:40px;
				background-color: white;
				color:black;
				font-size: 20px;
				border-bottom:2px solid #3d444c; 
			}
			
			.font_div{
			height:100%;
			width:100px;
			background-color: #3d444c;
			color:white;
			display: flex;
			justify-content: center;
			align-items: center;
			}
			.datum{
				width:100%;
				height:30px;
				line-height: 30px;
				border-bottom:1px dashed gray; 
			}
			
			.a>.p{
			width:100%;
			height:100px;
			background-color: #3d444c;
			text-align: center;
			padding-top:5px; 
			color:white;
			position: fixed;
			bottom:0;
			}
			.a{
			position: relative;
			}
			.datum>font{
				float: right;
			}
		</style>
	</head>
	<body class="easyui-layout" style="margin: 0px; padding: 0px;">
		<div data-options="region:'north',split:false" style="border: 0px;height:55px;<!-- overflow-x: hidden; overflow-y: hidden; -->">

		</div>

		<!-- 内容 -->
		<div data-options="region:'center',split:false" style='border: 0px;overflow-x:hidden;' class="a">
			<div class="neir" id="neir">
			
			</div>  
			  <div class="p">
			 版权所有:智能时代18合一第一组   © 2020-2099  All Rights Reserved<br><br>
			删帖入口     鄂ICP备13012778号-1<br><br>
			健康人生 学习<br>
			  </div>
			 
		</div>
		<!-- 底部 -->
		
			<script type="text/javascript">
			$.ajax({
				url:"Datum",
				data:{page:1,rows:99},
				type:"get",
				dataType: "json",
				 success: function(data){
					 var content=document.getElementById("neir");
					 var type=["初级资料","中级资料","高级资料","课外拓展"];
					/* for (var i = 0; i < type.length; i++) {
						var div=document.createElement('div');
						var values= document.createAttribute('value');
						pClass.value = type[i];
						div.setAttributeNode(values);
						content.appendChild(div);
					}	 */		 
					
					for(var j=0;j<type.length;j++){
						var div=document.createElement('div');
						var div_1=document.createElement('div');
						div_1.innerHTML="<div class='font_div'>"+type[j]+"</div>";
						div.appendChild(div_1);
						for(var i=0;i<data.length;i++){
							if(type[j] === data[i].cla){
								var div_2=document.createElement('div');
 								 div_2.innerHTML="<div class='datum'><a href='studyText.jsp?id="+data[i].id+"'>"+data[i].name+"</a><font>当前浏览次数:"+data[i].views+"</font></div>"; 
 								div.appendChild(div_2);
							}
						}
						content.appendChild(div);
					}
					 
						
				 }
			})
				
			</script>

	

		<!-- 顶部菜单 -->
	<div id="menu">
		<div class="index-nav">
			<div class="index-nav-frame clearfix">
				<div class="nav-line"></div>
				<div class="nav-small" tabindex="-1">
					<div class="nav-small-focus" tabindex="-1"></div>
					<img src="img/icon.png">
				</div>
				<div class="index-nav-frame-line active" tabindex="-1"
					style="position: absolute; left: 0px; bottom: 5px;">
					<img src="img/logo.png" onclick="index()">
				</div>
				<div class="index-nav-frame-line active" tabindex="-1">
					<a href="javascript:;" onclick="index()">首页</a>
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr1">欢迎页</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr2">项目介绍</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="http://localhost:8080/TestOnline/#tr3">关于</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					学习
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="studyArea.action">资料</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="itemBank.action">题库</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					考试
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="testOnline.action">在线考试</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="examinationRecord.action">考试记录</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="examinationRank.action">考试排名</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1">
					新闻
					<div class="index-nav-frame-line-center">
						<div class="index-nav-frame-line-li">
							<a href="announcement.action">网站公告</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="">考试规范</a>
						</div>
					</div>
					<div class="index-nav-frame-line-focus" tabindex="-1"></div>
				</div>
				<div class="index-nav-frame-line" tabindex="-1"
					style="position: absolute; right: 60px; top: 0px;">
					<span id="uname">请先登陆</span>
					<div class="index-nav-frame-line-center" id="usermanager">
						<div class="index-nav-frame-line-li">
							<a href="javascript:;" id="userInfo" onclick="userInfo()">个人主页</a>
						</div>
						<div class="index-nav-frame-line-li" id="admin"
							style="display: none;">
							<a href="admin.action;" id="admin">后台管理</a>
						</div>
						<div class="index-nav-frame-line-li">
							<a href="javascript:;" onclick="outLogin()">退出登陆</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div id="outLogin_infor" style="display: none;">退出登陆成功！</div>
	</body>
</html>
</div>
<div data-options="region:'center',split:false" style="border: 0px; overflow: hidden;"></div>
</body>
<script type="application/javascript">
	$(function() {
		var screeheight = $(window).height();
		var screewidth = $(window).width();
		// console.log(screeheight + "/" + screewidth + "/");
		$("#tb1").width(screewidth);
		$("#tr1").height(screeheight);
		$("#tr2").height(screeheight);
		$("#tr3").height(screeheight);
		$("#tb2").width(screewidth);
	})

	function userInfo() {
		$("#tb1").css("display", "none");
		$("#tb2").css("display", "block");
	}

	function index() {
		window.location.reload();
	}

	function goToLogin() {
		window.location.href = "login.action";
	}

	function outLogin() {
		$.ajax({
			type: "post",
			data: "outLogin",
			url: "user/out",
			success: function(result) {
				alert("退出登陆成功！");
				index();
			}
		})
	}

	var uname = '${user.uname}';
	var rname = '${user.rname}';

	if (uname == undefined || uname == null || uname == "") {
		$("#usermanager").css("display", "none");
		$("#uname").attr("onclick", "goToLogin()");
	} else {
		$("#uname").attr("onclick", "");
		$("#uname").text(uname);
		console.log('${user}');
		if (rname == "管理员") {
			$("#admin").css("display", "block");
		}
	}
</script>
</html>
