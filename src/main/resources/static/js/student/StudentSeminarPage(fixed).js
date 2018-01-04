var seminarId=1;
window.onload = function(){
	init();
	//*********get seminarId
	seminarId=localStorage.getItem("seminarId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
}
function init(){

	//获取讨论课基本信息	
	$.ajax({			
		url: "/seminar/"+seminarId,
		type: "GET",
		data: {},
		async: false,
		success: function(data)
		{
			var seminarInfo=data;
			var startDate=new Date(seminarInfo.startTime);
			var starttime=startDate.getFullYear()+"-"+(startDate.getMonth()+1)+"-"+startDate.getDate();
			var endDate=new Date(seminarInfo.endTime);
			var endtime=endDate.getFullYear()+"-"+(endDate.getMonth()+1)+"-"+endDate.getDate();
			
			//获取讨论课名字
			$("label#name").append(seminarInfo.name);
			//获取讨论课简介
			$("label#description").append(seminarInfo.description);
			//获取分组模式
			$("label#groupingMethod").append(seminarInfo.groupingMethod);
			//获取开始结束时间
			$("label#startTime").append(starttime);
			$("label#endTime").append(endtime);
			
			var topics=data.topics;
			var number=data.topics.length;
			var i =number;
			for(i;i>0;i--)
			{
				$("div.blockBody").prepend("<div class='topicBlock'><div class='topicBlockFont' onclick='concreteTopic("+topics[i-1].id+")' style='cursor:pointer'>"+topics[i-1].name+"</div></div>")
			}
		},
		error:function()
		{
			alert("获取讨论课信息失败");
		}
		});
}

//点击话题
function concreteTopic(id)
{
	//*************save topicId
	localStorage.setItem("topicId",id);
	window.location.href="/StudentViewTopicPage(fixed)";
}
//点击查看分数
function viewGrade()
{
	//********************save seminarId
	localStorage.setItem("seminarId",seminarId);
	window.location.href="/StudentViewGradePage";
}