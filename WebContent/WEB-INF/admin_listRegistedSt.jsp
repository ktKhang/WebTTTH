<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Admin Page</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">
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
    <!-- Xác nhận xóa -->
    <script type="text/javascript">
            function getConfirmation(){
            	var comfirmBox;
        		comfirmBox = confirm("Bạn có chắc chắn muốn xóa?");
        		if (comfirmBox == true) {
        			return true;
        		} else {
        			return false;
        		}
            }
     </script>
     <!-- Xác nhận duyệt -->
    <script type="text/javascript">
            function getConfirmation2(){
            	var comfirmBox;
        		comfirmBox = confirm("Bạn có chắc chắn muốn xác nhận những học viên này vào lớp?");
        		if (comfirmBox == true) {
        			return true;
        		} else {
        			return false;
        		}
            }
     </script>
</head>
<body>
<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="viewProfileAdmin" class="simple-text">
                    ITCENTER
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="viewProfileAdmin">
                        <i class="ti-user"></i>
                        <p>Thông tin cá nhân</p>
                    </a>
                </li>
                <li>
                    <a href="courseAdmin">
                        <i class="ti-book"></i>
                        <p>Quản lí khóa học</p>
                    </a>
                </li>
                <li class="active">
                    <a href="classAdmin">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lí lớp học</p>
                    </a>
                </li>
                <li>
                    <a href="accountAdmin">
                        <i class="ti-face-smile"></i>
                        <p>Quản lí tài khoản</p>
                    </a>
                </li>
                <li>
                    <a href="newsAdmin">
                        <i class="ti-write"></i>
                        <p>Quản lí tin tức</p>
                    </a>
                </li>
                <li>
                    <a href="forumAdmin">
                        <i class="ti-world"></i>
                        <p>Quản lí diễn đàn</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="TrangChu">
                        <i class="ti-home"></i>
                        <p>Xem trang chủ</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
		<nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">Quản lí lớp học</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="${adminAvatar}" class="img_avatar img-responsive" alt="Cinque Terre"/>
                                    <p>&nbsp;${adminName}&nbsp;</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="logout">Đăng xuất</a></li>
                                
                              </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="content">
            <div class="container-fluid">
            	<div class="row">
                    <div class="col-md-12">
		            	<div class="row">
		               		<div class="btn-group" style=" padding-bottom: 15px;padding-left: 20px;">
		                           <a href="classAdmin" type="button" class="btn btn-default">
		                             <i class="ti-arrow-left"></i>&nbsp;&nbsp;back
		                           </a>
		                    </div>
		               	</div>
		               	
		               	<div class="card">
		               		<div class="header">
                                <h4 class="title">Danh sách học viên</h4>
                                <div style="float: right; margin-top: -31px;">
	                                <ul class="nav nav-tabs">
	                                    <li class="active">
	                                        <a href="#tab_1_1" data-toggle="tab" aria-expanded="true" style="color: black;">Chưa duyệt</a>
	                                    </li>
	                                    <li >
	                                        <a href="#tab_1_2" data-toggle="tab" aria-expanded="true" style="color: black;">Đã duyệt</a>
	                                    </li>
	                                </ul>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="content">
                            <div class="tab-content">
                            	<div class="tab-pane active" id="tab_1_1">
                            		
                            		<form action="deleteStudents" id="form1" method="post" onsubmit="return checkCheckBoxes(this)">
			                            <div class="content table-responsive table-full-width">
			                                <table class="table table-striped">
			                                    <thead>
			                                    	<th>&nbsp;</th>
			                                        <th>Thành viên</th>
			                                        <th>SĐT</th>
			                                        <th>Email</th>
			                                        <th>Lớp đăng kí</th>
			                                        <th>Khóa học</th>
			                                    </thead>
			                                    <tbody>
			                                    	<c:forEach items="${listStudent2}" var="listStudent2">
			                                    		<tr>
			                                    			<td>
			                                    				<div class="checkbox icheck-primary">
			                                    				<input type="checkbox" name="studentDel[]" value="${listStudent2.sc_id}"/>
			                                    				</div>
			                                    			</td>
			                                    			<td>
			                                    				<div >
			                                                    <span>
			                                                        <span class="avatar">
			                                                            <img class="avatar" src="${listStudent2.avatar}">
			                                                        </span>
			                                                        ${listStudent2.name}
			                                                    </span>
			                                                	</div>
			                                    			</td>
				                                            <td>${listStudent2.phonenumber}</td>
				                                            <td>${listStudent2.mail}</td>
				                                            <td>${listStudent2.registeredClass}</td>
				                                            <td>${listStudent2.registeredCourse}</td>
			                                        	</tr>
			                                    	</c:forEach>
			                                    </tbody>
			                                </table> 
			                                
			                        	</div>
			                        	<div class="row" style="padding-bottom:10px;">
		                            		
				                            <div class="btn-group" style="margin-left: 10px; float: right; padding-right:15px;">
				                            	<button type="submit" name="action" value="delete" class="btn btn-default" onclick="return getConfirmation();"/><span class="ti-trash"></span>&nbsp;&nbsp;Xóa</button>
				                    		</div>
				                    		<div class="btn-group" style="float: right;">
				                                <button type="submit" name="action" value="accept" class="btn btn-default" onclick="return getConfirmation2();"/><span class="ti-check"></span>&nbsp;&nbsp;Duyệt</button>
				                            </div>
				                    	</div>
		                        	</form>
                            	</div>
                            	<div class="tab-pane" id="tab_1_2">
                            		<form action="deleteStudents2" id="form2" method="post" onsubmit="return checkCheckBoxes2(this)">
			                            <div class="content table-responsive table-full-width">
			                                <table id="tablepaging" class="table table-striped">
			                                    <thead>
			                                    	<th>&nbsp;</th>
			                                        <th>Học viên</th>
			                                        <th>SĐT</th>
			                                        <th>Email</th>
			                                        <th>Lớp đang học</th>
			                                        <th>Khóa học</th>
			                                    </thead>
			                                    <tbody>
			                                    	<c:forEach items="${listStudent}" var="listStudent">
			                                    		<tr>
			                                    			<td>
			                                    				<div class="checkbox icheck-primary">
			                                    				<input type="checkbox" name="studentDel2[]" value="${listStudent.sc_id}"/>
			                                    				</div>
			                                    			</td>
			                                    			<td>
			                                    				<div >
			                                                    <span>
			                                                        <span class="avatar">
			                                                            <img class="avatar" src="${listStudent.avatar}">
			                                                        </span>
			                                                        ${listStudent.name}
			                                                    </span>
			                                                	</div>
			                                    			</td>
				                                            <td>${listStudent.phonenumber}</td>
				                                            <td>${listStudent.mail}</td>
				                                            <td>${listStudent.registeredClass}</td>
				                                            <td>${listStudent.registeredCourse}</td>
			                                        	</tr>
			                                    	</c:forEach>
			                                    </tbody>
			                                </table> 
			                                
			                                <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>
			                        	</div>
			                        	<div class="row" style="padding-bottom:10px;">
		                            		
				                            <div class="btn-group" style="margin-left: 10px; float: right; padding-right:15px;">
				                            	<button type="submit" class="btn btn-default" onclick="return getConfirmation();"/><span class="ti-trash"></span>&nbsp;&nbsp;Xóa</button>
				                    		</div>
				                    	</div>
		                        	</form>
                            	</div>
                            	</div>
                            </div>
		               	</div>
               		
               	</div>
            </div>
        </div>
        
		<input type="hidden" id="message" value="${message}">
		<footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="viewProfileAdmin">
                            	ITCENTER
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="https://www.facebook.com/kt.khanq" target="_blank">Khang</a> <a href="https://www.facebook.com/profile.php?id=100009118060733" target="_blank">Duyen</a> <a href="https://www.facebook.com/toi.lagio.3154" target="_blank">My</a>
                </div>
            </div>
        </footer>

    </div>
</div>
<script type="text/javascript">
	var pager = new Pager('tablepaging', 5);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);
</script>
<script type="text/javascript">
(function () {
	var kk = document.getElementById('message').value; //lấy thông báo
    if(kk != ""){
        alert(kk);
    }
})();
</script> 
</body>
	<!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>
	<script language="javascript" src="assets/js/changePass.js"></script>
	<script type="text/javascript" language="JavaScript">
	function checkCheckBoxes(theForm) {
		var test = document.getElementsByName("studentDel[]");
		for(var i =0; i<test.length; i++){
		    if (test[i].checked == true) 
		    {
		    	return true;
		    } 
		}
    	alert ('Hãy chọn dòng trước khi thao tác!!');
        return false;
	}
	</script>
	<script type="text/javascript" language="JavaScript">
	function checkCheckBoxes2(theForm) {
		var test = document.getElementsByName("studentDel2[]");
		for(var i =0; i<test.length; i++){
		    if (test[i].checked == true) 
		    {
		    	return true;
		    } 
		}
    	alert ('Hãy chọn dòng trước khi thao tác!!');
        return false;
	}
	</script>
</html>