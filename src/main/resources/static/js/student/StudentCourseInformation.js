/**
 * Created by lenovo on 2017/12/4.
 */
var courseId = 1;

window.onload = function(){
	//*********get courseId
	courseId=localStorage.getItem("courseId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	getSeminar();
}
	
//获取讨论课信息
function getSeminar(){
    var seminarlist;

    $.ajax({
        url:"/course/"+courseId+"/seminar",
        type:"GET",
        success:function(data){
           // alert("获取讨论课列表成功！");
            seminarlist = data;
            $("#content").html("");
            if(seminarlist.length==0)
                $("#content").html("讨论课列表为空");
            for(var i in seminarlist) {
                var item = seminarlist[i];
                $("#content").append(
                "<div class=\"block\" onclick='seminarinfo("+item.id+")' style='cursor:pointer'>" +
                "<div class=\"blockFont\" id=\"seminar_" + item.id + "\">"+ item.name + "</div>"+ "</div>"
                );
            }//end for   
        },
        error:function(){
            alert("获取讨论课列表失败！");
        }
    });
}

//返回上一页按钮响应函数
function goback(){
	window.history.go(-1);  //返回上一页
}

function seminarinfo(id){
	//**********save seminarId
	localStorage.setItem("seminarId",seminarId);
	window.location.href="/StudentSeminarPage(fixed)";
	
}
function viewgroup(){
	window.location.href="/StudentViewGroupPage";
}

