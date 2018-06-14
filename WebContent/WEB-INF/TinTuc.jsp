<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="Bean.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>News</title> 
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!--bootstrap & Jquery-->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--Icon fa-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="css/mycssHome.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHome1.css"/>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>
	<link rel="stylesheet" type="text/css" href="css/News.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHome1.css"/>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	
	
	<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
</head>
<body>
	<!--
			==============================Hearder====================================
	-->
	<div class="container">
		<div class="topbar">
			<div id="menu">
				<ul>
					<%if(session.getAttribute("account")!=null)
						{ Account acc=(Account)session.getAttribute("account");
						%>
					<li class="dropdown">
    					<button class="btn btn_account dropdown-toggle" type="button" data-toggle="dropdown">
    						<img src="<%= acc.getAvatar() %>" class="img_avatar img-responsive" alt="Cinque Terre"/>
    						<span  class="dropbtn"><%=acc.getName() %></span>
					    	<span class="caret"></span>
						</button>
					    <ul class="dropdown-menu">
					      <li ><a href="ThongTinTaiKhoan?roleID=${account.role_id}">Thông tin tài khoản</a></li>
					      <li><a href="logout">Đăng xuất</a></li>
					    </ul>
					</li>		
					<%}else{ %>					
					<li class="dropdown">
						<span  class="dropbtn">TÀI KHOẢN</span>
						<div class="dropdown-content">
						    <a href="login">Đăng nhập</a>
						    <a href="Register_account">Đăng ký</a>
						</div>
					</li>			
					<%} %>						
					<li class="sdt"><span class="glyphicon glyphicon-earphone"></span>(+84)98777777 </li>
					<li class="gmail"><span class="	glyphicon glyphicon-envelope"></span>ITCENTER2017@GMAIL.COM</li>
				</ul>
			</div>
		</div>
		<header id="header">
			<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="30">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="TrangChu">
							<img style="width: 220px;padding-top: 10px;" src="images/TC.png" />
						</a>
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>
					</div>
					
					<div class="collapse navbar-collapse" >
						<ul class="nav navbar-nav navbar-right">  
							<li class="dropdown"><a href="TrangChu">TRANG CHỦ</a></li>     
							<li class="dropdown">
								<a href="Course?topic_id=0" class="dropdown-toggle" data-toggle="dropdown">KHÓA HỌC<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="Course?topic_id=0">Các khóa học</a></li>
									<li><a href="LichKhaiGiang">Lịch khai giảng</a></li>          
								</ul>
							</li>
							<li class="active">
								<a href="News">TIN TỨC</a>
								
							</li> 
							<%if(session.getAttribute("account")!=null)
							{Account acc=(Account)session.getAttribute("account");%>
							<li>
								<a href="user_thaoluan">THẢO LUẬN</a>
							</li> 
							<%}else{ %>	
							<li>
								<a href="thaoluan">THẢO LUẬN</a>
							</li> 
							<%} %> 
							<li><a href="Contact">LIÊN HỆ</a></li>
							<li class="dropdown">
								<a ><span class="glyphicon glyphicon-search"></span></a>
								<ul class="dropdown-menu">
									<li>
										<input type="text" id="timkiem" placeholder="Tìm kiếm">
									</li>
								</ul>
							</li>
						</ul>
						
					</div>
				</div><!--end container-->
			</nav><!--end nav-->
		</header><!--end header-->
	</div>
	<!--
			==============================CONTENT====================================
	-->
	
		<!-- Slider -->
		<div class="header-page">
		<div class="header-content" style="text-align: right;">
			<h1 >Tin tức</h1>		
		</div>
		</div>

	<!-- //top-header and slider -->
	<div class="container">
		<div class="banner-btm-agile">
		<!-- cột bên trái-->
			<div class="col-md-9 btm-wthree-left">
				<c:forEach items="${news}" var="list_news">
					<div class="wthree-top">
						<div class="w3agile-top">
							<div class="w3agile_special_deals_grid_left_grid">
								<a href="News_Info?news_id=${list_news.news_id }"><img src="${list_news.image }" class="img-responsive" alt="" /></a>
							</div>
							<div class="w3agile-middle">
							<ul>
								<li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i>${list_news.date }</a></li>
							</ul>
						</div>
						</div>
						
						<div class="w3agile-bottom">
							<div class="col-md-3 w3agile-left">
								<c:forEach items="${typenews}" var="list_type">
								<c:if test="${list_news.type_id==list_type.type_id }">
									<h5>${list_type.typename }</h5>
								</c:if>
								</c:forEach>
							</div>
							<div class="col-md-9 w3agile-right">
								<c:set var = "content" value = "${fn:substring(list_news.content_news, 0, 197)}" />
								<h3><a href="News_Info?news_id=${list_news.news_id }">${list_news.title }</a></h3>
								<p>${content }...</p>
								<a class="agileits w3layouts" href="News_Info?news_id=${list_news.news_id }">Đọc tiếp <span class="glyphicon agileits w3layouts glyphicon-arrow-right" aria-hidden="true"></span></a>
							</div>
								<div class="clearfix"></div>
						</div>
					</div>
				</c:forEach>
				<!-- wthree-top-1 -->
			</div>
		<!-- END cột bên phải -->
		<!--Cột bên phải-->
			<div class="col-md-3 w3agile_blog_left">
				<div class="agileinfo_calender">
				<h3>LIÊN KẾT VỚI:</h3>
				<div class="w3ls-social-icons-1">
					<a class="facebook" href="#"><i class="fa fa-facebook"></i></a>
					<a class="twitter" href="#"><i class="fa fa-twitter"></i></a>
					<a class="linkedin" href="#"><i class="fa fa-google-plus"></i></a>
				</div>
				</div>
				<div class="w3l_categories">
					<h3>Thể loại</h3>
					<ul>
						<c:forEach items="${typenews}" var="list_type">
						<li><a href="News?type_id=${list_type.type_id}"><span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>${list_type.typename }</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="w3ls_recent_posts">
						<h3>Bài vừa đăng</h3>
						<c:forEach items="${news1}" var="news1" begin="0" end="2">
						<div class="agileits_recent_posts_grid">
							<div class="agileits_recent_posts_gridl">
								<div class="w3agile_special_deals_grid_left_grid">
										<a href="Muc_Tin.html"><img src="images/TinTuc/${news1.image }" class="img-responsive" alt="" /></a>
									</div>
							</div>
							<div class="agileits_recent_posts_gridr">
								<c:set var = "title" value = "${fn:toLowerCase(news1.title)}" />
								<h4><a href="News_Info?news_id=${news1.news_id }">${title }</a></h4>
								<h5><i class="fa fa-calendar" aria-hidden="true"></i>${news1.date }</h5>
							</div>
							<div class="clearfix"> </div>
						</div>
						</c:forEach>
					</div>
				<!-- //btm-wthree-right -->
				<div class="clearfix"></div>
			</div>
		<!--END cột bên phải-->
		</div>
	</div>
		<!--
	==========================Footer================
	-->
	<div class="footer-wrapper">
		<div id="footer" class="footer-1">
			<div class="footer-main">
				<div class="container">
					<div class="row">
						<div class="col-md-3">
							<a href="#">
								<img alt class="logo_footer" src="images/TC.png">
							</a>
						</div>
						<div class="col-md-4">
							<div id="footerlst" class="widget">
								<h3 class="titlefooter">Navigation</h3>
								<div class="textwidget">
									<div class="row">
										<div class="col-md-6" style="padding-top: 17px;">
											<ul class="">
												<li><a class="non-textdecoration lstfooter" href="#">Trang chủ</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter" href="#">Khóa học</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter" href="#">Khai giảng</a></li>
											</ul>
										</div>
										<div class="col-md-6" style="padding-top: 17px;">
											<ul class="">
												<li><a class="non-textdecoration lstfooter" href="#">Thảo luận</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter" href="">Tin tức</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter" href="">Liên hệ</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div id="footerlst" class="widget2">
								<h3 class="titlefooter">Contact</h3>
									<div  style="padding-top: 17px;">
										<ul class="textwidget">
											<li style="font-size: 14px;"><i class="fa fa-map-marker" style="font-size:20px;color:#080707;"></i>&nbsp;&nbsp;Số 1, Võ Văn Ngân, Thủ Đức, TP Hồ Chí Minh, Việt Nam</li>
											<li style="font-size: 14px;padding-top: 15px;"><i class="fa fa-phone" style="font-size:20px;color:#080707;"></i>&nbsp;&nbsp;(+84)1869123456</li>
											<li style="font-size: 14px;padding-top: 15px;"><i class="fa fa-envelope" style="font-size:20px;color:#080707;"></i>&nbsp;&nbsp;<a class="non-textdecoration lstfooter" href="#">itcenter2017@gmail.com</a></li>
										</ul>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="container">
					<div class="footer-center">
						© Copyright 2017. All Rights Reserved</br>Powered and Designed by Khang & Mỹ & Duyên
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--nút quay về đầu trang-->
	<div class="btn-top" >
		<a href="javascript:void(0);" title="Top" style="display: inline;">
			
			<i class="glyphicon glyphiconc glyphicon-chevron-up"></i>
		</a>
	</div>
<script src="js/bootstrap.js"></script>
</body>
</html>