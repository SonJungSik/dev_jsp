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
						<li><a href="#">About</a></li>
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
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								Login</a></li>
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
				<h4>사원 리스트</h4>
				<table class="table table-hober">
					<thead>
						<tr>
							<th>사번</th>
							<th>성명</th>
							<th>직급</th>
							<th>부서</th>
							<th>전화번호</th>
							<th>입사일</th>
							<th>수정</th>
						</tr>
					</thead>
					<tbody>
						<!-- foreach 사용여기에 반복문으로 공지사항 리스트를 출력할수 있게끔 한다 -->
						<c:forEach var="staffList" items="${staffList }">
						<tr>
							<td>${staffList.stfid }</td>
							<td>${staffList.stfnm }</td>
							<td>${staffList.jobnm }</td>
							<td>${staffList.deptnm }</td>
							<td>${staffList.phone }</td>
							<td>${staffList.entrydt }</td>
							<td><a href="StaffServlet?command=staff_update_form&stfid=${staffList.stfid }">수정</a></td>
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

