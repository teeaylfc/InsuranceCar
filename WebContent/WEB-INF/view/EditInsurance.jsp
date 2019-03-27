<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sửa Bảo Hiểm</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<jsp:include page="admin_sidebar.jsp"></jsp:include>
<jsp:include page="admin_header.jsp"></jsp:include>
<div id="admin_content">
	<div class="admin_container">
		<div class="login">
			<div class="loginbox">
				<form action="UpdateInsuranceController" method="POST">
					<input 	type="hidden" class="text" name="insuranceID" value="${ins.insuranceID}">
					<p>Tên bảo hiểm</p><input class="text"	type="text" name="name" value="${ins.name}">
					<p>Loại bảo hiểm</p><input class="text" type="text" name="type" value="${ins.type}">
					<p>Exp</p><input class="text" type="text" name="exp" value="${ins.exp}">
					<p>Giá bảo hiểm</p><input class="text" type="text" name="price" value="${ins.price}">
					<p>Quantity</p><input class="text" type="text" name="quantityStock" value="${ins.quantityStock}">
					<p>Hãng </p><input class="text" type="text" name="forBrand" value="${ins.forBrand}">
					<p>Mô tả</p><input class="text" type="text" name="description" value="${ins.description}">
					<div class="text-center">
						<button class="admin_button blue">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>	
</div>	
</body>
</html>