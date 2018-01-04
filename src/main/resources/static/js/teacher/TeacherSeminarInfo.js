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
			var startDate=new Date(seminarInfo.startTime);
			var starttime=startDate.getFullYear()+"-"+(startDate.getMonth()+1)+"-"+startDate.getDate();
			var endDate=new Date(seminarInfo.endTime);
			var endtime=endDate.getFullYear()+"-"+(endDate.getMonth()+1)+"-"+endDate.getDate();
			
			$("label#name").append(seminarInfo.name);
			$("label#description").append(seminarInfo.description);
			$("label#groupingMethod").append(seminarInfo.groupingMethod);
			$("label#startTime").append(starttime);
			$("label#endTime").append(endtime);
			
			var topiclist=seminarInfo.topics;
			
			var number=seminarInfo.topics.length;
			
			var i =number;
			for(i;i>0;i--)
			{
				$("div.topicBlockBody").prepend("<div class='topicBlock'><div class='topicBlockFont' onclick='concreteTopic("+topiclist[i-1].id+")' style='cursor:pointer'>"+topiclist[i-1].name+"</div></div>")
			}
		},
		error:function()
		{
			alert("获取课程信息失败");
		}
		});
}

//删除讨论课
function deleteSeminar()
{
	if (confirm("您确定要删除该讨论课吗？")){		
	//删除讨论课
	$.ajax({			
		url: "/seminar/"+seminarId,
		type: "DELETE",
		data: {},
		async: false,
		success: function(data)
		{
			alert("删除成功");
			window.location.href='/TeacherCourseInformation';
		},
		error:function()
		{
			alert("删除失败");
		}
		});
	}
	else{}
}
//返回上一层
function back()
{
	window.location.href='/TeacherCourseInformation';
}
//跳转评分界面
function score()
{
	//********save seminarId
	localStorage("seminarId",seminarId);
	window.location.href='/TeacherScoreHome';
}
//修改
function modifySeminar()
{
	//********save seminarId
	localStorage("seminarId",seminarId);
	window.location.href='/TeacherUpdateSeminar';
}

//点击话题
function concreteTopic(id)
{
	//********save topicId
	localStorage("topicId",topicId);
	window.location.href='/TeacherTopicCheckBefore';
}
//添加话题
function addTopic()
{
	//********save seminarId
	localStorage("seminarId",seminarId);
	window.location.href='/TeacherCreateTopic';
}



