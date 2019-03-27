<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <% Customer c = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin tài khoản</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
				<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<div><h1>Chỉnh sửa thông tin tài khoản</h1></div>
				<div id="cp1">
					<ul>
						<li>Tên tài khoản :</li>
						<li>Họ và tên :</li>
						<li>Giới tính</li>
						<li>Ngày sinh :</li>
						<li>Địa chỉ :</li>
						<li>Số điện thoại :</li>
					</ul>
				</div>
				<form action="changeProfile" method="POST">
					<div id="cp2">
						<ul>
							<li><b><%= c.getAccount() %></b></li>
							<li><input type="text" placeholder="Nhập họ tên" name="name" required value="<%= c.getName() %>"></li>
							<li id = "radioselect">
									<input type="radio" class="gt" name="gender" value="nam" checked"> Nam
		  							<input type="radio" class="gt" name="gender" value="nu""> Nữ 	<br>
		  					</li>
		  					<li><input type="date" name="dob" value="<%= c.getDob() %>" min="1930-01-01" max="2018-12-31" required></li>
							<li><input type="text" placeholder="Nhập địa chỉ" name="address" value="<%= c.getAddress()%>" required></li>
							<li><input type="text" placeholder="Nhập số điện thoại" name="phone" value="<%= c.getPhone() %>" required></li>
						</ul>
					</div>
					<div id="cp3">
						<button>Cập nhật tài khoản</button>
					</div>
				</form>
				
			</div>
			</div>
		</div>
	<jsp:include page="ClientFooter.jsp"></jsp:include>