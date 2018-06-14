<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Liên hệ</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--Icon fa-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="css/mycssLienhe.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHome.css"/>
	
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>
	<script language="javascript" src="js/myjsLienhe.js"></script>
	<script language="javascript" src="js/myjsHome.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	
</head>
<body>
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
							<li class=" dropdown">
								<a href="Course" class="dropdown-toggle" data-toggle="dropdown">KHÓA HỌC<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="Course">Các khóa học</a></li>
									<li><a href="LichKhaiGiang">Lịch khai giảng</a></li>          
								</ul>
							</li>
							<li>
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
							<li class="active"><a href="Contact">LIÊN HỆ</a></li>
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
			<h1 style="text-align: right; padding-right: 0px; color: white;">Liên hệ</h1>		
		</div>
	</div>
<!--======================form dien thong tin-->
  	
  	<div class="container">
	  	<div id="wrapper" class="container">
	  		<div class="row">
				<form action="XuLySendMail" method ="Post">
				
					<h2 style="color: black; text-align: left; width: 1000px;">Send Us a Message</h2>
					<p class="tieude3">Liên hệ chúng tôi để chúng tôi giúp bạn dễ dàng hơn</p>
					<div class="responsive">
						<input type="text" id="name" name="name" class="textInput" placeholder="Your Name" style="padding-left: 10px" required><br/>
						<div class="val_error" id="name_error"></div>
					</div>
					<div style="padding-top: 8px;" class="responsive">
						<input type="text" id="email" name="email" class="textInput" placeholder="Your Email" style="padding-left: 10px" required><br/>
						<div class="val_error" id="email_error"></div>
					</div>
					<div style="padding-top: 8px;" class="responsive">
						<input type="text" id="topic" name="topic" class="textInput" placeholder="Topic" style="padding-left: 10px" required><br/>
						<div class="val_error" id="topic_error"></div>
					</div>
					<div style="padding-top: 14px" class="responsive">
						<textarea name="message" id="message" placeholder="Message"></textarea>
						<div class="val_error" id="message_error"></div>
					</div>
					<div>
						<button id="btnSendMessage" style="color:white; font-size:19px; background-color: #d20505" class="btn">Send Message</button>
						<input type="password" id="PassMail" name="passEmail" placeholder="Hãy nhập Password của Email" style="display:none;" />
						<button type="submit" id="Send" style="color:white; font-size:19px; background-color: #d20505;display:none;" class="btn" >SEND</button>
					</div>
					<h4 style="padding-top: 12px" id="ph" hidden> ĐÃ GỬI PHẢN HỒI THÀNH CÔNG!</h4>
				</form>
			</div>
		</div>
		
	</div>
	<!--===============GOOGLE MAP==================-->
	<div class="col-ms-12"> 
	  	<div id="map" style="width:100%;height:400px;">
	  		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.479840319647!2d106.76982351418313!3d10.851061660780243!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175270ad28d48ab%3A0xa6c02de0a7c40d6c!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBTxrAgcGjhuqFtIEvhu7kgdGh14bqtdCBUcC4gSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1514609370499" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
	  	</div>
	</div>
	<!--
	==========================Footer================
	-->
	<div class="footer-wrapper" style="padding-top: 120px;">
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

</body>
</html>

