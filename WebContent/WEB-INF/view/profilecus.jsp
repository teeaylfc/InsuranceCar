<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Customer"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <% Customer c = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
<link rel="stylesheet" type="text/css" href="css/index.css">


</head>
<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
		<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<div id="tite"><h1>Thông tin tài khoản</h1></div>
				<div id="pct1">
					<ul>
						<li>Họ và tên :</li>
						<li>Giới tính :</li>
						<li>Ngày sinh :</li>
						<li>Địa chỉ :</li>
						<li>Số điện thoại :</li>
					</ul>
				</div>
				<div id="pct2">
					<ul>
						<li><b><%= c.getName() %></b></li>
						<li><b><%= c.getGender()%></b></li>
						<li><b><%= c.getDob()%></b></li>
						<li><b><%= c.getAddress() %></b></li>
						<li><b><%= c.getPhone() %></b></li>
					</ul>
				</div>
			</div>
			</div>
		</div>
 <jsp:include page="ClientFooter.jsp"></jsp:include>