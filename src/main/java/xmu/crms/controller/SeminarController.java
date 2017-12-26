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

import xmu.crms.entity.Topic;
import xmu.crms.serviceimpl.TopicServiceImpl;
import xmu.crms.vo.GroupVo;
import xmu.crms.vo.SeminarVo;
import xmu.crms.vo.SeminarDetailVo;
import xmu.crms.vo.StudentSeminarVo;

@RestController
@RequestMapping("/seminar")
public class SeminarController {

    @Autowired
    private TopicServiceImpl topicServiceImpl;
	//按ID获取讨论课，传入讨论课id，返回讨论课对象
	@RequestMapping(value="/{seminarId}", method=RequestMethod.GET)
	public SeminarVo getSeminarById(@PathVariable("seminarId") int seminarId){
		return new SeminarVo();
	}
	
	//按ID修改讨论课，传入讨论课id和json
	@RequestMapping(value="/{seminarId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateSeminarById(@PathVariable("seminarId") int seminarId, @RequestBody SeminarVo seminar){
	}
	
	//按ID删除讨论课，传入讨论课id
	@RequestMapping(value="/{seminarId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteSeminarById(@PathVariable("seminarId") int seminarId){
	}
	
	//按ID获取与学生有关的讨论课信息
	@RequestMapping(value="/{seminarId}/my", method=RequestMethod.GET)
    public StudentSeminarVo getStudentSeminarById(@PathVariable("seminarId") int seminarId){
	    StudentSeminarVo seminar=new StudentSeminarVo(32,"概要设计","random","OOAD","2017-10-11","2017-10-24",23,true,true);//假的
        return seminar;
    }	
	
	 //按ID获取讨论课详情
    @RequestMapping(value="/{seminarId}/detail", method=RequestMethod.GET)
    public SeminarDetailVo getSeminarDetailById(@PathVariable("seminarId") int seminarId){
        SeminarDetailVo seminar=new SeminarDetailVo(32,"概要设计","2017-10-10","2017-10-24","海韵201","邱明","mingqiu@xmu.edu.cn");//假的
        return seminar;
    }   
    
	//按ID获取讨论课的话题
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.GET)
	public List<Topic> getTopicList(@PathVariable("seminarId") int seminarId){
		return topicServiceImpl.listTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()));
	}
	
	//在指定ID的讨论课创建话题
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.POST)
	public int createTopic(@PathVariable("seminarId") int seminarId, @RequestBody Topic topic, HttpServletResponse response){	
	    System.out.println(seminarId);
	    System.out.println(topic);
		response.setStatus(201);
		return topicServiceImpl.insertTopicBySeminarId(new BigInteger(((Integer)seminarId).toString()), topic).intValue();
	}
	
	//按讨论课ID查找小组
	//可选参数Boolean gradeable可打分的、int classId此班级的
	@RequestMapping(value="/{seminarId}/group", method=RequestMethod.GET)
	public List<GroupVo> getGroupListBySeminarId(
	        @PathVariable("seminarId") int seminarId, boolean gradeable, int classId){	
		List<GroupVo> groupList=new ArrayList<GroupVo>();
		return groupList;
	}
	
	//接下来的应该都是小程序的。。。
}
