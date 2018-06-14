<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@page import="Bean.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<title>Diễn đàn</title>
	
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
	<!--bootstrap & Jquery-->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--Icon fa-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="css/mycssHome.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssThaoluan.css"/>
	
	
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>

	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
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
								<a href="Course" class="dropdown-toggle" data-toggle="dropdown">KHÓA HỌC<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="Course">Các khóa học</a></li>
									<li><a href="LichKhaiGiang">Lịch khai giảng</a></li>          
								</ul>
							</li>
							<li >
								<a href="News">TIN TỨC</a>
								
							</li> 
							<li class="active">
								<a href="thaoluan">THẢO LUẬN</a>
							</li>  
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


	<div class="header-page">
		<div class="header-content">
			<h1 style="text-align: right; padding-top: 50px;">Mục thảo luận</h1>			
		</div>
		<!--
		==============================content===================================
		-->
		<div class="container gallery-agileinfo">
			<div class="col-md-6 col-xs-6 gallery-w3lstop">
				<figure class="effect-bubba forum1">
					<a href="thaoluan_daisanh?topicID=1" class="swipebox">
						<img src="images\thaoluan/hinh3.png" alt="" class="img-responsive" />
						<div class="figcaption">
							<h4>Đại sảnh</h4>
							<p>Nơi hướng dẫn, thông báo, góp ý và chủ đề nóng</p>	
						</div>	
					</a>
				</figure>
			</div>
			<div class="col-md-6 col-xs-6 gallery-w3lstop">
				<figure class="effect-bubba forum2" >
					<a href="thaoluan_goclaptrinh?topicID=4" class="swipebox" >
						<img src="images\thaoluan/hinh2.png" alt="" class="img-responsive" />
						<div class="figcaption">
							<h4>Góc lập trình</h4>
							<p>Hỏi đáp, bàn luận và trao đổi kiến thức về lập trình</p>	
						</div>
					</a>
				</figure>
			</div>

			<div class="col-md-6 col-xs-6 gallery-w3lstop">
				<figure class="effect-bubba forum3" >
					<a href="thaoluan_goccongnghe?topicID=6" class="swipebox" >
						<img src="images\thaoluan/ironman.jpg" alt="" class="img-responsive" />
						<div class="figcaption">
							<h4>Góc công nghệ</h4>
							<p>Thiết bị di động, đồ điện tử và hỏi đáp công nghệ</p>	
						</div>
					</a>
				</figure>
			</div>
			<div class="col-md-6 col-xs-6 gallery-w3lstop">
				<figure class="effect-bubba forum4">
					<a href="thaoluan_khugiaitri?topicID=9" class="swipebox">
						<img src="images\thaoluan/hinh0.png" alt="" class="img-responsive" />
						<div class="figcaption">
							<h4>Khu giải trí</h4>
							<p>Chuyện trò linh tinh</p>	
						</div>	
					</a>
				</figure>
			</div>
			<div class="col-md-6 col-xs-6 gallery-w3lstop">
				<figure class="effect-bubba forum5" >
					<a href="thaoluan_thuongmaivamuaban?topicID=11" class="swipebox" >
						<img src="images\thaoluan/hinh4.png" alt="" class="img-responsive" />
						<div class="figcaption">
							<h4>Thương mại & mua bán</h4>
							<p>Khu trao đổi bàn luận, mua bán</p>	
						</div>
					</a>
				</figure>
			</div>
		</div>
	
	
	
		<!--
	==========================Footer================
	-->
	<div class="footer2-wrapper">
		<div id="footer2" class="footer2-1">
			<div class="footer2-main">
				<div class="container">
					<div class="row">
						<div class="col-md-3">
							<a href="#">
								<img alt class="logo_footer" src="styles/images/TC2.png">
							</a>
						</div>
						<div class="col-md-4">
							<div id="footerlst2" class="widget">
								<h3 class="titlefooter2">Navigation</h3>
								<div class="textwidget">
									<div class="row">
										<div class="col-md-6" style="padding-top: 17px;">
											<ul class="">
												<li><a class="non-textdecoration lstfooter2" href="#">Trang chủ</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter2" href="#">Khóa học</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter2" href="#">Khai giảng</a></li>
											</ul>
										</div>
										<div class="col-md-6" style="padding-top: 17px;">
											<ul class="">
												<li><a class="non-textdecoration lstfooter2" href="#">Thảo luận</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter2" href="">Tin tức</a></li>
												<li style="padding-top: 15px;"><a class="non-textdecoration lstfooter2" href="">Liên hệ</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div id="footerlst2" class="widget2">
								<h3 class="titlefooter2">Contact</h3>
									<div  style="padding-top: 17px;">
										<ul class="textwidget">
											<li style="font-size: 14px;"><i class="fa fa-map-marker" style="font-size:20px;color:rgba(230, 226, 226, 0.84);"></i>&nbsp;&nbsp;Số 1, Võ Văn Ngân, Thủ Đức, TP Hồ Chí Minh, Việt Nam</li>
											<li style="font-size: 14px;padding-top: 15px;"><i class="fa fa-phone" style="font-size:20px;color:rgba(230, 226, 226, 0.84);"></i>&nbsp;&nbsp;(+84)1869123456</li>
											<li style="font-size: 14px;padding-top: 15px;"><i class="fa fa-envelope" style="font-size:20px;color:rgba(230, 226, 226, 0.84);"></i>&nbsp;&nbsp;<a class="non-textdecoration lstfooter" href="#">itcenter2017@gmail.com</a></li>
										</ul>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer2-bottom">
				<div class="container">
					<div class="footer2-center">
						© Copyright 2017. All Rights Reserved</br>Powered and Designed by Khang & Mỹ & Duyên
					</div>
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
</body>
</html>