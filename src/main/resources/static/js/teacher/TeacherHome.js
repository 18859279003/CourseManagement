var userId;
window.onload=init;

function init(){
	//*************************************get userId
	userId=localStorage.getItem("userId");
	alert(userId);
	var personinfo;
	$.ajax({			
		url:  "/me/"+userId,
		type: "GET",
		async: false,
		success: function(data)
		{
			personinfo=data;
			var gender=personinfo.gender=="0"?"男":"女";
			var title;
			if(personinfo.title=="1") title="教授";
			else if(personinfo.title=="2") title="副教授";
			else if(personinfo.title=="3") title="助理教授";
			$("#personinfo table").empty();
			$("#personinfo table").append(
					"<tr class='itemName'>" + 
					"<td>用户名：<span>" + personinfo.phone + "</span></td>" + 
					"<td>教工号：<span>" + personinfo.number + "</span></td>" + 
					"</tr>" +
					"<tr class='itemName'>" + 
					"<td>姓名：<span>" + personinfo.name + "</span></td>" + 
					"<td>性别：<span>" + gender+ "</span></td>" + 
					"</tr>" +
					"<tr class='itemName'>" + 
					"<td>学校：<span>" + personinfo.school.name + "</span></td>" + 
					"<td>职称：<span>" + title + "</span></td>" + 
					"</tr>" +
					"<tr class='itemName'>" + 
					"<td>E-mail：<span>" + personinfo.email + "</span></td>" + 
					"<td>联系方式：<span>" + personinfo.phone + "</span></td>" + 
					"</tr>" 		
			)	
			
		},
		error:function()
		{
			alert("获取用户信息失败");
		}
		});
}
