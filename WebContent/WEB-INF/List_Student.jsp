<%@page import="DAO.LichKhaiGiangDAO"%>
<%@page import="Bean.user" %>
<%@page import="Bean.ViewListStudent" %>
<%@page import="Bean.Account" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Danh Sách lớp</title>
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
	<link rel="stylesheet" type="text/css" href="css/mycssHomeUser.css"/>	
	<link rel="stylesheet" type="text/css" href="css/mycssList_Student.css"/>	
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<script language="javascript" src="js/myjsHome.js"></script>
	<!-- In file word -->
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript" src="tableExport.js"></script>
	<script type="text/javascript" src="jquery.base64.js"></script>
	
	<script type="text/javascript" src="jspdf/libs/sprintf.js"></script>
	<script type="text/javascript" src="jspdf/jspdf.js"></script>
	<script type="text/javascript" src="jspdf/libs/base64.js"></script>
	<script type="text/javascript" src="html2canvas.js"></script>

	
	<link rel="stylesheet" href="css/demo.css" type="text/css" media="screen" title="no title" charset="utf-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/List_Student.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/myjsInfoTaiKhoanTeacher.js" type="text/javascript" charset="utf-8"></script>
	
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
					<%Account acc=(Account)session.getAttribute("account");
					if(session.getAttribute("account")!=null)
						{ 
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
							<li class=""><a href="TrangChu">TRANG CHỦ</a></li>     
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
							<%if(session.getAttribute("account")!=null)
							{%>
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
		==============================content===================================
	-->
	<div class="header-page">
		<div class="header-content">
			<h1 style="text-align: right; padding-right: 0px;">Trang giảng viên</h1>		
		</div>
	</div>
	
	<sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://node6037-ttthweb.ocs.opusinteractive.io/web_ttth?useUnicode=true&characterEncoding=UTF-8"
                           user="root"  password="QEFskb64114"/>
 
				       <sql:query dataSource="${dbsource}" var="result">
				           select *
									from class
									where class.class_id=<%=Integer.parseInt(request.getParameter("class_id")) %> ;
				       </sql:query>
	
	<div class="container">
		<div class="card">
			<div class="infoClass">
				<h3 >THÔNG TIN LỚP HỌC</h3>
			    <div >
			      	<table style="margin: auto; width: 70%;">
			      	<c:forEach var="row" items="${result.rows}">
				      <tr>
				        <td>#Mã lớp:</td>
				        <td>${row.class_id }</td>
				        <td>Ngày bắt đầu:</td>
				        <td>${row.startday }</td>
				      </tr>
				      <tr>
				        <td>Tên lớp học:</td>
				        <td>${row.classname }</td>
				        <td>Ngày kết thúc:</td>
				        <td>${row.endday }</td>
				      </tr>
				      <tr>
				        <td>Ca học:</td>
				        <td>${row.timestudy }</td>
				        <td>Số lượng học viên:</td>
				        <td>${row.number_of_students }</td>
				      </tr>
				      <tr>
				        <td>Ngày Thi:</td>
				        <td>${row.testday }</td>
				        <td>Giảng viên:</td>
				        <td><%=acc.getName() %></td>
				      </tr>
				      <tr>
				        <td>Địa điểm</td>
				        <td>${row.location }</td>
				        <td></td>
				        <td></td>
				      </tr>
				      </c:forEach>
					</table>
			    </div>
			</div>
			
			
			<div class="body" >
			  
			<h3 >DANH SÁCH LỚP
			<div class="pull-right" style="font-size: 13px;">
				<form method="get" action="Update_Point_Excel" enctype="multipart/form-data">
					<input type="file" name="uploadFile"/>
					<input type="hidden" value="<%=request.getParameter("class_id")%>" name="class_id">
	   				
						<button class="btn waves-effect waves-light" type="submit" style="color:black;">
						<span class="btn-label" >
					<i class="fa fa-upload" aria-hidden="true"></i>
					</span>Update điểm</button>
				</form>
			</div>
			</h3>
			    <div class="table-header"><div class="pull-left">
			    
			    	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a CourseName">
			    </div>
			    
			    </div>
			    <table class="table table-hover bdt" id="myTable">
			        <thead>
			        <tr style="cursor: pointer;" class="header">
			            <th><span class="sort-element" onclick="sortTable(0)">#STT</span><span class="sort-icon fa"></span></th>
			            <th><span class="sort-element" onclick="sortTable(1)">Họ và Tên</span><span class="sort-icon fa"></span></th>
			            <th><span >Ngày sinh</span></th>
			            <th><span>Giới tính</span></th>
			            <th><span >Email</span></th>
			            <th><span class="sort-element" onclick="sortTable(2)">Điểm</span><span class="sort-icon fa"></span></th>
			            <th><span class="sort-element">Save</span></th>
			        </tr>
			        </thead>
			        <tbody>
			        
				       <c:forEach items="${ListStudent }" var="ListStudent">
			        	<!-- dữ liệu trong bảng -->
					        <tr style="display: table-row; cursor: pointer;">
					            <td >1</td>
					            <td >${ListStudent.name }</td>
					            <td >${ListStudent.birthday }</td>
					            <td >${ListStudent.sex }</td>
					            <td >${ListStudent.mail }</td>
					           
					            <form name="frmDoiMK" action="Update_Point?class_id=<%=Integer.parseInt(request.getParameter("class_id"))%>&account_id=${ListStudent.account_id }" method="post">
						             <td>
							            <input type="text" id="point" value="${ListStudent.point }" name="point" size="1" />
							        </td>
							        <td>
						            <!-- <td data-field="status"></td> -->
					  				<Button>Save</Button>
					  				</td>
					            </form>
					            
					         </tr>
				        </c:forEach>
			        </tbody>
			    </table>
			    <div id="pageNavPosition" class="pagination pageCourse" style="padding-top: 10px; padding-bottom: 30px; float:right;" align="center"></div>
			    <div id="table-footer" class="row">
			    	<div class="pull-left table-info">
			    		<a href="Print_List_Student?list=<%=request.getParameter("class_id")%>&list1=<%=request.getParameter("account_id")%>">
			    		<button class="btn btn-instagram waves-effect waves-light" type="button">
							<span class="btn-label" >
								<i class="fa fa-print" aria-hidden="true"></i>
							</span>Print
						</button></a>
						
			    	</div>
			    </div>
			  <!--   </form> -->
			    
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
						© Copyright 2017. All Rights Reserved</br>Powered and Designed by Khang &amp; Mỹ &amp; Duyên
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
	var pager = new Pager('myTable', 10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>
</body>
</html>