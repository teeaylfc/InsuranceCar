<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<head>
	<title>Danh sách khách hàng</title>
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
						<h3 class="title  ">DANH SÁCH KHÁCH HÀNG</h3>
					</div>
					<div class="admin_container ">
						<div class="table-responsive ">
							<table class="table text-center" cellspacing="0">
								<tr>
							      	<th> Tên </th>
							      	<th>Giới tính</th>
							      	<th>Địa chỉ</th>
							      	<th>Số điện thoại</th>
							      	<th>Ngày sinh</th>
							      	<th>Action</th>
						    	</tr>
						      	<c:forEach var="list" items="${listCus}">
								   	 <tr>
								    	<td>${list.name}</td>
								      	<td>${list.gender}</td>
								      	<td>${list.address}</td>
								      	<td>${list.phone}</td>
								      	<td>${list.dob}</td>
								    	<td>
							      		<form action="customers" method = "POST">
						      				<input name="cmID" value="${list.cmID}" type="hidden">
						      				<input name="action" value="delete" type="hidden">
						      				<button type="submit" class="admin_button green">Xóa</button>	
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