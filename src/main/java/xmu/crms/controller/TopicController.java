package xmu.crms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.VO.GroupVO;
import xmu.crms.serviceImpl.TopicServiceImpl;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private TopicServiceImpl topicServiceImpl;
	//按ID获取话题，传入话题id，返回话题对象
	@RequestMapping(value="/{topicId}", method=RequestMethod.GET)
	public Topic getTopicById(@PathVariable("topicId") int topicId) throws IllegalArgumentException, TopicNotFoundException{
	    System.out.print(topicId);
		return topicServiceImpl.getTopicByTopicId(new BigInteger(((Integer)topicId).toString()));
	}

	//按ID修改话题，传入话题id和json
	@RequestMapping(value="/{topicId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateTopicById(@PathVariable("topicId") int topicId, @RequestBody Topic topic) throws IllegalArgumentException, TopicNotFoundException{
		System.out.println(topic);
	    topicServiceImpl.updateTopicByTopicId(new BigInteger(((Integer)topicId).toString()), topic);
	}
	
	//按ID删除话题，传入话题id
	@RequestMapping(value="/{topicId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteTopicById(@PathVariable("topicId") int topicId) throws IllegalArgumentException, TopicNotFoundException{
		topicServiceImpl.deleteTopicByTopicId(new BigInteger(((Integer)topicId).toString()));
	}
	
	//按话题ID获取选择了该话题的小组
	@RequestMapping(value="/{topicId}/group", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<GroupVO> getGroupListByTopicId(@PathVariable("topicId") int topicId){
		List<GroupVO> groupList=new ArrayList<GroupVO>();
		return groupList;
	}
}
