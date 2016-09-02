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
				<h4>프로젝트 리스트</h4>
				<table class="table table-hober">
			<thead>
				<tr>
					<th>번호</th>
					<th>프로젝트명</th>
					<th>제안사</th>
					<th>시작일</th>
					<th>종료일</th>
				</tr>
			</thead>
			<tbody>
				<!-- foreach 사용여기에 반복문으로 프로젝트 리스트를 출력할수 있게끔 한다 -->
				<c:forEach var="projectList" items="${projectList}">
				<tr>
					<td>${projectList.pjtid }</td>
					<td><a href="StaffServlet?command=project_detail&pjtid=${projectList.pjtid }">${projectList.pjtnm }</a></td>
					<td>${projectList.site }</td>
					<td>${projectList.startdt }</td>
					<td>${projectList.enddt }</td>
				</tr>
				
				</c:forEach>
				<!--여기까지 반복문  -->
			</tbody>
		</table>
		<div>
			<c:if test="${pageDto.prevPage>0}">
				<span><a href="StaffServlet?command=project_list&curPage=${pageDto.prevPage}">이전</a></span>
			</c:if>
			<c:forEach  var="block" begin="${pageDto.firstPage}" end="${pageDto.lastPage}">
				<a href="StaffServlet?command=project_list&curPage=${block}">${block}</a>
			</c:forEach>
			<c:if test="${pageDto.nextPage>0}">
				<span><a href="StaffServlet?command=project_list&curPage=${pageDto.nextPage}">다음</a></span>
			</c:if>
		</div>
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

