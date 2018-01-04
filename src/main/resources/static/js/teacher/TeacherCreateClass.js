var count=1;//别动
var courseId=1;
window.onload = function(){
	//************get courseId
	courseId=localStorage.getItem("courseId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
	$(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
}
function createClass(){

	if(!checkinput())
		return ;

	var time="";
	for(var i=1;i<=count;i++){
		time+=$("#week"+count).find("option:selected").text()+
			$("#day"+count).find("option:selected").text()+
			$("#lesson"+count).find("option:selected").text()+"  ";
	}

	var newClass={
			name : $("#className").val(),
			site : $("#classSite").val(),
			classTime: time,
			reportPercentage : $("#reportGrade").val(),
			presentationPercentage : $("#seminarGrade").val(),
			fivePointPercentage : $("#seminarGrade5").val(),
			fourPointPercentage : $("#seminarGrade4").val(),
			threePointPercentage : $("#seminarGrade3").val()
	};
	//alert(JSON.stringify(newClass));
	$.ajax({			
		url:  "/course/"+courseId+"/class",
		type: "POST",
		//dataType : "JSON",
		contentType: "application/json;charest=utf-8",
		data: JSON.stringify(newClass),
		success: function(data)
		{
				alert("创建成功"+data);
				window.location.href='/TeacherCourseInformation';
		},
		error:function()
		{
			alert("创建失败");
		}
		});	
	
}

//添加时间
function add(){
	count++;
	$("div#add").after(
			"<div class='item'>"+
            "<label class='itemName'>上课时间:</label>"+
            "<select id='week" + count + "' class='bigSelect'>"+
               "<option value ='单周'>单周</option>"+
               "<option value ='双周'>双周</option>"+
               "<option value ='每周' selected='selected'>每周</option>"+
            "</select>"+
            "<select id='day"  + count + "' class='smallSelect'>"+
               "<option value ='周一'>周一</option>"+
               "<option value ='周二'>周二</option>"+
               "<option value ='周三' >周三</option>"+
               "<option value ='周四'>周四</option>"+
               "<option value ='周五'>周五</option>"+
               "<option value ='周六' >周六</option>"+
               "<option value ='周日' >周日</option>"+
            "</select>"+
            "<select id='lesson" + count + "' class='smallSelect'>"+
               "<option value ='一二节'>一二节</option>"+
               "<option value ='三四节'>三四节</option>"+
               "<option value ='五六节' >五六节</option>"+
               "<option value ='七八节'>七八节</option>"+
               "<option value ='九十节'>九十节</option>"+                  
            "</select></div>"
			);
}
//检查输入是否有空
function checkinput(){
    var warn = "";
    var name =$("#className").val();
    var site=$("#classSite").val();
    var report = $("#reportGrade").val();
	var presentation= $("#seminarGrade").val();
	var c = $("#seminarGrade3").val();
	var b = $("#seminarGrade4").val();
	var a = $("#seminarGrade5").val();
    if(warn == null || warn.length == 0){
        if(name == ""){
            warn = "名称不能为空。";
        }else if(site == ""){
            warn = "地点不能为空。";
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