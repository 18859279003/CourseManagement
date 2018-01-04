var topicId=1;
var seminarId=1;
var studentId=3;
window.onload = function(){
	//*********gettopicId/studentid/seminarid
	studentId=localStorage.getItem("userId");
	seminarId=localStorage.getItem("seminarId");
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
			$("label#name").prepend(topicInfo.name);
			$("label#description").prepend(topicInfo.description);
			$("label#groupLimit").prepend(topicInfo.groupNumberLimit);
			$("label#groupMemberLimit").prepend(topicInfo.groupStudentLimit);
		},
		error:function()
		{
			alert("获取课程信息失败");
		}
		});
}
function chooseTopic()
{
	if (confirm("您确定要选择该话题吗？")){	
	var groupId;
	$.ajax({			
		url: "/seminar/"+seminarId+"/my",
		type: "GET",
		data: {studentId,studentId},
		async: false,
		success: function(data)
		{
			groupId=data.id;
		},
		error:function()
		{
			alert("获取小组信息失败");
		}
		});
	$.ajax({			
		url: "/group/"+groupId+"/topic",
		type: "POST",
		data:{topicId:topicId},
		async: false,
		success: function(data)
		{
			alert("选择成功");
			window.location.href="/StudentSeminarPage(fixed)";
		},
		error:function()
		{
			alert("选择话题失败");
		}
		});
	}
	else{alert("选择失败");}
}