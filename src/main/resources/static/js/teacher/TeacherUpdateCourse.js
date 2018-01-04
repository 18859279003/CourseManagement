var courseId=1;
window.onload = function(){
	//************getcourseId
	courseId=localStorage.getItem("courseId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
    $(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init() {
	// 获取左侧课程基本信息
	$.ajax({
		url : "/course/" + courseId,
		type : "GET",
		data : {},
		async : false,
		success : function(data) {
			var courseInfo = data;
			$("#coursename").attr("value", courseInfo.name);
			$("#courseinfo").val(courseInfo.description);
			$("#seminarGrade").attr("value",courseInfo.presentationPercentage);
			$("#reportGrade").attr("value", courseInfo.reportPercentage);
			$("#seminarGrade5").attr("value", courseInfo.fivePointPercentage);
			$("#seminarGrade4").attr("value", courseInfo.fourPointPercentage);
			$("#seminarGrade3").attr("value", courseInfo.threePointPercentage);
		},
		error : function() {
			alert("获取课程信息失败");
		}
	});
}

function updateCourse(){
	var userId=localStorage.getItem("userId");
    var teacher={
    		id : userId
    };
	if(!checkinput())
		return ;
	var modifyinfo={
			name:$("#coursename").val(),
			startDate:$("#begintime").val(),
			endDate:$("#endtime").val(),
			description:$("#courseinfo").val(),
			reportPercentage : $("#reportGrade").val(),
			presentationPercentage : $("#seminarGrade").val(),
			fivePointPercentage : $("#seminarGrade5").val(),
			fourPointPercentage : $("#seminarGrade4").val(),
			threePointPercentage : $("#seminarGrade3").val(),
			teacher : teacher
	};
	//alert(JSON.stringify(modifyinfo));
	$.ajax({			
		url:  "/course/"+courseId,
		type: "PUT",
		contentType: "application/json",
		data: JSON.stringify(modifyinfo),
		success: function(data,status)
		{
				alert("修改成功"+status);
				window.location.href='/TeacherCourseHomePage'
		},
		error:function()
		{
			alert("修改失败");
		}
		});	
	
}
//检查输入是否有空
function checkinput(){
    var warn = "";
    var name =$("#coursename").val();
    var begintime = $("#begintime").val();
    var endtime = $("#endtime").val();
    var report = $("#reportGrade").val();
	var presentation = $("#seminarGrade").val();
	var c = $("#seminarGrade3").val();
	var b = $("#seminarGrade4").val();
	var a = $("#seminarGrade5").val();
    if(warn == null || warn.length == 0){
        if(name == ""){
            warn = "名称不能为空。";
        }else if(begintime == ""){
            warn = "请选择开始时间。";
        }else if( endtime  == ""){
            warn = "请选择结束时间。";
        }
        else if(report==""||presentation==""||a==""||b==""||c==""){
        	warn = "请输入评分规则。"
        }
        if(warn !=null && warn.length !=0){
            alert(warn);
            return false;
    }
        else
           return true;
    }
}

function reset(){
	window.location.reload();
}