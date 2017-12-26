function createTopic(){

	if(!checkinput())
		return ;
	var id=1;

	var newTopic={
			name : $("#topicName").val(),
			description : $("#description").val(),
			groupNumberLimit : $("#groupLimit").val(),
			groupStudentLimit : $("#groupMemberLimit").val(),
	};
	//alert(JSON.stringify(newTopic));
	$.ajax({			
		url:  "/seminar/"+id+"/topic",
		type: "POST",
		contentType: "application/json;charset=utf-8",
		data: JSON.stringify(newTopic),
		success: function(data)
		{
				alert("创建成功"+data);
				window.location.href="/TeacherSeminarInfo";
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
    var name =$("#topicName").val();
	var description = $("#description").val();
	var groupLimit = $("#groupLimit").val();
	var groupMemberLimit= $("#groupMemberLimit").val();

    if(warn == null || warn.length == 0){
        if(name == ""){
            warn = "名称不能为空。";
        }else if(description == ""){
            warn = "说明不能为空。";
        }else if( groupLimit  == ""){
            warn = "请输入组数限制。";
        }
        else if(groupMemberLimit==""){
        	warn = "请输入小组人数限制。"
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