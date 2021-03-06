package xmu.crms.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.security.AuthServiceImpl;
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
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	@Autowired
	private AuthServiceImpl authServiceImpl;
    /**
     * 获得当前用户
     * @return User deleteNumber
     * @throws UserNotFoundException 
     * @throws IllegalArgumentException 
     */
	@RequestMapping(value="/me/{userId}", method=RequestMethod.GET)
	public User getUser() throws IllegalArgumentException, UserNotFoundException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            throw new BadCredentialsException("Bad Credentials");
        }

        return userServiceImpl.getUserByUserId( (BigInteger)principal);
	}
	
	 /**
     * 修改当前用户
     * @return
	 * @throws UserNotFoundException 
     */
	@RequestMapping(value="/me/{userId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateUser(@RequestBody User user, @PathVariable int userId) throws UserNotFoundException {
     userServiceImpl.updateUserByUserId(new BigInteger(userId+""), user);
	}
	/**
	 * 手机号登录，返回用户基本信息
	 * @param phone
	 * @param password
	 * @return
	 * @throws UserNotFoundException 用户不存在或密码不正确
	 */
		@RequestMapping(value="/signin", method=RequestMethod.POST)
		public User signinByPhone(@RequestBody User user) throws UserNotFoundException{
			String token=authServiceImpl.login(user.getPhone(), user.getPassword());
			return loginServiceImpl.signInPhone(user);
		}
		
		/**
		 * 手机号密码注册
		 * @param user
		 * @return
		 * @throws UserNotFoundException
		 */
		@RequestMapping(value="/register", method=RequestMethod.POST)
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
