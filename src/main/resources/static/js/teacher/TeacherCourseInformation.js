/**
 * Created by lenovo on 2017/12/6.
 */
var courseId = 1;
window.onload = function(){
	//************getcourseId
	courseId=localStorage.getItem("courseId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	getClassInfo();
	getSeminarsInfo();
}

//获取已创建的班级信息
function getClassInfo() {
    var classlist;
    $.ajax({
        url: "/course/"+courseId+"/class",
        type: "GET",
        success: function (data) {
            classlist = data;
            $("#classlist").html("");
            for (var i in classlist) {
                var item = classlist[i];
                $("#classlist").append(
                		"<div class=\"block\" onclick='classinfo("+item.id+")' style='cursor:pointer'>" +
                		"<div class=\"blockFont\" id=\"class"+ item.id + "\" >"+ item.name + "</div></div>");
            }//end for
            $("#classlist").append(" <div class=\"block\">"
                +"<img class=\"addImg\" src=\"../../Img/smalladd.png\" alt=\"添加\" onclick='add()' style='cursor:pointer'></div>");
            alert("获取班级信息成功！");
        },
        error: function () {
            alert("获取班级信息失败!");
        }
    });
}
function classinfo(id){
	//********saveclassId
	localStorage.setItem("classId",id);
	window.location.href="/TeacherClassInfo";		
}
//获取已创建的讨论课列表
function getSeminarsInfo() {
    var seminarlist;

    $.ajax({
        url: "/course/"+courseId+"/seminar",
        type: "GET",
        success: function (data) {
            seminarlist = data;
            $("#seminarlist").html("");
            for (var i in seminarlist) {
                var item = seminarlist[i];
                $("#seminarlist").append(
                		"<div class=\"block\" onclick='seminarinfo("+item.id+")' style='cursor:pointer'>" +
                		"<div class=\"blockFont\" id=\"seminar"+ item.id + "\">"+ item.name + "</div></div>");
            }//end for
            $("#seminarlist").append(" <div class=\"block\">"
            +"<a href='/TeacherCreateSeminar' ><img class=\"addImg\" src=\"../../Img/smalladd.png\" alt=\"添加\" ></a></div>");      //页面跳转！！！
            alert("获取讨论课列表成功！");
        },
        error: function () {
            alert("获取讨论课列表失败！");
        }
    })
}
function seminarinfo(id){
	//********save seminarId
	localStorage.setItem("seminarId",id);
	window.location.href="/TeacherSeminarInfo";		
}
function goback(){
	window.history.go(-1);  //返回上一页
}

function add()
{
	localStorage.setItem("courseId",courseId);
	window.location.href="/TeacherCreateClass";	
}
