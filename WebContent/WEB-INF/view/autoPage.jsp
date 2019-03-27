<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html>
   <head>
      <title>Trang chủ</title>
   </head>
   <link rel="stylesheet" type="text/css" href="css/index.css">
 <jsp:include page="ClientHeader.jsp"></jsp:include>
      <div id="main">
         <div class="container">      
            <div id="block2">
               <div id="divi"></div>
               <div id="title-block" class="container">
                  <h3>ĐỒ CHƠI - PHỤ KIỆN - TRANG TRÍ Ô TÔ</h3>
               </div>
               <div id="divi"></div>
               <div id="product-slider">
                  <c:forEach var="list" items="${cars}">
                     <div id="product-box">
                        <h4>${list.name}</h4>
                        <img src="images/${list.imageCar}">
                        <p class="price-product">${list.price}</p>
                        <p class="desc">${list.description}</p>
                        <button>Xem chi tiết</button>
                     </div>
                  </c:forEach>
               </div>
            </div>
            
         </div>
      </div>
   <jsp:include page="ClientFooter.jsp"></jsp:include>