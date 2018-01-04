var count = 1;//别动
var classId=1;
window.onload = function(){
	//************getclassId
	classId=localStorage.getItem("classId");
	$(".courseName").html(localStorage.getItem("courseName")) ;
    $(".courseIntroduction").html(localStorage.getItem("courseIntroduction"));
	init();
}
function init() {

	// 获取班级信息
	$.ajax({
		url : "/class/"+classId,
		type : "GET",
		data : {},
		async : false,
		success : function(data) {
			var classInfo = data;
			$("div#name").append(
					"<input type='text' id='className' class='bigInput' value='"
							+ classInfo.name + "'>");
			$("div#site").append(
					"<input type='text' id='classSite' class='bigInput' value='"
							+ classInfo.site + "'>");
			$("input#seminarGrade").attr("value",classInfo.presentationPercentage);
			$("input#reportGrade").attr("value", classInfo.reportPercentage);
			$("input#seminarGrade5").attr("value", classInfo.fivePointPercentage);
			$("input#seminarGrade4").attr("value", classInfo.fourPointPercentage);
			$("input#seminarGrade3").attr("value", classInfo.threePointPercentage);

		},
		error : function() {
			alert("获取课程信息失败");
		}
	});

}

function updateClass() {

	var time = "";
	for (var i = 1; i <= count; i++) {
		time += $("#week" + count).find("option:selected").text()
				+ $("#day" + count).find("option:selected").text()
				+ $("#lesson" + count).find("option:selected").text() + "  ";
	}
	var newClass={
			name : $("#className").val(),
			site : $("#classSite").val(),
			time: time,
			reportPercentage : $("#reportGrade").val(),
			presentationPercentage : $("#seminarGrade").val(),
			fivePointPercentage : $("#seminarGrade5").val(),
			fourPointPercentage : $("#seminarGrade4").val(),
			threePointPercentage : $("#seminarGrade3").val()
	};
	alert(JSON.stringify(newClass));
	$.ajax({
		url : "/class/" + classId ,
		type : "PUT",
		// dataType : "JSON",
		contentType : "application/json;charest=utf-8",
		data : JSON.stringify(newClass),
		success : function(data) {
			alert("修改成功" + data);
			window.location.href = "/TeacherClassInfo";
		},
		error : function() {
			alert("修改失败");
		}
	});

}

// 添加时间
function add() {
	count++;
	$("div#add").after(
			"<div class='item'>" + "<label class='itemName'>上课时间:</label>"
					+ "<select id='week"
					+ count
					+ "' class='bigSelect'>"
					+ "<option value ='单周'>单周</option>"
					+ "<option value ='双周'>双周</option>"
					+ "<option value ='每周' selected='selected'>每周</option>"
					+ "</select>"
					+ "<select id='day"
					+ count
					+ "' class='smallSelect'>"
					+ "<option value ='周一'>周一</option>"
					+ "<option value ='周二'>周二</option>"
					+ "<option value ='周三' >周三</option>"
					+ "<option value ='周四'>周四</option>"
					+ "<option value ='周五'>周五</option>"
					+ "<option value ='周六' >周六</option>"
					+ "<option value ='周日' >周日</option>"
					+ "</select>"
					+ "<select id='lesson"
					+ count
					+ "' class='smallSelect'>"
					+ "<option value ='一二节'>一二节</option>"
					+ "<option value ='三四节'>三四节</option>"
					+ "<option value ='五六节' >五六节</option>"
					+ "<option value ='七八节'>七八节</option>"
					+ "<option value ='九十节'>九十节</option>" + "</select></div>");
}

function reset() {
	window.location.reload();
}