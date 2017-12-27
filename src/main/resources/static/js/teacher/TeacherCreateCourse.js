function createCourse(){

	if(!checkinput())
		return ;
	var proportions={
			report : $("#reportGrade").val(),
			presentation : $("#seminarGrade").val(),
			c : $("#seminarGrade3").val(),
			b : $("#seminarGrade4").val(),
			a : $("#seminarGrade5").val()		
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
			threePointPercentage : $("#seminarGrade3").val()
	};
	$.ajax({			
		url:  "/course",
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