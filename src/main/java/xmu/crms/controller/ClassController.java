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
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.serviceimpl.ClassServiceImpl;
import xmu.crms.vo.ClassGroupVo;

@RestController
@RequestMapping("/class")
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class ClassController {
	@Autowired
	ClassServiceImpl classServiceImpl;
	/**
	 * 获取与当前用户相关联的或符合条件的班级列表
	 * @param courseName
	 * @param teacherName
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<ClassInfo> getClassList(String courseName, String teacherName){
		ArrayList<ClassInfo> list=new ArrayList<ClassInfo>();
		return list;
	}

	
	/**
	 * 按ID获取班级，传入班级id，返回班级对象
	 * @param classId
	 * @return
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}", method=RequestMethod.GET)
	public ClassInfo getClassById(@PathVariable("classId") int classId) throws ClassesNotFoundException{
		return classServiceImpl.getClassByClassId(new BigInteger(((Integer)classId).toString()));
	}
	
	
	/**
	 * 按ID修改班级，传入班级id和json
	 * @param classId
	 * @param clas
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateClassById(@PathVariable("classId") int classId, @RequestBody ClassInfo clas) throws ClassesNotFoundException{
		classServiceImpl.updateClassByClassId(new BigInteger(((Integer)classId).toString()), clas);
	}
	
	/**
	 * 按ID删除班级，传入班级id
	 * @param classId
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteClassById(@PathVariable("classId") int classId) throws ClassesNotFoundException{
		classServiceImpl.deleteClassByClassId(new BigInteger(((Integer)classId).toString()));
	}
		
	/**
	 * 班级按ID查找学生列表（查询学号、姓名开头）
	 * @param classId
	 * @param numBeginWith
	 * @param nameBeginWith
	 * @return
	 */
	@RequestMapping(value="/{classId}/student", method=RequestMethod.GET)
	public List<User> getStudentList(@PathVariable("classId") int classId, String numBeginWith, String nameBeginWith){
		List<User> studentList=new ArrayList<User>();
		return studentList;
	}
	
	/**
	 * 学生按ID选择班级
	 * TODO
	 * @param classId
	 * @param studentId
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/{classId}/student", method=RequestMethod.POST)
	public String chooseClass(@PathVariable("classId") int classId, Integer studentId, HttpServletResponse response){

		  return "/class/34/student/2757";
	}


	/**
	 * 学生按ID取消选择班级
	 * @param classId
	 * @param studentId
	 */
	@RequestMapping(value="/{classId}/student/{studentId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void chooseClass(@PathVariable("classId") int classId, @PathVariable("studentId") int studentId){
	}
	
	/**
	 * 按ID获取自身所在班级小组
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="/{classId}/classgroup", method=RequestMethod.GET)
	public ClassGroupVo getGroupByClassId(@PathVariable("classId") int classId){

		return new ClassGroupVo();
	}
		
	/**
	 * 班级小组组长辞职
	 * @param classId
	 * @param student
	 */
	@RequestMapping(value="/{classId}/classgroup/resign", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void resign(@PathVariable("classId") int classId, @RequestBody User student){
	}
	
	 /**
	  * 成为班级小组组长
	  * @param classId
	  * @param student
	  */
    @RequestMapping(value="/{classId}/classgroup/assign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void assign(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    /**
     * 添加班级小组成员
     * @param classId
     * @param student
     */
    @RequestMapping(value="/{classId}/classgroup/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    /**
     * 移除班级小组成员
     * @param classId
     * @param student
     */
    @RequestMapping(value="/{classId}/classgroup/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("classId") int classId, @RequestBody User student){
    }
}
