<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.Account" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Khóa học</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--Icon fa-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="css/mycssHome.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssKhoahoc.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>
	
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>
	<script type="text/javascript">
		function Pager(tableName, itemsPerPage) {
			this.tableName = tableName;
			this.itemsPerPage = itemsPerPage;
			this.currentPage = 1;
			this.pages = 0;
			this.inited = false;
			this.showRecords = function(from, to) {
				var rows = document.getElementById(tableName).rows;
				// i starts from 1 to skip table header row
				for (var i = 1; i < rows.length; i++) {
					if (i < from || i > to)
						rows[i].style.display = 'none';
					else
					rows[i].style.display = '';
				}	
			}
			this.showPage = function(pageNumber) {
				if (! this.inited) {
					alert("not inited");
					return;
				}
				var oldPageAnchor = document.getElementById('pg'+this.currentPage);
				oldPageAnchor.className = 'btn btn-sm btn-icon';
				this.currentPage = pageNumber;
				var newPageAnchor = document.getElementById('pg'+this.currentPage);
				newPageAnchor.className = 'btn btn-info btn-fill';
				var from = (pageNumber - 1) * itemsPerPage + 1;
				var to = from + itemsPerPage - 1;
				this.showRecords(from, to);
			}
			this.prev = function() {
				if (this.currentPage > 1)
					this.showPage(this.currentPage - 1);
			}
			this.next = function() {
				if (this.currentPage < this.pages) {
					this.showPage(this.currentPage + 1);
				}
			}
			this.init = function() {
				var rows = document.getElementById(tableName).rows;
				var records = (rows.length - 1);
				this.pages = Math.ceil(records / itemsPerPage);
				this.inited = true;
			}
			this.showPageNav = function(pagerName, positionId) {
				if (! this.inited) {
				alert("not inited");
				return;
				}
				var element = document.getElementById(positionId);
				var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="btn btn-sm btn-icon"> « Prev </span> ';
				for (var page = 1; page <= this.pages; page++)
				pagerHtml += '<span id="pg' + page + '" class="btn btn-sm btn-icon" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> ';
				pagerHtml += '<span onclick="'+pagerName+'.next();" class="btn btn-sm btn-icon"> Next »</span>';
				element.innerHTML = pagerHtml;
			}
		}
	</script>
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
							<li class="active dropdown">
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
			=======================================
	-->

	<div class="header-page">
		<div class="header-content">
			<div style="text-align: right;">
				<h1>Khóa học</h1>
				<h4>Tổng hợp tất cả các khóa học</h4>
			</div>
			<div class="new-breadcrumb">
				<ol class="breadcrumb">
					<li>
						<a class="non-textdecoration" href="TrangChu">
							<span class="glyphicon glyphicon-home"></span>
        				</a>
					</li>
					<li class="active">
						Khóa học
					</li>
				</ol>
			</div>			
		</div>
	</div>
	<!--
		==============================content===================================
	-->

	<div class="container" style="font-family: 'Roboto', sans-serif;">

		<div class="body-page">
			<div class="row">
				<div class="col-md-3">
					<!-- Danh mục khóa học -->
					<div  class="list-group panel-title">
					    <c:forEach items="${topic}" var="list_topic">
					    	<c:choose>
					    	<c:when test="${id==list_topic.topic_id }">
					    		<a href="Course?topic_id=${list_topic.topic_id }" class="active list-group-item">${list_topic.topicname }</a>
					    	</c:when>
					    	<c:otherwise>
					    		<a href="Course?topic_id=${list_topic.topic_id }" class="list-group-item">${list_topic.topicname }</a>
					    	</c:otherwise>
					    	</c:choose>
					    </c:forEach>
					    
					</div>
					
				</div>
				<!-- Danh sách khóa học -->
				<div id="homeCourse" class="col-md-9">
					<div class="coursesWrapper">
						<div class="searchWrapper">
							<div class="pull-left">
								<h3 style="color: black;">Khóa học tiêu biểu</h3>
							</div>
							<div class="filter">
								<span>Sắp xếp theo:&nbsp;&nbsp;</span>
								<div class="btn-Group">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										Mới nhất&nbsp;
									</button>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="cardWrapper">
							<div class="itemCard clearfix">
							<table id="tablepaging" class="table">
							<thead style="display: none;">
		                    	<th>&nbsp;</th>
		                    </thead>
							<tbody>
								<c:forEach items="${course}" var="list">
								<tr>
									<td>
									<div class="col-sm-5">
										<div class="entry">
											<a class="non-textdecoration" href="Course_Info?course_id=${list.course_id }"><img src="${list.courseimage }" alt="khoahoc" style="width:100%"></a>
										</div>
									</div>
									<div class="col-sm-7">
										<div class="courseInfo">
											
											<div class="infoTop">
												<a class="non-textdecoration" href="Course_Info?course_id=${list.course_id }">
													<h4 style="color: black">${list.coursename }</h4>
												</a>
												<c:set var = "content" value = "${fn:substring(list.info, 0, 100)}" />
												<p>${content }...</p>
											</div>
											<div class="infoBot">
												<div class="row" style="padding-bottom: 20px;">
													<!-- <div style="float: left; padding-left: 25px;">
														<span class="couseText">Giảng viên: Lê Tấn Khang</span>
													</div> -->
													<div style="float: right; padding-right: 25px;">
														<a href="Course_Info?course_id=${list.course_id }" type="button" class="btn btn-default">
															More&nbsp;
															<i class="fa fa-angle-right"></i>
														</a>
													</div>
												</div>
											</div>
											
										</div>
									</div>
									</td>
								
								</tr>
								</c:forEach>
							</tbody>
							</table>
							<div id="pageNavPosition" class="pagination pageCourse" style="padding-top: 10px; padding-bottom: 30px;" align="center"></div>
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
<script type="text/javascript">
	var pager = new Pager('tablepaging', 5);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>
</body>
</html>