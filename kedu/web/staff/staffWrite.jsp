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
		<div class="row content" >
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
			<div class="col-sm-8 text-left" style="overflow: auto; height: 690px">
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
					<ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
    <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
    <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
    <li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
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

