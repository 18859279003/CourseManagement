var seminarId=1;
var studentId=3;
window.onload = function(){
	//*********getseminarId/studentid
	studentId=localStorage.getItem("userId");
	seminarId=localStorage.getItem("seminarId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init(){
	var groupinfo;
	$.ajax({			
		url: "/seminar/"+seminarId+"/my",
		type: "GET",
		data: {studentId,studentId},
		async: false,
		success: function(data)
		{
			groupinfo=data;
			$("table#studenttable").append(
					"<tr><td>"+groupinfo.seminar.name+"</td>"+
					"<td>"+"组名"
					+"</td>"+
					"<td>"+groupinfo.leader.name 
					+"</td>"+
					"<td>"+groupinfo.presentationGrade+"</td>"+

					"<td>"+groupinfo.reportGrade+"</td>"+
					"<td>"+groupinfo.finalGrade+"</td>"+
					"<td>" );
		},
		error:function()
		{
			alert("获取小组信息失败");
		}
		});
	
	
}

