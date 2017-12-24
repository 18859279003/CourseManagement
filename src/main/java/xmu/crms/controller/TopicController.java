package xmu.crms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.model.Group;
import xmu.crms.serviceImpl.TopicServiceImpl;

@RestController
@RequestMapping("/topic")
public class TopicController {

	//按ID获取话题，传入话题id，返回话题对象
	@RequestMapping(value="/{topicId}", method=RequestMethod.GET)
	public xmu.crms.entity.Topic getTopicById(@PathParam("topicId") BigInteger topicId) throws IllegalArgumentException, TopicNotFoundException{
		//Topic topic=new Topic(257,"A","领域模型与模块","Domain model与模块划分",5,6,2);
		TopicServiceImpl topicServiceImpl = new TopicServiceImpl();
		return topicServiceImpl.getTopicByTopicId(topicId);
	}

	//按ID修改话题，传入话题id和json
	@RequestMapping(value="/{topicId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateTopicById(@PathParam("topicId") BigInteger topicId, @RequestBody xmu.crms.entity.Topic topic) throws IllegalArgumentException, TopicNotFoundException{
		TopicServiceImpl topicServiceImpl = new TopicServiceImpl();
		topicServiceImpl.updateTopicByTopicId(topicId, topic);
	}
	
	//按ID删除话题，传入话题id
	@RequestMapping(value="/{topicId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteTopicById(@PathParam("topicId") Integer topicId){
	}
	
	//按话题ID获取选择了该话题的小组
	@RequestMapping(value="/{topicId}/group", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<Group> getGroupListByTopicId(@PathParam("topicId") Integer topicId){
		List<Group> groupList=new ArrayList<Group>();
		groupList.add(new Group(23,"1A1", null, null, null, null, null));
		groupList.add(new Group(26, "2A2", null, null, null, null, null));
		return groupList;
	}
}
