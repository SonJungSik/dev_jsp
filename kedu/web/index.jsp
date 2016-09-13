<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>로그인 페이지</title>


</head>

<body style="background: white;">
<div class="container">

      <form class="form-signin" method="post" action="StaffServlet?command=login">
        <h3 class="form-signin-heading">사원 관리 시스템 </h3>
        <label for="userid" class="sr-only">userid</label>
        <input type="text" id="stfid" name="stfid"  class="form-control" placeholder="사번" required autofocus>
        <label for="password" class="sr-only">password</label>
        <input type="password" id="password"  name="pwd" class="form-control" placeholder="비밀번호" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
 		<div>${message }</div> 
      </form>
      
      </div>
      </body>
</html>