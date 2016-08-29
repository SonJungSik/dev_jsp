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
				<h1>공지사항 수정</h1>
		<form name="frm" method="post" action="StaffServlet">
			<input type="hidden" name="command" value="notice_update">
			<input type="hidden" name="noticeno" value="${notice.noticeno }">
			<table class="table table-hober">
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" class="form-control"
						name="noticetitle" maxlength="50" value="${notice.noticetitle }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${loginUser.stfnm}<input type="hidden" name="stfid"
						value="${loginUser.stfid}"></td>
					<th>부서</th>
					<td><c:choose>
							<c:when test="${notice.deptid==1 }">
								<select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1" selected="selected">총무</option>
									<option value="2">재경</option>
									<option value="3">인사</option>
									<option value="4">기술지원</option>
								</select>
							</c:when>
							<c:when test="${notice.deptid==2 }">
								<select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1">총무</option>
									<option value="2" selected="selected">재경</option>
									<option value="3">인사</option>
									<option value="4">기술지원</option>
								</select>
							</c:when>
							<c:when test="${notice.deptid==3 }">
								<select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1">총무</option>
									<option value="2">재경</option>
									<option value="3" selected="selected">인사</option>
									<option value="4">기술지원</option>
								</select>
							</c:when>
							<c:when test="${notice.deptid==4 }">
								<select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1">총무</option>
									<option value="2">재경</option>
									<option value="3">인사</option>
									<option value="4" selected="selected">기술지원</option>
								</select>
							</c:when>
							
						</c:choose></td>
				</tr>
				<tr>
					<td colspan="4"><textarea class="form-control" rows="30"
							name="contents" >${ notice.contents }</textarea></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="수정"> <input type="button"
					value="목록" onclick="location.href='StaffServlet?command=notice_list'">
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

