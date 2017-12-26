package xmu.crms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.VO.ClassGroupVO;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.User;


@RestController
@RequestMapping("/class")
public class ClassController {

	//获取与当前用户相关联的或符合条件的班级列表
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<ClassInfo> getClassList(String courseName, String teacherName){
		ArrayList<ClassInfo> list=new ArrayList<ClassInfo>();
		return list;
	}

	//按ID获取班级，传入班级id，返回班级对象
	@RequestMapping(value="/{classId}", method=RequestMethod.GET)
	public ClassInfo getClassById(@PathParam("classId") Integer classId){
	    ClassInfo clas=new ClassInfo();
		return clas;
	}
	
	//按ID修改班级，传入班级id和json
	@RequestMapping(value="/{classId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateClassById(@PathParam("classId") Integer classId, @RequestBody ClassInfo clas){
	}
	
	//按ID删除班级，传入班级id
	@RequestMapping(value="/{classId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteClassById(@PathParam("classId") Integer classId){
	}
		
	//班级按ID查找学生列表（查询学号、姓名开头）
	@RequestMapping(value="/{classId}/student", method=RequestMethod.GET)
	public List<User> getStudentList(@PathParam("classId") Integer classId, String numBeginWith, String nameBeginWith){
		List<User> studentList=new ArrayList<User>();

		return studentList;
	}
	
	//TODO
	//学生按ID选择班级
	@RequestMapping(value="/{classId}/student", method=RequestMethod.POST)
	public String chooseClass(@PathParam("classId") Integer classId, Integer studentId, HttpServletResponse response){

		  return "/class/34/student/2757";
	}


	//学生按ID取消选择班级
	@RequestMapping(value="/{classId}/student/{studentId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void chooseClass(@PathParam("classId") Integer classId, @PathParam("studentId") Integer studentId){
	}
	
	//按ID获取自身所在班级小组
	@RequestMapping(value="/{classId}/classgroup", method=RequestMethod.GET)
	public ClassGroupVO getGroupByClassId(@PathParam("classId") Integer classId){

		return new ClassGroupVO();
	}
		
	//班级小组组长辞职
	@RequestMapping(value="/{classId}/classgroup/resign", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void resign(@PathParam("classId") Integer classId, @RequestBody User student){
	}
	
	 //成为班级小组组长
    @RequestMapping(value="/{classId}/classgroup/assign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void assign(@PathParam("classId") Integer classId, @RequestBody User student){
    }
    
    //添加班级小组成员
    @RequestMapping(value="/{classId}/classgroup/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathParam("classId") Integer classId, @RequestBody User student){
    }
    
    //移除班级小组成员
    @RequestMapping(value="/{classId}/classgroup/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remove(@PathParam("classId") Integer classId, @RequestBody User student){
    }
}
