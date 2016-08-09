<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>연락처</th>
				<th>권한</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${member.name}</td>
				<td>${member.userid}</td>
				<td>${member.pwd}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.admin}</td>
			</tr>
		</tbody>
	</table>
	<a href="MemberController">회원목록</a>
</body>
</html>