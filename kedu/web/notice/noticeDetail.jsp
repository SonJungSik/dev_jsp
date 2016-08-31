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
		<%@ include file="../header.jsp"%>
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
				<h4>공지사항 상세</h4>
				<form>
					<input type="hidden" name="command" value="notice_write">
					<table class="table table-hober ">
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" class="form-control"
								name="noticetitle" maxlength="50" readonly="readonly"
								value="${notice.noticetitle }"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${notice.stfnm}</td>
							<th>부서</th>
							<td>${notice.deptnm }</td>
						</tr>
						<tr>
							<th>작성일
							<td>${notice.regdt }
							<th>조회수</th>
							<td>${notice.readcount}</td>
						</tr>
						<tr>
							<td colspan="4"><textarea class="form-control" rows="30"
									name="contents" readonly="readonly">${notice.contents }</textarea></td>
						</tr>
					</table>
					<!-- 댓글 테이블 -->
					<div>
						<div id=replye_view>
							<table id="replytable" class="table table-condensed">
							<!-- 댓글 자리 -->
							<c:forEach items="${replyList }" var="replyList">
								<tr>
									<td colspan=2>
										<strong> ${replyList.stfnm }</strong>
										<a style="cursor:pointer;"  name="replytDel" > 삭제</a>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															${replyList.contents } <br>
										</p>
									</td>
								</tr>
							</c:forEach>
							</table>
						</div>
						<div id=reply_input>
							<table class="table table-condensed">
								<tr>
									<td><span class="form-inline" role="form"> <input
											type="text" id="replyname" name="replyname"
											class="form-control col-lg-2" data-rule-required="true"
											placeholder="이름" maxlength="10" value="${loginUser.stfnm }">
											<input type="hidden" id="stfid" value="${loginUser.stfid }">
											<input type="hidden" id="noticeno" value="${notice.noticeno }">
											<button type="button" id="replysubmit" name="replysubmit"
												class="btn btn-default">확인</button> <textarea
												id="replycontents" name="replycontents"
												class="form-control col-lg-12" style="width: 100%" rows="4"></textarea>
									</span></td>
								</tr>
							</table>
							<script>
								$(function() {

									$("#replysubmit")
											.click(
													function(event) {
														var stfid = $("#stfid");
														var pName = $("#replyname")
														var pText = $("#replycontents");
														var noticeno = $("#noticeno");
														var inputData = new Object();
														//alert(pText.val());
														inputData.stfid=stfid.val();
														inputData.contents=pText.val();
														inputData.noticeno=noticeno.val();
	
														

														if ($.trim(pName.val()) == "") {
															alert("이름을 입력하세요.");
															pName.focus();
															return;
														} else if ($.trim(pText
																.val()) == "") {
															alert("내용을 입력하세요.");
															pText.focus();
															return;
														}
														var replytext = '<tr>'
															+ '<td colspan=2>'
															+ '<strong>'
															+ pName.val()
															+ '</strong> '
															+ ' <a style="cursor:pointer;" name="replytDel">삭제</a><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
															+ pText.val().replace(/\n/g,"<br>")
															+ '</p>'
															+ '</td>'
															+ '</tr>';

																$.ajax({
										                        	url:"StaffServlet?command=reply_write",
										                        	type:"post",
										                        	data: inputData,
										                        	dataType:"json",
										                        	success: function(result){
										                        	}
										                        });		
								                        		$('#replytable').append(replytext);
								                        		$("#replyname").val("");
																$("#replycontents").val("");
													});
								});
							</script>
						</div>
					</div>
					<!-- 댓글 테이블 종료  -->
					<div align="center">
						<input type="button" value="수정"
							onclick="location.href='StaffServlet?command=notice_update_form&noticeno=${notice.noticeno}'">
						<input type="button" value="삭제"
							onclick="location.href='StaffServlet?command=notice_delete&noticeno=${notice.noticeno}'">
						<input type="button" value="목록으로">
					</div>
				</form>

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

