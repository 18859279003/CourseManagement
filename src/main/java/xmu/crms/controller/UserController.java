package xmu.crms.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.serviceimpl.LoginServiceImpl;
import xmu.crms.serviceimpl.TopicServiceImpl;
import xmu.crms.serviceimpl.UserServiceImpl;
/**
 * UserController
 * @author yangkepiao
 * @date 2017/12/26
 */
@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	private LoginServiceImpl loginServiceImpl;
    /**
     * 获得当前用户
     * @return User deleteNumber
     */
	@RequestMapping(value="/me", method=RequestMethod.GET)
	public User getUser() {
		return new User();
	}
	
	 /**
     * 修改当前用户
     * @return
	 * @throws UserNotFoundException 
     */
	@RequestMapping(value="/me", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateUser(@RequestBody User user) throws UserNotFoundException {
     userServiceImpl.updateUserByUserId(user.getId(), user);
	}
	/**
	 * 手机号登录，返回用户基本信息
	 * @param phone
	 * @param password
	 * @return
	 * @throws UserNotFoundException 用户不存在或密码不正确
	 */
		@RequestMapping(value="/signinByPhone", method=RequestMethod.GET)
		public User signinByPhone(String phone, String password) throws UserNotFoundException{
			User me=new User();
			me.setPhone(phone);
			me.setPassword(password);
			User recv=loginServiceImpl.signInPhone(me) ;
			return recv;
		}
		
		/**
		 * 手机号密码注册
		 * @param user
		 * @return
		 * @throws UserNotFoundException
		 */
		@RequestMapping(value="/registerByPhone", method=RequestMethod.POST)
		@ResponseStatus(value=HttpStatus.NO_CONTENT)
		public void registerByPhone(@RequestBody User user) throws UserNotFoundException{
			loginServiceImpl. signUpPhone(user) ;
			}
	/**
	 * 微信登录，返回用户基本信息
	 * @param code
	 * @param state
	 * @param successUrl
	 * @param response
	 * @return User deleteUser
	 */
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public User signin(String code, String state, String successUrl, HttpServletResponse response){
        return new User();
	}
}
