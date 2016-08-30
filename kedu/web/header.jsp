<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				<li class="active"><a href="StaffServlet?command=main_view">Home</a></li>
				<li><a href="StaffServlet?command=notice_list">공지사항</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">사원 관리 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="StaffServlet?command=staff_write_form">사원 등록</a></li>
						<li><a href="StaffServlet?command=staff_list">사원 리스트</a></li>
						<li><a href="#">여긴 뭐하지 </a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">프로젝트 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="StaffServlet?command=project_write_form">프로젝트 등록</a></li>
						<li><a href="StaffServlet?command=project_list">프로젝트 리스트</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><span style="color: white;">${loginUser.stfnm}(${loginUser.stfid})님
						안녕하세요 ${loginUser.ismgr }</span><br></li>
			</ul>
		</div>
	</div>
</nav>