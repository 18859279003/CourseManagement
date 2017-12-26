package xmu.crms.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.entity.User;
import xmu.crms.serviceImpl.TopicServiceImpl;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private TopicServiceImpl topicServiceImpl;
    
	//按ID获取小组详情，传入小组id，返回小组对象
    //是否包含小组选择的话题、是否包含小组的成绩
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET)
	public SeminarGroupTopic getTopicById(@PathVariable("groupId") int groupId, boolean embedTopics, boolean embedGrade){

		return new SeminarGroupTopic();
	}

	 //组长辞职
    @RequestMapping(value="/{groupId}/resign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void resign(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
     //成为组长
    @RequestMapping(value="/{groupId}/assign", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void assign(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    //添加成员
    @RequestMapping(value="/{groupId}/add", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void add(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    //移除成员
    @RequestMapping(value="/{groupId}/remove", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void remvoe(@PathVariable("classId") int classId, @RequestBody User student){
    }
    
    //TODO
    //小组按ID选择话题
    @RequestMapping(value="/{groupId}/topic", method=RequestMethod.POST)
    public String chooseTopic(@PathVariable("groupId") int groupId, int topicId){
        
        return "/group/27/topic/23";
    }
    
    //小组按ID取消选择话题
    @RequestMapping(value="/{groupId}/topic/{topicId}", method=RequestMethod.DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void cancelTopic(@PathVariable("groupId") int groupId, @PathVariable("topicId") int  topicId){
        topicServiceImpl.deleteSeminarGroupTopicById(new BigInteger(((Integer)groupId).toString()), new BigInteger(((Integer)topicId).toString()));
    }
/*
	//按ID获取小组的讨论课成绩
	@RequestMapping(value="/{groupId}/grade", method=RequestMethod.GET)
	public SeminarGrade getGradeByGroupId(@PathParam("groupId") Integer groupId){
		PresentationGrade presentationGrades[]=new PresentationGrade[1];
		presentationGrades[0]=new PresentationGrade(257,4);
		return new SeminarGrade( presentationGrades, 3, 4);		
	}
*/	
	//按ID设置小组的报告分
	@RequestMapping(value="/{groupId}/grade/report", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void gradeByGroupId(@PathVariable("groupId") int groupId, String reportGrade){//TODO
	}
	
	//提交对其他小组的打分是小程序端的
}
