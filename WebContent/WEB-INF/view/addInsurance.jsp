<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Thêm Bảo Hiểm</title>
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
				<form action="AddInsuranceController" method="POST">
					<p>Tên bảo hiểm</p>
					<input class="text"	type="text" name="name">
					<p>Loại bảo hiểm</p>
					<input class="text" type="text" name="type">
					<p>Exp</p>
					<input class="text" type="text" name="exp">
					<p>Giá bảo hiểm</p>
					<input class="text" type="text" name="price">
					<p>Quantity</p>
					<input class="text" type="text" name="quantityStock">
					<p>Hãng </p>
					<input class="text" type="text" name="forBrand">
					<p>Mô tả</p>
					<input class="text" type="text" name="description">
					<div class="text-center">
						<button class="admin_button blue ">Thêm </button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>