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
				<form action="UpdateCarController" method="POST"  enctype = "multipart/form-data">
					<input type="hidden" name="carID" value="${car.carID}">
					<p>Tên ô tô</p><input class="text"	type="text" name="nameCar" value="${car.name}">
					<p>Ngày sản xuất</p><input class="text" type="text" name="productDate" value="${car.productDate}">
					<p>Giá xe</p><input class="text" type="text" name="price" value="${car.price}">
					<p>Số lượng</p><input class="text"  type="text" name="quantityStock" value="${car.quantityStock}">
					<p>Mô tả</p><input class="text" type="text" name="description" value="${car.description }">
					<p>Hãng </p><input class="text" type="text" name="brand" value="${car.brand}">
					<p>Ảnh xe: </p><input class="text"  type="file" name="photo">			
					<input class="text" type="hidden" name="imageCar" value="${car.imageCar}">	
					<div class="text-center">
						<button type="submit" class="admin_button blue" >Lưu ô tô</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</div>		
</body>
</html>