<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
      <div id="header">
         <div class="container">
            <div id="logo">
               <img src="images/logo.png">
            </div>
            <div id="images/header-img">
               <img src="images/banner-header.jpg" height="120px" align="right">
            </div>
         </div>
         <div class="clear"></div>
         <div id="main-menu">
            <div class="container">
               <ul>
                  <li><a href="#" class="cate">Danh mục sản phẩm</a></li>
                  <li><a href="homeforward">Trang chủ</a></li>
                  <li><a href="#">Giới thiệu</a></li>
                  <li><a href="autopage">Ôtô</a></li>
                  <li><a href="insurancePage">Bảo hiểm</a></li>
                  <li><a href="#">Video</a></li>
                  <li><a href="#">Liên hệ</a></li>
                 
			    	<% if(session.getAttribute("customer")==null) { %>
			       		<li id="headerbtnLogin" style="border :1px solid #fff"><a href="login">Đăng nhập</a></li> 
	    			<% }else {%>
	    				<li><a href="myprofile" style="border :1px solid #fff">Profile</a></li>
			        	<li style="border :1px solid #fff"><a href="logout">Đăng xuất</a></li>
					<% } %>			
               </ul>
            </div>
         </div>
      </div>