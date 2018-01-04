var userId=3;
window.onload=init;

function init(){
	//**************************get userId
	userId=localStorage.getItem("userId");
	var personinfo;
	$.ajax({			
		url:  "/me/"+userId,
		type: "GET",
		async: false,
		success: function(data)
		{	
			personinfo=data;
			var gender=personinfo.gender=="0"?"男":"女";
			var education;
			if(personinfo.education=="1") education="本科";
			else if(personinfo.education=="2") education="硕士研究生";
			else if(personinfo.education=="3") education="博士研究生";
			$("#personinfomodify").empty();
			$("#personinfomodify").append(
			        "<tr class='itemName'>" + 
			        "<td>用户名：<span>" + personinfo.phone + "</span></td>" +
			        "<td>教工号：<input type='text' id='number' value='" + personinfo.number + "'/></td>" +
			        "</tr>" +
			        "<tr class='itemName'>" + 
			        "<td>姓名：<input type='text' id='name' value='" + personinfo.name + "'/></td>" +
			        "<td>性别：<input type='text' id='sex' value='" + gender + "'/></td>" +
			        "</tr>" +
			        "<tr class='itemName'>" + 
			        "<td>学校：<input type='text' id='school' value='" + personinfo.school.name + "'/></td>" +
			        "<td>学历：<input type='text' id='title' value='" + education + "'/></td>" +
			        "</tr>" +
			        "<tr class='itemName'>" + 
			        "<td>E-mail：<input type='text' id='e-mail' value='" + personinfo.email + "'/></td>" +
			        "<td>联系方式：<input type='text' id='phone' value='" + personinfo.phone + "'/></td>" +
			        "</tr>" 

			)	
			
		},
		error:function()
		{
			alert("获取用户信息失败");
		}
		});
}

function changePersonInfo(){

	if(!checkinput())
		return ;
	
	var gender;
	var sex=$("#sex").val();
	if(sex=="男") gender=0;
	else if(sex=="女") gender=1;
	else{
		alert("性别请输男或女。");
		return ;
	}
	var title;
	var t=$("#title").val();
	if(t=="本科") title=1;
	else if(t=="硕士研究生") title=2;
	else if(t=="博士研究生") title=3;
	else{
		alert("请输入正确学历：本科、硕士研究生或博士研究生。");
		return ;		
	}
	var school={name :$("#school").val()};
	var modifyinfo={
			"number":$("#idnum").val(),
			"name":$("#name").val(),
			"gender":gender,
			"school":school,
			"title":t,
			"email":$("#email").val(),
			"phone":$("#phone").val()
	};
	var modifyinfo={"name": $("#name").val(), "phone": $("#phone").val()};

	$.ajax({			
		url:  "/me/"+userId,
		type: "PUT",
		contentType: "application/json",
		data: JSON.stringify(modifyinfo),
		async: false,
		success: function(data,status)
		{						
			alert("修改成功"+status);
			window.location.href="/StudentHomePage";
		},
		error:function()
		{
			alert("修改失败");
		}
		});	
}
//检查输入是否有空
function checkinput(){
    var warn = "";
    var name = document.getElementById("name").value;
    var school = document.getElementById("school").value;
    var number = document.getElementById("number").value;
    if(warn == null || warn.length == 0){
        if(name == ""){
            warn = "姓名不能为空。";
        }else if(number == ""){
            warn = "学号不能为空。";
        }else if( school  == ""){
            warn = "学校不能为空。";
        }
        if(warn !=null && warn.length !=0){
            alert(warn);
            return false;
    }
        else
           return true;
    }
}
