package xmu.crms.controller;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.FixGroup;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.serviceimpl.UserServiceImpl;
import xmu.crms.vo.ClassGroupVo;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
	@Autowired
	private UserController userController;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Test
	public void testToken() throws IllegalArgumentException, UserNotFoundException {
		userController.signinByPhone(userServiceImpl.getUserByUserId(new BigInteger("4")));
		User user=userController.getUser();
		System.out.println(user);
	}
}
