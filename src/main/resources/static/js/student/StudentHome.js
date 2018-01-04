var userId=3;
window.onload = getInformation;

function getInformation(){
	//*************************************get userId
	userId=localStorage.getItem("userId");
	var t;
	$.ajax({
		url:  "/me/"+userId,
		type:"GET",
		success:function(data){
			t = data;
			var education;
			if(t.education=="1") education="本科";
			else if(t.education=="2") education="硕士研究生";
			else if(t.education=="3") education="博士研究生";
			
			$("#username").html(t.phone);
			$("#stuffNum").html(t.number);
			$("#name").html(t.name);
			judgesex(t.gender);
			$("#school").html(t.school.name);
			$("#education").html(education);
			$("#email").html(t.email);
			$("#tel").html(t.phone);
//			$("#img").src(t.avatar);
		},
		error:function(){
			alert("获取信息失败！");
		}
	});

}

//判断性别
function judgesex(g){
	if(g=="1")
		$("#gender").html("女");
	else
		$("#gender").html("男");
}


