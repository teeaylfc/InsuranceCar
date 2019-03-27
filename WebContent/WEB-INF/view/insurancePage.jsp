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
                  <h3>BẢO HIỂM Ô TÔ</h3>
               </div>
               <div id="divi"></div>
               <div id="product-slider">
                  <c:forEach var ="listins" items="${ins}" >
                     <div class="columns">
                        <ul class="price">
                           <li class="header" id="price-head-3">${listins.name}</li>
                           <li class="grey">Giá:${listins.price}</li>
                           <li>Loại : ${listins.type}</li>
                           <li>Thời hạn :${listins.exp} năm</li>
                           <li>Loại Bảo Hiểm :${listins.type}</li>
                           <li>${listins.description}</li>
                           <li class="grey"><a href="registerInsurance?insuranceID=${listins.insuranceID}" class="button-price">Sign Up</a></li>
                        </ul>
                     </div>
                  </c:forEach>
               </div>
            </div>
         </div>
      </div>
    <jsp:include page="ClientFooter.jsp"></jsp:include>