<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题库</title>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
		<style type="text/css">
					body{
						background: -webkit-gradient(linear, left top, left bottom, from(#f1eef9), to(#f5ccf6));
						width: 100wh;
						height: 100vh;
						
					}
					#div1{
						width: 1200px;
						height: 60px;
						margin: 0px auto;
						line-height: 60px;
						text-align: center;
						padding-top: 15px;
					}
					#table1{
						width: 1200px;
						text-align: center;
						margin: 0px auto;
						margin-top: 30px;
						border-radius: 20px;
						
					}
					table tr:nth-child(even){
						background-color:rgb(215,237,233);
					}
					table tr:nth-child(odd){
						background-color:rgb(244,213,233);
					}
					
					tr{
						height:50px
					}
					#div3{
						width:1200px;
						height:40px;
						margin:0px auto;
						font-size: 15px;
						text-align: center;
					}
					#ss{
						 color: var(--tableTextH);
					}
					a{
						color:green
					}
		</style>
</head>
<body>
		<div id="div1">
			<input id="ss"></input> 
			
		</div>
		<div id="div2">
			<table id="table1" cellspacing="0" cellpadding="0">
				<tr>
					<td>题目</td>
					<td>科目</td>
					<td>等级</td>
				</tr>
			</table>
			<div id="div3"><button style="width:1200px;height:40px;backgroud:rgb(178,200,187)" onClick='getData()'>下一页</button></div>
		</div>
	</body>
	<script type="text/javascript">
	
	$('#ss').searchbox({ 
		prompt:'请搜索题目',
		width:1000,
		height:40,
		searcher:function(value,name){ 
			console.log(value,name);
			page.indexpage=1;
			page.pagesize=10;
			page.sumpage=0;
			$.ajax({
				url:"requestion/findQuestion",
				type:"get",
				data:{
					qname:value,
					page:page.indexpage,
					rows:page.pagesize
				},
				success:function(result){
					page.sumpage=result.sum;
					var table1 = document.getElementById("table1");
					var a = table1.firstElementChild.childNodes;
					for (var i = 0; i < a.length; i++) {
						if (i > 1) {
							table1.firstElementChild.removeChild(a[i]);
							i--;
						}
					}
					var list=result?result.rows:null;
					var table=$("#table1");
					console.log(table);
					for(let i=0;i<list.length;i++){
						table.append("<tr><td><a style='text-decoration:none;' href='lookQuestion.jsp?qid="+list[i].qid+"'>"+list[i].qname+"</a></td><td>"+list[i].sname+"</td><td>"+list[i].gname+"</td></tr>");
					}
					if(page.indexpage>page.sumpage){
						$("#div3").html("哎呀！没有更多题目了喔~");
					}else{
						$("#div3").html('<button style="width:1200px;height:40px;backgroud:rgb(178,200,187)" onClick="getData()">下一页</button>')
						page.indexpage++;
					}
				}
			})
		}, 
	}); 
	
	var page = function(indexpage, pagesize, sumpage) {
		this.indexpage = indexpage;
		this.pagesize = pagesize;
		this.sumpage = sumpage;
	}
	
	$(function(){
		page.indexpage=1;
		page.pagesize=15;
		page.sumpage==0;
		getData();
	})
	
	function getData(){
		$.ajax({
			url:"requestion",
			type:"get",
			data:{
				page:page.indexpage,
				rows:page.pagesize
			},
			success:function(result){
				page.sumpage=result.sum;
				console.log(result);
				var list=result?result.rows:null;
				if(list!=null){
					var table=$("#table1");
					console.log(table);
					for(let i=0;i<list.length;i++){
						table.append("<tr><td><a style='text-decoration:none;' href='lookQuestion.jsp?qid="+list[i].qid+"'>"+list[i].qname+"</a></td><td>"+list[i].sname+"</td><td>"+list[i].gname+"</td></tr>");
					}
					if(page.indexpage>page.sumpage){
						$("#div3").html("哎呀！没有更多题目了喔~");
					}else{
						page.indexpage++;
					}
				}
			}
		})
	}
	</script>
</html>