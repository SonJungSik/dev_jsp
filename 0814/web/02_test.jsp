<%@page import="com.kedu.member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDao memDao=MemberDao.getInstance();
	Connection conn = memDao.getConnection();
	out.println("DBCP 연동 성공");
%>

</body>
</html>