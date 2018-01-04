/**
 * Created by lenovo on 2017/12/5.
 */
window.onload = function(){
	getProvince();
	getCity();
}

//获取省份列表
function getProvince(){
    var provincelist;
    $.ajax({
        url:"http://apis.map.qq.com/ws/district/v1/list?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp",
        type:"GET",
        dataType:"JSONP",
        success:function(data){
            provincelist = data.result[0];
            for(var i in provincelist){
                var item = provincelist[i];
                $("#province").append("<option value='"
                + item.id +"'>" + item.fullname +"</option>");
            }//end for
        },
        error:function(){
            alert("获取省份列表失败！");
        }
    });
}

//获取城市列表
function getCity(){
    var citylist;

    $.ajax({
        url:"http://apis.map.qq.com/ws/district/v1/list?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp",
        type:"GET",
        dataType:"JSONP",
        success:function(data){
            citylist = data.result[1];
            for(var i in citylist){
            	var item = citylist[i];          
            	var regexp = "11[0-9]{4}";
            	var result = item.id.match(regexp);                
                if(result)
                	$("#city").append("<option value='"
                			+ item.fullname +"'>" + item.fullname +"</option>");
            }//end for
        },
        error:function(){
            alert("获取城市列表失败！");
        }
    });
}

//添加学校
function createschool(){
    var school = {
    		"name":$("#school").val(),
    		"province":$("#province").val(),
    		"city":$("#city").val()
    		};
    alert(JSON.stringify(school));
    $.ajax({
        url:"/school",
        type:"POST",
        contentType:"application/json",
        data:JSON.stringify(school),
        success:function(data){
            alert("创建学校成功！" + data);
            window.location.href="/TeacherBindPage";
        },
        error:function(){
            alert("创建学校失败！");
        }
    })

}
//更新城市列表
$("#province").change(function(){
    var citylist;
    var pid = document.getElementById("province").value;
    //alert(pid);
    $.ajax({
        url:"http://apis.map.qq.com/ws/district/v1/list?key=7DFBZ-K4PWQ-TYK5Y-GL7XN-RBDSQ-XSB6M&output=jsonp",
        type:"GET",
        dataType:"JSONP",
        success:function(data){
            citylist = data.result[1];
            $("#city").html("");
            for(var i in citylist){
            	var item = citylist[i];          
            	var regexp = pid[0]+pid[1]+"[0-9]{4}";
            	var result = item.id.match(regexp);                
                if(result){
                	$("#city").append("<option value='"
                			+ item.fullname +"'>" + item.fullname +"</option>");
                }
            }//end for
        },
        error:function(){
            alert("获取城市列表失败！");
        }
    });
});