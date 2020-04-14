<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试排名</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<style  type="text/css">
			body{
				background: -webkit-gradient(linear, left top, left bottom, from(#f1eef9), to(#f5ccf6));
				width: 100wh;
				height: 100vh;
			}
			#div1{
				border-bottom: 2px solid gray;
				height: 60px;
				font-size:25px;
				font-weight: bold;
				color: gray;
				line-height: 60px;
			}
			#div2{ 
				width: 1500px;
				margin: 0px auto;
				height:630px;
				border:1px solid gray;
				margin-top: 20px;
			}
			#table1 {
				width: 1500px;
				text-align:center;
			}
			#table1 tr{
				height: 50px;
			}
			#div3{
				width: 1500px;
				height: 50px;
				border: 1px solid black;
			}
			
			a{
				text-decoration: none;
				color: rgb(174,178,183);
			}
			a:hover{
				color: rgb(255,108,96);
				cursor: pointer;
			}
			#ye1{
				width:1200px;
				height:50px
				border:1px solid black;
				float: left;
			}
			#yeye{
				width:300px;
				height:50px
				border:1px solid black;
				float: left;
				color:gray;
			}
		</style>
	</head>
	<body>
			<div id="div1">考试排名</div>
			<div id="div2">
				<table cellpadding="0" cellspacing="0" id="table1">
				<tr>
					<td>试卷名称</td>
					<td>考试时长</td>
					<td>总分</td>
				</tr>
			</table>
			</div>
				<div div="div3">
					<div id="ye1">
					<a id="shouye" onclick="getFirst(1,10)">首页</a> 
					<a onclick="getPre();">上一页</a> 
					<a onclick="getNext();">下一页</a> 
					<a onclick="getLast();">最末页</a>
					</div>
					<div id="yeye"></div>
				</div>
				
	</body>
	<script type="text/javascript">
	getFirst(1, 10)
	var page = function(indexpage, pagesize, sumsize, sumpage) {
		this.indexpage = indexpage;
		this.pagesize = pagesize;
		this.sumsize = sumsize;
		this.sumpage = sumpage;
	}
	function del() {
		var table1 = document.getElementById("table1");
		var a = table1.firstElementChild.childNodes;
		for (var i = 0; i < a.length; i++) {
			if (i > 1) {
				table1.firstElementChild.removeChild(a[i]);
				i--;
			}
		}
	}
	function getFirst(indexpage, pagesize) {
		del();
		getPost(indexpage, pagesize);
	}
	function getLast() {
		del();
		getPost(page.sumpage, page.pagesize);
	}

	function getNext() {
		if (page.indexpage < page.sumpage) {
			del();
			getPost(page.indexpage + 1, page.pagesize);
		}
	}
	function getPre() {
		if (page.indexpage > 1 && page.indexpage <= page.sumpage) {
			del();
			getPost(page.indexpage - 1, page.pagesize);
		}
	}

	function getPost(indexpage, pagesize) {
		var table1 = document.getElementById("table1");
		$.ajax({
			url:"studentTest/getMyTest",
			type:"get",
			data:{
				page:indexpage,
				rows:pagesize
			},
			success:function(result){
				page.indexpage=indexpage;
				page.pagesize=pagesize;
				page.sumpage=result.sum;
				page.sumsize=result.total;
				console.log(result);
				var list=result?result.rows:null;
					var table=$("#table1");
					console.log(table);
					for(let i=0;i<list.length;i++){
						table.append("<tr><td><a href='allTestStudent.jsp?tid="+list[i].tid+"&tname="+list[i].tname+"'>"+list[i].tname+"</a></td><td>"+list[i].time+"</td><td>"+list[i].tsum+"</td></tr>");
					}
					var yeye=document.getElementById("yeye");
					yeye.innerHTML="当前第"+page.indexpage+"页   每页条"+page.pagesize+" 共"+page.sumsize+"条  总"+page.sumpage+"页";
			}
		})
	}
    </script>
</html>
