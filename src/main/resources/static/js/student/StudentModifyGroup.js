/**
 * Created by lenovo on 2017/12/4.
 */

var classId=1;
var studentId=3;
var groupId=1;

//页面加载时，获取固定分组名单
window.onload = function(){
	//*********getstudentid/classid
	studentId=localStorage.getItem("userId");
	classId=localStorage.getItem("classId");
	$("#courseName").html(localStorage.getItem("courseName")) ;
    $("#courseIntroduction").html(localStorage.getItem("courseIntroduction"));
    getStudentList();
}

//获取固定分组名单
function getStudentList() {
    var group;
    $.ajax({
        url: "/class/"+classId+"/classgroup",
        type: "GET",
        data: {studentId: studentId},
        success: function (data) {
        	//alert(JSON.stringify(data));
            group = data;
            groupId=group.id;
            $(".Fixed_group").html("");
            if (group.length == 0)
                $(".Fixed_group").html("固定分组名单为空");
            $(".Fixed_group").append(
                    "<tr> <th>角色</th> <th>学号</th> <th>姓名</th> <th>操作</th> </tr>" +
                    "<tr id='"+group.leader.id +"'>" +
                    "<td>队长</td>" +
                    "<td>" + group.leader.number + "</td>" +
                    "<td>" + group.leader.name + "</td>" +
                    "<td></td> </tr>"
                )
            
                for(var i=1;i<group.members.length;i++){
                	var item = group.members[i];
                	if (i % 2 == 1) {
                    $(".Fixed_group").append(
                    		"<tr class=\"alt\" id='"+item.id+"'>" +
                        "<td>队员</td>" +
                        "<td>" + item.number + "</td>" +
                        "<td>" + item.name + "</td>" +
                        "<td><img src=\"../../Img/home.png\" style='cursor:pointer' onclick='deleteMember("+item.id+")'></td>" +
                        "</tr>"
                    );
                }
                else {
                    $(".Fixed_group").append(
                    		"<tr class=\"alt\" id='"+item.id+"'>" +
                        "<td>队员</td>" +
                        "<td>" + item.number + "</td>" +
                        "<td>" + item.name + "</td>" +
                        "<td><img src=\"../../Img/home.png\" style='cursor:pointer' onclick='deleteMember("+item.id+")'></td>" +
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
        url:"/class/"+classId+"/student",
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
                    "<tr class=\"alt\" id='"+item.id+"' >" +
                    "<td>" + item.number +"</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td><img src=\"../../Img/home.png\" style='cursor:pointer' onclick='addMember("+item.id+")'></td> </tr>"
                    );
                }
                else {
                    $(".addmember").append(
                    		"<tr class=\"alt\" id='"+item.id+"' >" +
                        "<td>" + item.number + "</td>" +
                    "<td>" + item.name + "</td>" +
                    "<td><img src=\"../../Img/home.png\" style='cursor:pointer' onclick='addMember("+item.id+")'></td> </tr>"
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
    $.ajax({
        url:"/class/"+classId+"/classgroup/remove"  ,
        type:"PUT",
        data:{studentId:id, groupId:groupId},
        success:function(data){ 
        	alert("删除成员成功！");
        	window.location.reload();
        },
        error:function(){
            alert("删除成员失败！");
        }
    });
}
//添加成员
function addMember(id)
{
    $.ajax({
        url:"/class/"+classId+"/classgroup/add" ,
        type:"PUT",
        data:{studentId:id, groupId:groupId},
        success:function(data){ 
        	alert("添加成员成功！");
        	window.location.reload();
        },
        error:function(){
            alert("添加成员失败！");
        }
    });
}