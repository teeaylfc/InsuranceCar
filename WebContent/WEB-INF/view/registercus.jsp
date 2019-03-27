<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí tài khoản</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>

<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
	<div id="regzone">
		<div id="regis">
				<c:if test = "${error != null }">
					<div id="error" class="align">
						<p class="text-center"> ${error}</p>
					</div>
				</c:if>
				<form action="register" method="POST">
					<div id="dktk">
					<h1>Đăng kí tài khoản</h1></div>
					<p><b>Tên tài khoản: </b></p>
					<input type="text" class="regtext" placeholder="Nhập tên tài khoản" required name="account"><br>
					<p><b>Mật khẩu:</b></p>
					<input type="password" class="regtext"  placeholder="Nhập mật khẩu" id="password" required name="password"><br>
					<p><b>Nhập lại mật khẩu:</b></p>
					<input type="password" class="regtext"  placeholder="Nhập mật khẩu" id="confirm_password" required><br>
					<p><b>Họ và tên :</b></p>
					<input type="text"  class="regtext" placeholder="Nhập họ và tên" required name="name"><br>
					<p><b>Giới tính:</b></p>
					  	<input type="radio" class="gt" name="gender" value="nam" checked> Nam
  						<input type="radio" class="gt" name="gender" value="nu"> Nữ<br>
  					<p><b>Ngày sinh</b></p>
  					<input type="date" name="dob" value="1997-10-23" min="1930-01-01" max="2018-12-31">
  					<p><b>Địa chỉ:</b></p>
  					<input type="text"  class="regtext" placeholder="Nhập địa chỉ" name="address" required><br>
  					<p><b>Số điện thoại:</b></p>
  					<input type="text"  class="regtext" placeholder="Nhập số điện thoại" name="phone" required><br>
  					<br>
					<button id="btnreg">Đăng kí tài khoản</button>
				</form>
		</div>
	</div>
</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>