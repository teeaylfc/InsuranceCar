<%@page import="model.Insurance"%>
<%@page import="dao.InsuranceDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<head>
	<title>Danh sách bảo hiểm của khách hàng</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1">
</head>
<jsp:include page="ClientHeader.jsp"></jsp:include>
<div class="main">
		<jsp:include page="ClientMenu.jsp"></jsp:include>
			<div id="procontent">
				<div><h1>Danh sách bảo hiểm đã mua</h1></div>
				<div id="vis1">
					<table class="table text-center" >
								  <tr>
							      <th>ID khách hàng</th>
							      <th>Biển số Xe</th>
							      <th>Mã Bảo Hiểm</th>
							      <th>Ngày Đăng Ký</th>
									</tr>
							    <c:forEach var="list" items="${listRI}">
								   	 <tr>
								      	<td>${list.cmID}</td>
								      	<td>${list.carNumber}</td>
								      	<td>${list.insuranceID}</td>
								      	<td>${list.registerDate}</td>
		   							 </tr>
	    						</c:forEach>
						</table>
				</div>
			</div>
			</div>
 <jsp:include page="ClientFooter.jsp"></jsp:include>