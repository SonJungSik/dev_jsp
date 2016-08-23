<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>jQuery UI Dialog -Modal form</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/css/style.css">
<style>
body {
	font-size: 62.5%;
}

label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<script>
	$(function() {
		var dialog, form, emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
				[]).add(name).add(email).add(password), tips = $(".validateTips");
		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}
		function checkLength(o, n, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips(n + " 은(는) " + min + " 에서 " + max + "자까지 입력해 주세요.");
				return false;
			} else {
				return true;
			}
		}
		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}
		function addUser() {
			var valid = true;
			allFields.removeClass("ui-state-error");
			valid = valid && checkLength(name, "이름", 3, 16);
			valid = valid && checkLength(email, "이메일", 6, 80);
			valid = valid && checkLength(password, "비밀번호", 5, 16);
			valid = valid
					&& checkRegexp(name, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i,
							"성명은 3자에서 16자 이내로 작성해 주세요");
			valid = valid
					&& checkRegexp(email, emailRegex, "eg. ui@jquery.com");

			valid = valid
					&& checkRegexp(email, emailRegex, "eg. ui@jquery.com");
			valid = valid
					&& checkRegexp(password, /^([0-9a-zA-Z])+$/,
							"Password는 영문자 소문자, 숫자 5~15 허용합니다. : a-z 0-9");
			if (valid) {
				
				
				//document.getElementById("frm").submit();
				$("#frm").submit();
				dialog.dialog("close");
				
			}
			return valid;
		}
		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			buttons : {
				"회원등록" : addUser,
				"취소" : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
				tips.text("모든 필드에 입력해 주세요").removeClass("ui-state-highlight");
			}
		});
		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			addUser();
		});
		$("#create-user").button().on("click", function() {
			dialog.dialog("open");
		});
	});
</script>
</head>
<body>
	<div id="dialog-form" title="회원등록">
		<p class="validateTips">모든 필드에 입력해 주세요</p>
		<form action="MemberServlet" id="frm" name="frm" method="post">
			<fieldset>
				<input type="hidden" name="command" value="member_write">
				<label for="name">이름</label> <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all"	placeholder="성명 입력">
				<label for="email">Email</label> <input	type="text" name="email" id="email" placeholder="이메일 입력" class="text ui-widget-content ui-corner-all"> 
				<label for="password">Password</label> <input type="password" name="pwd" id="password" placeholder="비밀번호 입력"	class="text ui-widget-content ui-corner-all">
				<!--Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
	<div id="users-contain" class="ui-widget">
		<h1>회원 현황</h1>
		<table id="users" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header ">
					<th>이름</th>
					<th>이메일</th>
					<th>비밀번호</th>
				</tr>
			</thead>
			<tbody>
				<!-- 반복 -->
				<c:forEach var="memberList" items="${memberList }">
					<tr>
						<td>${memberList.name}</td>
						<td>${memberList.email }</td>
						<td>${memberList.pwd }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<button id="create-user">회원 등록</button>
</body>
</html>
