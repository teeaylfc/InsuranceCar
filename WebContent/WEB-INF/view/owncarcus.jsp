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
				<div><h1>Thông tin ô tô của bạn</h1></div>
				<div id="vis1">
					<table class="table">
							    <tr>
							      <th>Hãng</th>
							      <th>Biển số</th>
							      <th>Số chỗ</th>
							      <th>Bảo hiểm</th>
							      <th>Quản lý</th>
							    </tr>
							   <c:forEach var="oc" items="${listOC}">
						      	<tr>
									<td>${oc.brand}</td>
									<td>${oc.carNumber}</td>
									<td>${oc.numberOfSeat}</td>
									<c:choose>
									    <c:when test="${oc.haveInsurance == 1}">
									       <td> Đã đăng ký</td> 
									    </c:when>    
									    <c:otherwise>
									        <td> Chưa đăng ký</td>
									    </c:otherwise>
									</c:choose>
									<td>
					      			<form action="editOwnCar" method = "GET">
					      				<input name="owncarID" value="${oc.owncarID}" type="hidden">
					      				<button type="submit" class="">Sửa</button>	
					      			</form>
					      			<form action="delOwnCar" method = "POST">
					      				<input name="owncarID" value="${oc.owncarID}" type="hidden">
					      				<button type="submit" class="">Xóa</button>	
					      			</form>
					      			</td>
								</tr>
								</c:forEach>
					</table>
				</div>
			</div>
			</div>
		</div>
<div id="footer">
	<div id="footzone">
		<div class="ft">
			
			<ul>
				<l1><h1>Giới thiệu</h1></l1>
				<li><a href="#">Hướng dẫn mua hàng</a></li>
				<li><a href="#">Hướng dẫn thanh toán</a></li>
				<li><a href="#">Hướng dẫn dịch vụ</a></li>
				<li><a href="#">Chỉnh sửa thông tin cá nhân</a></li>
			</ul>
		</div>
		<div class="ft">
			<ul>
				<l1><h1>Chính sách</h1></l1>
				<li><a href="#">Chính sách bảo mật</a></li>
				<li><a href="#">Chính sách bảo hành</a></li>
				<li><a href="#">Chính sách hậu mãi</a></li>
				<li><a href="#">Quy định sử dụng</a></li>
			</ul>
		</div>
		<div class="ft">
			<ul>
				<l1><h1>Hỗ trợ</h1></l1>
				<li><a href="#">Tìm kiếm</a></li>
				<li><a href="#">Liên hệ</a></li>
				<li><a href="#">Đăng nhập</a></li>
				<li><a href="#">Đăng kí</a></li>
			</ul>
			
		</div> 
		<div id="ftdk">
				<p><b>Đăng kí nhận thông tin :</b></p>
				<input type="text" id="" placeholder="Email của bạn">
				<button id="">Gửi</button>
			</div>
			<div id="ftlogo">
				<img src="images/logo.png">
			</div>

	</div>
</div>
		<c:if test = "${delError != null }">
			<script>
				alert("Xóa xe thất bại!");
			</script>
		</c:if>
</body>
</html>