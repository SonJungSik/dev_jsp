<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<title>사원등록</title>
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
						<li><a href="#">Projects</a></li>
						<li><a href="#">Contact</a></li>
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
			<!-- 여기부터 contents -->
			<div class="col-sm-8 text-left">
				<h1 class="text-center">사원 등록 페이지</h1>
				<form>
					<table class="table table-hober table-condensed">
						
						<tr>
							<td rowspan="15" class="col-sm-2">
							<img src="../img/jquery.jpg" width="200em" height="200em">
							<br />
							<br />
							<input type="file"></td>
							<th class="col-sm-2">사번</th>
							<td class="col-sm-8"><input type="text" name="stfid"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pwd"></td>
						</tr>
						<tr>
							<th>비밀번호확인</th>
							<td><input type="password" name="pwd"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="stfnm"></td>
						</tr>
						<tr>
							<th>주민번호</th>
							<td><input type="text" name="jumin1">-<input type="text" name="jumin2"></td>
						</tr>
						
						<tr>
							<th>성별</th>
							<td><input type="text" name="gender"></td>
						</tr>
						<tr>
							<th>부서</th>
							<td><input type="text" name="deptid"></td>
						</tr>
						<tr>
							<th>직급</th>
							<td><input type="text" name="jobid"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone"></td>
						</tr>
						<tr>
							<th>입사일</th>
							<td><input type="text" name="entrydt"></td>
						</tr>
						<tr>
							<th>연봉</th>
							<td><input type="text" name="salary"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="salary"></td>
						</tr>
						<tr>
							<th>상세주소</th>
							<td><input type="text" name="salary"></td>
						</tr>
						<tr>
							<th>부서</th>
							<td><input type="text" name="salary"></td>
						</tr>
						<tr>
							<th>직급</th>
							<td><input type="text" name="salary"></td>
						</tr>
					</table>
					<div style="text-align: center"><input type="submit" value="등록"> <input type="button" value="취소">
					</div>
				</form>

			</div>
			<!-- 여기까지 contents -->
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



</body>
</html>