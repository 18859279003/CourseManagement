package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

/**
 * Created by zhangzhaoyang on 2017/12/19.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicMapperTest {
	@Autowired
    private TopicMapper topicMapper;
	private static Log log = LogFactory.getLog(TopicMapperTest.class);
	@Test
public	void getTopicByTopicIdTest()throws  Exception
	{
		Topic topic1= topicMapper.getTopicByTopicId(new BigInteger("1"));
		log.info(topic1);
	}
	
	@Test
	public	void updateTopicByTopicIdTest()throws  Exception	
	{
		Topic topic=new Topic();
		topicMapper.updateTopicByTopicId(new BigInteger("2"), topic);
		log.info(topic);
	}
	
	@Test
	public	void deleteTopicByTopicIdTest()throws  Exception
		{
			topicMapper.deleteTopicByTopicId(new BigInteger("6"));
		}
	@Test
	public	void listTopicBySeminarIdTest()throws  Exception
		{
			List<Topic> topics=topicMapper.listTopicBySeminarId(new BigInteger("1"));
			log.info(topics);
		}
	@Test
	public	void insertTopicBySeminarIdTest()throws  Exception
		{
		    Topic topic=new Topic();
		    topic.setSerial("A");
		    topic.setName("123");
		    topic.setDescription("123");
		    topic.setGroupNumberLimit(new Integer("1"));
		    topic.setGroupStudentLimit(new Integer("1"));
		    
		    System.out.println("****************"+topicMapper.insertTopicBySeminarId(new BigInteger("3"), topic));
		}	
	@Test
	public	void deleteSeminarGroupTopicByIdTest()throws  Exception
		{
		    topicMapper.deleteSeminarGroupTopicById(new BigInteger("1"),new BigInteger("1"));
		}	
	@Test
	public	void deleteSeminarGroupTopicByTopicIdTest()throws  Exception
		{
		    topicMapper.deleteSeminarGroupTopicByTopicId(new BigInteger("1"));
		}
	@Test
	public	void getSeminarGroupTopicByIdTest()throws  Exception
		{
		   log.info(topicMapper.getSeminarGroupTopicById(new SeminarGroupTopic() ));
		}
	@Test
	public	void getSeminarGroupTopiclistByGroupIdTest()throws  Exception
		{
		  log.info(topicMapper.getSeminarGroupTopiclistByGroupId(new BigInteger("33")));
		}
}
