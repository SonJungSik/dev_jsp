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
				<h4>공지사항 등록</h4>
				<form name="frm" method="post" action="StaffServlet">
				<input type="hidden" name="command" value="notice_write">
				<table class="table table-hober">
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" class="form-control" name="noticetitle" maxlength="50" ></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${loginUser.stfnm} <input type="hidden" name="stfid" value="${loginUser.stfid}"></td>
							<th>부서</th>
							<td>
								<select id="deptid" name="deptid">
									<option>부서 선택</option>
									<option value="1">총무</option>
									<option value="2">재경</option>
									<option value="3">인사</option>
									<option value="4">기술지원</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="4"><textarea class="form-control" rows="30" name="contents" ></textarea></td>
						</tr>							
				</table>
				<div>
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

