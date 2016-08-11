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
<!--여기까지 복사  -->

<link rel="stylesheet" type="text/css" href="../css/view.css">

<title>공지사항 리스트</title>
</head>
<body>
	<div class="col-sm-8 text-left">
		<h1>공지사항 리스트</h1>
		<table class="table table-hober">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<!-- foreach 사용여기에 반복문으로 공지사항 리스트를 출력할수 있게끔 한다 -->
				<tr>
					<td>111</td>
					<td>내가 짱이지롱</td>
					<td>손정식</td>
					<td>2016.08.06</td>
					<td>100</td>
				</tr>
				<!--여기까지 반복문  -->
			</tbody>
		</table>
	</div>
</body>
</html>