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
	<h1>회원목록</h1>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>연락처</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td><a href="MemberDetail?userid=${member.userid}">${member.name}</a></td>
					<td>${member.userid}</td>
					<td>${member.phone}</td>
					<td>${member.admin}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>