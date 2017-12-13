/**
 * Created by lenovo on 2017/12/4.
 */
//课程ID
var classId;

//设置classId
function setClssId(n){
    classId = n;
}

//页面加载时，获取固定分组名单
window.onload = function(){
	getCourse();
	getStudentList();
}

//获取课程信息
function getCourse(){
//	alert("yes!");
    var t;

    $.ajax({
        url:"/course/{courseId}" ,
        type:"GET",
        success:function(data){ 
            t = data;
            $("#courseName").html("");
            $("#courseIntroduction").html("");
            courseId = t.id;
            $("#courseName").append(t.name);
            $("#courseIntroduction").append(t.description);
            alert("获取课程信息成功！");
        },
        error:function(){
            alert("获取课程信息失败！");
        }
    });
}

//获取固定分组名单
function getStudentList() {
    var group;
    $.ajax({
        url: "/class/{classId}/classgroup",
        type: "GET",
        success: function (data) {
            group = data;
            $(".Fixed_group").html("");
            if (group.length == 0)
                $(".Fixed_group").html("固定分组名单为空");
            $(".Fixed_group").append(
                    "<tr> <th>角色</th> <th>学号</th> <th>姓名</th> <th>操作</th> </tr>" +
                    "<tr id='"+group.leader.id+"'>" +
                    "<td>队长</td>" +
                    "<td>" + group.leader.id + "</td>" +
                    "<td>" + group.leader.name + "</td>" +
                    "<td></td> </tr>"
                )
            
                for(var i in group.members){
                	var item = group.members[i];
                	if (i % 2 == 1) {
                    $(".Fixed_group").append(
                    		"<tr class=\"alt\" id='"+item.id+"' onclick='deleteMember("+item.id+")'>" +
                        "<td>队员</td>" +
                        "<td>" + item.id + "</td>" +
                        "<td>" + item.name + "</td>" +
                        "<td><img src=\"../../Img/home.png\" style='cursor:pointer'></td>" +
                        "</tr>"
                    );
                }
                else {
                    $(".Fixed_group").append(
                    		"<tr class=\"alt\" id='"+item.id+"' onclick='deleteMember("+item.id+")'>" +
                        "<td>队员</td>" +
                        "<td>" + item.id + "</td>" +
                        "<td>" + item.name + "</td>" +
                        "<td><img src=\"../../Img/home.png\" style='cursor:pointer'></td>" +
                        "</tr>"
                    )
                }
            }//end for
            alert("获取固定分组名单成功！");
        },
        error: function () {
            alert("获取固定分组名单失败！");
        }
    })
}

//查询按钮响应函数
function search(){
    var num = document.getElementById("num").value;
    var nameBegin = document.getElementById("name").value;
    var studentlist;

    $.ajax({
        url:"/class/{classId}/student",
        type:"GET",
        data:{
            numBeginWith:num,
            nameBeginWith:nameBegin},
        success:function(data){
            studentlist = data;
            $(".addmember").html("");
            $(".addmember").append("<tr> <th>学号</th> <th>姓名</th> <th>操作</th> </tr>");
            if (studentlist.length == 0)
                $(".addmember").html("搜索结果为空");
            for (var i in studentlist) {
                var item = studentlist[i];
                if (i % 2 == 1) {
                    $(".addmember").append(
                    "<tr class=\"alt\" id='"+item.id+"' onclick='addMember("+item.id+",\""+item.name+"\")'>" +
                    "<td>" + item.id +"</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td><img src=\"../../Img/home.png\" style='cursor:pointer'></td> </tr>"
                    );
                }
                else {
                    $(".addmember").append(
                    		"<tr class=\"alt\" id='"+item.id+"' onclick='addMember("+item.id+",\""+item.name+"\")'>" +
                        "<td>" + item.id + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td><img src=\"../../Img/home.png\" style='cursor:pointer'></td> </tr>"
                    );
                }
            }//end for
        },
        error:function(){
            alert("查询符合条件的学生失败！");
        }
    });
}

//删除成员
function deleteMember(id)
{
	$("tr#"+id).remove();
}
//添加成员
function addMember(id,name)
{
	$("tr#"+id).remove();
	$(".Fixed_group").append(
			"<tr class=\"alt\" id='"+id+"' onclick='deleteMember("+id+")'>" +
            "<td>队员</td>" +
            "<td>" + id + "</td>" +
            "<td>" + name + "</td>" +
            "<td><img src=\"../../Img/home.png\" style='cursor:pointer'></td>" +
            "</tr>"
            );
}