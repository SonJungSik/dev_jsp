<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
$(function() {
	$("#tabs").tabs({
	event : "mouseover",
	collapsible : true
	});
});
</script>
</head>
<body>
<div id="tabs">
<ul>
	<li><a href="#tabs-1">경력사항	</a></li>
	<li><a href="#tabs-2">학력</a></li>
	<li><a href="#tabs-3">자격증</a></li>
</ul>
<div id="tabs-1">
	<p>경력사항 입력 폼</p>
</div>
<div id="tabs-2">
	<p>학력 입력 폼</p>
</div>
<div id="tabs-3">
	<p>자격증 입력 폼</p>
</div>
</div>
</body>
</html>