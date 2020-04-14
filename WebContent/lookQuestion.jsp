<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				width:300px;
				height:200px;
				margin: 0px auto;
			}
	</style>
</head>
<body>
	
	<div id="div1">
		
	</div>
	
</body>
	<script type="text/javascript">
	       var query = window.location.search.substring(1);
	       console.log(query);
	       var pair = query.split("=");
           var qid=pair[1];
           console.log(qid);
           $.ajax({
        	   url:"requestion/getBeanQuestion",
        	   type:"get",
        	   data:{
        		   qid:qid,
        	   },
        	   success:function(result){
        		   if(result.tyname=="解答题"){
        			   $("#div1").append("<p>题目："+result.qname+"</p><p style='text-indent:30px'>正确答案："+result.qkey+"</p>"	  ); 
        		   }else{
        		  $("#div1").append("<p>分值："+result.score+"</p><p>题目："+result.qname+"</p><p>a:"+result.a+"</p><p>b:"+result.b+"</p><p>c:"+result.c+"</p><p>d:"+result.d+"</p><p>正确答案："+result.qkey+"</p>" );
        		   }
        	   }
           });
	</script>
</html>