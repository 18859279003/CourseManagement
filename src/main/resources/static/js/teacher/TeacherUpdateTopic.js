var topicId=1;
window.onload = function(){
	//************gettopicId
	topicId=localStorage.getItem("topicId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
    $(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init(){

	//获取话题信息
	$.ajax({			
		url: "/topic/"+topicId,
		type: "GET",
		data: {},
		async: false,
		success: function(data)
		{
			var topicInfo=data;
			$("div#name").append( "<input type='text' id='topicName' class='bigInput' value='"+topicInfo.name+"'>");
			$("div#description").append("<textarea class='textStyle' id='topicDescription'>"+topicInfo.description+"</textarea>")
			$("div#groupLimit").append( "<input type='text' id='groupNumberLimit' class='middleInput' value='"+topicInfo.groupNumberLimit+"'>");
			$("div#number").append( "<input type='text' id='groupStudentLimit' class='middleInput' value='"+topicInfo.groupStudentLimit+"'>");
		},
		error:function()
		{
			alert("获取话题信息失败");
		}
		});
}

//提交
function submit()
{
	var serial="A";	
	var newTopic={
			//serial:serial,
			name : $("#topicName").val(),
			description:$("#topicDescription").val(),
			groupNumberLimit:$("#groupNumberLimit").val(),
			groupStudentLimit:$("#groupStudentLimit").val()
	};
	//alert(JSON.stringify(newClass));
	$.ajax({			
		url:  "/topic/"+topicId,
		type: "PUT",
		//dataType : "JSON",
		contentType: "application/json;charest=utf-8",
		data: JSON.stringify(newTopic),
		success: function(data)
		{
				alert("修改成功"+data);
				window.location.href="/TeacherTopicCheckBefore";
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
	window.location.reload()
}