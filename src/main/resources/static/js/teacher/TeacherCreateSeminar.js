function createSeminar(){

	if(!checkinput())
		return ;
	var courseId=1;

	var fixed;
	if($("#groupingMethod").find("option:selected").text()=="固定分组")
		fixed=true;
	else
		fixed=false;
	
	var newSeminar={
			name : $("#seminarName").val(),
			description : $("#description").val(),
			fixed : fixed,
			startTime : $("#startTime").val(),
			endTime : $("#endTime").val()
	};
	//alert(JSON.stringify(newSeminar));
	$.ajax({			
		url:  "/course/"+courseId+"/seminar",
		type: "POST",
		contentType: "application/json;charest=utf-8",
		data: JSON.stringify(newSeminar),
		success: function(data)
		{
				alert("创建成功"+data);
				window.location.href="/TeacherCourseInformation";
		},
		error:function()
		{
			alert("创建失败");
		}
		});	
	
}
//检查输入是否有空
function checkinput(){
    var warn = "";
    var name =$("#seminarName").val();
    var description = $("#seminarDescription").val();
    var begintime = $("#startTime").val();
    var endtime = $("#endTime").val();

    if(warn == null || warn.length == 0){
        if(name == ""){
            warn = "名称不能为空。";
        }else if(description == ""){
            warn = "说明不能为空。";
        }else if(begintime == null){
            warn = "请选择开始时间。";
        }else if( endtime  == null){
            warn = "请选择结束时间。";
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