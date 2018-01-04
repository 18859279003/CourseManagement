var classId=1;
var studentId=3;
window.onload = function(){
	//*********getstudentId/classId
	studentId=localStorage.getItem("studentId");
	classId=localStorage.getItem("classId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));;
	init();
}
function init(){
	 $.ajax({			
			url: "/class/"+classId+"/classgroup",
			type: "GET",
			data: {studentId: studentId},
			async: false,
			success: function(data)
			{
				var leader=data.leader;
				var members=data.members;                
				//获取队长信息
				$("tr#leader").append(
						"<td>队长</td>"+"<td>"+leader.number+"</td>"+"<td>"+leader.name+"</td>");
				//获取队员信息
				for(var i in members)
					{
					$("table#studenttable").append(
							"<tr class='alt'><td>队员</td>"+
							"<td>"+members[i].number+"</td>"+
                            "<td>"+members[i].name+"</td></tr>");
					}					   					
			},
			error:function()
			{
				alert("获取课程信息失败");
			}
			});
}