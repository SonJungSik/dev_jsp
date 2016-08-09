<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원의 정보 입력 폼</h2>
	<form method="post" action="../MemberInsert">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"
					value="${memberDto.name}"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"
					value="${memberDto.userid}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"
					value="${memberDto.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="11"
					value="${memberDto.phone}"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td><input type="radio" name="admin" value="1"
					checked="checked"> 관리자 <input type="radio" name="admin"
					value="0"> 일반회원</td>
			</tr>
			<tr>
				<td><input type="submit" value="전송"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>