<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--jquery文件-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!--easyui核心文件-->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!--对应的语言包-->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!--对应的语言包-->
<script type="text/javascript" src="js/summernote[1].js"></script>
<!--皮肤文件-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<!--图标文件-->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css" />
<style>
#addAname {
	border:none; 
	border-bottom: 1px solid #000;
	height:50px;
	background: 0 0;
	margin-top:20px;
	
}

#addauthor {
	margin-top: 100px;
	border:none; 
	border-bottom: 1px solid #000;
	height:50px;
	background: 0 0;
}

#texts {
	margin-top: 100px;
	height:200px;
	width: 500px;
	
}

#addbutton {
	margin-top: 50px;
	height:40px;
	width:60px;
	text-align:center;
	border:0px 0px 1px 0px;
	
	
}

#add-div-announ {
	margin-top: 10px;
	font-size: 40px;
	height:50px;
	widht:80px;
}

.aa {
	height: 50px;
	width: 300px;
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
#sp{
  float:left;
  margin-top: 100px;
}

</style>
</head>
<body style="height:100%;width:100%;/* background-image: url(img/bj3.jpg.jpg);background-size:100% 100%; */">
<div id="big-cent-div-announ-top">
			<div id="big-ceng-div-announ-log">
				<a href="index.jsp" target="首页" id="aa">首页 &nbsp;&nbsp;</a> |
				<a href="studyArea.action" target="资料" id="aa">资料&nbsp;&nbsp; </a> |
				<a href="#" target="考试介绍" id="aa">考试介绍&nbsp;&nbsp; </a> | 
				<a href="#" target="考试规范" id="aa">考试规范&nbsp;&nbsp;</a>| 
				<a href="examinationRank.action" target="考试排名" id="aa">考试排名&nbsp;&nbsp; </a> |
			    <a href="http://localhost:8080/TestOnline/#tr2"target="项目介绍" id="aa">项目介绍 &nbsp;&nbsp;</a> |
			</div>
		</div>
	<div id="add-div-announ">
		标题： <input type="text" id="addAname" class="aa" placeholder="输入标题"
			required /><br />
			<input type="hidden" id="getuid" value="${user.uid}">
	          作者： <input type="text" id="addauthor" class="aa"
			placeholder="输入作者" required /><br /> 
			<div id="texs-div">
	          <span id="sp"> 内容：</span>
		<textarea id="texts" style="overflow: scroll; overflow-x: hidden;"
			placeholder="公告内容" required="required "></textarea>
			</div>
		<br /> <input type="button" id="addbutton" value="提交">
	</div>
</body>
<script>
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
		var uid=$("#getuid").val();
		
		if(aid>0){//公告修改
			$.ajax({
				url:"announcement/singleObject",
				type:'get',
				data:{
					'aid':aid
				},
				success: function(result) {
					$("#addAname").val(result.aname);
					$("#addauthor").val(result.author);
					$("#texts").val(result.avalue);
				},
				
			});
			  //提交修改
			$("#addbutton").click(function(){
				var aname=$("#addAname").val();
			    var author=$("#addauthor").val();
				var avalue=$("#texts").val();
				$.ajax({
					url:"announcement",
					type:'post',
					data:{
						_method:'put',
						'aid':aid,
						'aname':aname,
						'author':author,
						'avalue':avalue
					},
					success: function(result) {
						alert("提交修改成功！");
						window.location.href="announcement.jsp"
					}
					
				});
			})
		
		}else{//公告添加
			$("#addbutton").click(function(){
				var aname=$("#addAname").val();
			    var author=$("#addauthor").val();
				var avalue=$("#texts").val();
				$.ajax({
					url:'announcement',
					type:'post',
					data:{
						'uid':uid,
						'aname':aname,
						'author':author,
						'avalue':avalue
					},
					success: function(result) {
						alert("提交修改成功！");
						window.location.href="announcement.jsp"
					}
						
				});
			})
		}
		
		 var E = window.wangEditor
	     //获取到咱们的编辑器位置
	     var editor = new E('#texts')
	     //获到取相应的元素(提交的intro元素)
	    //监听编辑器的修改事件(html就是编辑器中的内容)
	     editor.customConfig.onchange = function (html) {
	         //console.debug(html)
	         //把富文框的内容放进去
	         txtIntro.val(html);
	     };
	     // 创建对应的编辑器
	     editor.create();
		
		
	})



</script>
</html>