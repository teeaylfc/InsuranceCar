<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bảo hiểm</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
				<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<div><h1>Thông tin bảo hiểm đã mua</h1></div>
				<div id="vis1">
					<table class="table">
							    <tr>
							      <th>ID khách hàng</th>
							      <th>Biển số Xe</th>
							      <th>Mã Bảo Hiểm</th>
							      <th>Ngày Đăng Ký</th>
							      <th>Trạng Thái</th>
							      <th></th>
							    </tr>
							    <tr>
								    	<td>123</td>
								      	<td>12bx-56625</td>
								      	<td>2</td>
								      	<td>26/2/2019</td>
								      	<td>CHưa kích hoạt</td>
								 </tr>
					</table>
				</div>
			</div>
			</div>
		</div>
<jsp:include page="ClientFooter.jsp"></jsp:include>