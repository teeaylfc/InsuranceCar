<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <% Customer c = (Customer) session.getAttribute("customer"); %>
<div id="profile">
				<div id="promenu">
					<div id="prousername">
					<ul>
						<li>Xin chào :</li>
						<li><b><%= c.getName() %></b></li>
					</ul>
				</div>
				<div id="myacc"><h1>Tài khoản của tôi</h1></div>
				<ul id="menubar">
					<li><img src="images/iconmenu1.jpg" width="30px" id="iconmenu"> <a href="myprofile"><b>Thông tin tài khoản</b></a>
						<ul>
						<li><a href="changeProfile">Sửa thông tin tài khoản</a></li>
						<li><a href="changePassword">Thay đổi mật khẩu</a></li>
					</ul>
					</li>
					
					<li><img src="images/iconmenu2.jpg" width="30px" id="iconmenu"><a href="myInsurance" ><b>Bảo hiểm đã mua</b></a></li>
										<li><img src="images/iconmenu3.jpg" width="30px" id="iconmenu"><a href="insurancePage"><b>Đăng kí mua bảo hiểm</b></a></li>
					<li><img src="images/iconmenu4.jpg" width="30px"id="iconmenu"><a href="myOwnCars"><b>Ô tô của bạn</b></a>
						<ul>
						<li><a href="myOwnCars">Thông tin ô tô sở hữu</a></li>
						<li><a href="addOwnCar">Thêm ô tô</a></li>
					</ul>
				</ul>
				
				</div>
			<c:if test ="${changeProfileSuccess!=null }">
				<div id="error-area">
					<p>
						Cập nhật thông tin cá nhân thành công!
					</p>
				</div>
			</c:if>