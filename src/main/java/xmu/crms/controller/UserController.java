package xmu.crms.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.User;

@RestController
public class UserController {

    //获得当前用户
	@RequestMapping(value="/me", method=RequestMethod.GET)
	public User getUser() {
		return new User();
	}
	
	//修改当前用户
	@RequestMapping(value="/me", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateUser(@RequestBody User user) {

	}
	
	//微信登录，返回用户基本信息
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public User signin(String code, String state, String success_url, HttpServletResponse response){
        return new User();
	}
}
