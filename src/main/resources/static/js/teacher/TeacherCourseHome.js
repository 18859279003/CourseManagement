var userId=1;
myStorage = localStorage;
window.onload = function(){
	localStorage.getItem("userId");
	init();
}
function init(){
	$.ajax({			
		url:  "/course",
		type: "GET",
		data: {userId:userId},
		async: false,
		success: function(data)
		{
			var courselist=data;
			for(var i in courselist){
			var course=courselist[i];
			var startDate=new Date(course.startDate);
			var starttime=startDate.getFullYear()+"-"+(startDate.getMonth()+1)+"-"+startDate.getDate();
			var endDate=new Date(course.endDate);
			var endtime=endDate.getFullYear()+"-"+(endDate.getMonth()+1)+"-"+endDate.getDate();
			$("#courselist").append(
					"<div id='class"+course.id+"'class='main_box_right_content'>" + 
					"<h3 class='classtitle'>" +
						"<span onclick='courseinfo("+course.id+",\""+course.name+"\",\""+course.description+"\")' style='cursor:pointer'>" + course.name + "</span>" +
						"<button onclick='deleteCourse("+course.id+")' style='cursor:pointer'>删除课程</button>" +
						"<button onclick='updateCourse("+course.id+")' style='cursor:pointer'>修改课程</button>" +
					"</h3><hr />"+
					"<div class='classinfo'>" +
						"<table class='table'>" +
							"<tr>" +
								"<td class='tabletext'>课程简介：" + course.description+ "</td>" +
							"</tr>" +
							"<tr>" +
								"<td class='tabletext'>开始时间：" + starttime + "</td>" +
								"<td class='tabletext'>结束时间：" + endtime + "</td>" +
							"</tr>" +
						"</table>" +
						"</div><br/>"+
					"</div><br/>"
			)	
			}
			
		},
		error:function()
		{
			alert("获取课程信息失败");
		}
		});
}

function courseinfo(id,name,intro){
	//********save courseId/courseName/courseIntroduction
	localStorage.setItem("courseId",id);
	localStorage.setItem("courseName",name);
	localStorage.setItem("courseIntroduction",intro);
	window.location.href="/TeacherCourseInformation";	
}
function updateCourse(id){
	//********save courseId
	localStorage.setItem("courseId",id);
	window.location.href="/TeacherUpdateCourse";
}

function deleteCourse(id){
	$.ajax({			
		url:  "/course/"+id,
		type: "DELETE",
		data: {},
		success: function(data,status)
		{
			alert("删除成功"+status+id);
			window.location.reload();
		},
		error:function()
		{
			alert("删除失败");
		}
		});
}
