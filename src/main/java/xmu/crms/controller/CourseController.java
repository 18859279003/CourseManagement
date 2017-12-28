package xmu.crms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.serviceimpl.ClassServiceImpl;
import xmu.crms.serviceimpl.CourseServiceImpl;
import xmu.crms.serviceimpl.SeminarImpl;

@RestController
@RequestMapping("/course")
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class CourseController {
	@Autowired
    private CourseServiceImpl courseServiceImpl;
	@Autowired
	private ClassServiceImpl classServiceImpl;
	@Autowired
	private SeminarImpl seminarServiceImpl;
	/**
	 * 获取与当前用户相关联的课程列表
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Course> getCourseList(BigInteger userId) throws IllegalArgumentException, CourseNotFoundException{
		List<Course> courselist=courseServiceImpl.listCourseByUserId(userId);
		return courselist;
	}
	
	/**
	 * 创建课程，传入json，返回课程id
	 * @param course
	 * @param response
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public int createCourse(@RequestBody Course course,BigInteger userId, HttpServletResponse response){
		return courseServiceImpl.insertCourseByUserId(userId, course).intValue();
	}
	
	/**
	 * 按ID获取课程，传入课程id，返回课程对象
	 * @param courseId
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{courseId}", method=RequestMethod.GET)
	public Course getCourseById(@PathVariable("courseId") int courseId) throws IllegalArgumentException, CourseNotFoundException{
		return courseServiceImpl.getCourseByCourseId(new BigInteger(((Integer)courseId).toString()));
	}
	
	/**
	 * 按ID修改课程，传入课程id和json
	 * @param courseId
	 * @param course
	 */
	@RequestMapping(value="/{courseId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateCourseById(@PathVariable("courseId") int courseId, @RequestBody Course course){
		courseServiceImpl.updateCourseByCourseId(new BigInteger(((Integer)courseId).toString()), course);
	}
	
	/**
	 * 按ID删除课程，传入课程id
	 * @param courseId
	 */
	@RequestMapping(value="/{courseId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCourseById(@PathVariable("courseId") int courseId){
		courseServiceImpl.deleteCourseByCourseId(new BigInteger(((Integer)courseId).toString()));
	}
		
	/**
	 * 按ID获取课程的班级列表
	 * @return
	 */
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.GET)
	public List<ClassInfo> getClassListByCourseId(){
		List<ClassInfo> classList=new ArrayList<ClassInfo>();
		return classList;
	}
	
	/**
	 * 在指定ID的课程创建班级
	 * @param courseId
	 * @param clas
	 * @param response
	 * @return
	 * @throws CourseNotFoundException 
	 */
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.POST)
	public BigInteger createClass(@PathVariable("courseId") int courseId, @RequestBody ClassInfo clas, HttpServletResponse response) throws CourseNotFoundException{	
		return classServiceImpl.insertClassById(new BigInteger(((Integer)courseId).toString()), clas);
	}

	/**
	 * 按ID获取课程的讨论课列表
	 * @param courseId
	 * @param embedGrade
	 * @return
	 */
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.GET)
	public List<Seminar> getSeminarList(@PathVariable("courseId") int courseId, boolean embedGrade){
		List<Seminar> seminarlist=new ArrayList<Seminar>();
		return seminarlist;
	}
    
	/**
	 * 在课程创建讨论课
	 * @param courseId
	 * @param seminar
	 * @param response
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.POST)
	public BigInteger createSeminar(@PathVariable("courseId") int courseId, @RequestBody Seminar seminar, HttpServletResponse response) throws IllegalArgumentException, CourseNotFoundException{
		return seminarServiceImpl.insertSeminarByCourseId(new BigInteger(((Integer)courseId).toString()), seminar);
	}
	
}
