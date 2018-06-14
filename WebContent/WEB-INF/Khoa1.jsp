 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page import="Bean.Account" %>

<html>
	<head>
		 <title>Đăng Ký lớp học</title>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		  <link rel="stylesheet" href="css/Khoa1.css" type="text/css" media="all">
		 <!--  <script type="text/javascript" src="LichKhaiGiang.js"></script> -->
		  <script type="text/javascript" src="js/myjsLichkhaigiang.js"></script>

	</head>
	<body>
	
	  
	
		<div id="container">
			<div style="padding-top:50px;">
			<a id="dangki" href="#" class="tab" onclick="onXacNhan()">Xác nhận thông tin</a>
			<a id="dangnhap" href="#" class="tab" onclick="onHoanThanh()">Hoàn tất đăng kí</a>
		<!-- =============================================Form xác nhận=========================================== -->
	
			<div id="divXacNhan" class="divForm">
				<form name="frmDangKi">
					<div id="Trang_1">
					
								<div class="col-md-9">
									<div class="row">
										<div class="col-md-12 col-xs-5" style="margin-top: 20px; line-height: 120%;">Mời bạn xác nhận những thông tin sau:</div>
									</div>         
									                 
									<div class="row" style="margin-top:20px;">
										<div class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Môn học:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$MonHoc" type="text" id="ctl00_cphBody_MonHoc" class="Nhap_lieu" readonly="readonly" value="${course_name }"></div>
										<div style="clear:both;"></div>
									</div>
								
									<div class="row" style="margin-top:20px;">
										<div class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Mã lớp:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$Malop" type="text" id="ctl00_cphBody_Malop" class="Nhap_lieu" readonly="readonly" value="${class1.classname }"></div>
										<div style="clear:both;"></div>
									</div>
									<div class="row" style="margin-top:20px;"> 
										<div class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Lịch học:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$LichHoc" type="text" id="ctl00_cphBody_LichHoc" class="Nhap_lieu" readonly="readonly" value="${class1.timestudy }"></div>
										<div style="clear:both;"></div>
									</div>
									<div class="row" style="margin-top:20px;"> 
										<div class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Học phí:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$hocphi" type="text" id="ctl00_cphBody_LichHoc" class="Nhap_lieu" readonly="readonly" value="${fee }"></div>
										<div style="clear:both;"></div>
									</div>
									<div class="row" style="margin-top:20px;">                          
										<div class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Ngày khai giảng:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$Ngaykhaigiang" type="text" id="ctl00_cphBody_Ngaykhaigiang" class="Nhap_lieu" readonly="readonly" value="${class1.startday }"></div>
										<div style="clear:both;"></div>
									</div>
									<div class="row" style="margin-top:20px;min-height: 40px;" id="Khungdiadiem">                          
										<div id="ctl00_cphBody_TieudeDiadiem" class="col-md-3 col-xs-12" style="margin-top:12px;padding-right:0px;">Địa điểm học:</div>
										<div class="col-md-9 col-xs-5"><input name="ctl00$cphBody$Diadiem" type="text" id="ctl00_cphBody_Diadiem" class="Nhap_lieu" readonly="readonly" value="${class1.location }"></div>
										<div style="clear:both;"></div>
									</div>
									<div class="row">
										<div class=" tiep-tuc col-xs-5 col-md-12" >
											<a href="#" class="xacnhan" onclick="onHoanThanh()" style="padding-top:5px;">Xác nhận</a>
										</div>
									</div>
								</div>
								
								
								
							</div>
						
				</form>
				
			</div>
		<!-- ================================================Form Hoàn Thành=============================================== -->
			<div id ="divHoanThanh" class="divForm">
				<form name="frmDangNhap">
					<div id="Trang_2">
					<!-- ====================CÂU THÔNG BÁO=================== -->
						<div id="thongbao" class="col-md-12 col-xs-5">
							<p id="pthongbao">
						
							</p>
						</div>
						<%
						if(session.getAttribute("account")!=null)
						{ Account acc=(Account)session.getAttribute("account");
						%>
						<div class="col-md-9">
						  <div style="margin-top: 20px;" class="col-xs-12">Vui lòng hoàn tất thông tin cá nhân để nhận ưu đãi:</div>
						  <div style="margin-top:10px;">
								<div class="col-md-4 col-xs-12" style="margin-top:12px;"><span>Họ tên</span> <span style="color:red;position: relative;top: 5px;">*</span></div>
								<div class="col-md-8 col-xs-5"><input id="hoten" class="Nhap_lieu" style="background-color: #fff !important;" value="<%=acc.getName() %>"></div>
								<div style="clear:both;"></div>
							</div>
							<div style="margin-top:10px;">
								<div class="col-md-4 col-xs-12" style="margin-top:12px;"> <span="">Email <span style="color:red;position: relative;top: 5px;">*</span></div>
								<div class="col-md-8 col-xs-5"><input id="email" class="Nhap_lieu" style="background-color: #fff !important;" value="<%=acc.getMail() %>"></div>
								<div style="clear:both;"></div>
							</div>
							<div style="margin-top:10px;"> 
								<div class="col-md-4 col-xs-12" style="margin-top:12px;"><span>Số điện thoại</span> <span style="color:red;position: relative;top: 5px;">*</span></div>
								<div class="col-md-8 col-xs-5"><input id="dienthoai" class="Nhap_lieu" style="background-color: #fff !important;" value="<%=acc.getPhonenumber() %>"></div>
								<div style="clear:both;"></div>
							</div>
							<div style="margin-top:10px;">                          
								<div class="col-md-4 col-xs-12" style="margin-top:12px;">Đối tượng:</div>
								<div class="col-md-8 col-xs-5"><select id="thanhphan" class="Nhap_lieu" 
								style="background-color: #fff !important;">
								<option value="0">-- Chọn đối tượng --</option>
								<option style="background-color:#FFFFFF" value="1">Sinh viên</option>
								<option style="background-color:#FFFFFF" value="2">Đã tốt nghiệp, đang tìm việc</option>
								<option style="background-color:#FFFFFF" value="3">Đã đi làm</option>
								<option style="background-color:#FFFFFF" value="4">Khác</option>
								</select>
								</div>
								<div style="clear:both;"></div>
							</div>
							<div style="margin-top:10px;">                          
								<div class="col-md-4 col-xs-12" style="margin-top:12px;">Ghi chú khác:</div>
								<div class="col-md-8 col-xs-5"><textarea id="ghichu" name="ghichu" rows="4" class="Nhap_lieu" style="background-color: #fff !important;"></textarea></div>
								<div style="clear:both;"></div>
							</div>
							<!-- <div style="padding-top:40px;"></div> -->
							<div class="row">
								<div class=" tiep-tuc col-xs-5 col-md-12" >
									<a class="xacnhan" href="Insert_StudentClass?class_id=${class1.class_id }&account_id=<%=acc.getAccount_id() %>" onclick="return KiemTraHopLe()">Hoàn tất</a>
								</div>
							</div>
						 </div>   
						 <%} %>
					</div> <!--  trang2 -->
				</form>
			</div>
			<!-- ==========================================KẾT THÚC FORM HOÀN THÀNH========================================== -->
			
		</div>
		</div>

	</body>
</html>