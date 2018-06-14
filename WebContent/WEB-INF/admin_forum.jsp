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
                <li>
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
                <li class="active">
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
                    <a class="navbar-brand" href="#">Quản lí diễn đàn</a>
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
                    	<div class="card card-plain">
                            <div class="header" style="float: left;">
                                <h4 class="title">Mục thảo luận</h4>
                                <p class="category"></p>
                            </div>
                            <div class="clearfix"></div>
                            <form action="deleteNews" id="form1" method="post" onsubmit="return checkCheckBoxes(this)">
	                            <div class="content table-responsive table-full-width">
	                                <table id="tablepaging" class="table table-responsive ">
	                                    <thead>
	                                    	<th>&nbsp;</th>
	                                    	<th>&nbsp;</th>
	                                    	<th>&nbsp;</th>
	                                    </thead>
	                                    <tbody>
                                    		<tr>
                                    			<td>
                                    				<div >
                                                        <span class="avatar">
                                                            <img src="images\thaoluan/hinh3.png" alt height="60" width="90">
                                                        </span>
	                                                </div>
                                    			</td>
	                                            <td>Đại sảnh</td>
	                                            <td><a href="forumAdmin_topic?thread=1&name=Đại sảnh" 
	                                            style="font-size: 16px; color: black; padding-left: 30px;" type="button" class="ti-arrow-right btn btn-default"> Go</a></td>
                                        	</tr>
                                        	<tr>
                                    			<td>
                                    				<div >
                                                        <span class="avatar">
                                                            <img src="images\thaoluan/hinh2.png" alt height="60" width="90">
                                                        </span>
	                                                </div>
                                    			</td>
	                                            <td>Góc lập trình</td>
	                                            <td><a href="forumAdmin_topic?thread=2&name=Góc lập trình" 
	                                            style="font-size: 16px; color: black; padding-left: 30px;" type="button" class="ti-arrow-right btn btn-default"> Go</a></td>
                                        	</tr>
                                        	<tr>
                                    			<td>
                                    				<div >
                                                        <span class="avatar">
                                                            <img src="images\thaoluan/ironman.jpg" alt height="60" width="90">
                                                        </span>
	                                                </div>
                                    			</td>
	                                            <td>Góc công nghệ</td>
	                                            <td><a href="forumAdmin_topic?thread=3&name=Góc công nghệ" 
	                                            style="font-size: 16px; color: black; padding-left: 30px;" type="button" class="ti-arrow-right btn btn-default"> Go</a></td>
                                        	</tr>
                                        	<tr>
                                    			<td>
                                    				<div >
                                                        <span class="avatar">
                                                            <img src="images\thaoluan/hinh0.png" alt height="60" width="90">
                                                        </span>
	                                                </div>
                                    			</td>
	                                            <td>Khu giải trí</td>
	                                            <td><a href="forumAdmin_topic?thread=4&name=Khu giải trí" 
	                                            style="font-size: 16px; color: black; padding-left: 30px;" type="button" class="ti-arrow-right btn btn-default"> Go</a></td>
                                        	</tr>
                                        	<tr>
                                    			<td>
                                    				<div >
                                                        <span class="avatar">
                                                            <img src="images\thaoluan/forum1.jpg" alt height="60" width="90">
                                                        </span>
	                                                </div>
                                    			</td>
	                                            <td>Thương mại & mua bán</td>
	                                            <td><a href="forumAdmin_topic?thread=5&name=Thương mại mua bán" 
	                                            style="font-size: 16px; color: black; padding-left: 30px;" type="button" class="ti-arrow-right btn btn-default"> Go</a></td>
                                        	</tr>
	                                    </tbody>
	                                </table> 
	                                
	                                <div id="pageNavPosition" style="padding-top: 20px" align="center"></div>
	                        	</div>
                        	</form>
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
    k = document.getElementById('type').value; //lấy giá trị trong hidden form
    var x = document.getElementById("typeID").options.length;
          for(var i=0; i < x; i++)
          {
            if(document.getElementById('typeID').options[i].value == k) {
              document.getElementById('typeID').selectedIndex = i;
              return;
            }
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
		var test = document.getElementsByName("newsDel[]");
		for(var i =0; i<test.length; i++){
		    if (test[i].checked == true) 
		    {
		    	return true;
		    } 
		}
    	alert ('Hãy chọn dòng để xóa!');
        return false;
	}
	</script>
</html>