var groupId=1;
window.onload = function(){
	//************get groupId
	groupId=localStorage.getItem("groupId");
	getGroupInfo();
}
function score(){

	if(!checkinput())
		return;
	var score=$("#score").val();
	$.ajax({
		url: "/group/"+groupId + "/grade/report",
		type: "PUT",
		data: {reportGrade:score},
		async: false,
		success:function(data,status){
			alert(data+status);
			window.location.href="/TeacherScoreHome";
		},
		error:function(){
			alert("打分失败");
		}
	});		
}
function checkinput(){
	var score=$("#score").val();
	if(score==""){
		alert("请对报告进行打分。");
		return false;
	}
	
	if(!(score>=3&&score<=5)){
		alert("分数应在3到5之间。");
		return false;		
	}
	return true;
}
function getGroupInfo(){

	$.ajax({
		url: "/group/"+groupId,
		type: "GET",
		data: {},
		async: false,
		success:function(data){
			var groupinfo=data;	
			$("#groupinfo").append(
					'<label id=“seminarName" class="itemName">'+groupinfo.seminar.name+"</label>"+
					'<label id="leaderName" class="itemName">'+groupinfo.leader.name+"</label>"
			);
		},
		error:function(){
			alert("获取小组详情失败");
		}
	});	
}