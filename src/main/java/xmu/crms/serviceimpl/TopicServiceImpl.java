package xmu.crms.serviceimpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.mapper.TopicMapper;
import xmu.crms.service.GradeService;
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
		 if(topicId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
		Topic topic = topicMapper.getTopicByTopicId(topicId);
		if(topic==null)
		{
			throw new TopicNotFoundException();
		}
		return topic;
	}

	@Override
	public void updateTopicByTopicId(BigInteger topicId, Topic topic)throws TopicNotFoundException, IllegalArgumentException {
		 if(topicId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
		Integer num=topicMapper.updateTopicByTopicId(topicId, topic);
		if(num==null)
		{
			throw new TopicNotFoundException();
		}
		
	}

	@Override
	public void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException, TopicNotFoundException {
		 if(topicId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
		Integer num=topicMapper.deleteTopicByTopicId(topicId);
		if(num==null)
		{
			throw new TopicNotFoundException();
		}
	}

	@Override
	public List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
		 if(seminarId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
		return topicMapper.listTopicBySeminarId(seminarId);
	}

	@Override
	public BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException {
		 if(seminarId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
		Integer num=topicMapper.insertTopicBySeminarId(seminarId, topic);
		if(num<=0)
		{
			return new BigInteger("-1");
		}
		else
		{
			return new BigInteger(num.toString());
		}
			
	}

	@Override
	public void deleteSeminarGroupTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {
		if(groupId.intValue()<=0||topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
		topicMapper.deleteSeminarGroupTopicById(groupId, topicId);
	}

	@Override
	public void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
		if(topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
		topicMapper.deleteSeminarGroupTopicByTopicId(topicId);
		
	}

	@Override
	public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId)
			throws IllegalArgumentException {
		if(groupId.intValue()<=0||topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
		SeminarGroupTopic seminarGroupTopic=new SeminarGroupTopic();
        SeminarGroup seminarGroup=new SeminarGroup();
        seminarGroup.setId(groupId);
        Topic topic=new Topic();
        topic.setId(topicId);
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
		return topicMapper.getSeminarGroupTopicById(seminarGroupTopic);
	}

	@Override
	public void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
		if(seminarId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
		List<Topic> topics=topicMapper.listTopicBySeminarId(seminarId);
		for(int i=0;i<topics.size();i++)
		{
			topicMapper.deleteSeminarGroupTopicByTopicId(topics.get(i).getId());
			//GradeService   #deleteStudentScoreGroupByTopicId(BigInteger seminarGroupTopicId)
		}
		
	}

	@Override
	public List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId) throws IllegalArgumentException {
		if(groupId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
		List<SeminarGroupTopic> seminarGroupTopiclist=topicMapper.getSeminarGroupTopiclistByGroupId(groupId);
		return seminarGroupTopiclist ;
	}

}
