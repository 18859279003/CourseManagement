var seminarId=1;
window.onload = function(){
	//************getseminarId
	seminarId=localStorage.getItem("seminarId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
    $(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init(){
	//获取讨论课信息
	$.ajax({			
		url: "/seminar/"+seminarId,
		type: "GET",
		data: {},
		async: false,
		success: function(data)
		{
			var seminarInfo=data;
			$("div#name").append( "<input type='text' id='seminarName' class='bigInput' value='"+seminarInfo.name+"'>");
			$("div#description").append("  <textarea class='textStyle' id='seminarDescription'>"+seminarInfo.description+"</textarea>");

		},
		error:function()
		{
			alert("获取讨论信息失败");
		}
		});
	
}

//提交
function submit()
{
	var fixed;
	if($("#groupingMethod").find("option:selected").text()=="固定分组")
		fixed=true;
	else
		fixed=false;
	
	var newSeminar={
			name : $("#seminarName").val(),
			description:$("#seminarDescription").val(),
			fixed : fixed,
			startTime: $("#startTime").val(),
			endTime: $("#endTime").val()
	};
	alert(JSON.stringify(newSeminar));
	$.ajax({			
		url:  "/seminar/"+seminarId,
		type: "PUT",
		//dataType : "JSON",
		contentType: "application/json;charest=utf-8",
		data: JSON.stringify(newSeminar),
		success: function(data)
		{
				alert("修改成功"+data);
				window.location.href='/TeacherSeminarInfo';
		},
		error:function()
		{
			alert("修改失败");
		}
		});	
}
//重置
function reload()
{
	window.location.reload();
}
