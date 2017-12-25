package xmu.crms.mapper;

import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.School;
import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;

/**
 * 
 * @author Zhao Zhengyu
 * @version 2017-12-25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginMapperTest {
	@Autowired
	private LoginMapper loginMapper;
	private static Log log = LogFactory.getLog(LoginMapperTest.class);
	
	
	@Test
	public void testSignInPhone() throws UserNotFoundException {
		// 若user为空，则用户名或密码不正确
		User user=new User();
		user.setPhone("15720335800");
		user.setPassword("BE8791B8BE6DEC10");
		log.info(loginMapper.signInPhone(user));
	}
/*
INSERT INTO `user_info` VALUES ('1', '2017-12-16 12:14:09', '2017-12-16 12:14:09', '15720335800', null, null, null, 'BE8791B8BE6DEC10', '邱明', '1', '0', '1', '20170315', '3', '1', '20170315@xmu.edu.cn');
INSERT INTO `user_info` VALUES ('2', '2017-12-16 12:14:09', '2017-12-16 12:14:09', '15720335801', null, null, null, 'BE8791B8BE6DEC10', '王美红', '1', '1', '1', '20170518', '3', '1', '20170518@xmu.edu.cn');
INSERT INTO `user_info` VALUES ('3', '2017-12-16 12:14:09', '2017-12-16 12:14:09', '15720335803', null, null, null, 'BE8791B8BE6DEC10', '学生1', '1', '0', '0', '24320152202700', '1', null, '24320152202700@stu.xmu.edu.cn');
INSERT INTO `user_info` VALUES ('4', '2017-12-16 12:14:09', '2017-12-16 12:14:09', '15720335804', null, null, null, 'BE8791B8BE6DEC10', '学生2', '1', '0', '0', '24320152202701', '1', null, '24320152202701@stu.xmu.edu.cn');
 */
	
	@Test
	public void testSignUpPhone() {
		// TODO Auto-generated method stub
		School school=new School();
		school.setName("黄南大学");	
		school.setId(new BigInteger("1"));;	
		User user=new User();
		user.setPhone("17750634707");
		user.setPassword("wohenpi");
		user.setName("张昭阳");
		user.setSchool(school);
		user.setGender(1);
		user.setType(0);
		user.setNumber("24320152202864");
		user.setEmail("woshizhaoyangdebaba@qq.com");
		loginMapper.signUpPhone(user);
		log.info(loginMapper.signInPhone(user));
	}


	@Test
	public void testDeleteStudentAccount () throws Exception {
		loginMapper.deleteStudentAccount(new BigInteger("10"));
		}
	@Test
	public void testDeleteTeacherAccount () throws Exception {
		loginMapper.deleteTeacherAccount(new BigInteger("2"));
		}
	

}
