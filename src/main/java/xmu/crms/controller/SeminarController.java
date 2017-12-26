package xmu.crms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.Topic;
import xmu.crms.VO.GroupVO;
import xmu.crms.VO.SeminarVO;
import xmu.crms.VO.SeminarDetailVO;
import xmu.crms.VO.StudentSeminarVO;

@RestController
@RequestMapping("/seminar")
public class SeminarController {

	//按ID获取讨论课，传入讨论课id，返回讨论课对象
	@RequestMapping(value="/{seminarId}", method=RequestMethod.GET)
	public SeminarVO getSeminarById(@PathParam("seminarId") Integer seminarId){
		return new SeminarVO();
	}
	
	//按ID修改讨论课，传入讨论课id和json
	@RequestMapping(value="/{seminarId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateSeminarById(@PathParam("seminarId") Integer seminarId, @RequestBody SeminarVO seminar){
	}
	
	//按ID删除讨论课，传入讨论课id
	@RequestMapping(value="/{seminarId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteSeminarById(@PathParam("seminarId") Integer seminarId){
	}
	
	//按ID获取与学生有关的讨论课信息
	@RequestMapping(value="/{seminarId}/my", method=RequestMethod.GET)
    public StudentSeminarVO getStudentSeminarById(@PathParam("seminarId") Integer seminarId){
	    StudentSeminarVO seminar=new StudentSeminarVO(32,"概要设计","random","OOAD","2017-10-11","2017-10-24",23,true,true);//假的
        return seminar;
    }	
	
	 //按ID获取讨论课详情
    @RequestMapping(value="/{seminarId}/detail", method=RequestMethod.GET)
    public SeminarDetailVO getSeminarDetailById(@PathParam("seminarId") Integer seminarId){
        SeminarDetailVO seminar=new SeminarDetailVO(32,"概要设计","2017-10-10","2017-10-24","海韵201","邱明","mingqiu@xmu.edu.cn");//假的
        return seminar;
    }   
    
	//按ID获取讨论课的话题
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.GET)
	public List<Topic> getTopicList(@PathParam("seminarId") Integer seminarId){
		List<Topic> topiclist=new ArrayList<Topic>();//假的
		return topiclist;
	}
	
	//在指定ID的讨论课创建话题
	@RequestMapping(value="/{seminarId}/topic", method=RequestMethod.POST)
	public int createTopic(@PathParam("seminarId") Integer seminarId, @RequestBody Topic topic, HttpServletResponse response){	
		response.setStatus(201);
		return topic.getId().intValue();
	}
	
	//按讨论课ID查找小组
	//可选参数Boolean gradeable可打分的、int classId此班级的
	@RequestMapping(value="/{seminarId}/group", method=RequestMethod.GET)
	public List<GroupVO> getGroupListBySeminarId(
			@PathParam("seminarId") Integer seminarId, boolean gradeable, int classId){	
		List<GroupVO> groupList=new ArrayList<GroupVO>();
		return groupList;
	}
	
	//接下来的应该都是小程序的。。。
}
