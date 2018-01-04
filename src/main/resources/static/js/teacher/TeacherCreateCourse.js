var userId=1;
window.onload = function(){
	//*****get userId
	userId=localStorage.getItem("userId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
}
function createCourse(){
	
	if(!checkinput())
		return ;
	
    var teacher={
    		id : userId
    };
	var newCourse={
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
	alert(JSON.stringify(newCourse));
	$.ajax({			
		url:  "/course/"+userId,
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify(newCourse),
		success: function(data,status)
		{
				alert("创建成功"+data);
				window.location.href='/TeacherCourseHomePage';
		},
		error:function()
		{
			alert("添加失败");
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
	var presentation= $("#seminarGrade").val();
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
        else if((parseInt(report)+parseInt(presentation))!=100){
        	warn="报告和讨论课分数之和应为100。";
        }
        else if((parseInt(c)+parseInt(b)+parseInt(a))!=100){
        	warn="各阶段分数之和应为100。";
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