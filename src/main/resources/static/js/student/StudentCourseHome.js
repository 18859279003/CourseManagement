/**
 * Created by lenovo on 2017/12/4.
 */
var studentId=3;
window.onload = function(){
	//************getstudentId
	studentId=localStorage.getItem("userId");
	getClassInformation();
}

//获取班级信息列表
function getClassInformation(){
    var classlist;
    $.ajax({
        url:"/class/student/"+studentId,
        type:"GET",
        success:function(data){
            classlist = data;
            $("#content").html("");
            if(classlist.length==0)
                $("#content").html("课程列表为空");
            for(var i in classlist)
            {
                var item = classlist[i];
                $("#content").append(
                "<div class=\"main_box_right_content\" id=\"class" + item.id + "\"> "+
                "<h3 class=\"classtitle\">" +
                "<span onclick='classinfo("+item.id+")' style='cursor:pointer'>" + item.course.name + "</span>" +
                "<button onclick='cancelcourse(" + item.id +  ")'>退选课程</button>" +
                "</h3>" +
                "<div class=\"divideline\"></div>" +
                "<div  class=\"classinfo\">" +
                "<table class=\"table\">" +
                "<tr>" +
                "<td class=\"tabletext\">班级：<span>" + item.name + "</span></td>  <td class=\"tabletext\">课程地点：" + item.site + "</td>" +
            "</tr>" +
            "<tr>" +
            "<td class=\"tabletext\">教师：" + item.course.teacher.name + "</td>  <td class=\"tabletext\"></td>" +
            "</tr> </table> </div> </div>"
                );
            }
            alert("获取班级信息成功！" + data);
        },
        error:function(){
            alert("获取班级信息失败！");
        }
    });

}

//退课
function cancelcourse(classId){

    $.ajax({
        url:"/class/"+classId+"/student/"+studentId,
        type:"DELETE",
        success:function(data){
        	$("#class" + classId).remove();
            alert("退选课程成功！");
        },
        error: function () {
            alert("退选课程失败！");
        }
    })
}
//跳转
function classinfo(id)
{
	//************save classId
	localStorage.setItem("classId",id);
	alert(id);
	window.location.href='/StudentCourseInformation';
}
