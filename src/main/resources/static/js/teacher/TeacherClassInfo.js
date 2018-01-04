/**
 * Created by lenovo on 2017/12/6.
 */
var classId=1;
window.onload = function(){
	//************getclassId
	classId=localStorage.getItem("classId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	getClassInfo();
}

//获取班级的具体信息
function getClassInfo(){
    var classInfo;
    $.ajax({
        url:"/class/"+classId,
        type:"GET",
        success:function(data){
            classInfo = data;
            alert(JSON.stringify(classInfo));
            $("#className").append(classInfo.name);
            $("#name").append(classInfo.name);
            $("#address").append(classInfo.site);
            $("#time").append(classInfo.classTime);
            $("#presentation").append(classInfo.presentationPercentage);
            $("#report").append(classInfo.reportPercentage);
            $("#agrade").append(classInfo.fivePointPercentage);
            $("#bgrade").append(classInfo.fourPointPercentage);
            $("#cgrade").append(classInfo.threePointPercentage);
            
            alert("获取班级信息成功！");
        },
        error:function(){
            alert("获取班级信息失败！");
        }
    })
}

//返回上一页
function goback(){
	window.location.href="/TeacherCourseInformation";  //返回上一页
}

//下载学生名单
function downloadfile(){
   alert("下载成功");
}

//修改班级
function updateClass(){
	window.location.href='/TeacherUpdateClass';
}
//删除班级
function deleteclass(){
    $.ajax({
        url:"/class/"+classId,
        type:"DELETE",
        success:function(data){
            alert("删除班级成功！");
            window.location.href='/TeacherCourseInformation';
        },
        error:function(){
            alert("删除班级失败！");
        }
    });
}