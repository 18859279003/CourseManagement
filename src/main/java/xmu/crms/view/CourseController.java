package xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.model.Class;
import xmu.crms.model.Course;
import xmu.crms.model.CourseDetail;
import xmu.crms.model.Seminar;
import xmu.crms.model.SeminarClasses;
import xmu.crms.model.SeminarGradeDetail;

@RestController
@RequestMapping("/course")
public class CourseController {

	//获取与当前用户相关联的课程列表
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Course> getCourseList(){
		List<Course> courselist=new ArrayList<Course>();//假的
		courselist.add(new Course(1, null, "OOAD",3,60,"2017-9-1", "2018-1-1", null, null));
		courselist.add(new Course( 2,null, "J2EE",1, 60, "2017-9-1","2018-1-1", null, null));
		return courselist;
	}
	
	//创建课程，传入json，返回课程id
	@RequestMapping(value="", method=RequestMethod.POST)
	public int createCourse(@RequestBody Course course){	
		course.setId(23);
		return course.getId();//假的
	}
	
	//按ID获取课程，传入课程id，返回课程对象
	@RequestMapping(value="/{courseId}", method=RequestMethod.GET)
	public CourseDetail getCourseById(@PathParam("courseId") Integer courseId){
		return new CourseDetail(23, "OOAD","面向对象分析与设计","邱明","mingqiu@xmu.edu.cn");//假的
	}
	
	//按ID修改课程，传入课程id和json
	@RequestMapping(value="/{courseId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateCourseById(@PathParam("courseId") Integer courseId, @RequestBody Course course){
	}
	
	//按ID删除课程，传入课程id
	@RequestMapping(value="/{courseId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCourseById(@PathParam("courseId") Integer courseId){
	}
		
	//按ID获取课程的班级列表
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.GET)
	public List<Class> getClassListByCourseId(@PathParam("courseId") Integer courseId){
		List<Class> classList=new ArrayList<Class>();
		classList.add(new Class( 45,"周三1-2节", courseId, null, null, courseId, null, null));
		classList.add(new Class( 48,"周三3-4节", courseId, null, null, courseId, null, null));
		return classList;
	}
	
	//在指定ID的课程创建班级
	@RequestMapping(value="/{courseId}/class", method=RequestMethod.POST)
	public int createTopic(@PathParam("courseId") Integer courseId, @RequestBody Class clas){	
		clas.setId(45);
		return clas.getId();//假的
	}
/////////////////////////////////////siminar里面无grade//////////////////////////////////////////////////////////////////////////////////////////
	//按ID获取课程的讨论课列表
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.GET)
	public List<Seminar> getSeminarList(@PathParam("courseId") Integer courseId, boolean embedGrade){
		List<Seminar> seminarlist=new ArrayList<Seminar>();//假的
		seminarlist.add(new Seminar( 29,"界面原型设计","界面原型设计", "fixed","2017-09-25","2017-10-09", null,null));
		return seminarlist;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/{courseId}/seminar", method=RequestMethod.POST)
	public int createSeminar(@PathParam("courseId") Integer courseId, @RequestBody Seminar seminar){
		seminar.setId(32);
		return seminar.getId();
	}
/////////////////////////////////////	无"groupingMethod": "fixed",//////////////////////////////////////////////////////////////////////////
	 //获取课程正在进行的讨论课
    @RequestMapping(value="/{courseId}/seminar/current", method=RequestMethod.GET)
    public SeminarClasses getCurrentSeminar(@PathParam("courseId") Integer courseId){ 
    	Class clas[]=new Class[2];
    	clas[0]=new Class(   53,"周三12", courseId, null, null, courseId, null, null);
    	clas[1]=new Class(   57,"周三34", courseId, null, null, courseId, null, null);
        return new SeminarClasses(  29,"界面原型设计","OOAD","2017-09-25","2017-10-09",clas);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/////////////////////////////////////    无"seminarName": "需求分析",//////////////////////////////////////////////////////////////////////////
    //按课程ID获取学生的所有讨论课成绩
   @RequestMapping(value="/{courseId}/grade", method=RequestMethod.GET)
   public List<SeminarGradeDetail> getGradeListByCourseId(@PathParam("courseId") Integer courseId){ 
	   List<SeminarGradeDetail> list=new ArrayList<SeminarGradeDetail>();
	   list.add(new SeminarGradeDetail( "3A2","张三",3,4,4));
	   list.add(new SeminarGradeDetail( "3A3","张三",4,4,4));
       return list;
   }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
