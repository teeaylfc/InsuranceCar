<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
		<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
	<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<div><h1>Thay đổi mật khẩu</h1></div>
				<div id="cp1">
					<ul>
						<li>Mật khẩu cũ :</li>
						<li>Mật khẩu mới :</li>
						<li>Nhập lại mật khẩu mới :</li>
					</ul>
				</div>
				<form action="changePassword" method="POST">
					<div id="cp2">
						<ul>
							<li><input type="password" placeholder="Nhập mật khẩu cũ" required name="oldpassword"></li>
							<li><input type="password" placeholder="Nhập mật khẩu mới" id="password" required name="newpassword"></li>
							<li><input type="password" placeholder="Nhập lại mật khẩu mới" id="confirm_password" required></li>
						</ul>
					</div>
					<div id="cp3">
						<button>Đổi mật khẩu</button>
					</div>
				</form>
				
			</div>
			</div>
		</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>