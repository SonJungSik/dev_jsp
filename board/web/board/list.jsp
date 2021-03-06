<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.kedu.common.db.DBManager"%>
<%-- <jsp:useBean id="dbmgr" scope="application" class="com.kedu.common.db.DBManager" /> --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>목록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/css/bootstrap.min.css"
	integrity="sha384-MIwDKRSSImVFAZCVLtU0LMDdON6KVCrZHyVQQj6e8wIEJkW4tvwqXrbMIya1vriY"
	crossorigin="anonymous">
</head>
<body style="font-size: 13px;">
	<h1>목록</h1>
	<%
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		//1.총레코드 수를 구한다.
		int totalRecord = 0;
		try {
			con = DBManager.getConnection();
			sql = "SELECT count(*) FROM brdex";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt(1);
		} catch (SQLException e) {
		} finally {
			DBManager.close(con, stmt, rs);
		}
		//2.페이지당 보일 레코드 수를 결정하고 총 페이지 수를 구한다.
		int numPerPage = 10; //한 페이지에서 보일 레코드 수
		int totalPage = 0; //총 페이지수

		if (totalRecord != 0) {
			if (totalRecord % numPerPage == 0) {
				totalPage = totalRecord / numPerPage;
			} else {
				totalPage = totalRecord / numPerPage + 1;
			}
		}
		//3.첫번째 레코드 번호와 마지막 레코드 번호를 구한다.
		int curPage = request.getParameter("curPage") == null ? 1
				: Integer.parseInt(request.getParameter("curPage"));
		//시작 레코드 계산
		int start = (curPage - 1) * numPerPage + 1;
		//마지막 레코드 계산
		int end = start + numPerPage - 1;
		//해당 페이지의 레코드 셋을 구한 후 출력한다.
		try {
			con = DBManager.getConnection();
			sql = "SELECT no,title,wdate FROM (" + "SELECT ROWNUM R, A.* FROM ("
					+ "SELECT no, title, wdate FROM brdex ORDER BY no DESC) A) " + "WHERE R BETWEEN ? AND ?";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
	%>
	<p>
		<a href="write_form.jsp?curPage=<%=curPage%>">글쓰기</a>
	</p>
	<table class="table table-hover table-sm">
		<thead class="thead-inverse">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (rs.next()) {
						int no = rs.getInt("no");
						String title = rs.getString("title");
						Date wdate = rs.getDate("wdate");
			%>
			<tr>
				<td><%=no%></td>
				<td><a href="view.jsp?no=<%=no%>"><%=title%></a></td>
				<td><%=wdate.toString()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		} catch (SQLException e) {
		} finally {
			DBManager.close(con, stmt, rs);
		}
	%>
	<nav aria-label="page" align="center">
		<ul class="pagination pagination-sm">
			<%
				//4.각 페이지에 대한 직접 이동 링크를 만든다.
				int pagePerBlock = 5; // 블록당 페이지수를 저장할 변수와 초기화
				int block = 1; // 현재 블록 저장 변수와 초기화

				if (curPage % pagePerBlock == 0) {
					block = curPage / pagePerBlock;
				} else {
					block = curPage / pagePerBlock + 1;
				}

				int firstPage = (block - 1) * pagePerBlock + 1;
				int lastPage = block * pagePerBlock;

				int totalBlock = 0;

				if (totalPage > 0) {
					if (totalPage % pagePerBlock == 0) {
						totalBlock = totalPage / pagePerBlock;
					} else {
						totalBlock = totalPage / pagePerBlock + 1;
					}
				}

				int prevPage = 0;
				if (block > 1) {
					prevPage = firstPage - 1;
			%>
			<li class="page-item"><a class="page-link"
				href="list.jsp?curPage=<%=prevPage%>" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> <span class="sr-only">이전</span>
			</a></li>
			<%-- <a href="list.jsp?curPage=<%=prevPage %>">[이전]</a> --%>
			<%
				}

				if (block >= totalBlock) {
					lastPage = totalPage;
				}

				for (int i = firstPage; i <= lastPage; i++) {
			%>
			<li class="page-item"><a class="page-link"
				href="list.jsp?curPage=<%=i%>"><%=i%> <span class="sr-only">(current)</span></a>
			</li>
			<%-- 	<a href="list.jsp?curPage=<%=i %>">[<%=i %>]</a> --%>
			<%
				}

				if (block < totalBlock) {
					int nextPage = lastPage + 1;
			%>
			<li class="page-item"><a class="page-link"
				href="list.jsp?curPage=<%=nextPage%>" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span> <span class="sr-only">다름</span>
			</a></li>
			<%-- <a href="list.jsp?curPage=<%=nextPage %>">[다음]</a> --%>
			<%
				}
			%>
		</ul>
	</nav>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"
		integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
		integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/js/bootstrap.min.js"
		integrity="sha384-ux8v3A6CPtOTqOzMKiuo3d/DomGaaClxFYdCu2HPMBEkf6x2xiDyJ7gkXU0MWwaD"
		crossorigin="anonymous"></script>
</body>
</html>
