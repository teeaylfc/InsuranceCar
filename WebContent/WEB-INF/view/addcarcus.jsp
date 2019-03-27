<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <%Customer c = (Customer) session.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí mua bảo hiểm</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
		<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<c:if test = "${error != null }">
					<div id="error" class="align">
						<p class="text-center"> ${error}</p>
					</div>
				</c:if>
				<div><h1>Thêm xe của bạn</h1></div>
				<div id="cp1">
					<ul>
						<li>Chủ xe:</li>
						<li>Hãng xe :</li>
						<li>Biển số :</li>
						<li>Số chỗ :</li>
						<li>Tình trạng đăng ký BH :</li>
					</ul>
				</div>
				<form action="addOwnCar" method="POST">
					<div id="cp2">
						<ul>
							<li><b><%= c.getName() %></b></li>
							<li><input type="text" placeholder="Nhập tên hãng xe" name="brand" required></li>
							<li><input type="text" placeholder="Nhập biển số" name="carNumber" required></li>
							<li><input type="number" placeholder="Nhập số chỗ ngồi" name="numberOfSeat" required min="4" max="16" value="4"></li>
							<li>
								<input class ="cci" type="radio"  name="haveInsurance" value="1" > Đã đăng ký
	  							<input class ="cci" type="radio"  name="haveInsurance" value="0" checked> Chưa đăng ký
							</li>
						</ul>
					</div>
					<div id="cp3">
						<button>Xác nhận</button>
					</div>
				</form>
			</div>
			</div>
		</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>