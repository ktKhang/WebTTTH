
 $(document).ready(function(){
	
    //validate login
    //
    //ẩn các thông báo
    $("#title_error").hide();
    $("#author_error").hide();
    $("#message_error").hide();
    var error_tittle = false;
    var error_author = false;
    var error_message = false;
    
    $("#tittleID").focusout(function() {

        check_tittle();
    });
     $("#authorID").focusout(function() {

        check_author();
    });
    $("#message").focusout(function() {

        check_message();
    });

    function check_tittle() {
    
        var tittle_length = $("#tittleID").val().length;
        if($("#tittleID").val()=="")
        {
            $("#tittle_error").html("Hãy nhập tiêu đề bài viết!");
            $("#tittle_error").show(); 
            //$("#username_error").css("color","red");
            error_tittle = false;
        }
        else {
            $("#tittle_error").hide();
            error_tittle = true;
        }
    
    }
    
    function check_author() {
    
        var author_length = $("#authorID").val().length;
        if($("#authorID").val()=="")
        {
            $("#author_error").html("Hãy nhập tên người viết bài!");
            $("#author_error").show(); 
            //$("#username_error").css("color","red");
            error_author = false;
        }
        else {
            $("#author_error").hide();
            error_author = true;
        }
    
    }
    function check_message() {
    
        var message_length = $("#message").val().length;
        if($("#message").val()=="")
        {
            $("#message_error").html("Hãy nhập nội dung!");
            $("#message_error").show(); 
            error_message = false;
        }
        else {
            $("#message_error").hide();
            error_message = true;
        }
    
    }

    
    $("#btnSave").click(function() {

        check_tittle();
        check_author();
        check_message();
        
        if(error_tittle == true && error_author == true && error_message == true) {
            alert("Đã tạo thành công!!");
            return true;
        }     
        return false;
    });
});
