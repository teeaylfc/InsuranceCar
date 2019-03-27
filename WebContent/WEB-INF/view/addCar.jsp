<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<html>
<head>
	<title>Thêm Xe</title>
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
				<form action="addCarController" method="POST"  enctype = "multipart/form-data">
				<p>Tên ô tô</p>
				<input class="text" type="text" name="nameCar " required>
				<p>Năm sản xuất</p>
				<input class="text" type="text" name="productDate" required>
				<p>Giá xe</p>
				<input class="text" type="text" name="price" required>
				<p>Số lượng</p>
				<input class="text" type="text" name="quantityStock" required>
				<p>Mô tả</p>
				<input class="text" type="text" name="description" required>
				<p>Hãng </p>
				<div class="opp">
				<select name="brand">
				<c:forEach var="brand" items= "${listB}">
					<option value="${brand.name}">${brand.name}</option>
				</c:forEach>
				</select>
				</div>
				<p>Ảnh xe: </p>
				<input class="text" type="file" name="photo" required>
				<br>
				<div class="text-center">
				<button class="admin_button align" type="submit">Thêm ô tô</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>