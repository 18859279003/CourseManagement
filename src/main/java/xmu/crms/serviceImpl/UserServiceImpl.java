package xmu.crms.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.Attendance;
import xmu.crms.entity.Course;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.mapper.UserMapper;
import xmu.crms.service.UserService;

import java.math.BigInteger;
import java.util.List;
/**
 * service要加上一个@Service的注解，以便可以到处注入这个service
 *
 * @author yangkepiao
 * @date 2017/12/19
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userMapper;
	@Override
	public BigInteger insertAttendanceById(BigInteger classId, BigInteger seminarId, BigInteger userId, double longitude,
			double latitude)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException, UserNotFoundException {
		
		if(classId.intValue()<0||userId.intValue()<0||seminarId.intValue()<0)
		{
			throw new IllegalArgumentException();
		}
			
		if(userMapper.selectClass(classId)==null)
		{
			throw new ClassesNotFoundException();
		}
			
		if(userMapper.selectSeminar(seminarId)==null)
		{
			throw new SeminarNotFoundException();
		}
			
		if(userMapper.selectUser(userId)==null)
		{
			throw new UserNotFoundException();
		}
			
		double longi=userMapper.getLongitude(seminarId, classId);
		double lati=userMapper.getLatitude(seminarId, classId);
	if(longi==longitude&&lati==latitude)
		{
		userMapper.insertAttendanceById(classId, seminarId, userId);	
		return userMapper.getIdByInfo(classId, seminarId, userId);
		}
	else return null;
	}

	@Override
	public List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		
		if(classId.intValue()<0||seminarId.intValue()<0)
		{
			throw new IllegalArgumentException();
		}
		if(userMapper.selectClass(classId)==null)
		{
			throw new ClassesNotFoundException();
		}
		if(userMapper.selectSeminar(seminarId)==null)
		{
			throw new SeminarNotFoundException();
		}	
			
		return userMapper.listAttendanceById(seminarId, classId);
		
	}

	@Override
	public User getUserByUserId(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		
		if(userId.intValue()<0)
		{
			throw new IllegalArgumentException();
		}
			
		if(userMapper.selectUser(userId)==null)
		{
			throw new UserNotFoundException();
		}
			
		return userMapper.getUserByUserIdBigInteger(userId);
	}

	@Override
	public List<BigInteger> listUserIdByUserName(String userName) throws IllegalArgumentException, UserNotFoundException {
		
		if(userMapper.listUserIdByUserName(userName).size()==0)
		{
			throw new UserNotFoundException();
		}
		return userMapper.listUserIdByUserName(userName);
	}

	@Override
	public void updateUserByUserId(BigInteger userId, User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(userMapper.selectUser(userId)==null)
			throw new UserNotFoundException();
		userMapper.updateUserByUserId(userId, user);
	}

	@Override
	public List<User> listUserByClassId(BigInteger classId, String numBeginWith, String nameBeginWith)
			throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		if(classId.intValue()<0)
			throw new IllegalArgumentException();
		if(userMapper.selectClass(classId)==null)
			throw new ClassesNotFoundException();
		if(userMapper.listUserByClassId(classId, numBeginWith+"%", nameBeginWith+"%")==null)
			throw new UserNotFoundException();
		return userMapper.listUserByClassId(classId, numBeginWith+"%", nameBeginWith+"%");
	}

	@Override
	public List<User> listUserByUserName(String userName) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(userMapper.listUserIdByUserName(userName).size()==0)
			throw new UserNotFoundException();
		return userMapper.listUserByUserName(userName);
	}

	@Override
	public List<User> listPresentStudent(BigInteger seminarId, BigInteger classId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		// TODO Auto-generated method stub
		if(classId.intValue()<0||seminarId.intValue()<0)
			throw new IllegalArgumentException();
		if(userMapper.selectClass(classId)==null)
			throw new ClassesNotFoundException();
		if(userMapper.selectSeminar(seminarId)==null)
			throw new SeminarNotFoundException();
		return userMapper.listPresentStudent(seminarId, classId);
	}

	@Override
	public List<User> listLateStudent(BigInteger seminarId, BigInteger classId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		// TODO Auto-generated method stub
		if(classId.intValue()<0||seminarId.intValue()<0)
			throw new IllegalArgumentException();
		if(userMapper.selectClass(classId)==null)
			throw new ClassesNotFoundException();
		if(userMapper.selectSeminar(seminarId)==null)
			throw new SeminarNotFoundException();
		return userMapper.listLateStudent(seminarId, classId);
	}

	@Override
	public List<User> listAbsenceStudent(BigInteger seminarId, BigInteger classId)
			throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
		// TODO Auto-generated method stub
		if(classId.intValue()<0||seminarId.intValue()<0)
			throw new IllegalArgumentException();
		if(userMapper.selectClass(classId)==null)
			throw new ClassesNotFoundException();
		if(userMapper.selectSeminar(seminarId)==null)
			throw new SeminarNotFoundException();
		return userMapper.listAbsenceStudent(seminarId, classId);
	}

	@Override
	public List<Course> listCourseByTeacherName(String teacherName)
			throws UserNotFoundException, IllegalArgumentException, CourseNotFoundException {
		// TODO Auto-generated method stub
		if(listUserByUserName(teacherName)==null)
			throw new UserNotFoundException();
		if(userMapper.listCourseByTeacherName(teacherName).size()==0)
			throw new CourseNotFoundException();
		return userMapper.listCourseByTeacherName(teacherName);
	}

}
