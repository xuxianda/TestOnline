<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>这里是修改界面</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css">
<link href="css/te.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>		

<style>
	.xxx{
		margin: 30px;
	}
	.xx{
		line-height:10px; 
	}
</style>
	</head>

<body>
			
         <!-- <div style="text-align: right" >
				<a href = "testpaperList.jsp" ><input class="btn btn-default" type="button" value="退出本页面" "/></a>	
         </div> -->
         
         <div style="height:40%">
            <table class="table table-hover xxx" style="text-align: center" ">
            
                <tr >
                    <td><input type="text" id="tname" name="tname" class="form-control" value="" ></td>
                    <td ><input class="btn btn-default" type = "button" name = "tname" value = "试卷名称"></td>
                </tr>
                
                <tr>
                	<td></br></td>
                </tr>
                
                <tr >
                    <td><input type="text" id="time" name="time" class="form-control" value="" ></td>
                    <td ><input class="btn btn-default" type = "button" name = "time" value = "考试时长"></td>
                </tr>
                
            </table>
            
          </div>   
             
  <div class="container" style="width:100%">
    <table id="tb">
    	<tr>
        	<td id="Add" class="easyui-linkbutton"  >添加题目</td>
        	<td id="Del" class="easyui-linkbutton"  >删除题目</td>
        <tr>
    </table>
    
  <table id="td" class="table table-hover table table-bordered" style="width:100%">
  </table>
  
</div>
             
             <table class="table table-hover " style="text-align: center">
                <tr>
                    <td ><input id="OK" class="btn btn-default" type="button" value="提交" /></td>
                    <td ><a href = "testpaperList.jsp" ><input class="btn btn-default" type="button" value="返回" "/></a></td>
                </tr>
			</table>
	
<script>
		document.getElementById("tname").value =   sessionStorage.getItem("tname"); 
		document.getElementById("time").value =   sessionStorage.getItem("time"); 
		var tid = sessionStorage.getItem("tid");
		var sid = sessionStorage.getItem("sid");
		
		$("#td").datagrid({
			title: '试卷题目',
			url: 'paper/quest?tid='+tid,
			method: 'get',
			pagination: true,
			columns:[
				[{
					field:'',
					checkbox:true
				},{
					field: 'qorder',
					title: '试卷编号',
					width: '7%',
					align: 'center'
				},{
					field: 'qname',
					title: '题目名称',
					width: '10%',
					align: 'center'
				},{
					field: 'score',
					title: '题目分值',
					width: '7%',
					align: 'center'
				},{
					field: 'a',
					title: 'A',
					width: '11%',
					align: 'center'
				},{
					field: 'b',
					title: 'B',
					width: '11%',
					align: 'center'
				},{
					field: 'c',
					title: 'C',
					width: '11%',
					align: 'center'
				},{
					field: 'd',
					title: 'D',
					width: '11%',
					align: 'center'
				},{
					field: 'qkey',
					title: '正确答案',
					width: '7%',
					align: 'center'
				},{
					field:'sname',
					title:'科目',
					width:'8%',
					align:'center'
				},{
					field:'tyname',
					title:'题目类型',
					width:'8%',
					align:'center'
				},{
					field:'gname',
					title:'难度',
					width:'8%',
					align:'center'
				}
				]
				
			]
		});
		 
		
		document.getElementById("Add").onclick = function(){
			
			$("#Del").hide();
			console.log("======"+sid);
			
			
			
			$("#td").datagrid({
		 		url:'paper/type',
		 		type:'get',
		 		pagination: true,
		 		queryParams:{
		 			tid:tid,
		 			sid:sid
		 		}
		 	});
			
			}
		
		document.getElementById("OK").onclick = function(){
			
			console.log("===ok===");
			var rows = $('#td').datagrid('getChecked');
			
			
			if (rows.length == 0) {
				console.log("OK1");
				var tname = $("#tname").val();
				var time = $("#time").val();
				var index = 5;
				$.ajax({
					url:'paper?index='+index,
					type:'POST',
					dataType : 'json',
					data:{
						_method:'PATCH',
						tid:tid,
						tname:tname,
						time:time
					},
					success:function(xx){
						if (xx) {
							alert("-- 修改完成");
	window.location.href="${sessionScope.path}/TestOnline/testpaperList.jsp";
						}else{
							alert("--  错误");
						}
					}
				});
				
		
				
			}else{
				
				console.log("OK1");
				var tname = $("#tname").val();
				var time = $("#time").val();
				var index = 5;
				$.ajax({
					url:'paper?index='+index,
					type:'POST',
					dataType : 'json',
					data:{
						_method:'PATCH',
						tid:tid,
						tname:tname,
						time:time
					}
				});
				
		/* ----------------------------------------------- */
			var paper = [];
			for (var i = 0; i < rows.length; i++) {
				paper.push(rows[i].qid);
			}
			var index = 3;
			$.ajax({
				url:'paper?index='+index+'&'+'tid='+tid,
				type:'POST',
				dataType : 'json',
				data:{
					_method:'PATCH',
					paper:JSON.stringify(paper)
				},
				success:function(xx){
					if (xx) {
						alert("-- 完成");
	window.location.href="${sessionScope.path}/TestOnline/testpaperList.jsp";
					}else{
						alert("--  错误");
					}
				}
			});
		}
		}
		
			
		document.getElementById("Del").onclick = function(){
			
			var rows = $('#td').datagrid('getChecked');
			
			if (rows.length == 0) {
				alert("-- 你还未选择要删除的题目 --");
			}else{
				var paper = [];
				for (var i = 0; i < rows.length; i++) {
					paper.push(rows[i].qid);
				}
				
				console.log("被选中的题目编号----  "+paper);
				
					var index = 4;
						$.ajax({
							url:'paper?index='+index+'&'+'tid='+tid,
							type:'POST',
							datatype:'json',
							data:{
								_method:'PATCH',
								paper:JSON.stringify(paper)
							},
							success:function(xx){
								if (xx) {
									alert("-- 删除完成");
								}else{
									alert("-- 删除失败");
								}
							}
						});
			}
		}

</script>

	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
</body>
</html>