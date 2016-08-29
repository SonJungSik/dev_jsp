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
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Logo</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="StaffServlet?command=notice_list">공지사항</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">사원 관리 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="StaffServlet?command=staff_write_form">사원 등록</a></li>
								<li><a href="StaffServlet?command=staff_list">사원 리스트</a></li>
								<li><a href="#">여긴 뭐하지	</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">프로젝트 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">사원 등록</a></li>
								<li><a href="#">Page 1-2</a></li>
								<li><a href="#">Page 1-3</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><span style="color: white;">${loginUser.stfnm}(${loginUser.stfid})님 안녕하세요 ${loginUser.ismgr }</span><br>
														
								</li>
					</ul>
				</div>
			</div>
		</nav>
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
				<input type="hidden" name="command" value="project_update">
				<input type="hidden" name="pjtid" value="${project.pjtid }">
				<table class="table table-hober">
						<tr>
							<th>프로젝트 명</th>
							<td colspan="3"><input type="text" class="form-control" name="pjtnm" maxlength="50"  value="${project.pjtnm }"></td>
						</tr>
						<tr>
							<th>제안사</th>
							<td colspan="3"><input type="text" class="form-control" name="site" value="${project.site }"></td>
						</tr>
						<tr>
							<th>
								시작일
							</th>
							<td>
								<input type="text" id="startdt" name="startdt" value="${project.startdt }">
							</td>
							<th>
								종료일
							</th>
							<td>
								<input type="text" id="enddt" name="enddt" value="${project.enddt }">
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
					<input type="submit" value="등록"> <input type="button" value="취소">
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

