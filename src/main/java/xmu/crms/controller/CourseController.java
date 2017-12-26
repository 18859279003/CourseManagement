package xmu.crms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

@RestController
@RequestMapping("/course")
public class CourseController {

	//获取与当前用户相关联的课程列表
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Course> getCourseList(){
		List<Course> courselist=new ArrayList<Course>();//假的
		return courselist;
	}
	
	//创建课程，传入json，返回课程id
	@RequestMapping(value="", method=RequestMethod.POST)
	public Course createCourse(@RequestBody Course course, HttpServletResponse response){	
		return course;//假的
	}
	
	//按ID获取课程，传入课程id，返回课程对象
	@RequestMapping(value="/{courseId}", method=RequestMethod.GET)
	public Course getCourseById(@PathVariable("courseId") int courseId){
		return new Course();
	}
	
	//按ID修改课程，传入课程id和json
	@RequestMapping(value="/{courseId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateCourseById(@PathVariable("courseId") int courseId, @RequestBody Course course){
	}
	
	//按ID删除课程，传入课程id
	@RequestMapping(value="/{courseId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCourseById(@PathVariable("courseId") int courseId){
	}
		
	//按ID获取课程的班级列表
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.GET)
	public List<ClassInfo> getClassListByCourseId(){
		List<ClassInfo> classList=new ArrayList<ClassInfo>();
		return classList;
	}
	
	//在指定ID的课程创建班级
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.POST)
	public ClassInfo createTopic(@PathVariable("courseId") int courseId, @RequestBody ClassInfo clas, HttpServletResponse response){	
		return clas;//假的
	}

	//按ID获取课程的讨论课列表
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.GET)
	public List<Seminar> getSeminarList(@PathVariable("courseId") int courseId, boolean embedGrade){
		List<Seminar> seminarlist=new ArrayList<Seminar>();//假的
		return seminarlist;
	}
    
	//在课程创建讨论课
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.POST)
	public Seminar createSeminar(@PathVariable("courseId") int courseId, @RequestBody Seminar seminar, HttpServletResponse response){
		return seminar;
	}
	
}
