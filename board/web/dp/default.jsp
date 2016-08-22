<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuuery UI Datepicker - Default functionality</title>
<link rel="stylesheet" href="../css/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="../js/jquery-ui.js"></script>
<link rel="stylesheet" href="/css/style.css">
<script>
$(function(){
	$("#datepicker").datepicker();
});
</script>
</head>
<body>
	<p>Date: <input type="text" id="datepicker"></p>
</body>
</html>