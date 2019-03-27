<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <%
		String success = request.getAttribute("success") + "";
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
		<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
		<div id="login">
			<div id="loginleft">
				<div id="dntk">
					<h1>ĐĂNG NHẬP TÀI KHOẢN</h1></div>
					<c:if test = "${error != null }">
						<div id="error" class="align">
							<p class="text-center"> ${error}</p>
						</div>
					</c:if>
					<form action="login" method="POST">
						<p><b>Tên tài khoản: </b></p><br>
						<input type="text" class="textlog" placeholder="Nhập tên tài khoản" name="account" required>
						<p><b>Mật khẩu:</b></p>
						<input type="password" class="textlog" placeholder="Nhập mật khẩu" name="password" required>
					
						<button id="btnlogin">Đăng nhập</button>
						<div id= "linkregzone" >
						<a id="linkregcus" href="register">Nếu bạn chưa có tài khoản? Click vào đây </a>
						</div>
					</form>
					
			</div>
			<div id="loginright">
				<p>Bạn quên mật khẩu? Nhập số điện thoại hoặc email để lấy lại mật khẩu.</p>
				<p><b>Email hoặc số điện thoại:</b></p>
				
				<input type="text" placeholder="Nhập email hoặc số điện thoại">
			
				<button>Lấy lại mật khẩu</button>
			</div>
			<div></div>
		</div>
		</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>