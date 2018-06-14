<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@page import="Bean.Account" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	<title>Diễn đàn - góc công nghệ</title>
	
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
	<link rel="stylesheet" type="text/css" href="css/mycssThaoluan_daisanh.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssThaoluan_daisanh_baiviet.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssUse_Inf.css"/>
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>
	
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>

	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
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
					<li class="dropdown">
    					<button class="btn btn_account dropdown-toggle" type="button" data-toggle="dropdown">
    						<img src="${account.avatar}" class="img_avatar img-responsive" alt="Cinque Terre"/>
    						<span  class="dropbtn">${account.name}</span>
					    	<span class="caret"></span>
						</button>
					    <ul class="dropdown-menu">
					      <li ><a href="ThongTinTaiKhoan_user.html">Thông tin tài khoản</a></li>
					      <li><a href="logout">Đăng xuất</a></li>
					    </ul>
					</li>					
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
								<a href="user_thaoluan">THẢO LUẬN</a>
							</li> 
							<li><a href="Contact">LIÊN HỆ</a></li>
							<li class="dropdown">
								<a ><span class="glyphicon glyphicon-search"></span></a>
								<ul class="dropdown-menu">
									<li>
										<form action="login">
										<input type="text" id="timkiem" placeholder="Tìm kiếm">
										</form>
									</li>
								</ul>
							</li>
						</ul>
						
					</div>
				</div><!--end container-->
			</nav><!--end nav-->
		</header><!--end header-->
	</div>


	<div id="daisanh" class="header-page">
		<div class="header-content">
			<h1 style="text-align: right; padding-top: 50px;">${Stitle }</h1>			
		</div>
		<!--
		==============================content===================================
		-->
		<div>
			<ol class="breadcrumb">
				<li>
					<a class="non-textdecoration" href="TrangChu">
						<span class="glyphicon glyphicon-home"></span>
    				</a>
				</li>
				<li>
					<a class="non-textdecoration" href="user_thaoluan">
					Thảo luận
					</a>
				</li>
				<li>
					<a class="non-textdecoration" href="user_thaoluan_goccongnghe?topicID=6">
					Góc công nghệ
					</a>
				</li>
				<li class="active">
					${Stitle }
				</li>
			</ol>
		</div>
		<hr class="divider">
		<div class="container contentdaisanh">
			<div class="row">
				<div id="menudaisanh" class="col-md-1 menu_daisanh">
				</div>
				<div id="contentdaisanh_post" class="col-md-10 content_daisanh_post">
					<div class="content_daisanh_baiviet">
						<div class="post-content">
							<header class="post-header">
								<h4 class="pull-left post-title">${discussionInfo.title}</h4>
							</header>
							<div class="post-main">
								<div class="post-main1" >
									<div style="float: left;">
										<a href="#openModal${discussionInfo.account_id}" class="post-avatar">
											<img src="${discussionInfo.avatar}">
										</a>
									</div>
									<div class="post-name">
										<div class="postInfo">
											<dt>
												Posted by <a href="#openModal${discussionInfo.account_id}"> ${discussionInfo.postedby}</a>
											</dt>
											<dd style="color: rgb(150,150,150);">
												<a class="dateTime" href="#">
													<span title="${discussionInfo.postdate}">${discussionInfo.postdate}</span>
												</a>
											</dd>
										</div>
									</div>
								</div>
								<div class="post-main2">
									<p>
										${discussionInfo.content}
									</p>
								</div>
							</div>
							
						</div>
					</div>
					<div class="post-comment row">
						<div class="avatar-comment col-md-1 col-xs-1">
							<a href="" class="post-avatar">
								<img src="${account.avatar}">
							</a>
						</div>
						<form action="addCommentUser?role=2&discussionID=${discussionID}&Stitle=${Stitle}" method="post" class="col-md-11 col-xs-11">
							<input type="hidden" name="accountID" value="${account.account_id}" />
							<textarea name="message" placeholder="Viết bình luận.." ></textarea>
							<button type="submit" class="btnPost">Post</button>
						</form>
					</div>
					<div class="listcomment row">
						<table id="tablepaging" class="table">
						<thead style="display: none;">
	                    	<th>&nbsp;</th>
	                    </thead>
						<tbody>
						<c:forEach items="${listComment}" var="listComment">
						<tr>
							<div class="cmt">
								<td>
								<div class="avatar_cmt">
									<a href="" class="post-avatar">
										<img src="${listComment.avatar}">
									</a>
								</div>
								<div class="post-name">
									<div class="postInfo">
										<dt>
											<a href="#openModal${discussionInfo.account_id}"> ${listComment.name}</a>
										</dt>
										<dd style="color: rgb(150,150,150);">
											<a class="dateTime" href="#">
												<span title="${listComment.time}">${listComment.time}</span>
											</a>
										</dd>
									</div>
								</div>
								<div class="cmt-content">
									<p>
										${listComment.comment}
									</p>
								</div>
								</td>
							</div>
						</tr>
						</c:forEach>
						</tbody>
						</table>
						<div id="pageNavPosition" style="padding-top: 10px; padding-bottom: 30px;" align="center"></div>
					</div>
					<div id="openModal${discussionInfo.account_id}" class="modalDialog">
					    <div>
					        <a href="#close" title="Close" class="close" style="color: white;"><i class="fa fa-times" style="font-size:24px"></i></a>
					        <div class="row">
					        	<div class="avatar_info col-md-4">
									<img src="${discussionInfo.avatar}">
					        	</div>
					        	<div class="col-md-7 use_inf">
				        		<h4>${discussionInfo.postedby}</h4>
				        		<p style="padding-bottom: 10px">${discussionInfo.sex}</p>
				        		<p>Birthday: <span>${discussionInfo.birthday}</span></p>
				        		<p>Email: <span>${discussionInfo.mail}</span></p>
				        		<p>Phone: <span>${discussionInfo.phonenumber}</span></p>
				        	</div>
					        </div>
					    </div>
					</div>
					<c:forEach items="${listComment}" var="listComment">
					<div id="openModal${listComment.account_id}" class="modalDialog">
					    <div>
					        <a href="#close" title="Close" class="close" style="color: white;"><i class="fa fa-times" style="font-size:24px"></i></a>
					        <div class="row">
					        	<div class="avatar_info col-md-4">
									<img src="${listComment.avatar}">
					        	</div>
					        	<div class="col-md-7 use_inf">
					        		<h4>${listComment.name}</h4>
					        		<p style="padding-bottom: 10px">${listComment.sex}</p>
					        		<p>Birthday: <span>${listComment.birthday}</span></p>
					        		<p>Email: <span>${listComment.mail}</span></p>
					        		<p>Phone: <span>${listComment.phonenumber}</span></p>
					        	</div>
					        </div>
					    </div>
					</div>
					</c:forEach>
				</div>

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
								<img alt class="logo_footer" src="images/TC2.png">
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
<script type="text/javascript">
	var pager = new Pager('tablepaging', 10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>
</body>
</html>