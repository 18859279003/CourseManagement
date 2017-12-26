package xmu.crms.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.User;
import xmu.crms.entity.Attendance;
import xmu.crms.entity.Course;

import java.math.BigInteger;
import java.util.List;
/**
 * UserMapperTest
 * @author yangkepiao
 * @date 2017/12/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
@Autowired
private UserMapper userMapper;
private static Log log =LogFactory.getLog(UserMapperTest.class);
@Test
public void getUserByUserIdBigInteger()throws Exception{
	User user=userMapper.getUserByUserIdBigInteger(new BigInteger("4"));
 System.out.println(user.getSchool().getName());
 
}

@Test
public void insertAttendanceById()throws Exception{
	userMapper.insertAttendanceById(new BigInteger("1"),new BigInteger("3"),new BigInteger("2"));
}
@Test
public void listAbsenceStudent()throws Exception{
	List<User>list=userMapper.listAbsenceStudent(new BigInteger("3"),new BigInteger("1"));
log.info(list);
}
@Test
public void listAttendanceById()throws Exception{
	List<Attendance>list=userMapper.listAttendanceById(new BigInteger("3"),new BigInteger("1"));
log.info(list);
}
@Test
public void listCourseByTeacherName()throws Exception{
	List<Course>list=userMapper.listCourseByTeacherName("邱明");
log.info(list);
}
@Test
public void listLateStudent()throws Exception{
	List<User>list=userMapper.listLateStudent(new BigInteger("3"),new BigInteger("1"));
log.info(list);
}
@Test
public void listPresentStudent()throws Exception{
	List<User>list=userMapper.listPresentStudent(new BigInteger("3"),new BigInteger("1"));
log.info(list);
}
@Test
public void listUserByClassId()throws Exception{
	List<User>list=userMapper.listUserByClassId(new BigInteger("1"),"24%","学%");
log.info(list);
}
@Test
public void listUserByUserName()throws Exception{
	List<User>list=userMapper.listUserByUserName("邱明");
//log.info(list);
}
@Test
public void  listUserIdByUserName()throws Exception{
	List<BigInteger> userId=userMapper. listUserIdByUserName("邱明");
//log.info(userId);
}
@Test
public void  updateUserByUserId()throws Exception{
	User user=new User();
	user.setId(new BigInteger("1"));
	user.setName("吴清强");
	user.setPhone("15720335800");
	user.setWechatId("1230000");
	user.setOpenid("1230000");
	user.setAvatar("12300000");
	user.setPassword("BE8791B8BE6DEC10");
	user.setGender(0);
	user.setType(1);
	user.setNumber("20170315");
	user.setEducation(3);
	user.setTitle(1);
	user.setEmail("20170315@xmu.edu.cn");
	userMapper.updateUserByUserId(user.getId(),user);
log.info(user);
}

}
