/**
 * zdd
 */
window.onload = function(){
	getProvince();
	getCity();
	getSchool();
}

//注册，返回一个用户对象
function register(){
    var phone = document.getElementById("phoneNum").value;
    var password = document.getElementById("password").value;
    var name = document.getElementById("name").value;
    var province = document.getElementById("province").value;
    var city = document.getElementById("city").value;
    var school = document.getElementById("school").value;
    var stuffnum = document.getElementById("stuffNum").value;
    var email = document.getElementById("email").value;
    var gender = judgesex();
 
    var School={
    		name:school,
    		province:province,
    		city:city
    };
    var user = {
    		phone:phone,
    		password:password,
    		name:name,
    		school:School,
    		number:stuffnum,
    		email:email,
    		gender:gender
    };
    alert(JSON.stringify(user));
    $.ajax({
        url : "/register",
        type : "POST",
        contentType:"application/json",
        data:JSON.stringify(user),   
        async:false,
        success:function(data){
            alert("注册成功！" + data);
            window.location.href="/AccountLoginPage";
        },
        error:function(){
            alert("注册失败！");
        }
    });

}

//检查输入是否正确
function checkright(){
    var warn = "";
    var password = document.getElementById("password").value;
    var name = document.getElementById("name").value;
    var school = document.getElementById("school").value;
    var stuffnum = document.getElementById("stuffNum").value;
    var email = document.getElementById("email").value;

    warn = checktel();
    if(warn == null || warn.length == 0){
        if(password == ""){
            warn = "密码不能为空！";
        }else if(name == ""){
            warn = "姓名不能为空！";
        }else if(stuffnum == ""){
            warn = "学号不能为空！";
        }else if(email == ""){
            warn = "邮箱不能为空！";
        }
    }
    if(warn !=null && warn.length !=0)
        alert(warn);
    else{
       register();
    }
    
    return false;
}

//检查手机号输入是否正确
function checktel(){
    var username = $("#phoneNum").val();
    var mes = "";
    if (username.length == 0 || username==null) {
        mes = "用户名不能为空！";
    }
    else if (username.length != 11) {
        mes = "请输入11位手机号作为用户名！";
        $("#phoneNum").html="";
    }
    else{
        var PATTERN_CHINAMOBILE = /^1(3[4-9]|5[012789]|8[23478]|4[7]|7[8])\d{8}$/; //移动号
        var PATTERN_CHINAUNICOM = /^1(3[0-2]|5[56]|8[56]|4[5]|7[6])\d{8}$/; //联通号
        var PATTERN_CHINATELECOM = /^1(3[3])|(8[019])\d{8}$/; //电信号
        if (PATTERN_CHINAUNICOM.test(username) || PATTERN_CHINAMOBILE.test(username) || PATTERN_CHINATELECOM.test(username)) {
            return mes;
        }else {
            mes = "请输入正确的手机号";
        }
    }
    return mes;

}

//判断性别
function judgesex() {
    var x = document.getElementById("man");
    var gender;

    if (x=="男") {
        gender = "0";
    }
    else {
        gender = "1";
    }
    return gender;
}

//获取学校列表
function getSchool(){
	var schoollist;
	var city  = $("city").val();
	$.ajax({
		url:"/school",
		type:"GET",
        data:{city : city},
		success:function(data){
			schoollist = data;
			$("#school").html="";
			for(var i in schoollist){
				var item = schoollist[i];
				$("#school").append("<option value=\""
						+ item.name + "\">"
						+ item.name + "</option>");
			}//end for
		},
		error:function(){
			alert("获取学校列表失败！");
		}
	});
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

//更新学校列表
$("#city").change(function(){
	var schoollist;
	var city  = document.getElementById("city").value;
	//alert(city);
	$.ajax({
		url:"/school",
		type:"GET",
        data:{city:city},
		success:function(data){
			alert(data);
			schoollist = data;
			$("#school").html="";
			for(var i in schoollist){
				var item = schoollist[i];
				$("#school").append("<option value=\""
						+ item.name + "\">"
						+ item.name + "</option>");
			}//end for
		},
		error:function(){
			alert("获取学校列表失败！");
		}
	});
})