
	function onIOS(){
		
		var divIOS = document.getElementById("divIOS");
		var divDoHoa = document.getElementById("divDoHoa");
		var divTinHocVP = document.getElementById("divTinHocVP");
		var divLapTrinhDD = document.getElementById("divLapTrinhDD");
		divIOS.style.display ="block";
		divDoHoa.style.display ="none";
		divTinHocVP.style.display="none";
		divLapTrinhDD.style.display="none";
		
	}
	
	

	function onDoHoa(){
		// ẩn phần đăng kí
		// hiển thị div đăng 
		var divIOS = document.getElementById("divIOS");
		var divDoHoa = document.getElementById("divDoHoa");
		var divTinHocVP = document.getElementById("divTinHocVP");
		var divLapTrinhDD = document.getElementById("divLapTrinhDD");
		divLapTrinhDD.style.display="none";
		divTinHocVP.style.display="none";
		divIOS.style.display ="none";
		divDoHoa.style.display ="block";
		
	}
	function onTinHocVP(){
		// ẩn phần đăng nhập
		// hiển thị div đăng 
		var divIOS = document.getElementById("divIOS");
		var divDoHoa = document.getElementById("divDoHoa");
		var divTinHocVP = document.getElementById("divTinHocVP");
		var divLapTrinhDD = document.getElementById("divLapTrinhDD");
		divIOS.style.display ="none";
		divDoHoa.style.display ="none";
		divTinHocVP.style.display="block";
		divLapTrinhDD.style.display="none";
		
	}
	
	
	//Sư kiện khi nhấn tab đăng kí
	function onLapTrinhDD(){
		// ẩn phần đăng kí
		// hiển thị div đăng 
		var divIOS = document.getElementById("divIOS");
		var divDoHoa = document.getElementById("divDoHoa");
		var divTinHocVP = document.getElementById("divTinHocVP");
		var divLapTrinhDD = document.getElementById("divLapTrinhDD");
		divLapTrinhDD.style.display="block";
		divTinHocVP.style.display="none";
		divIOS.style.display ="none";
		divDoHoa.style.display ="none";
		
	}
	function onXacNhan(){
		// ẩn phần đăng kí
		// hiển thị div đăng 
		var divXacNhan = document.getElementById("divXacNhan");
		var divHoanThanh = document.getElementById("divHoanThanh");
		divXacNhan.style.display="block";
		divHoanThanh.style.display="none";
		
	}
	function onHoanThanh(){
		var divXacNhan = document.getElementById("divXacNhan");
		var divHoanThanh = document.getElementById("divHoanThanh");
		divXacNhan.style.display="none";
		divHoanThanh.style.display="block";
		
	}
	function kiemtraEmailHopLe() {
		var inputTag = document.getElementById("email");
		var email = /^([\w\.])+@([a-zA-Z0-9\-])+\.([a-zA-Z]{2,4})(\.[a-zA-Z]{2,4})?$/;
		var theP = document.getElementById("pthongbao");
		if(inputTag.value.match(email))
		{
			theP.style.display ="none";
			return true; 
		} else{
			theP.style.display = "block";
			theP.innerHTML ="HÃY NHẬP EMAIL HỢP LỆ ";
			frmDangNhap.email.style.border ="solid 2px red";
			theP.style.color = "red";
			return false;
		}
			
	}
	function ktraBatBuocDangKi(){
		var pthongbao = document.getElementById ("pthongbao");
		var hoten = document.getElementById ("hoten");
		var dienthoai = document.getElementById("dienthoai");
		var email =  document.getElementById("email");
		if(frmDangNhap.hoten.value == "" && frmDangNhap.dienthoai.value == ""  && frmDangNhap.email.value=="")
		{
			frmDangNhap.hoten.style.border ="solid 2px red";
			frmDangNhap.dienthoai.style.border ="solid 2px red";
			frmDangNhap.email.style.border ="solid 2px red";
			pthongbao.style.display ="block";
			
			pthongbao.innerHTML = "Bạn cần nhập dữ liệu cho các trường đầy đủ" +"<br/>";
			return false;
		} else if(frmDangNhap.hoten.value == "") {
			frmDangNhap.hoten.style.border ="solid 2px red";
			frmDangNhap.dienthoai.style.border ="none";
			frmDangNhap.email.style.border ="none";
			pthongbao.style.display ="block";
			pthongbao.innerHTML = "Bạn phải điền họ tên";
			return false;
		} else if(frmDangNhap.email.value == "") {
			frmDangNhap.email.style.border ="solid 2px red";
			frmDangNhap.dienthoai.style.border ="none";
			frmDangNhap.hoten.style.border ="none";
			pthongbao.style.display ="block";
			pthongbao.innerHTML = "Bạn phải điền email";
			return false;
		}else if(frmDangNhap.dienthoai.value == "") {
			frmDangNhap.dienthoai.style.border ="solid 2px red";
			frmDangNhap.hoten.style.border ="none";
			frmDangNhap.email.style.border ="none";
			pthongbao.style.display ="block";
			pthongbao.innerHTML = "Bạn phải điền số điện thoại";
			return false;
		}else {
			frmDangNhap.dienthoai.style.border ="none";
			frmDangNhap.hoten.style.border ="none";
			frmDangNhap.email.style.border ="none";
			pthongbao.style.display ="none";
			return true;
		}
		
	}
	function KiemTraHopLe(){
		return ktraBatBuocDangKi() && kiemtraEmailHopLe();
	}
	