package xmu.crms.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.FixGroup;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.SeminarGroupService;
import xmu.crms.serviceimpl.FixGroupServiceImpl;
import xmu.crms.serviceimpl.GradeServiceImpl;
import xmu.crms.serviceimpl.SeminarGroupImpl;
import xmu.crms.serviceimpl.TopicServiceImpl;
import xmu.crms.vo.ClassGroupVo;

@RestController
@RequestMapping("/group")
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class GroupController {
    @Autowired
    private TopicServiceImpl topicServiceImpl;
    
    @Autowired 
    private GradeServiceImpl gradeServiceImpl;
    
    @Autowired
    private SeminarGroupImpl seminarGroupServiceImpl;
    
    @Autowired
    private FixGroupServiceImpl fixGroupServiceImpl;
	/**
	 * 按ID获取小组详情，传入小组id，返回小组对象
	 * @param groupId
	 * @return
	 * @throws GroupNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET)
	public SeminarGroup getGroupById(@PathVariable("groupId") int groupId) throws IllegalArgumentException, GroupNotFoundException{
	    return seminarGroupServiceImpl.getSeminarGroupByGroupId(new BigInteger(((Integer)groupId).toString()));
	}

	@RequestMapping(value="/fixgroup/{groupId}", method=RequestMethod.GET)
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
	  * 组长辞职
	  * @param classId
	  * @param student
	  */
    @RequestMapping(value="/{groupId}/resign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void resign(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
     /**
      * 成为组长
      * @param classId
      * @param student
      */
    @RequestMapping(value="/{groupId}/assign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void assign(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    /**
     * 添加成员
     * @param classId
     * @param student
     */
    @RequestMapping(value="/{groupId}/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    /**
     * 移除成员
     * @param classId
     * @param student
     */
    @RequestMapping(value="/{groupId}/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remvoe(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    /**
     * 小组按ID选择话题
     * @param groupId
     * @param topicId
     * @return
     * @throws GroupNotFoundException 
     * @throws IllegalArgumentException 
     */
    @RequestMapping(value="/{groupId}/topic", method=RequestMethod.POST)
    public int chooseTopic(@PathVariable("groupId") int groupId, int topicId) throws IllegalArgumentException, GroupNotFoundException{
        
        return seminarGroupServiceImpl.insertTopicByGroupId(new BigInteger(((Integer)groupId).toString()), new BigInteger(((Integer)topicId).toString())).intValue();
    }
    
    /**
     * 取消选择话题
     * @param groupId
     * @param topicId
     */
    @RequestMapping(value="/{groupId}/topic/{topicId}", method=RequestMethod.DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void cancelTopic(@PathVariable("groupId") int groupId, @PathVariable("topicId") int  topicId){
        topicServiceImpl.deleteSeminarGroupTopicById(new BigInteger(((Integer)groupId).toString()), new BigInteger(((Integer)topicId).toString()));
    }

	/**
	 * 按ID获取小组的讨论课成绩
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value="/{groupId}/grade", method=RequestMethod.GET)
	public SeminarGroupTopic getGradeByGroupId(@PathVariable("groupId") Integer groupId){
		
		return null;		
	}
	
	/**
	 * 按ID设置小组的报告分
	 * @param groupId
	 * @param reportGrade
	 */
	@RequestMapping(value="/{groupId}/grade/report", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void gradeByGroupId(@PathVariable("groupId") int groupId, int reportGrade) throws IllegalArgumentException, GroupNotFoundException{
        gradeServiceImpl.updateGroupByGroupId(new BigInteger(((Integer)groupId).toString()), new BigInteger(((Integer)reportGrade).toString()));
    }
}
