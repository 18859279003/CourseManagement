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
import xmu.crms.entity.FixGroup;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.FixGroupService;
import xmu.crms.serviceimpl.ClassServiceImpl;
import xmu.crms.serviceimpl.CourseServiceImpl;
import xmu.crms.serviceimpl.FixGroupServiceImpl;
import xmu.crms.serviceimpl.UserServiceImpl;
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
	
	@Autowired 
	private CourseServiceImpl courseServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private FixGroupServiceImpl fixGroupServiceImpl;
	/**
	 * 获取与当前用户相关联的或符合条件的班级列表
	 * @param courseName
	 * @param teacherName
	 * @return
	 * @throws CourseNotFoundException 
	 * @throws UserNotFoundException 
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<ClassInfo> getClassList(String courseName, String teacherName) throws CourseNotFoundException, UserNotFoundException, ClassesNotFoundException{
	    if(courseName==""&&teacherName=="")
	    {
	    	return classServiceImpl.listAllClass();
	    }
	    else
	    {
	        return classServiceImpl.listClassByName(courseName,teacherName);
	    }
	}

	/**
     * 根据学生Id获取与当前用户相关联的班级列表
     * @param studentId
     * @return
     * @throws UserNotFoundException
     * @throws IllegalArgumentException
     * @throws ClassesNotFoundException
     */
    @RequestMapping(value="/student/{studentId}", method=RequestMethod.GET)
    public List<ClassInfo> getClassListByStudentId(@PathVariable("studentId") int studentId) throws  UserNotFoundException, IllegalArgumentException, ClassesNotFoundException{
        List<ClassInfo> classlist = new ArrayList<ClassInfo>();
        classlist=classServiceImpl.listClassByUserId(new BigInteger(((Integer)studentId).toString()));
        return classlist;
    }
    
	/**
	 * 按ID获取班级，传入班级id，返回班级对象
	 * @param classId
	 * @return
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}", method=RequestMethod.GET)
	public ClassInfo getClassById(@PathVariable("classId") int classId) throws ClassesNotFoundException{
	    //System.out.println(classServiceImpl.getClassByClassId(new BigInteger(((Integer)classId).toString())));
		return classServiceImpl.getClassByClassId(new BigInteger(((Integer)classId).toString()));
	}
	
	
	/**
	 * 按ID修改班级，传入班级id和json
	 * @param classId
	 * @param clas
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
	 * @throws UserNotFoundException 
	 * @throws ClassesNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{classId}/student", method=RequestMethod.GET)
	public List<User> getStudentList(@PathVariable("classId") int classId, String numBeginWith, String nameBeginWith) throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException{
		
		return userServiceImpl.listUserByClassId(new BigInteger(((Integer)classId).toString()), numBeginWith, nameBeginWith);
	}
	
	/**
	 * 学生按ID选择班级
	 * TODO
	 * @param classId
	 * @param studentId
	 * @param response
	 * @return
	 * @throws UserNotFoundException 
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}/student", method=RequestMethod.POST)
	public int chooseClass(@PathVariable("classId") int classId, Integer studentId, HttpServletResponse response) throws ClassesNotFoundException, UserNotFoundException{

		  return classServiceImpl.insertCourseSelectionById(new BigInteger(((Integer)studentId).toString()), new BigInteger(((Integer)classId).toString())).intValue();
	}


	/**
	 * 学生按ID取消选择班级
	 * @param classId
	 * @param studentId
	 * @throws UserNotFoundException 
	 * @throws ClassesNotFoundException 
	 */
	@RequestMapping(value="/{classId}/student/{studentId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void chooseClass(@PathVariable("classId") int classId, @PathVariable("studentId") int studentId) throws ClassesNotFoundException, UserNotFoundException{
	    classServiceImpl.deleteCourseSelectionById(new BigInteger(((Integer)studentId).toString()), new BigInteger(((Integer)classId).toString()));
	}
	
	/**
     * 按ID获取自身所在班级小组
     * @param classId
     * @return
     * @throws UserNotFoundException 
     * @throws ClassesNotFoundException 
     * @throws IllegalArgumentException 
     * @throws FixGroupNotFoundException 
     */
    @RequestMapping(value="/{classId}/classgroup", method=RequestMethod.GET)
    public ClassGroupVo getGroupByClassId(@PathVariable("classId") int classId,int studentId) throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException, FixGroupNotFoundException{
        FixGroup group=fixGroupServiceImpl.getFixedGroupById(new BigInteger(((Integer)studentId).toString()),new BigInteger(((Integer)classId).toString()));
        ClassGroupVo vo = new ClassGroupVo();
        vo.setId(group.getId());
        vo.setLeader(group.getLeader());
        List<User> members=fixGroupServiceImpl.listFixGroupMemberByGroupId(group.getId());
        User[] users = (User[])members.toArray(new User[members.size()]);
        vo.setMembers(users);
        return vo;
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
     * @throws InvalidOperationException 
     * @throws UserNotFoundException 
     * @throws FixGroupNotFoundException 
     * @throws IllegalArgumentException 
     */
    @RequestMapping(value="/{classId}/classgroup/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathVariable("classId") int classId, int studentId,int groupId) throws IllegalArgumentException, FixGroupNotFoundException, UserNotFoundException, InvalidOperationException{
        fixGroupServiceImpl.insertStudentIntoGroup(new BigInteger(((Integer)studentId).toString()), new BigInteger(((Integer)groupId).toString()));
        
    }
    
    /**
     * 移除班级小组成员
     * @param classId
     * @param student
     * @throws UserNotFoundException 
     * @throws FixGroupNotFoundException 
     * @throws IllegalArgumentException 
     */
    @RequestMapping(value="/{classId}/classgroup/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("classId") int classId, int studentId,int groupId) throws IllegalArgumentException, FixGroupNotFoundException, UserNotFoundException{
        fixGroupServiceImpl.deleteFixGroupUserById(new BigInteger(((Integer)groupId).toString()), new BigInteger(((Integer)studentId).toString()));
        
    }
}
