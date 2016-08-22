<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/css/style.css">

<script>
$(function() {
	$("#testDatepicker").datepicker({
		changeMonth: true,
		dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		dayNamesMin: ['월', '화', '수','목','금','토','일'],
		monthNamesShort: ['1','2','3','4','5','6','7', '8','9','10', '11', '12'],
		monthNames: ['1월', '2월', '3월', '4월', '5월','6월','7월','8월','9월','10월','11월','12월']	
	});
});
</script>
</head>
<body>
<p>Date: <input type="text" id="datepicker" size="30"></p>


</body>
</html>