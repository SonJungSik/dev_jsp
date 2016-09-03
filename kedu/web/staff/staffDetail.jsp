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
				<h4>상세정보 입력</h4>
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a data-toggle="tab" href="#home">학력사항</a></li>
                                        <li><a data-toggle="tab" href="#menu1">경력사항</a></li>
                                        <li><a data-toggle="tab" href="#menu2">자격증</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="home" class="tab-pane fade in active">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>학교명</th>
                                                    <th>입학일자</th>
                                                    <th>졸업일자</th>
                                                    <th>전공</th>
                                                    <th>졸업구분</th>
                                                    <th>성적</th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="menu1" class="tab-pane fade">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>직장명</th>
                                                    <th>입사일</th>
                                                    <th>퇴사일</th>
                                                    <th>최종직위</th>
                                                    <th>담당업무</th>
                                                    <th>월급여</th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="menu2" class="tab-pane fade">
                                            <table class="table table-hober table-condensed">
                                                <tr>
                                                    <th>자격증명</th>
                                                    <th>자격증번호</th>
                                                    <th>취득일</th>
                                                </tr>
                                            </table>
                                        </div>
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

