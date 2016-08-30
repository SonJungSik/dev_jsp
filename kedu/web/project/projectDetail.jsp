<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">

<!--페이지마다 복사  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="../../css/view.css" rel="stylesheet" type="text/css">

<!-- 달력위한 것듯 -->
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript">
$( function() {
    $( "#startdt" ).datepicker({
    	dateFormat: 'yy-mm-dd',
    	changeMonth: true,
    	dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
    	dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
    	monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
    	monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
    	 	
    });
    
    $( "#enddt" ).datepicker({
    	dateFormat: 'yy-mm-dd',
    	changeMonth: true,
    	dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
    	dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
    	monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
    	monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
    	 	
    });
});
</script>
</head>
<body>

	<div class="container-fluid text-center">
		<%@ include file="../header.jsp" %>
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<h4>프로젝트 등록</h4>
				<form name="frm" method="post" action="StaffServlet">
				<input type="hidden" name="command" value="project_update_form">
				<input type="hidden" name="pjtid" value="${project.pjtid }">
				<table class="table table-hober">
						<tr>
							<th>프로젝트 명</th>
							<td colspan="3">${project.pjtnm }</td>
						</tr>
						<tr>
							<th>제안사</th>
							<td colspan="3">${project.site }</td>
						</tr>
						<tr>
							<th>
								시작일
							</th>
							<td>
								${project.startdt }
							</td>
							<th>
								종료일
							</th>
							<td>
								${project.enddt }
							</td>
						</tr>
						<tr>
							<th>요구스킬</th>
							<td><input type="checkbox" value="1">JAVA
								<input type="checkbox" value="2">Servlet/JSP
								<input type="checkbox" value="3">Sprint/iBatis Framework
								<input type="checkbox" value="4">HTML5
								<input type="checkbox" value="5">CSS
							</td>
						</tr>
						<tr>
							<th>상세내용</th>
							<td colspan="3"><textarea class="form-control" rows="20" name="contents" >${project.contents }</textarea></td>
						</tr>							
				</table>
				<div align="center">
					<input type="submit" value="수정"> <input type="button" value="취소">
				</div>
				</form>	
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>채팅</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
		<footer class="container-fluid text-center">
			<p>Footer Text</p>
		</footer>
	</div>

</body>
</html>

