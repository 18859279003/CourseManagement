var seminarId=1;
window.onload = function(){
	//************get seminarId
	seminarId=localStorage.getItem("seminarId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
    $(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init(){

	$.ajax({
		url: "/seminar/"+seminarId+"/group",
		type: "GET",
		data: {gradeable:false,classId:1},//meiyouyong
		async: false,
		success:function(data){
			var grouplist=data;
			for(var i in grouplist){
			var groupinfo=grouplist[i];	
			var report=(groupinfo.report==null||groupinfo.report=="")?"未提交":"已提交";
			$("#grouplist tbody").append(
					"<tr><td>"+groupinfo.topic+"</td>"+
					"<td>"+groupinfo.groupName+"</td>"+
					"<td>"+groupinfo.leaderName+"</td>"+
					"<td>"+groupinfo.presentationGrade+"</td>"+
					"<td>"+report+"</td>"+
					"<td>"+groupinfo.reportGrade+"</td>"+
					"<td>"+groupinfo.grade+"</td>"+
					"<td>" +
						"<img src='../../Img/view.png' alt='预览' onclick='report("+groupinfo.id+")' style='cursor:pointer'>"+
                        "<img src='../../Img/download.png' alt='下载'>"+
                    "</td></tr>"
			);
			}
		},
		error:function(){
			alert("获取小组列表失败");
		}
	});
}
function report(id){
	//***************save groupId
	localStorage.setItem("groupId",id);
	window.location.href="/TeacherScoreReportPage";
}

