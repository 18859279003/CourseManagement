/**
 * Created by lenovo on 2017/12/4.
 */
var studentId=1;
window.onload = getAllClass;

// 获取所有的班级信息
function getAllClass() {
	//**************getstudentId
	studentId = localStorage.getItem("studentId");
	var classlist;

	var courseName = $("#course").val();
	var teacherName = $("#teacher").val();
	
	$.ajax({
		url : "/class",
		type : "GET",
		data : {courseName:courseName, teacherName:teacherName},
		success : function(data) {
			//alert(JSON.stringify(data));
			classlist = data;
			$("#classlist").html("");
			if (classlist.length == 0)
				$("#classlist").html("可选课程列表为空");
			else
				for ( var i in classlist) {
					var item = classlist[i];
					$("#classlist").append(
							"<div class=\"main_box_right_content\" + id='" + item.id + "'>" 
									+ "<h3 class=\"classtitle\">"
									+ item.name
									+ "<button onclick='chooseCourse("
									+ item.id + ")'>选课</button></h3><hr/>"
									+ "<div class=\"classinfo\">"
									+ "<table class=\"table\">" + "<tr>"
									+ "<td class=\"tabletext\">地点："
									+ item.site + "</td>" + "</tr>"
									+ "<tr>" + "<td class=\"tabletext\">时间："
									+ item.classTime + "</td>"
									+ "</tr></table></div></div>");
				}
		},
		error : function() {
			alert("获取班级信息失败！");
		}
	})
}

//选课
function chooseCourse(id) {
	
	$.ajax({
		url : "/class/" + id + "/student",
		type : "POST",
		data : {studentId:studentId},
		success : function(data) {
		
			alert("选课成功！" + data);
		},
		error : function() {
			alert("选课失败！");
		}
	})
}
