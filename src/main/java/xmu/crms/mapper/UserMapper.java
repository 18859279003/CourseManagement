package xmu.crms.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.User;
import xmu.crms.entity.Attendance;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.entity.FixGroup;
import xmu.crms.entity.School;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/**
 * School Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 *
 *
 * @author liuxin
 * @date 2017/12/19
 */
@Mapper
@Component
public interface UserMapper {
	 /**
     * selectUser.
     *
     * @author cb
     * @param id
     * @return User deleteNumber
     */
        User selectUser(BigInteger id);
    /**
     * selectSchool.
     *
     * @author cb
     * @param id
     * @return School deleteNumber
     */
        School selectSchool(BigInteger id);

    /**
     * selectClass.
     *
     * @author cb
     * @param id
     * @return ClassInfo deleteNumber
     */
    ClassInfo selectClass(BigInteger id);

    /**
     * selectCourse.
     *
     * @author cb
     * @param id
     * @return Course deleteNumber
     */
    Course selectCourse(BigInteger id);

    /**
     * selectFixGroup.
     *
     * @author cb
     * @param id
     * @return FixGroup deleteNumber
     */
    FixGroup selectFixGroup(BigInteger id);

    /**
     * selectSeminar.
     *
     * @author cb
     * @param id
     * @return Seminar deleteNumber
     */
    Seminar selectSeminar(BigInteger id);

    /**
     * selectSeminarGroup.
     *
     * @author cb
     * @param id
     * @return SeminarGroup deleteNumber
     */
    SeminarGroup selectSeminarGroup(BigInteger id);

    /**
     * selectSeminarGroupTopic.
     *
     * @author cb
     * @param id
     * @return SeminarGroupTopic deleteNumber
     */
    SeminarGroupTopic selectSeminarGroupTopic(BigInteger id);

    /**
     * selectTopic.
     *
     * @author cb
     * @param id
     * @return Topic deleteNumber
     */
    Topic selectTopic(BigInteger id);
/**
 * 根据id得到用户
 * @param userId
 * @return User deleteNumber
 */
	User getUserByUserIdBigInteger(@Param("userId") BigInteger userId);
	/**
	 * 返回签到序列
	 * @param classId
	 * @param seminarId
	 * @param userId
	 * @return BigInteger deleteNumber
	 */
	BigInteger getIdByInfo(@Param("classId") BigInteger classId,@Param("seminarId") BigInteger seminarId,@Param("userId")
	BigInteger userId);
/**
 * 插入学生签到信息
 * @param classId
 * @param seminarId
 * @param userId
 */
	void insertAttendanceById(@Param("classId")  BigInteger classId,@Param("seminarId")  BigInteger seminarId,@Param("userId")
	BigInteger userId);
	/**
	 * 获取经度
	 * @param seminarId
	 * @param classId
	 * @return double deleteNumber
	 */
	double getLongitude(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId);
	/**
	 * 获取纬度
	 * @param seminarId
	 * @param classId
	 * @return double
	 */
	double getLatitude(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId);
	/**
	 * 获取讨论课所在班级缺勤学生名单
	 * @param seminarId
	 * @param classId
	 * @return List<User> deleteNumber
	 */
	List<User> listAbsenceStudent(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId );

	/**
	 * 获取学生签到信息.
	 * @param seminarId
	 * @param classId
	 * @return List<Attendance> deleteNumber
	 */
	List<Attendance> listAttendanceById(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId );
	/**
	 * 根据教师名称列出课程名称.
	 * @param userName
	 * @return List<Course> deleteNumber
	 */
	List<Course>listCourseByTeacherName(@Param("userName") String userName);
	/**
	 * 获取讨论课所在班级迟到学生名单.
	 * @param seminarId
	 * @param classId
	 * @return List<User> deleteNumber
	 */
	List<User>listLateStudent(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId);
	/**
	 * 获取讨论课所在的班级出勤的学生名单
	 * @param seminarId
	 * @param classId
	 * @return List<User> deleteNumber
	 */
	List<User> listPresentStudent(@Param("seminarId") BigInteger seminarId,@Param("classId") BigInteger classId );
	/**
	 * 按班级ID、学号开头、姓名开头获取学生列表.
	 * @param classId
	 * @param numBeginWith
	 * @param nameBeginWith
	 * @return List<User> deleteNumber
	 */
	List<User>listUserByClassId(@Param("classId") BigInteger classId,@Param("numBeginWith") String numBeginWith,@Param("nameBeginWith") String nameBeginWith);
	/**
	 * 根据用户名获取用户列表.
	 * @param userName
	 * @return List<User> deleteNumber
	 */
	List<User>listUserByUserName(@Param("userName") String userName);
	/**
	 * 根据用户名获取用户ID.
	 * @param userName
	 * @return List<BigInteger> deleteNumber
	 */
	List<BigInteger> listUserIdByUserName(@Param("userName") String userName);
	/**
	 * 根据用户ID修改用户信息.
	 * @param userId
	 * @param user
	 */
	void updateUserByUserId(@Param("userId") BigInteger userId,@Param("user") User user);
}
