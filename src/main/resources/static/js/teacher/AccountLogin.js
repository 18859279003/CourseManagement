/**
 * zdd
 */
function login(){
	var user={
			phone : $("#userName").val(),
			password : $("#password").val(),
	};
    $.ajax({
        url : "/signin",
        type : "POST",
        contentType : "application/json;charset=utf-8",
        data:JSON.stringify(user),   
        async:false,
        success:function(data){
            alert("登录成功！" + data);
            window.location.href="/TeacherHomePage";
        },
        error:function(){
            alert("登录失败！");
        }
    });
}