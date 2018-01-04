/**
 * zdd
 */
var userId=1;
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
            alert("登录成功！" );
            //********************************saveuserid
            localStorage.setItem("userId",data.id 

);
            if(data.type==1)
            	window.location.href="/TeacherHomePage";
            else if(data.type==0)
            	window.location.href="/StudentHomePage";
        },
        error:function(){
            alert("登录失败！");
        }
    });
