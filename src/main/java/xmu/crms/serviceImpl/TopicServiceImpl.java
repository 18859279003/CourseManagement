package xmu.crms.serviceImpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.mapper.TopicMapper;
import xmu.crms.service.TopicService;

/**
* @author zhangzhaoyang
* @date 2017/12/22
*/
@Service
public class TopicServiceImpl implements TopicService
{
	@Autowired
	private TopicMapper topicMapper;
	@Override
	public Topic getTopicByTopicId(BigInteger topicId) throws TopicNotFoundException, IllegalArgumentException {
		return topicMapper.getTopicByTopicId(topicId);
	}

	@Override
	public void updateTopicByTopicId(BigInteger topicId, Topic topic)
			throws TopicNotFoundException, IllegalArgumentException {
		topicMapper.updateTopicByTopicId(topicId, topic);
		
	}

	@Override
	public void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
		topicMapper.deleteTopicByTopicId(topicId);
	}

	@Override
	public List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
		
		return topicMapper.listTopicBySeminarId(seminarId);
	}

	@Override
	public BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException {
		topicMapper.insertTopicBySeminarId(seminarId, topic);
		return topic.getId();
	}

	@Override
	public void deleteSeminarGroupTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {
		topicMapper.deleteSeminarGroupTopicById(groupId, topicId);
		
	}

	@Override
	public void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
		topicMapper.deleteSeminarGroupTopicByTopicId(topicId);
		
	}

	@Override
	public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
