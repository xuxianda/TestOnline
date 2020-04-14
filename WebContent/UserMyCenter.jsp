<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<!-- saved from url=(0044)http://demo.demohuo.top/modals/50/5083/demo/ -->
<html>
<style>
	#user{
	position: absolute;
	overflow:hidden;
	text-indent:10em;
	margin-top: 30px;
	}
	.no-doc{
	position: relative;
	}
	
	.text{
	-web-kit-appearance:none;
		-moz-appearance: none;
		font-size:1.4em;
		height:2.0em;
		border-radius:5px;
		border:1px solid #c8cccf;
		color:#6a6f77;
		outline:0;
	};
	#sex{
		width:100px;
		height:30px;
	}


.no-doc>div:last-child{ margin-top:32px; height:20px; position: relative; top:-30px}
.no-doc>div:last-child>a 
{
    
 
    text-decoration:none;
	background:#62ab00;
	color:#f2f2f2;
	
	padding: 10px 30px 10px 30px;
	font-size:16px;
	font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
	font-weight:bold;
	border-radius:3px;
	
	-webkit-transition:all linear 0.30s;
	-moz-transition:all linear 0.30s;
	transition:all linear 0.30s;
	
	}
.no-doc>div:last-child>a:hover { background:#2e4a31; }




</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<title>后台用户中心</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/iconfont.css">
		<script type="text/javascript" src="js/echarts.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>

	<body style="width:100%;height:100%">
		<div class="header">
			<div class="bar">
				<div class="w1200">
					<span class="l">在线考试系统<font>用户中心</font></span>
					<span class="r"><a href="index.jsp"><i class="icon iconfont icon-dianyuan"></i>退出</a></span>
				</div>
			</div>
			<div class="user-info">
				<div class="w1200">
					<div class="user-headface">
						<img src="./img/user_face.jpg">
					</div>
					<div class="user-account">
					
						<p class="tip"><span class="dateText"></span>，${user.username}</p>
						<p class="account">
							<span>帐户名：${user.username}</span>
							<span>用户：${user.uname}</span>
							
						</p>
						<span class="dateTime"></span>
					</div>
					
				</div>
				
			</div>
		</div>
		<div class="main w1200">
			<div class="left">
				<ul>
					<li>
						<a class="active" onclick="Userquery()">
							<i class="icon iconfont icon-lingdang"></i>
							查看个人信息
						</a>
					</li>
					<li>
						<a onclick="examQuery()">
							<i class="icon iconfont icon-fangzidichan"></i>
							查看考试记录
						</a>
					</li>
					<li>
						<a onclick="updateUser()">
							<i class="icon iconfont icon-wenda"></i>
							修改个人信息
						</a>
					</li>
				</ul>
			</div>
			<div class="right">
				<div class="tap">
					<span>个人信息</span>
				</div>
				<div class="container">
					<div class="no-doc">
					 <img src="./img/no_doc.jpg">
					
						
							
					</div>
					 
				</div>
			</div>
		</div>
	<script type="text/javascript">
	
	
	function updateUser(){
		$(".tap").html("修改信息");
		$(".no-doc").empty();
		$(".no-doc").append("用户名：<input type='text' class='text' id='username' value='${username}' required><br/><br/>")
		$(".no-doc").append("旧密码：<input type='password' class='text' id='pwd' value='${password}' required><br/><br/>");
		$(".no-doc").append("新密码：<input type='password' class='text' id='rpwd' required><br/><br/>");
		$(".no-doc").append("确定密码：<input type='password' class='text' id='rqpwd' required><br/><br/>");
		$(".no-doc").append("&emsp;&emsp;姓名：<input type='text' class='text' id='name' value='${uname}' required><br/><br/>")
		$(".no-doc").append("性别：<select id='sex'></select><br/><br/>	")
		$("#sex").append("<option value='男' selected='selected'>男</option>");
		$("#sex").append("<option value='女'>女</option>");
		$(".no-doc").append("<div><a>提交</a></div>");
	}
	
	function save(){
			var username=$("#username").val();
			var pwd=$("#pwd").val();
			var rpwd=$("#rpwd").val();
			var rqpwd=$("#rqpwd").val();
			var name=$("#name").val();
			var sex=$("#sex").val();
			console.log(username+""+pwd+""+sex+""+name);
			$.ajax({
				url:"stu",
				type:"post",
				data:{
					username:username,
					password:rpwd,
					name:name,
					gender:sex,
					pwd:pwd
				},
				success:function(data){
					alert(1111)
					if(data == false){
						alert("修改失败,新旧密码不一致");
					}else{
						if(rpwd == rqpwd){
						alert("修改成功");							
						}else{
						alert("俩次新密码不一致");
						}
					}
				}
			})
		
			
	}
	function examQuery(){
		$(".tap").html("考试记录");
		console.log(123);
		$.ajax({
			url:"stu/utest",
			type:"get",
			success:function(data){
				console.log(data);
			}
		})
	}
	
	
	function Userquery(){
		$(".tap").html("个人信息");
		$(".no-doc").empty();
		$(".no-doc").append("<p id='user'>用户名 ：${user.username }</p><br/><br/><br/>")
		$(".no-doc").append("<p id='user'>姓名 ：${user.uname }</p><br/><br/><br/>")
		$(".no-doc").append("<p id='user'>性别 ：${user.gender }</p><br/><br/><br/>")
		$(".no-doc").append("<p id='user'>积分：${user.integral}</p><br/><br/><br/>")
	}
	
	 $(".dateTime").everyTime("3s",writeCurrentDate());
	function writeCurrentDate() {
        var now = new Date();
        var year = now.getFullYear(); //得到年份
        var month = now.getMonth();//得到月份
        var date = now.getDate();//得到日期
        var day = now.getDay();//得到周几
        var hour = now.getHours();//得到小时
        var minu = now.getMinutes();//得到分钟
        var sec = now.getSeconds();//得到秒
    	var MS = now.getMilliseconds();//获取毫秒
        var week;
        month = month + 1;
        if (month < 10) month = "0" + month;
        if (date < 10) date = "0" + date;
        if (hour < 10) hour = "0" + hour;
        if (minu < 10) minu = "0" + minu;
        if (sec < 10) sec = "0" + sec;
        if (MS < 100) MS = "0" + MS;
        var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
        week = arr_week[day];
        var time = "";
        time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;
        //当前日期赋值给当前日期输入框中（jQuery easyUI）
        console.log(hour)
        if( hour > 12 && hour< 18){
        	$(".dateText").text("下午好");
        }else if(7<= hour && hour <12){
        	$(".dateText").text("早上好");
        }else if(hour == 12){
        	$(".dateText").text("中午好");
        }else if(18 <= hour && hour<=24){
        	$(".dateText").text("晚上好");
        }else if(hour < 7){
        	$(".dateText").text("凌晨好");
        }
        $(".dateTime").html(time);
        //设置得到当前日期的函数的执行间隔时间，每1000毫秒刷新一次。
        var timer = setTimeout("writeCurrentDate()", 6000);
      }
	
		
	</script>

</body></html>