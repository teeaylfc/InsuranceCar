<%@page import="model.Insurance"%>
<%@page import="dao.InsuranceDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<head>
	<title>Danh sách ô tô</title>
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
						<h3 class="title">DANH SÁCH BẢO HIỂM</h3>
					</div>
					<div class="admin_container ">
						<div class="table-responsive ">
							<table class="table text-center" cellspacing="0">
							    <tr>
							      <th>ID</th>
							      <th>Tên</th>
							      <th>Loại BH</th>
							      <th>Hạn (Ngày)</th>
							      <th>Giá (VNĐ)</th>
							      <th>SL Tồn Kho</th>
							      <th>Hãng (áp dụng)</th> 
							      <th>Mô tả</th>
							      <th>Thao tác</th>
							    </tr>
							    <c:forEach var="list" items="${listIns}">
								   	 <tr>
								    	<td>${list.insuranceID}</td>
								      	<td>${list.name}</td>
								      	<td>${list.type}</td>
								      	<td>${list.exp}</td>
								      	<td>${list.price}</td>
								     	<td>${list.quantityStock}</td>
								      	<td>${list.forBrand}</td>
								     	<td>${list.description}</td>
								    	<td>
							      		<form action="ForwardUpdateInsurance" method = "POST">
						      				<input name="insuranceID" value="${list.insuranceID}" type="hidden">
						      				<button type="submit" class="admin_button green">Sửa</button>	
						      			</form>	
							      		<form action="DeleteInsuranceController" method = "POST">
						      				<input name="insuranceID" value="${list.insuranceID}" type="hidden">
						      				<button type="submit" class="admin_button blue">Xóa</button>	
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