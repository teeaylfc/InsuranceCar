<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Admin Login</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>

<body class="login">
	<div class="loginbox">
		<div  class="login_title">
		<h1>Đăng Nhập</h1>
		</div>
		<img src="images/avatar.jpg" class="login_img" sizes="150 150">
		<form action="adminLogin" method="POST">
		<c:if test = "${error != null }">
			<div id="error" class="align">
				<p class="text-center"> ${error}</p>
			</div>
		</c:if>
		<p>Tài khoản</p>
		<input class="text" type="text" placeholder="&nbsp;Enter Username" name="adminAccount">
		<p>Mật khẩu</p>
		<input class="text" type="Password" placeholder="&nbsp;Enter Password" name="adminPassword">
		<button class="btnlogin">Đăng nhập</button><br>
		</form>
		<div class="align">
		</div>
		
	</div>
</body>
</html>