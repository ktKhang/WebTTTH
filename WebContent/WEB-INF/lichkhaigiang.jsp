<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Lịch khai giảng</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--Icon fa-->
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="css/mycssHome.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssLichkhaigiang.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssKhoahoc.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>
	<script type="text/javascript" src="js/myjsLichkhaigiang.js"></script>
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
    					<button class="btn btn_account dropdown-toggle" style="color:black;" type="button" data-toggle="dropdown">
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
							<li class="active dropdown">
								<a href="khoahoc.html" class="dropdown-toggle" data-toggle="dropdown">KHÓA HỌC<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="Course">Các khóa học</a></li>
									<li><a href="LichKhaiGiang">Lịch khai giảng</a></li>          
								</ul>
							</li>
							<li>
								<a href="News">TIN TỨC</a>
								
							</li> 
							<li>
								<a href="user_thaoluan">THẢO LUẬN</a>
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
	<!--
		==============================content===================================
	-->
	<div class="header-page">
		<div class="header-content">
			<h1 style="text-align: right; padding-right: 0px;">Lịch khai giảng</h1>		
		</div>
	</div>

	<div id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60" class="homepage">
		<!-- data-spy và data-target:tạo scrollspy -->
	
	<div style="height:50px;"></div>
	<div class="w3ls-section" id="main">
		<div class="container">
			<div class="col-md-5 wthree-service-left">
				<div class="agileinfo-about-title">
					<span class="w3ls-title">Lịch khai giảng</span>
					<h1>SCHEDULE</h1>
				</div>
				<p>Chúng tôi cung cấp cho bạn những khóa học lập trình, những chương trình đào tạo được tìm kiếm nhiều nhất với đội ngũ
				giảng dạy có nhiều chuyên môn</p>
				<div class="agileinfo-sleft1">
					<i class="fa fa-hand-o-right" aria-hidden="true"></i>
					<h5>Lịch khai giảng</h5>
				</div>
			</div>
			<div class="col-md-7  wthree-service-right" >
				<div class="col-md-6 col-sm-6 col-xs-6 wthree-service-right1 wthree-service-rightgrid">
					<div class="service-img w3-simg1">
					</div>
					<div class="col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-md-10 col-sm-10 col-xs-10 service-img w3-simg2"></div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-6 wthree-service-right1">
					<div class="col-md-10 col-sm-10 col-xs-10 service-img w3-simg5"></div>
					<div class="col-md-2 col-sm-2 col-xs-2"></div>
					<div class="clearfix"></div>
					<div class="service-img w3-simg4"></div>
					<div class="col-md-10 col-sm-10 col-xs-10 service-img w3-simg5"></div>
					<div class="col-md-2 col-sm-2 col-xs-2"></div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- ============================================THÔNG TIN LỊCH KHAI GIẢNG==========================================================
	================================================================================================================================== -->
	<div class="w3ls-section news" id="services">
		<div id="container">
	<!-- 	=======================================================LẬP TRÌNH IOS====================================================== -->
			<div id="divIOS" class="divForm">
				<form name="frmDangKi" action="#">
					<h3 class="w3ls-title">Lịch khai giảng</h3>
					<hr/>
					<table class="table">
					
						<thead>
						  <tr>
						  	<th>Khóa học</th>
							<th>Lớp</th>
							<th>Thời gian</th>
							<th>Ngày khai giảng</th>
							<th>Địa điểm học</th>
							<th>Học phí</th>
							<th>Đăng kí</th>
						  </tr>
						</thead>
						<tbody>
					
						<c:forEach items="${list_class }" var="list_class">
						<c:forEach items="${course}" var="list_course" >
							<c:if test="${list_class.course_id==list_course.course_id}">
								
								  <tr>
								  	<td>${list_course.coursename }</td>
									<td>${list_class.classname }</td>
									<td>${list_class.timestudy }</td>
									<td>${list_class.startday }</td>
									<td>${list_class.location }</td>
									<td>${list_course.fee }</td>
									<td><button><a href="Register_Class?class_id=${list_class.class_id}&course_name=${list_course.coursename }&fee=${list_course.fee}">Đăng Kí</a></button></td>
								  </tr>   
								 
							</c:if>
						</c:forEach>
						</c:forEach>
						</tbody> 
					  </table>
					 
					<br>
				</form>
			</div>
		
		<!-- ================================================LẬP TRÌNH DI ĐỘNG================================================= -->
		</div>
	</div>
	<!--  About Starts -->
	<div class="w3ls-section" id="attractions">
		<div class="container">
			<div class="about-padding-w3ls">
				<h3 class="w3ls-title"> Các chương trình đào tạo mới </h3>
				<div class="about-img">
					<div class="w3l-img1">
						<div class="w3l-img2">
							<h4>Lập trình HTML</h4>
							   <!--  transform: rotate(-7deg); Tạo độ nghiêng cho thẻ -->
						</div>
						<div class="about-bottom">
							<div class="w3l-img3">
								<h4>Lập trình IOS</h4>
								 <!--  transform: rotate(-7deg); Tạo độ nghiêng cho thẻ -->
							</div>
							<div class="w3l-img3-text">
								<h4>Lập trình cho trẻ</h4>
								 <!--  transform: rotate(-7deg); Tạo độ nghiêng cho thẻ -->
							</div>
						</div>
					</div>
				</div>
				<div class="w3_agile-attractions-bottom">
					<div class="col-md-4 col-sm-4 about-text-left">
						<h2>ƯU ĐÃI ĐẶC BIỆT: </h2>
					</div>
					<div class="col-md-8 col-sm-8 about-text">
						<div class="about-text-padding-agile">
							<div class="col-md-12 khoang-cach-5"><p>
								<ul>
								<li>
									Tặng 100.000đ khi đăng kí Online</li>
								<li>
									Tặng&nbsp;10% học phí cho <strong>Sinh viên</strong> hoặc <strong>Học viên cũ</strong> đã học tại Trung Tâm Tin Học</li>
								<li>
									Tặng&nbsp;10% học phí cho đăng ký nhóm 2 học viên, 15% khi đăng kí nhóm 3 học viên</li>
							</ul>
							<p>
								<strong>​</strong>
								<strong style="font-family: arial, helvetica, sans-serif;">ĐẶC BIỆT: &nbsp;</strong>
								<font face="arial, helvetica, sans-serif">Đăng ký&nbsp;</font>trọn gói 2 khóa lập trình ( 
								<strong>IOS + HTML</strong>)=&nbsp;<strike>7.800.000Đ</strike>&nbsp;ưu đãi&nbsp;
								<span style="color: blue;"><span style="font-family: arial, helvetica, sans-serif;">
								<span style="font-size: 14px;"><strong>6.000.000Đ</strong>
								</span></span></span>
							</p>
							<div>
								<p>
									<u><em><font face="arial, helvetica, sans-serif"><b>Lưu ý:</b></font></em></u></p>
								<ul>
									<li>
										<em>Để nhận được&nbsp;
										<strong>ưu đãi&nbsp;</strong>
										học viên phải Đăng ký online và hoàn tất học phí đến hết ngày 
										<span style="color:blue;"><strong>14/10/2017</strong></span>.</em></li>
									<li>
										<em>Trong trường hợp có nhiều chính sách ưu đãi, bạn sẽ được áp dụng 
										<strong>chính sách ưu đãi cao nhất</strong> (không cộng dồn)</em></li>
									<li>
										<em>Đối với ưu đãi&nbsp;
										<strong>Học sinh - Sinh viên</strong>, 
										khi đến đăng ký vui lòng mang theo 01 bản photo thẻ Học sinh, Sinh viên&nbsp;và bản gốc&nbsp;
										để được hưởng ưu đãi.</em></li>
								</ul>
							</div>
							<p>
								&nbsp;</p>
							</div>
							
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	<!-- gallery -->
	<div class="w3ls-section gallery" id="gallery">
		<div class="container">
			<h3 class="w3ls-title">Chương Trình Đào Tạo Ngắn Hạn</h3>
			<div class="gallery-agileinfo">
				<c:forEach items="${course}" var="list_cou" begin = "0" end="4">
					<div class="col-md-6 col-xs-6 gallery-w3lstop">
						<figure class="effect-bubba">
							<a href="Course_Info?course_id=${list_cou.course_id }" class="swipebox">
								<img src="images/trangchu/${list_cou.courseimage }" alt="" class="img-responsive" />
								<div class="figcaption">
									<h4>${list_cou.coursename }</h4>
								</div>	
							</a>
						</figure>
					</div>
				</c:forEach>				
					
			</div>

		</div>
	</div>
	<div style="height:50px;"></div>
	<!--Chương trình dài hạn-->
	<div class="w3ls-section main" id="plans" style="padding-top:15px;">
		<h3 class="w3ls-title" style="padding-top:8px;">Chương Trình Đào Tạo Dài Hạn</h3>
		<p></p>
		<div id="particles-js"></div>
		<div class="priceing-table-main">
			<h3 class="w3ls-title"></h3>
			<div class="priceing-table-grids">
				<div class=" price-grid">
					<div class="price-block agile">
						
						<div class="col-md-4 price1">
							<h4>Thiết Kế Website</h4>
						</div>
						<div class="col-md-5 price-gd-bottom">
							<div class="price-list">
								<h4>Nội dung: </h4>
								<P class="bed"> Photoshop cho Web +&nbsp;Layout Web,&nbsp;HTML5 + CSS3 + Jquery,
								&nbsp;Animation, Responsive Web + Đồ án</P>
							</div>

						</div>
						<div class="col-md-3 price-gd-top pric-clr1">
							<h4>Học Phí</h4>
							<h3><span>$</span>68</h3>
							<h5>/khóa</h5>
							<div class="price-selet pric-sclr1">
								<a href="#small-dialog" class="popup-with-zoom-anim">Đăng Kí</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class=" price-grid w3ls-price-middle">
					<div class="price-block agile">
						<div class="col-md-4 price1 price2">
							<h4>Thiết Kế Đồ Họa</h4>
						</div>
						<div class="col-md-5 price-gd-bottom">
							<div class="price-list">
								<h4>Nội Dung:</h4></h4>
								<P class="bed">Thực hành trong suốt 12 tháng</P>
							</div>

						</div>
						<div class="col-md-3 price-gd-top pric-clr2">
							<h4>Học Phí</h4>
							<h3><span>$</span>85</h3>
							<h5>/khóa</h5>
							<div class="price-selet pric-sclr1">
								<a href="#small-dialog" class="popup-with-zoom-anim">Đăng Kí</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
					<div class="price-grid" style="float:left">
						<div class="price-block agile">
							<div class="col-md-4 price1 price3">
								<h4>Thiết kế Đồ Họa</h4>
							</div>
							<div class="col-md-5 price-gd-bottom">
								<div class="price-list">
									<h4>Nội Dung:</h4>
									<P class="bed"> Bố cục - màu sắc - nghệ thuật chữ, Phát triển ý tưởng, 
									Hệ thồng thương hiệu, Nhiếp ảnh, Chế bản - bình phim - xuất phim, Đồ án</P>
								</div>

							</div>
							<div class="col-md-3 price-gd-top pric-clr4">
								<h4>Học Phí</h4>
								<h3><span>$</span>99</h3>
								<h5>/khóa</h5>
								<div class="price-selet pric-sclr1">
									<a href="#small-dialog" class="popup-with-zoom-anim">Đăng Kí </a>
								</div>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			</div>

		</div>
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

</body>
</html>