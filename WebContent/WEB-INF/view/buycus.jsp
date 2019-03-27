
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.Customer"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <% Customer c = (Customer) session.getAttribute("customer"); %>
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
				<div><h1>Đăng kí mua bảo hiểm</h1></div>
				<div id="cp1">
					<ul>
						<li>Tên tài khoản :</li>
						<li>Tên bảo hiểm</li>
						<li>Loại bảo hiểm:</li>
						<li>Hạn sử dụng :</li>
						<li>Hãng xe áp dụng:</li>
						<li>Giá:</li>
						<li>Chọn xe:</li>
					</ul>
				</div>
				<form action="registerInsurance" method="POST">
					<div id="cp2">
						<ul>
							<input name="customerID" value=<%=c.getCmID()%> type="hidden">
							<input name="insuranceID" value="${ins.insuranceID}" type="hidden">
							<li><b><%= c.getName() %></b></li>
							<li>${ins.name}</li>
							<li>${ins.type}</li>
							<li>${ins.exp} ngày</li>
							<li>${ins.forBrand}</li>
							<li>${ins.price}</li>
							<li><select name="ownCar">
								<c:forEach var="oc" items= "${listOC}">
									<option value="${oc.carNumber}">${oc.carNumber}</option>
								</c:forEach>
							</select></li>
						</ul>
					</div>
				<p>Lưu ý: Bạn chỉ có thể đăng ký bảo hiểm cho xe có hãng mà bảo hiểm hỗ trợ</p>
				<div id="cp3">
					<button>Xác nhận</button>
				</div>
				</form>
			</div>
			</div>
		</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>