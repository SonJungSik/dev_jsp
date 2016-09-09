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
<!-- 달력위한 것듯 -->
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
	$("#entdt").datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일','일요일'],
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8','9', '10', '11', '12'],
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월','8월', '9월', '10월', '11월', '12월']
	});
	$("#grddt").datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일','일요일'],
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8','9', '10', '11', '12'],
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월','8월', '9월', '10월', '11월', '12월']
	});
	/* 달력 끝 */ 
	
	$(".delbutton").on("click",function(){
		alert($(this).attr("id"));
		
		var acaid=$(this).attr("id");
		$.ajax({
        	url:"StaffServlet?command=aca_del",
        	type:"post",
        	data: inputData,
        	dataType:"json",
        	success: function(result){
        				
        	}
        });
	});
	$("#acasubmit").click(
			function(event) {
				var stfid = $("#stfid");
				var acanm = $("#acanm");
				var entdt = $("#entdt")
				var grddt = $("#grddt");
				var major = $("#major");
				var grd_yn = $("#grd_yn");
				var grade = $("#grade");
				var regnm = $("#regnm");
							
				
				var inputData = new Object();
				//alert(pText.val());
				
				inputData.stfid=stfid.val();
				inputData.acanm=acanm.val();
				inputData.entdt=entdt.val();
				inputData.grddt=grddt.val();
				inputData.major=major.val();
				inputData.grd_yn=grd_yn.val();
				inputData.grade=grade.val();
				inputData.regnm=regnm.val();
				

			
				var acatext = '<tr>'
					+ '<td>'
					+ acanm.val()
					+ '</td>'
					+ '<td>'
					+ entdt.val()
					+ '</td>'
					+ '<td>'
					+ grddt.val()
					+ '</td>'
					+ '<td>'
					+ major.val()
					+ '</td>'
					+ '<td>'
					+ grd_yn.val()
					+ '</td>'
					+ '<td>'
					+ grade.val()
					+ '</td>'
					+ '<td>'
					+ "<input type='button' value='삭제' class='button'>"
					+ '</td>'
					+ '</tr>';
					
						$.ajax({
                        	url:"StaffServlet?command=aca_write",
                        	type:"post",
                        	data: inputData,
                        	dataType:"json",
                        	success: function(result){
                        	}
                        });		
                		$('#acatable').append(acatext);
                		$("#acanm").val("");
						$("#entdt").val("");
						$("#grddt").val("");
						$("#major").val("");
						$("#grade").val("");
			});


});
</script>
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
				<h4>상세정보 입력</h4>
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">학력사항</a></li>
					<li><a data-toggle="tab" href="#menu1">경력사항</a></li>
					<li><a data-toggle="tab" href="#menu2">자격증</a></li>
				</ul>

				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						<form class="form-inline" >
						<table class="table table-hober table-condensed" id="acatable">
							<tr>
								<th>학교명</th>
								<th>입학일자</th>
								<th>졸업일자</th>
								<th>전공</th>
								<th>졸업구분</th>
								<th>학점</th>
								<th>추가/삭제</th>
							</tr>
							
							<tr>
								
								<td><input type="text" name="acanm" id="acanm" class="form-control">
								<input type="hidden" name="regnm" id="regnm" value="${loginUser.stfnm}">
								<input type="hidden" name="stfid" id="stfid" value="${stfid}">
								</td>
								<td><input type="text" name="entdt" id="entdt" class="form-control"></td>
								<td><input type="text" name="grddt" id="grddt" class="form-control"></td>
								<td><input type="text" name="major" id="major" class="form-control" ></td>
								<td><input type="radio" name="grd_yn" id="grd_yn" value="Y">Y <input type="radio" name="grd_yn" id="grd_yn" value="N">N</td>								
								<td><input type="text" name="grade" id="grade" class="form-control" size="2">/4.5</td>
								<td><input type="button" value="추가" class="button" name="acasubmit" id="acasubmit">
								</td>
								<c:forEach items="${detailList}" var="detailList">
									<tr >
										<td>${detailList.acanm}	</td>
										<td>${detailList.entdt}	</td>
										<td>${detailList.grddt}	</td>
										<td>${detailList.major}	</td>
										<td>${detailList.grd_yn}</td>
										<td>${detailList.grade}</td>
										<td><input type="button" class="delbutton" value="삭제" id="${detailList.acaid }" class="button"></td>
										
									</tr>
								</c:forEach>
							</tr>
						</table>
						</form>
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

