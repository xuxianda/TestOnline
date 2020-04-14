<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>考试</title>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
	</head>
	<body>
		<h1>开始作答</h1>
		<%
			Map<Integer,String> key = new HashMap();
		%>
	</body>
	<script>
		$(function() {
			$.ajax({
				type: "post",
				url: "exam/1",
				data: "json",
				success: function(result) {
					console.log(result);
				}
			})
		})
	</script>
</html>
