<%@page import="model.Insurance"%>
<%@page import="dao.InsuranceDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<head>
	<title>Bảo hiểm đang chờ kích hoạt</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
	<jsp:include page="admin_sidebar.jsp"></jsp:include>
	<jsp:include page="admin_header.jsp"></jsp:include>
	<div id="admin_content">
		<div class="show-info bg-white">
			<div class="total col-2" id="total-car">
				<h3>1000 Xe</h3>
			</div>
			<div class="total col-2" id="total-user">
				<h3>1000 Xe</h3>
			</div>
			<div class="total col-2" id="total-insur">
				<h3>1000 Xe</h3>
			</div>
			<div class="total col-2" id="total-post">
				<h3>1000 Xe</h3>
			</div>

		</div>
		<div id="error" class="align">
			<p class="text-center"><strong>Lỗi rồi!</strong> xin kiểm tra lại</p>
		</div>
		<div class="admin_block"> 
			<div class="admin_container bg-white">
				<div class="show-item">
					<div class="text-center">
						<h3 class="title">DANH SÁCH BẢO HIỂM CHỜ ĐĂNG KÍ</h3>
					</div>
					<div class="admin_container ">
						<div class="table-responsive ">
							<table class="table text-center" cellspacing="0">
							    <tr>
							      <th>ID khách hàng</th>
							      <th>Biển số Xe</th>
							      <th>Mã Bảo Hiểm</th>
							      <th>Ngày Đăng Ký</th>
							      <th>Trạng Thái</th>
								  <th>Thao tác</th>
							    </tr>
							    <c:forEach var="list" items="${listPI}">
								   	 <tr>
								      	<td>${list.cmID}</td>
								      	<td>${list.carNumber}</td>
								      	<td>${list.insuranceID}</td>
								      	<td>${list.registerDate}</td>
								     	<td>Chờ kích hoạt</td>
								    	<td>
						      			<form action="manageRegisterInsurances" method ="POST">
						      				<input name="riID" value="${list.riID}" type="hidden">
						      				<input name="action" value="destroy" type="hidden">
						      				<button type="submit" class="admin_button green">Hủy</button>	
						      			</form>	
							      		<form action="manageRegisterInsurances" method ="POST">
						      				<input name="riID" value="${list.riID}" type="hidden">
						      				<input name="action" value="active" type="hidden">
						      				<button type="submit" class="admin_button blue">Kích Hoạt</button>	
						      			</form>
		      						  	</td>
		   							 </tr>
	    						</c:forEach>
	  						</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>				
</body>
</html>