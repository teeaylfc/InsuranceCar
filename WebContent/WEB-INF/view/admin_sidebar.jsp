<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>sidebar admin</title>
	<link rel="stylesheet" type="text/css" href="style2.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>	
	<div id="section-left">
		<div id="user-box">
			<div class="avatar">
				<img src="images/avatar.jpg" alt="" width="100px"	height="100px">
				<div class="username"><h3>Hello</h3></div>
			</div>
			
		</div>
		<div id="admin_menu">
			<ul>
				<li><a href="#">Quản lý bảo hiểm
					<ul class="sub-menu">
						<li><a href="AddInsuranceController">Thêm bảo hiểm</a></li>
						<li><a href="ListInsurancesController">Danh sách bảo hiểm</a></li>
					</ul>
					</a>
				</li>
				<li>
					<a href="#">Quản Lý ô tô</a>
					<ul class="sub-menu">
						<li><a href="ListCarsController">Danh sách ô tô</a></li>
						<li><a href="addCarController">Thêm Ô tô</a></li>
					</ul>
				</li>
				<li><a href="customers">Quản lý người dùng</a></li>
				<li>
					<a href="#">Quản lý đăng ký bảo hiểm
						<ul class="sub-menu">
							<li><a href="manageRegisterInsurances?status=pending">Bảo hiểm chờ đăng ký</a></li>
							<li><a href="manageRegisterInsurances?status=registered">Bảo hiểm đã đăng ký</a></li>
						</ul>
					</a>
				</li>
			</ul>
		</div>
	</div>
<!-- <!DOCTYPE html>
<html>
<head>
<head>
	<title>sidebar admin</title>
	<link rel="stylesheet" type="text/css" href="style2.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<div id="admin_menu">
	<ul>
		<li>
			<a href="ListInsurancesController">Quản lý bảo hiểm</a>
			<ul class="sub-menu">
				<li><a href="AddInsuranceController">Thêm bảo hiểm</a></li>
			</ul>
		</li>
		<li>
			<a href="ListCarsController">Quản Lý ô tô</a>
			<ul class="sub-menu">
				<li><a href="addCarController">Thêm xe</a></li>
			</ul>
		</li>
		<li><a href="#">Quản lý khác</a></li>
	</ul>
</div>
</body>
</html> -->