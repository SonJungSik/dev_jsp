<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--페이지마다 복사  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--여기까지 복사  -->
<title>공지사항  상세</title>

</head>
<body>
<div class="col-sm-8 text-left">
		<h1>공지사항 상세</h1>
		<table class="table table-bordered">
				<tr>
					<th>작성자</th> <td>손정식</td>
					<th>글번호</th> <td>111</td>
				</tr>
				<tr>
					<th>작성일</th> <td>2016.08.06</td>			
					<th>조회수</th> <td>100</td>			
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">내가 짱이지롱</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">글이 뭐가 있나?</td>
				</tr>					</table>
		<p align="center">
		<input type="button" class="btn" value="수정">
		<input type="button" class="btn" value="삭제">
		<input type="button" class="btn" value="목록으로">
		</p>
		<p>
		댓글 - 댓글 개수
		</p>
		<table class="table" >
			<tr>
				<td align="left">손정식 2016.08.06 22:40:42 <br>
				 댓글 내용이 들어감</td>
				<td><input type="button" class="btn" value="수정">
				<input type="button" class="btn" value="삭제"></td>
			</tr>
		</table>
		
	</div>
</body>
</html>