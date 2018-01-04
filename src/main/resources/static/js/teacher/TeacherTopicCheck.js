var topicId=1;
window.onload = function(){
	//************get topicId
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
			//if(data=="") alert(data);
			var topicInfo=data;
			$("label#name").append(topicInfo.name);
			$("label#description").append(topicInfo.description);
			$("label#groupLimit").append(topicInfo.groupNumberLimit);
			$("label#groupMemberLimit").append(topicInfo.groupStudentLimit);
			//$("label#groupLeft").append(topicInfo.groupLeft);
		},
		error:function()
		{
			alert("获取话题信息失败");
		}
		});
	
}

//删除话题
function deleteTopic()
{
	if 
	(confirm("您确定要删除该话题吗？")){		
	$.ajax({			
		url: "/topic/"+topicId,
		type: "DELETE",
		data: {},
		async: false,
		success: function(data)
		{
			alert("删除成功"+data);
			window.location.href='/TeacherSeminarInfo';
		},
		error:function()
		{
			alert("删除失败");
		}
		});
	}
	else{}
}
//修改话题
function updateTopic()
{
	//**************save topicId
	localStorage.setItem("topicId",topicId);
	window.location.href='/TeacherUpdateTopic'
}