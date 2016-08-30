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
			<h3>공지사항</h3>
				<table class="table table-hober">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>부서명</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- foreach 사용여기에 반복문으로 공지사항 리스트를 출력할수 있게끔 한다 -->
				<c:forEach var="noticeList" items="${noticeList}">
				<tr>
					<td>${noticeList.noticeno }</td>
					<td><a href="StaffServlet?command=notice_detail&noticeno=${noticeList.noticeno }">${noticeList.noticetitle }</a></td>
					<td>${noticeList.stfnm }</td>
					<td>${noticeList.deptnm }</td>
					<td>${noticeList.regdt }</td>
					<td>${noticeList.readcount }</td>
				</tr>
				
				</c:forEach>
				<!--여기까지 반복문  -->
			</tbody>
		</table>
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

